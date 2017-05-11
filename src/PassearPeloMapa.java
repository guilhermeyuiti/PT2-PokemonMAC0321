import java.util.Random;

public class PassearPeloMapa {

	/*criou-se metodos para gerar numeros randomicos para que a selecao de movimentos e acoes nao fosse fixa e houvesse uma probabilidade de 
	ocorrerem */
	public static int gerarAtaqueRandomico() {
		int max=4;
	    int min=1;
	    int diff=max-min;
	    Random rn = new Random();
	    int i = rn.nextInt(diff+1);
	    i+=min;
	    return i;
	}
	
	public static int gerarAcaoRandomico() { //gera número aleatório entre 1 e 100 para definir o que cada treinador ou pokemon selvagem faz
		int max=100;
	    int min=1;
	    int diff=max-min;
	    Random rn = new Random();
	    int i = rn.nextInt(diff+1);
	    i+=min;
	    return i;
	}
	
	public static int gerarMovimentoRandomico() { //gera numero aleatorio entre 1 e 4 para definir qual o movimento do treinador (cima, baixo, esquerda ou direita)
		int max=4;
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
			if (variaveldeacao>=1 && variaveldeacao<=59){
				System.out.println("O treinador "+A.getNomeTreinador()+" irá atacar com o pokemón "+PA.getNomePokemon()+"!");
				System.out.println("O treinador irá usar "+PA.imprimeAtaque(numerodoataque));
				System.out.println();
				PA.pokemonAtaca(numerodoataque, Selvagem); 
				
				//dps de cada ataque devemos checar se o pokemon que recebeu o ataque nao morreu
				if (Selvagem.vivoOuMorto()==false) {
					System.out.println("O pokemon selvagem "+Selvagem.getNomePokemon()+" morreu!");			
				}
			}
				
				
			if (variaveldeacao>=60 && variaveldeacao<=90 ) {
				A.setContinuaBatalha(false); //O TREINADOR FOGE DA BATALHA
			}
			
				
			if (variaveldeacao>=91 && variaveldeacao<=100) {
				//nao se pode usar item se o pokemon ja morreu ou se seu HP vai exceder o maximo, caso isso ocorra vai para ATAQUE DO TREINADOR
				if (A.usaritem(PA)==false) {
					System.out.println("O treinador "+A.getNomeTreinador()+" irá atacar com o pokemón "+PA.getNomePokemon()+"!");
					System.out.println("O treinador irá usar "+PA.imprimeAtaque(numerodoataque));
					System.out.println();
					PA.pokemonAtaca(numerodoataque, Selvagem); 
					if (Selvagem.vivoOuMorto()==false)
						System.out.println("O treinador "+A.getNomeTreinador()+" venceu a batalha!!");	
				}
				
			}
			A.capturaPokemon(Selvagem);
		}
		System.out.println();
		variaveldeacao =gerarAcaoRandomico();  //variaveldeacao recebe outro número para definir ação diferente da anterior
		numerodoataque=gerarAtaqueRandomico();  //numerodoataque recebe outro número para definir ataque diferente do anterior
		//se pokemon esta vivo e treinador nao fugiu e selvagem nao fugiu, ataque DO SELVAGEM
		if (Selvagem.vivoOuMorto() == true && A.getContinuaBatalha()==true){
			if(variaveldeacao>=1 && variaveldeacao<=89){
				System.out.println("O pokemon selvagem "+Selvagem.getNomePokemon()+" irá atacar!");
				System.out.println("O pokemon irá usar "+Selvagem.imprimeAtaque(numerodoataque));
				System.out.println();
				Selvagem.pokemonAtaca(numerodoataque, PA);
				if (PA.vivoOuMorto()==false) {
					System.out.println("O pokemón selvagem "+Selvagem.getNomePokemon()+" venceu a batalha!!");
				}
			}
			if (variaveldeacao>=90 && variaveldeacao<=100) {
				Selvagem.setContinuaBatalha(false); //O POKEMON SELVAGEM FOGE DA BATALHA
			}
		}
		System.out.println();
		
