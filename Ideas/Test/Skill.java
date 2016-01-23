import java.util.*;

public abstract class Skill
{
    protected int mpCost;
    public static HashMap<String,Skill> allSkills = new HashMap<String,Skill>();
    
    public static void consAllSkills()
    {
        allSkills.put("Basic Attack", new basicAttack());
        allSkills.put("Basic AttackM", new basicAttackM());
        
        //Warrior Skills
        allSkills.put("Strong Swing", new strongSwing());
        allSkills.put("Proud Swivel", new proudSwivel());
        allSkills.put("Finishing Touch", new finishingTouch());
        allSkills.put("War Cry", new warCry());
        allSkills.put("Rush Down", new rushDown());
        allSkills.put("Weaken", new weaken());
        
        //Archer Skills
        allSkills.put("Bow Throw", new bowThrow());
        allSkills.put("Arrow Storm", new arrowStrom());
        allSkills.put("Focus", new focus());
        allSkills.put ("Markdown", new markDown());
        allSkills.put ("Fatal Shot", new fatalShot());
        allSkills.put ("Quick Draw", new quickDraw());
        
        //Mage Skills
        allSkills.put("Arcanite Force", new arcaniteForce());
        allSkills.put("Arcane Bullets", new arcaneBullets());
        allSkills.put("Concentrate", new concentrate());
        allSkills.put("Stagnate", new stagnate());
        allSkills.put("Brain Shock", new brainShock());
        allSkills.put("Mana Break", new manaBreak());
        
        //Rogue Skills
        allSkills.put ("Back Stab", new backStab());
        allSkills.put ("Assassinate", new assassinate());
        allSkills.put ("Gamble", new gamble());
        allSkills.put ("Curtains", new curtains());
        allSkills.put ("Shuffle Time", new shuffleTime());
        allSkills.put ("Pickpocket", new pickpocket());
        
        //Fire skills
        allSkills.put("Heat Wave", new heatWave());
        allSkills.put("Rekindle", new reKindle());
        allSkills.put ("Flame Crash", new flameCrash());
        allSkills.put ("Inner Fire", new innerFire());
        allSkills.put ("Inferno", new inferno());
        
        //Aqua Skills
        allSkills.put("Hail Storm", new hailStorm());
        allSkills.put ("Tidal Wave", new tidalWave());
        allSkills.put ("Aqua Veil", new aquaVeil());
        allSkills.put ("Icicle Charge", new icicleCharge());
        allSkills.put ("Geyser", new geyser());
        
        //Wood Skills
        allSkills.put("Flower Dance", new flowerDance());
        allSkills.put ("Wood Spike", new woodSpike());
        allSkills.put ("Pepper Song", new pepperSong());
        allSkills.put ("Seed Burst", new seedBurst());
        allSkills.put ("Planet", new planet());
        
        //Light Skills
        allSkills.put("Salvation", new salvation());
        allSkills.put ("Heavenly Light", new heavenlyLight());
        allSkills.put ("Luster Wave", new lusterWave());
        allSkills.put ("Holy Smite", new holySmite());
        allSkills.put ("Radiance", new radiance());
        
        //Dark Skillss
        allSkills.put("Zombie Strike", new zombieStrike());
        allSkills.put ("Demon Fury", new demonFury());
        allSkills.put ("Blood Rain", new bloodRain());
        allSkills.put ("Vampire", new vampire());
        allSkills.put ("Darkness", new darkness());
        
        //Gale Skills
        allSkills.put("Tail Wind", new tailWind());
        allSkills.put ("Spiral Assault", new spiralAssault());
        allSkills.put ("Feather Duster", new featherDuster());
        allSkills.put ("Hurricane Force", new hurricaneForce());
        allSkills.put ("Maelstrom", new maelstrom());
        
        
        //Final Boss Brown Skills
        allSkills.put ("Keys to Success", new keys());
        allSkills.put ("Wadatah", new wadatah());
        allSkills.put ("Day of Relaxation", new csExam());
        allSkills.put ("Beard of Justice", new beard());
        allSkills.put ("Bun of Fate", new bun());
        
    }
    
    public static HashMap<String,Skill> getAllSkills()
    {
        return allSkills;
    }
    
    public abstract void use(GChar user, GChar c);
    public int getMpCost() {return mpCost;}
}


class basicAttack extends Skill
{
    public basicAttack()
    {
        mpCost = 0;
    }
    
