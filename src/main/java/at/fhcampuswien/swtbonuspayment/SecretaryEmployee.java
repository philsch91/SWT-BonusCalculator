package at.fhcampuswien.swtbonuspayment;

import java.util.Calendar;
import java.util.Date;

public class SecretaryEmployee extends Employee {

    /**
     * override in subclasses
     * @return Bonus
     */
    @Override
    public Bonus getBonus(){
        Bonus bonus = super.getBonus();
        bonus.value = bonus.value * 2;

        return bonus;
    }
}
