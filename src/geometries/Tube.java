package geometries;

import primitives.*;

import java.util.Objects;

public class Tube implements Geometry{
    Ray _axisRay;
    double _radius;

    public Tube(Ray axisRay, double radius) {
        this._axisRay = axisRay;
        this._radius = radius;
    }

    public Ray getAxisRay() {
        return _axisRay;
    }

    public double getRadius() {
        return _radius;
    }

    @Override
    public Vector getNormal(Point3D p)
    {
        Point3D pO = _axisRay.getPoint();
        Vector pO_p = p.subtract(pO);
        Vector v =  _axisRay.getVec();
        double t = v.dotProduct(pO_p);

        Point3D O = pO.add(v.scalar(t));

        return p.subtract(O).normalize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tube tube = (Tube) o;
        return Double.compare(tube._radius, _radius) == 0 && Objects.equals(_axisRay, tube._axisRay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_axisRay, _radius);
    }

    @Override
    public String toString() {
        return "Tube{" +
                "_axisRay=" + _axisRay +
                ", _radius=" + _radius +
                '}';
    }
}
