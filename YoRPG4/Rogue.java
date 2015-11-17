public class Rogue extends Characters {
    
    //BASE ATTRIBUTES
    
    //METHODS
    
    //constructor
    public Rogue( String n ) {
        name = n;
        desc = "\n              Thy must sneak real good to be able to choose this lifestyle.\n";
        HP = 125;
        strength = 100;
        defense = 40;
        attackrating = .4;
        baseHP = 125;
        baseDefense = 40;
        baseAR = .4;
        jobId = 3;
    }

    //specialize
    public void specialize() {
        defense -= 15;
        attackrating += .2;
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
  