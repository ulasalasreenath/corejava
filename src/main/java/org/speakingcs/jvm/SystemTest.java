package org.speakingcs.jvm;

import java.util.Properties;

public class SystemTest {

    public static void main(String[] args) {
        Properties properties = System.getProperties();

        // prints all system properties
        for(Object key : properties.keySet()) {
            System.out.println(key);
        }

        // fetch value of system property java.ext.dirs

        System.out.println("location of extension directory " + properties.get("java.ext.dirs"));
    }
}
