package Practice07.Flyweight.Shapes;

public class Circle implements Shape {
    @Override
    public void draw(int x, int y) {
        int r = 5;
        System.out.println("("+ x + ", " + y +"): рисуем круг с радиусом:" + r);
    }
}
