/*
Your name here
APCS1 pd 9
HW30 -- Ye Olde Role Playing Game, Expanded
2015-11-14
Team Terminal - James Cao, Jongyoul Lee, Conan Wong
*/
public class Priest extends Character {
    
    //Basic Constructor
    public Priest(String n){
        name = n;
        HP = 400;
        str = 100;
        def = 45;
        luk = .15;
        rating = .6;
        strInitial = str;
        defInitial = def;
        hpInitial = HP;
        ratingIntial = rating;
        lukInitial = luk;
        details ="The priest has relatively low offense stats, but makes up for it with high health and ability to recover health. One could say that the priest is quite the tanky class.";
    }
    //end of basic constructor
    
    //Overloaded Constructor
    public Priest (String n, int h,int s, int d, double r){
        name = n;
        HP = h;
        str = s/2;
        def *= 2;
        rating = r;
    }
    
    public String about(){
        return details;
    } 
    
    public void normalize(){
        healing = false;
        str = strInitial;
        def = defInitial;
        rating = ratingIntial;
        luk = lukInitial;}    
    
    //Super special secret power
    public void specialize(){
        System.out.println ("Go, Heavenly Guard!");
        str += 20;
        def += 20;
        HP += 10;
    }//end of secret power
    
    
     
    public void recover(){
         System.out.println ("Used Heal!");
        if (hpInitial > HP){
        HP += 300;
            if (HP > hpInitial){
                HP = hpInitial;
            }
        }
        else {
            System.out.println ("It had no effect!");}
        healing = true;
        str = 0;
    }
    
    
  
    /* just wanted to leave this here as a comment for later
    public void heal(Character other){
        other.HP += 50;
        return 50;
    }
    */
}