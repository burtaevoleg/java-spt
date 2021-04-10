package Practice06.Factory.CoffeeTypes.ItalianStyle;

import Practice06.Factory.Coffee;

public class ItalianStyleAmericano extends Coffee {
    @Override
    public void grindCoffee() {
        System.out.println("grid ItalianStyleAmericano");
    }

    @Override
    public void makeCoffee() {
        System.out.println("make ItalianStyleAmericano");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("pour ItalianStyleAmericano into cup");
    }
}
