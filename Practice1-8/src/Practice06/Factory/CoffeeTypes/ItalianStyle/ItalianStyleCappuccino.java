package Practice06.Factory.CoffeeTypes.ItalianStyle;

import Practice06.Factory.Coffee;

public class ItalianStyleCappuccino extends Coffee {
    @Override
    public void grindCoffee() {
        System.out.println("grid ItalianStyleCappuccino");
    }

    @Override
    public void makeCoffee() {
        System.out.println("make ItalianStyleCappuccino");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("pour ItalianStyleCappuccino into cup");
    }
}
