/**
 * Lab 6
 *
 * Class representing an ellipse.
 *
 * THIS CLASS IS PROVIDED TO YOU. DO NOT CHANGE IT.
 * YOU SHOULD, HOWEVER, READ THE DOCUMENTATION.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class Ellipse extends Shape
{
	/**
	 * Length of the ellipse's major (longer) axis.
	 */
	private double majorAxis;
	/**
	 * Length of the ellipse's minor (shorter) axis.
	 */
	private double minorAxis;

	/**
	 * Although super() would be called automatically, we make an
	 * explicit call to super() here. As Shape is the superclass of Circle, this calls
	 * the Shape() constructor. This means that when the Circle() constructor is called,
	 * the Shape() constructor is also called, and the Circle is assigned an id.
	 *
	 * @param id The shape's name identifier, as defined in Shape.java.
	 * @param majorAxis The major axis of the ellipse.
	 * @param minorAxis The minor axis of the ellipse.
	 */
	public Ellipse(String id, double majorAxis, double minorAxis)
	{
		super(id);
		this.majorAxis = majorAxis;
		this.minorAxis = minorAxis;
	}

	/**
	 * Get the ellipe's major axis.
	 * @return Length of the major axis.
	 */
	public double getMajorAxis()
	{
		return majorAxis;
	}

	/**
	 * Get the ellipe's minor axis.
	 * @return Length of the minor axis.
	 */
	public double getMinorAxis()
	{
		return minorAxis;
	}

	/**
	 * Calculates and returns the area of the ellipse.
	 *
	 * @return The area of the ellipse: pi * major_axis * minor_axis
	 */
	@Override
	public double getArea()
	{
		return Math.PI * majorAxis * minorAxis;
	}

	/**
	 * Calculate and return the circumference of an ellipse.
	 *
	 * Surprisingly, computation of an ellipse's circumference is actually rather complex. As such, this method
	 * uses and approximate method.
	 *
	 * One unique property of circles is that they do not share same complexity. As such, the circumference of a
	 * circle can be calculated more simply and precisely.
	 *
	 * @return The ellipse's circumference, approximated by:
	 * 2pi * sqrt((majorAxis^2 + minorAxis^2) / 2)
	 */
	@Override
	public double getPerimeter()
	{
		return 2 * Math.PI * Math.sqrt((Math.pow(majorAxis, 2) + Math.pow(minorAxis, 2)) / 2);
	}

	/**
	 * Gets the type of the shape.
	 *
	 * @return The string "Ellipse".
	 */
	@Override
	public String getShapeType()
	{
		return "Ellipse";
	}
}
