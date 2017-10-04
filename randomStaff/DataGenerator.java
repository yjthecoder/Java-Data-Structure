package randomStaff;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

/**
 * Generate different kind of dummy data by commenting out the specific functions
 */
public class DataGenerator {
    public static BufferedReader bufread;
    //specify the path of the txt file
    private static String path = "/Users/yuanji/Desktop/SQLOUTPUT/output.txt";
    private static  File file = new File(path);

    /**
     * write to file
     * 
     */
    public static void writeTxtFile(String newStr) throws IOException{
        
        FileWriter fileWritter = new FileWriter(file,true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        try {
            
	        bufferWritter.write(newStr + '\n');
	        
        } catch (IOException e1) {
            
            e1.printStackTrace();
        } finally {
            if (bufferWritter != null) {
                try {
                	bufferWritter.close();
                    System.out.println("Done");
                 
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
    
    
    
    public static void main(String[] s) throws IOException {
    	//toggle comment to generate desired data
    	
    	
    	
    	//CustomerGenerator();    	
    	
    	
    	//CategoryGenerator();
    	
    	
    	//SubCategoryGenerator();
    	
    	
    	//ProductGenerator();

    	
    	//FocusingGenerator();
    	    	
    	
    	//WishListItemGenerator();
    	
    	//ShoppingCartItemGenerator();
    	
    	
    	
    	//ReceiptGenerator();
    	
    	//PurchaseRecordGenerator();
    	
    	ReviewGenerator();
    	
    	
  
        
        
    }
    
    static void CustomerGenerator() throws IOException{
    	System.out.print("Please enter the number of Customer data that you want to generate: ");
        Scanner sc = new Scanner(System.in);
        int numOfRecords = sc.nextInt();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();  
		String currentDateTime = dateFormat.format(cal.getTime());
        
        for (int i=0; i<numOfRecords; i++){
        	
        	currentDateTime = dateFormat.format(cal.getTime());
        	StringBuffer fNameBuffer = new StringBuffer();
        	StringBuffer lNameBuffer = new StringBuffer();
        	StringBuffer emailBuffer = new StringBuffer();

        	

        	//three loops to ensure different string values for each field
        	//A fixed size for each string
        	for (int j = 0; j < 12; j++) {  
                int num = random.nextInt(52);  
                fNameBuffer.append(str.charAt(num));
                
            }
        	
        	for (int j = 0; j < 12; j++) {  
                int num = random.nextInt(52);  
                lNameBuffer.append(str.charAt(num));

            }
        	
        	for (int j = 0; j < 12; j++) {  
                int num = random.nextInt(52);  
                emailBuffer.append(str.charAt(num));

            }
        	
        	
        	//
            
        	
        	//Generate Customer data output
        	String output = "INSERT INTO Customer VALUES ( null, null,"
        					+"\'FName:"+fNameBuffer.toString()+"\'," 
        					+"\'LName:"+lNameBuffer.toString()+"\',"
        					+"\'Email:"+emailBuffer.toString()+"\'"
        					+");";
        	
        	writeTxtFile(output);
        }
        sc.close();
    }
    
    
    
    static void CategoryGenerator() throws IOException{
    	System.out.print("Please enter the number of Category data that you want to generate: ");
        Scanner sc = new Scanner(System.in);
        int numOfRecords = sc.nextInt();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        
        for (int i=0; i<numOfRecords; i++){
        	
        	StringBuffer categoryNameBuffer = new StringBuffer();
        	   	      	
        	//A fixed size for each string
        	for (int j = 0; j < 6; j++) {  
                int num = random.nextInt(52);  
                categoryNameBuffer.append(str.charAt(num));
            }  
        	
        	//Generate Customer data output
        	String output = "INSERT INTO Category VALUES ( null,"
        					+"\'Category Name:"+categoryNameBuffer.toString()+"\'" 
        					+");";
        	
        	writeTxtFile(output);
        }
        sc.close();
        
    }
    
    
    static void SubCategoryGenerator() throws IOException{
    	System.out.print("Please enter the number of SubCategory data that you want to generate: ");
        Scanner sc = new Scanner(System.in);
        int numOfRecords = sc.nextInt();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        
        for (int i=0; i<numOfRecords; i++){
        	
        	StringBuffer subCategoryNameBuffer = new StringBuffer();
        	int categoryNo = 1+ random.nextInt(104);

        	
        	//A fixed size for each string
        	for (int j = 0; j < 3; j++) {  
                int num = random.nextInt(52);  
                subCategoryNameBuffer.append(str.charAt(num));


            }  
        	
        	//
            
        	
        	//Generate Customer data output
        	String output = "INSERT INTO SubCategory VALUES ( null,"
        					+"\'SubCategory Name:"+subCategoryNameBuffer.toString()+"\'," 
        					+categoryNo
        					+");";
        	
        	writeTxtFile(output);
        }
        sc.close();
        
    }
    
    
    static void ProductGenerator() throws IOException{
    	System.out.print("Please enter the number of Product data that you want to generate: ");
        Scanner sc = new Scanner(System.in);
        int numOfRecords = sc.nextInt();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String currentDateString = localDate.toString();
        
        for (int i=0; i<numOfRecords; i++){
        	
        	StringBuffer productNameBuffer = new StringBuffer();

        	double price = random.nextInt(20000)/10.00 + 0.99;
        	int quantity = random.nextInt(2000);
        	int subCategoryNo = 1+random.nextInt(499);   	
        	
        	
        	//A fixed size for each string
        	for (int j = 0; j < 7; j++) {  
                int num = random.nextInt(52);  
                productNameBuffer.append(str.charAt(num));
            }  
        	
        	//
            
        	
        	//Generate Customer data output
        	String output = "INSERT INTO Product VALUES ( null, null,"
        					+"\'Product Name:"+productNameBuffer.toString()+"\'," 
        					+price+","
        					+quantity+","
        					+subCategoryNo
        					+");";
        	
        	writeTxtFile(output);
        }
        sc.close();
    }
   
    
    static void FocusedSubCategoryGenerator() throws IOException{
    	
    	System.out.print("Please enter the number of FocusedSubCategory data that you want to generate: ");
        Scanner sc = new Scanner(System.in);
        int numOfRecords = sc.nextInt();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        
        for (int i=0; i<numOfRecords; i++){
        	
        	StringBuffer fsubCategoryNameBuffer = new StringBuffer();
        	
        	int subCategoryNo = 4+ random.nextInt(505);

        	
        	//A fixed size for each string
        	for (int j = 0; j < 3; j++) {  
                int num = random.nextInt(52);  
                fsubCategoryNameBuffer.append(str.charAt(num));


            }  
        	
        	
        	//Generate Customer data output
        	String output = "INSERT INTO FocusedSubCategory VALUES ("
        					+"\'SubCategory Name:"+fsubCategoryNameBuffer.toString()+"\'," 
        					+subCategoryNo
        					+");";
        	
        	writeTxtFile(output);
        }
        sc.close();
        
    }
    
    static void FocusingGenerator() throws IOException{
    	System.out.print("Please enter the number of Focusing data that you want to generate: ");
        Scanner sc = new Scanner(System.in);
        int numOfRecords = sc.nextInt();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        

        
        for (int i=0; i<numOfRecords; i++){
        	
        	
        	int subCategoryNo = 1+random.nextInt(50);   	
        	int customerNo = 1+ random.nextInt(500);
        	
            
        	
        	//Generate Customer data output
        	String output = "INSERT INTO Focusing VALUES ("
        					+"null,"
        					+subCategoryNo+","
        					+customerNo
        					+");";
        	
        	writeTxtFile(output);
        }
        sc.close();   
    }
    
    static void WishListItemGenerator() throws IOException{
    	System.out.print("Please enter the number of WishListItem data that you want to generate: ");
        Scanner sc = new Scanner(System.in);
        int numOfRecords = sc.nextInt();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String currentDateString = localDate.toString();
        
        for (int i=0; i<numOfRecords; i++){
        	
        	
        	
        	int customerNo = 1+ random.nextInt(500);
        	int productNo = 1+random.nextInt(100);   	
        	
            
        	
        	//Generate Customer data output
        	String output = "INSERT INTO WishlistItem VALUES ("
        					+"null,"
        					+customerNo+","
        					+productNo
        					+");";
        	
        	writeTxtFile(output);
        }
        sc.close();   
    }
    
    
    
    
    static void ShoppingCartItemGenerator() throws IOException{
    	System.out.print("Please enter the number of ShoppingCartItem data that you want to generate: ");
        Scanner sc = new Scanner(System.in);
        int numOfRecords = sc.nextInt();
        Random random = new Random();
        
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String currentDateString = localDate.toString();
        
        for (int i=0; i<numOfRecords; i++){
        	
        	
        	   	
        	int amountToBuy = 1+ random.nextInt(100);
        	int customerNo = 1+ random.nextInt(500);
        	int productNo = 1+random.nextInt(100);   
            
        	
        	//Generate Customer data output
        	String output = "INSERT INTO ShoppingCartItem VALUES (null,"
        					+amountToBuy+","
        					+customerNo+","
        					+productNo
        					+");";
        	
        	writeTxtFile(output);
        }
        sc.close();   

    }
    
    
    
    static void ReceiptGenerator() throws IOException{
    	System.out.print("Please enter the number of Receipt data that you want to generate: ");
        Scanner sc = new Scanner(System.in);
        int numOfRecords = sc.nextInt();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String currentDateString = localDate.toString();
        
        for (int i=0; i<numOfRecords; i++){
        	
        	
        	
        	int customerNo = 1+ random.nextInt(300);
        	        	
                    	
        	//Generate Customer data output
        	String output = "INSERT INTO Receipt VALUES ("
        					+"null,"
        					+"null,"
        					+customerNo
        					+");";
        	
        	writeTxtFile(output);
        }
        sc.close();   
    }
    
    
    static void PurchaseRecordGenerator() throws IOException{
    	System.out.print("Please enter the number of PurchaseRecord data that you want to generate: ");
        Scanner sc = new Scanner(System.in);
        int numOfRecords = sc.nextInt();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String currentDateString = localDate.toString();
        
        for (int i=0; i<numOfRecords; i++){
        	
        	
        	int quantityBought =  1+random.nextInt(100);
        	int productNo = 1+random.nextInt(200);
        	int receiptNo = 1+random.nextInt(100);
        	        	
                    	
        	//Generate Customer data output
        	String output = "INSERT INTO PurchaseRecord VALUES ("
        					+quantityBought+","
        					+productNo+","
        					+receiptNo
        					
        					+");";
        	
        	writeTxtFile(output);
        }
        sc.close();   
    }
    
    
    static void ReviewGenerator() throws IOException{
    	
    	System.out.print("Please enter the number of Review data that you want to generate: ");
        Scanner sc = new Scanner(System.in);
        int numOfRecords = sc.nextInt();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        
        for (int i=0; i<numOfRecords; i++){
        	
        	StringBuffer reviewContentTextBuffer = new StringBuffer();
        	
        	int productNo = 1+ random.nextInt(100);
        	int receiptNo = 1+ random.nextInt(100);
        	
        	//A fixed size for each string
        	for (int j = 0; j < 3; j++) {  
                int num = random.nextInt(52);  
                reviewContentTextBuffer.append(str.charAt(num));


            }  
        	
        	
        	//Generate Customer data output
        	String output = "INSERT INTO Review VALUES (null, "
        					+"\'Review Text:"+reviewContentTextBuffer.toString()+"\'," 
        					+productNo+","
        					+receiptNo
        					+");";
        	
        	writeTxtFile(output);
        }
        sc.close();
        
    }
       
       
}
