
abstract class Treinador {
	private String pokemon;  //nome do pokemon do treinador
	private String treinador;  //nome do treinador
	private boolean continuaBatalha=true;
	public Treinador (String treinador, String pokemon) {
		this.treinador=treinador;
		this.pokemon =pokemon;
	}
	
	public String getNomeTreinador() {
		return treinador;
	}
	
	public String getNomePokemon(){
		return pokemon;
	}
	

}
