package renderer;

import elements.*;
import geometries.*;
import org.junit.jupiter.api.Test;
import primitives.*;
import scene.Scene;
import primitives.Color;

/**
 * Test rendering a basic image
 * @author Dan
 */

public class RenderTests {

    private Camera camera = new Camera.BuilderCamera(Point3D.ZERO, new Vector(0, 0, -1), new Vector(0, 1, 0))
            .setDistance(100)
            .setViewPlaneHeight(500)
            .setViewPlaneWidth(500)
            .build();

    /**
     * Produce a scene with basic 3D model and render it into a jpeg image with a grid
     */

    @Test
    public void basicRenderTwoColorTest() {

        Scene scene = new Scene("Test scene")
                .setAmbientLight(new AmbientLight(new Color(255, 191, 191), 1))
                .setBackground(new Color(75, 127, 90));


        scene.geometries.add(new Sphere(50, new Point3D(0, 0, -100)),
                new Triangle(new Point3D(-100, 0, -100), new Point3D(0, 100, -100), new Point3D(-100, 100, -100)), // up left
                new Triangle(new Point3D(100, 0, -100), new Point3D(0, 100, -100), new Point3D(100, 100, -100)), // up right
                new Triangle(new Point3D(-100, 0, -100), new Point3D(0, -100, -100), new Point3D(-100, -100, -100)), // down left
                new Triangle(new Point3D(100, 0, -100), new Point3D(0, -100, -100), new Point3D(100, -100, -100))); // down right

        ImageWriter imageWriter = new ImageWriter("base render test", 1000, 1000);
        Render render = new Render()
                .setImageWriter(imageWriter)
                .setScene(scene)
                .setCamera(camera)
                .setRayTracer(new RayTracerBasic(scene));


        render.renderImage();
        render.printGrid(100, new Color(java.awt.Color.YELLOW));
        render.writeToImage();

    }
}