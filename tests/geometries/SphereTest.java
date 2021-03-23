package geometries;

import static org.junit.jupiter.api.Assertions.*;
import primitives.*;

import org.junit.jupiter.api.Test;

class SphereTest {

    @Test
    void getNormal() {
        Point3D centerTest = new Point3D(1, 0, 1);
        Sphere Sphtests = new Sphere(new Point3D(2, 0, 2), 1.0);
        Vector result = Sphtests.getNormal(centerTest);
        Vector test = new Vector(new Point3D(1, 0, 1)).normalized();
        assertEquals(result.getHead().getX(), test.getHead().getX());
        assertEquals(result.getHead().getY(), test.getHead().getY());
        assertEquals(result.getHead().getZ(), test.getHead().getZ());
    }

}