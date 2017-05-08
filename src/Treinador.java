
abstract class Treinador {
	private String pokemon;  //nome do pokemon do treinador
	private String treinador;  //nome do treinador
	private boolean continuaBatalha=true;
	private int posicaoYatual, posicaoXatual;
	public Treinador (String treinador, String pokemon, int X, int Y) {
		this.treinador=treinador;
		this.pokemon =pokemon;
		posicaoXatual=X;
		posicaoYatual=Y;
	}
	
	public boolean getContinuaBatalha() {
		return continuaBatalha;
	}
	
	public boolean setContinuaBatalha(boolean a) {
		return continuaBatalha=a;
	}
	
	abstract boolean usaritem(Pokemon P);
	
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
	
	//METODOS PARA ANDAR
	public boolean direita(){
		if(posicaoYatual<9) {
			++posicaoYatual;
			System.out.println(treinador+" andou para a direita!");
			return true;
		}
		else {
			System.out.println(treinador+" não pode andar para a direita!");
			return false;
		}
	}
	
	public boolean esquerda(){
		if(posicaoYatual>0) {
			--posicaoYatual;
			System.out.println(treinador+" andou para a esquerda!");
			return true;
		}
		else {
			System.out.println(treinador+" não pode andar para a esquerda!");
			return false;
		}
	}
	
	public boolean cima(){
		if(posicaoXatual>0) {
			--posicaoXatual;
			System.out.println(treinador+" andou para cima!");
			return true;
		}
		else {
			System.out.println(treinador+" não pode andar para cima!");
			return false;
		}

	}
	
	public boolean baixo(){
		if(posicaoXatual<9) {
			++posicaoXatual;
			System.out.println(treinador+" andou para baixo!");
			return true;
		}
		else {
			System.out.println(treinador+" não pode andar para baixo!");
			return false;
		}
	}

}
