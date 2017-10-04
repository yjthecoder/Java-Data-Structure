package testingArea;

public class SysLineSeperatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String a = "    a b   c  ";
	    String[] s = a.split(" ");
	    StringBuilder result = new StringBuilder();

        //scan from right and populate result
        for (int i = 0;i <= s.length - 1; ++i) {
            
                result.append("'"+s[i]+"'");
           
        }
	    
		System.out.println(result);
		//System.out.println("a" + System.lineSeparator().toString() + "b");
	
		
	}

}
