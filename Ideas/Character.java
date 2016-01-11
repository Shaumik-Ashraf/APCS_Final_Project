import java.io.*;
import java.util.*;

public abstract class Character{
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
    //public boolean healing; //if true, the player will skip their attack and heal
    
    //used for normalize
    public int hpInitial;
    public int strInitial;
    public int magicInitial;
    public int defInitial;
    public int resInitial;
    public int luckInitial;
    public int speedInitial;
    
    
    //Basic attack that every character can perform
    public int regAtk( Character enemy){
        this.crit = false; //Crit activation is set to false
        int damage = this.str - enemy.def; //Work in progress. This is the damage that your character will do
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.str )- (enemy.def /1.03) ) ;//This will be the new damage your character does
        }
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    }
    
    
    public void bestStat(String stat){
        if (stat.equals ("Health")){
            HP *= 1.5;
        }
        else if (stat.equals ("Strength")){
            str *= 1.5;
        }
        
        else if (stat.equals ("Magic")){
            magic *= 1.5;
        }
        
        else if (stat.equals ("Defense")){
            def *= 1.5;
        }
        
        else if (stat.equals ("Resistance")){
            res *= 1.5;
        }
        
        else if (stat.equals ("Luck")){
            luck *= 1.5;
        }
        
        else if (stat.equals ("Speed")){
            speed *= 1.5;
        }
        else{
            System.out.println ("Something went wrong...");
        }
    }
    public void worstStat(String stat){
         if (stat.equals ("Health")){
            HP *= .5;
        }
        else if (stat.equals ("Strength")){
            str *= .5;
        }
        
        else if (stat.equals ("Magic")){
            magic *= .5;
        }
        
        else if (stat.equals ("Defense")){
            def *= .5;
        }
        
        else if (stat.equals ("Resistance")){
            res *= .5;
        }
        
        else if (stat.equals ("Luck")){
            luck *= .5;
        }
        
        else if (stat.equals ("Speed")){
            speed *= .5;
        }
        else{
            System.out.println ("Something went wrong...");
        }
        
    }
    
    public void statSheet(){
        ArrayList<String> stats = new ArrayList();
        stats.add("HP:" + HP);
        stats.add("Str:" + str);
        stats.add("Magic:" +magic);
        stats.add("Def:" + def);
        stats.add("Res:" + res);
        stats.add("Luck:" + luck);
        stats.add("Speed:" + speed);
        System.out.println (stats);
    }
    
    public abstract void normalize();
    
    
    
    
    
}