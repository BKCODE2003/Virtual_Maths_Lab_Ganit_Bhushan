import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VLab_03040303_118_Assign27_Bhushan {
	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VLab_03040303_118_Assign27_Bhushan.xlsx";     //Location where excel file is getting generated
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
	
		for(int i =1;i<201;i++)
		{
			// Create row
			
			XSSFRow row = sheet1.createRow(i);
			row.createCell(0).setCellValue(i); 
			row.createCell(1).setCellValue("Text"); 
			row.createCell(2).setCellValue(1);
			row.createCell(3).setCellValue("03040303");

			
			

			String Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Que,Que1,Sol,Sol1;
			
			Que="Find किंमत काढा / शोधा <br> $(\\dfrac{2}{5}x^2y-\\dfrac{1}{3}y^2z) - (\\dfrac{1}{4}z^2x-\\dfrac{3}{5}yx^2) + (\\dfrac{2}{3}zy^2 -\\dfrac{3}{4}xz^2)$ <br>";
			Que1="";

			Sol="Given  $(\\dfrac{2}{5}x^2y-\\dfrac{1}{3}y^2z)-(\\dfrac{1}{4}z^2x-\\dfrac{3}{5}yx^2) +(\\dfrac{2}{3}zy^2 -\\dfrac{3}{4}xz^2)$<br>"+
								" $= \\dfrac{2}{5}x^2y-\\dfrac{1}{3}y^2z-\\dfrac{1}{4}z^2x+\\dfrac{3}{5}yx^2 +\\dfrac{2}{3}zy^2 -\\dfrac{3}{4}xz^2$  . . . .  by opening the brackets<br>"+
								" $=(\\dfrac{2}{5}x^2y+\\dfrac{3}{5}x^2y) +(-\\dfrac{1}{3}y^2z+\\dfrac{2}{3}y^2z) +(-\\dfrac{1}{4}z^2x-\\dfrac{3}{4}z^2x)$ . . . .By bringing like terms together <br>"+
								" $= x^2y +\\dfrac{1}{3}y^2z -z^2x$  . . . .  adding the coefficients of like terms<br>"+
								" $\\therefore x^2y +\\dfrac{1}{3}y^2z -z^2x$ is the answer.<br>";
			Sol1="#उत्तर : $x^2y +\\dfrac{1}{3}y^2 -z^2x$<br>"+
 				"दिलेल्या वरून $(\\dfrac{2}{5}x^2y-\\dfrac{1}{3}y^2z)-(\\dfrac{1}{4}z^2x-\\dfrac{3}{5}yx^2) +(\\dfrac{2}{3}zy^2 -\\dfrac{3}{4}xz^2)$<br>"+
 				"$= \\dfrac{2}{5}x^2y-\\dfrac{1}{3}y^2z-\\dfrac{1}{4}z^2x+\\dfrac{3}{5}yx^2 +\\dfrac{2}{3}zy^2 -\\dfrac{3}{4}xz^2$ . . . .  कंस सोडवून <br>"+
 				"$=(\\dfrac{2}{5}x^2y+\\dfrac{3}{5}x^2y) +(-\\dfrac{1}{3}y^2z+\\dfrac{2}{3}y^2z) +(-\\dfrac{1}{4}z^2x-\\dfrac{3}{4}z^2x)$  . . . . सजातीय पदे एकत्र करून <br>"+
 				"$= x^2y +\\dfrac{1}{3}y^2z -z^2x$  . . . .  सजातीय पदांच्या सहगुणकांची बेरीज करून <br>"+
				"$\therefore x^2y +\\dfrac{1}{3}y^2z -z^2x$ हे उत्तर.<br>";
			
			
			String Solution = ""+Sol+" "+Sol1+"";
			String Question =""+Que+" "+Que1+"";
			
			Correct_ans="";
			wrong_ans="";
			
			wrong_ans1="";
			
			wrong_ans2="";

			row.createCell(4).setCellValue(Question);
			row.createCell(5).setCellValue(Correct_ans);
			//				 row.createCell(6).setCellValue(" ");
			//				 row.createCell(7).setCellValue(" ");
			//				 row.createCell(8).setCellValue(" ");
			row.createCell(9).setCellValue(wrong_ans);
			row.createCell(10).setCellValue(wrong_ans1);
			row.createCell(11).setCellValue(wrong_ans2);
			row.createCell(12).setCellValue(90);
			row.createCell(13).setCellValue(3);
			//				  row.createCell(14).setCellValue(" ");
			row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			//Generate Solution
								
			row.createCell(16).setCellValue(Solution);
			//				  row.createCell(17).setCellValue(" ");
			row.createCell(18).setCellValue(118);

				
			String Checker =""+Solution+""+Correct_ans+""+wrong_ans+""+wrong_ans1+""+wrong_ans2+""+Question+"";
			mapsize = map.size();
			map.put(Checker,i);
			mapsizeafter = map.size();
							
			//In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
			if(mapsize == mapsizeafter) {
				// System.out.println(Checker);
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
