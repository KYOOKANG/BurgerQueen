package app.product.subproduct;
import app.product.Manufacture;

public class Drink extends Manufacture {

    private boolean haveStraw;

    public Drink(String name, int number, int kcal, int value, boolean haveStraw) {
        super(name, number, kcal, value);
        this.haveStraw = haveStraw;
    }

    public Drink(Drink drink) {
        super(drink.getName(), drink.getKcal(), drink.getValue());
        this.haveStraw = drink.isHaveStraw();
    }

    public boolean isHaveStraw() {
        return haveStraw;
    }

    public void setHaveStraw(boolean haveStraw) {
        this.haveStraw = haveStraw;
    }
}
