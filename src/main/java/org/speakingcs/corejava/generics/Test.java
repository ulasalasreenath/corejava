package org.speakingcs.corejava.generics;

import java.util.ArrayList;
import java.util.List;

public class Test {

    //List<Integer>
    //T[] genericArray; cannot create generic arrays of type T
    //List<String>[] stringList = new ArrayList<String>[1]; error generic array creation
    List<String>[] stringList = null; // no error

}
