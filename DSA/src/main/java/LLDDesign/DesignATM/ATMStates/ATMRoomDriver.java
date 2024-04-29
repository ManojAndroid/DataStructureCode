package LLDDesign.DesignATM.ATMStates;

import LLDDesign.DesignATM.*;

public class ATMRoomDriver {
    public ATM atm;
    public User user;
    public static void main(String args[]) {

        ATMRoomDriver atmRoomDriver = new ATMRoomDriver();
        atmRoomDriver.initialize();

        atmRoomDriver.atm.printCurrentATMStatus();
        atmRoomDriver.atm.getCurrentATMState().insertCard(atmRoomDriver.atm, atmRoomDriver.user.card);
        atmRoomDriver.atm.getCurrentATMState().authenticatePin(atmRoomDriver.atm, atmRoomDriver.user.card, 112211);
        atmRoomDriver.atm.getCurrentATMState().selectOperation(atmRoomDriver.atm, atmRoomDriver.user.card, TransactionType.CASH_WITHDRAWAL);
        atmRoomDriver.atm.getCurrentATMState().cashWithdrawal(atmRoomDriver.atm, atmRoomDriver.user.card, 2700);
        atmRoomDriver.atm.printCurrentATMStatus();


    }

    private void initialize() {

        //create ATM
        atm = ATM.getATMObject();
        atm.setAtmBalance(3500, 1,2,5);

        //create User
        this.user = createUser();
    }

    private User createUser(){

        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard(){

        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private UserBankAccount createBankAccount() {

        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.balance = 3000;

        return bankAccount;

    }


}
