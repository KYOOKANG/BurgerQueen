package app.Reduction.reductionPolicy;

public class FastenedPercentageReductionPolicy implements ReductionPolicy {
    private int reductionPercentage;

    public FastenedPercentageReductionPolicy(int reductionPercentage) {
        this.reductionPercentage = reductionPercentage;
    }

    public int calculateReductionValue(int value) {
        return value = value - (value * reductionPercentage / 100);
    }


}
