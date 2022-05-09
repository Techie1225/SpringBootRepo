

class ChetanException   extends Exception  
{ 
	public ChetanException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
}  
    
public class CreateException  
{
    static void validate (String username) throws ChetanException {    
       if(!username.contains("c")){  
  
        // throw an object of user defined exception  
      throw new ChetanException("username doesn't contain requred chatacter");    
    }  
       else {   
        System.out.println("welcome to the site");   
        }   
     }    
    public static void main(String args[])  
    {  
    	try {
			validate("manoj");
		} catch (ChetanException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}  
  
        System.out.println("rest of the code...");    
    }  
}  