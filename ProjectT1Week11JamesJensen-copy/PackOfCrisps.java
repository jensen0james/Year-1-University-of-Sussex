
/**
 * The PackOfCrisps class represents a packet of crisps. It is used to stock
 * snack machines or to be eaten by students.
 *
 * @author jensen0james
 * @version 1.2.0
 */
public class PackOfCrisps
{
    // instance variables - replace the example below with your own
    private boolean open;
    private int numOfCrisps;
    private String flavour;

    /**
     * Constructor for objects of class PackOfCrisps. Packs of crisps start out
     * closed and with 10 crisps in each bag.
     */
    public PackOfCrisps()
    {
        open = false;
        numOfCrisps = 10;
    }

    /**
     * Set the flavour of a pack of crisps to the flavour that is being passed
     * into the method.
     *
     * @param  theFlavour  The flavour that a pack of crisps will be set to.
     */
    public void setFlavour(String theFlavour)
    {
        flavour = theFlavour; 
    }
    
    /**
     * Check whether or not a pack of crisps is empty.
     *
     * @return    A bollean, where the value is true if the pack is empty and
     *            false if it still has crisps in it.
     */
    public boolean isEmpty()
    {            
        return numOfCrisps == 0;
    }
    
    /**
     * Check whether or not a pack of crisps is still closed. 
     *
     * @return    A bollean, where the value is true if the pack is closed and
     *            false if it is open.
     */
    public boolean isClosed()
    {
        return !open;
    }
    
    /**
     * Open a pack of crisps. Sets open to true.
     */
    public void open()
    {
        open = true;
    }
    
    /**
     * Get the flavour of the pack of crisps and return it as a string.
     * 
     * @return    A String, where the string is the flavour of the pack of
     *            crisps.
     */
    public String getFlavour()
    {
        return flavour;
    }
    
    /**
     * Remove a crisp from the pack if it is not empty and open.
     */
    public void eatCrisp()
    {
        if (!open)
            System.out.println("Need to open the packet first!");
        else if (numOfCrisps > 0)
            numOfCrisps--;
        else
            System.out.println("The packet is empty!");
    }
}
