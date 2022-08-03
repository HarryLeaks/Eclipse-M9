package polipackage;

public class Dinamico {
	public static void main(String[] args) {
		Carro veiculo = new Bicicleta();
		veiculo.movimentar(); //Refere-se à bicicleta
		
		veiculo = new Carro();
		veiculo.movimentar(); //Refere-se ao carro
	}
}
