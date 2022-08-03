package projeto;

public abstract class Forma {
    private double alt,larg;

	public double getAlt() {
		return alt;
	}

	public double getLarg() {
		return larg;
	}

	public void setAlt(double alt) {
		this.alt = alt;
	}

	public void setLarg(double larg) {
		this.larg = larg;
	}

	public abstract double calcArea();
    
}
