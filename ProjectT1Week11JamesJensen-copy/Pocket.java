import java.util.HashSet;
import java.util.Iterator;

/**
 * The Pocket class represents a student's pocket that holds pennies.
 *
 * @author jensen0james
 * @version 1.0.0
 */
public class Pocket
{
    // instance variables - replace the example below with your own
    private HashSet<Penny> pocket;

    /**
     * Constructor for objects of class Pocket. Creates a pocket that can hold
     * objects of type Penny.
     * 
     * @param  size  Determines how many pennies the pocket can hold.
     */
    public Pocket(int size)
    {
        this.pocket = new HashSet<Penny>();
        
        for (int i = 0; i < size; i++)
        { 
            pocket.add(new Penny());
        }
    }

    /**
     * Count how many pennies are in the HashSet and return it as an integer.
     *
     * @return    An integer, which is the size of the HashSet pocket of type
     *            Penny
     */
    public int pennyCount()
    {
        return pocket.size();
    }
    
    /**
     * Check whether the pocket is empty. If the pocket is not empty, remove
     * a Penny from the pocket and return it.
     *
     * @return    A Penny if there are still pennies in the pocket, otherwise
     *            return null.
     */
    public Penny removePenny()
    {
        if(!pocket.isEmpty())
        {
            Iterator<Penny> iter = pocket.iterator();
            Penny removed = iter.next();
            pocket.remove(removed);
            return removed;
        }
        return null;    
    }
}
