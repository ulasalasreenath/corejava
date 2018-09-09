package org.speakingcs.generics;

public class OrderedPair<K, V> implements Pair<K, V> {

	private K key;
	private V value;

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

}
