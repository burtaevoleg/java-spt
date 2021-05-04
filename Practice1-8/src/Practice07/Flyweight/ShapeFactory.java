package Practice07.Flyweight;

import Practice07.Flyweight.Shapes.Circle;
import Practice07.Flyweight.Shapes.Point;
import Practice07.Flyweight.Shapes.Shape;
import Practice07.Flyweight.Shapes.Square;
import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static final Map<String, Shape> shapes = new HashMap();

    public Shape getShape(String shapeName){
        Shape shape = shapes.get(shapeName);
        if (shape == null){
            switch (shapeName){
                case "круг":
                    shape = new Circle();
                    break;
                case "точка":
                    shape = new Point();
                    break;
                case "квадрат":
                    shape = new Square();
                    break;
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }
}
