public class Priest extends Characters {
    
    //BASE ATTRIBUTES
    
    //METHODS
    
    //constructor
    public Priest( String n ) {
        name = n;
        desc = "\n              Un bueno sacerdote de la casa de god, y un luchador bueno.\n";
        HP = 125;
        strength = 100;
        defense = 40;
        attackrating = .4;
        baseHP = 125;
        baseDefense = 40;
        baseAR = .4;
        jobId = 0;
    }

    //specialize
    public void specialize() {
        defense += 20;
        attackrating -= .2;
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
  