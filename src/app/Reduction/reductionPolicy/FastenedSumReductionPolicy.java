package app.Reduction.reductionPolicy;

public class FastenedSumReductionPolicy implements ReductionPolicy {

    private int reductionSum;

    public FastenedSumReductionPolicy(int reductionSum) {
        this.reductionSum = reductionSum;
    }

    public int calculateReductionValue(int value) {
        return value = value - reductionSum;
    }
}
