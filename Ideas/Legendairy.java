import java.io.*;
import java.util.*;


    public class Legendairy{
            
        
        private static final ArrayList<String> stats = new ArrayList();
        private static final ArrayList<String> traits = new ArrayList();
        
        private static ArrayList<String> player = new ArrayList();

        private Character cloud;
        private Character enemy;
        
        private boolean response;
        
        //private InputStreamReader isr;
        //private BufferedReader in;
        
        private Scanner in;
        
        public Legendairy() {
          //  isr = new InputStreamReader( System.in );
	      //  in = new BufferedReader( isr );
	        in = new Scanner(System.in);
	        response = false;
	        stats.add ("Health");
	        stats.add ("Strength");
	        stats.add ("Magic");
	        stats.add ("Defense");
	        stats.add ("Resistance");
	        stats.add ("Luck");
	        stats.add ("Agilty");
	        
	        traits.add ("Outgoing");
	        traits.add ("Optimistic");
	        traits.add ("Calm");
	        /*
	        //A bit silly, but if the user happens to type it into lower case, the program will accept the input and uppercase it later on.
	        stats.add ("health");
	        stats.add ("strength");
	        stats.add ("magic");
	        stats.add ("defense");
	        stats.add ("resistance");
	        stats.add ("luck");
	        stats.add ("speed");
	        
	        traits.add ("outgoing");
	        traits.add ("optimistic");
	        traits.add ("calm");*/
	        newGame();
        }
        
        public void newGame(){
            String message = "";
            message = "Welcome to Project Legendairy. \nWe appreciate you volunteering to help out. \nWould you mind telling me your name?";
            System.out.println (message);
            
            //try {
	            player.add (in.nextLine());
	        //}
	        //catch ( IOException e ) {}
	        
	        message = "What do you think is your strongest asset?\n";
	        message += "Health\n";
	        message += "Strength\n";
        	message += "Magic\n";
        	message += "Defense\n";
        	message += "Resistance\n";
	        message += "Luck\n";
        	message += "Agility\n";
       
            System.out.println (message);
            
            while (!response){
                
                //try {
                    System.out.println("Please enter an appropriate response.");
	                String choice =in.nextLine();;
	                if ( stats.contains (choice) ) {
	                    player.add (choice);
	                    response = true;
	                }
	            //}
	            //catch ( IOException e ) { }
            }
            
            response = false;
            
            message = "What do you think is your weakest asset?\n";
	        message += "Health\n";
	        message += "Strength\n";
        	message += "Magic\n";
        	message += "Defense\n";
        	message += "Resistance\n";
	        message += "Luck\n";
        	message += "Agilty\n";
       
            System.out.println (message);
            
            while (!response){
                
                //try {
                    System.out.println("Please enter an appropriate response.");
	                String choice =in.nextLine();
	                if ( stats.contains (choice) ) {
	                    player.add(choice);
	                    response = true;
	                }
	            //}
	            //catch ( IOException e ) { }
            }
            
        
        
         response = false;
            
            message = "Which of the following best describes your character?\n";
        	message += "Outgoing\n";
	        message += "Optimistic\n";
	        message += "Calm\n";
        

       
            System.out.println (message);
            
            while (!response){
                
               // try {
                    System.out.println("Please enter an appropriate response.");
	                String choice =in.nextLine();
	                if ( traits.contains (choice) ) {
	                    player.add(choice);
	                    response = true;
	                }
	            //}
	            //catch ( IOException e ) { }
            }
            
            //Description will be customized to fit what the player inputed previously
            message = "Hm, so you're " ;
            message += player.get(0);
            message += "?\n";
            System.out.println (message);
            
            if (player.get(3).equals ("Outgoing")){
                Fire hero = new Fire (player);
            }
            
        
        }
        
        public static void main (String[] args){
            Legendairy game = new Legendairy();
        }
    }