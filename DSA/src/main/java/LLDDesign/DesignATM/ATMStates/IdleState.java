package LLDDesign.DesignATM.ATMStates;

import LLDDesign.DesignATM.ATM;
import LLDDesign.DesignATM.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }

}
