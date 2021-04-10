package Practice06.Factory.CoffeeTypes.AmericanStyle;

import Practice06.Factory.Coffee;

public class AmericanStyleCaffeLatte extends Coffee {
    @Override
    public void grindCoffee() {
        System.out.println("grid AmericanStyleCaffeLatte");
    }

    @Override
    public void makeCoffee() {
        System.out.println("make AmericanStyleCaffeLatte");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("pour AmericanStyleCaffeLatte into cup");
    }
}
