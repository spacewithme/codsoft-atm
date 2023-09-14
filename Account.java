import java.util.Scanner;

public class Account {
    private double balance;

    public Account(double originalBalance) {
        balance = originalBalance;
    }
    public double getBalance(){
        return  balance;
    }
    public void deposit(double amount){
        if(amount > 0){
            balance = balance + amount;
            System.out.println("Amount Deposited: "+ amount);

        } else {
            System.out.println("Amount you have entered  is invalid");
        }

    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance){
            balance = balance - amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("you have "+ balance +" Rupees in your acc. you can not withdraw more than "+ balance);

        }else {
            System.out.println("Amount you have entered  is Invalid");
        }

    }

}

class ATM{
    private Account acc;
    private Scanner sc;

    public ATM(Account acc){

        this.acc=acc;
        sc = new Scanner(System.in);

    }
    public void options(){
        System.out.println("------------------------");
        System.out.println("1. Inquire Balance");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Withdraw Cash");
        System.out.println("4. Exit");
        System.out.print("\nSelect Any Option :\n");
        System.out.println("------------------------");
    }
    public void choose(){
        int ch;
        do {
            options();
           // System.out.println("Select the Service");
            ch = sc.nextInt();
            switch (ch){
                case 1:
                    getBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    // exit
                    System.out.println("------------------------");
                    System.out.println("Thanks for using our banking services");
                    System.out.println("------------------------");
                    break;
                default:System.out.println("Option Not Available");

            }
        }
        while (ch != 4);


    }
    private void getBalance(){
        // balance display
        System.out.println("------------------------");
        System.out.println("Balance: " + "Rs." + acc.getBalance());
        System.out.println("------------------------");
        System.out.println("\n\n");
    }
    private void deposit(){
        System.out.println("Enter the Amount to Deposit");
        double amount = sc.nextDouble();
        acc.deposit(amount);
    }
    private void withdraw(){
        System.out.println("Enter the Amount to Withdraw");
        double amount = sc.nextDouble();
        acc.withdraw(amount);
    }

}
