
public class PassearPeloMapa {
	public static void batalhaComSelvagem(Treinador T, Pokemon P, Pokemon Selvagem) {
		System.out.println("O pokemon de "+T.getNomeTreinador()+ " é "+P.getNomePokemon() +" e seu HP é "+P.getHPPokemon()+ "/"+P.getHPmax());
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
			if (variavelDoSelvagem>=7 && variavelDoSelvagem<=15) {
				System.out.println("A wild Bulbasauro appears");
				batalhaComSelvagem(T, P, Selvagem[1]);
			}
			if (variavelDoSelvagem>=25 && variavelDoSelvagem<=30) {
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
		mp1.imprimemapa(T1);
		
		andar(T1, mp1, 4, PokeDoTreinador, Selvagem[0]);
		mp1.imprimemapa(T1);

		andar(T1, mp1, 4, PokeDoTreinador, Selvagem[0]);
		mp1.imprimemapa(T1);

		andar(T1, mp1, 4, PokeDoTreinador, Selvagem[0]);
		mp1.imprimemapa(T1);

		andar(T1, mp1, 4, PokeDoTreinador, Selvagem[0]);
		mp1.imprimemapa(T1);

		andar(T1, mp1, 4, PokeDoTreinador, Selvagem[0]);
		mp1.imprimemapa(T1);

		andar(T1, mp1, 4, PokeDoTreinador, Selvagem[0]);
		mp1.imprimemapa(T1);


		
		
	
	
	}
}
