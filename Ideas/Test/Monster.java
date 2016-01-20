import java.io.*;
import java.util.*;

public class Monster extends GChar{
    
    public static HashMap <String, String[]r> bestiary = new HashMap <String, Monster>();
    

    
    public Monster(){}
    
    //Skills
    protected ArrayList<String> known = new ArrayList<String>();
    
    public void initMonsters()
    {
        bestiary.put ("Pumpkin Head", new String[" insert mods here"] );
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
     =========================================================================================================================================================
     ===Battle/Skill Methods========================================================================================================================================
     =========================================================================================================================================================
     */
     
    public void randomSkill (Monster target){
        int index =(int)(Math.random() * known.size());
        String skill = known.get (index);
        this.useSkill(skill, target);
    }
    
    
    
    
   
}