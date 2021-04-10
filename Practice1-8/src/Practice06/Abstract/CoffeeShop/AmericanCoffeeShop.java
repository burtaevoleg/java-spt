package Practice06.Abstract.CoffeeShop;

import Practice06.Abstract.CoffeeTypes.AmericanStyle.AmericanStyleAmericano;
import Practice06.Abstract.CoffeeTypes.AmericanStyle.AmericanStyleCappuccino;
import Practice06.Abstract.CoffeeTypes.AmericanStyle.AmericanStyleEspresso;
import Practice06.Abstract.CoffeeTypes.Interfaces.Americano;
import Practice06.Abstract.CoffeeTypes.Interfaces.Cappuccino;
import Practice06.Abstract.CoffeeTypes.Interfaces.Espresso;

public class AmericanCoffeeShop implements CoffeeShop {
    @Override
    public Americano createAmericano() {
        return new AmericanStyleAmericano();
    }

    @Override
    public Espresso createEspresso() {
        return new AmericanStyleEspresso();
    }

    @Override
    public Cappuccino createCappuccino() {
        return new AmericanStyleCappuccino();
    }
}
