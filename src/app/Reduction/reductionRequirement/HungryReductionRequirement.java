package app.Reduction.reductionRequirement;

import app.Reduction.reductionPolicy.FastenedHalfReductionPolicy;
import app.Reduction.reductionPolicy.ReductionPolicy;

import java.util.Scanner;

public class HungryReductionRequirement implements ReductionRequirement {
    private boolean isMeet;
//    삭제 : FastenedHalfReductionPolicy fastenedHalfReductionPolicy = new FastenedHalfReductionPolicy(50);
    ReductionPolicy reductionPolicy;

    public HungryReductionRequirement(ReductionPolicy reductionPolicy) {
        this.reductionPolicy = reductionPolicy;
    }

    public boolean isMeet() {
        return isMeet;
    }

    private void setMeet(boolean meet) {
        isMeet = meet;
    }

    public void examinationReductionRequirement() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("당신은 배고프신가요? : (1) 네  (2) 아니요.");

        String select = scanner.nextLine();

        if (select.equals("1")) setMeet(true);
        else if (select.equals("2")) setMeet(false);
    }

    public int applyReduction(int value) {
        return reductionPolicy.calculateReductionValue(value);
    }
}
