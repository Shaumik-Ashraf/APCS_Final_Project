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
        
        private boolean response;
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
			response = false;
			
	        stats.add ("Health");
	        stats.add ("HP");
	        stats.add ("Strength");
	        stats.add ("Magic");
	        stats.add ("Defense");
	        stats.add ("Resistance");
	        stats.add ("Luck");
	        stats.add ("Agility");
	        
	        traits.add ("Outgoing");
	        traits.add ("Optimistic");
	        traits.add ("Calm");
	        traits.add ("Carefree");
	        traits.add ("Empty");
	        
	        jobs.add ("Warrior");
	        jobs.add ("Mage");
	        jobs.add ("Archer");
	        

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
        	
        	
        	while (!response){
                
                	System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
	                choice =in.nextLine();
	               	System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( jobs.contains (choice) ) {
	                    job = choice;
	                    response = true;
	                }

            }
            
            response = false;
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
       
            
            
            while (!response){
               
                	System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
	                choice =in.nextLine();
	                System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( stats.contains (choice) ) {
	                    best = choice;
	                    response = true;
	                }
	         
            }
            
            response = false;
            
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
       
            
            
            while (!response){
                
              
                	System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
	                choice =in.nextLine();
	                System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( stats.contains (choice) ) {
	                    worst = choice;
	                    response = true;
	                }
	           
            }
            
        
        
         response = false;
            System.out.print("\033[H\033[2J");
			System.out.flush();
            message = "Which of the following best describes your character?\n";
        	message += "\nOutgoing\n";
	        message += "Optimistic\n";
	        message += "Calm\n";
	        message += "Carefree\n";
	        message += "Empty\n";
        

            
            while (!response){
                
             
               		System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
	                choice =in.nextLine();
	                System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( traits.contains (choice) ) {
	                    element = choice;
	                    if (element.equals ("Outgoing") ){
	                    	element = "Fire";
	                    }
	                    response = true;
	                }
	           
            }
            
            response = false;
            
            //Description will be customized to fit what the player inputed previously
            System.out.print("\033[H\033[2J");
			System.out.flush();
			
		
			
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
