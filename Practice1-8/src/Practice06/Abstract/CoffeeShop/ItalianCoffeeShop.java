package Practice06.Abstract.CoffeeShop;

import Practice06.Abstract.CoffeeTypes.Interfaces.Americano;
import Practice06.Abstract.CoffeeTypes.Interfaces.Cappuccino;
import Practice06.Abstract.CoffeeTypes.Interfaces.Espresso;
import Practice06.Abstract.CoffeeTypes.ItalianStyle.ItalianStyleAmericano;
import Practice06.Abstract.CoffeeTypes.ItalianStyle.ItalianStyleCappuccino;
import Practice06.Abstract.CoffeeTypes.ItalianStyle.ItalianStyleEspresso;

public class ItalianCoffeeShop implements CoffeeShop {
    @Override
    public Americano createAmericano() {
        return new ItalianStyleAmericano();
    }

    @Override
    public Espresso createEspresso() {
        return new ItalianStyleEspresso();
    }

    @Override
    public Cappuccino createCappuccino() {
        return new ItalianStyleCappuccino();
    }
}
