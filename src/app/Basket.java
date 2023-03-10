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
        System.out.println("๐งบ ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("-".repeat(60));

        printBasketGoodsDetails();

        System.out.println("-".repeat(60));
        System.out.printf("ํฉ๊ณ : %d์\n", calculateTotalValue());

        System.out.println("์ด์ ์ผ๋ก ๋์๊ฐ๋ ค๋ฉด ์ํฐ๋ฅผ ๋๋ฅด์ธ์. ");
        scan.nextLine();
    }

    protected void printBasketGoodsDetails() {
        for (Manufacture manufacture : goods) {
            if (manufacture instanceof BurgerSet) {
                BurgerSet burgerSet = (BurgerSet) manufacture;
                System.out.printf(
                        "  %s %6d์ (%s (์ผ์ฒฉ %d๊ฐ), %s (๋นจ๋ %s))\n",
                        manufacture.getName(),
                        manufacture.getValue(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getTomato_sauce(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().isHaveStraw()  ? "์์" : "์์"
                );
            }
            else if (manufacture instanceof Hamburger){
                System.out.printf(
                        "  %-8s %6d์ (๋จํ)\n",
                        manufacture.getName(),
                        manufacture.getValue()
                );
            }
            else if (manufacture instanceof Side) {
                System.out.printf(
                        "  %-8s %6d์ (์ผ์ฒฉ %d๊ฐ)\n",
                        manufacture.getName(),
                        manufacture.getValue(),
                        ((Side) manufacture).getTomato_sauce()
                );
            } else if (manufacture instanceof Drink) {
                System.out.printf(
                        "  %-8s %6d์ (๋นจ๋ %s)\n",
                        manufacture.getName(),
                        manufacture.getValue(),
                        ((Drink) manufacture).isHaveStraw() ? "์์" : "์์"
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

        System.out.printf("[๐ฃ] %s๋ฅผ(์) ์ฅ๋ฐ๊ตฌ๋์ ๋ด์์ต๋๋ค.", manufacture.getName());

    }

    private void chooseOption(Manufacture manufacture){
        String input;

        if (manufacture instanceof Hamburger) {
            System.out.printf(
                    "๋จํ์ผ๋ก ์ฃผ๋ฌธํ์๊ฒ ์ด์? (1)_๋จํ(%d์) (2)_์ธํธ(%d์)\n",
                    manufacture.getValue(),
                    ((Hamburger) manufacture).getSetPrice()
            );
            input = scan.nextLine();
            if(input.equals("2")) ((Hamburger)manufacture).setSet(true);
        }
        else if (manufacture instanceof Side) {
            System.out.println("์ผ์ฒฉ์ ๋ช๊ฐ๊ฐ ํ์ํ์ ๊ฐ์?");
            input = scan.nextLine();
            ((Side)manufacture).setTomato_sauce((Integer.parseInt(input)));
        } else if (manufacture instanceof Drink) {
            System.out.println("๋นจ๋๊ฐ ํ์ํ์ ๊ฐ์? (1)_์ (2)_์๋์ค");
            input = scan.nextLine();
            if(input.equals("2")) ((Drink)manufacture).setHaveStraw(false);
        }
    }

    private BurgerSet makeSet(Hamburger hamburger) {
        System.out.println("์ฌ์ด๋๋ฅผ ๊ณจ๋ผ์ฃผ์ธ์");
        menu.printSides(false);

        String sideId = scan.nextLine();
        Side side = (Side) manufactureRepository.FindByNumber(Integer.parseInt(sideId));
        Side newSide = new Side(side);
        chooseOption(newSide);

        System.out.println("์๋ฃ๋ฅผ ๊ณจ๋ผ์ฃผ์ธ์.");
        menu.printDrinks(false);

        String drinkId = scan.nextLine();
        Drink drink = (Drink) manufactureRepository.FindByNumber(Integer.parseInt(drinkId));
        Drink newDrink = new Drink(drink);
        chooseOption(newDrink);

        String name = hamburger.getName() + "์ธํธ";
        int value = hamburger.getSetPrice();
        int kcal = hamburger.getKcal() + side.getKcal() + drink.getKcal();

        return new BurgerSet(name,kcal,value,hamburger,newSide,newDrink);
    }
}

