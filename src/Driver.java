/**
 * Lab 6
 *
 * Driver class that creates some shapes and demonstrates how sorting is accomplished
 * through use of the defined natural ordering of shapes (compareTo in Shape) and
 * an alternate order (compare in ShapeAreaComparator/ShapePerimeterComparator).
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class Driver
{
    /**
     * Method used to do high-level testing of your code. You may alter this as you see fit.
     * @param args Program args.
     */
	public static void main(String[] args)
	{
		ShapeSorter sorter = new ShapeSorter();

		// Create several shapes:
		Shape s1 = new Square("A", 4.0);
		Shape s2 = new Rectangle("B", 4.0, 1.0);
		Shape s3 = new Rectangle("C", 3.0, 4.0);
		Shape s4 = new Rectangle("D", 16.0, 1.0);
		Shape s5 = new Rectangle("A", 8.0, 2.0);

		// Add all to sorter:
		sorter.addShape(s1);
		sorter.addShape(s2);
		sorter.addShape(s4);
		sorter.addShape(s3);
		sorter.addShape(s5);

		// Print unsorted:
		System.out.println("###");
		System.out.println(sorter);

		// Sort by default sorting (Shape's compareTo):
		sorter.sortShapes();
		System.out.println("###");
		System.out.println(sorter);

		// Sort by area and print:
		sorter.sortShapes(new ShapeAreaComparator());
		System.out.println("###");
		System.out.println(sorter);

		// Sort by perimeter and print:
		sorter.sortShapes(new ShapePerimeterComparator());
		System.out.println("###");
		System.out.println(sorter);
	}
}