package app.Reduction.reductionRequirement;

import app.Reduction.reductionPolicy.FastenedSumReductionPolicy;
import app.Reduction.reductionPolicy.ReductionPolicy;

import java.util.Scanner;

public class KidReductionRequirement implements ReductionRequirement {

    private boolean isMeet;
//   삭제 : FastenedSumReductionPolicy fastenedSumReductionPolicy = new FastenedSumReductionPolicy(500);
    ReductionPolicy reductionPolicy;

    public KidReductionRequirement(ReductionPolicy reductionPolicy) {
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

        System.out.println("나이가 어떻게 되십니까?");

//        String select = scanner.nextLine();
//        int input = Integer.parseInt(select);
        int select = Integer.parseInt(scanner.nextLine()); // 위와 동일

//        if (Integer.parseInt(select) < 20) setMeet(true);
//        else if (Integer.parseInt(select) >= 20) setMeet(false);
        setMeet(select < 20); // 위와 동일
    }

    public int applyReduction(int value) {
        return reductionPolicy.calculateReductionValue(value);
    }


}
