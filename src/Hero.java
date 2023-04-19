import java.util.Random;

public class Hero
{
    //properties
    private String name;
    private int hitPoints;

    //constructors
    public Hero(String name)
    {
        this.name=name;
        hitPoints=100;
    }

    //behaviour
    public String getName()
    {
        return name;
    }
    public int getHitPoints()
    {
        return hitPoints;
    }
    public String toString()
    {
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }
    public void attack(Hero opponent)
    {
        Random numGen = new Random();
        double atk = numGen.nextDouble();
        if(atk < 0.5)
        {
            opponent.hitPoints -= 10;
        }
        else if (atk >= 0.5)
        {
            this.hitPoints -= 10;
        }
    }
    public void senzuBean()
    {
        hitPoints = 100;
    }
    public void fightUntilTheDeathHelper(Hero opponent)
    {
        while (hitPoints>0 && opponent.hitPoints>0)
        {
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent)
    {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return "" + name + ": " + hitPoints + "      " + opponent.getName() + ": " + opponent.getHitPoints();
    }
    private int[] nFightsToTheDeathHelper(Hero opponent , int n)
    {
        int[] scoreboard = new int[2];
        for (int i = 0 ; i < n ; i++)
        {
            fightUntilTheDeathHelper(opponent);
            if(hitPoints > opponent.hitPoints)
            {
                scoreboard[0]++;
            }
            else
            {
                scoreboard[1]++;
            }
        }
        return scoreboard;
    }
    public String nFightsToTheDeath(Hero opponent , int n)
    {
        int[] scoreboard = nFightsToTheDeathHelper(opponent, n);
        String scores = "" + name + ": " + scoreboard[0] + " wins\n" + opponent.getName() + ": " + scoreboard[1] + " wins\n";
        if (scoreboard[0] > scoreboard [1])
        {
            return scores + name + " wins!";
        }
        else if (scoreboard[1] > scoreboard [0])
        {
            return scores + opponent.name + " wins!";
        }
        else
        {
            return scores + "OMG! It was actually a draw!";
        }
    }
    public void dramaticFightToTheDeath(Hero opponent)
    {
        senzuBean();
        opponent.senzuBean();
        while (hitPoints>=0 && opponent.hitPoints>=0)
        {
            attack(opponent);
            System.out.println("" + name + ": " + hitPoints + "      " + opponent.getName() + ": " + opponent.getHitPoints());
        }
    }
}
