package primitives;

import java.util.Objects;

import static primitives.Point3D.ZERO;

public class Vector {

    Point3D _head;

    /**
     * constructor that receives 3 double in parameter and verify if this point is different of (0,0,0) or not
     * if the point if not different of (0,0,0) so there is exception
     * @param x coordinate for X axis
     * @param y coordinate for Y axis
     * @param z coordinate for Z axis
     */

    public Vector(double x, double y, double z) {
        _head = new Point3D(x, y, z);

        if (_head.equals(ZERO))
            throw new IllegalArgumentException("Zero vector is forbidden !");
    }

    /**
     * constructor that receives point in parameter and verify if this point is different of (0,0,0) or not
     * if the point if not different of (0,0,0) so there is exception
     * @param head
     */

    public Vector(Point3D head){

        if(head.equals(ZERO))
        {
            throw new IllegalArgumentException("Vector head cannot be Point(0, 0, 0");
        }

        _head = head;
    }

    /**
     * getter _head
     * @return _head
     */

    public Point3D getHead() {
        return _head;
    }

    /**
     * products of the corresponding coordinates of 2 vectors
     * @param v second vector for the operation
     * @return the sum of the products
     */

    public double dotProduct(Vector v) {
        double u1 = _head._x.coord;
        double u2 = _head._y.coord;
        double u3 = _head._z.coord;

        double v1 = v._head._x.coord;
        double v2 = v._head._y.coord;
        double v3 = v._head._z.coord;

        return (u1*v1 + u2*v2 + u3*v3);
    }

    /**
     * cross product between two vectors
     * @param v the second vector for the operation
     * @return a vector
     */

    public Vector crossProduct(Vector v) {
        double u1 = _head._x.coord;
        double u2 = _head._y.coord;
        double u3 = _head._z.coord;

        double v1 = v._head._x.coord;
        double v2 = v._head._y.coord;
        double v3 = v._head._z.coord;

        return new Vector(new Point3D(
                u2*v3 - u3*v2,
                u3*v1 - u1*v3,
                u1*v2 - u2*v1
        ));
    }

    /**
     * addition between two vectors
     * @param v the second vector for the operation
     * @return a vector
     */

    public Vector add(Vector v) {
        double u1 = _head._x.coord;
        double u2 = _head._y.coord;
        double u3 = _head._z.coord;

        double v1 = v._head._x.coord;
        double v2 = v._head._y.coord;
        double v3 = v._head._z.coord;

        return new Vector(new Point3D(
                u1 + v1,
                u2 + v2,
                u3 + v3
        ));
    }

    /**
     * substraction between 2 vectors
     * @param v the second vector for the operation
     * @return the vector after the substraction
     */

    public Vector substract(Vector v) {

        return new Vector(
                this._head._x.coord - v._head._x.coord,
                this._head._y.coord - v._head._y.coord,
                this._head._z.coord - v._head._z.coord
        );
    }

    /**
     * multiplication between a vector and a constant (double)
     * @param a the constant
     * @return the new vector after the operation
     */

    public Vector scalar(double a){
        double u1 = _head._x.coord;
        double u2 = _head._y.coord;
        double u3 = _head._z.coord;

        return new Vector(new Point3D(
                a*u1,
                a*u2,
                a*u3
        ));
    }

    /**
     * calculates the square of the length of a vector
     * @return squared length
     */

    public double lengthSquared(){
        double u1 = _head._x.coord;
        double u2 = _head._y.coord;
        double u3 = _head._z.coord;

        return ((u1 * u1) + (u2 * u2) + (u3 * u3));
    }

    /**
     * calculates the length of a vector
     * @return length
     */

    public double length(){
        double u1 = _head._x.coord;
        double u2 = _head._y.coord;
        double u3 = _head._z.coord;

        return Math.sqrt(lengthSquared());
    }

    /**
     * normalize the vector in change his head point
     * @return the new vector after the normalization
     */

    public Vector normalize(){
        this._head = new Point3D(
                _head._x.coord/length(),
                _head._y.coord/length(),
                _head._z.coord / length() );
        return this;
    }

    /**
     * returns a new normalized vector based on that one
     * @return a new normalized vector
     */

    public Vector normalized()
    {
        Vector normal  = new Vector(_head);
        normal.normalize();

        return normal;
    }

    @Override
    public String toString(){
        return "head= " + _head.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return _head.equals(vector._head);
    }
}