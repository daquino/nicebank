package com.refactify.nicebank;

public final class Money {
    private final int dollars;
    private final int cents;

    public Money() {
        this.dollars = 0;
        this.cents = 0;
    }

    public Money(final String amount) {
        String[] amountComponents = amount.replace("$","").replace("-", "").replace("+", "").split("\\.");
        this.dollars = Integer.parseInt(amountComponents[0]);
        this.cents = Integer.parseInt(amountComponents[1]);
    }

    public Money(final int dollars, final int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public int dollars() {
        return dollars;
    }

    public int cents() {
        return cents;
    }

    public Money add(final Money amount) {
        int newCents = cents + amount.cents();
        int newDollars = dollars + amount.dollars();

        if(newCents >= 100) {
            newCents -= 100;
            newDollars++;
        }

        return new Money(newDollars, newCents);
    }

    public Money minus(Money amount){
        int newCents = cents - amount.cents();
        int newDollars = dollars - amount.dollars();

        if (newCents < 0){
            newCents += 100;
            newDollars--;
        }

        return new Money(newDollars, newCents);
    }

    @Override
    public boolean equals(final Object other) {
        boolean equal = false;

        if(other instanceof Money) {
            Money otherMoney = (Money) other;
            equal = (this.dollars() == otherMoney.dollars()
                    && this.cents() == otherMoney.cents());
        }

        return equal;
    }

    @Override
    public String toString() {
        return String.format("$%01d.%02d", this.dollars(), this.cents());
    }
}
