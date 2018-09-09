package org.speakingcs.designpatterns.visitor;

public class Book implements Visitable {

	private double price;
	private double weight;

	public Book(double price, double weight) {
		this.price = price;
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
