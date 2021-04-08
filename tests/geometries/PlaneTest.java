package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import java.util.List;

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

    @Test
    void findIntersections() {
        // ============ Equivalence Partitions Tests ==============
        // TC01 : ray intersect the plane
        Plane plane= new Plane(new Point3D(3,4,4),new Point3D(0,1,0),new Point3D(0,0,1));
        List<Point3D> intersection=plane.findIntersections(new Ray(new Point3D(2,1,1),new Vector(1,2,2)));
        assertEquals(new Point3D(4.199999999999999,5.3999999999999995,5.3999999999999995),intersection.get(0),"fail");
        //TC02:ray doesnt intersect the plane
        Plane plane2= new Plane(new Point3D(0,0,0),new Point3D(1,0,0),new Point3D(0,1,0));
        assertEquals(null, plane2.findIntersections(new Ray(new Point3D(0,0,1),new Vector(1,1,4))),"fail");
        // =============== Boundary Values Tests =================
        // TC01 : ray into the plane
        assertEquals(null, plane2.findIntersections(new Ray(new Point3D(0.5,0.5,0),new Vector(1,1,0))),"fail");
        // TC02 : ray parralele to  the plane
        assertEquals(null, plane2.findIntersections(new Ray(new Point3D(0,0,2),new Vector(1,2,2))),"fail");
        // TC03 : cast 1: befor the plane/ ray orthogonal to  the plane/
        assertEquals(new Point3D(2.0,2.0,0.0), plane2.findIntersections(new Ray(new Point3D(1,1,-2),new Vector(1,1,2))).get(0),"fail");
        // TC04 : cast 2: after the plane/ ray orthogonal to  the plane/
        assertEquals(null, plane2.findIntersections(new Ray(new Point3D(1,1,2),new Vector(1,1,4))),"fail");
        // TC05 : cast 3: in the plane/ ray orthogonal to  the plane/
        assertEquals(null, plane2.findIntersections(new Ray(new Point3D(1,0,0),new Vector(1,0,1))),"fail");
        // TC06 : ray not parallalele and not orthogonal to  the plane/
        assertEquals(null, plane2.findIntersections(new Ray(new Point3D(1,0,0),new Vector(4,4,1))),"fail");
    }
}