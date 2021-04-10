package Practice06.Abstract;

import Practice06.Abstract.CoffeeShop.AmericanCoffeeShop;
import Practice06.Abstract.CoffeeShop.CoffeeShop;
import Practice06.Abstract.CoffeeShop.ItalianCoffeeShop;

public class Main {
    public static void main(String[] args) {
        CoffeeShop americanCoffeeShop = new AmericanCoffeeShop();
        americanCoffeeShop.createAmericano();
        americanCoffeeShop.createCappuccino();

        CoffeeShop italianCoffeeShop = new ItalianCoffeeShop();
        italianCoffeeShop.createEspresso();
        italianCoffeeShop.createCappuccino();
    }
}
