import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class To_Do_Checker
{
    private final static String TODO_FILENAME = "Todo.java";
    
    private final static int[] VALID_SECTIONS = {11, 12, 13, 14};
    
    private final static int VALID_ID_LENGTH = 9;
    
    // Lightweight date checker:
    private final static String VALID_DATE_REGEX = "20[0-9][0-9]-[0-1][0-9]-[0-3][0-9]";
    private final static String VALID_DATE_FORMAT_INFO = "YYYY-MM-DD";
    
    private final static String VALID_EMAIL_SUFFIX = "@ou.edu";
    
    /**
     * Number of characters at the start of each metadata line (section, id, date, email)
     */
    private final static int LINE_HEADER_LENGTH = 21;
    
    public static void main(String[] args)
    {
    	String error = "";
        boolean valid = true;
        
        try (FileInputStream fs = new FileInputStream(new File(TODO_FILENAME));
             BufferedReader br = new BufferedReader(new InputStreamReader(fs)))
        {
            // Read in the file text:
            String nextLine = br.readLine();
            nextLine = br.readLine(); // Skip first line...
            
            // Check lab section:
            String sectionPortion = nextLine.substring(LINE_HEADER_LENGTH).trim();
            try {
            	int section = Integer.parseInt(sectionPortion);
                if (Arrays.binarySearch(VALID_SECTIONS, section) < 0)  // Invalid section number.
                {
                	error += String.format("Invalid section number %d. Valid section numbers are: %s\n", 
                			section, Arrays.toString(VALID_SECTIONS));
                    valid = false;
                }
            }
            catch (NumberFormatException e)
            {
            	error += "First line does not contain integer section number.\n";
            	valid = false;
            }
            
            // Check last modified:
            nextLine = br.readLine();
            String lastModified = nextLine.substring(LINE_HEADER_LENGTH).trim();
            String[] splitDate = lastModified.split(VALID_DATE_REGEX);
            if (splitDate.length != 0)  // Invalid last date modified.
            {
            	error += String.format("Invalid date format for last modified %s. Be sure that the"
                        + "format matches %s\n", lastModified, VALID_DATE_FORMAT_INFO);
                valid = false;
            }
            
            // Check OU ID:
            nextLine = br.readLine();
            String idPortion = nextLine.substring(LINE_HEADER_LENGTH).trim();
            try {
	            int id = Integer.parseInt(idPortion);
	            // ID should not have any leading zeros.
	            if (String.format("%d", id).length() != VALID_ID_LENGTH)  // Invalid OU ID length.
	            {
	            	error += String.format("Invalid OU ID %d. OU IDs must be %d digits long.\n", 
	                        id, VALID_ID_LENGTH);
	                valid = false;
	            }
            }
            catch (NumberFormatException e)
            {
            	error += "Third line does not contain integer ou id number.\n";
            	valid = false;
            }
            
            // Check Email:
            nextLine = br.readLine();
            String email = nextLine.substring(LINE_HEADER_LENGTH).trim();
            if (!email.endsWith(VALID_EMAIL_SUFFIX))
            {
            	error += String.format("Invalid email %s. Make sure that your email ends with %s\n",
                        email, VALID_EMAIL_SUFFIX);
                valid = false;
            }
            
            // Skip over empty lines:
            nextLine = br.readLine();
            while(nextLine.equals(""))
            {
            	nextLine = br.readLine();
            }
            nextLine = br.readLine();  // Skip over "Tasks:"
            
            // Check the tasks:
            int numTasks = 0;
            if (valid)  // Don't assess tasks if file is already incorrect...
            {
	            boolean done = false;
	            while(!done && valid)
	            {
	            	String[] parts = nextLine.split("\\.", 2);
	            	try {
	            		int task = Integer.parseInt(parts[0].trim());
	            		if (task != numTasks + 1)
	            		{
	            			error += String.format("The task line \"%s\" is invalid. Tasks numbers must increase by 1, "
	        					+ "starting from 1, e.g.\n"
		        				+ "1. Task 1\n"
		        				+ "2. Task 2\n"
		        				+ "3. Task 3\n",
		        				nextLine);
	            			valid = false;
	            		}
	            		numTasks++;
	            	}
	            	catch (NumberFormatException e)
	            	{
	            		error += String.format("The task line \"%s\" is invalid. Make sure that all tasks start with "
	            				+ "a number and a period. e.g.\n"
	            				+ "1. Task 1\n"
	            				+ "2. Task 2\n"
	            				+ "3. Task 3\n"
	            				+ "and so on.\n"
	            				+ "Make sure that the tasks are on consecutive lines with no empty lines between them.\n",
	                            nextLine);
	                    valid = false;
	            	}
	            	catch (ArrayIndexOutOfBoundsException e)
	            	{
	            		error += String.format("The task line \"%s\" is invalid. Make sure that all tasks start with "
	            				+ "a number and a period. e.g.\n"
	            				+ "1. Task 1\n"
	            				+ "2. Task 2\n"
	            				+ "3. Task 3\n"
	            				+ "and so on.\n"
	            				+ "Make sure that the tasks are on consecutive lines with no empty lines between them.\n",
	                            nextLine);
	                    valid = false;
	            	}
	            	
	            	nextLine = br.readLine();
	            	if (nextLine.equals("") || nextLine.startsWith("Estimated:"))
	            	{
	            		done = true;
	            	}
	            }
            }
            
            // Skip over empty lines:
            nextLine = br.readLine();
            while(nextLine.equals(""))
            {
            	nextLine = br.readLine();
            }
            nextLine = br.readLine();  // Skip over "Estimated:"
            
            // Check the estimated times:
            if (valid)
            {
            	int numEstimates = 0;
	            boolean done = false;
	            while(!done && valid)
	            {
	            	String[] parts = nextLine.split("\\.", 2);
	            	try {
	            		int est = Integer.parseInt(parts[0].trim());
	            		if (est != numEstimates + 1)
	            		{
	            			error += String.format("The estimate line \"%s\" is invalid."
	            				+ "Estimate numbers must increase by 1, starting from 1, e.g.\n"
		        				+ "1. 20\n"
		        				+ "2. 40\n"
		        				+ "3. 60\n",
		        				nextLine);
	            			valid = false;
	            		}
	            		int val = Integer.parseInt(parts[1].trim());
	            		if (val <= 0)
	            		{
	            			error += String.format("The estimate line \"%s\" is invalid. "
            					+ "Make sure that the estimated time is a positive (>0) integer value.\n",
	                            nextLine);
		                    valid = false;
	            		}
	            		numEstimates++;
	            	}
	            	catch (NumberFormatException e)
	            	{
	            		error += String.format("The estimate line \"%s\" is invalid. Make sure that all estimate start with "
	            				+ "a number and a period. e.g.\n"
		        				+ "1. 20\n"
		        				+ "2. 40\n"
		        				+ "3. 60\n"
	            				+ "and so on.\n"
	            				+ "Make sure that the estimate are on consecutive lines with no empty lines between them.\n"
	            				+ "Make sure that the estimated time is a positive (>0) integer value.\n",
	                            nextLine);
	                    valid = false;
	            	}
	            	catch (ArrayIndexOutOfBoundsException e)
	            	{
	            		error += String.format("The estimate line \"%s\" is invalid. Make sure that all estimate start with "
	            				+ "a number and a period. e.g.\n"
		        				+ "1. 20\n"
		        				+ "2. 40\n"
		        				+ "3. 60\n"
	            				+ "and so on.\n"
	            				+ "Make sure that the estimate are on consecutive lines with no empty lines between them.\n",
	                            nextLine);
	                    valid = false;
	            	}
	            	
	            	nextLine = br.readLine();
	            	if (nextLine.equals("") || nextLine.startsWith("Actual:"))
	            	{
	            		done = true;
	            	}
	            }
	            if (valid)
	            {
		            if (numEstimates != numTasks)
		            {
		            	error += String.format("Number of estimates (%d) does not match number of tasks (%d).\n"
		            			+ "Make sure that there are no empty line between tasks and between estimates.",
		            			numEstimates, numTasks);
	                    valid = false;
		            }
	            }
            }
            
            // Skip over empty lines:
            nextLine = br.readLine();
            while(nextLine.equals(""))
            {
            	nextLine = br.readLine();
            }
            nextLine = br.readLine();  // Skip over "Actual:"
            
            // Check the actual times:
            if (valid)
            {
            	int numActual = 0;
	            boolean done = false;
	            while(!done && valid)
	            {
	            	String[] parts = nextLine.split("\\.", 2);
	            	try {
	            		int act = Integer.parseInt(parts[0].trim());
	            		if (act != numActual + 1)
	            		{
	            			error += String.format("The actual time line \"%s\" is invalid."
	            				+ "Actual time numbers must increase by 1, starting from 1, e.g.\n"
		        				+ "1. 20\n"
		        				+ "2. 40\n"
		        				+ "3. 60\n",
		        				nextLine);
	            			valid = false;
	            		}
	            		int val = Integer.parseInt(parts[1].trim());
	            		if (val <= 0)
	            		{
	            			error += String.format("The actual time line \"%s\" is invalid. "
            					+ "Make sure that the actual time is a positive (>0) integer value.\n",
	                            nextLine);
		                    valid = false;
	            		}
	            		numActual++;
	            	}
	            	catch (NumberFormatException e)
	            	{
	            		error += String.format("The actual time \"%s\" is invalid. Make sure that all actual times start with "
	            				+ "a number and a period. e.g.\n"
		        				+ "1. 20\n"
		        				+ "2. 40\n"
		        				+ "3. 60\n"
	            				+ "and so on.\n"
	            				+ "Make sure that the actual times are on consecutive lines with no empty lines between them.\n"
	            				+ "Make sure that the actual time is a positive (>0) integer value.\n",
	                            nextLine);
	                    valid = false;
	            	}
	            	catch (ArrayIndexOutOfBoundsException e)
	            	{
	            		error += String.format("The actual time line \"%s\" is invalid. Make sure that all actual times start with "
	            				+ "a number and a period. e.g.\n"
		        				+ "1. 20\n"
		        				+ "2. 40\n"
		        				+ "3. 60\n"
	            				+ "and so on.\n"
	            				+ "Make sure that the actual times are on consecutive lines with no empty lines between them.\n",
	                            nextLine);
	                    valid = false;
	            	}
	            	
	            	nextLine = br.readLine();
	            	if (nextLine == null || nextLine.equals("") || nextLine.startsWith("*/"))
	            	{
	            		done = true;
	            	}
	            }
	            if (valid)
	            {
		            if (numActual != numTasks)
		            {
		            	error += String.format("Number of actuals (%d) does not match number of tasks (%d).\n"
		            			+ "Make sure that there are no empty line between tasks and between actuals.",
		            			numActual, numTasks);
	                    valid = false;
		            }
	            }
            }
        }
        catch (FileNotFoundException e) {
        	error += String.format("File %s not found! Make sure that your %s file is not in the src folder"
                    + "but is at the project level. Make sure that the extension is .json\n",
                    TODO_FILENAME, TODO_FILENAME);
            valid = false;
        } catch (IOException e) {
        	error += "Error while reading file! Try running the program again. The error is as below:\n";
            e.printStackTrace();
            valid = false;
        }
        
        // Output valid if successful:
        if (valid)
        {
            System.out.println(String.format("%s sucessfully validated!", TODO_FILENAME));
        }
        else
        {
            System.out.println(String.format("Validation on %s failed! Review the below errors "
            		+ "to resolve your issues:\n%s", TODO_FILENAME, error));
        }
    }
}