		if (A.getContinuaBatalha()==false) {  //treinador foge e pokemón selvagem vence a batalha
			System.out.println("O treinador "+A.getNomeTreinador()+" fugiu!");
			System.out.println("O pokemón selvagem "+Selvagem.getNomePokemon()+" venceu a batalha!!");
			System.out.println();
		}
		//POKEMON SELVAGEM FOGE
		if (Selvagem.getContinuaBatalha()==false) { //pokemón selvagem foge e treinador vence a batalha
			System.out.println("O pokemón selvagem "+Selvagem.getNomePokemon()+" fugiu!");
			System.out.println("O treinador "+A.getNomeTreinador()+" venceu a batalha!!");
			System.out.println();
		}
		
	}
	

	public static void batalhaComSelvagem(Treinador T, Pokemon P, Pokemon Selvagem) { //metodo chamado caso o treinador encontre um pokemón selvagem
		System.out.println("O pokemon de "+T.getNomeTreinador()+ " é "+P.getNomePokemon() +" e seu HP é "+P.getHPPokemon()+ "/"+P.getHPmax());
		System.out.println("O pokemon selvagem "+Selvagem.getNomePokemon()+" tem "+Selvagem.getHPPokemon()+"/"+Selvagem.getHPmax()+" de HP");
		while (T.getContinuaBatalha()==true && Selvagem.getContinuaBatalha()==true && P.getHPPokemon()>0 && Selvagem.getHPPokemon()>0) {
			batalha(T, P, Selvagem, 0, 0);
		}
		Selvagem.SetHP(Selvagem.getHPmax()-Selvagem.getHPPokemon()); //Após cada batalha com o treinador, o pokemon selvagem fica com a vida cheia para poder combater com outros treinadores e estar com a vida máxima
		Selvagem.setContinuaBatalha(true);
		T.setContinuaBatalha(true);
	}
	
	public static void andar(Treinador T, Mapa mp, int acao, Pokemon Selvagem[], Pokemon P) {  //muda a posicao do treinador no mapa (caso seja possível) com base nas ações solicitadas
		int variavelDoSelvagem = mp.selvagemAparece(T);
		boolean tCima=false, tBaixo=false, tEsquerda=false, tDireita=false;
		//so pode escolher um pokemon para batalhar se ele tem HP
		if (P.getHPPokemon()>0) {
			
			// cada número foi associado a uma direção e assim chama-se os métodos que foram definidos na classe treinador
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
				//os intervalos indicam a probabilidade de um pokemon aparecer aonde tem grama (definida pelo numero 1)
				if (variavelDoSelvagem>=0 && variavelDoSelvagem<=46 && mp.getMapa(T.getPosicaoXatual(), T.getPosicaoYatual())==1) {   
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
	
	public static void batalha (Treinador T, Mapa mp, Pokemon Selvagem[], Pokemon PokeDoTreinador[]) { //inicia a batalha/movimentos do treinador
		int i=0, movimentoRandomico=0;
		System.out.println("O treinador "+T.getNomeTreinador()+" irá começar a andar no mapa!!!");
		mp.imprimemapa(T);
		System.out.println("-----------------------------------------------------------");
		while (i<6) { /* 6 é o numero maximo de pokemons do treinador*/
			movimentoRandomico=gerarMovimentoRandomico();
			andar (T, mp, movimentoRandomico, Selvagem, PokeDoTreinador[i]);
			mp.imprimemapa(T);
			System.out.println("-----------------------------------------------------------");
			if (PokeDoTreinador[i].getHPPokemon()<=0)
				i++; //o contador aumenta com a morte do pokemon
		}
	}
	
	public static void main(String[] args) {
		//como utilizou-se randomico na geracao do mapa, os objetos mapas serao diferentes, assim mp1 != mp2 
		Mapa mp1 = new Mapa();
		Mapa mp2 = new Mapa();
		Ash T1 = new Ash();
		Ash T2 = new Ash();
		Pokemon[] Selvagem = new Pokemon[6]; //pokemóns Selvagens que podem aparecer no mapa
		Pokemon[] PokeDoTreinador = new Pokemon[6];   // Cada treinador pode ter ate 6 pokemóns
		Pokemon[] PokeDoTreinador2 = new Pokemon[6];  
		Selvagem[0] = new Pikachu();   
		Selvagem[1] = new Bulbasaur();
		Selvagem[2] = new Charmander();
		Selvagem[3] = new Pikachu();
		Selvagem[4] = new Bulbasaur();
		Selvagem[5] = new Charmander();
		PokeDoTreinador[0]= new Pikachu();
		PokeDoTreinador[1]= new Charmander();
		PokeDoTreinador[2]= new Pikachu();
		PokeDoTreinador[3]= new Charmander();
		PokeDoTreinador[4]= new Charmander();
		PokeDoTreinador[5]= new Pikachu();
		PokeDoTreinador2[0]= new Pikachu();
		PokeDoTreinador2[1]= new Charmander();
		PokeDoTreinador2[2]= new Pikachu();
		PokeDoTreinador2[3]= new Charmander();
		PokeDoTreinador2[4]= new Charmander();
		PokeDoTreinador2[5]= new Pikachu();
		
		
		batalha (T1, mp1, Selvagem, PokeDoTreinador);
		batalha (T2, mp2, Selvagem, PokeDoTreinador2);

/*
 
 :::,
 '::::'._
   '.    '.                        __.,,.
     '.    '.                _..-'''':::"
       \     \,.--""""--.,-''      _:'
   /\   \  .               .    .-'
  /  \   \                   ':'
 /    \  :                     :
/      \:                       :
\       :                       :
 \      :      ,--,         ,-,  :
  \    :      |(_):|       |():| :
   \   :     __'--'   __    '-'_  :
    \  :    /  \      \/      / \ :
     \  :  (    )             \_/ :
  .-'' . :  \__/   '--''--'      :
  \  . .-:'.                   .:
   \' :| :  '-.__      ___...-' :
    \::|:        ''''''          '.
  .,:::':  :                       '.
   \::\:   :                         '._
    \::    :     /             '-._     '.
     \:    :    /              .   :-._ :-'
      :    :   /               :   :  ''
      :   .'   )'.             :   :
       :  :  .'   '.          :   :
        : '..'      :      _.' _.:
         '._        :..---'\'''  _)
            '':---''_)      '-'-'
               '-'-'  PIKACHU!  
  
 */

	}
}
