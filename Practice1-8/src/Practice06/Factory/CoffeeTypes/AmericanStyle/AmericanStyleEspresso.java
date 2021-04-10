package Practice06.Factory.CoffeeTypes.AmericanStyle;

import Practice06.Factory.Coffee;

public class AmericanStyleEspresso extends Coffee {
    @Override
    public void grindCoffee() {
        System.out.println("grid AmericanStyleEspresso");
    }

    @Override
    public void makeCoffee() {
        System.out.println("make AmericanStyleEspresso");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("pour AmericanStyleEspresso into cup");
    }
}
