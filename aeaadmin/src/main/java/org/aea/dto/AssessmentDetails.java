package org.aea.dto;

import com.google.common.base.MoreObjects;
import org.aea.entity.Ngo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sathsrinivasan on 11/29/2015.
 */
public class AssessmentDetails {
    private Ngo selectedNgo;
    private User familyHead;
    private Address address;
    private String startDate;
    private String category;
    private Worksite selectedWorksite;
    private FamilyEntitlement familyEntitlement;
    private Set<User> family = new HashSet<User>();
    private int work;
    private String workName;
    private String familyId;
    private Date date;

    public Ngo getSelectedNgo() {
        return selectedNgo;
    }

    public void setSelectedNgo(Ngo selectedNgo) {
        this.selectedNgo = selectedNgo;
    }

    public User getFamilyHead() {
        return familyHead;
    }

    public void setFamilyHead(User familyHead) {
        this.familyHead = familyHead;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Worksite getSelectedWorksite() {
        return selectedWorksite;
    }

    public void setSelectedWorksite(Worksite selectedWorksite) {
        this.selectedWorksite = selectedWorksite;
    }

    public FamilyEntitlement getFamilyEntitlement() {
        return familyEntitlement;
    }

    public void setFamilyEntitlement(FamilyEntitlement familyEntitlement) {
        this.familyEntitlement = familyEntitlement;
    }

    public Set<User> getFamily() {
        return family;
    }

    public void addUser(User member) {
        this.family.add(member);
    }

    public void setWork(int work) {
        this.work = work;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public int getWork() {
        return work;
    }

    public String getWorkName() {
        return workName;
    }

    public void setFamily(Set<User> family) {
        this.family = family;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("selectedNgo", selectedNgo)
                .add("familyHead", familyHead)
                .add("address", address)
                .add("startDate", startDate)
                .add("category", category)
                .add("selectedWorksite", selectedWorksite)
                .add("familyEntitlement", familyEntitlement)
                .add("family", family)
                .add("work", work)
                .add("workName", workName)
                .add("familyId", familyId)
                .toString();
    }
}
