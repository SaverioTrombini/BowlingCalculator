package model;

public class Turno {
	
	private int primoTiro;
	private int secondoTiro;
	private boolean strike;
	private boolean spare;
	
	public Turno() {
		this.setPrimoTiro(0);
		this.setSecondoTiro(0);
		this.strike=false;
		this.spare=false;
	}

	public boolean isStrike() {
		return strike;
	}

	public boolean isSpare() {
		return spare;
	}

	public void setStrike(boolean strike) {
		this.strike = strike;
	}

	public void setSpare(boolean spare) {
		this.spare = spare;
	}

	public int getPrimoTiro() {
		return primoTiro;
	}

	public void setPrimoTiro(int primoTiro) {
		this.primoTiro = primoTiro;
	}

	public int getSecondoTiro() {
		return secondoTiro;
	}

	public void setSecondoTiro(int secondoTiro) {
		this.secondoTiro = secondoTiro;
	}	
}