    public void use(GChar user, GChar c)
    {
        System.out.println (user.name + " bashes " + c.name);
        user.MP -= mpCost;
        if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage(user.str - c.def / 2 );
            System.out.println ("It's a critical hit! REKT");
        }
        else
        {
            c.takeDamage(user.str-c.def);
        }
        
    }
}

class basicAttackM extends Skill
{
    public basicAttackM()
    {
        mpCost = 0;
    }
    
    public void use(GChar user, GChar c)
    {
        System.out.println (user.name + " bashes " + c.name);
        user.MP -= mpCost;
        c.takeDamage(user.magic-c.res);
        System.out.println (user.name + " deals " + (user.magic-c.res ) );

    }
}


//current Warrior class skills
class strongSwing extends Skill
{
    public strongSwing()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " used Strong Swing!");
        user.MP -= mpCost;
     if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.str + 10 - c.def / 2 );
            System.out.println ("It's a critical hit! REKT");
        }
    else
        {
            c.takeDamage (user.str + 10 - c.def);
        }
    }
}


class proudSwivel extends Skill
{
    public proudSwivel()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " used Proud Swivel!");
        user.MP -= mpCost;
        if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.str + user.magic - c.def / 2 );
            System.out.println ("It's a critical hit! REKT");
        }
        else
        {
            c.takeDamage (user.str + user.magic - c.def);
        }
    }
}


class finishingTouch extends Skill
{
    public finishingTouch()
    {
        mpCost = 40;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " used Finishing Touch!"); 
        user.MP -= mpCost;
        if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.str + user.HP - c.def / 2 );
            System.out.println ("It's a critical hit! REKT");
        }
        else
        {
            c.takeDamage (user.str + user.HP - c.def);
        }
    }
}

class warCry extends Skill
{
    public warCry()
    {
        mpCost = 20;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " unleashed a resonating bellow!"); 
        System.out.println ("The power of " + user.name + "'s chords of steel decreased " + c.name+ "'s strength!");
        c.str *= .8;
    }
}

class rushDown extends Skill
{
    public rushDown()
    {
        mpCost = 35;
    }
    
    public void use (GChar user, GChar c){
        System.out.println (user.name + " unleashes a string of slashes!");
        int hits = 3;

        while (hits != 0)
        {
            user.useSkill ("BasicAttack", c);
            hits --;
        }
        
    }
}

class weaken extends Skill
{
    public weaken()
    {
        mpCost = 35;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " swings at " + c.name +"'s weakspot!");
        user.MP -= mpCost;
        if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.str - c.def / 2 );
            System.out.println ("It's a critical hit! REKT");
        }
        else
        {
            c.takeDamage (user.str  - c.def);
        }
        System.out.println (c.name + "'s defense dropped!");
        c.def *= .8;
    }
}




//class Archer skills
class bowThrow extends Skill
{
    public bowThrow()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " threw a bow!?!");
        user.MP -= mpCost;
     if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.str - c.def / 4 );
            System.out.println ("It's a critical hit! REKT");
        }
    else
        {
            c.takeDamage (user.str - c.def/2);
        }
    }
}

class arrowStrom extends Skill
{
    public arrowStrom()
    {
        mpCost = 35;
    }
    
    public void use (GChar user, GChar c){
        System.out.println (user.name + " fired some arrows into the sky!");
        int hits = (int)(Math.random() *4);
        if (hits == 0 )
        {
            System.out.println ("The arrows miss " + c.name +"!");
        }
        while (hits != 0)
        {
            user.useSkill ("BasicAttack", c);
            hits --;
        }
        
    }
}

class focus extends Skill //needs to be fixed
{
    public focus()
    {
        mpCost = 20;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " began to concentrate!");
        System.out.println (user.name + "'s offensive capabiltiies have increased!");
        c.def *= .9;
        c.res *= .9;
    }
}

class markDown extends Skill
{
    public markDown()
    {
        mpCost = 20;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " pinpointed " + c.name + "'s weakpoints!");
        System.out.println (user.name + "'s physical damage increases!");
        c.def *= .75;
    }
}

class fatalShot extends Skill
{
    public fatalShot()
    {
        mpCost = 30;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " fires a concentrated blast at the foe!");
        user.MP -= mpCost;
        c.takeDamage ((int)(user.str*1.5));
        
    }
}

