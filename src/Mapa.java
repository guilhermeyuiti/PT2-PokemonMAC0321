import java.util.Random;

public class Mapa {
	
	static int posicaoXatual=0, posicaoYatual=0;
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


	public static int gerarMapa() {
		int max=1;
	    int min=0;
	    int diff=max-min;
	    Random rn = new Random();
	    int i = rn.nextInt(diff+1);
	    i+=min;
	    return i;
	}
	
	public void imprimemapa() {
		int i;
		int j;
		for ( i=0; i<10; i++) {
			for (j=0; j<10; j++) {
				if (mapa[i][j]==0 && (i!=posicaoXatual || j!=posicaoYatual))
					System.out.print("FLOOR ");
				if (i==posicaoXatual && j==posicaoYatual)
					System.out.print("  X   ");
				if (mapa[i][j]==1 && (i!=posicaoXatual || j!=posicaoYatual))
					System.out.print("GRASS ");

			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public void direita(){
		if(posicaoYatual<9) {
			posicaoYatual++;
		}
		else {
			System.out.println("Você não pode andar para a direita!");
		}
		imprimemapa();
	}
	
	public void esquerda(){
		if(posicaoYatual>0) {
			posicaoYatual--;
		}
		else {
			System.out.println("Você não pode andar para a esquerda!");
		}
		imprimemapa();
	}
	
	public void cima(){
		if(posicaoXatual>0) {
			posicaoXatual--;
		}
		else {
			System.out.println("Você não pode andar para cima!");
		}
		imprimemapa();
	}
	
	public void baixo(){
		if(posicaoXatual<9) {
			posicaoXatual++;
		}
		else {
			System.out.println("Você não pode andar para baixo!");
		}
		imprimemapa();
	}
	
	
	
}
