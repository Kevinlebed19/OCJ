package com.kevin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UserForm {

    public static void main(String[] u) throws Exception {
        var r = new BufferedReader(
                new InputStreamReader(System.in));
        var w = new BufferedWriter(
                new OutputStreamWriter(System.out));
        try (r) {
            w.write("What is your name? ");
            w.flush();
            r.readLine();
            w.write("Thank you!");
            w.write("Press enter to exit");
            w.flush();
        }
        System.in.read();
    }
}
