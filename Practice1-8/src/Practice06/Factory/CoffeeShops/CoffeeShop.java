package Practice06.Factory.CoffeeShops;

import Practice06.Factory.Coffee;
import Practice06.Factory.CoffeeTypes.CoffeeType;

public abstract class CoffeeShop {

    public Coffee orderCoffee(CoffeeType type) {
        Coffee coffee = createCoffee(type);

        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();

        System.out.println("Вот ваш кофе! Спасибо, приходите еще!");
        return coffee;
    }

    protected abstract Coffee createCoffee(CoffeeType coffeeType);
}
