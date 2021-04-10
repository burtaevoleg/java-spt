package Practice06.Factory;


import Practice06.Factory.CoffeeShops.AmericanCoffeeShop;
import Practice06.Factory.CoffeeShops.CoffeeShop;
import Practice06.Factory.CoffeeShops.ItalianCoffeeShop;
import Practice06.Factory.CoffeeTypes.CoffeeType;

public class Main {
    public static void main(String[] args) {
        CoffeeShop italianCoffeeShop = new ItalianCoffeeShop();
        italianCoffeeShop.orderCoffee(CoffeeType.AMERICANO);

        CoffeeShop americanCoffeeShop = new AmericanCoffeeShop();
        americanCoffeeShop.orderCoffee(CoffeeType.CAFFE_LATTE);
    }
}
