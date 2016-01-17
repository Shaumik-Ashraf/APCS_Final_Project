/* abstract Character class - contains everything required for battling, and all methods for any character
 * 
 * Notes:
 *	maybe add a public void battle(Character x) method? remove some of the "weight" from Legendairy
 *	packaging everything
 *
 */

//package gamechars;
import java.io.*;
import java.util.*;
//import gameutils.*;
 

public class GChar{

    /*
    =================================================================================================================
    =========================FIELD===================================================================================
    =================================================================================================================
    */
    public String name;
    public String element;
    
    public int HP; //Player's health
    public int str; //Determines damage of physical attacks
    public int magic; //Determines damage of spells
    public int def; //Reduces the damage taken by physical attacks
    public int res; //Reduces the damage taken by magic attacks
    public int luck; //Affects critical hit ratio and total damage taken (min/max damage)
    public int speed; //Determines turn order and battle and affects evasion rate
    public boolean crit; //if true, the attack will be a critical hit and do more damage
    //public boolean healing; // if true, the player skips a turn to heal.
    public boolean typeAdv; // if the player does a move that has a type advantage, deal double damage.
    public boolean typeDis; // if the player does a move that has a type disadvantage, deal half damage.
    public int EXP;
    public int level;
    public int MP;
   
    
    //used for normalize
    public int hpInitial;
    public int strInitial;
    public int magicInitial;
    public int defInitial;
    public int resInitial;
    public int luckInitial;
    public int speedInitial;
    public int mpInitial;
    
    //Skills
    protected ArrayList<String> learnable = new ArrayList<String>();
    protected ArrayList<String> known = new ArrayList<String>();
    
    
    
    //Inventory
    private Inventory i;
    
    
    //Constructor -- using word "class" creates problems, using word "job" as the character class works fine
    public GChar(String n, String e, String best, String worst, String job)
    {
        name = n;
        element = e;
        hpInitial = HP = 35;
        mpInitial = MP = 35;
        strInitial = str = 10;
        magicInitial = magic = 10;
        defInitial = def = 10;
        resInitial = res = 10;
        luckInitial = luck = 10;
        speedInitial = speed = 10;
        EXP = 50;
        level = 1;
        bestStat(best);
        worstStat(worst);
        known.add("Basic Attack");
        
        if (element.equals ("Fire"))
            {
                known.add ("Heat Wave");
                learnable.add ("Rekindle");
                learnable.add ("Flame Crash");
              }
              
        switch(job.toLowerCase())
        {
            
                
            case "warrior":
                
                //Stat modifications upon instantiation
                strInitial = str = 13;
                magicInitial = magic = 8;
   
             
                //Basic Skills upon instantiation
                known.add ("Strong Swing");
                
                //Skills learned upon level up
                learnable.add ("Proud Swivel");
                learnable.add ("Finishing Touch");
                

             
                
                //construct inventory with warrior default weapon
                i = new Inventory("Bronze Longsword");
                break;
                
            case "mage":
                
                //Stat modifications upon instantiation
                strInitial = str = 8;
                magicInitial = magic = 13;
                
                //Basic Skills upon instantiation
                known.add ("Arcanite Force");
                
                //Skills learned upon level up
                learnable.add ("Arcane Bullets");
                learnable.add ("Concentrate");
                
                i = new Inventory("Wooden Pole");
                break;
                
            case "archer":
                //Stat modifications upon instantiation
                speedInitial = speed = 13;
                magicInitial = magic = 8;
                //Basic Skills upon instantiation
                known.add ("Bow Throw");
                
                //Skills learned upon level up
                learnable.add ("Focus");
                learnable.add ("Arrow Storm");
                
                i = new Inventory("Bronze Longsword");//Archer doesn't have a weapon yet. T_T
                break;
                
            case "rogue":
                i = new Inventory("Bronze Dagger");                
                //construct inventory with rogue default weapon       
              
                
                break;
                
            case "monster":
                break;
                
          
            
        }
    }
    
