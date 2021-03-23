package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void getNormal() {

        Plane test = new Plane(new Point3D(1.0,1.0,1.0),new Vector(new Point3D(3.0,3.0,3.0)));
        Vector v = new Vector(new Point3D(3.0,3.0,3.0));
        assertEquals(v.getHead().getX(),test.getNormal().getHead().getX());
        assertEquals(v.getHead().getY(),test.getNormal().getHead().getY());
        assertEquals(v.getHead().getZ(),test.getNormal().getHead().getZ());
    }
}