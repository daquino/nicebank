package com.refactify.nicebank;

import cucumber.api.java.*;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class BackgroundProcessorHooks {
    private Thread transactionProcessorThread;

    @Before(order = 4)
    public void startBackgroundThread() {
        transactionProcessorThread = new Thread() {
            @Override
            public void run() {
                TransactionProcessor processor = new TransactionProcessor();
                processor.process();
            }
        };
        transactionProcessorThread.start();
    }

    @After
    public void stopBackgroundThread() {
        transactionProcessorThread.interrupt();
    }
}
