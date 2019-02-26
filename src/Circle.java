/**
 * Lab 6
 *
 * Class representing a circle.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class Circle extends Ellipse
{
	/**
	 * Circle constructor. A circle is a specific type of ellipse for which the
	 * major and minor axes are equivalent.
	 *
	 * The circle should pass information to the ellipse's super constructor.
	 *
	 * @param id The shape's name identifier, as defined in Shape.java.
	 * @param radius The radius of the circle.
	 */
	public Circle(String id, double radius)
	{
		// TODO: complete this...
	}

	/**
	 * Calculate and return the circumference of an circle (same as the "perimeter").
	 *
	 * Surprisingly, computation of an ellipse's circumference is actually rather complex. As such, the ellipse
	 * implementation of getPerimeter uses an approximate method.
	 *
	 * One unique property of circles is that they do not share same complexity. As such, the circumference of a
	 * circle can be calculated more simply and precisely. Thus, the circle class overwrite the getPerimeter method.
	 * This will give a result that is more accurate than the getPerimeter implemented in ellipse and that is generally
	 * simpler.
	 *
	 * getArea() is not overwritten, as the formula is equivalent and equally precise/easy for ellipses and circles.
	 *
	 * @return The circle's circumference: 2*pi*radius (radius = major axis = minor axis)
	 */
	@Override
	public double getPerimeter()
	{
		// TODO: complete this...
	}

	/**
	 * Gets the type of the shape.
	 *
	 * @return The string "Circle"
	 */
	@Override
	public String getShapeType()
	{
		// TODO: complete this...
	}
}
