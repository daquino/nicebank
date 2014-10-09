package com.refactify.nicebank;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AtmServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<html><head><title>Nice Bank ATM</title></head></html>" +
                                             "<body><form action=\"withdraw\" method=\"post\">" +
                                             "<label for=\"amount\">Amount</label>" +
                                             "<input type=\"text\" id=\"amount\" name=\"amount\"/>" +
                                             "<button type=\"submit\" id=\"withdraw\">Withdraw</button>" +
                                             "</form></body></html>");
    }
}
