package primitives;

import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;

class VectorTest {
    Vector v1 = new Vector(1, 2, 3);
    Vector v2 = new Vector(0, 3, -2);

    @Test
    void testZeroPoints(){

        try { // test zero vector
            new Vector(0, 0, 0);
            fail("ERROR: zero vector does not throw an exception");
        } catch (IllegalArgumentException e) {
            out.println("good: Vector 0 not created");
        }

    }


    @Test
    void dotProduct() {
        Vector v3 = new Vector(0, 3, -2);
        double v1DotV3= alignZero(v1.dotProduct(v3));
        //TC01: Two orthogonal vector
        assertEquals(0,v1DotV3,"ERROR: dotProduct() for orthogonal vectors is not zero");
        //TC02:Two vector not orthogonal
        v3=new Vector(0,2,-2);
        if(isZero(v1.dotProduct(v3)))
        {
            fail("ERROR:Must be different from 0 because v1 not orthogonal to v3");
        }

    }

    @Test
    void crossProduct() {

        // ============ Equivalence Partitions Tests ==============
        Vector v3 = new Vector(-2, -4, -6);
        Vector vr = v1.crossProduct(v3);

        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        assertEquals(v1.length() * v2.length(), vr.length(), 0.00001, "crossProduct() wrong result length");

        // TC02: Test cross-product result orthogonality to its operands
        assertTrue(isZero(vr.dotProduct(v1)), "crossProduct() result is not orthogonal to 1st operand");
        assertTrue(isZero(vr.dotProduct(v2)), "crossProduct() result is not orthogonal to 2nd operand");

        // =============== Boundary Values Tests ==================
        // TC11: test zero vector from cross-productof co-lined vectors

        try {
            v1.crossProduct(v2);
            fail("crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception e) {}

    }

    @Test
    void add() {
    }

    @Test
    void substract() {
        Vector vminus = v1.substract(v2);
    }

    @Test
    void scalar() {
        Vector vscale = v1.scalar(-0.9999999999999999999);


        assertEquals(new Vector(-1,-2,-3), vscale);
    }

    @Test
    void lengthSquared() {
    }

    @Test
    void length() {
    }

    @Test
    void normalize() {
        Vector v = new Vector(1, 2, 3);
        Vector vCopy = new Vector(v.getHead());
        Vector vCopyNormalize = vCopy.normalize();
        if (vCopy != vCopyNormalize)
            out.println("ERROR: normalize() function creates a new vector");
        if (!isZero(vCopyNormalize.length() - 1))
            out.println("ERROR: normalize() result is not a unit vector");
    }

    @Test
    void normalized() {
        Vector v = new Vector(1, 2, 3);
        Vector vCopy = new Vector(v.getHead());
        Vector vCopyNormalize = vCopy.normalize();
        assertEquals(vCopy , vCopyNormalize,"ERROR: normalize() function creates a new vector" );

        if (!isZero(vCopyNormalize.length() - 1))
            out.println("ERROR: normalize() result is not a unit vector");
        Vector u = v.normalized();
        v.normalize();
        if (u == v)
            out.println("ERROR: normalizated() function does not create a new vector");
        if (u.equals(v))
            out.println("GOOD: content are equals ");

    }
}