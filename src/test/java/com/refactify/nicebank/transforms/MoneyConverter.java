package com.refactify.nicebank.transforms;

import com.refactify.nicebank.Money;
import cucumber.api.Transformer;

public class MoneyConverter extends Transformer<Money> {
    @Override
    public Money transform(final String amount) {
        String[] numbers = amount.split("\\.");
        int dollars = Integer.parseInt(numbers[0].replace("$", ""));
        int cents = Integer.parseInt(numbers[1]);
        return new Money(dollars, cents);
    }
}
