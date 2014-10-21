package com.refactify.nicebank;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:cucumber.xml")
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
