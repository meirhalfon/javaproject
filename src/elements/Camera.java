package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

public class Camera {
    final private Point3D _p0;
    final private Vector _vTo;
    final private Vector _vUp;
    final private Vector _vRight;

    private double _distance;
    private double _width;
    private double _height;

    private Camera(BuilderCamera builder) {
        _p0 = builder._p0;
        _vTo = builder._vTo;
        _vUp = builder._vUp;
        _vRight = builder._vRight;
        _height = builder._height;
        _width = builder._width;
        _distance = builder._distance;
    }

    public Camera(Point3D p0, Vector vTo, Vector vUp) {
        _p0 = p0;
        _vTo = vTo.normalized();
        _vUp = vUp.normalized();
        if (!isZero(_vTo.dotProduct(_vUp))){
            throw new IllegalArgumentException("vUp is not orthogonal to vTo");
        }
        _vRight = vTo.crossProduct(_vUp);
    }


    /**
     * borrowing from Builder pattern
     * @param width
     * @param height
     * @return
     */

    public Camera setViewPlaneSize(double width, double height){
        _width=width;
        _height=height;
        return this;
    }

    public Ray constructRayThroughPixel(int nX, int nY, int j, int i){
        Point3D PC = _p0.add(_vTo.scalar(_distance));

        double Ry = _height / nY;
        double Rx = _width / nX;

        double yI = -(i - (nY - 1) / 2d) * Ry;
        double xJ =  (j - (nX - 1) / 2d) * Rx;

        Point3D Pij = PC;

        if(xJ != 0){
            Pij = Pij.add(_vRight.scalar((xJ)));
        }

        if(yI != 0){
            Pij = Pij.add(_vUp.scalar((-yI)));
        }

        if(isZero(yI) && isZero(xJ)){
            return new Ray(_p0, Pij.subtract((_p0)));
        }

        if(isZero(xJ)){
            Pij = PC.add(_vUp.scalar(-yI));
            return new Ray(_p0, Pij.subtract(_p0));
        }

        if(isZero(yI)){
            Pij = PC.add(_vRight.scalar(xJ));
            return new Ray(_p0, Pij.subtract(_p0));
        }

        Vector deltaX = _vRight.scalar(xJ);
        Vector deltaY = _vUp.scalar(yI);

        Pij = PC.add(_vRight.scalar(xJ).add(_vUp.scalar(yI)));
        Vector Vij = Pij.subtract(_p0);

        return new Ray(_p0, Vij);
    }

    public Camera setDistance(double distance){
        _distance = distance;
        return this;
    }

    public Point3D getP0() {
        return _p0;
    }

    public Vector getvTo() {
        return _vTo;
    }

    public Vector getvUp() {
        return _vUp;
    }

    public Vector getvRight() {
        return _vRight;
    }


    /**
     * Builder Class for Camera
     */

    public static class BuilderCamera {
        final private Point3D _p0;
        final private Vector _vTo;
        final private Vector _vUp;
        final private Vector _vRight;

        private double _distance = 10;
        private double _width = 1;
        private double _height = 1;

        public Camera build() {
            Camera camera = new Camera(this);
            return camera;
        }

        public BuilderCamera setDistance(double distance) {
            _distance = distance;
            return this;
        }


        public BuilderCamera setViewPlaneWidth(double width) {
            _width = width;
            return this;
        }

        public BuilderCamera setViewPlaneHeight(double height) {
            _height = height;
            return this;
        }

        public BuilderCamera(Point3D p0, Vector vTo, Vector vUp) {
            _p0 = p0;

            if (!isZero(vTo.dotProduct(vUp))) {
                throw new IllegalArgumentException("vto and vup are not orthogonal");
            }

            _vTo = vTo.normalized();
            _vUp = vUp.normalized();

            _vRight = _vTo.crossProduct(_vUp);

        }
    }
}