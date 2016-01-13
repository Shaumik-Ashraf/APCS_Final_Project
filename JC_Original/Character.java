/*
Your name here
APCS1 pd 9
HW30 -- Ye Olde Role Playing Game, Expanded
2015-11-14
Team Terminal - James Cao, Jongyoul Lee, Conan Wong
*/

public abstract class Character{
    
    //Basic properties of all characters.
    public String name;
    public String details;
    public int HP;
    public int str;
    public int def;
    public double luk;
    public double rating;
    public boolean crit;
    public boolean healing;
    
    //used to normalize attack and defense values
    int strInitial = 0;
    int defInitial = 0;
    int hpInitial = 0;
    double lukInitial = 0;
    double ratingIntial = 0;
    //end of properties
    
    //Dead or alive?
    public boolean isAlive(){
        return (HP > 0);
    }// Only time will Tell
    
    //Accessors
    public int getDefense(){
        return def;
    }
    
    public String getName() {
        return name;
    }//end of accessors
    
    public abstract String about();

    //Taking damage
    public void lowerHP(int damage){
        this.HP -= damage;
    }// Owch
    
    //COUNTERATTACK. GO SWORDHAND.
    public int attack (Character other){
        this.crit = false;
        int damage = (int)((this.str * this.rating) - other.def);
        if (Math.random() <= luk){
            this.crit = true;
            damage *= (int)((this.str * this.rating)- (other.def /1.03));
        }
        other.HP -= damage;
        return damage;
    }//HEEEYAHHHHHH
    
    public abstract void specialize();
    
    public abstract void normalize();
    
    public abstract void recover();
    
   
    /*Copy this into other classes
      public void normalize(){
        str = strInitial;
        def = defInitial;
        rating = ratingIntial;
        luk = lukInitial;
    }*/
 
    
  
}