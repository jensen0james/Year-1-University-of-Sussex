
/**
 * The Student class represents a student who is always hungry and is trying
 * to buy their favourite flavour of crisps with pennies in their pocket.
 * They are either attempting to buy a packet of crisps, eating a crisp,
 * or throwing an epmty bag away.
 *
 * @author jensen0james
 * @version 1.0.0
 */
public class Student
{
    // instance variables - replace the example below with your own
    private static int STUDENT_ID = 0;
    
    private String flavour;
    private SnackMachine machine;
    private String identityNumber;
    private Pocket money;
    private PackOfCrisps packet;
    

    /**
     * Constructor for objects of class Student. Students are given a student_id
     * which seperates them from other students. They have a pocket of 20 pennies
     * each. They are constructed without a pack of crisps in hand. They have a flavour
     * they will try to buy from their assigned snack machine.
     * 
     * @param  flavour  The flavour of crisp that the student will attempt
     *                  to purchase.
     * @param  machine  The snack machine that a student will purchase packs
     *                  of crisps from.
     */
    public Student(String flavour, SnackMachine machine)
    {
        STUDENT_ID++;
        this.flavour = flavour;
        this.machine = machine;
        identityNumber = "student" + STUDENT_ID;
        money = new Pocket(20);
        packet = null;
    }

    /**
     * The student attempts to buy a pack of crisps from a snack machine.
     */
    private void buyCrisps()
    {
        if (money.pennyCount() < machine.getCost())
            System.out.println(identityNumber + " doesn't have enough money to buy a pack!");
        else if (machine.countPacks(flavour) == 0)
        {
            System.out.print("The machine has run out of ");
            System.out.println(identityNumber + " favourite " + flavour + " crisps!");
        }
        else
        {
            for (int i = 0; i < machine.getCost(); i++)
                machine.insertMoney(money.removePenny());
            packet = machine.buyPack(flavour);
        }
    }
    
    /**
     * The student tries to eat a crisp out of a bag of crisps in their
     * possession. If the bag is empty they throw it away. If they do not have
     * bag they attempt to buy one.
     */
    public void snackTime()
    {
        if (packet == null)
        {
            System.out.println(identityNumber + " is buying a pack of crisps!");
            buyCrisps();
        }
        else if (packet.isClosed())
        {
            System.out.println(identityNumber + " is opening the packet!");
            packet.open();
        }
        else if (packet.isEmpty())
        {
            System.out.println(identityNumber + " has finished the packet!");
            packet = null;
        }
        else
        {
            System.out.println(identityNumber + " is eating a favourite " + flavour + " crisp!");
            packet.eatCrisp();
        }
    }
}
