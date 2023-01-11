package app;

import app.product.Manufacture;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

public class Menu {
    private Manufacture[] manufactures;

    public Menu(Manufacture[] manufactures) {
        this.manufactures = manufactures;
    }

    public void printMenu() {
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(60));

        printHamburgers(true);
        printSides(true);
        printDrinks(true);

        System.out.println();
        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(60));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }

    protected void printDrinks(boolean printValue) {
        System.out.println("🥤 음료");
        for (Manufacture manufacture : manufactures) {
            if (manufacture instanceof Drink) {
                printEachMenu(manufacture, printValue);
            }
        }
        System.out.println();
    }

    protected void printSides(boolean printValue) {
        System.out.println("🍟 사이드");
        for (Manufacture manufact : manufactures) {
            if (manufact instanceof Side) {
                printEachMenu(manufact, printValue);
            }
        }
        System.out.println();
    }

    private void printHamburgers(boolean printValue) {
        System.out.println("🍔 햄버거");
        for (Manufacture manufact : manufactures) {
            if(manufact instanceof Hamburger) {
                printEachMenu(manufact, printValue);
            }
        }
    }

    private static void printEachMenu(Manufacture manufact, boolean printValue) {
        if(printValue) {
            System.out.printf(
                    "   (%d) %s %5dKcal %5d원\n",
                    manufact.getNumber(), manufact.getName(), manufact.getKcal(), manufact.getValue()
            );
        }
        else System.out.printf("   (%d) %s %5dKcal\n", manufact.getNumber(), manufact.getName(), manufact.getKcal());
    }
}

