package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;

/**
 * Represent a sphere
 */

public class Sphere extends RadialGeometry implements Geometry{

    final Point3D _center;

    public Sphere(double radius, Point3D center){
        super(radius);
        this._center = center;

    }

    public Sphere(double x, double y, double z, double radius) {
        super(radius);
        _center = new Point3D(x, y, z);
    }

    public Point3D getCenter() {
        return _center;
    }

    /**
     * normalization between the points p and o (who is the center of the sphere)
     * @param p point in the sphere
     * @return a vector as result of the operation
     */

    @Override
    public Vector getNormal(Point3D p)
    {
        Vector p_o = p.subtract(_center);
        Vector v = p_o.normalize();
        return v;
    }



    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere._radius, _radius) == 0 && _center.equals(sphere._center);
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Point3D P0 = ray.getPoint();
        Vector v = ray.getVec();

        if (P0.equals(_center)) {
            return List.of(_center.add(v.scalar(_radius)));
        }

        Vector U = _center.subtract(P0);

        double tm = alignZero(v.dotProduct(U));
        double d = alignZero(Math.sqrt(U.lengthSquared() - tm * tm));

        // no intersections : the ray direction is above the sphere
        if (d >= _radius) {
            return null;
        }

        double th = alignZero(Math.sqrt(_radius * _radius - d * d));
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        if (t1 > 0 && t2 > 0) {
//            Point3D P1 = P0.add(v.scale(t1));
//            Point3D P2 = P0.add(v.scale(t2));
            Point3D P1 =ray.getPoint(t1);
            Point3D P2 =ray.getPoint(t2);
            return List.of(P1, P2);
        }
        if (t1 > 0) {
//            Point3D P1 = P0.add(v.scale(t1));
            Point3D P1 =ray.getPoint(t1);
            return List.of(P1);
        }
        if (t2 > 0) {
//            Point3D P2 = P0.add(v.scale(t2));
            Point3D P2 =ray.getPoint(t2);
            return List.of(P2);
        }
        return null;
    }
}