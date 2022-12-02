import java.util.ArrayList;

/**
 * The SnackMachine class represnts a snack machine that holds packets of
 * crisps that can be purchased once sufficient payment has been provided.
 *
 * @author jensen0james
 * @version 1.1.0
 */
public class SnackMachine
{
    private ArrayList<PackOfCrisps> packet;
    private int capacity;
    private int cost;
    private int payment;
    private ArrayList<Penny> pennies;
    
    /**
     * Constructor for objects of class SnackMachine. Creates a snack machine
     * with a set capacity and cost for packs of crisps. Can accept pennies as
     * a form of payment. Can stock machine with packs of crisps.
     * 
     * @param  capacity  The maximum number of packs of crisps the machine 
     *                   can hold.
     * @param  cost  The cost to buy a pack of crisps from the machine.
     */
    public SnackMachine(int capacity, int cost)
    {
        packet = new ArrayList<PackOfCrisps>();
        this.capacity = capacity;
        this.cost = cost;
        payment = 0;
        pennies = new ArrayList<Penny>();
    }

    /**
     * Check the cost to buy a pack of crisps.
     *
     * @return    An integer, where the value is the cost of purchasing a pack
     *            of crisps.
     */
    public int getCost()
    {
        return cost;
    }
    
    /**
     * Add a pack of crisps into the snack machine so long as there is room
     * for another pack.
     *
     * @param  pack  A PackOfCrisps to be added to the machine.
     */
    public void addPack(PackOfCrisps pack)
    {
        if (packet.size() < capacity)
            packet.add(pack);
        else
            System.out.println("The machine is already full!");
    }
    
    /**
     * Count how many packs of a specific flavour are in the snack machine and
     * return it as an integer.
     *
     * @param  flavour  The flavour to be checked against the flavours in the
     *                  machine.
     * @return    An integer, that is the number of packets in the machine
     *            with the checked flavour.
     */
    public int countPacks(String flavour)
    {
        int counter = 0;
        for (int i = 0; i < packet.size(); i++)
        {
            if(packet.get(i).getFlavour() == flavour)
                counter++;
        }
        return counter;
    }
    
    /**
     * Pennies are added to the machine as a form of payment.
     *
     * @param  penny  A Penny is accepted as payment.
     */
    public void insertMoney(Penny penny)
    {
        pennies.add(penny);
        payment++;
    }
    
    /**
     * Buy a pack of crisps from the machine of a specific flavour and return
     * that flavour if possible.
     *
     * @param  flavour  the flavour of the pack of crisps to be bought.
     * @return    A PackOfCrisps object, where the pack of crisps is of the
     *            flavour requested.
     */
    public PackOfCrisps buyPack(String flavour)
    {
        PackOfCrisps purchase = null;
        for (int i = 0; i < packet.size(); i++)
        {
            
            if(packet.get(i).getFlavour() == flavour && payment >= cost)
            {
                purchase = packet.get(i);
                packet.remove(i);
                payment = 0;
                pennies.clear();
                break;
            }
            else if(payment < cost)
            {
                System.out.println("You need to insert more pennies!");
                break;
            }
        }
        return purchase;
        
    }
    
    /**
     * Describe the current state of the snack machine.
     */
    public void describe()
    {
        System.out.print("The snack machine has " + packet.size() + " packets of crisps left");
        System.out.println(" and has taken " + pennies.size() + " pennies in payment.");
    }
    
    
}