    /*
    =================================================================================================================
    ==========STAT METHODS===========================================================================================
    =================================================================================================================
    */
    
    
    public void bestStat(String stat){
        if (stat.equals ("health")){
            HP *= 1.5;
            hpInitial = HP;
        }
        else if (stat.equals ("strength")){
            str *= 1.5;
            strInitial = str;
        }
        
        else if (stat.equals ("magic")){
            magic *= 1.5;
            magicInitial = magic;
        }
        
        else if (stat.equals ("defense")){
            def *= 1.5;
            defInitial = def;
        }
        
        else if (stat.equals ("resistance")){
            res *= 1.5;
            resInitial = res;
        }
        
        else if (stat.equals ("luck")){
            luck *= 1.5;
            luckInitial = luck;
        }
        
        else if (stat.equals ("agility")){
            speed *= 1.5;
            speedInitial = speed;
        }
        else{
            System.out.println ("System.outmething went wrong...");
        }
    }
    
    public void worstStat(String stat){
         if (stat.equals ("health")){
            HP *= .5;
            hpInitial = HP;
        }
        else if (stat.equals ("strength")){
            str *= .5;
            strInitial = str;
        }
        
        else if (stat.equals ("magic")){
            magic *= .5;
            magicInitial = magic;
        }
        
        else if (stat.equals ("defense")){
            def *= .5;
            defInitial = def;
        }
        
        else if (stat.equals ("resistance")){
            res *= .5;
            resInitial = res;
        }
        
        else if (stat.equals ("luck")){
            luck *= .5;
            luckInitial = luck;
        }
        
        else if (stat.equals ("agility")){
            speed *= .5;
            speedInitial = speed;
        }
        else{
            System.out.println ("System.outmething went wrong...");
        }
        
    }
    
     public boolean isAlive(){
        return (HP > 0);
    }
    
    public void statSheet(){
        ArrayList<String> stats = new ArrayList();
        stats.add("HP: " + HP + "/" + hpInitial);
        stats.add("MP: " + MP + "/" + mpInitial);
        stats.add("Str: " + str);
        stats.add("Magic: " +magic);
        stats.add("Def: " + def);
        stats.add("Res: " + res);
        stats.add("Luck: " + luck);
        stats.add("Speed: " + speed);
        
        System.out.println (name);
        System.out.println ("Level: " + level);
        System.out.println ("Element: "+ element);
        System.out.println ("EXP: " + EXP + "/100");
        System.out.println (stats);
    }
    
    //reset stats
    //also use as heal (boolean healing not required; usage: class Town -> rest case)
    //may cause conflicts when using equips
    public void normalize(){
       // healing = false;
        str = strInitial;
        magic = magicInitial;
        def = defInitial;
        res = resInitial;
        luck = luckInitial;
        speed = speedInitial;
        crit = false;
        typeAdv = false;
        typeDis = false;
    }
    
    /*
     =========================================================================================================================================================
     ===Level Methods==========================================================================================================================================
     =========================================================================================================================================================
     */   
     public void expGain (GChar c)
     {
        this.EXP += c.EXP;
        System.out.println (name + " gained " + c.EXP + " EXP!");
        if (this.EXP >= 100)
        {
            System.out.print("\033[H\033[2J");
			System.out.flush();
            System.out.println ("\nLevel gained!");
            try
            {
                Thread.sleep (2000);
            } catch (Exception e){}
            int lvlGain = this.EXP /100;
            this.level += lvlGain;
            this.EXP = this.EXP % 100;
            this.hpInitial += 10 * lvlGain;
            this.mpInitial += 10 * lvlGain;
            this.HP = hpInitial;
            this.MP = mpInitial;
            this.skillPoints(lvlGain);
            if (this.level % 5 == 0){
                this.learnSkill();
            }
        }
     }
     