class quickDraw extends Skill
{
    public quickDraw()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " fires a series of quick bolts!");
        user.MP -= mpCost;
     if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.str + user.speed - c.def / 2 );
            System.out.println ("It's a critical hit! REKT");
        }
    else
        {
            c.takeDamage (user.str + user.speed - c.def);
        }
    }
}




//class Mage skills

class arcaniteForce extends Skill
{
    public arcaniteForce()
    {
        mpCost = 15;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " cast Arcanite Force!");
        user.MP -= mpCost;
        c.takeDamage (user.magic + 15 - c.res);
        
    }
}

class arcaneBullets extends Skill
{
    public arcaneBullets()
    {
        mpCost = 40;
    }
    
    public void use (GChar user, GChar c){
        System.out.println (user.name + " launches a series of magical orbs!");
        int hits = 3;

        while (hits != 0)
        {
            user.useSkill ("BasicAttackM", c);
            hits --;
        }
        
    }
}

class concentrate extends Skill//needs to be fixed
{
    public concentrate()
    {
        mpCost = 30;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " began to chant magical incantations");
        System.out.println (user.name + " Magical damage increases drastically at the cost of a quarter of " + user.name + "'s health!");
        c.res /= 2;
        user.HP /= 4;
        
    }
}

class stagnate extends Skill
{
    public stagnate()
    {
        mpCost = 30;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " showers " + c.name + " in a magical light");
        System.out.println (c.name + "'s magical resistance has decreased!");
        c.res *= .8;
        
    }
}

class brainShock extends Skill
{
    public brainShock()
    {
        mpCost = 0;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " stole some of " + c.name + "'s MP!");
        user.MP -= mpCost;
        user.MP += (int)(c.MP * .3);
        c.takeDamageMp ((int)(c.MP *.3));
        
    }
}

class manaBreak extends Skill
{
    public manaBreak()
    {
    }
    
    public void use (GChar user, GChar c)
    {
        mpCost = user.MP;
        System.out.println (user.name + " released all of their mana!");
        user.MP -= mpCost;
        c.takeDamage ((user.MP + user.magic) * 2);
        System.out.println (user.name + " feels drained!");
    }
}



//class Thief skils
class backStab extends Skill
{
    public backStab()
    {
        mpCost = 15;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " dashes behind the " + c.name + " and deals a fatal stab!");
        user.MP -= mpCost;
         if (((Math.random() * 50)) <= user.luck)
        {
            c.takeDamage (user.str * 2 - c.def / 2 );
            System.out.println ("It's a critical hit! REKT");
        }
        else
        {
            c.takeDamage (user.str * 2 - c.def);
        }
        
    }
}

class assassinate extends Skill
{
    public assassinate()
    {
        mpCost = 35;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " attempts to assassinate the " + c.name + "!");
        user.MP -= mpCost;
        if (((Math.random() * 110)) <= user.luck)
        {
            c.takeDamage (c.HP);
            System.out.println ("It's a one hit ko!");
        }
        else
        {
            c.takeDamage ((int)(c.HP * .2));
        }
        
    }
}

class gamble extends Skill //needs to be fixed
{
    public gamble()
    {
        mpCost = 30;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " flips a coin!");
        if (((Math.random() * 200)) <= user.luck)
        {
            c.def *= .7;
            c.speed /= 2;
            System.out.println ("Lucky! " +user.name + " obtains unimaginable power!");
        }
        else
        {
            user.def /= 2;
            user.res /= 2;
            System.out.println ("Unlucky! " +user.name + " obtains unimaginable weaknesses!");
        }

        
    }
}

class curtains extends Skill
{
    public curtains()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " is enveloped in a misty cloak!");
        System.out.println (user.name + " is likely to be hit with critical damage!");
        c.luck *= .8;
    }
}

class shuffleTime extends Skill //needs to be fixed
{
    public shuffleTime()
    {
        mpCost = 40;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " uses a random skill!!");
        if (((Math.random() * 100)) < 33)
        {
            user.useSkill ("Finishing Touch", c);
        }
        
        else if (((Math.random() * 100)) > 66)
        {
            user.useSkill ("Arcane Bullets", c);
        }
        
        else{
            user.useSkill ("Arrow Storm", c);
        }

        
    }
}

class pickpocket extends Skill
{
    public pickpocket()
    {
        mpCost = 30;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " performs a sly attack on " + c.name + "!");
        user.MP -= mpCost;
        c.takeDamage (user.str/2 - c.def);
        if (((Math.random() * 100)) <= c.luck)
        {
            System.out.println (user.name + " found " + c.name + "'s secret nest egg! Finders keepers!");
            user.gold += c.gold;
        }
        
    }
}




