import java.util.Comparator;

/**
 * Lab 6
 *
 * Class used to define a new way to compare shapes. This gives a different ordering to shapes. The compareTo() in
 * Shape orders shapes in ascending order (comparing area then perimeter).
 *
 * When a sorting function uses this class instead of the compareTo() method in shape, the sorting function
 * will sort the list of shapes in ascending order of perimeter. The area is ignored.
 *
 * @author Stephen
 * @version 2019-02-17
 */
public class ShapePerimeterComparator implements Comparator<Shape>
{
    /**
     * Implementation of Comparator<Shape>'s compare method.
     *
     * This method should define an ordering of shapes that would sort shapes in order of increasing perimeter,
     * disregarding the area of the shapes.
     *
     * Look to the documentation in Shape's compareTo to better understand how this should work.
     *
     * @param s1 The first shape to be compared.
     * @param s2 The second shape to be compared.
     * @return -1, 0, or 1. These values are returned on the following conditions:
     *     (1) Perimeter of s1 is < perimeter of s2: return -1
     *     (2) Perimeter of s1 is > perimeter of s2: return 1
     *     (3) Perimeter of s1 = perimeter of s2:
     */
	@Override
	public int compare(Shape s1, Shape s2)
	{
		// TODO: complete this...
	}

	/**
	 * Compares two shapes to determine if they are effectively equal (same perimeter). You should use the compare()
	 * method of this class to determine this.
	 *
	 * @param s1 The first shape to be compared.
     * @param s2 The second shape to be compared.
     * @return True if the shapes are effectively equal, False if they do not.
	 */
	public boolean equals(Shape s1, Shape s2)
	{
		// TODO: complete this...
	}
}
