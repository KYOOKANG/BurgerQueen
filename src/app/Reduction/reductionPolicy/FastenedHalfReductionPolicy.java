package app.Reduction.reductionPolicy;

public class FastenedHalfReductionPolicy implements ReductionPolicy {
    private int halfRate;

    public FastenedHalfReductionPolicy(int halfRate) {
        this.halfRate = halfRate;
    }

    public int calculateReductionValue(int value) {
        return value / (100 / halfRate);
    }
}
