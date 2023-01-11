package app;

import app.Reduction.Reduction;
import app.Reduction.reductionPolicy.FastenedHalfReductionPolicy;
import app.Reduction.reductionPolicy.FastenedPercentageReductionPolicy;
import app.Reduction.reductionPolicy.FastenedSumReductionPolicy;
import app.Reduction.reductionRequirement.CozReductionRequirement;
import app.Reduction.reductionRequirement.HungryReductionRequirement;
import app.Reduction.reductionRequirement.KidReductionRequirement;
import app.Reduction.reductionRequirement.ReductionRequirement;
import app.product.Manufacture;
import app.product.ManufactureRepository;

import java.util.Scanner;

public class OrderProgram {
    private ManufactureRepository manufactureRepository;
    private Menu menu;
    private Basket basket;
    private Order order;

    public OrderProgram(ManufactureRepository manufactureRepository, Menu menu, Basket basket, Order order) {
        this.manufactureRepository = manufactureRepository;
        this.menu = menu;
        this.basket = basket;
        this.order = order;
    }

    public void start() {


//        ManufactureRepository manufactureRepository = new ManufactureRepository();
//        Menu menu = new Menu(manufactures);
//        Basket basket = new Basket(manufactureRepository, menu);
//        Manufacture[] manufactures = manufactureRepository.getAllManufactures();
//        Order order = new Order(basket, new Reduction(new ReductionRequirement[]{
//                new CozReductionRequirement(new FastenedPercentageReductionPolicy(10)),
//                new KidReductionRequirement(new FastenedSumReductionPolicy(500)),
//                new HungryReductionRequirement(new FastenedHalfReductionPolicy(50))
//        }));

//        Order order = new Order(basket);
//        Order order = new Order(basket,new ReductionRequirement[]{
//                new CozReductionRequirement(new FastenedPercentageReductionPolicy(10)),
//                new KidReductionRequirement(new FastenedSumReductionPolicy(500)),
//                new HungryReductionRequirement(new FastenedHalfReductionPolicy(50))
//        };

        Scanner scan = new Scanner(System.in);
        System.out.println("🍔 BurgerQueen Order Service");

        while (true) {
            menu.printMenu();
            String select = scan.nextLine();

            if (select.equals("+")) {
                order.playOrder();
                break;
            }
            else {
                int menuNumber = Integer.parseInt(select);

                if (menuNumber == 0) basket.printBasket();
                else if (1 <= menuNumber && menuNumber <= manufactureRepository.getAllManufactures().length) {
                    basket.plusToBasket(menuNumber);
                }
            }
        }
    }
}

