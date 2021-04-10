package Practice07.Flyweight.Shapes;

public class Square implements Shape {
    @Override
    public void draw(int x, int y) {
        int a = 10;
        System.out.println("("+ x + ", " + y +"): рисуем круг со стороной:" + a);
    }
}
