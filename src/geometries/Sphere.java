package geometries;

import primitives.*;

public class Sphere implements Geometry{

    final Point3D _center;
    final double _radius;

    public Sphere(Point3D a, double r){
        this._center = a;
        this._radius = r;
    }

    public Sphere(double x, double y, double z, double r) {
        _center = new Point3D(x, y, z);
        _radius = r;
    }

    public Point3D getCenter() {
        return _center;
    }

    public double getRadius() {
        return _radius;
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
}
