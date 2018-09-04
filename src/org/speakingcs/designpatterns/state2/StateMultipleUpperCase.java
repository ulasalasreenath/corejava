package org.speakingcs.designpatterns.state2;

public class StateMultipleUpperCase implements Statelike {

	private int count = 0;

	@Override
	public void writeName(StateContext context, String name) {
		System.out.println(name.toUpperCase());
		if (++count > 1) {
			context.setState(new StateLowerCase());
		}
	}
}
