
import java.util.Random;
import java.util.Scanner;
public class TicTacToe{

   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If two parameters line  and column
     * are passed, they are used. 
     * Otherwise, a default value is used. Defaults values are also
     * used if the paramters are too small (less than 2).
     * 
     * @param args
     *            command line parameters
     */
     public static void main(String[] args) {

        StudentInfo.display();

        TicTacToeGame game;
        int lines = 3;
        int columns = 3;
        int win = 3;

   
        try{
            if (args.length >= 2) {
                lines = Integer.parseInt(args[0]);
                if(lines<2){
                    System.out.println("Invalid argument, using default...");
                    lines = 3;
                }
                columns = Integer.parseInt(args[1]);
                if(columns<2){
                    System.out.println("Invalid argument, using default...");
                    columns = 3;
                }
            }
            if (args.length >= 3){
                win = Integer.parseInt(args[2]);
                if(win<2){
                    System.out.println("Invalid argument, using default...");
                    win = 3;
                }
            } 
            if (args.length > 3){
                System.out.println("Too many arguments. Only the first 3 are used.");
            } 

        } catch(NumberFormatException e){
            System.out.println("Invalid argument, using default...");
            lines   = 3;
            columns  = 3;
            win = 3;
        }

        
        Player[] players = new Player[2];
        String s2 = "Y";

        
        // YOUR CODE HERE
        

        while (s2.equals("y") || s2.equals("Y")){

            //le premier joueur est initialement choisi au hasard 

            game = new TicTacToeGame(lines,columns,win);
            Random player = new Random();
            int nPlayer = player.nextInt(2);
            if(nPlayer == 1){
                players[0] = new HumanPlayer();
                players[1] = new ComputerRandomPlayer();

            }else{
                players[1] = new HumanPlayer();
                players[0] = new ComputerRandomPlayer();

            }
            
            while (game.getGameState() == GameState.PLAYING) {
                
                if(game.getLevel() % 2 == 0) {
                    players[0].play(game);   
                }else {
                    System.out.println("other player to play ");
                    players[1].play(game);
                }
                
                GameState st= game.getGameState();
            
                if(st == GameState.XWIN) {
                    System.out.println("X win");
                }else if(st== GameState.OWIN) {
                    System.out.println("O win");
                }else if(st == GameState.DRAW ) {
                    System.out.println("Draw");
                }
            }

            //Si le jeu est términé on affiche la grille du jeu
            if (game.getGameState() != GameState.PLAYING){
                System.out.println("Game over");
                System.out.println(game.toString());
            }


            //Demande au joueur si il veut jouer une nouvelle partie
            System.out.print("Do you want to continue playing?(Y or N): ");
            Scanner s = new Scanner(System.in);
            s2 = s.nextLine();
        }

    }

}