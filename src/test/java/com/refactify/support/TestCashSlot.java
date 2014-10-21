package com.refactify.support;

import com.refactify.nicebank.CashSlot;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class TestCashSlot extends CashSlot {
}