//element Fire skills
class heatWave extends Skill
{
    public heatWave()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " cast Heat Wave!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Wood") )
        {
           c.takeDamage (user.magic*2 - c.res); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Aqua") )
        {
           c.takeDamage (user.magic/2 - c.res); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.magic - c.res);
        }
    }
}



class reKindle extends Skill
{
    public reKindle()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " cast Rekindle!");
        System.out.println (user.name + " regains some MP!");
        user.MP += 30;
    }
}

class flameCrash extends Skill
{
    public flameCrash()
    {
        mpCost = 15;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " used Flame Crash!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Wood") )
        {
           c.takeDamage (user.str*2 - c.res); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Aqua") )
        {
           c.takeDamage (user.str/2 - c.res); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.magic - c.res);
        }
    }
}


class innerFire extends Skill
{
    public innerFire()
    {
        mpCost = 30;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " channels their inner lifeforce and unleashes a powerful fireball!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Wood") )
        {
           c.takeDamage (user.HP*2 - c.res); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Aqua") )
        {
           c.takeDamage (user.HP/2 - c.res); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.HP - c.res);
        }
    }
}
class inferno extends Skill
{
    public inferno()
    {
        mpCost = 150;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " used Inferno!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Wood") )
        {
           c.takeDamage (9999); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Aqua") )
        {
           c.takeDamage (user.magic - c.res); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.magic*3 - c.res);
        }
    }
}

//element aqua skills
class hailStorm extends Skill
{
    public hailStorm()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c){
        System.out.println (user.name + " fires chunks of ice!");
        int hits = 3;
        while (hits != 0)
        {
            if (c.element.equals ("Wood") )
            {
                 c.takeDamage (user.str*2 - c.def); 
                System.out.println ("It's super effective!");
            }
        
            else if (c.element.equals ("Fire") )
            {
                c.takeDamage (user.str/2 - c.def); 
                System.out.println ("It's not very effective...");
            }
        
            else
            {
             c.takeDamage (user.str - c.def);
            }
            
            hits --;
        }
        
    }
}

class tidalWave extends Skill
{
    public tidalWave()
    {
        mpCost = 30;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " launched a giant wave at " + c.name + "!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Fire") )
        {
           c.takeDamage (user.magic*3 - c.res); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Wood") )
        {
           c.takeDamage (user.magic/2 - c.res); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.magic - c.res);
        }
    }
}

class aquaVeil extends Skill
{
    public aquaVeil()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " cast Aqua Veil!");
        System.out.println (user.name + " is enveloped by a ring of water. Resistance to physical attacks have increased for one turn!");
        user.def *= 2;
    }
}

class icicleCharge extends Skill
{
    public icicleCharge()
    {
        mpCost = 20;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println ("Sharp icicles cover " + user.name + "'s body!" + c.name + " suddenly charges at " + c.name + "!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Wood") )
        {
           c.takeDamage (user.def * 2- c.def/2); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Wood") )
        {
           c.takeDamage (user.def/2 - c.def); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.def - c.def);
        }
    }
}


class geyser extends Skill
{
    public geyser()
    {
        mpCost = 150;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " fires a burst of pressurized water at " + c.name + "!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Fire") )
        {
           c.takeDamage (9999); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Wood") )
        {
           c.takeDamage (user.magic - c.res); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.magic*3 - c.res);
        }
    }
}

//element Wood Skills
class flowerDance extends Skill
{
    public flowerDance()
    {
        mpCost = 50;
    }
    
    public void use (GChar user, GChar c){
        System.out.println (user.name + " begins a gallant dance!");
        int hits = (int)(Math.random() *7);
        if (hits == 0 )
        {
            System.out.println (user.name + " trips!");
            user.takeDamage (10);
        }
        while (hits != 0)
        {
            user.useSkill ("BasicAttack", c);
            hits --;
        }
        
    }
}

class seedBurst extends Skill
{
    public seedBurst()
    {
        mpCost = 30;
    }
    
