import java.util.Scanner;

public class BankATM implements ATM {
    private int balance;
    
    public BankATM(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void getMyBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    @Override
    public void getCash(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Remaining balance: " + balance);
        }
    }
    
    public void depositCash(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("Updated balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    public void applyLoan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the type of loan you want:");
        System.out.println("1. Personal Loan");
        System.out.println("2. Car Loan");
        System.out.println("3. Home Loan");
        System.out.println("4. Educational Loan");
        System.out.print("Enter your choice: ");
        int loanType = scanner.nextInt();
        
        showLoanDocuments(loanType);
    }

    private void showLoanDocuments(int loanType) {
        Scanner scanner = new Scanner(System.in);
        String loanTypeName = "";
        switch (loanType) {
            case 1:
                loanTypeName = "Personal Loan";
                break;
            case 2:
                loanTypeName = "Car Loan";
                break;
            case 3:
                loanTypeName = "Home Loan";
                break;
            case 4:
                loanTypeName = "Educational Loan";
                break;
            default:
                System.out.println("Invalid choice! Loan application canceled.");
                return;
        }
        
        System.out.println("You have selected: " + loanTypeName);
        System.out.println("To apply for a " + loanTypeName + ", please provide the following documents:");
        
        if (loanType == 1 || loanType == 2 || loanType == 3 || loanType == 4) {
            System.out.println("1. Identity Proof (Aadhaar/Passport/Driving License/Voter ID/PAN Card)");
            System.out.println("2. Address Proof (Utility Bills/Bank Statement/Rent Agreement/Passport)");
            System.out.println("3. Income Proof (Salary Slips/Form 16/ITR/Bank Statement)");
        }
        if (loanType == 2) {
            System.out.println("4. Vehicle Documents (Vehicle Quotation/Registration Certificate/Insurance Documents)");
        }
        if (loanType == 3) {
            System.out.println("4. Property Documents (Sale Deed/Registration/NOC from Builder)");
        }
        if (loanType == 4) {
            System.out.println("4. Student's Documents (Admission Letter/Marksheet/Certificate of Last Exam Passed/Proof of Age/PAN Card)");
            System.out.println("5. Co-Applicant's Documents (Identity Proof/Address Proof/Income Proof)");
            System.out.println("6. Institution's Documents (Fee Structure/Admission Letter/Certificate of Recognition)");
        }
        
        System.out.print("Enter your CIBIL score: ");
        int cibilScore = scanner.nextInt();
        
        if (cibilScore >= 750) {
            System.out.println("Excellent credit score");
        } else if (cibilScore >= 700) {
            System.out.println("Good credit score");
        } else if (cibilScore >= 650) {
            System.out.println("Fair credit score");
        } else {
            System.out.println("Poor or Bad credit score");
            System.out.println("Your application may lead to:");
            System.out.println("* Higher interest rates");
            System.out.println("* Stricter loan terms");
            System.out.println("* Lower loan amounts");
        }
        
        System.out.print("Enter your monthly income: ");
        int monthlyIncome = scanner.nextInt();
        int eligibleLoanAmount = 0;
        
        if (monthlyIncome >= 100000) {
            eligibleLoanAmount = 2000000;
        } else if (monthlyIncome >= 75000) {
            eligibleLoanAmount = 1500000;
        } else if (monthlyIncome >= 50000) {
            eligibleLoanAmount = 1000000;
        } else if (monthlyIncome >= 25000) {
            eligibleLoanAmount = 500000;
        } else {
            System.out.println("Sorry, you are not eligible for a loan.");
            return;
        }
        
        System.out.println("Based on your income, you are eligible for a loan amount of: " + eligibleLoanAmount);
        System.out.println("Please fill out the loan application form here: https://www.bankwebsite.com/loan-application");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankATM myATM = new BankATM(5000);
        
        while (true) {
            System.out.println("\nWelcome to the Bank ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Apply for Loan");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    myATM.getMyBalance();
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    int withdrawAmount = scanner.nextInt();
                    myATM.getCash(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter deposit amount: ");
                    int depositAmount = scanner.nextInt();
                    myATM.depositCash(depositAmount);
                    break;
                case 4:
                    myATM.applyLoan();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}