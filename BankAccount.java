import java.util.Scanner;
class BankAccount {
    private String name;
    private String username;
    private String password;
    private double balance;

public BankAccount (String name, String username, String password, double balance){
    this.name = name;
    this.username = username;
    this.password = password;
    this.balance = balance;
}

public void deposit(double amount) {
    balance += amount;
    System.out.println("Deposited: " + amount);
    System.out.println("Your new balance is " + balance);
}

public void withdraw(double amount){
    if (amount > balance) {
        System.out.println("Withdrawal of " + amount + " cannot be made. Balance is less than withdrawal amount.");
        System.out.println("Please try again.");
    } else {
        balance -= amount;
        System.out.println("Withdrawal of " + amount + " was successful.");
        System.out.println("Your new balance is " + balance);
    }
}

public void checkBalance() {
    System.out.println("Checking bank account balance: " + balance);
}

public boolean loginAccount(String enteredUsername, String enteredPassword) {
    return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
   }

public static void main(String[] args) {
   System.out.println("Welcome to the bank! What is your name?");
   Scanner scanner = new Scanner(System.in);
   String name = scanner.nextLine();
   System.out.println("Nice to meet you, " + name + "!" );
   System.out.println("Please create an account. Enter your username.");
   String username = scanner.nextLine();
   System.out.println("Please enter your password now.");
   String password = scanner.nextLine();
   System.out.println("Account creation successful! Remember to write down your account information and do not share this information with anyone else!");
   System.out.println("Would you like to continue or log out?");
   String decision = scanner.nextLine();

   if (decision.equalsIgnoreCase("log out")) {
    System.out.println("You are now logging out, goodbye!");
    return;
   }
   
   boolean hasStartingBalance = false;
   double startingBalance = 0;
   while (!hasStartingBalance) {
   System.out.println("Please enter your starting balance.");
   startingBalance = scanner.nextDouble();
   
   if (startingBalance < 0) {
    System.out.println("Invalid starting balance. Balance cannot be negative.");
   } else {
    System.out.println("Success! You now have a balance of $" + startingBalance);
    hasStartingBalance = true;
   }
   scanner.nextLine();
}

   BankAccount account = new BankAccount(name, username, password, startingBalance);

   boolean loggedIn = false;
   while (!loggedIn) {
   System.out.println("Please log in again to continue.");
   System.out.println("Enter your username: ");
   String enteredUsername = scanner.nextLine();
   System.out.println("Enter your password.");
   String enteredPassword = scanner.nextLine();

   if (account.loginAccount(enteredUsername, enteredPassword)) {
    System.out.println("Login successful!");   
    loggedIn = true;
    } else {
    System.out.println("Invalid login. Please try again.");
   }
   }
   
    boolean menu = true;
    while (menu) { 
    System.out.println("Bank Menu");
    System.out.println("Deposit Money");
    System.out.println("Withdraw Money");
    System.out.println("Check Balance");
    System.out.println("What do you want to do today?");
    
    String answer = scanner.nextLine();

    if (answer.equalsIgnoreCase("Deposit Money") || answer.equalsIgnoreCase("Deposit")) {
      System.out.println("How much money would you like to deposit?");
      double amount = scanner.nextDouble();
      scanner.nextLine();
      account.deposit(amount);
    }
    
    else if (answer.equalsIgnoreCase("Withdraw Money") || answer.equalsIgnoreCase("Withdraw")) { 
      System.out.println("How much money would you like to withdraw?");
      double amount = scanner.nextDouble();
      scanner.nextLine();
      account.withdraw(amount);
    }

    else if (answer.equalsIgnoreCase("Check Balance") || answer.equalsIgnoreCase("Check")){  
        account.checkBalance();
    }
    else {
        System.out.println("System error, please try again");
    }
    
    System.out.println("Would you like to do anything else today?");
    String response = scanner.nextLine();
    if (!response.equalsIgnoreCase("Yes")) {
        menu = false;
        System.out.println("Thank you for coming, have a good day!");
    }
    }
    scanner.close();
}
}