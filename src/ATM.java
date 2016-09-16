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
        while (stillRun) {
            System.out.println("Please enter your username");
            String username = scanner.nextLine();
            if (users.get(username) == null) {
                System.out.println("User does not exist, would you like to create an account? Press y or n");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    main(args);
                }
                System.out.println("Please enter a password");
                String password = scanner.nextLine();
                System.out.println("Initial deposit amount?");
                int myBalance = scanner.nextInt();
                scanner.nextLine();
                User user = new User(username, password, myBalance);
                users.put(user.name, user);
            }
            System.out.println("Please enter your password");
            String userPass = scanner.nextLine();
            if (userPass.equalsIgnoreCase(users.get(username).pass)) {
            boolean isLoggedIn = true;
            while (isLoggedIn) {
                User user = users.get(username);

                    System.out.println("Welcome " + user.name + "!");
                    System.out.println("1: Check Balance");
                    System.out.println("2: Make Withdraw");
                    System.out.println("3: Logout");
                    System.out.println("4: Remove Account");
                    System.out.println("5: Quit");
                    String choice1 = scanner.nextLine();
                    if (choice1.equalsIgnoreCase("1")) {
                        System.out.println("Your balance is: $" + user.balance);
                    } else if (choice1.equalsIgnoreCase("2")) {
                        System.out.println("How much would you like to withdraw?");
                        String withdraw = scanner.nextLine();
                        if (Integer.parseInt(withdraw) > user.balance) {
                            System.out.println("You too broke biatch!");
                        } else {
                            user.balance = user.balance - Integer.parseInt(withdraw);
                            System.out.println("Please take your money");
                            System.out.println("Your new balance is: $" + user.balance);
                        }
                    } else if (choice1.equalsIgnoreCase("3")) {
                        isLoggedIn = false;
                        main(args);
                    } else if (choice1.equalsIgnoreCase("4")) {
                        System.out.println("Are you really sure you would like to remove your account? Press y or n");
                        String choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("y")) {
                            users.remove(user.name);
                            main(args);
                        }
                    } else if (choice1.equalsIgnoreCase("5")) {
                        System.exit(0);
                    }
                }
            }
            else {
                System.out.println("Password incorrect!");
                main(args);
            }
        }
    }
}
