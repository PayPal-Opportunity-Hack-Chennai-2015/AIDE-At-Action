package org.aea.dto;

import com.google.common.base.MoreObjects;

/**
 * Created by sathsrinivasan on 11/29/2015.
 */
public class NutritionAssessment {
    private int isAnemic;
    private int isCleanWater;
    private int isNutrition;
    private int isSanitation;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("isAnemic", isAnemic)
                .add("isCleanWater", isCleanWater)
                .add("isNutrition", isNutrition)
                .add("isSanitation", isSanitation)
                .toString();
    }

    public int getIsCleanWater() {
        return isCleanWater;
    }

    public void setIsCleanWater(int isCleanWater) {
        this.isCleanWater = isCleanWater;
    }

    public int getIsNutrition() {
        return isNutrition;
    }

    public void setIsNutrition(int isNutrition) {
        this.isNutrition = isNutrition;
    }

    public int getIsSanitation() {
        return isSanitation;
    }

    public void setIsSanitation(int isSanitation) {
        this.isSanitation = isSanitation;
    }

    public int getIsAnemic() {
        return isAnemic;
    }

    public void setIsAnemic(int isAnemic) {
        this.isAnemic = isAnemic;
    }
}
