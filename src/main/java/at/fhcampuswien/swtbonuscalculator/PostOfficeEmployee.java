package at.fhcampuswien.swtbonuscalculator;

public class PostOfficeEmployee extends Employee {

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
