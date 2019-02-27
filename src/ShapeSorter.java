import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class that aggregates (stores in a list) and sorts shapes.
 *
 * Sorting is done either through the natural ordering of shapes
 * or through a given comparator.
 *
 * @author Stephen
 * @version 2019-02-17
 */
public class ShapeSorter
{
	/**
	 * List of shapes to be sorted.
	 */
	protected ArrayList<Shape> shapes;

	/**
	 * Constructor. Initializes member fields - member fields are listed in the uml above the second line. 
	 */
	public ShapeSorter()
	{
		// TODO: complete this...
		shapes = new ArrayList<Shape>(); 
	}

	/**
	 * Adds a shape to the list of shapes to be sorted.
	 *
	 * @param s Shape to be added.
	 */
	public void addShape(Shape s)
	{
		// TODO: complete this...
		shapes.add(s); 
		
	}

	/**
	 * Sort the list of shapes by the default ordering (Shapes' compareTo method).
	 *
	 * It is recommended that you use Collections.sort().
	 */
	public void sortShapes()
	{
		// TODO: complete this...
		Collections.sort(shapes);
	}

	/**
	 * Sort the list of shapes by some custom ordering (a class implementing Comparator<Shape>).
	 *
	 * It is recommended that you use Collections.sort().
	 *
	 * @param comparator The shape comparing object that defines the ordering of the shapes (how to
	 * sort them).
	 */
	public void sortShapes(Comparator<Shape> comparator)
	{
		// TODO: complete this...
		Collections.sort(shapes, comparator);
	}

	/**
	 * toString override.
	 *
	 * @return The toString of all shared shapes, concatenated. toStrings are added
	 * in the order that they appear in the list.
	 */
	@Override
	public String toString()
	{
		// TODO: complete this...
		String shapeWords = ""; 
		for (int i = 0; i < shapes.size(); i++)
		{
			shapeWords+= shapes.get(i).toString();  
		}
		return shapeWords; 
	}

}
