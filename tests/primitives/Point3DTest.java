package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {

    Point3D p1 = new Point3D(0.0d,0.5d,1.0d);
    Point3D p2 = new Point3D(0.000000000001d,0.499999999999d, 1d);
    @Test
    void equals() {
        assertEquals(p1,p2);
    }

    @Test
    public String toString() {
        System.out.println("the first point is: " + p1);
        System.out.println("the second point is: " + p2);
        return null;
    }

    @Test
    void distance() {
        Point3D p3 = new Point3D(0, 0, 2);
        assertEquals(20, p3.distance(p2),2);
    }

    @Test
    void distanceSquared(){
        assertEquals(0, p1.distanceSquared(p2));
    }
}