package Practice07.Flyweight;

import Practice07.Flyweight.Shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        List <Shape> shapes = new ArrayList<>();

        shapes.add(shapeFactory.getShape("круг"));
        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("точка"));
        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("точка"));
        shapes.add(shapeFactory.getShape("круг"));
        shapes.add(shapeFactory.getShape("квадрат"));

        Random random = new Random();
        for (Shape shape: shapes){
            shape.draw(random.nextInt(100), random.nextInt(100));
        }
    }
}
