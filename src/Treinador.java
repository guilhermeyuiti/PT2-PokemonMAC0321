import java.util.Random;

abstract class Treinador {
	private String pokemon;  //nome do pokemon do treinador
	private String treinador;  //nome do treinador
	private boolean continuaBatalha=true; //variavel pra indicar fuga ou continuidade do treinador na batalha
	private int posicaoYatual, posicaoXatual;//variaveis que indicam a localizacao do treinador no mapa
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
	
	public boolean capturaPokemon (Pokemon Selvagem) {  //captura de pokemon utilizando uma pokebola
		int max=255;
	    int min=0;
	    int diff=max-min;		  
	    Random rn = new Random();
	    int m = rn.nextInt(diff+1);
		m+=min;
		System.out.println("O treinador "+treinador+" usou uma pokebola no pokemón "+Selvagem.getNomePokemon());
		System.out.println("3, 2, 1...");
		int f = (Selvagem.getHPmax()*255*4)/(Selvagem.getHPPokemon()*12);   // fórmula obtida no site Bulbapédia
		if (f>=m) { // se o pokemón foi pego, ele deve ser adicionado aos pokemóns do treinador (com a vida máxima)
			System.out.println("O pokemón selvagem "+Selvagem.getNomePokemon()+" foi capturado!!");
			Selvagem.SetHP(Selvagem.getHPmax()-Selvagem.getHPPokemon()); //vida máxima ao pokemón selvagem caso ele tenha sido capturado
			return true;
		}
		else {
			System.out.println("O pokemón selvagem "+Selvagem.getNomePokemon()+" não foi capturado!");
		}
		return false;
	}

}
