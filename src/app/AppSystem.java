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

public class AppSystem {

    Basket basket = new Basket(manufactureRepository(), menu());
    Menu menu = new Menu(manufactureRepository().getAllManufactures());

    ManufactureRepository manufactureRepository = new ManufactureRepository();
    public ManufactureRepository manufactureRepository() {
        return manufactureRepository;
    }

    public Menu menu(){
        return menu;
    }

    public Basket basket() {
        return basket;
    }

    public Reduction reduction() {
        return new Reduction(new ReductionRequirement[]{
                new CozReductionRequirement(new FastenedPercentageReductionPolicy(10)),
                new KidReductionRequirement(new FastenedSumReductionPolicy(500)),
                new HungryReductionRequirement(new FastenedHalfReductionPolicy(50))
        });
    }

    public Order order() {
        return new Order(basket(),reduction());
    }

//    ManufactureRepository manufactureRepository = new ManufactureRepository();
//    Menu menu = new Menu(manufactures);
//    Basket basket = new Basket(manufactureRepository, menu);
//
//    Order order = new Order(basket, new Reduction(new ReductionRequirement[]{
//            new CozReductionRequirement(new FastenedPercentageReductionPolicy(10)),
//            new KidReductionRequirement(new FastenedSumReductionPolicy(500)),
//            new HungryReductionRequirement(new FastenedHalfReductionPolicy(50))
//    }));
}
