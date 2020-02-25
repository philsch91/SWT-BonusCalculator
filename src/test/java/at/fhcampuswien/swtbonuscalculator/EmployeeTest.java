package at.fhcampuswien.swtbonuscalculator;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void testEmployee_lessThan2years_getBonus() {
        Employee employee = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2020, 1,1);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        assertEquals((double)0, (double)bonus.value, 0);
    }

    @Test
    public void testSecretryEmployee_lessThan2years_getBonus() {
        Employee employee = new SecretaryEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2019, 2,1);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        assertEquals((double)0, (double)bonus.value, 0);
    }

    @Test
    public void testPostOfficeEmployee_lessThan2years_getBonus() {
        Employee employee = new PostOfficeEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2019, 11,3);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        assertEquals((double)0, (double)bonus.value, 0);
    }

    @Test
    public void testEmployee_moreThan2years_getBonus() {
        Employee employee = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2017, 1,1);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        assertEquals((double)50, (double)bonus.value, 0);
    }

    @Test
    public void testSecretaryEmployee_moreThan2years_getBonus() {
        Employee employee = new SecretaryEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2018, 1,1);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        assertEquals((double)50*2, (double)bonus.value, 0);
    }

    @Test
    public void testPostOfficeEmployee_moreThan2years_getBonus() {
        Employee employee = new PostOfficeEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2017, 12,31);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        assertEquals((double)50*2, (double)bonus.value, 0);
    }

    @Test
    public void testEmployee_moreThan4years_getBonus() {
        Employee employee = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2015, 1,1);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        System.out.println(bonus.toString());
        assertEquals((double)80, (double)bonus.value, 0);
    }

    @Test
    public void testSecretaryEmployee_moreThan4years_getBonus() {
        Employee employee = new SecretaryEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2015, 1,1);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        assertEquals((double)80*2,(double)bonus.value, 0);
    }

    @Test
    public void testPostOfficeEmployee_moreThan4years_getBonus() {
        Employee postOfficeEmployee = new PostOfficeEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2014, 12,24);
        postOfficeEmployee.setEntryDate(entryDate);

        Bonus bonus = postOfficeEmployee.getBonus();
        assertEquals((double)80*2,(double)bonus.value, 0);
    }

    @Test
    public void testEmployee_moreThan10years_getBonus() {
        Employee employee = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2009, 1,1);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        assertEquals((double)120, (double)bonus.value, 0);
    }

    @Test
    public void testSecretaryEmployee_moreThan10years_getBonus() {
        Employee employee = new SecretaryEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2009, 7,4);
        employee.setEntryDate(entryDate);

        Bonus bonus = employee.getBonus();
        assertEquals((double)120*2, (double)bonus.value, 0);
    }

    @Test
    public void testPostOfficeEmployee_moreThan10years_getBonus() {
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

    @Test
    public void testSecretaryEmployee_legalEntryDate() {
        Employee employee = new SecretaryEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(1990, 12,31);
        boolean isValid = true;
        try {
            employee.setEntryDate(entryDate);
        } catch (IllegalArgumentException ex){
            isValid = false;
        }

        assertEquals(true, isValid);
    }

    @Test
    public void testSecretaryEmployee_illegalEntryDate() {
        Employee employee = new SecretaryEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(1910, 12,24);
        boolean isValid = true;
        try {
            employee.setEntryDate(entryDate);
        } catch (IllegalArgumentException ex){
            isValid = false;
        }

        assertEquals(false, isValid);
    }

    @Test
    public void testPostOfficeEmployee_legalEntryDate() {
        Employee employee = new PostOfficeEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(1990, 1,1);
        boolean isValid = true;
        try {
            employee.setEntryDate(entryDate);
        } catch (IllegalArgumentException ex){
            isValid = false;
        }

        assertEquals(true, isValid);
    }

    @Test
    public void testPostOfficeEmployee_illegalEntryDate() {
        Employee employee = new PostOfficeEmployee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(1920, 1,1);
        boolean isValid = true;
        try {
            employee.setEntryDate(entryDate);
        } catch (IllegalArgumentException ex){
            isValid = false;
        }

        assertEquals(false, isValid);
    }
}
