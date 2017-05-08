import java.util.Random;

public class Mapa {
	
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
		return mapa[x][y];
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
		if (mapa[T.getPosicaoXatual()][T.getPosicaoYatual()] == 1) {
			System.out.println("Pokemon selvagem pode aparecer");
			return gerarSelvagemRandomico();
		}
		else return -1;
	}
	
}
