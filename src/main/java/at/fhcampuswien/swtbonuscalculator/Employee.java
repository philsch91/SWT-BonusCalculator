package at.fhcampuswien.swtbonuscalculator;

import java.util.Calendar;
import java.util.TimeZone;

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

        //less than 2 years

        /**
         * Date solution
        Date limitDate = Calendar.getInstance().getTime();
        limitDate.setYear(limitDate.getYear() - 2);

        Calendar limitCal = Calendar.getInstance();

        ////limitDate.setYear(limitDate.getYear() + 1900);
        ////limitCal.set(limitDate.getYear(), limitDate.getMonth(), limitDate.getDay());
        limitCal.setTime(limitDate);

        //System.out.println(this.getEntryDate().getTime());
        //System.out.println(limitCal.getTime());
        */

        Calendar limitCal = Calendar.getInstance(TimeZone.getDefault());
        limitCal.add(Calendar.YEAR, -2);

        if(this.getEntryDate().compareTo(limitCal) > 0){
            return new Bonus(0);
        }

        //more than 10 years

        limitCal = Calendar.getInstance(TimeZone.getDefault());
        limitCal.add(Calendar.YEAR, -10);

        if(this.getEntryDate().compareTo(limitCal) < 0){
            return new Bonus(120);
        }

        //more than 4 years

        limitCal = Calendar.getInstance(TimeZone.getDefault());
        limitCal.add(Calendar.YEAR, -4);

        if(this.getEntryDate().compareTo(limitCal) < 0){
            return new Bonus(80);
        }

        //more than 2 years

        limitCal = Calendar.getInstance(TimeZone.getDefault());
        limitCal.add(Calendar.YEAR, -2);

        if(this.getEntryDate().compareTo(limitCal) < 0){
            return new Bonus(50);
        }

        return null;
    }

    public Calendar getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Calendar entryDate) {
        Calendar limitCal = Calendar.getInstance(TimeZone.getDefault());
        limitCal.add(Calendar.YEAR, -75);

        //System.out.println(entryDate.getTime());
        //System.out.println(limitCal.getTime());

        if(entryDate.compareTo(limitCal) < 0){
            throw new IllegalArgumentException("illegal argument");
        }

        this.entryDate = entryDate;
    }
}
