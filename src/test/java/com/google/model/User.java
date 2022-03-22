package com.google.model;

import java.util.Objects;

public class User {

    private String userVMClass;
    private String userNumbersOfInstances;
    private String userInstanceType;
    private String userRegion;
    private String userLocalSsd;
    private String userCommitmentTerm;

    public User(String userNumbersOfInstances) {
        this.userNumbersOfInstances = userNumbersOfInstances;
        userVMClass = "regular";
        userInstanceType = "n1-standard-1";
        userRegion = "Frankfurt";
        userLocalSsd = "2x375 GiB";
        userCommitmentTerm = "1 Year";
    }

    public void setUserNumbersOfInstances(String userNumbersOfInstances) {
        this.userNumbersOfInstances = userNumbersOfInstances;
    }

    public String getUserVMClass() {
        return userVMClass;
    }

    public String getUserNumbersOfInstances() {
        return userNumbersOfInstances;
    }

    public String getUserInstanceType() {
        return userInstanceType;
    }

    public String getUserRegion() {
        return userRegion;
    }

    public String getUserLocalSsd() {
        return userLocalSsd;
    }

    public String getUserCommitmentTerm() {
        return userCommitmentTerm;
    }

    @Override
    public String toString() {
        return "User{" +
                "userVMClass='" + userVMClass + '\'' +
                ", userNumbersOfInstances='" + userNumbersOfInstances + '\'' +
                ", userInstanceType='" + userInstanceType + '\'' +
                ", userRegion='" + userRegion + '\'' +
                ", userLocalSsd='" + userLocalSsd + '\'' +
                ", userCommitmentTerm='" + userCommitmentTerm + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userVMClass, user.userVMClass) &&
                Objects.equals(userNumbersOfInstances, user.userNumbersOfInstances) &&
                Objects.equals(userInstanceType, user.userInstanceType) &&
                Objects.equals(userRegion, user.userRegion) &&
                Objects.equals(userLocalSsd, user.userLocalSsd) &&
                Objects.equals(userCommitmentTerm, user.userCommitmentTerm);

    }

    @Override
    public int hashCode() {
        return Objects.hash(userVMClass, userNumbersOfInstances, userInstanceType, userRegion, userLocalSsd, userCommitmentTerm);
    }
}
