package com.refactify.nicebank;

import com.refactify.support.TestAccount;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:cucumber.xml")
public class ServerHooks {
    public static final int PORT = 8887;
    private AtmServer server;
    @Autowired
    private CashSlot cashSlot;
    @Autowired
    private TestAccount account;

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
