import game.Game;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriftMonkey {
	
	/*
	 * using this to run my 'Game'
	 */
	
    public static void main(String[] args) throws IOException {
    	
    	/*
    	 * BufferReadder will continue to take/display input/outputs
    	 * as the game is running.
    	 * 
    	 */
    	
        BufferedReader in;
        String input;
        String output;
        
        /*
         * init game to start prog
         */
        
        Game game = new Game();
        
        /*
         * user input is stored 
         */
        in = new BufferedReader(new InputStreamReader(System.in));
        // calls showIntro constructor to display and instruct player with instructions
        game.showIntro();
        game.showCurrR();
        // loop that places action marker
        // as well as 
        do {
            System.out.print("> ");
            input = in.readLine();
            output = game.RunCommand(input);
            System.out.println(output);
            
        } while (!"q".equals(input));
    }

}

