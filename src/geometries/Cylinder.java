package geometries;

import primitives.*;

import java.util.Objects;

public class Cylinder extends Tube{

    final double _height;

    public Cylinder(Ray axisRay, double radius, double height) {
        super(radius, axisRay);
        _height = height;
    }

    public double getHeight() {
        return _height;
    }

    public Vector getNormal(Point3D p)
    {
        return super.getNormal(p);
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "_height=" + _height +
                ", _axisRay=" + _axisRay +
                ", _radius=" + _radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cylinder cylinder = (Cylinder) o;
        return Double.compare(cylinder._height, _height) == 0;
    }
}