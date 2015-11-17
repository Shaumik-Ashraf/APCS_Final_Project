public class Monster extends Characters {
    //METHODS
  
    //constructor
    public Monster() {
        name = "Enemy";
        HP = 150;
        strength = (int)(Math.random()*45 + 20);
        defense = 20;
        attackrating = 1;
        baseHP = 150;
    }
    
    public void specialize()
    {
        
    }
    
    public void normalize()
    {
    
    }
    public String about()
    {
        if (HP > ((int)(baseHP*.75)))
        {
            return ("Ye Olde Monster appears unscathed...");
        }
        else if (HP > ((int)(baseHP*.30)))
        {
            return ("Ye Olde Monster is wounded...");
        }
        else
        {
            return ("Ye Olde Monster is near dissolution!");
        }
    }

}