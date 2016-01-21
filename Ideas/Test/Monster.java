import java.io.*;
import java.util.*;

public class Monster extends GChar{
    
    public static HashMap <String, String[]> bestiary = new HashMap <String, String[]>();
    
    // Inventory i;
    
    
    public static void initMonsters()
    {
        //====================================         Name             Element   Basic Skill         Spe Skill           xHP       xStr     xMag      EXP
        bestiary.put ("Pumpkin Head", new String[]     {"Pumpkin Head",   "Wood",   "Basic Attack",   "Rekindle",         "1.2",    "1.2",   ".8" ,   "10"});
        bestiary.put ("Moo Cow", new String[]          {"Moo Cow",        "Light",  "Basic Attack",   "Back Stab",        "1.5",    ".8",    ".6" ,   "10"});
        bestiary.put ("Dullahan", new String[]         {"Dullahan",       "Dark",   "Zombie Strike",  "Blood Rain",       "1.5",    ".8",    ".8",    "10"});
        bestiary.put ("Frog Knight", new String[]      {"Frog Knight",    "Aqua",   "Basic Attack",   "Proud Swivel",     ".5",     "1.3",   ".3" ,    "10"});
        bestiary.put ("Phantom", new String[]          {"Phantom",        "Blank",   "Basic Attack",  "Noise Pulse",      ".3",     ".4",    ".4" ,    "10"});
        bestiary.put ("Ice Puppet", new String[]       {"Ice Puppet",     "Aqua",   "Basic Attack",   "Hail Storm",       "1.1",    ".7",    ".8" ,    "10"});
        bestiary.put ("Chinchilla", new String[]       {"Chinchilla",     "Wood",   "Basic Attack",   "Bow Throw",        "1.2",    "1.1",   ".1" ,    "10"});
        bestiary.put ("Elephant Ronin", new String[]   {"Elephant Ronin", "Gale",   "Basic Attack",   "Spiral Assault",   "1.8",    "1.1",   ".8" ,    "10"});
        bestiary.put ("Magmasaur", new String[]        {"Magmasaur",      "Fire",   "Basic Attack",   "Heat Wave",        "1.1",    "1",    "1.2" ,    "10"});
        bestiary.put ("Feral Wolf", new String[]       {"Feral Wolf",     "Gale",   "Basic Attack",   "Feather Duster",   ".9",     "1.1",  "1.1" ,    "10"});
        bestiary.put ("Centaur", new String[]          {"Centaur",        "Wood",   "Basic Attack",   "Arrow Storm",      ".7",     "1.3",  "1.1" ,    "10"});
        bestiary.put ("Harmony Wombat", new String[]   {"Harmony Wombat", "Light",  "Basic Attack",   "Salvation",        ".5",     "1.1",    "1" ,    "10"});
        bestiary.put ("Molten Rock", new String[]      {"Molten Rock",    "Fire",   "Basic Attack",   "Flame Crash",       "2",     ".8",   "1.1" ,    "10"});
        bestiary.put ("Rain Chief", new String[]       {"Rain Chief",     "Aqua",   "Basic Attack",   "Drizzle",          ".5",     ".8",   "1.1" ,    "10"});
        bestiary.put ("Sorcerer", new String[]         {"Sorcerer",       "Dark",   "Basic Attack",   "Arcanite Force",   ".3",     ".1",   "1.4" ,    "10"});
        bestiary.put ("Shark Pirate", new String[]     {"Shark Pirate",   "Aqua",   "Basic Attack",   "Back Stab",       "1.1",     "1.1",    "1" ,    "10"});
        bestiary.put ("Titan", new String[]            {"Titan",         " Fire",   "Basic Attack",   "Finishing Touch", "1.6",     "1.5",   ".1" ,    "10"});
        bestiary.put ("Nokia", new String[]            {"Nokia",         "Blank",    "Basic Attack",  "Assassinate",       "3",     ".1",    ".1" ,    "10"});
    }
    
    //=========================Scaling monsters
    
    public Monster ()
    {
        name = "James";
        element = "Null";
        hpInitial = HP = 20;
        mpInitial = MP = 999999;
        strInitial = str = 10;
        magicInitial = magic = 10;
        defInitial = def = 10;
        resInitial = res = 10;
        luckInitial = luck = 10;
        speedInitial = speed = 10;
        EXP = 0;
        
        
    }
    
    public Monster (String monsterName, int lvl)
    {
        hpInitial = HP = 20;
        mpInitial = MP = 999999;
        strInitial = str = 10;
        magicInitial = magic = 10;
        defInitial = def = 10;
        resInitial = res = 10;
        luckInitial = luck = 10;
        speedInitial = speed = 10;
        EXP = 0;
        
        String[] details = bestiary.get(monsterName);
        name = details[0];
        element = details [1];
        
        known.add (details[2]);
        known.add (details[3]);
        
        hpInitial = HP = (int)(HP * Double.parseDouble (details[4])); 
        strInitial = str = (int)(str * Double.parseDouble (details[5])); 
        magicInitial = magic = (int)(magic * Double.parseDouble (details[6])); 
        
        EXP = Integer.parseInt (details[7]);
        //System.out.println("scaling" + speed);
        this.scale(lvl);
    }
    
    public void scale (int lvl){
        level = lvl;
        hpInitial = HP = (int)(HP * (1 + (int)(level/5)));
        mpInitial = MP = (int)(MP * (1 + level/5));
        strInitial = str = (int)(str * (1 + level/5));
        magicInitial = magic = (int)(magic * (1 + level/5));
        defInitial = def = (int)(def * (1 + level/5));
        resInitial = res = (int)(res * (1 + level/5));
        luckInitial = luck = (int)(luck * (1 + level/5));
        speedInitial = speed = (int)(speed * (1 + level/5));
        //System.out.println(speed);
    }
    

    
     /*
     =========================================================================================================================================================
     ===Battle/Skill Methods========================================================================================================================================
     =========================================================================================================================================================
     */
     
    public void randomSkill (GChar target){
        int index =(int)(Math.random() * known.size());
        String skill = known.get (index);
        this.useSkill(skill, target);
    }
    
    
    
    
   
}