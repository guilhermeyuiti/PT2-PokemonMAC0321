
public class PassearPeloMapa {
	public static void batalhaComSelvagem(Treinador T, Pokemon P, Pokemon Selvagem) {
		System.out.println("O pokemon de "+T.getNomeTreinador()+ " é "+P.getNomePokemon() +" e seu HP é "+P.getHPPokemon()+ "/"+P.getHPmax());
	}
	public static void main(String[] args) {
		Mapa mp1 = new Mapa();
		Mapa mp2 = new Mapa();
		Ash T1 = new Ash();
		mp1.imprimemapa(T1);
		//mp2.imprimemapa();
		T1.direita(mp1);
		T1.direita(mp1);
		mp1.imprimemapa(T1);
		


	
	}
}
