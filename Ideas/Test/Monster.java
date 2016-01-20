import java.io.*;
import java.util.*;

public class Monster extends GChar{
    public static HashMap <String, Monster> bestiary = new HashMap <String, Monster>();
    
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
    
    public Monster(){}
    
    //Skills
    protected ArrayList<String> known = new ArrayList<String>();
    
    public void initMonsters()
    {
        bestiary.put ("Pumpkin Head", new pumpkinHead() );
    }
    
    public void scale (int lvl, int exp){
        this.EXP = exp;
        level = lvl;
        hpInitial = HP = HP * (1 + lvl/5);
        mpInitial = MP = MP * (1 + lvl/5);
        strInitial = str = str * (1 + lvl/5);
        magicInitial = magic = magic * (1 + lvl/5);
        defInitial = def = def * (1 + lvl/5);
        resInitial = res = res * (1 + lvl/5);
        luckInitial = luck = luck * (1 + lvl/5);
        speedInitial = speed = speed * (1 + lvl/5);
    }
    
    
     /*
    =================================================================================================================
    ==========STAT METHODS===========================================================================================
    =================================================================================================================
    */
    
    
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

    }
    
    
     /*
     =========================================================================================================================================================
     ===Battle/Skill Methods========================================================================================================================================
     =========================================================================================================================================================
     */
     
    public void randomSkill (Monster target){
        int index =(int)(Math.random() * known.size());
        String skill = known.get (index);
        this.useSkill(skill, target);
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
     
     public void useSkill(String skillName, Monster target){}
     
     
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
     
     
    
    class pumpkinHead extends Monster{
        public pumpkinHead ()
        {
            name = "Pumpkin Head";
            element = "Wood";
            hpInitial = HP = 20;
            mpInitial = MP = 30;
            strInitial = str = 13;
            magicInitial = magic = 5;
            defInitial = def = 4;
            resInitial = res = 4;
            luckInitial = luck = 3;
            speedInitial = speed = 6;
            EXP = 0;
            level = 1;
            
            known.add("Basic Attack");
            known.add ("Wood Spike");
            
        }
    }
    
   
}