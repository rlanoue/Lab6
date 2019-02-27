import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
	/**
	 * Tests for the square class.
	 */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
	 * Tests for the rectangle class.
	 */
	@Test
	public void RectangleTest()
	{
		// TODO: complete this...
		Shape rec = new Rectangle("Rectangle1", 3.0, 4.0);
		Assert.assertEquals("Rectangle area incorrect.", 12.0, rec.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.", 14.0, rec.getPerimeter(), 0.0001);
		Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rec.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Rectangle1", rec.getId());
	}

	/**
	 * Tests for the EquilateralTriangle class.
	 */
	@Test
	public void TriangleTest()
	{
		// TODO: complete this...
		Shape eqt= new EquilateralTriangle("EqTri1", 5.0);
		Assert.assertEquals("Equilateral Triangle area incorrect.", 10.8253, eqt.getArea(), 0.0001);
		Assert.assertEquals("Equilateral Triangle perimeter incorrect.", 15, eqt.getPerimeter(), 0.0001);
		Assert.assertEquals("Equilateral Trianlge type incorrect.", "Equilateral Triangle", eqt.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "EqTri1", eqt.getId()); 
	}

	/**
	 * Tests for the trapezoid class. Also test that IDs are done correctly.
	 */
	@Test
	public void TrapezoidTest()
	{
		// TODO: complete this...
		Shape trap = new Trapezoid("Trap1", 6.0, 6.0, 7.0, 6.0);
		Assert.assertEquals("Trapezoid area incorrect", 38.8643, trap.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect", 25, trap.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", trap.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Trap1", trap.getId()); 

	}

	/**
	 * Tests for the ellipse class. Also test that IDs are done correctly.
	 */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
	 * Tests for the circle class. Also test that IDs are done correctly.
	 */
	@Test
	public void CircleTest()
	{
		// TODO: complete this...
		Shape circ = new Circle("Ellipse3", 3.0);
		Assert.assertEquals("Circle area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Circle perimeter incorrect.",
				2 * Math.PI * 3.0,
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse3", circ.getId());

		Shape circ2 = new Circle("Ellipse4", 5.0);
		Assert.assertEquals("Circle area incorrect.", Math.PI*5.0*5.0, circ2.getArea(),0.0001);
		Assert.assertEquals("Circle perimeter incorrect.",
				2 * Math.PI * 5.0,
				circ2.getPerimeter(),0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle",circ2.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse4", circ2.getId());
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		// TODO: complete this...
		Shape rect = new Rectangle("R8", 3.0, 3.0);
		Assert.assertEquals(rect.toString(), "Rectangle:\t ID = R8\t area = 9.000\t perimeter = 12.000");  
	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
	 * Tests for the Shape Area Comparator class.
	 */
	@Test
	public void CompareAreaTest()
	{
		// Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
		Shape rect2 = new Rectangle("R2", 1.0, 9.0);
		Shape sqr2 = new Square("S2", 5.0);
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
		Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

		// Test unequal perimeter and area:
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
		Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
	 * Tests for the Shape Perimeter Comparator class.
	 */
	@Test
	public void ComparePerimeterTest()
	{
		// TODO: complete this...
		//Equal Perimeters
		Shape rect = new Rectangle("R3", 7.0,7.0);
		Shape sqr = new Square("S3", 7.0);
		ShapePerimeterComparator sc = new ShapePerimeterComparator();
		Assert.assertEquals("ShapePerimeterComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal.", sc.equals(rect, sqr));

		//Unequal Perimeters
		Shape rect2 = new Rectangle("R4", 9.0,4.0);
		Shape sqr2 = new Square("S4", 8.0);
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
		Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect2));

	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
	public void NaturalCompareTest()
	{
		// TODO: complete this...
		Shape rect = new Rectangle("R5", 6.0, 6.0); 
		Shape rect2 = new Rectangle("R6", 6.0, 6.0); 
		Shape rect3 = new Rectangle("R7", 7.0, 7.0); 
		Shape rect4 = new Rectangle("R9", 1.0, 36.0);

		Assert.assertEquals("NaturalCompare gave incorrect ordering.", 1, rect3.compareTo(rect)); 
		Assert.assertEquals("NaturalCompare gave incorrect ordering.", -1, rect.compareTo(rect3)); 
		
		Assert.assertEquals("NaturalCompare find shapes equal.", 0, rect.compareTo(rect2));
		
		Assert.assertEquals("NaturalCompare gave incorrect ordering.", 1, rect4.compareTo(rect));
		Assert.assertEquals("NaturalCompare gave incorrect ordering.", -1, rect.compareTo(rect4));
	
	}
}
