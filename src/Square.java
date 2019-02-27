
public class Square extends Rectangle 
{
	public Square(String id, double size)
	{
		super(id, size, size);
	}

	public String getShapeType()
	{
		return "Square"; 
	}
}
