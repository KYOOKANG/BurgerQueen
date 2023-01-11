package app.product.subproduct;
import app.product.Manufacture;

public class Hamburger extends Manufacture {
    private boolean isSet;
    private int SetPrice;

    public Hamburger(String name, int number, int kcal, int value, boolean isSet, int setPrice) {
        super(name, number, kcal, value);
        this.isSet = isSet;
        this.SetPrice = setPrice;
    }


    public Hamburger(Hamburger hamburger) {
        super(hamburger.getName(), hamburger.getKcal(), hamburger.getValue());
        this.isSet = hamburger.isSet();
        this.SetPrice = hamburger.getSetPrice();
    }

    public boolean isSet() {
        return isSet;
    }

    public void setSet(boolean set) {
        isSet = set;
    }

    public int getSetPrice() {
        return SetPrice;
    }

    public void setSetPrice(int setPrice) {
        SetPrice = setPrice;
    }
}
