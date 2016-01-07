/*
Your name here
APCS1 pd 9
HW30 -- Ye Olde Role Playing Game, Expanded
2015-11-14
Team Terminal - James Cao, Jongyoul Lee, Conan Wong
*/
public class Warrior extends Character {
    

    
    //Basic Constructor
    public Warrior(String n){
        name = n;
        HP = 300;
        str = 290;
        def = 45;
        rating = .5;
        luk = .1;
        strInitial = str;
        defInitial = def;
        hpInitial = HP;
        ratingIntial = rating;
        lukInitial = luk;
        details = "As a warrior you command upon your will and integrity to bring your desires to fruition. Though lacking in accuracy, the warrior is capable of withstanding damage and dealing fatal melee blows.";
    }
    //end of basic constructor
    
    //Overloaded Constructor
    public Warrior (String n, int h,int s, int d, double r){
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
        System.out.println ("Go, Fatal Smash!");
        str += 110;
        def /= 2;
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
    }}