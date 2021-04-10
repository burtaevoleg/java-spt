package components;

import interfaces.Fighter;
import org.springframework.stereotype.Component;

@Component
public class StreetFighter implements Fighter {
    @Override
    public void doFight() {
        System.out.println("I am a street fighter");
    }
}
