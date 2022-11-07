import java.util.ArrayList;

/**
 * Write a description of class SnackMachine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SnackMachine
{
    // instance variables - replace the example below with your own
    private ArrayList<PackOfCrisps> packet;
    private int capacity;
    private int cost;
    private int payment;
    private ArrayList<Penny> pennies;
    
    /**
     * Constructor for objects of class SnackMachine
     */
    public SnackMachine(int capacity, int cost)
    {
        this.packet = new ArrayList<PackOfCrisps>();
        this.capacity = capacity;
        this.cost = cost;
        payment = 0;
        this.pennies = new ArrayList<Penny>();
        
    }

    public int getCost()
    {
        return cost;
    }
    
    public void addPack(PackOfCrisps pack)
    {
        if (packet.size() < capacity)
            packet.add(pack);
        else
            System.out.println("The machine is already full!");
    }
    
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
    
    public void insertMoney(Penny penny)
    {
        pennies.add(penny);
        payment++;
    }
    
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
    
    public void describe()
    {
        System.out.print("The snack machine has " + packet.size() + " packets of crisps left");
        System.out.println(" and has taken " + pennies.size() + " pennies in payment.");
    }
    
    
}
