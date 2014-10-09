package com.refactify.nicebank;

import java.io.*;
import java.util.Scanner;

public class BalanceStore {
    private static String BALANCE_FILE_PATH = "./balance";

    public static void clear() {
        new File(BALANCE_FILE_PATH).delete();
        setBalance(new Money(0,0));
    }

    public static Money getBalance() {
        File balanceFile = new File(BALANCE_FILE_PATH);
        Scanner scanner = null;
        try {
            scanner = new Scanner(balanceFile);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        Money balance = new Money(scanner.nextLine());
        return balance;
    }

    public static void setBalance(final Money newBalance) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(BALANCE_FILE_PATH, "UTF-8");
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println(newBalance.toString());
        writer.close();
    }
}
