package LLDDesign.DesignATM;

public class UserBankAccount {
    public int balance;

    public void withdrawalBalance(int amount) {
        balance = balance - amount;
    }

}
