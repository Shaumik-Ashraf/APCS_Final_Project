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
        switch(job.toLowerCase())
        {
            case "warrior":
                
                //Stat modifications upon instantiation
                strInitial = str = 13;
                magicInitial = magic = 8;
           
                
                //Basic Skills upon instantiation
                known.add ("Strong Swing");
                known.add ("Heat Wave");
                
                //Possible skills to learn upon level up
                learnable.add ("Proud Swivel");
                
                //construct inventory with warrior default weapon
                i = new Inventory("Bronze Longsword");
                break;
            case "mage":
                //add mage learnable and owned skills here, and construct inventory with archer default weapon
                break;
            case "archer":
                //add archer learnable and owned skills here, and construct inventory with mage default weapon
                break;
            case "rogue":
                i = new Inventory("Bronze Dagger");                
                //construct inventory with rogue default weapon                
                break;
            
        }
    }
    
    /*
    =================================================================================================================
    ==========STAT METHODS===========================================================================================
    =================================================================================================================
    */
    
    
    public void bestStat(String stat){
        if (stat.equals ("Health")){
            HP *= 1.5;
            hpInitial = HP;
        }
        else if (stat.equals ("Strength")){
            str *= 1.5;
            strInitial = str;
        }
        
        else if (stat.equals ("Magic")){
            magic *= 1.5;
            magicInitial = magic;
        }
        
        else if (stat.equals ("Defense")){
            def *= 1.5;
            defInitial = def;
        }
        
        else if (stat.equals ("Resistance")){
            res *= 1.5;
            resInitial = res;
        }
        
        else if (stat.equals ("Luck")){
            luck *= 1.5;
            luckInitial = luck;
        }
        
        else if (stat.equals ("Agility")){
            speed *= 1.5;
            speedInitial = speed;
        }
        else{
            System.out.println ("System.outmething went wrong...");
        }
    }
    
    public void worstStat(String stat){
         if (stat.equals ("Health")){
            HP *= .5;
            hpInitial = HP;
        }
        else if (stat.equals ("Strength")){
            str *= .5;
            strInitial = str;
        }
        
        else if (stat.equals ("Magic")){
            magic *= .5;
            magicInitial = magic;
        }
        
        else if (stat.equals ("Defense")){
            def *= .5;
            defInitial = def;
        }
        
        else if (stat.equals ("Resistance")){
            res *= .5;
            resInitial = res;
        }
        
        else if (stat.equals ("Luck")){
            luck *= .5;
            luckInitial = luck;
        }
        
        else if (stat.equals ("Agility")){
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
            this.learnSkill();
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
            System.out.println ("Type the stats you want allocate points to. You have " + SP + " points.\n");
            this.statSheet();
            System.out.println("\nStat: ");
            
            input = in.nextLine();
            input.toLowerCase(Locale.ENGLISH);
            
            
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
         System.out.println("Skills you know:" + known);
     }
     
     public void useSkill(String skillName, GChar target)
     {
         if ((known.contains(skillName)) && ((this.MP - Skill.getAllSkills().get(skillName).getMpCost()) >= 0))
         {
            Skill.getAllSkills().get(skillName).use(this, target);
         }
         else if (!((this.MP - Skill.getAllSkills().get(skillName).getMpCost()) >= 0))
         {
            System.out.println("You don't have enough MP."); 
         }
         else
         {
             System.out.println("You don't know that skill.");
         }
     }
     
     public void learnSkill()
     {
         try 
         {
            known.add(learnable.get(0));
            System.out.println(this.name + " has learned " + learnable.get(0));
            learnable.remove(0);
         } catch (Exception e) {System.out.println("You know everything already");}
     }
     
     public void takeDamage(int damage)
     {
         if (damage < 0) {damage = 0;}
         else
         {
             HP -= damage;
         }
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
    
    
    
    //Main Method for Testing
    public static void main(String[] args)
    {
        Item.consEquipList();
        Skill.consAllSkills();
        GChar Logan = new GChar("Logan", "Fire", "Strength", "Magic", "Warrior");
        GChar Wendell = new GChar("Wendell", "Wood", "Agility", "Magic", "Rogue");
        Logan.getInventory().giveItem(new Weapon("Zweihänder"));
        Logan.getInventory().equipItem("Zweihänder");
        Wendell.getInventory().giveItem(new Weapon("Zweihänder"));
        Wendell.getInventory().equipItem("Zweihänder");
   
/*        
        Logan.augmentStats();
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
*/        
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
        Wendell.useSkill ("Basic Attack", Logan);
        if ( !( Logan.isAlive()) ) 
        {
            Wendell.expGain(Logan);
            Wendell.statSheet();
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}  //close class