     public void skillPoints (int lvlGain)
     {
        Scanner in = new Scanner(System.in);
        String input;
        String pause;
        int SP = 3 * lvlGain;
        while (SP != 0)
        {
            System.out.print("\033[H\033[2J");
			System.out.flush();            
            System.out.println ("Type the stats " + name + " wants allocate points to. " + name + " have " + SP + " points.\n");
            this.statSheet();
            System.out.println("\nStat: ");
            
            input = in.nextLine();
            input = input.toLowerCase(Locale.ENGLISH);
            
            
            if (input.equals ("strength") || input.equals("str") )
            {
                this.str ++;
                SP -- ;
            }
            
            if (input.equals ("magic") || input.equals("mag") )
            {
                this.magic ++;
                SP -- ;
            }     
            
            if (input.equals ("defense") || input.equals("def") )
            {
                this.def ++;
                SP -- ;
            }
            
            if (input.equals ("resistance") || input.equals("res") )
            {
                this.res ++;
                SP -- ;
            }     
            
            if (input.equals ("luck") || input.equals("luk") )
            {
                this.luck ++;
                SP -- ;
            }
            
            if (input.equals ("speed") || input.equals("spe") )
            {
                this.speed ++;
                SP -- ;
            }
            
            System.out.print("\033[H\033[2J");
			System.out.flush();
            
        }
     }
     
    
     
    
    /*
     =========================================================================================================================================================
     ===Battle/Skill Methods========================================================================================================================================
     =========================================================================================================================================================
     */
     
     public void printKnown()
     {
         System.out.println("Skills " + name + " knows: " + known);
     }
     
     public void useSkill(String skillName, GChar target)
     {
         if ((known.contains(skillName)) && ((this.MP - Skill.getAllSkills().get(skillName).getMpCost()) >= 0))
         {
            Skill.getAllSkills().get(skillName).use(this, target);
         }
         else if ((known.contains(skillName)) &&(!((this.MP - Skill.getAllSkills().get(skillName).getMpCost()) >= 0)))
         {
            System.out.println("" + name + " does not have enough MP."); 
         }
         else
         {
             System.out.println("" + name + " does not know that skill.");
         }
     }
     
     public void learnSkill()
     {
         try 
         {
            known.add(learnable.get(0));
            System.out.println(this.name + " has learned " + learnable.get(0));
            learnable.remove(0);
         } catch (Exception e) {System.out.println("" + name + " knows everything already");}
     }
     
     public void takeDamage(int damage)
     {
         if (damage < 0) {damage = 0;}
         else
         {
             HP -= damage;
         }
         System.out.println (this.name + " takes " + damage + " damage!");
     }
     
    /*
     =========================================================================================================================================================
     ===Item Methods==========================================================================================================================================
     =========================================================================================================================================================
     */     
    
    public Inventory getInventory()
    {
        return i;
    }
    
    public void augmentStats()
    {
        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        temp = this.getInventory().scrapeStats();
        str += temp.get("strMod");
        def += temp.get("defMod");
        res += temp.get("resMod");
        magic += temp.get("magicMod");
        HP += temp.get("hpMod");
        MP += temp.get("mpMod");
        luck += temp.get("luckMod");
        speed += temp.get("speedMod");
        if (HP > hpInitial) {HP = hpInitial;}
        if (MP > mpInitial) {MP = mpInitial;}
        
    }
    
    /*
     =========================================================================================================================================================
     ===Enemy Encounter Methods==========================================================================================================================================
     =========================================================================================================================================================
     */     
     
