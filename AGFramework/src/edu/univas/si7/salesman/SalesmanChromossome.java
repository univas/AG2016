package edu.univas.si7.salesman;

import edu.univas.si7.ag.Chromossome;

public class SalesmanChromossome extends Chromossome {

	private String nome;
	private float x;
	private float y;

	public SalesmanChromossome(String nome, float x, float y) {
		super();
		this.nome = nome;
		this.x = x;
		this.y = y;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
}
