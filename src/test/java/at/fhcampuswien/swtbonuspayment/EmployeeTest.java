package at.fhcampuswien.swtbonuspayment;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;

import static org.junit.Assert.*;

public class EmployeeTest {


    @Test
    public void test_getBonus() {
        //Test Employee 1
        Employee e1 = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2020, 1,1);
        e1.entryDate = entryDate;

        Bonus bonus = e1.getBonus();
        assertEquals((double)bonus.value, (double)0);
    }

    @Test
    public void test2_getBonus() {
        //Test Employee 2
        Employee e2 = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2017, 1,1);
        e2.entryDate = entryDate;

        Bonus bonus = e2.getBonus();
        assertEquals((double)bonus.value, (double)50);
    }

    @Test
    public void test3_getBonus() {
        //Test Employee 3
        Employee e3 = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2015, 1,1);
        e3.entryDate = entryDate;

        Bonus bonus = e3.getBonus();
        assertEquals((double)bonus.value, (double)80);
    }

    @Test
    public void test4_getBonus() {
        //Test SecretaryEmployee
        Employee SecretaryEmployee = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2015, 1,1);
        SecretaryEmployee.entryDate = entryDate;

        Bonus bonus = SecretaryEmployee.getBonus();
        assertEquals((double)bonus.value, (double)80*2);
    }

    @Test
    public void test5_getBonus() {
        //Test Employee 4
        Employee e4 = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2009, 1,1);
        e4.entryDate = entryDate;

        Bonus bonus = e4.getBonus();
        assertEquals((double)bonus.value, (double)120);
    }

    @Test
    public void test6_getBonus() {
        //Test PostOfficeEmployee
        Employee PostOfficeEmployee = new Employee();
        Calendar entryDate = Calendar.getInstance();
        entryDate.set(2009, 1,1);
        PostOfficeEmployee.entryDate = entryDate;

        Bonus bonus = PostOfficeEmployee.getBonus();
        assertEquals((double)bonus.value, (double)120*2);
    }
}
