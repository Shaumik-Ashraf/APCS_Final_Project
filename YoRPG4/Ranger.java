public class Ranger extends Characters {
    
    //BASE ATTRIBUTES

    //METHODS
    
    //constructor
    public Ranger( String n ) {
        name = n;
        desc = "\n              Shoot thy arrow at thine enemies with the grace of a butterfly.\n";
        HP = 125;
        strength = 100;
        defense = 40;
        attackrating = .4;
        baseHP = 125;
        jobId = 5;
        baseDefense = 40;
        baseAR = .4;
    }

    //specialize
    public void specialize() {
        defense -= 10;
        attackrating += .1;
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
  