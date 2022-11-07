
/**
 * Write a description of class PackOfCrisps here.
 * 
 * Write a Java class PackOfCrisps that represents a packet of potato crisps.
 * The following information is associated with each packet:
 *
 * 1. whether or not the packet has been opened
 * 2. the number of crisps in the packet:
 *      initially this is 10 and becomes 0 when the packet has been emptied
 *      - 4 crisps in the packet means that 6 have been eaten.
 * 3. the flavour of the crisps in the packet
 *
 * @author jensen0james
 * @version 0.0.1
 */
public class PackOfCrisps
{
    // instance variables - replace the example below with your own
    private boolean open;
    private int numOfCrisps;
    private String flavour;

    /**
     * Constructor for objects of class PackOfCrisps
     */
    public PackOfCrisps()
    {
        open = false;
        numOfCrisps = 10;
    }

    public void setFlavour(String theFlavour)
    {
        flavour = theFlavour; 
    }
    
    public boolean isEmpty()
    {            
        return numOfCrisps > 0;
    }
    
    public boolean isClosed()
    {
        return !open;
    }
    
    public void open()
    {
        open = true;
    }
    
    public String getFlavour()
    {
        return flavour;
    }
    
    public void eatCrisp()
    {
        if (open == false)
            System.out.println("Need to open the packet first!");
        else if (numOfCrisps > 0)
            numOfCrisps--;
        else
            System.out.println("The packet is empty!");
    }
}
