package com.refactify.nicebank;

import cucumber.api.java.Before;
import org.javalite.activejdbc.Base;

public class ResetHooks {
    @Before(order = 1)
    public void reset() {
        TransactionQueue.clear();
        if (!Base.hasConnection()) {
            Base.open(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/bank",
                    "teller", "password"
            );
            Account.deleteAll();
        }
    }
}
