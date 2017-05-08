
public class PassearPeloMapa {
	public static void batalhaComSelvagem(Treinador T, Pokemon P, Pokemon Selvagem) {
		System.out.println("O pokemon de "+T.getNomeTreinador()+ " é "+P.getNomePokemon() +" e seu HP é "+P.getHPPokemon()+ "/"+P.getHPmax());
	}
	
	public static Pokemon andar(Treinador T, Mapa mp, int acao, Pokemon P[]) {
		if (acao==1) {  //CIMA 
			if (T.cima()==true)
			System.out.println(mp.selvagemAparece(T));
			if (mp.selvagemAparece(T)>=0 && mp.selvagemAparece(T)<=6) {
				System.out.println("A wild Pikachu appears");
				return P[0];
			}
			if (mp.selvagemAparece(T)>=7 && mp.selvagemAparece(T)<=15) {
				System.out.println("A wild Bulbasauro appears");
				return P[1];
			}
			if (mp.selvagemAparece(T)>=25&& mp.selvagemAparece(T)<=35) {
				System.out.println("A wild Charmander appears");
				return P[2];
			}
		}
		
		if (acao==2) {  //BAIXO
			if (T.baixo()==true)
				System.out.println(mp.selvagemAparece(T));

		}
		if (acao==3) {  //ESQUERDA 
			if (T.esquerda()==true)
			System.out.println(mp.selvagemAparece(T));

		}
		if (acao==4) {  //DIREITA
			if (T.direita()==true)
			System.out.println(mp.selvagemAparece(T));

		}
		if (acao!=1 && acao!=2 && acao!=3 && acao!=4) {
			System.out.println("Essa ação não é valida!");
		}
		return P[0];
	}
	public static void main(String[] args) {
		Mapa mp1 = new Mapa();
		Ash T1 = new Ash();
		Pokemon[] P = new Pokemon[3];
		P[0] = new Pikachu();
		P[1] = new Bulbasaur();
		P[2] = new Charmander();
		
		
		

		mp1.imprimemapa(T1);
		
	
	
	}
}
