package veiculos;

public class veiculosInfo {
	private int id;
	private String placa;
	private String nome;
	private String marca;
	private String valor; 
	
	public veiculosInfo(){
		
	}
	
	public veiculosInfo(int id, String placa, String nome, String marca, String valor){
		this.setId(id);
		this.setPlaca(placa);
		this.setNome(nome);
		this.setMarca(marca);
		this.setValor(valor);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
