/* WarriorF class - extend warrior and implement Fire
 * 
 * Notes:
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;
import gameutils.*;
 

public class WarriorF extends Warrior implements Fire {
    
    public WarriorF (ArrayList<String> player){
        super(player);
        element = "Fire";
        
		bestStat ("Strength");
        worstStat ("Resistance");
        
		SkillSet.add("Heat Wave");
		SkillSet.add("Rekindle");
		SkillSet.add("Flame Crash");
		
		
    }
    
	/* Now in Skill
    public int heatWave(gChar enemy){
        SO.println (name + " cast Heat Wave!");
        this.crit = false; //Crit activation is set to false
        int damage = this.magic - enemy.res; //Work in progress. This is the damage that your character will do
        
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.magic )- (enemy.res /1.03) ) ;//This will be the new damage your character does
        }
        
        if ( enemy.element.equals ("Wood") ){
            this.typeAdv = true;
            damage *= 2;
        }
        
        if ( enemy.element.equals ("Aqua") ){
            this.typeDis = true;
            damage /= 2;
        }
        
        if (damage <= 0){
            damage = 0;
        }
        SO.println ("The enemy took " + damage + "!\n\n");
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    
        }
        
        
    //does damage on res based on str stat    
    public int flameCrash(gChar enemy){
        SO.println (name + " used Flame Crash!");
        this.crit = false; //Crit activation is set to false
        int damage = this.str - enemy.def; //Work in progress. This is the damage that your character will do
        
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.str )- (enemy.def /1.03) ) ;//This will be the new damage your character does
        }
        
        if ( enemy.element.equals ("Wood") ){
            this.typeAdv = true;
            damage *= 2;
        }
        
        if ( enemy.element.equals ("Aqua") ){
            this.typeDis = true;
            damage /= 2;
        }
        
        if (damage <= 0){
            damage = 0;
        }
        SO.println ("The enemy took " + damage + "!\n\n");
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    
        }
    
    
        
    public void reKindle(){
        SO.println (name + " cast Rekindle!");
        SO.println (name + " is enveloped by a firey aura! Resistance to magic has increased!");
        res += 4;
    }
    
    public String skillListChange( String skillList){
        if (this.level == 2){
            skillList += "Proud Swivel\n";
            System.out.println (this.name + " learned Proud Swivel!");
        }
        
        if (this.level == 3){
            skillList += "Finishing Touch\n";
            System.out.println (this.name + " learned Finishing Touch!");
        }
        
        return skillList;
    }
    
    public ArrayList<String> skillChange( ArrayList<String> skills){
         if (this.level == 2){
             skills.add ("Proud Swivel");
         }
         if (this.level == 3){
             skills.add ("Finishing Touch");
         }
         return skills;
    }
    
    */  
      
}