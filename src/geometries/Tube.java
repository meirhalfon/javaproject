package geometries;

import primitives.*;

import java.util.List;
import java.util.Objects;

public class Tube extends RadialGeometry implements Geometry{
    final    Ray _axisRay;

    public Tube( double radius,Ray axisRay) {
        super(radius);
        this._axisRay = axisRay;
    }

    public Ray getAxisRay() {
        return _axisRay;
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

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}