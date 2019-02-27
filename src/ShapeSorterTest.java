import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter.
 * Implicitly tests that the comparators are implemented correctly.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeSorterTest
{
	/**
	 * Test that shapes are added correctly.
	 */
	@Test
	public void AddShapeTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests sorting via the default ordering.
	 */
	@Test
	public void SortShapesDefaultTest()
	{
		// TODO: complete this...
		
		ShapeSorter sorter = new ShapeSorter();
		
		Shape a = new Rectangle("test", 2, 2);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 8);
		Shape d = new Circle("test4", 11.5);
		
		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		sorter.sortShapes();
		
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);

		
	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();
		ShapeAreaComparator areaCompare = new ShapeAreaComparator(); 
		
		Shape a = new Rectangle("test", 2, 3);
		Shape b = new EquilateralTriangle("test2", 5);
		Shape c = new Square("test3", 11);
		Shape d = new Circle("test4", 41);
		
		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		sorter.sortShapes(areaCompare);
		
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	
	}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();
		ShapePerimeterComparator perimeterCompare = new ShapePerimeterComparator(); 
		
		Shape a = new Square("test", 1);
		Shape b = new EquilateralTriangle("test2", 2);
		Shape c = new Square("test3", 4);
		Shape d = new Ellipse("test4", 7, 8);
		
		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		sorter.sortShapes(perimeterCompare);
		
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests the toString.
	 */
	@Test
	public void ToStringTest()
	{
		// TODO: complete this...
		ShapeSorter sorter = new ShapeSorter();
	
		Shape c = new Square("test3", 3);
		Shape d = new Rectangle("test4", 2, 2);
	
		sorter.addShape(c);
		sorter.addShape(d);
		Assert.assertEquals("Square:\t ID = test3\t area = 9.000\t perimeter = 12.000Rectangle:\t ID = test4\t area = 4.000\t perimeter = 8.000",
				sorter.toString());
		
		//Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d)
//		Assert.assertEquals(sorter.shapes, rect); 
}
}