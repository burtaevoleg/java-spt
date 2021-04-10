package Practice06.Factory.CoffeeTypes.ItalianStyle;

import Practice06.Factory.Coffee;

public class ItalianStyleCaffeLatte extends Coffee {
    @Override
    public void grindCoffee() {
        System.out.println("grid ItalianStyleCaffeLatte");
    }

    @Override
    public void makeCoffee() {
        System.out.println("make ItalianStyleCaffeLatte");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("pour ItalianStyleCaffeLatte into cup");
    }
}
