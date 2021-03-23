package geometries;

import primitives.*;

public class Plane implements Geometry{

    Point3D _q0;
    final Vector _normal;

    public Plane(Point3D q0, Vector normal) {
        _q0 = q0;
        _normal = normal;
    }

    public Plane(Point3D q1, Point3D q2, Point3D q3){
        this._normal = null;
        this._q0 = q1;
    }

    public Vector getNormal() {
        return _normal;
    }


@Override
    public Vector getNormal(Point3D p) {
        return _normal;
    }

    @Override
    public String toString() {
        return "Plane [_q0=" + _q0 + ", _normal=" + _normal + ", getClass()=" + getClass() +
                ", toString()=" + super.toString() + "]";
    }
}
