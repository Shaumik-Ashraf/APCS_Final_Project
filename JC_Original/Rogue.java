/*
Your name here
APCS1 pd 9
HW30 -- Ye Olde Role Playing Game, Expanded
2015-11-14
Team Terminal - James Cao, Jongyoul Lee, Conan Wong
*/
public class Rogue extends Character {
    
    //Basic Constructor
    public Rogue(String n){
        name = n;
        HP = 200;
        str = 110;
        def = 30;
        luk = .40;
        rating = .5;
        strInitial = str;
        defInitial = def;
        hpInitial = HP;
        lukInitial = luk;
        ratingIntial = rating;
        details = "A rogue relies solely on the powers of the RNGesus for their strength. While the rogue's base stats are rather standard, their high luck stat has the potential to do devestating damage to their foes.";
    }
    //end of basic constructor
    
    //Overloaded Constructor
    public Rogue (String n, int h,int s, int d, double r){
        name = n;
        HP = h;
        str = s;
        def = d;
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
        System.out.println ("Go, Full House!");
        str += str * (1 + Math.random());
    }//end of secret power
    
   
    public void recover(){
        System.out.println ("Used a potion!");
        if (hpInitial > HP){
        HP += 150;
             if (HP > hpInitial){
                HP = hpInitial;
            }
        }
        else {
            System.out.println ("It had no effect!");}
        healing = true;
        str = 0;
    }
    

    
}