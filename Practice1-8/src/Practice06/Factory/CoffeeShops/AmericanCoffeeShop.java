package Practice06.Factory.CoffeeShops;

import Practice06.Factory.Coffee;
import Practice06.Factory.CoffeeTypes.CoffeeType;
import Practice06.Factory.CoffeeTypes.AmericanStyle.AmericanStyleAmericano;
import Practice06.Factory.CoffeeTypes.AmericanStyle.AmericanStyleCaffeLatte;
import Practice06.Factory.CoffeeTypes.AmericanStyle.AmericanStyleCappuccino;
import Practice06.Factory.CoffeeTypes.AmericanStyle.AmericanStyleEspresso;

public class AmericanCoffeeShop extends CoffeeShop {
    @Override
    protected Coffee createCoffee(CoffeeType coffeeType) {
        Coffee coffee = null;
        switch (coffeeType) {
            case AMERICANO:
                coffee = new AmericanStyleAmericano();
                break;
            case ESPRESSO:
                coffee = new AmericanStyleEspresso();
                break;
            case CAPPUCCINO:
                coffee = new AmericanStyleCappuccino();
                break;
            case CAFFE_LATTE:
                coffee = new AmericanStyleCaffeLatte();
                break;
        }
        return coffee;
    }
}
