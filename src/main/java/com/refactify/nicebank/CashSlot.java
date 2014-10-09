package com.refactify.nicebank;

public class CashSlot {
    private int contents;
    public int contents() {
        return contents;
    }

    public void dispense(final int dollars) {
        contents = dollars;
    }
}
