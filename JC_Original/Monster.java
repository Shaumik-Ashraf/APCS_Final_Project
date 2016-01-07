/*
Your name here
APCS1 pd 9
HW30 -- Ye Olde Role Playing Game, Expanded
2015-11-14
Team Terminal - James Cao, Jongyoul Lee, Conan Wong
*/
public class Monster extends Character{
    
    
    //Basic constructor    
    public Monster(){
        HP = (int)(Math.random() * (1500-100) +1);
        str = (int)(Math.random() * (90-30) +1);
        def = (int)(Math.random() * (90-30) +1);
        luk = 0;
        rating = 2;
    }//end of 
    
    public void specialize(){}
    
    public void normalize(){}
      
    public void recover(){}
    
    public String about(){
        return "";
    } 
    
}