/* ArcherA class - extend archer and implement Aqua
 * 
 * Notes:
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;
import gameutils.*;
 

public class ArcherA extends Archer implements Aqua {
    
    public ArcherA(ArrayList<String> builder){
    
		super(builder);
        element = "Aqua";
        
        bestStat ("Resistance");
        worstStat ("Luck");
		
		SkillSet.add("hailStorm");
		SkillSet.add("drizzle");
		SkillSet.add("aquaveil");
		
    }
    
	/* Now in Skill
    public void hailStorm (gChar enemy){
        
        SO.println (name + " began the Hail Storm!");
        int hits = 3;
            while (hits != 0){
		        int damage = regAtkM( enemy );
		    	if ( enemy.element.equals ("Wood") ){
            		this.typeAdv = true;
            		damage += regAtk( enemy );
        			}
        
        		if ( enemy.element.equals ("Fire") ){
            	    this.typeDis = true;
            		damage = bestow (enemy, damage);
    				}
		    	if (damage <= 0){
					damage = 0;
		    		}
				SO.println ("The enemy took " + damage + "!\n\n");
				hits --;
            }

        }
     
    //does damage on res based on str stat    
    public void drizzle(gChar enemy){
        SO.println (name + " cast Drizzle!");
        int hits = (int)(Math.random() *4);
        if (hits == 0 ){
            SO.println ("But it failed!");
        }
		while (hits != 0){
			int damage = regAtk( enemy );
			if ( enemy.element.equals ("Fire") ){
				this.typeAdv = true;
				damage += regAtk( enemy );
				}
	
			if ( enemy.element.equals ("Aqua") ){
				this.typeDis = true;
				damage = bestow (enemy, damage);
				}
			if (damage <= 0){
				damage = 0;
				}
			SO.println ("The enemy took " + damage + "!\n\n");
			hits --;
			this.str++;
		}
        this.str = this.strInitial;
    } //close drizzle
        
    public void aquaVeil(){
        SO.println (name + " cast Aqua Veil!");
        SO.println ("The ring of water increased " + name +"'s defenses!");
        def += 4;
       
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
