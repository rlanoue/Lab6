
public class Square extends Rectangle 
{
	private double size; 

	public Square(String id, double size)
	{
		super(id, height, width); 
		this.size = size; 
	}

	public String getShapeType()
	{
		return "Square"; 
	}
}
