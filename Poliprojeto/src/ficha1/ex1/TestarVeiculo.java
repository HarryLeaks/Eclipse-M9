package ficha1.ex1;

public class TestarVeiculo {
	public static void main(String[] args) {
		Veiculo c = new Carro();
		Veiculo b  = new Bicicleta();
		Veiculo m = new Mota();
		Veiculo t = new Trotinete();
		
		c.velocidade();
		b.velocidade();
		m.velocidade();
		t.velocidade();
	}
}
