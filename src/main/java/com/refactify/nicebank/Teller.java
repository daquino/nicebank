package com.refactify.nicebank;

public interface Teller {
    void withdrawFrom(final Account account, final int amount);
}
