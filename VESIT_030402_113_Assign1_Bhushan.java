import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;



import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VESIT_030402_113_Assign1_Bhushan {

	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VESIT_030402_113_Assign1_Bhushan.xlsx";     //Location where excel file is getting generated
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Instruction");      //Generating first sheet as Instruction
		
		XSSFSheet sheet1 = workbook.createSheet("Questions");       //Generating second sheet as Questions
		
		//Adding first row in second sheet(Questions)
		String[] header = {"Sr. No","Question Type","Answer Type","Topic Number","Question (Text Only)","Correct Answer 1","Correct Answer 2",
				"Correct Answer 3","Correct Answer 4","Wrong Answer 1","Wrong Answer 2","Wrong Answer 3","Time in seconds","Difficulty Level",
				"Question (Image/ Audio/ Video)","Contributor's Registered mailId","Solution (Text Only)","Solution (Image/ Audio/ Video)","Variation Number"};
		XSSFRow rowhead = sheet1.createRow(0);	
		
		//Set height and width to the column and row
		   sheet1.setColumnWidth(4, 35*250);
		   sheet1.setColumnWidth(16, 45*250);
	
	 	//Adding header to the second sheet
		for(int head=0; head<header.length; head++) {
			rowhead.createCell(head).setCellValue(header[head]);
		    
		}
		
		   
			 int mapsize,mapsizeafter;
			 HashMap<String, Integer> map = new HashMap<String, Integer> ();
		
			 for(int i =1;i<201;i++) {
			// Create row
			
	  	     XSSFRow row = sheet1.createRow(i);
	  	     row.createCell(0).setCellValue(i); 
	  	     row.createCell(1).setCellValue("Text"); 
	  	     row.createCell(2).setCellValue(1);
	  	     row.createCell(3).setCellValue("030402");

	String [] wrongSolEng={"Monomial","Binomial","Quadractic","An identity","Nothing can be said","None of the above"};
	String [] wrongSolMar={"एकपदी","द्विपदी","वर्ग समीकरण","नित्य समीकरण","सांगता येत नाही","दिलेल्या पैकी कोणतेच नाही"};
	    
	  	     // Generate random number to perform the operation
	  	    
	  	   
			int a=(int)(Math.random()*6);
			int b=(int)(Math.random()*6);
			int c=(int)(Math.random()*6);
			int d=(int)(Math.random()*3);
           boolean k=true;
			while(k)
			{
			 a=(int)(Math.random()*6);
			 b=(int)(Math.random()*6);
			 c=(int)(Math.random()*6);
			
			if(a!=b && a!=c  && b!=c )
			{
				k=false;
			}
			}
           
		//Above code will generate unique random numbers means different values for a,b,c non of them is same for single question

           String Correct_ans=""+"Trinomial"+"<br> #"+"त्रिपदी"+"<br>";
			 
			 
			 String wrong_ans=""+wrongSolEng[a]+"<br> #"+wrongSolMar[a]+"<br>" ;

			 
			 String wrong_ans1=""+wrongSolEng[b]+"<br> #"+wrongSolMar[b]+"<br>";

			 
			 String wrong_ans2=""+wrongSolEng[c]+"<br> #"+wrongSolMar[c]+"<br>";

			 String wrong_ans3=""+d+""+wrong_ans+""+wrong_ans1+""+wrong_ans2+"";   //This is used for checking purpose (Duplicacy Checking ) in map.put()


			 // For selecting 1 question out of 3 
			 switch (d) {
				case 0:
				String  Que = "If an algebraic expression has three terms, then it is called as ________<br>";
				//Generate question marathi
				String Que1 = "#बैजिक राशीमध्ये जर तीन  पदे असतील तर त्याला________ म्हणतात.<br>";

				String Question =""+Que+" "+Que1+"";
				row.createCell(4).setCellValue(Question);
					break;

			  case 1:
			  String  Que2 = "Algebraic expression with three  terms is called as ________<br>";
			  //Generate question marathi
			  String Que3 ="# तीन  पदे असलेल्या बैजिक राशीला________म्हणतात.<br>";
			  String Question1 =""+Que2+" "+Que3+"";
			  row.createCell(4).setCellValue(Question1);
			  break;
			  
			  case 2:
			  String  Que4 = "________is an algebraic expression,which has three terms.<br>";
			  //Generate question marathi
			  String Que5 = "# ________ ही अशी बैजिक राशी आहे, ज्यात तीन पदे असतात.<br>";
				
			  String Question2 =""+Que4+" "+Que5+"";
			  row.createCell(4).setCellValue(Question2);
				default:
					break;
			 }
			  
			  row.createCell(5).setCellValue(Correct_ans);
//				 row.createCell(6).setCellValue(" ");
//				 row.createCell(7).setCellValue(" ");
//				 row.createCell(8).setCellValue(" ");
				 row.createCell(9).setCellValue(wrong_ans);
				 row.createCell(10).setCellValue(wrong_ans1);
				 row.createCell(11).setCellValue(wrong_ans2);
				 row.createCell(12).setCellValue(60);
				   row.createCell(13).setCellValue(1);
//				  row.createCell(14).setCellValue(" ");
				  row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				  
				//Generate Solution
				  String Solu ="Ans : Trinomial <br>Trinomial is defined as a polynomial containing three terms. Since this expression has three terms it is called as trinomial is the answer.<br>";
				  String Sol1 =" # उत्तर : त्रिपदी <br>ज्या बैजिक बहुपदीमध्ये तीन पदे असतात तिला त्रिपदी म्हणतात. दिलेल्या बैजिक राशीमध्ये तीन पदे आहेत म्हणून ती त्रिपदी आहे हे उत्तर.<br> ";
				  String Solution = " "+Solu+" "+Sol1+" ";				 
				  row.createCell(16).setCellValue(Solution);
//				  row.createCell(17).setCellValue(" ");
				  row.createCell(18).setCellValue(113);

					mapsize = map.size();
					map.put(wrong_ans3, i);
				 mapsizeafter = map.size();
				
                //In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
				if(mapsize == mapsizeafter) {
					System.out.println("duplicate Question"+i+". " +wrong_ans3);
					i--;
				}
	 
				  
			 }
			
			
			 int rowTotal = sheet1.getLastRowNum();
     //			  System.out.println(rowTotal);
				XSSFRow row = sheet1.createRow(rowTotal+1);
				row.createCell(0).setCellValue("****");

                    //Writing data to the file
		        	FileOutputStream fileout = new FileOutputStream(filename);
					workbook.write(fileout);
					fileout.close();
				    
				    System.out.println("file created");
				    
	}
	
}