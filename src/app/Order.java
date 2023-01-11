package app;

import app.Reduction.Reduction;
import app.Reduction.reductionPolicy.FastenedHalfReductionPolicy;
import app.Reduction.reductionPolicy.FastenedPercentageReductionPolicy;
import app.Reduction.reductionPolicy.FastenedSumReductionPolicy;
import app.Reduction.reductionRequirement.CozReductionRequirement;
import app.Reduction.reductionRequirement.HungryReductionRequirement;
import app.Reduction.reductionRequirement.KidReductionRequirement;
import app.Reduction.reductionRequirement.ReductionRequirement;

public class Order {
    private Basket basket;
    private Reduction reduction;


    public Order(Basket basket, Reduction reduction) {
        this.basket = basket;
        this.reduction = reduction;
    }

    public void playOrder() {

//        CozReductionRequirement cozReductionRequirement = new CozReductionRequirement();
//        KidReductionRequirement kidReductionRequirement = new KidReductionRequirement();
//        HungryReductionRequirement hungryReductionRequirement = new HungryReductionRequirement();

//        CozReductionRequirement cozReductionRequirement = new CozReductionRequirement(new FastenedPercentageReductionPolicy(10));
//        KidReductionRequirement kidReductionRequirement = new KidReductionRequirement(new FastenedSumReductionPolicy(500));
//        HungryReductionRequirement hungryReductionRequirement = new HungryReductionRequirement(new FastenedHalfReductionPolicy(50));
//
//        cozReductionRequirement.examinationReductionRequirement();
//        kidReductionRequirement.examinationReductionRequirement();
//        hungryReductionRequirement.examinationReductionRequirement();
//
//        int totalValue = basket.calculateTotalValue();
////        int finalValue = 0; // 이것도 작동
//        int finalValue = totalValue;
//
//        if (cozReductionRequirement.isMeet()) finalValue = cozReductionRequirement.applyReduction(totalValue);
//        if (kidReductionRequirement.isMeet()) finalValue = kidReductionRequirement.applyReduction(totalValue);
//        if (hungryReductionRequirement.isMeet()) finalValue = hungryReductionRequirement.applyReduction(totalValue);

        int totalValue = basket.calculateTotalValue();
        int finalValue = reduction.reduction(totalValue);

        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(60));

        basket.printBasketGoodsDetails();

        System.out.println("-".repeat(60));
        System.out.printf("금액 합계      : %d원\n", totalValue);
        System.out.printf("할인 적용 금액 : %d원\n",finalValue);
    }
}

