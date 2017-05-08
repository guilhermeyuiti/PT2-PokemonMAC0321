import java.util.Random;

public class PassearPeloMapa {
	
	public static int gerarAtaqueRandomico() {
		int max=4;
	    int min=1;
	    int diff=max-min;
	    Random rn = new Random();
	    int i = rn.nextInt(diff+1);
	    i+=min;
	    return i;
	}
	
	public static int gerarAcaoRandomico() {
		int max=100;
	    int min=1;
	    int diff=max-min;
	    Random rn = new Random();
	    int i = rn.nextInt(diff+1);
	    i+=min;
	    return i;
	}
	
	
	public static void batalha(Treinador A, Pokemon PA, Pokemon Selvagem, int i, int j){ // i e j guardam a posicao do pokemon atual
		int numerodoataque=gerarAtaqueRandomico();
		int variaveldeacao =gerarAcaoRandomico();
		//se pokemon esta vivo e treinador nao fugiu e selvagem nao fugiu, ataque DO TREINADOR
		if (PA.vivoOuMorto() == true && A.getContinuaBatalha()==true){
			if (variaveldeacao>=1 && variaveldeacao<=30){
				System.out.println("O treinador "+A.getNomeTreinador()+" irá atacar com o pokemón "+PA.getNomePokemon()+"!");
				System.out.println("O treinador irá usar "+PA.imprimeAtaque(numerodoataque));
				System.out.println();
				PA.pokemonAtaca(numerodoataque, Selvagem); 
			//dps de cada ataque devemos checar se o pokemon que recebeu o ataque nao morreu
				if (Selvagem.vivoOuMorto()==false)
					System.out.println("O pokemon selvagem "+Selvagem.getNomePokemon()+" morreu!");			
			if (variaveldeacao>=31 && variaveldeacao<=50 )
				A.setContinuaBatalha(false); //O TREINADOR FOGE DA BATALHA
				
			if (variaveldeacao>=51 && variaveldeacao<=100) {
				if (A.usaritem(PA)==false) {
					System.out.println("O treinador "+A.getNomeTreinador()+" irá atacar com o pokemón "+PA.getNomePokemon()+"!");
					System.out.println("O treinador irá usar "+PA.imprimeAtaque(numerodoataque));
					System.out.println();
					PA.pokemonAtaca(numerodoataque, Selvagem); 
					if (Selvagem.vivoOuMorto()==false)
						System.out.println("O treinador "+A.getNomeTreinador()+" venceu a batalha!!");				}
				
			}
			
		}
		System.out.println();
		variaveldeacao =gerarAcaoRandomico();
		numerodoataque=gerarAtaqueRandomico();
		//se pokemon esta vivo e treinador nao fugiu e selvagem nao fugiu, ataque DO SELVAGEM
		if (Selvagem.vivoOuMorto() == true /*&& A.getContinuaBatalha()==true*/){
			if(variaveldeacao>=1 && variaveldeacao<=89){
				System.out.println("O pokemon selvagem "+Selvagem.getNomePokemon()+" irá atacar!");
				System.out.println("O pokemon irá usar "+Selvagem.imprimeAtaque(numerodoataque));
				System.out.println();
				Selvagem.pokemonAtaca(numerodoataque, PA);
				if (PA.vivoOuMorto()==false)
					System.out.println("O pokemón selvagem "+Selvagem.getNomePokemon()+" venceu a batalha!!");
			}
			if (variaveldeacao>=90 && variaveldeacao<=100)
				Selvagem.setContinuaBatalha(false); //O POKEMON SELVAGEM FOGE DA BATALHA
			}
		}
		System.out.println();
		
		if (A.getContinuaBatalha()==false) {
			System.out.println("O treinador "+A.getNomeTreinador()+" fugiu!");
			System.out.println("O treinador "+Selvagem.getNomePokemon()+" venceu a batalha!!");
		}
		//POKEMON SELVAGEM FOGE
		if (Selvagem.getContinuaBatalha()==false) {
			System.out.println("O pokemón selvagem "+Selvagem.getNomePokemon()+" fugiu!");
			System.out.println("O treinador "+A.getNomeTreinador()+" venceu a batalha!!");
		}
		
	}
	

	
	
