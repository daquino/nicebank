package com.refactify.nicebank;

import com.refactify.support.TestAccount;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServerHooks {
    public static final int PORT = 8887;
    private AtmServer server;
    private CashSlot cashSlot;
    private TestAccount account;

    public ServerHooks(final CashSlot cashSlot, final TestAccount account) {
        this.cashSlot = cashSlot;
        this.account = account;
    }

    @Before(order = 2)
    public void startServer() throws Exception {
        server = new AtmServer(PORT, cashSlot, account);
        server.start();
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }
}
