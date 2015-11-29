package org.aea.dto;

/**
 * Created by sathsrinivasan on 11/29/2015.
 */
public class FamilyEntitlement {
    private int isMarriageScheme;
    private int isMarriageBenefits;
    private int isOldAgePension;
    private int isWidowPension;
    private int ration;

    public int getIsMarriageScheme() {
        return isMarriageScheme;
    }

    public void setIsMarriageScheme(int isMarriageScheme) {
        this.isMarriageScheme = isMarriageScheme;
    }

    public int getIsMarriageBenefits() {
        return isMarriageBenefits;
    }

    public void setIsMarriageBenefits(int isMarriageBenefits) {
        this.isMarriageBenefits = isMarriageBenefits;
    }

    public int getIsOldAgePension() {
        return isOldAgePension;
    }

    public void setIsOldAgePension(int isOldAgePension) {
        this.isOldAgePension = isOldAgePension;
    }

    public int getIsWidowPension() {
        return isWidowPension;
    }

    public void setIsWidowPension(int isWidowPension) {
        this.isWidowPension = isWidowPension;
    }

    public int getRation() {
        return ration;
    }

    public void setRation(int ration) {
        this.ration = ration;
    }
}
