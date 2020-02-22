package at.fhcampuswien.swtbonuspayment;

import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        Employee e1 = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2010,1,1);
        e1.getBonus();
    }
}
