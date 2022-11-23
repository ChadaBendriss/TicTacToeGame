import java.util.Scanner;

public class HumanPlayer implements Player{
	public void play(TicTacToeGame p){

		GameState st= p.getGameState();
		
		// vérifie d’abord que le jeu est effectivement jouable
		if(!(st==GameState.PLAYING)){
			System.out.println("Erreur");
		}else {

			
	        	
				System.out.println(p.toString());	
				// demande à l’utilisateur une entrée valide


				if(p.nextCellValue()==CellValue.X){
					System.out.print("X to play: ");
				}else{
					System.out.print("O to play: ");
				}
				Scanner input = new Scanner (System.in);
				int pos =input.nextInt();
				pos=pos-1;
				if(pos<0||pos>(p.lines * p.columns)){
					System.out.println("The value should be between 1 and" + p.lines* p.columns);
				}else if(p.valueAt(pos) != CellValue.EMPTY){
					System.out.println("This cell has already been played");
				}else{
					p.play(pos);
				}

				

				if(st == GameState.XWIN) {
					System.out.println("X win");
				}else if(st== GameState.OWIN) {
					System.out.println("O win");
				}else if(st == GameState.DRAW ) {
					System.out.println("Draw");

				}

			
		}
	}
}
			



		
