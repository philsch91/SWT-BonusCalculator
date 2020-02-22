package at.fhcampuswien.swtbonuspayment;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void testEmployee_getBonus() {
        Employee employee = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2020, 1,1);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        assertEquals((double)0, (double)bonus.value, 0);
    }

    @Test
    public void testEmployee_2years_getBonus() {
        Employee employee = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2017, 1,1);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        assertEquals((double)50, (double)bonus.value, 0);
    }

    @Test
    public void testEmployee_4years_getBonus() {
        Employee employee = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2015, 1,1);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        System.out.println(bonus.toString());
        assertEquals((double)80, (double)bonus.value, 0);
    }

    @Test
    public void testSecretaryEmployee_4years_getBonus() {
        Employee secretaryEmployee = new SecretaryEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2015, 1,1);
        secretaryEmployee.setEntryDate(entryDate);

        Bonus bonus = secretaryEmployee.getBonus();
        assertEquals((double)80*2,(double)bonus.value, 0);
    }

    @Test
    public void testEmployee_10years_getBonus() {
        Employee employee = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2009, 1,1);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        assertEquals((double)120, (double)bonus.value, 0);
    }

    @Test
    public void testPostOfficeEmployee_10years_getBonus() {
        Employee postOfficeEmployee = new PostOfficeEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2009, 1,1);
        postOfficeEmployee.setEntryDate(entryDate);

        Bonus bonus = postOfficeEmployee.getBonus();
        assertEquals((double)120*2, (double)bonus.value,0);
    }

    @Test
    public void testEmployee_legalEntryDate() {
        Employee employee = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(1980, 1,1);
        boolean isValid = true;
        try {
            employee.setEntryDate(entryDate);
        } catch (IllegalArgumentException ex){
            isValid = false;
        }

        assertEquals(true, isValid);
    }

    @Test
    public void testEmployee_illegalEntryDate() {
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
