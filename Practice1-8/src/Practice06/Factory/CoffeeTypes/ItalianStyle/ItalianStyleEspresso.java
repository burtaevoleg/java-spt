package Practice06.Factory.CoffeeTypes.ItalianStyle;

import Practice06.Factory.Coffee;

public class ItalianStyleEspresso extends Coffee {
    @Override
    public void grindCoffee() {
        System.out.println("grid ItalianStyleEspresso");
    }

    @Override
    public void makeCoffee() {
        System.out.println("make ItalianStyleEspresso");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("pour ItalianStyleEspresso into cup");
    }
}
