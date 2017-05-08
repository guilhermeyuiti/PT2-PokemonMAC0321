
abstract class Treinador {
	private String pokemon;  //nome do pokemon do treinador
	private String treinador;  //nome do treinador
	//private boolean continuaBatalha=true;
	private int posicaoYatual, posicaoXatual;
	public Treinador (String treinador, String pokemon, int X, int Y) {
		this.treinador=treinador;
		this.pokemon =pokemon;
		posicaoXatual=X;
		posicaoYatual=Y;
	}
	
	public String getNomeTreinador() {
		return treinador;
	}
	
	public String getNomePokemon(){
		return pokemon;
	}
	
	public int getPosicaoXatual(){
		return posicaoXatual;
	}
	
	public int getPosicaoYatual(){
		return posicaoYatual;
	}
	
	public void direita(Mapa mp){
		if(posicaoYatual<9) {
			posicaoYatual++;
		}
		else {
			System.out.println("Você não pode andar para a direita!");
		}
		//mp.imprimemapa();
	}
	
	public void esquerda(Mapa mp){
		if(posicaoYatual>0) {
			posicaoYatual--;
		}
		else {
			System.out.println("Você não pode andar para a esquerda!");
		}
		//mp.imprimemapa();
	}
	
	public void cima(Mapa mp){
		if(posicaoXatual>0) {
			posicaoXatual--;
		}
		else {
			System.out.println("Você não pode andar para cima!");
		}
		//mp.imprimemapa();
	}
	
	public void baixo(Mapa mp){
		if(posicaoXatual<9) {
			posicaoXatual++;
		}
		else {
			System.out.println("Você não pode andar para baixo!");
		}
		//mp.imprimemapa();
	}

}
