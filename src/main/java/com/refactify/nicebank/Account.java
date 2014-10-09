package com.refactify.nicebank;

public class Account {
    private TransactionQueue queue = new TransactionQueue();

    public void credit(Money amount) {
        queue.write("+" + amount.toString());
    }

    public void debit(final int dollars) {
        Money amount = new Money(dollars, 0);
        queue.write("-" + amount.toString());
    }

    public Money getBalance() {
        return BalanceStore.getBalance();
    }
}
