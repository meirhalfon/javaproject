package geometries;

public abstract class RadialGeometry {
    final protected double _radius;

    public RadialGeometry(double radius) {
        _radius = 0;
    }

    public double getRadius() {
        return _radius;
    }
}
