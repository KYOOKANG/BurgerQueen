package app.Reduction.reductionRequirement;

import app.Reduction.reductionPolicy.FastenedPercentageReductionPolicy;
import app.Reduction.reductionPolicy.ReductionPolicy;

import java.util.Scanner;

public class CozReductionRequirement implements ReductionRequirement {

    private boolean isMeet;
    // 삭제 : private FastenedPercentageReductionPolicy fastenedPercentageReductionPolicy = new FastenedPercentageReductionPolicy(10);
    private ReductionPolicy reductionPolicy;

    public CozReductionRequirement(ReductionPolicy reductionPolicy) {
        this.reductionPolicy = reductionPolicy;
    }

    public int applyReduction(int value) {
        // 삭제 : return fastenedPercentageReductionPolicy.calculateReductionValue(value);
        return reductionPolicy.calculateReductionValue(value);
    }


    public boolean isMeet() {
        return isMeet;
    }

    private void setMeet(boolean meet) {isMeet = meet;}

    public void examinationReductionRequirement() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("코드스테이츠 수강생이십니까? (1)_예 (2)_아니오");
        String select = scanner.nextLine();

        if (select.equals("1")) setMeet(true);
        else if (select.equals("2")) setMeet(false);
    }
}
