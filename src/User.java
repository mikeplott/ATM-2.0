/**
 * Created by michaelplott on 9/16/16.
 */
public class User {

    String name;
    String pass;
    int balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public User(String name, String pass, int balance) {
        this.name = name;
        this.pass = pass;
        this.balance = balance;

    }
}
