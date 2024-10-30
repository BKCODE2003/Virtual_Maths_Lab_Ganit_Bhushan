import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VLab_0304060402_109_1_Assign29_Bhushan {
	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VLab_0304060402_109_1_Assign29_Bhushan.xlsx";     //Location where excel file is getting generated
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
			row.createCell(3).setCellValue("0304060402");

			String ename[] = {"Abhinav","Harsh","Adarsh","Shaym","Rajveer","Amit","Rajvardhan","Ashok","Omkar","Kunal","Arya","Swati","Radha","Prachi","Aditi","Akshara","Kavyaa","Swara","Sharayu","sayali"};
			String mname[]= {"अभिनव","हर्ष","आदर्श","श्याम","राजवीर","अमित","राजवर्धन","अशोक","ओंकार","कुणाल","आर्या","स्वाती","राधा","प्राची","अदिती","अक्षरा","काव्या","स्वरा","शरयू","सायली"};
			
			int a=(int)(Math.random()*20); 
			
			int attempted=(int)(Math.random()*91+10); 
			
			int correct_attempt=(int)(Math.random()*(attempted+1));

			int wrong_attempt=attempted-correct_attempt;

			int score=correct_attempt*2-wrong_attempt;

			String Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Que,Que1,Sol,Sol1;
			
			Que="In a competitive examination, there were $100$ questions. The correct answer would carry $2$ marks, and for incorrect answers $1$ mark would be deducted, and $0$ mark for not attempted questions. "+ename[a]+" had attempted $"+attempted+"$ questions and "+(a>9 ? "she":"he")+" got a total $"+score+"$ marks. Then how many questions did "+(a>9 ? "she":"he")+" get wrong? <br> ";
			Que1="#एका स्पर्धा परीक्षेत $100$ प्रश्न होते. बरोबर उत्तराला $2$ गुण, तर प्रत्येक चूक उत्तरासाठी $1$ गुण वजा होतो, आणि न सोडविलेल्या प्रश्नाला $0$ गुण दिले जातात. "+mname[a]+"ने त्या परीक्षेत $"+attempted+"$ प्रश्न सोडविले आणि "+(a>9 ? "तिला":"त्याला")+" एकूण $"+score+"$ गुण मिळाले. तर "+(a>9 ? "तिने":"त्याने")+" किती प्रश्न चूक सोडविले? <br> ";

			Sol="Ans: $"+wrong_attempt+"$ <br> Let us assume that "+ename[a]+" got $x$ questions correct and $y$ questions wrong. From the given information, we get<br> $x+y="+attempted+". . . . (i)$, and $2x-y="+score+". . . . (ii)$<br> From $(i)$ we get $x="+attempted+"-y$ <br> Substituting this value of $x$ in $(ii)$, we get <br> $2("+attempted+"-y)-y="+score+"$ <br> $ \\therefore y= "+wrong_attempt+" =$ no. of wrong answers given by "+ename[a]+". <br> ";
			Sol1="#उत्तर: $"+wrong_attempt+"$ <br> "+mname[a]+"ने $x$ प्रश्न बरोबर सोडवले आणि $y$ प्रश्न चूक सोडवले असे मानू. दिलेल्या माहितीनुसार आपल्याला <br> $x+y="+attempted+". . . . (i)$ , आणि $2x-y="+score+". . . . (ii)$ अशी समीकरणे मिळतात <br> आता समीकरण $(i)$ वरून $x="+attempted+"-y$ मिळते <br> ही  $x$ ची किंमत आपण $(ii)$ मध्ये ठेऊन आपल्याला <br> $2("+attempted+"-y)-y="+score+"$ <br> $ \\therefore y= "+wrong_attempt+" =$ चूक सोडविलेल्या प्रश्नांची संख्या हे उत्तर मिळते. <br> ";
			

			
			String Solution = ""+Sol+" "+Sol1+"";
			String Question =""+Que+" "+Que1+"";
			
			Correct_ans="$"+wrong_attempt+"$ <br> ";
			wrong_ans="$"+correct_attempt+"$ <br> ";
			if(wrong_attempt==correct_attempt){
				wrong_ans="$"+(correct_attempt+1)+"$ <br> ";
			}
			wrong_ans2="$"+(attempted)+"$ <br> ";
			wrong_ans1="$"+(wrong_attempt+2)+"$ <br> ";
			int k=2;
			while(wrong_ans1==wrong_ans || wrong_ans1==Correct_ans || wrong_ans1==wrong_ans2){
				wrong_ans1="$"+(wrong_attempt+k)+"$ <br> ";
				k++;
			}
			wrong_ans2="$"+(attempted)+"$ <br> ";
			

			row.createCell(4).setCellValue(Question);
			row.createCell(5).setCellValue(Correct_ans);
			//				 row.createCell(6).setCellValue(" ");
			//				 row.createCell(7).setCellValue(" ");
			//				 row.createCell(8).setCellValue(" ");
			row.createCell(9).setCellValue(wrong_ans);
			row.createCell(10).setCellValue(wrong_ans1);
			row.createCell(11).setCellValue(wrong_ans2);
			row.createCell(12).setCellValue(360);
			row.createCell(13).setCellValue(5);
			//				  row.createCell(14).setCellValue(" ");
			row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			//Generate Solution
								
			row.createCell(16).setCellValue(Solution);
			//				  row.createCell(17).setCellValue(" ");
			row.createCell(18).setCellValue(109);

				
			String Checker =""+correct_attempt+""+wrong_attempt+""+attempted+""+score+"";
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
