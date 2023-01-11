package app.product.subproduct;
import app.product.Manufacture;

public class BurgerSet extends Manufacture {

    private Hamburger hamburger;
    private Side side;
    private Drink drink;

    public BurgerSet(String name, int kcal, int value, Hamburger hamburger, Side side, Drink drink) {
        super(name, kcal, value);
        this.hamburger = hamburger;
        this.side = side;
        this.drink = drink;
    }

    public Hamburger getHamburger() {
        return hamburger;
    }

    public Side getSide() {
        return side;
    }

    public Drink getDrink() {
        return drink;
    }
}
