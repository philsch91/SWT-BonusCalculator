package at.fhcampuswien.swtbonuscalculator;

import java.util.Calendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "--- SWT Bonus Payment ---" );

        Employee e1 = new Employee();
        Calendar entryDate1 = Calendar.getInstance();
        entryDate1.set(1970,1,1);

        try {
            e1.setEntryDate(entryDate1);
        } catch (IllegalArgumentException ex){
            System.out.println("illegal argument");
        }

        Employee e2 = new Employee();
        Calendar entryDate2 = Calendar.getInstance();
        entryDate2.set(1920,1,1);

        try {
            e2.setEntryDate(entryDate2);
        } catch (IllegalArgumentException ex){
            System.out.println("illegal argument");
        }
    }
}
