package ficha1.ex1;

public class Produto {
	private String nome;
	private double preco;
	
	public String getNome() {
		return nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public boolean caro() {
		if(preco > 100) 
			return true;
		else
			return false;
	}
}
