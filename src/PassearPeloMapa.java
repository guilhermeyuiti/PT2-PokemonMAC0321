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
	
	
	public static void batalha(Treinador A, Treinador B, Pokemon PA, Pokemon PB, int i, int j){ // i e j guardam a posicao do pokemon atual
		int numerodoataque=gerarAtaqueRandomico();
		int variaveldeacao =gerarAcaoRandomico();
		if (PA.vivoOuMorto() == true && A.getContinuaBatalha()==true && B.getContinuaBatalha()==true){
			if (variaveldeacao>=1 && variaveldeacao<=59){
				System.out.println("O treinador "+A.getNomeTreinador()+" irá atacar com o pokemón "+PA.getNomePokemon()+"!");
				System.out.println("O treinador irá usar "+PA.imprimeAtaque(numerodoataque));
				System.out.println();
				PA.pokemonAtaca(numerodoataque, PB); 
			//dps de cada ataque devemos checar se o pokemon que recebeu o ataque nao morreu, se morreu devemos listar os pokemons tirando o morto
				vivoOuMorto(A, B, PA, PB, i, j);
			}
			if (variaveldeacao==60 || variaveldeacao==61 )
				A.setContinuaBatalha(); //O TREINADOR FOGE DA BATALHA
			if (variaveldeacao>=62 && variaveldeacao<=90 ) {
				if (A.usaritem(PA)==false) {
					System.out.println("O treinador "+A.getNomeTreinador()+" irá atacar com o pokemón "+PA.getNomePokemon()+"!");
					System.out.println("O treinador irá usar "+PA.imprimeAtaque(numerodoataque));
					System.out.println();
					PA.pokemonAtaca(numerodoataque, PB); 
					vivoOuMorto(A, B, PA, PB, i, j);
				}
				
			}
			if (variaveldeacao>=91 && variaveldeacao<=100) {
				A.trocarpokemon();
				A.setTrocarPokemon(true);
			}
		}
		System.out.println();
		variaveldeacao =gerarAcaoRandomico();
		if (PB.vivoOuMorto() == true && B.getContinuaBatalha()==true && A.getContinuaBatalha()==true){
			if(variaveldeacao>=1 && variaveldeacao<=59){
				System.out.println("O treinador "+B.getNomeTreinador()+" irá atacar com o pokemón "+PB.getNomePokemon()+"!");
				System.out.println("O treinador irá usar "+PB.imprimeAtaque(numerodoataque));
				System.out.println();
				PB.pokemonAtaca(numerodoataque, PA);
				vivoOuMorto(A, B, PA, PB, i, j);
			}
			if (variaveldeacao==60 || variaveldeacao==61)
				B.setContinuaBatalha(); //O TREINADOR FOGE DA BATALHA
			if (variaveldeacao>=62 && variaveldeacao<=90) {
				if (B.usaritem(PB)==false) {
					System.out.println("O treinador "+B.getNomeTreinador()+" irá atacar com o pokemón "+PB.getNomePokemon()+"!");
					System.out.println("O treinador irá usar "+PB.imprimeAtaque(numerodoataque));
					System.out.println();
					PB.pokemonAtaca(numerodoataque, PA); 
					vivoOuMorto(A, B, PA, PB, i, j);
				}
			}
			if (variaveldeacao>=91 && variaveldeacao<=100) {
				B.trocarpokemon();
				B.setTrocarPokemon(true);
			}

		}
		System.out.println();
		
		if (A.getContinuaBatalha()==false) {
			System.out.println("O treinador "+A.getNomeTreinador()+" fugiu!");
			System.out.println("O treinador "+B.getNomeTreinador()+" venceu a batalha!!");
		}
		if (B.getContinuaBatalha()==false) {
			System.out.println("O treinador "+B.getNomeTreinador()+" fugiu!");
			System.out.println("O treinador "+A.getNomeTreinador()+" venceu a batalha!!");
		}
	}
	

	
	
	public static void batalhaComSelvagem(Treinador T, Pokemon P, Pokemon Selvagem) {
		System.out.println("O pokemon de "+T.getNomeTreinador()+ " é "+P.getNomePokemon() +" e seu HP é "+P.getHPPokemon()+ "/"+P.getHPmax());
		System.out.println("O pokemon selvagem "+Selvagem.getNomePokemon()+" tem "+Selvagem.getHPPokemon()+"/"+Selvagem.getHPmax()+" de HP");
		
	}
	
	public static void andar(Treinador T, Mapa mp, int acao, Pokemon Selvagem[], Pokemon P) {
		int variavelDoSelvagem = mp.selvagemAparece(T);
		boolean tCima=false, tBaixo=false, tEsquerda=false, tDireita=false;
		if (acao==1) {  //CIMA 
			tCima=T.cima();
			if (tCima==true)
				System.out.println(variavelDoSelvagem); //REMOVER O PRINT DEPOIS
		}
		
		if (acao==2) {  //BAIXO
			tBaixo=T.baixo();
			if (tBaixo==true)
				System.out.println(variavelDoSelvagem);
		}
		if (acao==3) {  //ESQUERDA 
			tEsquerda=T.esquerda();
			if (tEsquerda==true)
				System.out.println(variavelDoSelvagem);
		}
		if (acao==4) {  //DIREITA
			tDireita=T.direita();
			if (tDireita==true)
				System.out.println(variavelDoSelvagem);
		}
		
		if (acao!=1 && acao!=2 && acao!=3 && acao!=4) {  //ACAO INVALIDA
			System.out.println("Essa ação não é valida!");
		}
		
		
		
		if ((acao==1 && tCima==true) || (acao==2 && tBaixo==true) || (acao==3 && tEsquerda==true) || (acao==4 && tDireita==true)) {
			if (variavelDoSelvagem>=0 && variavelDoSelvagem<=6) {   // MUDAR OS INTERVALOS PARA APARECER MENOS POKEMONS
				System.out.println("A wild Pikachu appears");
				batalhaComSelvagem(T, P, Selvagem[0]);
			}
			if (variavelDoSelvagem>=7 && variavelDoSelvagem<=25) {
				System.out.println("A wild Bulbasauro appears");
				batalhaComSelvagem(T, P, Selvagem[1]);
			}
			if (variavelDoSelvagem>=55 && variavelDoSelvagem<=67) {
				System.out.println("A wild Charmander appears");
				batalhaComSelvagem(T, P, Selvagem[2]);
			}
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
		
		mp1.imprimemapa(T1);
		
		
		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[0]);
		mp1.imprimemapa(T1);

		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[0]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[0]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[0]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[0]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[0]);
		mp1.imprimemapa(T1);
		andar(T1, mp1, 4, Selvagem, PokeDoTreinador[0]);
		mp1.imprimemapa(T1);

	}
}
