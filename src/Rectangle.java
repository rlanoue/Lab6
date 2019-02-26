
public class Rectangle extends Polygon
{
	protected static double height;
	protected static double width; 

	public Rectangle(String id, double height, double width)
	{
		super(id); 
		this.height = height;
		this.width = width; 
	}

	public double getArea()
	{
		return  height * width; 
	}

	public String getShapeType()
	{
		return "Rectangle"; 
	}
}
