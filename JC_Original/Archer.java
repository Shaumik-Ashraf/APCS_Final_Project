/*
Your name here
APCS1 pd 9
HW30 -- Ye Olde Role Playing Game, Expanded
2015-11-14
Team Terminal - James Cao, Jongyoul Lee, Conan Wong
*/
public class Archer extends Character {
    
    //used to normalize attack and defense values
    
    //Basic Constructor
    public Archer(String n){
        name = n;
        HP = 200;
        str = 140;
        def = 30;
        luk = .15;
        rating = .9;
        strInitial = str;
        defInitial = def;
        hpInitial = HP;
        ratingIntial = rating;
        lukInitial = luk;
        details = "An archer has neither significant flaws nor strengths. They have practiced their ability to attack while at the same time watching their back.";
        
    }
    //end of basic constructor
    
    //Overloaded Constructor
    public Archer (String n, int h,int s, int d, double r){
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
        System.out.println ("Go, Strike Shot!");
        rating *= 2;
        luk += .1;
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