package assignments.datastructure.udemy.assignment03;

public class Employee implements Comparable<Employee>{

	
	int employeeNumber;
	String firstName, lastName, emailId; 
	
	
	
	public Employee(int employeeNumber,	String firstName, String lastName,String emailId) {
		// TODO Auto-generated constructor stub
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this. emailId = emailId;
	}
	
	
	
	@Override
	public int compareTo(Employee o) {
		if(this.employeeNumber < o.employeeNumber){
			return -1;
	    }else if(this.employeeNumber > o.employeeNumber){
	    	return 1;
	    }else{
	    	return 0;
	    }
	}
	
}

