package at.fhcampuswien.swtbonuspayment;

import java.util.Calendar;
import java.util.Date;

public class Employee {
    Calendar entryDate = null;

    /**
     * override in subclasses
     * @return Bonus
     */
    public Bonus getBonus(){
        if(this.entryDate == null){
            return null;
        }

        Date now = Calendar.getInstance().getTime();
        //System.out.println(now);
        now.setYear(now.getYear() - 2);
        Calendar c = Calendar.getInstance();
        c.set(now.getYear(), now.getMonth(), now.getDay());

        if(this.entryDate.compareTo(c) > 0){
            return new Bonus(0);
        }

        now = Calendar.getInstance().getTime();
        //System.out.println(now);
        now.setYear(now.getYear() - 10);
        c = Calendar.getInstance();
        c.set(now.getYear(), now.getMonth(), now.getDay());

        if(this.entryDate.compareTo(c) < 0){
            return new Bonus(120);
        }

        now = Calendar.getInstance().getTime();
        //System.out.println(now);
        now.setYear(now.getYear() - 4);
        c = Calendar.getInstance();
        c.set(now.getYear(), now.getMonth(), now.getDay());

        if(this.entryDate.compareTo(c) < 0){
            return new Bonus(80);
        }

        now = Calendar.getInstance().getTime();
        //System.out.println(now);
        now.setYear(now.getYear() - 2);
        c = Calendar.getInstance();
        c.set(now.getYear(), now.getMonth(), now.getDay());

        if(this.entryDate.compareTo(c) < 0){
            return new Bonus(50);
        }

        return null;
    }
}
