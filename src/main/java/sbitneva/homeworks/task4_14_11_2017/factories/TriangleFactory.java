package task4_14_11_2017.factories;

import task4_14_11_2017.figures.Point;
import task4_14_11_2017.figures.Triangle;

public class TriangleFactory extends AbstractConcreteFactory{

    public static Triangle create(){
        Point apexA, apexB, apexC;
        apexA = PointFactory.create();
        apexB = PointFactory.create();
        apexC = PointFactory.create();

        Triangle triangle = new Triangle(apexA, apexB, apexC);
        while(!triangle.isValid()){
            triangle.setApexA(PointFactory.create());
        }

        return triangle;
    }
}
