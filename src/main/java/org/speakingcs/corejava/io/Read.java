package org.speakingcs.corejava.io;

import java.io.IOException;

public class Read {


    public static void main(String[] args) {
        System.out.println("Type a character: ");
        int val = 0;
        try {

            // the return type of read is int, but it returns a byte value!
            val = System.in.read();

        }catch (IOException ioe) {

        }

    }

}
