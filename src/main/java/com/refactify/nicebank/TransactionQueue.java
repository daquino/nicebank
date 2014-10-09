package com.refactify.nicebank;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.*;

public class TransactionQueue {
    private static String MESSAGES_FOLDER = "./messages";
    private static String MESSAGE_FILE_PATH = "%s/%03d";
    private int nextId = 1;

    public static void clear() {
        try {
            FileUtils.deleteDirectory(new File(MESSAGES_FOLDER));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        new File(MESSAGES_FOLDER).mkdirs();
    }

    public void write(final String transaction) {
        String messageFilePath = String.format(MESSAGE_FILE_PATH, MESSAGES_FOLDER, nextId);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(messageFilePath, "UTF-8");
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println(transaction);
        writer.close();
        nextId++;
    }

    public String read() {
        File messagesFolder = new File(MESSAGES_FOLDER);
        File[] messages = messagesFolder.listFiles();
        String message = "";
        if(messages != null && messages.length > 0) {
            Arrays.sort(messages, new Comparator<File>() {
                @Override
                public int compare(final File f1, final File f2) {
                    return Integer.parseInt(f1.getName()) - Integer.parseInt(f2.getName());
                }
            });
            Scanner scanner = null;
            try {
                scanner = new Scanner(messages[0]);
            }
            catch(FileNotFoundException e) {
                e.printStackTrace();
            }
            message = scanner.nextLine();
            scanner.close();

            messages[0].delete();
        }
        return message;
    }
}
