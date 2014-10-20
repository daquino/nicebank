package com.refactify.support;

import com.refactify.nicebank.Teller;

public class KnowsTheTeller {
    private Teller teller;
    private MyWebDriver webDriver;

    public Teller getTeller() {
        if(teller == null) {
            teller = new AtmUserInterface(getWebDriver());
        }
        return teller;
    }

    public MyWebDriver getWebDriver() {
        if(webDriver == null) {
            webDriver = new MyWebDriver();
        }
        return webDriver;
    }
}
