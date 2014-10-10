package com.refactify.nicebank;

public class TransactionProcessor {
    private TransactionQueue queue = new TransactionQueue();

    public void process() {
        do {
            String message = queue.read();

            if(message.length() > 0) {
                String[] parts = message.split(",");
                Account account = Account.findFirst("number = ?", parts[1]);
                Money transactionAmount = new Money(parts[0]);
                if(isCreditTransaction(message)) {
                    account.setBalance(account.getBalance().add(transactionAmount));
                }
                else {
                    account.setBalance(account.getBalance().minus(transactionAmount));
                }
            }
        } while (true);
    }

    private boolean isCreditTransaction(final String message) {
        return !message.startsWith("-");
    }
}
