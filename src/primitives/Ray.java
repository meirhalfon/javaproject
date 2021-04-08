package primitives;

import java.util.Objects;

public class Ray {
    final Point3D _p0;
    final Vector _dir;

    public Ray(Point3D p0, Vector dir) {
        dir.normalize();
        _p0 = p0;
        _dir = dir;
    }

    /**
     * getter point
     * @return
     */

    public Point3D getPoint() {
        return _p0;
    }

    /**
     * getter vector
     * @return
     */

    public Vector getVec() {
        return _dir;
    }

    @Override
    public String toString() {
        return "Ray{" +
                "_p0=" + _p0 +
                ", _dir=" + _dir +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return _p0.equals(ray._p0) && _dir.equals(ray._dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_p0, _dir);
    }

    public Point3D getPoint(double t)
    {
        return _p0.add(_dir.scalar(t));
    }
}