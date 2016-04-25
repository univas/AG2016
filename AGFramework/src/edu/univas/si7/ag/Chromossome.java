package edu.univas.si7.ag;

public abstract class Chromossome {

	public abstract void doMutation();
	
	@Override
	public abstract String toString();
	
	@Override
	public abstract boolean equals(Object obj);
}
