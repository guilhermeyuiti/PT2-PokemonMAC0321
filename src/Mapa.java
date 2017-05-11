import java.util.Random;

public class Mapa {
	//cria-se um mapa de forma randomica com 1s e 0s ao chamar o metodo gerarMapa
	private int mapa[][]= {
			{gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa()},
			{gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa()},
			{gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa()},
			{gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa()},
			{gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa()},
			{gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa()},
			{gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa()},
			{gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa()},
			{gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa()},
			{gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa(), gerarMapa()},
            };

	public int getMapa(int x, int y){
		return mapa[x][y]; //metodo para avaliar em passearpelomapa se na posicao temos chao ou grama
	}
	
	public int gerarMapa() {
		int max=1;
	    int min=0;
	    int diff=max-min;
	    Random rn = new Random();
	    int i = rn.nextInt(diff+1);
	    i+=min;
	    return i;
	}
	
	public void imprimemapa(Treinador T) {
		int i;
		int j;
		for ( i=0; i<10; i++) {
			for (j=0; j<10; j++) {
				if (mapa[i][j]==0 && (i!=T.getPosicaoXatual() || j!=T.getPosicaoYatual()))
					System.out.print("FLOOR ");
				if (i==T.getPosicaoXatual() && j==T.getPosicaoYatual())
					System.out.print("  X   ");
				if (mapa[i][j]==1 && (i!=T.getPosicaoXatual() || j!=T.getPosicaoYatual()))
					System.out.print("GRASS ");

			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	public int gerarSelvagemRandomico() {
		int max=100;
	    int min=0;
	    int diff=max-min;
	    Random rn = new Random();
	    int i = rn.nextInt(diff+1);
	    i+=min;
	    return i;
	}
	
	//Pikachu P1 = new Pikachu ();
	public int selvagemAparece(Treinador T) {
		//se no mapa for 1 (grama), gera um numero randomico que eh usado na passear pelo mapa para colocar um pokemon selvagem aleatorio no mapa
		if (mapa[T.getPosicaoXatual()][T.getPosicaoYatual()] == 1) {
			return gerarSelvagemRandomico();
		}
		else return -1;
	}
	
}
