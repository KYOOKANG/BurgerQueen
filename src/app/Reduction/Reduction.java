package app.Reduction;

import app.Reduction.reductionRequirement.ReductionRequirement;

public class Reduction {
    private ReductionRequirement[] reductionRequirements;

    public Reduction(ReductionRequirement[] reductionRequirements) {
        this.reductionRequirements = reductionRequirements;
    }

    public int reduction(int value) {
        int reductionValue = value;

        for (ReductionRequirement reductionRequirement : reductionRequirements) {
            reductionRequirement.examinationReductionRequirement();
            if (reductionRequirement.isMeet()) reductionValue = reductionRequirement.applyReduction(reductionValue);
        }
        return reductionValue;
    }
}


