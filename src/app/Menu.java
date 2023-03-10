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
        System.out.println("[๐ป] ๋ฉ๋ด");
        System.out.println("-".repeat(60));

        printHamburgers(true);
        printSides(true);
        printDrinks(true);

        System.out.println();
        System.out.println("๐งบ (0) ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("๐ฆ (+) ์ฃผ๋ฌธํ๊ธฐ");
        System.out.println("-".repeat(60));
        System.out.print("[๐ฃ] ๋ฉ๋ด๋ฅผ ์ ํํด์ฃผ์ธ์ : ");
    }

    protected void printDrinks(boolean printValue) {
        System.out.println("๐ฅค ์๋ฃ");
        for (Manufacture manufacture : manufactures) {
            if (manufacture instanceof Drink) {
                printEachMenu(manufacture, printValue);
            }
        }
        System.out.println();
    }

    protected void printSides(boolean printValue) {
        System.out.println("๐ ์ฌ์ด๋");
        for (Manufacture manufact : manufactures) {
            if (manufact instanceof Side) {
                printEachMenu(manufact, printValue);
            }
        }
        System.out.println();
    }

    private void printHamburgers(boolean printValue) {
        System.out.println("๐ ํ๋ฒ๊ฑฐ");
        for (Manufacture manufact : manufactures) {
            if(manufact instanceof Hamburger) {
                printEachMenu(manufact, printValue);
            }
        }
    }

    private static void printEachMenu(Manufacture manufact, boolean printValue) {
        if(printValue) {
            System.out.printf(
                    "   (%d) %s %5dKcal %5d์\n",
                    manufact.getNumber(), manufact.getName(), manufact.getKcal(), manufact.getValue()
            );
        }
        else System.out.printf("   (%d) %s %5dKcal\n", manufact.getNumber(), manufact.getName(), manufact.getKcal());
    }
}

