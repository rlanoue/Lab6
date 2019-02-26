/**
 * Class to represent a trapezoid, a type of Polygon.
 *
 * Specifically, defines a quadrilateral with exactly one pair of parallel sides. This is important to being
 * able to consistently define an area function, as explained here:
 * https://math.stackexchange.com/questions/2637690/is-there-a-formula-to-calculate-the-area-of-a-trapezoid-knowing-the-length-of-al?rq=1
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class Trapezoid extends Polygon
{
	/**
	 * The variables storing the lengths of the left/right sides of the trapezoid and the lengths of the
	 * top/bottom bases.
	 */
	private double leftSide, rightSide, topBase, bottomBase;

	/**
     * The rectangle constructor. Store the side and base information and store in the sideLengths array.
     *
     * @param id The created shape's name id.
     * @param leftSide The left side (not parallel) of the trapezoid.
     * @param rightSide The right side (not parallel) of the trapezoid.
     * @param topBase The top base (parallel to the bottom base) of the trapezoid.
     * @param bottomBase The bottom base (pallel to the top base) of the trapezoid.
     */
	public Trapezoid(String id, double leftSide, double rightSide, double topBase, double bottomBase)
	{
		// TODO: complete this...
		super(id); 
		this.leftSide = leftSide; 
		this.rightSide = rightSide; 
		this.topBase = topBase; 
		this.bottomBase = bottomBase; 
		
	}

	/**
	 * Calculates and returns the area of the trapezoid.
	 *
	 * Formula as obtained from:
	 * https://math.stackexchange.com/questions/2637690/is-there-a-formula-to-calculate-the-area-of-a-trapezoid-knowing-the-length-of-al?rq=1
	 *
	 * @return Area of the trapezoid.
	 */
	@Override
	public double getArea()
	{
		// Use shorter variables names for sake of simplicty:
		double a = this.bottomBase;
		double b = this.topBase;
		double c = this.leftSide;
		double d = this.rightSide;

		// Use intermediate variables:
		double e = (a + b) / 2;
		double f = Math.pow(b - a, 2) + Math.pow(c, 2) - Math.pow(d, 2);
		double g = 2 * c * (b - a);

		// Calculate:
		return e * c * Math.sqrt(1 - Math.pow(f/g, 2));
	}

	/**
	 * Gets the type of the shape.
	 *
	 * @return The string "Trapezoid"
	 */
	@Override
	public String getShapeType()
	{
		// TODO: complete this...
		return "Trapezoid"; 
	}

}
