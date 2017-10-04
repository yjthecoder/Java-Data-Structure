/*
 * this program tests how to use inner class
 */

package cs61bNoteCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SimpleIO {
	
	public static void main(String[] arg) throws Exception {
		
		System.out.println("Enter something: \n");
		BufferedReader keybd =
				new BufferedReader(new InputStreamReader(System.in));
		System.out.println(keybd.readLine());
		
		
		SimpleIO a= new SimpleIO();
		
		ConstructorExperiment defaultConstructor = a.new ConstructorExperiment();
		defaultConstructor.saySomething();
		ConstructorExperiment constructorWithAge = a.new ConstructorExperiment(123);
		constructorWithAge.saySomething();
		ConstructorExperiment constructorWithName = a.new ConstructorExperiment("asdf");
		constructorWithName.saySomething();
		
		
		
	}
 
 
	ConstructorExperiment xxx = new ConstructorExperiment();
	
	class ConstructorExperiment{
		StringBuilder name;
		int age;
		public ConstructorExperiment() {
			age = 0;
			name = new StringBuilder("blank");
		}
		
		public ConstructorExperiment(int age){
			this.age = age;
		}
		public ConstructorExperiment(String name){
			this.name = new StringBuilder(name);	
		}
		
		
		public void saySomething(){
			System.out.println("Name: "+name+'\n'+"Age: "+age+"\n");
		}
		
	}

 
}

