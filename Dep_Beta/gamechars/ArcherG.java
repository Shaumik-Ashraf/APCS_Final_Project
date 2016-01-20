/* ArcherA class - extend Archer and implement Gale
 * 
 * Notes:
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;
import gameutils.*;
 

public class ArcherG extends Archer implements Gale {
    
    public ArcherG (ArrayList<String> player){

    	super(player);
        element = "Gale";
    
		bestStat("Agility");
		worstStat("Defense");
	
		SkillSet.add("Tail Wind");
		SkillSet.add("Spiral Assault");
		SkillSet.add("Feather Duster");
	
    }
    
	/*  Now in Skill
    public int windStrike(gChar enemy){
        SO.println (name + " cast Wind Strike!");
        this.crit = false; //Crit activation is set to false
        int damage = this.str - enemy.res; //Work in progress. This is the damage that your character will do
        
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.magic )- (enemy.def /1.03) ) ;//This will be the new damage your character does
        }
        /*
        if ( enemy.element.equals ("Fire") ){
            this.typeAdv = true;
            damage *= 2;
        }
        
        if ( enemy.element.equals ("Aqua") ){
            this.typeDis = true;
            damage /= 2;
        }*
        
        if (damage <= 0){
            damage = 0;
        }
        SO.println ("The enemy took " + damage + "!\n\n");
        
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    
        }
        
        
    //does multiple regular attacks   
    public int galeForce(gChar enemy){
       SO.println (name + " cast Wind Strike!");
        this.crit = false; //Crit activation is set to false
        int damage = this.str - enemy.def; //Work in progress. This is the damage that your character will do
        
        
        if ( (Math.random() *60) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.str )- (enemy.def /1.03) ) ;//This will be the new damage your character does
        }
        
      /*  if ( enemy.element.equals ("Fire") ){
            this.typeAdv = true;
            damage *= 2;
        }
        
        if ( enemy.element.equals ("Aqua") ){
            this.typeDis = true;
            damage /= 2;
        }*
        
        if (damage <= 0){
            damage = 0;
        }
        SO.println ("The enemy took " + damage + "!\n\n");
        
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    
        }
    
    
        
    public void tailWind(){
        SO.println (name + " started a Tail Wind!");
        SO.println ("The gust of wind made " + name + " faster!");
        speed += 4;
    }
    
   
     public String skillListChange( String skillList){
        if (this.level == 2){
            skillList += "Arrow Storm\n";
            System.out.println (this.name + " learned Arrow Storm!");
        }
        
        if (this.level == 3){
            skillList += "Focus\n";
            System.out.println (this.name + " learned Focus!");
        }
        
        return skillList;
    }
    
    public ArrayList<String> skillChange( ArrayList<String> skills){
         if (this.level == 2){
             skills.add ("Arrow Storm");
         }
         if (this.level == 3){
             skills.add ("Focus");
         }
         return skills;
    }
        
    */
	 
}  //close class

