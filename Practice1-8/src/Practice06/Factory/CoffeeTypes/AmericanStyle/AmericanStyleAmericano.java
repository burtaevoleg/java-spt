package Practice06.Factory.CoffeeTypes.AmericanStyle;

import Practice06.Factory.Coffee;

public class AmericanStyleAmericano extends Coffee {
    @Override
    public void grindCoffee() {
        System.out.println("grid AmericanStyleAmericano");
    }

    @Override
    public void makeCoffee() {
        System.out.println("make AmericanStyleAmericano");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("pour AmericanStyleAmericano into cup");
    }
}
