package org.pythonsogood;

import org.pythonsogood.interfaces.Render;
import org.pythonsogood.renders.PixelArtRender;
import org.pythonsogood.renders.VectorRender;
import org.pythonsogood.shapes.Circle;
import org.pythonsogood.shapes.Square;

public class Main {
    public static void main(String[] args) {
        Render pixelArtRender = new PixelArtRender();
		Render vectorRender = new VectorRender();

		Circle pixelArtCircle = new Circle(10, 10, 5, pixelArtRender);
		pixelArtCircle.render();

		Circle vectorCircle = new Circle(10, 10, 5, vectorRender);
		vectorCircle.render();

		Square pixelArtSquare = new Square(10, 10, 5, pixelArtRender);
		pixelArtSquare.render();

		Square vectorSquare = new Square(10, 10, 5, vectorRender);
		vectorSquare.render();
    }
}