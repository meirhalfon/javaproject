package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.isZero;

/**
 *@author Yoel and Jerry
 */

public class Triangle extends Polygon{

    public Triangle(Point3D d, Point3D point3D, Point3D vertices) {
        super(vertices);
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersections = plane.findIntersections(ray);

        if (intersections == null)
            return null; //if there is no intersection with the plane

        Point3D p0 = ray.getPoint();
        Vector v = ray.getVec();
        Vector v1 = vertices.get(0).subtract(p0);//verify if its in the triangle
        Vector v2 = vertices.get(1).subtract(p0);
        Vector v3 = vertices.get(2).subtract(p0);
        double s1 = v.dotProduct(v1.crossProduct(v2));

        if (isZero(s1))
            return null;

        double s2 = v.dotProduct(v2.crossProduct(v3));

        if (isZero(s2))
            return null;

        double s3 = v.dotProduct(v3.crossProduct(v1));

        if (isZero(s3))
            return null;

        if((s1 > 0 && s2 > 0 && s3 > 0) || (s1 < 0 && s2 < 0 && s3 < 0)) {
            return intersections;
        }

        else
            return  null;
    }
}
