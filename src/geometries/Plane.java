package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Plane implements Geometry{

    Point3D _q0;
    final Vector _normal;

    public Plane(Point3D q0, Vector normal) {
        _q0 = q0;
        _normal = normal.normalize();
    }

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        Vector v1 = p2.subtract(p1);
        Vector v2 = p3.subtract(p1);
        Vector n = v1.crossProduct(v2);

        _q0 = p1;
        _normal = n.normalize();
    }

    /**
     * getter of the normal vector field
     * @Deprecated use {@link Plane#getNormal with null as parameter}
     * @return
     */

    @Deprecated
    public Vector getNormal() {
        return _normal;
    }

    public Point3D getQ0() {
        return _q0;
    }

    /**
     * implementation of getNormal from Geometry interface
     * @param p who is reference point
     * @return normal to the Tube
     */

    @Override
    public Vector getNormal(Point3D p) {
        return _normal;
    }

    @Override
    public String toString() {
        return "Plane [_q0=" + _q0 + ", _normal=" + _normal + ", getClass()=" + getClass() +
                ", toString()=" + super.toString() + "]";
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Vector v1;  //vector  P0 to Q
        try {  //1 rst cast :verify if the  ray starts from point Q there is no intersections
            v1 = _q0.subtract(ray.getPoint());
        }

        catch (IllegalArgumentException e) {
            return null;
        }

        double nv = _normal.dotProduct(ray.getVec());

        if (isZero(nv)) //second cast  ray is parallel to the plane - no intersections
            return null;

        double t = alignZero(_normal.dotProduct(v1) / nv);

        Point3D P = isZero(t) ? ray.getPoint() : ray.getPoint().add(ray.getVec().scalar(t));

        return t <= 0 ? null : List.of(P);
    }
}