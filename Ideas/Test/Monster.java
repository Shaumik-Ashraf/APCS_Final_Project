import java.io.*;
import java.util.*;

public class Monster extends GChar{
    
    public static HashMap <String, String[]> bestiary = new HashMap <String, String[]>();
    
    // Inventory i;
    
    
    public static void initMonsters()
    {
        //====================================      Name            Element   Basic Skill       Spe Skill      xHP     xStr   xMag  EXP
        bestiary.put ("Pumpkin Head", new String[] {"Pumpkin Head", "Wood",   "Basic Attack",   "Rekindle",    "1.2",  "1.2", ".8" , "10"});
        bestiary.put ("Moo Cow", new String[]      {"Moo Cow",      "Light",  "Basic Attack",   "Back Stab",   "1.5",  ".8",  ".6" , "10"});
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
    
    public Monster (String[] details)
    {
        this();
        name = details[0];
        element = details [1];
        
        known.add (details[2]);
        known.add (details[3]);
        
        hpInitial = HP = (int)(HP * Double.parseDouble (details[4])); 
        strInitial = str = (int)(str * Double.parseDouble (details[5])); 
        magicInitial = magic = (int)(magic * Double.parseDouble (details[6])); 
        
        EXP = Integer.parseInt (details[7]);
    }
    
    public void scale (int lvl){
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