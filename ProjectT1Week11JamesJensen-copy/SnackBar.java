import java.util.ArrayList;
import java.util.Random;

/**
 * The SanckBar class represents a bar in which students can purchase snacks
 * with pennies that they have in their pocket by going up to a snack machine
 * to buy a packet of crisps. Time proceeds in discrete steps.
 *
 * @author jensen0james
 * @version 1.0.0
 */
public class SnackBar
{
    // instance variables - replace the example below with your own
    private Random random;
    private String flavoursOfCrisps[];
    private SnackMachine newSnackMachine;
    private ArrayList<Student> student;

    /**
     * Main method accepts two arguments. The first argument is how many
     * students are in the snack bar. The second argument is for how many
     * steps the simulation will run.
     * 
     * @param  args  Arguments to dictate how the program will run.
     */
    public static void main(String[] args)
    {
        SnackBar snackBar = new SnackBar(Integer.parseInt(args[0]),10,5);
        snackBar.describe();
        snackBar.runSnackBar(Integer.parseInt(args[1]));
    }
    /**
     * Constructor for objects of class SnackBar. The snack bar is a place
     * where students can interact with a snack machine. Time progresses
     * in discrete steps were a student is picked to execute their snack time
     * logic. The snack bar constructs the snack machine and fills it with
     * packs of crisps. It also constructs students and assigns them a flavour.
     * 
     * @param  numOfStudents  The number of students the snack bar
     *                        will be constructed with.
     * @param  numOfCrisps  The number of packs of crisps the machine
     *                      will be stocked with of random flavour.
     * @param  cost  How much each pack of crisps will cost to purchase
     *               from the constructed machine.
     */
    public SnackBar(int numOfStudents, int numOfCrisps, int cost)
    {
        random = new Random();
        flavoursOfCrisps = new String[]
        {
            "Original", "Onion", "Salt and Vinegar", "BBQ", "Cheddar"
        };
        newSnackMachine = new SnackMachine(numOfCrisps, cost);
        student = new ArrayList<Student>();
        for (int i = 0; i < numOfCrisps; i++)
        {
            PackOfCrisps newPack = new PackOfCrisps();
            newPack.setFlavour(randomFlavour());
            newSnackMachine.addPack(newPack);
        }
        for (int i = 0; i < numOfStudents; i++)
            student.add(new Student(randomFlavour(), newSnackMachine));
        
    }

    /**
     * Picks a random flavour from the avaible flavours of crisps
     *
     * @return    A String, where the String is the randomly generated flavour
     *            of crisp.
     */
    private String randomFlavour()
    {
        return flavoursOfCrisps[random.nextInt(5)];
    }
    
    /**
     * Describe the state of the snack bar.
     */
    public void describe()
    {
        System.out.println("The SnackBar has " + student.size() + " hungry students.");
        System.out.println("The SnackMachine has: ");
        for (int i = 0; i < flavoursOfCrisps.length; i++)
        {
            System.out.print(newSnackMachine.countPacks(flavoursOfCrisps[i]) + " packets of ");
            System.out.print(flavoursOfCrisps[i] + " crisps");
            if (i == flavoursOfCrisps.length - 1)
                System.out.println(".");
            else
                System.out.println(",");
        }
        
    }
    
    /**
     * Step the snack bar forward in time by one step. For each step, invoke
     * the describe method and pick a random student to invoke their snackTime
     * method.
     *
     * @param  nStep  An integer, which reprents for how many steps the snack
     *                bar should run for.
     */
    public void runSnackBar(int nStep)
    {
        for (int i = 1; i <= nStep; i++)
        {
            System.out.println("Time Step " + i);
            describe();
            student.get(random.nextInt(student.size())).snackTime();
        }
    }
}
