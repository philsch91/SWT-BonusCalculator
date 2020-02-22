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
        entryDate.set(1946,1,1);

        try {
            e1.setEntryDate(entryDate);
        } catch (IllegalArgumentException ex){
            System.out.println("illegal argument");
        }
    }
}
