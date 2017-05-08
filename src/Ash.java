
public class Ash extends Treinador {
	Ash(){
		super ("Ash", "Pikachu", 0, 0);
	}
	public boolean usaritem(Pokemon P) {
		//se o pokemon esta vivo e seu HP nao excedera o maximo pode usar item
		if (P.vivoOuMorto() == true && P.getHPPokemon() + 25 <= P.getHPmax()){
			System.out.println("Ash usou um item de cura!");
			P.SetHP(25);
			System.out.println("O pokemón " +P.getNomePokemon()+" recebeu 25 de HP e ficou com "+ P.getHPPokemon()+"/"+P.getHPmax()+" de HP");
			return true;
		}
		//se o pokemon esta vivo e seu HP excedera o maximo NAO pode usar item
		else if (P.vivoOuMorto() == true && P.getHPPokemon() + 25 > P.getHPmax()){
			//System.out.println("Ash tentou usar um item de cura");
			//System.out.println("Ash não pode usar um item de cura pois a vida do pokemón já está alta!");
			return false;
		}
		//se o pokemon esta morto NAO pode usar item
		else if (P.vivoOuMorto() != true){
			//System.out.println("Ash tentou usar um item de cura");
			//System.out.println("Ash não pode usar um item de cura pois o pokemón está morto!");
			return false;
		}
		return true;
	}
	
}
