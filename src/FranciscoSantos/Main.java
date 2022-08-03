package FranciscoSantos;

public class Main {
	private static Principal principal;
	public static void main(String[] args) {
		principal = new Principal();
		principal.win();
	}
	
	public Principal getWindow() {
		return principal;
	}
}
