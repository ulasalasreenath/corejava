package org.speakingcs.designpatterns.visitor;

public class PostageVisitor implements Visitor {

	private double totalPostageForCart;

	@Override
	public void visit(Book book) {
			totalPostageForCart += book.getPrice();
	}

	public double getTotalPostage() {
		return totalPostageForCart;
	}

}
