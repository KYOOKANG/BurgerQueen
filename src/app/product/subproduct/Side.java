package app.product.subproduct;
import app.product.Manufacture;

public class Side extends Manufacture {

    private int tomato_sauce;

    public Side(String name, int number, int kcal, int value, int tomato_sauce) {
        super(name, number, kcal, value);
        this.tomato_sauce = tomato_sauce;
    }

    public Side(Side side) {
        super(side.getName(), side.getKcal(), side.getValue());
        this.tomato_sauce = side.getTomato_sauce();
    }

    public int getTomato_sauce() {
        return tomato_sauce;
    }

    public void setTomato_sauce(int tomato_sauce) {
        this.tomato_sauce = tomato_sauce;
    }
}
