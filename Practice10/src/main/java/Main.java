import interfaces.Fighter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Fighter boxer = context.getBean("boxer", Fighter.class);
        Fighter streetFighter = context.getBean("streetFighter", Fighter.class);
        Fighter judoka = context.getBean("judoka", Fighter.class);
        boxer.doFight();
        streetFighter.doFight();
        judoka.doFight();
        context.close();
    }
}
