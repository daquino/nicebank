package com.refactify.nicebank;

import com.refactify.support.KnowsTheAccount;
import com.refactify.support.KnowsTheCashSlot;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServerHooks {
    public static final int PORT = 8887;
    private AtmServer server;
    private KnowsTheCashSlot cashSlotHelper;
    private KnowsTheAccount accountHelper;

    public ServerHooks(final KnowsTheCashSlot cashSlotHelper, final KnowsTheAccount accountHelper) {
        this.cashSlotHelper = cashSlotHelper;
        this.accountHelper = accountHelper;
    }

    @Before
    public void startServer() throws Exception {
        server = new AtmServer(PORT, cashSlotHelper.getCashSlot(), accountHelper.getMyAccount());
        server.start();
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }
}
