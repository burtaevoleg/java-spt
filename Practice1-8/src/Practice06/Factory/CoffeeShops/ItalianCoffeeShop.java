package Practice06.Factory.CoffeeShops;

import Practice06.Factory.Coffee;
import Practice06.Factory.CoffeeTypes.CoffeeType;
import Practice06.Factory.CoffeeTypes.ItalianStyle.ItalianStyleAmericano;
import Practice06.Factory.CoffeeTypes.ItalianStyle.ItalianStyleCaffeLatte;
import Practice06.Factory.CoffeeTypes.ItalianStyle.ItalianStyleCappuccino;
import Practice06.Factory.CoffeeTypes.ItalianStyle.ItalianStyleEspresso;

public class ItalianCoffeeShop extends CoffeeShop {
    @Override
    protected Coffee createCoffee(CoffeeType coffeeType) {
        Coffee coffee = null;
        switch (coffeeType) {
            case AMERICANO:
                coffee = new ItalianStyleAmericano();
                break;
            case ESPRESSO:
                coffee = new ItalianStyleEspresso();
                break;
            case CAPPUCCINO:
                coffee = new ItalianStyleCappuccino();
                break;
            case CAFFE_LATTE:
                coffee = new ItalianStyleCaffeLatte();
                break;
        }
        return coffee;
    }
}
