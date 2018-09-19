package org.speakingcs.corejava.io;

import java.io.Console;

public class Echo {

    public static void main(String[] args) {
        // get teh System console object

        Console console = System.console();
        if(console == null) {
            System.err.println("Cannot retrieve console object - are you running your application from an IDE? Exiting teh application ...");
            System.exit(-1); // terminate the application

        }
        //read the line and print it through printf
        console.printf(console.readLine());
    }
}
