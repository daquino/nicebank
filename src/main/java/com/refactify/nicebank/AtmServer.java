package com.refactify.nicebank;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;
import org.javalite.activejdbc.Base;

public class AtmServer {
    private final Server server;
    public AtmServer(final int port, final CashSlot cashSlot, final Account account) {
        server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new WithdrawalServlet(cashSlot, account)), "/withdraw");
        context.addServlet(new ServletHolder(new AtmServlet()), "/");
    }

    public void start() throws Exception {
        server.start();
        System.out.println("Listening on " + server.getURI());
    }

    public void stop() throws Exception {
        server.stop();
    }

    public static void main(final String[] args) throws Exception {
        Base.open("com.mysql.jdbc.Driver",
                  "jdbc:mysql://localhost/bank",
                  "teller", "password");
        new AtmServer(9988, new CashSlot(), new Account()).start();
    }
}