	public static void batalhaComSelvagem(Treinador T, Pokemon P, Pokemon Selvagem) {
		System.out.println("O pokemon de "+T.getNomeTreinador()+ " é "+P.getNomePokemon() +" e seu HP é "+P.getHPPokemon()+ "/"+P.getHPmax());
		System.out.println("O pokemon selvagem "+Selvagem.getNomePokemon()+" tem "+Selvagem.getHPPokemon()+"/"+Selvagem.getHPmax()+" de HP");
		while (T.getContinuaBatalha()==true && Selvagem.getContinuaBatalha()==true && P.getHPPokemon()>0 && Selvagem.getHPPokemon()>0) {
			batalha(T, P, Selvagem, 0, 0);
		}
		Selvagem.SetHP(Selvagem.getHPmax()-Selvagem.getHPPokemon()); //Após cada batalha com o treinador, o pokemon selvagem fica com a vida cheia
																	// para poder combater com outros treinadores e estar com a vida maxima
		Selvagem.setContinuaBatalha(true);
	}
	
	public static void andar(Treinador T, Mapa mp, int acao, Pokemon Selvagem[], Pokemon P) {
		int variavelDoSelvagem = mp.selvagemAparece(T);
		boolean tCima=false, tBaixo=false, tEsquerda=false, tDireita=false;
		if (P.getHPPokemon()>0) {
			if (acao==1) {  //CIMA 
				tCima=T.cima();
			}
			
			if (acao==2) {  //BAIXO
				tBaixo=T.baixo();

			}
			if (acao==3) {  //ESQUERDA 
				tEsquerda=T.esquerda();
			}
			if (acao==4) {  //DIREITA
				tDireita=T.direita();
			}
			
			if (acao!=1 && acao!=2 && acao!=3 && acao!=4) {  //ACAO INVALIDA
				System.out.println("Essa ação não é valida!");
			}
			
			
			
			if ((acao==1 && tCima==true) || (acao==2 && tBaixo==true) || (acao==3 && tEsquerda==true) || (acao==4 && tDireita==true)) {
				if (variavelDoSelvagem>=0 && variavelDoSelvagem<=46 && mp.getMapa(T.getPosicaoXatual(), T.getPosicaoYatual())==1) {   // MUDAR OS INTERVALOS PARA APARECER MENOS POKEMONS
					System.out.println("A wild Pikachu appears");
					batalhaComSelvagem(T, P, Selvagem[0]);
				}
				if (variavelDoSelvagem>=47 && variavelDoSelvagem<=89 && mp.getMapa(T.getPosicaoXatual(), T.getPosicaoYatual())==1) {
					System.out.println("A wild Bulbasauro appears");
					batalhaComSelvagem(T, P, Selvagem[1]);
				}
				if (variavelDoSelvagem>=90 && variavelDoSelvagem<=100 && mp.getMapa(T.getPosicaoXatual(), T.getPosicaoYatual())==1) {
					System.out.println("A wild Charmander appears");
					batalhaComSelvagem(T, P, Selvagem[2]);
				}
			}
		}
		else {
			System.out.println("O treinador "+T.getNomeTreinador()+" deve escolher outro pokemón, pois "+P.getNomePokemon()+" está sem HP!");
		}
		
	}
	
	
	public static void main(String[] args) {
		Mapa mp1 = new Mapa();
		Ash T1 = new Ash();
		Pokemon[] Selvagem = new Pokemon[10];
		Pokemon[] PokeDoTreinador = new Pokemon[10];   // Cada treinador só pode ter um (apenas um) pokemón para batalhar contra selvagens
		Selvagem[0] = new Pikachu();
		Selvagem[1] = new Bulbasaur();
		Selvagem[2] = new Charmander();
		PokeDoTreinador[0]= new Pikachu();
		PokeDoTreinador[1]= new Charmander();
		
		
		mp1.imprimemapa(T1);
		
		
		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);

		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 3, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 3, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 3, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 3, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 3, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 2, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 2, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 2, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 2, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 2, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 2, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 3, Selvagem, PokeDoTreinador[1]);
		mp1.imprimemapa(T1);


	}
}
