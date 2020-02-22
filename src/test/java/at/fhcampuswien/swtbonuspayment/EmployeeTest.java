package at.fhcampuswien.swtbonuspayment;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class EmployeeTest {


    @Test
    public void test_getBonus() {
        Employee e1 = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2020, 1,1);
        e1.setEntryDate(entryDate);

        Bonus bonus = e1.getBonus();
        assertEquals((double)0, (double)bonus.value, 0);
    }

    @Test
    public void test2_getBonus() {
        Employee e2 = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2017, 1,1);
        e2.setEntryDate(entryDate);

        Bonus bonus = e2.getBonus();
        assertEquals((double)50, (double)bonus.value, 0);
    }

    @Test
    public void test3_getBonus() {
        Employee e3 = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2015, 1,1);
        e3.setEntryDate(entryDate);

        Bonus bonus = e3.getBonus();
        System.out.println(bonus.toString());
        assertEquals((double)80, (double)bonus.value, 0);
    }

    @Test
    public void test4_getBonus() {
        Employee secretaryEmployee = new SecretaryEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2015, 1,1);
        secretaryEmployee.setEntryDate(entryDate);

        Bonus bonus = secretaryEmployee.getBonus();
        assertEquals((double)80*2,(double)bonus.value, 0);
    }

    @Test
    public void test5_getBonus() {
        Employee e4 = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2009, 1,1);
        e4.setEntryDate(entryDate);

        Bonus bonus = e4.getBonus();
        assertEquals((double)120, (double)bonus.value, 0);
    }

    @Test
    public void test6_getBonus() {
        Employee postOfficeEmployee = new PostOfficeEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2009, 1,1);
        postOfficeEmployee.setEntryDate(entryDate);

        Bonus bonus = postOfficeEmployee.getBonus();
        assertEquals((double)120*2, (double)bonus.value,0);
    }

    @Test
    public void test7_getBonus() {
        Employee employee = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(1910, 1,1);
        boolean isValid = true;
        try {
            employee.setEntryDate(entryDate);
        } catch (IllegalArgumentException ex){
            isValid = false;
        }

        assertEquals(false, isValid);
    }
}
