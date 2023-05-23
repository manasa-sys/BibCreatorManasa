

public class FileInvalidException extends Exception
{
	public FileInvalidException()
	{
		
	super("Error:Input file cannot be parsed due to missing information");
	}
	
	public FileInvalidException(String msg)
	{
		
	super(msg);
	}
	public String getMessage() {
		return super.getMessage();
	}

	
}
