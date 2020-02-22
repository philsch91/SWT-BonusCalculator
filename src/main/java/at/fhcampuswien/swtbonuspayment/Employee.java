package at.fhcampuswien.swtbonuspayment;

import java.util.Calendar;
import java.util.Date;

public class Employee {
    private Calendar entryDate = null;

    /**
     * override in subclasses
     * @return Bonus
     */
    public Bonus getBonus(){
        if(this.getEntryDate() == null){
            return null;
        }

        Date now = Calendar.getInstance().getTime();
        now.setYear(now.getYear() - 2);

        System.out.println(now);
        //System.out.println(now.getYear());

        Calendar c = Calendar.getInstance();
        c.set(now.getYear() + 1900, now.getMonth(), now.getDay());
        //c.setTime(now);

        System.out.println(this.getEntryDate().getTime());
        System.out.println(c.getTime());

        if(this.getEntryDate().compareTo(c) > 0){
            return new Bonus(0);
        }

        now = Calendar.getInstance().getTime();
        //System.out.println(now);
        now.setYear(now.getYear() - 10);
        c = Calendar.getInstance();
        c.set(now.getYear() + 1900, now.getMonth(), now.getDay());

        if(this.getEntryDate().compareTo(c) < 0){
            return new Bonus(120);
        }

        now = Calendar.getInstance().getTime();
        //System.out.println(now);
        now.setYear(now.getYear() - 4);
        c = Calendar.getInstance();
        c.set(now.getYear() + 1900, now.getMonth(), now.getDay());

        if(this.getEntryDate().compareTo(c) < 0){
            return new Bonus(80);
        }

        now = Calendar.getInstance().getTime();
        //System.out.println(now);
        now.setYear(now.getYear() - 2);
        c = Calendar.getInstance();
        c.set(now.getYear() + 1900, now.getMonth(), now.getDay());

        if(this.getEntryDate().compareTo(c) < 0){
            return new Bonus(50);
        }

        return null;
    }

    public Calendar getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Calendar entryDate) {
        Date date = Calendar.getInstance().getTime();
        date.setYear(date.getYear() - 75);

        System.out.println(entryDate.getTime());
        System.out.println(date);

        if(entryDate.getTime().compareTo(date) < 0){
            throw new IllegalArgumentException("illegal argument");
        }

        this.entryDate = entryDate;
    }
}
