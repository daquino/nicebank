package com.refactify.nicebank;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class WithdrawalServlet extends HttpServlet {
    private final CashSlot cashSlot;
    private final Account account;
    public WithdrawalServlet(final CashSlot cashSlot, final Account account) {
        this.cashSlot = cashSlot;
        this.account = account;
    }
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        Teller teller = new AutomatedTeller(cashSlot);
        int amount = Integer.parseInt(request.getParameter("amount"));
        teller.withdrawFrom(account, amount);
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<html><head><title>Nice Bank ATM</title></head>" +
                                             "<body>Please take your $" + amount + "</body>" +
                                             "</html>");
    }
}
