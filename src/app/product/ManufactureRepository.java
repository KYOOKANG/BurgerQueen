package app.product;

import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

public class ManufactureRepository {
    private final Manufacture[] manufactures = {
            new Hamburger("새우버거", 1, 500,2500, false, 3500),
            new Hamburger("치킨버거", 2, 600,3000, false, 4000),
            new Side("감자튀김", 3, 300, 1000, 1),
            new Side("어니언링", 4, 300, 1200, 1),
            new Drink("코카콜라", 5, 250, 1000, true),
            new Drink("펩시콜라", 6, 220, 900, true)
    };

    public Manufacture[] getAllManufactures() {
        return manufactures;
    }

    public Manufacture FindByNumber(int manufactureNumber){
        for(Manufacture manufacture : manufactures) {
            if (manufacture.getNumber() == manufactureNumber) return manufacture;
            }
        return null;
    }
}

