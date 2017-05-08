
abstract class Pokemon {
	//nome do pokemon
		private String nome;
		//cada pokemon tem ate 4 ataques diferentes
		private String ataque[] = new String[4]; 
		//vida do pokemon
		private int HP;
		//cada ataque tem uma quantidade de dano
		private int dano[] = new int[4];
		//cada pokemon tem um tipo
		private String tipo;
		//guardando o maximo de HP do pokemon
		private int HPmax;
		private boolean continuaBatalha=true;
		//construtor
		Pokemon(String nome, int HP, String tipo, String ataque[], int dano[]){
			this.nome = nome;
			this.HPmax = HP;
			this.HP = HP;
			this.tipo = tipo;
			this.ataque[0] = ataque[0];
			this.ataque[1] = ataque[1];
			this.ataque[2] = ataque[2];
			this.ataque[3] = ataque[3];
			this.dano[0] = dano[0];
			this.dano[1] = dano[1];
			this.dano[2] = dano[2];
			this.dano[3] = dano[3];
		}
		
		public boolean getContinuaBatalha() {
			return continuaBatalha;
		}
		
		public boolean setContinuaBatalha() {
			return continuaBatalha=false;
		}
		
		public String getNomePokemon(){
			return nome;
		}
		
		public int getHPPokemon(){
			return HP;
		}
		
		public int getHPmax(){
			return HPmax;
		}
		//metodo para adicionar ou retirar HP de acordo com a batalha
		public int SetHP(int HP){
			this.HP = this.HP + HP;
			return this.HP; 
		}
		//metodo para imprimir os ataques
		public String imprimeAtaque(int num){
			if (num == 1) return ataque[0];
			if (num == 2) return ataque[1];
			if (num == 3) return ataque[2];
			if (num == 4) return ataque[3];
			else return null;
			
		}
		public void pokemonAtaca(int num, Pokemon inimigo){
			if (num == 1){
				if (inimigo.getHPPokemon()-dano[num-1]>0)
					System.out.println("O pokemon "+inimigo.getNomePokemon()+" está com "+inimigo.SetHP(-(dano[num-1]))+"/"+inimigo.getHPmax()+" de HP");
				else
					System.out.println("O pokemon "+inimigo.getNomePokemon()+" ficou com "+inimigo.SetHP(-inimigo.getHPPokemon())+" de HP e morreu!!");

			}
			if (num == 2){
				if (inimigo.getHPPokemon()-dano[num-1]>0)
					System.out.println("O pokemon "+inimigo.getNomePokemon()+" está com "+inimigo.SetHP(-(dano[num-1]))+"/"+inimigo.getHPmax()+" de HP");
				else
					System.out.println("O pokemon "+inimigo.getNomePokemon()+" está com "+inimigo.SetHP(-inimigo.getHPPokemon())+" de HP e morreu!!");
			}
			if (num == 3){
				if (inimigo.getHPPokemon()-dano[num-1]>0)
					System.out.println("O pokemon "+inimigo.getNomePokemon()+" está com "+inimigo.SetHP(-(dano[num-1]))+"/"+inimigo.getHPmax()+" de HP");
				else
					System.out.println("O pokemon "+inimigo.getNomePokemon()+" está com "+inimigo.SetHP(-inimigo.getHPPokemon())+" de HP e morreu!!");
			}
			if (num == 4){
				if (inimigo.getHPPokemon()-dano[num-1]>0)
					System.out.println("O pokemon "+inimigo.getNomePokemon()+" está com "+inimigo.SetHP(-(dano[num-1]))+"/"+inimigo.getHPmax()+" de HP");
				else
					System.out.println("O pokemon "+inimigo.getNomePokemon()+" está com "+inimigo.SetHP(-inimigo.getHPPokemon())+" de HP e morreu!!");
			}
		}
		
		//FUNCAO PRA CHECAR SE ESTA VIVO
		public boolean vivoOuMorto(){
			if (HP>0){
				return true;
			}
			else return false;
		}
}
