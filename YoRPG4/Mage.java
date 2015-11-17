public class Mage extends Characters {
    
    //BASE ATTRIBUTES
    
    //METHODS
    
    //constructor
    public Mage ( String n ) {
        name = n;
        desc = "\n              The Wisest mate in thy high kingdom.\n";
        HP = 100;
        strength = 80;
        defense = 60;
        attackrating = .7;
        baseHP = 100;
        baseDefense = 60;
        baseAR = .7;
        jobId = 2;
    }

    //specialize
    public void specialize() {
        defense -= 20;
        attackrating += .5;
    }
    
    //normalize
    public void normalize() {
        defense = baseDefense;
        attackrating = baseAR;
    }
    
    public String about()
    {
        return desc;
    }

}
  