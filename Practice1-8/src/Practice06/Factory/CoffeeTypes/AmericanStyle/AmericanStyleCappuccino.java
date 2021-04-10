package Practice06.Factory.CoffeeTypes.AmericanStyle;

import Practice06.Factory.Coffee;

public class AmericanStyleCappuccino extends Coffee {
    @Override
    public void grindCoffee() {
        System.out.println("grid AmericanStyleCappuccino");
    }

    @Override
    public void makeCoffee() {
        System.out.println("make AmericanStyleCappuccino");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("pour AmericanStyleCappuccino into cup");
    }
}
