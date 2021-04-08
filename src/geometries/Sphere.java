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
        Point3D p0 = ray.getPoint();
        Vector v = ray.getVec();

        if (p0.equals(_center)){
            throw new IllegalArgumentException("Ray p0 cannot be equals to the center of the sphere");
        }

        Vector u = _center.subtract(p0);
        double tm = u.dotProduct(v);
        double d = alignZero(Math.sqrt(u.lengthSquared() - tm*tm));

        if (d >= _radius) {
            return null;
        }

        double th = Math.sqrt(_radius*_radius - d*d);
        double t1 = tm - th;
        double t2 = tm + th;

        if(t1 > 0 && t2 > 0) {
            Point3D p1 = p0.add(v.scalar(t1));
            Point3D p2 = p0.add(v.scalar(t2));

            return List.of(p1, p2);
        }

        if(t1 > 0) {
            Point3D p1 = p0.add(v.scalar(t1));

            return List.of(p1);
        }

        if(t2 > 0) {
            Point3D p2 = p0.add(v.scalar(t2));

            return List.of(p2);
        }

        return null;
    }
}