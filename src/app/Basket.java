package app;

import app.product.Manufacture;
import app.product.ManufactureRepository;
import app.product.subproduct.BurgerSet;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

import java.util.Scanner;

public class Basket {
    private Manufacture[] goods = new Manufacture[0];
    private ManufactureRepository manufactureRepository;
    private Menu menu;

    public Basket(ManufactureRepository manufactureRepository, Menu menu) {
        this.manufactureRepository = manufactureRepository;
        this.menu = menu;
    }

    Scanner scan = new Scanner(System.in);

    public void printBasket() {
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(60));

        printBasketGoodsDetails();

        System.out.println("-".repeat(60));
        System.out.printf("합계 : %d원\n", calculateTotalValue());

        System.out.println("이전으로 돌아가려면 엔터를 누르세요. ");
        scan.nextLine();
    }

    protected void printBasketGoodsDetails() {
        for (Manufacture manufacture : goods) {
            if (manufacture instanceof BurgerSet) {
                BurgerSet burgerSet = (BurgerSet) manufacture;
                System.out.printf(
                        "  %s %6d원 (%s (케첩 %d개), %s (빨대 %s))\n",
                        manufacture.getName(),
                        manufacture.getValue(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getTomato_sauce(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().isHaveStraw()  ? "있음" : "없음"
                );
            }
            else if (manufacture instanceof Hamburger){
                System.out.printf(
                        "  %-8s %6d원 (단품)\n",
                        manufacture.getName(),
                        manufacture.getValue()
                );
            }
            else if (manufacture instanceof Side) {
                System.out.printf(
                        "  %-8s %6d원 (케첩 %d개)\n",
                        manufacture.getName(),
                        manufacture.getValue(),
                        ((Side) manufacture).getTomato_sauce()
                );
            } else if (manufacture instanceof Drink) {
                System.out.printf(
                        "  %-8s %6d원 (빨대 %s)\n",
                        manufacture.getName(),
                        manufacture.getValue(),
                        ((Drink) manufacture).isHaveStraw() ? "있음" : "없음"
                );
            }
        }
    }

    protected int calculateTotalValue() {
        int totalValue = 0;
        for (Manufacture manufacture : goods) {
            totalValue += manufacture.getValue();
        }
        return totalValue;
    }

    public void plusToBasket(int manufactureNumber){

        Manufacture manufacture = manufactureRepository.FindByNumber(manufactureNumber);

        chooseOption(manufacture);

        if(manufacture instanceof Hamburger) {
            Hamburger hamburger = (Hamburger) manufacture;
            if(hamburger.isSet()) manufacture = makeSet(hamburger);
        }

        Manufacture newManufacture;
        if (manufacture instanceof Hamburger) newManufacture = new Hamburger((Hamburger) manufacture);
        else if (manufacture instanceof Side) newManufacture = new Side((Side) manufacture);
        else if (manufacture instanceof Drink) newManufacture = new Drink((Drink) manufacture);
        else newManufacture = manufacture;

        Manufacture[] newGoods = new Manufacture[goods.length + 1];
        System.arraycopy(goods,0,newGoods,0, goods.length);
        newGoods[newGoods.length - 1] = newManufacture;
        goods = newGoods;

        System.out.printf("[📣] %s를(을) 장바구니에 담았습니다.", manufacture.getName());

    }

    private void chooseOption(Manufacture manufacture){
        String input;

        if (manufacture instanceof Hamburger) {
            System.out.printf(
                    "단품으로 주문하시겠어요? (1)_단품(%d원) (2)_세트(%d원)\n",
                    manufacture.getValue(),
                    ((Hamburger) manufacture).getSetPrice()
            );
            input = scan.nextLine();
            if(input.equals("2")) ((Hamburger)manufacture).setSet(true);
        }
        else if (manufacture instanceof Side) {
            System.out.println("케첩은 몇개가 필요하신가요?");
            input = scan.nextLine();
            ((Side)manufacture).setTomato_sauce((Integer.parseInt(input)));
        } else if (manufacture instanceof Drink) {
            System.out.println("빨대가 필요하신가요? (1)_예 (2)_아니오");
            input = scan.nextLine();
            if(input.equals("2")) ((Drink)manufacture).setHaveStraw(false);
        }
    }

    private BurgerSet makeSet(Hamburger hamburger) {
        System.out.println("사이드를 골라주세요");
        menu.printSides(false);

        String sideId = scan.nextLine();
        Side side = (Side) manufactureRepository.FindByNumber(Integer.parseInt(sideId));
        Side newSide = new Side(side);
        chooseOption(newSide);

        System.out.println("음료를 골라주세요.");
        menu.printDrinks(false);

        String drinkId = scan.nextLine();
        Drink drink = (Drink) manufactureRepository.FindByNumber(Integer.parseInt(drinkId));
        Drink newDrink = new Drink(drink);
        chooseOption(newDrink);

        String name = hamburger.getName() + "세트";
        int value = hamburger.getSetPrice();
        int kcal = hamburger.getKcal() + side.getKcal() + drink.getKcal();

        return new BurgerSet(name,kcal,value,hamburger,newSide,newDrink);
    }
}

