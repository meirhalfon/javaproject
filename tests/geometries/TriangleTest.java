package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void getNormal() {
        new PolygonTest().testGetNormal();
    }

    @Test
    void findIntersections() {
        // ============ Equivalence Partitions Tests ==============
        Triangle triangle= new Triangle(new Point3D(-10,0,0),new Point3D(10,0,0),new Point3D(0,10,0));

        //TC01 inside triangle
        assertEquals(new Point3D(1.5,1.5,0.0),triangle.findIntersections(new Ray(new Point3D(1,1,-1),new Vector(1,1,2))).get(0), "fail");

        //TC02 outside against edege
        assertEquals(null,triangle.findIntersections(new Ray(new Point3D(-10,1,-1),new Vector(-10,1,2))),"fail");

        //TC03 outside against vertex
        assertEquals( null,triangle.findIntersections(new Ray(new Point3D(-11,0,-1),new Vector(-11,0,2))),"fail");

        // =============== Boundary Values Tests =================

        //TCO1 on edge
        assertEquals(null,triangle.findIntersections(new Ray(new Point3D(-10,0,-10),new Vector(-10,0,5))),"fail");

        //TCO2 in vertex
        assertEquals(null,triangle.findIntersections(new Ray(new Point3D(-5,-5,-0),new Vector(-5,-5,5))),"fail");

        //TCO3 on edge contination
        assertEquals(null,triangle.findIntersections(new Ray(new Point3D(-10,20,-10),new Vector(-10,20,5))),"fail");
    }
}