package Practice06.Abstract.CoffeeShop;

import Practice06.Abstract.CoffeeTypes.Interfaces.Americano;
import Practice06.Abstract.CoffeeTypes.Interfaces.Cappuccino;
import Practice06.Abstract.CoffeeTypes.Interfaces.Espresso;

public interface CoffeeShop {
    Americano createAmericano();
    Espresso createEspresso();
    Cappuccino createCappuccino();
}
