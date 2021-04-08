package primitives;

import java.util.Objects;

/**
 * basic Point for RayTracing project
 * @author Dan
 * @author jerry halfon halfoncj1@gmail.com 1325129
 * @author yoel obadia yoel.obadia.yo@gmail.com 1413422
 */

public class Point3D {
    final Coordinate _x;
    final Coordinate _y;
    final Coordinate _z;

    final public static Point3D ZERO = new Point3D(0.0d, 0.0d, 0.0d);

    /**
     * constructor for Point3D
     * @param x coordinate for X axis
     * @param y coordinate for Y axis
     * @param z coordinate for Z axis
     */

    public Point3D(double x, double y, double z) {
        _x = new Coordinate(x);
        _y = new Coordinate(y);
        _z = new Coordinate(z);
    }

    /**
     * getter coordinate x
     * @return
     */

    public double getX()
    {
        return _x.coord;
    }

    /**
     * getter coordinate y
     * @return
     */

    public double getY()
    {
        return _y.coord;
    }

    /**
     * getter coordinate z
     * @return
     */

    public double getZ()
    {
        return _z.coord;
    }

    public boolean equals(Point3D object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Point3D point3D = (Point3D) object;
        return _x.equals(point3D._x) && _y.equals(point3D._y) && _z.equals(point3D._z);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "(" + _x + "," + _y + "," + _z + ")";
    }

    /**
     * return the distance between 2 points squared
     * @param other who is the second point
     * @return (x2-x1)^2 + (y2-y1)^2 + (z2-z1)^2
     */

    public double distanceSquared(Point3D other){
        final double x1 = _x.coord;
        final double y1 = _y.coord;
        final double z1 = _z.coord;

        final double x2 = other._x.coord;
        final double y2 = other._y.coord;
        final double z2 = other._z.coord;

        return (((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1))+((z2-z1)*(z2-z1)));
    }

    /**
     * return the distance between 2 points
     * @param point3D who is the second point
     * @return euclidean distance between 2 3D points
     */

    public double distance(Point3D point3D){
        return Math.sqrt(distanceSquared(point3D));
    }

    /**
     * Vector subtraction
     * Receives a second point in the parameter, returns a vector from the second point to the point on which the operation is performed
     * @param pt2 who is the second point
     * @return
     */

    public Vector subtract(Point3D pt2) {

        if(pt2.equals(this)){
            throw new IllegalArgumentException("cannot create Vector to Point(0,0,0)");
        }

        return new Vector(new Point3D(
                pt2._x.coord - _x.coord,
                pt2._y.coord - _y.coord,
                pt2._z.coord - _z.coord
        ));
    }

    /**
     * addition between point and vector and return the point getted
     * To change later...
     * @param vector this vector that we add to point
     * @return
     */

    public Point3D add(Vector vector){
        return new Point3D(_x.coord + vector._head._x.coord,
                _y.coord + vector._head._y.coord,
                _z.coord + vector._head._z.coord
        );
    }


}