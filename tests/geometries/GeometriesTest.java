package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class GeometriesTest {

    @Test
    void findIntersections() {
        Geometries geos = new Geometries();
        geos.add(new Sphere(5, new Point3D(1,1,1)));
        assertNull(geos.findIntersections(new Ray(new Point3D(2,2,2), new Vector(1,1,1))));
    }
}