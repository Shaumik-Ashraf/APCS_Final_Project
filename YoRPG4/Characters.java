public abstract class Characters {
    
    protected String name;
    protected int HP;
    protected int strength;
    protected int defense;
    protected double attackrating;
    protected static String desc;
    protected int baseHP;
    protected int baseDefense;
    protected double baseAR;
    protected int jobId;
    
    //isAlive
    public boolean isAlive() {
        boolean status = true;
        if (HP > 0) {
	        status = true;
        }
        else {
	        status = false;
        }
        return status;
    }
    
    //getDefense
    public int getDefense() {
        return defense;
    }
    
    //lowerHP
    public void lowerHP(int damage) {
        HP -= damage;
    }
    
    public String getName()
    {
     return name;   
    }
    
    //attack
    public int attack(Characters Characters1) {
        int damage;
        damage = (int)((strength * attackrating) - Characters1.getDefense());
        if (damage < 0)
        {
            damage = 0;
        }
        Characters1.lowerHP(damage);
        return damage;
    }
    
    //about
    public abstract String about();
    
        //specialize
    public abstract void specialize();
    
    //normalize
    public abstract void normalize();
    
    public int getJobID()
    {
        return jobId;
    }
    
    public String toString()
    {
        String s = ("HP: " + HP + "/" + baseHP + "\n");
        return s;
    }
}

