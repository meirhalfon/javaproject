package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Test
    void getNormal() {
        Cylinder test = new Cylinder(new Ray(new Point3D(0, 0, 0),new Vector(new Point3D(1,1,0))),2.0,2.0);
        Vector normalTest = test.getNormal(new Point3D(1.0, 1.0, 1.0));
        Vector expected = new Point3D(0,0,1.0).subtract(new Point3D(0, 0, 0)).normalized();
        assertEquals(expected.getHead().getX(), normalTest.getHead().getX());
        assertEquals(expected.getHead().getY(), normalTest.getHead().getY());
        assertEquals(expected.getHead().getZ(), normalTest.getHead().getZ());
    }
}