    public void use (GChar user, GChar c){
        System.out.println (user.name + " launches a giant walnut into the air!");
        int hits = 2;
        while (hits != 0)
        {
            if (c.element.equals ("Aqua") )
            {
                 c.takeDamage (user.str*2 - c.def); 
                System.out.println ("It's super effective!");
            }
        
            else if (c.element.equals ("Fire") )
            {
                c.takeDamage (user.str/2 - c.def); 
                System.out.println ("It's not very effective...");
            }
        
            else
            {
             c.takeDamage (user.str - c.def);
            }
            
            hits --;
        }
        
    }
}

class woodSpike extends Skill
{
    public woodSpike()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " impales " + c.name + " with a spike of wood!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Aqua") )
        {
           c.takeDamage (user.magic*2 - c.def); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Fire") )
        {
           c.takeDamage (user.magic/2 - c.def); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.magic - c.def);
        }
    }
}



class pepperSong extends Skill
{
    public pepperSong()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " sings the Pepper Song");
        System.out.println ("The lyrics are so awesome that " + user.name + "regains health!");
        user.HP += user.hpInitial * .4;
    }
}

class planet extends Skill
{
    public planet()
    {
        mpCost = 150;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " unleashes the forces of nature!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Aqua") )
        {
           c.takeDamage (9999); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Fire") )
        {
           c.takeDamage (user.str - c.def); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.str *3 - c.def);
        }
    }
}

//element light skills
class heavenlyLight extends Skill
{
    public heavenlyLight()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " summons a holy light from the sky.");
        System.out.println ("The radiant light envelops " + user.name + ". Defensive abiltiies have increased for one turn!");
        user.def *= 1.5;
        user.res *= 1.5;
    }
}

class salvation extends Skill
{
    public salvation()
    {
        mpCost = 50;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " begins to glow...");
        System.out.println ( user.name + "'s health has been fully recovered!");
        user.HP = user.hpInitial;
    }
}

class lusterWave extends Skill
{
    public lusterWave()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " releases a blinding light!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Dark") )
        {
           c.takeDamage (user.magic*3 - c.res); 
           System.out.println ("It's super effective!");
        }

        else
        {
            c.takeDamage (user.magic - c.res);
        }
    }
}

class holySmite extends Skill
{
    public holySmite()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " strikes " + c.name + " with a bolt of light!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Dark") )
        {
           c.takeDamage (user.str*3 - c.def); 
           System.out.println ("It's super effective!");
        }

        else
        {
            c.takeDamage (user.str - c.def/2);
        }
    }
}


class radiance extends Skill
{
    public radiance()
    {
        mpCost = 150;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " unleases a solar ray!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Dark") )
        {
           c.takeDamage (9999); 
           System.out.println ("It's super effective!");
        }

        else
        {
            c.takeDamage (user.magic*3 - c.res);
        }
    }
}

//element dark
class zombieStrike extends Skill
{
    public zombieStrike()
    {
        mpCost = 35;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " slams " + c.name + "with a undead aura!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Light") )
        {
           c.takeDamage (user.HP *3 - c.res - c.def); 
           System.out.println ("It's super effective!");
        }

        else
        {
            c.takeDamage ((int)(user.HP *1.5 - c.res - c.def));
        }
    }
}

class demonFury extends Skill
{
    public demonFury()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " calls for the powers of an otherworldly entity!");
        System.out.println ("The entity has granted " + user.name + " an intimidating power of darkness." +c.name +"'s offensive power has decreased!");
        c.str *= .7;
        c.magic *=.7;
    }
}

class bloodRain extends Skill
{
    public bloodRain()
    {
        mpCost = 50;
    }
    
    public void use (GChar user, GChar c){
        System.out.println ("The sky turns crimson.");
        int hits = (int)(Math.random() *7 + 1);
        while (hits != 0)
        {
            if (hits % 2 == 0){
                c.takeDamage (user.magic - c.def); 
            }
            else{
                c.takeDamage (user.str - c.def); 
            }
            hits --;
        }
        System.out.println ( user.name + " is severely weakened!");
        user.HP *= .5;
        
    }
}

class darkness extends Skill
{
    public darkness()
    {
        mpCost = 150;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " covers the battlefield with an ominous malevolence!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Light") )
        {
           c.takeDamage (9999); 
           System.out.println ("It's super effective!");
        }

        else
        {
            c.takeDamage (user.str *3 - c.def);
        }
    }
}

class vampire extends Skill
{
    public vampire()
    {
        mpCost = 20;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " drained " + c.name + "'s lifeforce!");
        user.MP -= mpCost;
        user.HP += (int)(c.HP * .1);
        c.takeDamageMp ((int)(c.HP *.1));
        
    }
}

