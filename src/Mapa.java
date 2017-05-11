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
	
	public int gerarMapa() { //gera 0 ou 1, sendo GRASS (1) e FLOOR (0) de forma randômica
		int max=1;
	    int min=0;
	    int diff=max-min;
	    Random rn = new Random();
	    int i = rn.nextInt(diff+1);
	    i+=min;
	    return i;
	}
	
	public void imprimemapa(Treinador T) { //imprime mapa com FLOOR ou GRASS ou X (posição atual do treinador)
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
		System.out.println();   //pulou-se essas linhas para as impressões ficarem visualmente melhores
		System.out.println();
		System.out.println();
	}
	
	public int gerarSelvagemRandomico() {  //gera numero entre 0 e 100 para se definir qual pokemón irá aparecer no mapa
		int max=100;
	    int min=0;
	    int diff=max-min;
	    Random rn = new Random();
	    int i = rn.nextInt(diff+1);
	    i+=min;
	    return i;
	}
	
	public int selvagemAparece(Treinador T) {
		//se no mapa for 1 (grama), gera um número randômico que é usado na passear pelo mapa para colocar um pokemon selvagem aleatório no mapa
		if (mapa[T.getPosicaoXatual()][T.getPosicaoYatual()] == 1) {
			return gerarSelvagemRandomico();
		}
		else return -1; // convenção caso o pokemon selvagem não aparecer
	}
	
}
