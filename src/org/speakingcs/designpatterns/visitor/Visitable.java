package org.speakingcs.designpatterns.visitor;

// Element interface
public interface Visitable {
	public void accept(Visitor visitor);
}
