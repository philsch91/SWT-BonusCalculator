package at.fhcampuswien.swtbonuspayment;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;

import static org.junit.Assert.*;

public class EmployeeTest {


    @Test
    public void test_getBonus() {
        Employee e1 = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2020, 1,1);
        e1.entryDate = entryDate;

        Bonus bonus = e1.getBonus();
        assertEquals((double)bonus.value, (double)20);
    }

    @Test
    public void test2_getBonus() {
        //Test Employee 2
    }
    @Test
    public void test3_getBonus() {
        //Test SecretaryEmployee
    }

    @Test
    public void test4_getBonus() {
        //Test PostOfficeEmployee
    }
}
