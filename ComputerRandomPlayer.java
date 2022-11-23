import java.util.Random;

public class ComputerRandomPlayer implements Player{

	public void play(TicTacToeGame p){

		GameState s= p.getGameState();
	    
	    //elle vérifie d’abord que la partie est effectivement jouable
		
		if(!(s==GameState.PLAYING)){
			System.out.println("Erreur");
		
		}else{
			    // choisit au hasard le coup suivant
				Random rand = new Random();
				int cpu = rand.nextInt(p.lines*p.columns);
				while (p.valueAt(cpu) != CellValue.EMPTY) {
					cpu = rand.nextInt(p.lines*p.columns);
				}
				p.play(cpu);
				
				

	}
	}

}