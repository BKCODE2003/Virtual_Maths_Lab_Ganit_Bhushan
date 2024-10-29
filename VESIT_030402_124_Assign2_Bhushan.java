import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VESIT_030402_124_Assign2_Bhushan {

	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VESIT_030402_124_Assign1_Bhushan.xlsx";     //Location where excel file is getting generated
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
   

		String [] queVariEng={"monomial","binomial","trinomial"};
		
		String [] queVariMar={"एकपदी","द्विपदी","त्रिपदी"};
	

		String [] solEng={"Nothing can be said","Data insufficient"};
		String [] solMar={"सांगता येत नाही","दिलेली माहिती पुरेशी नाही"};
	   
	   String [] wrongSolEng={"True","False","None of the given","Value of trinomial is more","Value of binomial is more","Value of trinomial is less","Value of binomial is less","Values of both will always be identical"};
	   String [] wrongSolMar={"बरोबर","चूक","दिलेल्या पैकी कोणतेच नाही"," त्रिपदीची किंमत मोठी","द्विपदीची किंमत मोठी"," त्रिपदीची किंमत लहान","द्विपदीची किंमत लहान","दोन्हीच्या किमती कायम समान असतील"};

	   
		
		for (int i=1;i<201;i++)
		{
	  	     XSSFRow row = sheet1.createRow(i);
	  	     row.createCell(0).setCellValue(i); 
	  	     row.createCell(1).setCellValue("Text"); 
	  	     row.createCell(2).setCellValue(1);
	  	     row.createCell(3).setCellValue("030402");
	  	    
           //m and n for question string d for solution string and rest for wrong answers 
			
		   int a=(int)(Math.random()*8);
		   int b=(int)(Math.random()*8);
		   int c=(int)(Math.random()*8);
		   int d=(int)(Math.random()*2);
		   int m=(int)(Math.random()*3);
		   int n=(int)(Math.random()*3);
		   boolean k=true;
		   while(k)
		   {
			 a=(int)(Math.random()*8);
			 b=(int)(Math.random()*8);
			 c=(int)(Math.random()*8);
		   if(a!=b && a!=c && b!=c)
		   {
			   k=false;
		   }
		   }
		   //Above code will generate unqiue random numbers means different values for a,b,c non of them is same for single question
			 String wrong_ans=""+wrongSolEng[a]+"<br> #"+wrongSolMar[a]+"<br>" ;

			 String wrong_ans1=""+wrongSolEng[b]+"<br> #"+wrongSolMar[b]+"<br>";

			 String wrong_ans2=""+wrongSolEng[c]+"<br> #"+wrongSolMar[c]+"<br>";
  
			 String Correct_ans=""+solEng[d]+"<br> #"+solMar[d]+"<br>";

			 String Question ;
			 String Solution ;

		   //if else is used to add another word when both trionomial or bino or mono are compaired.
			 if(queVariEng[m]==queVariEng[n])
			 {
				String  Que = "For a specific value of a variable, the value of "+queVariEng[m]+" is larger than the value of another "+queVariEng[n]+" for the same specific value of variable.<br>";
			
				String Que1 = "#चलाच्या विशिष्ट किमतीसाठी कोणत्याही "+queVariMar[m]+"चे मूल्य चलाच्या त्याच विशिष्ट किमतीसाठी दुसऱ्या "+queVariMar[n]+"च्या किमती पेक्षा जास्त असते.<br>";
				 Question = ""+Que+" "+Que1+"";

				 String Solu ="Ans : "+solEng[d]+". <br>For the given value of variable say, $x$, value of any polynomial depends on coefficients as well as powers of the variables in the polynomial. It does not depend only upon number of terms in the given polynomial. So we can not compare value of "+queVariEng[m]+" with value of another "+queVariEng[n]+" , based on the number of terms. Two different types of polynomials can have same or different values. <br>$\\therefore$ "+solEng[d]+" , is the correct answer for the given question.<br>";
				  String Sol1 ="#उत्तर : "+solMar[d]+".<br>चलाच्या विशिष्ट किमतीसाठी कोणत्याही बहुपदीचे मूल्य हे जसे त्या चलाच्या किमतीवर अवलंबून असते, तसेच ते त्यातील पदांचे सहगुणक आणि चलाचा घातांक यावर सुद्धा अवलंबून असते. ते फक्त पदांच्या संख्येवर अवलंबून नसते. त्यामुळे एका "+queVariMar[m]+"च्या मूल्याची दुसऱ्या राशीतील पदांच्या संख्येनुसार तुलना होऊ शकत नाही. भिन्न पद-संख्या असणाऱ्या बहुपदींचे मूल्य समानही असू शकते किंवा वेगवेगळेही असू शकते.<br>$\\therefore$ "+solMar[d]+" , हे उत्तर बरोबर आहे.<br>";
				  Solution = " "+Solu+" "+Sol1+" ";	
			 }
			 else{
			 //Generate question english
			 String  Que = "For a specific value of a variable, the value of "+queVariEng[m]+" is larger than the value of "+queVariEng[n]+" for the same specific value of variable.<br>";
			 //Generate question marathi
			 String Que1 = "#चलाच्या विशिष्ट किमतीसाठी कोणत्याही "+queVariMar[m]+"चे मूल्य चलाच्या त्याच विशिष्ट किमतीसाठी "+queVariMar[n]+"च्या किमती पेक्षा जास्त असते.<br>";
			  Question = ""+Que+" "+Que1+"";

			  String Solu ="Ans : "+solEng[d]+". <br>For the given value of variable say, $x$, value of any polynomial depends on coefficients as well as powers of the variables in the polynomial. It does not depend only upon number of terms in the given polynomial. So we can not compare value of "+queVariEng[m]+" with value of "+queVariEng[n]+" , based on the number of terms. Two different types of polynomials can have same or different values. <br>$\\therefore$ "+solEng[d]+" , is the correct answer for the given question.<br>";
			  String Sol1 ="#उत्तर : "+solMar[d]+".<br>चलाच्या विशिष्ट किमतीसाठी कोणत्याही बहुपदीचे मूल्य हे जसे त्या चलाच्या किमतीवर अवलंबून असते, तसेच ते त्यातील पदांचे सहगुणक आणि चलाचा घातांक यावर सुद्धा अवलंबून असते. ते फक्त पदांच्या संख्येवर अवलंबून नसते. त्यामुळे एका "+queVariMar[m]+"च्या मूल्याची दुसऱ्या राशीतील पदांच्या संख्येनुसार तुलना होऊ शकत नाही. भिन्न पद-संख्या असणाऱ्या बहुपदींचे मूल्य समानही असू शकते किंवा वेगवेगळेही असू शकते.<br>$\\therefore$ "+solMar[d]+" , हे उत्तर बरोबर आहे.<br>";
			  Solution = " "+Solu+" "+Sol1+" ";	
			 }
			 String checker=""+Correct_ans+""+wrong_ans+""+wrong_ans1+""+wrong_ans2+""+queVariEng[m]+""+queVariEng[n]+"";   //for checking purpose in map.put()

			  row.createCell(4).setCellValue(Question);
			  row.createCell(5).setCellValue(Correct_ans);
//				 row.createCell(6).setCellValue(" ");
//				 row.createCell(7).setCellValue(" ");
//				 row.createCell(8).setCellValue(" ");
				 row.createCell(9).setCellValue(wrong_ans);
				 row.createCell(10).setCellValue(wrong_ans1);
				 row.createCell(11).setCellValue(wrong_ans2);
				 row.createCell(12).setCellValue(60);
				   row.createCell(13).setCellValue(3);
//				  row.createCell(14).setCellValue(" ");
				  row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				  
				//Generate Solution

						 
				  row.createCell(16).setCellValue(Solution);
//				  row.createCell(17).setCellValue(" ");
				  row.createCell(18).setCellValue(124);

					mapsize = map.size();
					map.put(checker, i);
				 mapsizeafter = map.size();
				
            //    In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
				if(mapsize == mapsizeafter) {
					System.out.println("duplicate Question"+i+". " + checker);
					i--;
				}
				
				//  if(a==b||a==c||a==d||b==c||b==d||c==d) {
				// 		System.out.println("duplicate"+ i);  
				// 		i--;
				// 	  }
	 
				                
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