package com.refactify.nicebank;

public class AutomatedTeller implements Teller {
    private CashSlot cashSlot;

    public AutomatedTeller(final CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }
    public void withdrawFrom(final Account account, final int amount) {
        account.debit(amount);
        cashSlot.dispense(amount);
    }
}
