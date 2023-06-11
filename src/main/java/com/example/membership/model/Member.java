/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.membership.model;

public class Member {
    private String name;
    private String email;
    private String birthdate;
    private int months;
    private boolean isSpecialOffer;

    public Member(String name, String email, String birthdate, int months, boolean isSpecialOffer) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.months = months;
        this.isSpecialOffer = isSpecialOffer;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public boolean isSpecialOffer() {
        return isSpecialOffer;
    }

    public void setSpecialOffer(boolean specialOffer) {
        isSpecialOffer = specialOffer;
    }

    // Other methods

    public double calculateMembershipCost() {
        double baseFee = 0.0;

        if (months >= 1 && months <= 6) {
            baseFee = 30.0;
        } else if (months > 6 && months <= 12) {
            baseFee = 27.5;
        } else if (months > 12) {
            baseFee = 25.0;
        }

        double discount = isSpecialOffer ? 0.15 : 0.0;
        double totalFee = baseFee * months;
        double discountedFee = totalFee - (totalFee * discount);

        return discountedFee;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", months=" + months +
                ", isSpecialOffer=" + isSpecialOffer +
                ", membershipCost=" + calculateMembershipCost() +
                '}';
    }
}
