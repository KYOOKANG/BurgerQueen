package app;

public class Main {
    public static void main(String[] args) {
        AppSystem appSystem = new AppSystem();

        OrderProgram orderProgram = new OrderProgram(
                appSystem.manufactureRepository(),
                appSystem.menu(),
                appSystem.basket(),
                appSystem.order()
        );

        orderProgram.start();
    }
}