package geometries;

import org.junit.jupiter.api.Test;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TubeTest {

    private Ray _axisRay;

    @Test
    void getNormal() {
        Point3D center =  new Point3D(0, 1, 0);
        Tube test = new Tube(1.0, new Ray(new Point3D(1, 0, 0),new Vector(new Point3D(1, 0, 0))));
        Vector test1 = test.getNormal(new Point3D(0, 1, 0));
        assertEquals(new Coordinate(0.0), test1.getHead().getX());
        assertEquals(new Coordinate(1.0), test1.getHead().getY());
        assertEquals(new Coordinate(0.0), test1.getHead().getZ());
    }


}