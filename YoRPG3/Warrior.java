public class Warrior extends Characters {
    
    //BASE ATTRIBUTES
    
    //METHODS
    
    //constructor
    public Warrior( String n ) {
        name = n;
        desc = "\n              The strongest knight in the brothel.\n";
        HP = 125;
        strength = 100;
        defense = 40;
        attackrating = .4;
        
        baseHP = 125;
        baseDefense = 40;
        baseAR = .4;
        jobId = 1;
    }

    public void specialize()
    {
        defense += 13;
        attackrating -= .1;
    }

    public void normalize() {
            defense = baseDefense;
            attackrating = baseAR;
        }
    
    public String about()
    {
        return desc;
    }

}
  