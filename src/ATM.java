import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by michaelplott on 9/16/16.
 */
public class ATM {

    static HashMap<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stillRun = true;
        System.out.println();
        System.out.println("Welcome to the ATM");
        System.out.println();
        while (stillRun) {
            System.out.println("Please enter your username");
            String username = scanner.nextLine();
            if (username.startsWith("/")) {
                System.out.println("Invalid username");
                main(args);
            }
            if (users.get(username) == null) {
                System.out.println();
                System.out.println("User does not exist, would you like to create an account? Press y or n");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    System.out.println("Returning to user entry");
                    System.out.println();
                    main(args);
                } else if (!choice.equalsIgnoreCase("y")) {
                    main(args);
                }
                System.out.println();
                System.out.println("Please enter a password");
                String password = scanner.nextLine();
                System.out.println();
                System.out.println("Initial deposit amount?");
                int myBalance = scanner.nextInt();
                scanner.nextLine();
                User user = new User(username, password, myBalance);
                users.put(user.name, user);
            }
            System.out.println();
            System.out.println("Please enter your password");
            String userPass = scanner.nextLine();
            if (!userPass.equalsIgnoreCase(users.get(username).pass)) {
                System.out.println();
                System.out.println("Password incorrect, returning you to user login");
                main(args);
            }
            if (userPass.equalsIgnoreCase(users.get(username).pass)) {
                System.out.println();
                System.out.println("Welcome " + username + "!");
                boolean isLoggedIn = true;
                while (isLoggedIn) {
                    User user = users.get(username);
                    System.out.println();
                    System.out.println("1: Check Balance");
                    System.out.println("2: Make Withdraw");
                    System.out.println("3: Make Deposit");
                    System.out.println("4: Logout");
                    System.out.println("5: Remove Account");
                    System.out.println("6: Quit");
                    System.out.println("/admin will print out all users accounts");
                    System.out.println();
                    String choice1 = scanner.nextLine();
                    System.out.println();
                    if (choice1.equalsIgnoreCase("1")) {
                        System.out.println();
                        System.out.println("Your balance is: $" + user.balance);
                    } else if (choice1.equalsIgnoreCase("2")) {
                        System.out.println();
                        System.out.println("How much would you like to withdraw?");
                        String withdraw = scanner.nextLine();
                        if (Integer.parseInt(withdraw) > user.balance) {
                            System.out.println("You too broke biatch!");
                        } else {
                            user.balance -= Integer.parseInt(withdraw);
                            System.out.println();
                            System.out.println("Please take your money");
                            System.out.println();
                            System.out.println("Your new balance is: $" + user.balance);
                        }
                    } else if (choice1.equalsIgnoreCase("4")) {
                        isLoggedIn = false;
                        main(args);
                    } else if (choice1.equalsIgnoreCase("5")) {
                        System.out.println("Are you really sure you would like to remove your account? Press y or n");
                        String choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("y")) {
                            users.remove(user.name);
                            main(args);
                        }
                    } else if (choice1.equalsIgnoreCase("6")) {
                        System.exit(0);
                    } else if (choice1.equalsIgnoreCase("3")) {
                        System.out.println();
                        System.out.println("Please enter deposit amount");
                        String deposit = scanner.nextLine();
                        user.balance = user.balance + Integer.parseInt(deposit);
                        System.out.println();
                        System.out.println("Your new balance is: $" + user.balance);
                    } else if (choice1.equalsIgnoreCase("/admin")) {
                        for (String key : users.keySet()) {
                            System.out.println("Username: " + users.get(key).name +
                                    "," + " " + "Password: " + "" + users.get(key).pass +
                                    "," + " " + "Balance: " + "" + users.get(key).balance);
                            System.out.println();
                        }
                            main(args);
                    }
                    else {
                        System.out.println("Password incorrect!");
                        main(args);
                    }
                }
            }
        }
    }
}
