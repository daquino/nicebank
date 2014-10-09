package com.refactify.nicebank;

import cucumber.api.java.*;

public class BackgroundProcessorHooks {
    private Thread transactionProcessorThread;

    @Before
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
