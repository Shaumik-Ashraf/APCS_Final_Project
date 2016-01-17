/* Legendairy - does the heavy lifting of legends
 * 
 * Notes:
 * This should still work
 * 
 *
 */

//custom api
//import gamechars.*;
//import gameutils.*;
 
//java 7 api 
import java.io.*;
import java.util.*;


    public class Legendairy{
    	
    	private static final ArrayList<String> stats = new ArrayList();
        private static final ArrayList<String> traits = new ArrayList();
        private static final ArrayList<String> jobs = new ArrayList();
            
      
        private GChar enemy;
        
        private String message;
        private String choice;

        private Scanner in;
        
        public String name;
        public String element;
        public String best;
        public String worst;
        public String job;
        

        
        public Legendairy() {
         
	        in = new Scanner(System.in);
			
	        stats.add ("health");
	        stats.add ("strength");
	        stats.add ("magic");
	        stats.add ("defense");
	        stats.add ("resistance");
	        stats.add ("luck");
	        stats.add ("agility");
	        
	        traits.add ("outgoing");
	        traits.add ("optimistic");
	        traits.add ("calm");
	        traits.add ("carefree");
	        traits.add ("empty");
	        
	        jobs.add ("warrior");
	        jobs.add ("mage");
	        jobs.add ("archer");
	        

	        newGame();
        }
        
        public void newGame(){
        	
            //character selections
            characterCreation();
            
            //for now, do battle
           // battleSim();
        
        	
        	
        }
        
        public void characterCreation(){
        	System.out.print("\033[H\033[2J");
			System.out.flush();
            message = "";
            message = "Welcome to Project Legendairy. \nWe appreciate you volunteering to help out. \nWould you mind telling me your name?";
            System.out.println (message);
            
        
	        name = in.nextLine();
	      
	        System.out.print("\033[H\033[2J");
			System.out.flush();
	        
	        message = "Choose your vocation.\n";
	        message += "Warrior\n";
	        message += "Mage\n";
        	message += "Archer\n";
        	
        	
        	do
        	{
                
                	System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
	                choice =in.nextLine();
	                choice = choice.toLowerCase(Locale.ENGLISH);
	               	System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( jobs.contains (choice) ) {
	                    job = choice;
	                    break;
	                }

            }while (true);
            
      
	        System.out.print("\033[H\033[2J");
			System.out.flush();
	        message = "What do you think is your strongest asset?\n";
	        message += "\nHealth\n";
	        message += "Strength\n";
        	message += "Magic\n";
        	message += "Defense\n";
        	message += "Resistance\n";
	        message += "Luck\n";
        	message += "Agility\n";
       
            
            do
        	{
              
                System.out.println (message);
                System.out.println("Please enter an appropriate response.\n");
	            choice =in.nextLine();
	            choice = choice.toLowerCase(Locale.ENGLISH);
	            System.out.print("\033[H\033[2J");
				System.out.flush();
	            if ( stats.contains (choice) ) {
	               	best = choice;
	                break;
	                }

            }while (true);
            
      
            
            System.out.print("\033[H\033[2J");
			System.out.flush();
            message = "What do you think is your weakest asset?\n";
	        message += "\nHealth\n";
	        message += "Strength\n";
        	message += "Magic\n";
        	message += "Defense\n";
        	message += "Resistance\n";
	        message += "Luck\n";
        	message += "Agility\n";
       
            
 			do
        	{
              
                System.out.println (message);
                System.out.println("Please enter an appropriate response.\n");
	            choice =in.nextLine();
	            choice = choice.toLowerCase(Locale.ENGLISH);
	            System.out.print("\033[H\033[2J");
				System.out.flush();
	            if ( stats.contains (choice) ) {
	               	worst = choice;
	                break;
	                }

            }while (true);
            
        
        
        
            System.out.print("\033[H\033[2J");
			System.out.flush();
            message = "Which of the following best describes your character?\n";
        	message += "\nOutgoing\n";
	        message += "Optimistic\n";
	        message += "Calm\n";
	        message += "Carefree\n";
	        message += "Empty\n";
        
			do
        	{
              
                System.out.println (message);
                System.out.println("Please enter an appropriate response.\n");
	            choice =in.nextLine();
	            choice = choice.toLowerCase(Locale.ENGLISH);
	            System.out.print("\033[H\033[2J");
				System.out.flush();
	            if ( traits.contains (choice) ) {
	                    element = choice;
	                    if (element.equals ("outgoing") ){
	                    	element = "Fire";
	                    }
	                    if (element.equals ("optimistic") ){
	                    	element = "Wood";
	                    }
	                    if (element.equals ("calm") ){
	                    	element = "Aqua";
	                    }
	                    if (element.equals ("carefree") ){
	                    	element = "Gale";
	                    }
	                    if (element.equals ("empty") ){
	                    	element = "Void";
	                    }
	               break;
	            }

            }while (true);
            

            System.out.print("\033[H\033[2J");
			System.out.flush();
			
			System.out.println (name);
			System.out.println (element);
			System.out.println (best);
			System.out.println (worst);
			System.out.println (job);
			
			
			GChar cloud = new GChar (name, element, best, worst, job);
            message = "Hm, so you're " ;
            message += name;
            message += "?\n";
            System.out.println (message);
          
        }
            
          
       		
       		
      	
          
        
        public static void main (String[] args){
            Legendairy game = new Legendairy();
        }
    }
