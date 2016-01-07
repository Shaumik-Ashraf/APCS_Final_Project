/*
Your name here
APCS1 pd 9
HW30 -- Ye Olde Role Playing Game, Expanded
2015-11-14
Team Terminal - James Cao, Jongyoul Lee, Conan Wong
*/

public class Wizard extends Character{
    public Wizard(String n){
        name = n;
        HP = 150;
        str = 300;
        def = 20;
        rating = .6;
        luk = .12;
        strInitial = str;
        defInitial = def;
        hpInitial = HP;
        ratingIntial = rating;
        lukInitial = luk;;
        details = "As a wizard, you bend the elements of nature to your will, using spells to invoke the manipulation of your surroundings. Though wizards lack in defense, they make up for it with their magical prowess";
    }
    public Wizard(String n, int h,int s, int d, double r){
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
        System.out.println ("Go,Mind Blast!");
        str *= 2;
        HP /= 2;
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