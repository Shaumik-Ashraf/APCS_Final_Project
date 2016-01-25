/* Character class - contains everything required for battling, and all methods for any character
 * 
 * Notes:
 *	subclasses?
 *	
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
    public int gold;  //making this public
    public String[] stuff;

   
    
    //used for normalize
    public int hpInitial;
    public int strInitial;
    public int magicInitial;
    public int defInitial;
    public int resInitial;
    public int luckInitial;
    public int speedInitial;
    public int mpInitial;
    
    //Skills -made these public
    public ArrayList<String> learnable = new ArrayList<String>();
    public ArrayList<String> known = new ArrayList<String>();
    
    
    
	public Scanner in = new Scanner(System.in);
	
    //Inventory -made this public
    public Inventory i;
    
    public GChar(){}
    
    //Constructor -- using word "class" creates problems, using word "job" as the character class works fine
    public GChar(String n, String e, String best, String worst, String job)
    {
        level = 1;
        name = n;
        element = e;
        hpInitial = HP = 35;
        mpInitial = MP = 35;
        strInitial = str = 13;
        magicInitial = magic = 10;
        defInitial = def = 0;
        resInitial = res = 10;
        luckInitial = luck = 10;
        speedInitial = speed = 10;
        EXP = 50;
        gold = 250;
        bestStat(best);
        worstStat(worst);
        known.add("Basic Attack");
        stuff = new String[] {n, e, best, worst, job};
        
     
              
        switch(job.toLowerCase()) 
        {
             
                    
            case "warrior":
                
                //Stat modifications upon instantiation
                strInitial = str = 13;
                magicInitial = magic = 8;
   
             
                //Basic Skills upon instantiation
                known.add ("Strong Swing");
                
                if (element.equals ("Fire"))
                {
                    known.add ("Heat Wave");
                    learnable.add ("Rekindle");
                    learnable.add ("War Cry");
                    learnable.add ("Proud Swivel");
                    learnable.add ("Inner Fire");
                    learnable.add ("Flame Crash");
                    learnable.add ("Weaken");
                    learnable.add ("Rush Down");
                    learnable.add ("Finishing Touch");
                    learnable.add ("Inferno");
                }
                
                if (element.equals ("Aqua"))
                {
                    known.add ("Hail Storm");
                    learnable.add ("Aqua Veil");
                    learnable.add ("War Cry");
                    learnable.add ("Proud Swivel");
                    learnable.add ("Icicle Charge");
                    learnable.add ("Tidal Wave");
                    learnable.add ("Weaken");
                    learnable.add ("Rush Down");
                    learnable.add ("Finishing Touch");
                    learnable.add ("Geyser");
                }
                
                if (element.equals ("Wood"))
                {
                    known.add ("Pepper Song");
                    learnable.add ("Wood Spike");
                    learnable.add ("War Cry");
                    learnable.add ("Proud Swivel");
                    learnable.add ("Rush Down");
                    learnable.add ("Seed Burst");
                    learnable.add ("Weaken");
                    learnable.add ("Finishing Touch");
                    learnable.add ("Flower Dance");
                    learnable.add ("Planet");
                }

                if (element.equals ("Light"))
                {
                    known.add ("Heavenly Light");
                    learnable.add ("War Cry");
                    learnable.add ("Luster Wave");
                    learnable.add ("Proud Swivel");
                    learnable.add ("Rush Down");
                    learnable.add ("Weaken");
                    learnable.add ("Holy Smite");
                    learnable.add ("Finishing Touch");
                    learnable.add ("Salvation");
                    learnable.add ("Radiance");
                }
                
                if (element.equals ("Dark"))
                {
                    known.add ("Vampire");
                    learnable.add ("Demon Fury");
                    learnable.add ("War Cry");
                    learnable.add ("Zombie Strike");
                    learnable.add ("Rush Down");
                    learnable.add ("Weaken");
                    learnable.add ("Proud Swivel");
                    learnable.add ("Finishing Touch");
                    learnable.add ("Blood Rain");
                    learnable.add ("Darkness");
                }
                
                if (element.equals ("Gale"))
                {
                    known.add ("Feather Duster");
                    learnable.add ("War Cry");
                    learnable.add ("Spiral Assault");
                    learnable.add ("Proud Swivel");
                    learnable.add ("Rush Down");
                    learnable.add ("Weaken");
                    learnable.add ("Hurricane Force");
                    learnable.add ("Finishing Touch");
                    learnable.add ("Tail Wind");
                    learnable.add ("Maelstrom");
                }
                
               
                //construct inventory with warrior default weapon
                i = new Inventory("Bronze Longsword");
                break;
                   
            case "mage":
                
                //Stat modifications upon instantiation
                strInitial = str = 8;
                magicInitial = magic = 13;
                
                //Basic Skills upon instantiation
                known.add ("Arcanite Force");
                
                if (element.equals ("Fire"))
                {
                    known.add ("Heat Wave");
                    learnable.add ("Flame Crash");
                    learnable.add ("Rekindle");
                    learnable.add ("Brain Shock");
                    learnable.add ("Stagnate");
                    learnable.add ("Inner Fire");
                    learnable.add ("Arcane Bullets");
                    learnable.add ("Concentrate");
                    learnable.add ("Inferno");
                    learnable.add ("Mana Break");
                }
                
                if (element.equals ("Aqua"))
                {
                    known.add ("Hail Storm");
                    learnable.add ("Aqua Veil");
                    learnable.add ("Brain Shock");
                    learnable.add ("Stagnate");
                    learnable.add ("Icicle Charge");
                    learnable.add ("Tidal Wave");
                    learnable.add ("Arcane Bullets");
                    learnable.add ("Concentrate");
                    learnable.add ("Geyser");
                    learnable.add ("Mana Break");
                }
                
                if (element.equals ("Wood"))
                {
                    known.add ("Pepper Song");
                    learnable.add ("Flower Dance");
                    learnable.add ("Brain Shock");
                    learnable.add ("Seed Burst");
                    learnable.add ("Wood Spike");
                    learnable.add ("Stagnate");
                    learnable.add ("Arcane Bullets");
                    learnable.add ("Concentrate");
                    learnable.add ("Planet");
                    learnable.add ("Mana Break");
                }
                
                if (element.equals ("Light"))
                {
                    known.add ("Heavenly Light");
                    learnable.add ("Stagnate");
                    learnable.add ("Brain Shock");
                    learnable.add ("Holy Smite");
                    learnable.add ("Salvation");
                    learnable.add ("Arcane Bullets");
                    learnable.add ("Luster Wave");
                    learnable.add ("Concentrate");
                    learnable.add ("Radiance");
                    learnable.add ("Mana Break");
                }
                
                if (element.equals ("Dark"))
                {
                    known.add ("Demon Fury");
                    learnable.add ("Blood Rain");
                    learnable.add ("Vampire");
                    learnable.add ("Zombie Strike");
                    learnable.add ("Stagnate");
                    learnable.add ("Brain Shock");
                    learnable.add ("Arcane Bullets");
                    learnable.add ("Concentrate");
                    learnable.add ("Darkness");
                    learnable.add ("Mana Break");
                }
                
                if (element.equals ("Gale"))
                {
                    known.add ("Spiral Assault");
                    learnable.add ("Feather Duster");
                    learnable.add ("Brain Shock");
                    learnable.add ("Tail Wind");
                    learnable.add ("Stagnate");
                    learnable.add ("Hurricane Force");
                    learnable.add ("Arcane Bullets");
                    learnable.add ("Concentrate");
                    learnable.add ("Maelstrom");
                    learnable.add ("Mana Break");
                }
                
                i = new Inventory("Wooden Pole");
                break;
                
            case "archer":
                //Stat modifications upon instantiation
                speedInitial = speed = 13;
                magicInitial = magic = 8;
                //Basic Skills upon instantiation
                known.add ("Bow Throw");
               
               
                if (element.equals ("Fire"))
                {
                    known.add ("Heat Wave");
                    learnable.add ("Rekindle");
                    learnable.add ("Focus");
                    learnable.add ("Flame Crash");
                    learnable.add ("Markdown");
                    learnable.add ("Quick Draw");
                    learnable.add ("Inner Fire");
                    learnable.add ("Fatal Shot");
                    learnable.add ("Arrow Storm");
                    learnable.add ("Inferno");               
                }
                
                if (element.equals ("Aqua"))
                {
                    known.add ("Hail Storm");
                    learnable.add ("Aqua Veil");
                    learnable.add ("Focus");
                    learnable.add ("Markdown");
                    learnable.add ("Quick Draw");
                    learnable.add ("Icicle Charge");
                    learnable.add ("Tidal Wave");
                    learnable.add ("Fatal Shot");
                    learnable.add ("Arrow Storm");
                    learnable.add ("Geyser");
                }
                
                if (element.equals ("Wood"))
                {
                    known.add ("Pepper Song");
                    learnable.add ("Wood Spike");
                    learnable.add ("Markdown");
                    learnable.add ("Seed Burst");
                    learnable.add ("Quick Draw");
                    learnable.add ("Focus");
                    learnable.add ("Arrow Storm");
                    learnable.add ("Fatal Shot");
                    learnable.add ("Flower Dance");
                    learnable.add ("Planet");
                }
                
                if (element.equals ("Light"))
                {
                    known.add ("Luster Wave");
                    learnable.add ("Heavenly Light");
                    learnable.add ("Focus");
                    learnable.add ("Holy Smite");
                    learnable.add ("Quick Draw");
                    learnable.add ("Markdown");
                    learnable.add ("Salvation");
                    learnable.add ("Fatal Shot");
                    learnable.add ("Arrow Storm");
                    learnable.add ("Radiance");
                }
                
                if (element.equals ("Dark"))
                {
                    known.add ("Vampire");
                    learnable.add ("Zombie Strike");
                    learnable.add ("Demon Fury");
                    learnable.add ("Focus");
                    learnable.add ("Quick Draw");
                    learnable.add ("Markdown");
                    learnable.add ("Fatal Shot");
                    learnable.add ("Arrow Storm");
                    learnable.add ("Blood Rain");
                    learnable.add ("Darkness");
                }
                
                if (element.equals ("Gale"))
                {
                    known.add ("Feather Duster");
                    learnable.add ("Spiral Assault");
                    learnable.add ("Focus");
                    learnable.add ("Quick Draw");
                    learnable.add ("Markdown");
                    learnable.add ("Hurricane Force");
                    learnable.add ("Fatal Shot");
                    learnable.add ("Arrow Storm");
                    learnable.add ("Tail Wind");
                    learnable.add ("Maelstrom");
                }
                
                i = new Inventory("Bronze Longsword");//Archer doesn't have a weapon yet. T_T
                break;
                
            case "rogue":
                luckInitial = luck = 13;
                magicInitial = magic = 8;
                strInitial = str = 8;
                
                known.add ("Back Stab");
                
                
                if (element.equals ("Fire"))
                {
                    known.add ("Heat Wave");
                    learnable.add ("Rekindle");
                    learnable.add ("Pickpocket");
                    learnable.add ("Flame Crash");
                    learnable.add ("Curtains");
                    learnable.add ("Gamble");
                    learnable.add ("Inner Fire");
                    learnable.add ("Shuffle Time");
                    learnable.add ("Assassinate");
                    learnable.add ("Inferno");                
                }
                
                if (element.equals ("Aqua"))
                {
                    known.add ("Hail Storm");
                    learnable.add ("Aqua Veil");
                    learnable.add ("Pickpocket");
                    learnable.add ("Tidal Wave");
                    learnable.add ("Curtains");
                    learnable.add ("Icicle Charge");
                    learnable.add ("Gamble");
                    learnable.add ("Shuffle Time");
                    learnable.add ("Assassinate");
                    learnable.add ("Geyser");
                }
                
                if (element.equals ("Wood"))
                {
                    known.add ("Pepper Song");
                    learnable.add ("Wood Spike");
                    learnable.add ("Pickpocket");
                    learnable.add ("Gamble");
                    learnable.add ("Seed Burst");
                    learnable.add ("Curtains");
                    learnable.add ("Flower Dance");
                    learnable.add ("Shuffle Time");
                    learnable.add ("Assassinate");
                    learnable.add ("Planet");
                }
                
                if (element.equals ("Light"))
                {
                    known.add ("Heavenly Light");
                    learnable.add ("Luster Wave");
                    learnable.add ("Gamble");
                    learnable.add ("Pickpocket");
                    learnable.add ("Curtains");
                    learnable.add ("Holy Smite");
                    learnable.add ("Salvation");
                    learnable.add ("Shuffle Time");
                    learnable.add ("Assassinate");
                    learnable.add ("Radiance");
                }
                
                if (element.equals ("Dark"))
                {
                    known.add ("Vampire");
                    learnable.add ("Demon Fury");
                    learnable.add ("Pickpocket");
                    learnable.add ("Zombie Strike");
                    learnable.add ("Gamble");
                    learnable.add ("Curtains");
                    learnable.add ("Shuffle Time");
                    learnable.add ("Blood Rain");
                    learnable.add ("Assassinate");
                    learnable.add ("Darkness");
                }
                
                  
                if (element.equals ("Gale"))
                {
                    known.add ("Feather Duster");
                    learnable.add ("Spiral Assault");
                    learnable.add ("Pickpocket");
                    learnable.add ("Gamble");
                    learnable.add ("Curtains");
                    learnable.add ("Hurricane Force");
                    learnable.add ("Shuffle Time");
                    learnable.add ("Tail Wind");
                    learnable.add ("Assassinate");
                    learnable.add ("Maelstrom");
                }
                
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
       // else{
      //      System.out.println ("System.outmething went wrong...");
      //  }
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
        else; //System.out.println("System.outmething went wrong...");
        
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
        this.gold += c.gold;
        System.out.println (name + " gained " + c.EXP + " EXP!");
        System.out.println (name + " gained " + c.gold + " gold!");
        System.out.println("\nType any character to continue");
		String delay = in.nextLine();
		System.out.print("\033[H\033[2J");
		System.out.flush();
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
            this.hpInitial += 15 * lvlGain;
            this.mpInitial += 15 * lvlGain;
            this.skillPoints(lvlGain);
            if (this.level % 4 == 0){
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
                this.strInitial ++;
                this.str ++;
                SP -- ;
            }
            
            if (input.equals ("magic") || input.equals("mag") )
            {
                this.magicInitial ++;
                this.magic ++;
                SP -- ;
            }     
            
            if (input.equals ("defense") || input.equals("def") )
            {
                this.defInitial ++;
                this.def ++;
                SP -- ;
            }
            
            if (input.equals ("resistance") || input.equals("res") )
            {
                this.resInitial ++;
                this.res ++;
                SP -- ;
            }     
            
            if (input.equals ("luck") || input.equals("luk") )
            {
                this.luckInitial ++;
                this.luck ++;
                SP -- ;
            }
            
            if (input.equals ("speed") || input.equals("spe") )
            {
                this.speedInitial ++;
                this.speed ++;
                SP -- ;
            }
            
            System.out.print("\033[H\033[2J");
			System.out.flush();
            
        }
     }
     
     //sets exp of GChars. Use when monsters are created so the player can get some exp from killing them
     public void setEXP (GChar target, int value){
         target.EXP = value;
     }
     
     public void giveEXP(int amount)
     {
         this.EXP += amount;
         System.out.println(this.name + " has gained " + amount + " exp.");
         if (this.EXP >= 100)
         {
             this.EXP = this.EXP%100;
             this.skillPoints(1);
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

     public void takeDamageMp(int damage)
     {
         if (damage < 0) {damage = 0;}
         else
         {
             MP -= damage;
         }
         if (MP <= 0)
         {
             MP = 0;
         }
         System.out.println (this.name + " takes " + damage + " MP damage!");
     }
     
     
     public void randomSkill (GChar target)
     {
        int index =(int)(Math.random() * known.size());
        String skill = known.get (index);
        this.useSkill(skill, target);
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
                    this.normalize();
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
        		    System.out.print("\033[H\033[2J");
		            System.out.flush();  
        
        results (this , enemy);
    }
     
     public void results(GChar user, GChar enemy){
         if (!(user.isAlive()))
         {
             System.out.println ("" + name + " died.");
         }
         else if (!(enemy.isAlive()))
         {
             System.out.println ("" + name + " defeated the enemy!");
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
     
     public static void itemInterface(ArrayList <GChar> party)
{
                    Scanner in = new Scanner(System.in);
                    String delay;
                    String input;
		            System.out.println("Whose items?\n");
		            input = in.nextLine();
		            GChar charInput = party.get(0);
		            for (int j = 0; j < party.size(); j++)
		            {
		                if (party.get(j).name.equals(input))
		                {
		                    charInput = party.get(j);
		                }
		            }
		            
		            if (party.contains(charInput))
		            {
		                charInput.normalize();
                        while(!(input.equals("nothing")))
    		            {
                            System.out.print("\033[H\033[2J");
                		    System.out.flush();
    			            System.out.println(charInput.getInventory() + "\nWhat will " + charInput.toString() + " do?\nEquip Item\nUse Item\nClear Effects\nView Stats\nGive Item\nNothing (go back)\n");	                
    		                input = in.nextLine().toLowerCase(Locale.ENGLISH);
    		                switch(input)
    		                {
    		                    case "use item":
    		                        try 
    		                        {
    		                            System.out.println("\nUse what item? ");
    		                            charInput.getInventory().useItem(in.nextLine());		                            
    		                        } catch(Exception e) {System.out.println("" + charInput.toString() + " can't use that item.");}
    
    		                        break;
    		                    case "equip item":
    		                        try 
    		                        {
        		                        System.out.println("\nEquip what item?");
        		                        charInput.getInventory().equipItem(in.nextLine());		                            
    		                        } catch(Exception e) {System.out.println("" + charInput.toString() + " can't equip that item.");}
    
    		                        break;
    		                    case "clear effects":
    		                        charInput.getInventory().killEffects();
    		                        break;
    		                    case "nothing":
    		                        break;
    		                    case "view stats":
    		                        charInput.getInventory().onlyViewing();
    		                        charInput.augmentStats();
    		                        System.out.println("\nStats: ");
    		                        charInput.statSheet();
    		                        charInput.normalize();
    		                        break;
    		                    case "give item":
    		                        System.out.println("Give it to who?");
    		                        input = in.nextLine();
    		                        GChar charInput2 = party.get(0);
		                            for (int j = 0; j < party.size(); j++)
		                            {
		                                if (party.get(j).name.equals(input))
		                                {
		                                    charInput2 = party.get(j);
		                                }
		                            }
		                            System.out.println("Give what item to " + charInput2.name + "?");
		                            input = in.nextLine();
		                            charInput.getInventory().giveItemTo(input, charInput2);
		                            break;
    		                }
    		                System.out.println("\nType any character to continue");
    		                delay = in.nextLine();
    		            }		                
		            }
}
    
    
    
    //Main Method for Testing
    public static void main(String[] args)
    {
        Item.consEquipList();
        Skill.consAllSkills();
        Monster.initMonsters();
        GChar Logan = new GChar("Logan", "Fire", "Strength", "Magic", "Warrior");
        GChar Wendell = new GChar("Wendell", "Wood", "Agility", "Magic", "Rogue");

   
       
        ArrayList<GChar> chars = new ArrayList<GChar>();
        chars.add(Logan);
        chars.add(Wendell);
        Wendell.getInventory().giveItem(new MiscItem("Advanced Lock Picking Kit"));
        Wendell.getInventory().giveItem(new MiscItem("Rope"));
        Event e = new CavernEvent(chars);
        chars = e.beginEvent();
        e = new ChestEvent(chars);
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

