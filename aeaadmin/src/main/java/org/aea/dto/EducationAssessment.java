package org.aea.dto;

import com.google.common.base.MoreObjects;

/**
 * Created by sathsrinivasan on 11/29/2015.
 */
public class EducationAssessment {

    private int selectedSchool;
    private String grade;
    private int isBooks;
    private int isScholarship;

    public int getSelectedSchool() {
        return selectedSchool;
    }

    public void setSelectedSchool(int selectedSchool) {
        this.selectedSchool = selectedSchool;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getIsBooks() {
        return isBooks;
    }

    public void setIsBooks(int isBooks) {
        this.isBooks = isBooks;
    }

    public int getIsScholarship() {
        return isScholarship;
    }

    public void setIsScholarship(int isScholarship) {
        this.isScholarship = isScholarship;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("selectedSchool", selectedSchool)
                .add("grade", grade)
                .add("isBooks", isBooks)
                .add("isScholarship", isScholarship)
                .toString();
    }
}
