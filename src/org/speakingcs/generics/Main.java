package org.speakingcs.generics;

public class Main {

	public static void main(String[] args) {
		
		Test<Integer> test = new Test<Integer>(15);
		System.out.println(test.getObject());
		
		Test<String> strings = new Test<String>("speaking cs");
		System.out.println(strings.getObject());
		
		Test2<String, Integer> test2 = new Test2<String, Integer>("Speakingcs", 15);
		test2.print();
		
		Test.genericDisplay("Speakingcs");
		
		NaturalNumber<Integer> nn = new NaturalNumber<>();
		
	}

}