//element Gale skills
class tailWind extends Skill
{
    public tailWind()
    {
        mpCost = 20;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " whips up a tail wind!");
        System.out.println ("The blistering winds increase " + user.name + "'s speed");
        c.speed *= .8;
    }
}


class spiralAssault extends Skill
{
    public spiralAssault()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " spins violently and charges at the " +c.name+"!"); 
        user.MP -= mpCost;
        if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.str - c.res / 3);
            System.out.println ("It's a critical hit! REKT");
        }
        else
        {
            c.takeDamage (user.str - c.res/2);
        }
        
    }
}


class featherDuster extends Skill
{
    public featherDuster()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " fires a gust of at " +c.name+"!"); 
        user.MP -= mpCost;
        if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.magic - c.def / 3 );
            System.out.println ("It's a critical hit! REKT");
        }
        else
        {
            c.takeDamage (user.magic - c.def/2);
        }
        
    }
}

class hurricaneForce extends Skill
{
    public hurricaneForce()
    {
        mpCost = 35;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " unleashes burst of torrential winds at  " +c.name+"!"); 
        user.MP -= mpCost;
        c.takeDamage (user.magic + user.str - c.def);
        
    }
}

class maelstrom extends Skill
{
    public maelstrom()
    {
        mpCost = 150;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " creates a devestating storm!"); 
        c.takeDamage ((int)(c.HP * .25));

    }
}



//blank element skills too op pls nerf. Let Mls final boss have this element because why not. ;)

class noisePulse extends Skill
{
    public noisePulse()
    {
        mpCost = 0;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println ("Drown in noise..."); 
        user.MP -= mpCost;
        if ( (c.element.equals ("Dark") ) || c.element.equals ("Light") )
        {
           c.takeDamage (user.magic + user.str); 
           System.out.println ("Everything is nothing...");
        }

        else
        {
            c.takeDamage ((user.magic + user.str) /2);
        }
        
        System.out.println ("Give up...");
        c.def /= 2;
        c.res /= 2;
        
         if (((Math.random() * 300)) <= user.luck){
             System.out.println ("Resistance is futile..."); 
              c.takeDamage (c.HP); 
         } 
    }
}

class gravity extends Skill
{
    public gravity()
    {
        mpCost = 0;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println ("Kneel before me..."); 
        user.MP -= mpCost;
        if ( (c.element.equals ("Fire") ) || c.element.equals ("Aqua") || c.element.equals ("Wood") || c.element.equals ("Gale")) 
        {
           c.takeDamage ((int)(c.HP * .5)); 
           System.out.println ("Everything is nothing...");
        }

        else
        {
            c.takeDamage ((int)(c.HP * .25));
        }
        
        System.out.println ("Why bother anymore?");
        c.speed /= 2;
        
         if (((Math.random() * 300)) <= user.luck){
             System.out.println ("Resistance is futile..."); 
              c.takeDamage (c.HP); 
         } 
    }
}

class abnormalize extends Skill
{
    public abnormalize()
    {
        mpCost = 0;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println ("This is the end...");
        System.out.println (user.name + " becomes one with the void!");
        c.str /=2;
        c.magic /= 2;
        c.speed /= 2;
    }
}


//Brown Skills
class keys extends Skill
{
    public keys()
    {
        mpCost = 0;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " used Keys to Success!"); 
        System.out.println ("It was a major key! Bless up! " + user.name "'s stats dramatically increase!");
        user.str *= 1.5;
        user.magic *= 1.5
        user.def *= 1.5
        user.res *= 1.5
        user.speed *= 1.5
    }
}

class wadatah extends Skill
{
    public wadatah()
    {
        mpCost = 0;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " used WADATAHHHH!"); 
        c.takeDamage (c.hpInitial * .5);
    }
}

class csExam extends Skill
{
    public csExam()
    {
        mpCost = 0;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " gave " + c.name + " a Day of Relaxation!"); 
        c.takeDamage (c.hpInitial);
        System.out.println (user.name + " got sent to the gift shop!"); 
    }
}

class beard extends Skill
{
    public beard()
    {
        mpCost = 0;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " used his Beard of Justice!"); 
        c.takeDamage (user.str - c.def);
    }
}

class bun extends Skill
{
    public bun()
    {
        mpCost = 0;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " used his Bun of Fate!"); 
        c.takeDamage (user.magic - c.res);
    }
}




