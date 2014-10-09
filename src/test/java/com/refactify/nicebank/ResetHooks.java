package com.refactify.nicebank;

import cucumber.api.java.Before;

public class ResetHooks {
    @Before
    public void reset() {
        TransactionQueue.clear();
        BalanceStore.clear();
    }
}
