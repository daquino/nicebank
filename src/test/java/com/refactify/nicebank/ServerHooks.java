package com.refactify.nicebank;

import com.refactify.support.KnowsTheDomain;
import cucumber.api.java.*;

public class ServerHooks {
    public static final int PORT = 8887;
    private AtmServer server;
    private KnowsTheDomain helper;

    public ServerHooks(final KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Before
    public void startServer() throws Exception {
        server = new AtmServer(PORT, helper.getCashSlot(), helper.getMyAccount());
        server.start();
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }
}
