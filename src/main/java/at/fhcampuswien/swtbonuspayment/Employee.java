package at.fhcampuswien.swtbonuspayment;

import java.util.Calendar;

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

        //if()
        return null;
    }
}
