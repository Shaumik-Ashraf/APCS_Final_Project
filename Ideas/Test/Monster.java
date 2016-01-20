import java.io.*;
import java.util.*;

public class Monster extends GChar{
    
    public static HashMap <String, Monster> bestiary = new HashMap <String, Monster>();
    

    
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