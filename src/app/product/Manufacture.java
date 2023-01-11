package app.product;

public class Manufacture {
    private String name;
    private int number;
    private int kcal;
    private int value;

    public Manufacture(String name, int number, int kcal, int value) {
        this.name = name;
        this.number = number;
        this.kcal = kcal;
        this.value = value;
    }

    public Manufacture(String name, int kcal, int value) {
        this.name = name;
        this.kcal = kcal;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