    public void battleBeat (GChar enemy)
    {
        Scanner in = new Scanner(System.in);
		String input;  //input buffer
		String delay;
            do
             {
             System.out.print("\033[H\033[2J");
		     System.out.flush();
             System.out.println ("What will " + name + " do?");
             System.out.println ("Fight\nItems\nNothing\n" );
            
            input = in.nextLine();
            input = input.toLowerCase(Locale.ENGLISH);
        
         
            if( "fight".equals(input)) 
                {
			    	break;
		        }
            if (input.equals ("items"))
		        {

		            while(!(input.equals("nothing")))
		            {
                        System.out.print("\033[H\033[2J");
            		    System.out.flush();
			            System.out.println(this.getInventory() + "\nWhat will " + name + " do?\nEquip Item\nUse Item\nClear Effects\nView Stats\nNothing (go back)\n");	                
		                input = in.nextLine().toLowerCase(Locale.ENGLISH);
		                switch(input)
		                {
		                    case "use item":
		                        try 
		                        {
		                            System.out.println("\nUse what item? ");
		                            this.getInventory().useItem(in.nextLine());		                            
		                        } catch(Exception e) {System.out.println("" + name + " can't use that item.");}

		                        break;
		                    case "equip item":
		                        try 
		                        {
    		                        System.out.println("\nEquip what item?");
    		                        this.getInventory().equipItem(in.nextLine());		                            
		                        } catch(Exception e) {System.out.println("" + name + " can't equip that item.");}

		                        break;
		                    case "clear effects":
		                        this.getInventory().killEffects();
		                        break;
		                    case "nothing":
		                        break;
		                    case "view stats":
		                        this.getInventory().onlyViewing();
		                        this.augmentStats();
		                        System.out.println("\nStats: ");
		                        this.statSheet();
		                        this.normalize();
		                        break;
		                }
		                System.out.println("\nType any character to continue");
		                delay = in.nextLine();
		            }
		            
		            
		            
		        }
		        
             } while(true);
		 
		     
		 
		     if (input.equals ("fight"))
		        {
		            this.normalize();
		            this.augmentStats();
		            System.out.println ("Select an attack to use.");
		            this.printKnown();
		            input = in.nextLine();
		        }
		        
        		    this.useSkill (input, enemy);
        		    delay = in.nextLine();
        
        results (this , enemy);
    }
     
     public void results(GChar user, GChar enemy){
         if (!(user.isAlive()))
         {
             System.out.println ("" + name + " died.");
         }
         else if (!(enemy.isAlive()))
         {
             System.out.println ("" + name + " win the battle!");
             user.expGain (enemy);
         }
     }
     
     public boolean isFaster (GChar enemy){
         return (this.speed > enemy.speed);
     }
     
     public String toString()
     {
         return name;
     }
    
    
    
    //Main Method for Testing
    public static void main(String[] args)
    {
        Item.consEquipList();
        Skill.consAllSkills();
        GChar Logan = new GChar("Logan", "Fire", "Strength", "Magic", "Warrior");
        GChar Wendell = new GChar("Wendell", "Wood", "Agility", "Magic", "Rogue");

   
       
        ArrayList<GChar> chars = new ArrayList<GChar>();
        chars.add(Logan);
        chars.add(Wendell);
        Event e = new ChestEvent(chars);
        chars = e.beginEvent();
    /*    Logan.augmentStats();
        Wendell.augmentStats();
        Wendell.statSheet();
        System.out.println("");
        Logan.statSheet();
        System.out.println("");
        Logan.printKnown();
        Logan.useSkill("Basic Attack", Wendell);
        System.out.println("\nLogan Basic Attacking Wendell\n");
        Wendell.statSheet();
        Logan.normalize();
        Wendell.normalize();
       
        Logan.augmentStats();
        Wendell.augmentStats();
        Logan.learnSkill();
        Logan.learnSkill();
        System.out.println("Learning and using Heat Wave on Wendell");
        Logan.useSkill("Heat Wave", Wendell);
        Wendell.statSheet();
        Logan.normalize();
        Wendell.normalize();
        
        Wendell.getInventory().giveItem(new EffectItem("Ultimate Healing Potion"));
       Wendell.getInventory().useItem("Ultimate Healing Potion");
        
        Wendell.augmentStats();
        Logan.augmentStats();
        System.out.println("Wendell used a potion...");
        Wendell.statSheet();
        System.out.println("Wendell using BA on Logan");
        Wendell.useSkill("Basic Attack", Logan);
        Logan.statSheet();
        Logan.normalize();
        Wendell.normalize();
        
        Wendell.augmentStats();
        Logan.augmentStats();
        Wendell.useSkill ("Basic Attack", Logan);*/
     
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}  //close class

