import java.io.*;
import java.util.*;

public class Monster extends GChar{
    
    public static HashMap <String, String[]> bestiary = new HashMap <String, String[]>();
    
    public static void initMonsters(){
        //====================================         Name                Element   Basic Skill         Spe Skill           xHP        xStr     xMag       EXP   xSpeed
        bestiary.put ("Pumpkin Head", new String[]     {"Pumpkin Head",     "Wood",   "Basic Attack",   "Rekindle",         "1.2",    " 1.2",    ".8" ,    "10",     "1"   });
        bestiary.put ("Moo Cow", new String[]          {"Moo Cow",          "Light",  "Basic Attack",   "Back Stab",        "1.5",      ".8",    ".6" ,    "10",    "10"   });
        bestiary.put ("Dullahan", new String[]         {"Dullahan",         "Dark",   "Zombie Strike",  "Blood Rain",       "1.5",      ".8",     ".8",    "10",   "1.5"   });
        bestiary.put ("Frog Knight", new String[]      {"Frog Knight",      "Aqua",   "Basic Attack",   "Rush Down",         ".5",     "1.3",   " .3" ,    "10",   "1.2"   });
        bestiary.put ("Phantom", new String[]          {"Phantom",         "Blank",   "Basic Attack",   "Noise Pulse",       ".5",      ".4",    ".4" ,    "10",    ".5"   });
        bestiary.put ("Ice Puppet", new String[]       {"Ice Puppet",       "Aqua",   "Basic Attack",   "Icicle Charge",    "1.1",      ".7",    ".8" ,    "10",    ".8"   });
        bestiary.put ("Chinchilla", new String[]       {"Chinchilla",       "Wood",   "Basic Attack",   "Curtains",         "1.2",     "1.1",    ".1" ,    "10",    ".5"   });
        bestiary.put ("Elephant Ronin", new String[]   {"Elephant Ronin",   "Gale",   "Basic Attack",   "Spiral Assault",   "1.8",     "1.1",    ".8" ,    "10",   "1.5"   });
        bestiary.put ("Magmasaur", new String[]        {"Magmasaur",        "Fire",   "Basic Attack",   "Heat Wave",        "1.1",       "1",   "1.2" ,    "10",   "1.2"   });
        bestiary.put ("Feral Wolf", new String[]       {"Feral Wolf",       "Gale",   "Basic Attack",   "Feather Duster",    ".9",     "1.1",  " 1.1" ,    "10",   "1.4"   });
        bestiary.put ("Centaur", new String[]          {"Centaur",          "Wood",   "Holy Smite",   "  Arrow Storm",       ".7",     "1.3",   "1.1" ,    "10",   "1.2"   });
        bestiary.put ("Harmony Wombat", new String[]   {"Harmony Wombat",  "Light",   "Vampire",        "Salvation",         ".5",     "1.1",     "1" ,    "10",   "1.1"   });
        bestiary.put ("Molten Rock", new String[]      {"Molten Rock",      "Fire",   "Inner Fire",     "Flame Crash",        "2",      ".8",   "1.1" ,    "10",    ".7"   });
        bestiary.put ("Rain Chief", new String[]       {"Rain Chief",       "Aqua",   "Basic Attack",   "Drizzle",           ".5",      ".8",   "1.1" ,    "10",     "1"   });
        bestiary.put ("Sorcerer", new String[]         {"Sorcerer",         "Dark",   "Brain Shock",   "Arcanite Force",     ".4",      ".1",   "1.4" ,    "10",    ".9"   });
        bestiary.put ("Shark Pirate", new String[]     {"Shark Pirate",     "Aqua",   "Basic Attack",   "Back Stab",        "1.1",     "1.1",     "1" ,    "10",   "1.2"   });
        bestiary.put ("Titan", new String[]            {"Titan",           " Fire",   "Basic Attack",   "Finishing Touch",  "1.6",     "1.5",    ".1" ,    "10",    ".5"   });
        bestiary.put ("Nokia", new String[]            {"Nokia",           "Blank",   "Basic Attack",   "Assassinate",       "30",      ".1",    ".1" ,    "10",    ".1"   });
        bestiary.put ("Axe Villager", new String[]     {"Axe Villager",    " Wood",   "Basic Attack",   "Strong Swing",       "1",       "2",    ".1" ,    "10",     "1"   });
        bestiary.put ("Gelatinous Cube", new String[]  {"Gelatinous Cube",  "Aqua",   "Basic Attack",   "Tidal Wave",       "2.5",      ".1",    ".1" ,    "10",    ".9"   });
        bestiary.put ("Hollow Golem", new String[]     {"Hollow Golem",    "Light",   "Basic Attack",   "Planet",           "2.5",     "1.2",    ".1" ,    "10",    ".9"   });
        bestiary.put ("Magitek Delta", new String[]    {"Magitek Delta",    "Dark",   "Basic Attack",   "Arcane Bullets",   "1.1",      ".1",    "1.2",    "10",    ".8"   });    
        bestiary.put ("Magitek Epsilon", new String[]  {"Magictek Epsilon","Light",   "Basic Attack",   "Arcanite Force",   "1.1",      ".1",    "1.4",    "10",    ".7"   });
        bestiary.put ("Air Chair", new String[]        {"Air Chair",        "Gale",   "Basic Attack",   "Luster Wave",       ".4",     "1.1",    ".7" ,    "10",   "1.4"   });
        bestiary.put ("Sword Beetle", new String[]     {"Sword Beetle",     "Wood",   "Strong Swing",   "Proud Swivel",     "1.1",     "1.5",    ".7" ,    "10",   "1.4"   });
        bestiary.put ("Trap Box", new String[]         {"Trap Box",        "Blank",   "Spiral Assault", "Heat Wave",        "1.5",     "1.2",    "1.2",    "10",   "1.2"   });
        bestiary.put ("Danger Beast", new String[]     {"Danger Beast",     "Fire",   "Flame Crash",    "Spiral Assault",   "1.6",     "1.5",    "1.5",    "10",   "1.5"   });
        bestiary.put ("Stage Killer", new String[]     {"Stage Killer",     "Aqua",   "Assassinate",    "Shuffle Time",  "   1.1",     "1.1",    "1.1",    "10",   "1.8"   }); 
        bestiary.put ("Modern Airplane", new String[]  {"Modern Airplane", "Blank",   "Basic Attack",   "Fatal Shot",         "2",      ".8",     ".8",    "10",     "1"   });
        bestiary.put ("Mossgreen Moss", new String[]   {"Mossgreen Moss",  "Light",   "Basic Attack",   "Luster Wave",      "1.2",     "1.1",    "1.1",    "10",   "1.1"   });
        bestiary.put ("Future Fencer", new String[]    {"Future Fencer",    "Dark",   "Finishing Touch","Darkness",         "1.2",     "1.7",    "1.5",    "10",   "1.6"   });
        bestiary.put ("Desert Snail", new String[]     {"Desert Snail",     "Fire",   "Basic Attack",   "Heat Wave",          "1",     "1.1",    "1.3",    "10",   ".4"    });
        bestiary.put ("Boomerang Shark", new String[]  {"Boomerang Shark",  "Aqua",   "Finishing Touch","Tidal Wave",       "1.2",     "1.7",    "1.7",    "10",   "1.5"   });
        bestiary.put ("Destiny Ferret", new String[]   {"Destiny Ferret",   "Dark",   "Flower Dance",   "Blood Rain",       "1.1",     "1.5",    "1.5",    "10",     "1"   });
        bestiary.put ("Cardboard Fox", new String[]    {"Cardboard Fox",    "Wood",   "Seed Burst",     "Flower Dance",     "1.2",      ".8",    "1.1",    "10",   "1.2"   });
        bestiary.put ("Granola Dragon", new String[]   {"Granola Dragon",   "Fire",   "Basic Attack",   "Inferno",          "1.6",      ".4",    "1.5",    "10",   "1.6"   });
        bestiary.put ("Cliff Chomper", new String[]    {"Cliff Chomper",   "Light",   "Rush Down",      "Finishing Touch",    "2",     "1.8",     ".1",    "10",   ".4"    });
        bestiary.put ("Paint Scarecrow", new String[]  {"Paint Scarecrow", "Light",   "Basic Attack",   "Shuffle Time",     "1.1",     "1.3",    "1.3",    "10",   ".1"    });
        bestiary.put ("Chain Reaper", new String[]     {"Chain Reaper",     "Dark",   "Blood Rain",     "Brain Shock",        "2",     "1.9",    "1.3",    "10",   "1.3"   });
        bestiary.put ("Cloudforce Knight", new String[]{"Cloudforce Knight","Gale",   "Basic Attack",   "Feather Duster",   "1.2",     "1.4",    "1.4",    "10",   "1.6"   });
        bestiary.put ("Frankenfish", new String[]      {"Frankenfish",      "Aqua",   "Brain Shock",    "Tidal Wave",         "1",     "1.1",    "1.1",    "10",   "2.1"   });
        bestiary.put ("Neon Werewolf", new String[]    {"Neon Werewolf",   "Light",   "Flower Dance",   "Radiance",         "1.1",     "1.6",    "1.6",    "10",   "1.1"   });
        bestiary.put ("Bear Lancer", new String[]      {"Bear Lancer",      "Wood",   "Proud Swivel",   "Wood Spike",       "1.8",       "2",      "1",    "10",   ".6"    });
        bestiary.put ("Goat Commander", new String[]   {"Goat Commander",   "Gale",   "Basic Attack",   "Fatal Shot",       "1.3",     "1.2",    "1.1",    "10",   "1.3"   });
        bestiary.put ("Mega Eagle", new String[]       {"Mega Eagle",       "Fire",   "Feather Duster", "Rush Down",        "1.1",     "1.5",     ".6",    "10",   "1.7"   });
        bestiary.put ("Manabot", new String[]          {"Manabot",         "Blank",   "Brain Shock",    "Arcanite Force",   "1.7",      ".7",    "1.8",    "10",   ".7"    });
        bestiary.put ("Spirit Corn", new String[]      {"Spirit Corn",      "Wood",   "Luster Wave",    "Pepper Song",      "1.2",     "1.7",    "1.5",    "10",   "1.6"   });
        bestiary.put ("Solar Spider", new String[]     {"Solar Spider",    "Light",   "Heat Wave",      "Radiance",           "1",     "1.1",    "1.6",    "10",   "1.7"   });
        bestiary.put ("Alucard's Dog", new String[]    {"Alucard's Dog",    "Dark",   "Zombie Strike",  "Vampire",          "1.1",     "1.6",    "1.3",    "10",   "1.8"   });
        bestiary.put ("Soul Turtle", new String[]      {"Soul Turtle",      "Aqua",   "Arcane Bullets", "Tidal Wave",       "1.6",     "1.1",    "1.9",    "10",   ".1"    });
        bestiary.put ("Nox", new String[]              {"Nox",              "Dark",   "Zombie Strike",  "Shuffle Time",       "2",       "2",      "2",    "10",   "1.7"   });
        bestiary.put ("Vinewich", new String[]         {"Vinewich",         "Wood",   "Seed Burst",     "Wood Spike",       "1.4",     "1.6",    "1.7",    "10",   "1.3"   });
        bestiary.put ("Trident Lion", new String[]     {"Trident Lion",     "Aqua",   "Geyser",         "Rush Down",        "1.8",     "1.6",    "1.5",    "10",   "2"     });
        bestiary.put ("Candle Speaker", new String[]   {"Candle Speaker",   "Fire",   "Rekindle",       "Heat Wave",        "1.5",     "1.1",    "1.9",    "10",   "1.4"   });
        bestiary.put ("Lodestar", new String[]         {"Lodestar",        "Light",   "Holy Smite",     "Luster Wave",        "2",       "2",      "2",    "10",   "1.7"   });
        bestiary.put ("Psychoham", new String[]        {"Psychoham",        "Gale",   "BasicAttack",    "Pickpocket",       "1.6",     "1.1",    "1.1",    "10",   "2.1"   });
        bestiary.put ("Magictek Beta", new String[]    {"Magitek Beta",    "Blank",   "Brain Shock",    "Mana Burst",         "1",       "1",      "2",    "10",   "1.9"   });
        bestiary.put ("Fair Gunslinger", new String[]  {"Fair Gunslinger",  "Fire",   "Quick Draw",     "Fatal Shot",       "1.8",     "1.7",    "1.2",    "10",   "1.7"   });
        bestiary.put ("Atlas", new String[]            {"Atlas",           "Light",   "Strong Swing",   "Planet",             "2",       "2",      "0",    "10",   "1.5"   });
        bestiary.put ("Mercenary", new String[]        {"Mercenary",       "Blank",   "Assassinate",    "Arrow Storm",      "1.5",     "1.9",    "1.5",    "10",   "2.2"   });
        bestiary.put ("Forte Flutist", new String[]    {"Forte Flutist",    "Wood",   "Arcanite Forte", "Tidal Wave",       "1.1",     "1.1",    "2.1",    "10",   "1.1"   });
        bestiary.put ("Felldragon", new String[]       {"Felldragon",       "Dark",   "Heat Wave",      "Rush Down",        "2.4",     "2.5",    "2.5",    "10",   "2.5"   });
        bestiary.put ("Grand Wall", new String[]       {"Grand Wall",      "Blank",   "BasicAttack",    "Pepper Song",        "3",      ".5",     ".5",    "10",   ".1"    });
        bestiary.put ("Elegant Dancer", new String[]   {"Elegant Dancer",   "Aqua",   "Flower Dance",   "Shuffle Time",     "1.5",     "1.3",    "1.1",    "10",   "1.7"   });
        bestiary.put ("Reckless Sage", new String[]    {"Reckless Sage",    "Gale",   "Mana Burst",     "Inner Fire",       "2.4",     "1.1",    "2.1",    "10",   "1.1"   });
        bestiary.put ("Undead Zombie", new String[]    {"Undead Zombie",   "Light",   "Zombie Strike",  "Vampire",          "1.2",     "1.5",    "1.1",    "10",   "1.2"   });
        bestiary.put ("Heroic Donut", new String[]     {"Heroic Donut",     "Fire",   "Finishing Touch","Back Stab",        "1.5",     "1.8",    "1.1",    "10",   "1.7"   });
        bestiary.put ("Autotune", new String[]         {"Autotune",        "Blank",   "Pepper Song",    "Noise Pulse",      "1.4",     "  1",      "1",    "10",   "1.5"   });
        bestiary.put ("Imposter Mage", new String[]    {"Imposter Mage",    "Aqua",   "Brain Shock",    "Strong Swing",     "2.5",     "1.9",     ".5",    "10",   "1.1"   });
        bestiary.put ("Ribobon", new String[]          {"Ribobon",          "Wood",   "Luster Wave",    "Seed Burst",       "1.5",     "1.4",    "1.4",    "10",   "1.3"   });
        bestiary.put ("Goblin Salesman", new String[]  {"Goblin Salesmen", "Blank",   "Shuffle Time",   "Hurricane Force",  "1.5",     "1.7",    "1.7",    "10",   "1.3"   });
        
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
        gold = 100;
        EXP = 0;
        
        String[] details = bestiary.get(monsterName);
        name = details[0];
        element = details [1];
        
        known.add (details[2]);
        known.add (details[3]);
        
        hpInitial = HP = (int)(HP * Double.parseDouble (details[4])); 
        strInitial = str = (int)(str * Double.parseDouble (details[5])); 
        magicInitial = magic = (int)(magic * Double.parseDouble (details[6])); 
        speedInitial = speed = (int)(speed * Double.parseDouble (details[8])); 
        
        EXP = Integer.parseInt (details[7]);
        //System.out.println("scaling" + speed);
        this.scale(lvl);
    }
    
    public void scale (int lvl){
        level = lvl;
        hpInitial = HP = (int)(HP * (1 + (int)(level/5)));
        mpInitial = MP = (int)(MP * (1 + (int)level/5));
        strInitial = str = (int)(str * (1 + (int)level/5));
        magicInitial = magic = (int)(magic * (int)(1 + level/5));
        defInitial = def = (int)(def * (1 + (int)level/5));
        resInitial = res = (int)(res * (1 + (int)level/5));
        luckInitial = luck = (int)(luck * (1 + (int)level/5));
        speedInitial = speed = (int)(speed * (1 + (int)level/5));
        gold *= (int)(level/5);
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
