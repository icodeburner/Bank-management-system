package projects;

import java.util.Scanner;

class BankAccount {
    private String customerName = null;
    private int customerId;
    private float balance;

    public void createAccount(String customerName, int customerId, float balance) {

        if (balance < 1000) {
            System.out.println("Account cannot be create you have to deposite Minimum balance 1000");
        } else {
            this.customerName = customerName;
            this.customerId = customerId;
            this.balance = balance;
            System.out.println("Account created succesfully");
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public float getBalance() {
        return balance;
    }

    public float deposite(float amount) {
        balance += amount;
        System.out.println("Cash deposited successfully");
        return balance;
    }

    public float withdrawl(float amount) {
        if (balance < amount) {
            System.out.println("Low balance");
        } else {
            balance -= amount;
            System.out.println("Cash withdrawl successfully");
        }
        return balance;
    }

    public void deleteAccount() {
        if (customerName == null && customerId == 0 && balance == 0) {
            System.out.println("You have create account first to delete account");
        } else {
            customerName = null;
            customerId = 0;
            balance = 0;
            System.out.println("Account delete seccussfully");
        }
    }

    public void displayDetails() {
        System.out.println("\nCustomer name : " + customerName);
        System.out.println("Customer id : " + customerId);
        System.out.println("Customer balance : " + balance + "\n");
    }
}

public class bankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();
        float amount;

        while (true) {
            System.out.println(
                    "\nPress 1 -> Create account\nPress 2 -> Deposite\nPress 3 -> Withdrawl\nPress 4 -> Show details\n"
                            + //
                            "Press 5 -> Delete account\nPress 0 -> Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\nEnter customer name : ");
                    String customerName = sc.next();
                    System.out.println("Enter cutomer id : ");
                    int customerId = sc.nextInt();
                    System.out.println("Enter balance : ");
                    float balance = sc.nextFloat();

                    account.createAccount(customerName, customerId, balance);
                    break;
                case 2:
                    System.out.println("Enter amount : ");
                    amount = sc.nextFloat();
                    account.deposite(amount);
                    break;
                case 3:
                    System.out.println("Enter amount : ");
                    amount = sc.nextFloat();
                    account.withdrawl(amount);
                    break;
                case 4:
                    account.displayDetails();
                    break;
                case 5:
                    account.deleteAccount();
                    break;
                case 0:
                    System.out.println("Thank you for using our bank!");
                    return;
                default:
                    System.out.println("Enter valid number please!");
                    break;
            }
            // sc.close();
        }
    }
}
