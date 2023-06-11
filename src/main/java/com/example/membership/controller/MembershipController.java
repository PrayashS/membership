/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.membership.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.membership.model.Member;

public class MembershipController {
    private List<Member> members;

    public MembershipController() {
        members = new ArrayList<>();
    }

    public void runMembershipFeeCalculator() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Membership Fee Calculator");
            System.out.println("1. Add new member");
            System.out.println("2. Display list of members");
            System.out.println("3. Query a member");
            System.out.println("4. Delete a member");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewMember(scanner);
                    break;
                case 2:
                    displayListOfMembers();
                    break;
                case 3:
                    queryMember(scanner);
                    break;
                case 4:
                    deleteMember(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Membership Fee Calculator...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 5);
    }

    private void addNewMember(Scanner scanner) {
        System.out.println("Add New Member");
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        System.out.print("Enter member email: ");
        String email = scanner.nextLine();

        System.out.print("Enter member birthdate (dd-mm-yyyy): ");
        String birthdate = scanner.nextLine();

        System.out.print("Enter number of months for membership: ");
        int months = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        System.out.print("Special offer? (yes/no): ");
        String specialOffer = scanner.nextLine();

        boolean isSpecialOffer = specialOffer.equalsIgnoreCase("yes");

        Member newMember = new Member(name, email, birthdate, months, isSpecialOffer);
        members.add(newMember);

        System.out.println("New member added successfully!");
    }

    private void displayListOfMembers() {
        System.out.println("List of Members");
        System.out.println("================");

        for (Member member : members) {
            System.out.println(member);
        }

        System.out.println();

        // Member with the highest spending
        Member highestSpendingMember = getHighestSpendingMember();
        System.out.println("Member with the highest spending: ");
        System.out.println(highestSpendingMember);
        System.out.println();

        // Member with the lowest spending
        Member lowestSpendingMember = getLowestSpendingMember();
        System.out.println("Member with the lowest spending: ");
        System.out.println(lowestSpendingMember);
        System.out.println();

        // Number of members with months less than 6 and greater than/equal to 6
        int membersLessThan6Months = getMembersLessThan6Months();
        int membersGreaterThanOrEqual6Months = getMembersGreaterThanOrEqual6Months();
        System.out.println("Number of members with months less than 6: " + membersLessThan6Months);
        System.out.println("Number of members with months greater than/equal to 6: " + membersGreaterThanOrEqual6Months);
    }

    private Member getHighestSpendingMember() {
    if (members.isEmpty()) {
        return null;
    }

    Member highestSpendingMember = members.get(0);
    double highestSpending = highestSpendingMember.calculateMembershipCost();

    for (Member member : members) {
        double membershipCost = member.calculateMembershipCost();
        if (membershipCost > highestSpending) {
            highestSpending = membershipCost;
            highestSpendingMember = member;
        }
    }

    return highestSpendingMember;
}

    public Member getLowestSpendingMember() {
    if (members.isEmpty()) {
        return null;
    }

    Member lowestSpendingMember = members.get(0);
    double lowestSpending = lowestSpendingMember.calculateMembershipCost();

    for (Member member : members) {
        double membershipCost = member.calculateMembershipCost();
        if (membershipCost < lowestSpending) {
            lowestSpending = membershipCost;
            lowestSpendingMember = member;
        }
    }

    return lowestSpendingMember;
}

    private int getMembersLessThan6Months() {
        int count = 0;

    for (Member member : members) {
        if (member.getMonths() < 6) {
            count++;
        }
    }

    return count;
}

    private int getMembersGreaterThanOrEqual6Months() {
    int count = 0;

    for (Member member : members) {
        if (member.getMonths() >= 6) {
            count++;
        }
    }

    return count;
}

    private void queryMember(Scanner scanner) {
        System.out.println("Query a Member");
        System.out.println("==============");

        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        System.out.print("Enter member birthdate (dd-mm-yyyy): ");
        String birthdate = scanner.nextLine();

        Member queriedMember = findMemberByNameAndBirthdate(name, birthdate);

        if (queriedMember != null) {
            System.out.println("Member Details");
            System.out.println(queriedMember);
        } else {
            System.out.println("Member not found!");
        }
    }

    private Member findMemberByNameAndBirthdate(String name, String birthdate) {
         for (Member member : members) {
        if (member.getName().equalsIgnoreCase(name) && member.getBirthdate().equals(birthdate)) {
            return member;
        }
    }
    return null;
}

    private void deleteMember(Scanner scanner) {
        System.out.println("Delete a Member");
        System.out.println("===============");

        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        System.out.print("Enter member birthdate (dd-mm-yyyy): ");
        String birthdate = scanner.nextLine();

        Member memberToDelete = findMemberByNameAndBirthdate(name, birthdate);

        if (memberToDelete != null) {
            members.remove(memberToDelete);
            System.out.println("Member deleted successfully!");
        } else {
            System.out.println("Member not found!");
        }
    }
}

