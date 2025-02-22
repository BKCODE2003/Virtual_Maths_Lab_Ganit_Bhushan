import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VLab_120202_105_Assign27_Bhushan {
	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VLab_120202_105_Assign27_Bhushan.xlsx";     //Location where excel file is getting generated
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
			row.createCell(3).setCellValue("120202");

			char []alphabetCapArray = {'A', 'B', 'C', 'D', 'F', 'G', 'H', 'K', 'L', 'M', 'P', 'S', 'T', 'V', 'X', 'Y'};
			char []alphabetArray = {'a', 'b', 'c', 'd', 'f', 'g', 'h', 'k', 'l', 'm', 'p', 's', 't', 'v', 'x', 'y'};

			String Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Que,Que1,Sol,Sol1,correct_ans_eng_term,correct_ans_mar_term,correct_ans_eng_term1,correct_ans_mar_term1;
			
			// $M = \\{m \\ | "+alphabetArray[p]+" \\ $ all natural odd numbers$\\}$<br>#$M = \\{m \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक विषम संख्या $\\}$<br>
			// $M = \\{m \\ | "+alphabetArray[p]+" \\ $ all even integers $\\}$<br>#$M = \\{m \\ | "+alphabetArray[p]+" \\ $ सर्व सम संख्या $\\}$<br>
			// $M = \\{m \\ | "+alphabetArray[p]+" \\ $ all even natural numbers $<10\\}$<br>#$M = \\{m \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक सम संख्या $<10\\}$<br>
			// $M = \\{m \\ | "+alphabetArray[p]+" \\ m=2n$ where $n\\in N$ and $n<5\\}$<br>#$M = \\{m \\ | "+alphabetArray[p]+" \\ m=2n$ ज्यात $n\\in N$ आणि $n<5\\}$<br>
			// $M = \\{m \\ | "+alphabetArray[p]+" \\ $ all odd integers $\\}$<br>#$M = \\{m \\ | "+alphabetArray[p]+" \\ $ सर्व विषम संख्या $\\}$<br>
			// $M = \\{m \\ | "+alphabetArray[p]+" \\ $ all all natural numbers divisible by 5 $\\}$<br>#$M = \\{m \\ | "+alphabetArray[p]+" \\ $ अशा सर्व संख्या ज्यांना $5$ ने पूर्ण भाग जातो$\\}$<br>
				
			correct_ans_eng_term="";
			correct_ans_mar_term="";
			Correct_ans="";
			wrong_ans="";
			wrong_ans1="";
			wrong_ans2="";

			correct_ans_eng_term1="";
			correct_ans_mar_term1="";

			int p=(int)(Math.random()*16);
			int q=1;
			if(p<=14){
				q=p+1;
			}
			else{
				if(p==0){
					q=1;
				}
				else{
					q=p-1;
				}
			}

			
			int ch=(int)(Math.random()*13+1);
			int itr1=(int)Math.random()*3;
			int itr2=(int)Math.random()*3;
			int itr3=(int)Math.random()*3;

			int itrnum1=(int)Math.random()*8+2;
			int itrnum2=(int)Math.random()*10+1;
			String setString="";

			switch (ch) {
				case 1:
					// All Even Natural Numbers 
					setString="\\{2, 4, 6, 8, ....\\}";
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all even natural numbers $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक सम संख्या $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"=2"+alphabetArray[q]+"$, where $"+alphabetArray[q]+"\\in N$ $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"=2"+alphabetArray[q]+"$, ज्यात $"+alphabetArray[q]+"\\in N$ $\\}";

					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					
					if(itr1==0){
						wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all odd natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक विषम संख्या $\\}$ <br>";
					}else{
						wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक संख्या $\\}$ <br>";
					}
					if(itr2==0){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}$ <br>";
					}else{
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all perfect square numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण वर्ग संख्या $\\}$ <br>";

					}
					if(itr3==0){
						wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all whole numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण संख्या $\\}$ <br>";
					}else{
						wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";
					}

				break;
				
				case 2:
					// All Odd Natural Numbers 
					setString="\\{1, 3, 5, 7, ....\\}";
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all odd natural numbers $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक विषम संख्या $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"=2"+alphabetArray[q]+"+1$, where $"+alphabetArray[q]+"\\in W$ $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"=2"+alphabetArray[q]+"+1$, ज्यात $"+alphabetArray[q]+"\\in W$ $\\}";


					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					if(itr1==0){
						wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all even natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक सम संख्या $\\}$ <br>";
					}else{
						wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक संख्या $\\}$ <br>";
					}
					if(itr2==0){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}$ <br>";
					}else{
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all perfect square numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण वर्ग संख्या $\\}$ <br>";

					}
					if(itr3==0){
						wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all whole numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण संख्या $\\}$ <br>";
					}else{
						wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";
					}
				break;

				// case 3:
				// 	// Num/5
				// 	setString="\\{5, 10, 15, 20, ....\\}";
				// 	correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers divisible by $5$ $\\}";
				// 	correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ अशा सर्व नैसर्गिक संख्या ज्यांना $5$ ने पूर्ण भाग जातो $\\}";

				// 	Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
				// 	wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all even natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक सम संख्या $\\}$ <br>";
				// 	wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all perfect square numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण वर्ग संख्या $\\}$ <br>";
				// 	wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers divisible by $10$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ अशा सर्व नैसर्गिक संख्या ज्यांना $10$ ने पूर्ण भाग जातो $\\}$ <br>";

				// break;

				// case 4:
				// 	// Num/10
				// 	setString="\\{10, 20, 30, 40, ....\\}";
				// 	correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers divisible by $10$ $\\}";
				// 	correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ अशा सर्व नैसर्गिक संख्या ज्यांना $10$ ने पूर्ण भाग जातो $\\}";

				// 	Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
				// 	wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}$ <br>";
				// 	wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all perfect square numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण वर्ग संख्या $\\}$ <br>";
				// 	wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers divisible by $4$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ अशा सर्व नैसर्गिक संख्या ज्यांना $4$ ने पूर्ण भाग जातो $\\}$ <br>";

				// break;

				case 3:
					// All perfect Squares
					setString="\\{1, 4, 9, 16, ....\\}";
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all perfect square numbers $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण वर्ग संख्या $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+alphabetArray[q]+"^2$, where $"+alphabetArray[q]+"\\in N$ $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+alphabetArray[q]+"^2$, ज्यात $"+alphabetArray[q]+"\\in N$ $\\}";


					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}$ <br>";
					if(itr1==1){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all whole numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण संख्या $\\}$ <br>";
					}
					else if(itr2==1){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all positive odd cube numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व विषम धन घन संख्या $\\}$ <br>";
					}else{
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";
					}
					if(itr1==0)
					{wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all even natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक सम संख्या $\\}$ <br>";
					}
					else if(itr2==0){
						wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all odd natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक विषम संख्या $\\}$ <br>";
					}else{
						wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक संख्या $\\}$ <br>";
					}
				break;

				case 4:
					// All perfect cubes
					setString="\\{1, 8, 27, 64, ....\\}";
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all positive cube numbers $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व धन घन संख्या $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+alphabetArray[q]+"^3$, where $"+alphabetArray[q]+"\\in N$ $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+alphabetArray[q]+"^3$, ज्यात $"+alphabetArray[q]+"\\in N$ $\\}";

					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}$ <br>";
					if(itr1==1){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all perfect square numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण वर्ग संख्या $\\}$ <br>";
					}
					else if(itr2==1){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all positive odd cube numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व विषम धन घन संख्या $\\}$ <br>";
					}else{
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";
					}
					if(itr1==0)
					{wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all even natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक सम संख्या $\\}$ <br>";
					}
					else if(itr2==0){
						wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all odd natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक विषम संख्या $\\}$ <br>";
					}else{
						wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक संख्या $\\}$ <br>";
					}
				break;
					
				case 5:
					// M=n*num
					int num=(int)(Math.random()*9+2);
					setString="\\{"+num+", "+(num*2)+", "+(num*3)+", "+(num*4)+", ....\\}";
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+num+""+alphabetArray[q]+"\\ $, where $"+alphabetArray[q]+"\\in N$ $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+num+""+alphabetArray[q]+"\\ $, ज्यात $"+alphabetArray[q]+"\\in N$ $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+num+""+alphabetArray[q]+"\\ $, where $"+alphabetArray[q]+"\\in N$ $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+num+""+alphabetArray[q]+"\\ $, ज्यात $"+alphabetArray[q]+"\\in N$ $\\}";

					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					if(itr1==0)
					{wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all even natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक सम संख्या $\\}$ <br>";
					}
					else if(itr2==0){
						wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all odd natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक विषम संख्या $\\}$ <br>";
					}else{
						wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक संख्या $\\}$ <br>";
					}

					if(itr1==1){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all perfect square numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण वर्ग संख्या $\\}$ <br>";
					}
					else if(itr2==1){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all positive cube numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व धन घन संख्या $\\}$ <br>";
					}else{
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";
					}
					wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers divisible by $"+((num*2)+1)+"$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ अशा सर्व नैसर्गिक संख्या ज्यांना $"+((num*2)+1)+"$ ने पूर्ण भाग जातो $\\}$ <br>";


				break;

				case 6:
					// All Prime numbers
					setString="\\{2, 3, 5, 7, ....\\}";
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}";
					
					int num5=(int)(Math.random()*8+2);
					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers divisible by $"+num5+"$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ अशा सर्व नैसर्गिक संख्या ज्यांना $"+num5+"$ ने पूर्ण भाग जातो $\\}$ <br>";
					wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all even numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व सम संख्या $\\}$ <br>";
					wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+num5+""+alphabetArray[q]+"+"+itrnum2+"\\ $ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+num5+""+alphabetArray[q]+"+"+itrnum2+"\\ $ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";

				break;

				case 7:
					// All Natural numbers
					setString="\\{1, 2, 3, 4, ....\\}";
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक संख्या $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक संख्या $\\}";
					
					int num3=(int)(Math.random()*8+2);
					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers divisible by $"+num3+"$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ अशा सर्व नैसर्गिक संख्या ज्यांना $"+num3+"$ ने पूर्ण भाग जातो $\\}$ <br>";
					if(itr1==1){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all perfect square numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण वर्ग संख्या $\\}$ <br>";
					}
					else if(itr2==0){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all positive cube numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व धन घन संख्या $\\}$ <br>";
					}else{
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";
					}
					wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}$ <br>";

				break;

				case 8:
					// All Whole numbers
					setString="\\{0, 1, 2, 3, ....\\}";
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all whole numbers $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण संख्या $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all whole numbers $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण संख्या $\\}";
					
					int num4=(int)(Math.random()*8+2);
					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers divisible by $"+num4+"$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ अशा सर्व नैसर्गिक संख्या ज्यांना $"+num4+"$ ने पूर्ण भाग जातो $\\}$ <br>";
					wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+"|"+alphabetArray[p]+"="+num4+""+alphabetArray[q]+"$ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+"|"+alphabetArray[p]+"="+num4+""+alphabetArray[q]+"$ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";
					wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}$ <br>";

				break;

				case 9:
					// All square of even number
					setString="\\{4, 16, 36, 64, ....\\}";
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all even perfect square numbers $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व सम पूर्ण वर्ग संख्या $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"=(2"+alphabetArray[q]+")^2$, where $"+alphabetArray[q]+"\\in N$ $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"=(2"+alphabetArray[q]+")^2$, ज्यात $"+alphabetArray[q]+"\\in N$ $\\}";

					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					if(itr1==0){
						wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all even natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक सम संख्या $\\}$ <br>";
					}else{
						wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक संख्या $\\}$ <br>";
					}
					if(itr2==0){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}$ <br>";
					}else{
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all positive cube numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व धन घन संख्या $\\}$ <br>";

					}
					wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+"|"+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"$ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+"|"+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"$ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";

				break;

				case 10:
					// All square of odd numbers
					setString="\\{1, 9, 25, 49, ....\\}";
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all odd perfect square numbers $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व विषम पूर्ण वर्ग संख्या $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"=(2"+alphabetArray[q]+"+1)^2$, where $"+alphabetArray[q]+"\\in N$ $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"=(2"+alphabetArray[q]+"+1)^2$, ज्यात $"+alphabetArray[q]+"\\in N$ $\\}";

					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					if(itr1==0){
						wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all even natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक सम संख्या $\\}$ <br>";
					}else{
						wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक संख्या $\\}$ <br>";
					}
					if(itr2==0){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}$ <br>";
					}else{
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all positive cube numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व धन घन संख्या $\\}$ <br>";

					}
					wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+"|"+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"$ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+"|"+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"$ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";

				break;

				case 11:
					// All cube of even number
					setString="\\{8, 64, 216, 512, ....\\}";
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all positive even cube numbers $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व सम धन घन संख्या $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"=(2"+alphabetArray[q]+")^3$, where $"+alphabetArray[q]+"\\in N$ $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"=(2"+alphabetArray[q]+")^3$, ज्यात $"+alphabetArray[q]+"\\in N$ $\\}";

					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					if(itr2==0){
						wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}$ <br>";
					}else{
						wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all positive cube numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व धन घन संख्या $\\}$ <br>";

					}					
					wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+"|"+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"$ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+"|"+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"$ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";
					wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक संख्या $\\}$ <br>";

				break;

				case 12:
					// All cube of odd numbers
					setString="\\{1, 27, 125, 343, ....\\}";
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all positive odd cube numbers $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व विषम धन घन संख्या $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"=(2"+alphabetArray[q]+"+1)^3$, where $"+alphabetArray[q]+"\\in N$ $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"=(2"+alphabetArray[q]+"+1)^3$, ज्यात $"+alphabetArray[q]+"\\in N$ $\\}";

					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all prime numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व मूळ संख्या $\\}$ <br>";
					if(itr1==1){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all perfect square numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण वर्ग संख्या $\\}$ <br>";
					}
					else if(itr2==1){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all positive cube numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व धन घन संख्या $\\}$ <br>";
					}else{
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";
					}						
					wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all whole numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण संख्या $\\}$ <br>";

				break;

				case 13:
					int num2=(int)(Math.random()*9+2);
					setString="\\{"+num2+", "+(num2*num2)+", "+(num2*num2*num2)+", "+(num2*num2*num2*num2)+", ....\\}";
					
					correct_ans_eng_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ "+alphabetArray[p]+"="+num2+"^"+alphabetArray[q]+"$, where $"+alphabetArray[q]+"\\in N$ $\\}";
					correct_ans_mar_term="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ "+alphabetArray[p]+"="+num2+"^"+alphabetArray[q]+"$, ज्यात $"+alphabetArray[q]+"\\in N$ $\\}";

					correct_ans_eng_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ "+alphabetArray[p]+"="+num2+"^"+alphabetArray[q]+"$, where $"+alphabetArray[q]+"\\in N$ $\\}";
					correct_ans_mar_term1="\\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ "+alphabetArray[p]+"="+num2+"^"+alphabetArray[q]+"$, ज्यात $"+alphabetArray[q]+"\\in N$ $\\}";


					Correct_ans="$"+alphabetCapArray[p]+" = "+correct_ans_eng_term+"$ <br> #$"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ <br>";
					wrong_ans="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all even natural numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व नैसर्गिक सम संख्या $\\}$ <br>";
					if(itr1==1){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all perfect square numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व पूर्ण वर्ग संख्या $\\}$ <br>";
					}
					else if(itr2==1){
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all positive cube numbers $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ सर्व धन घन संख्या $\\}$ <br>";
					}else{
						wrong_ans1="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ where $"+alphabetArray[q]+"\\in N$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+"="+itrnum1+""+alphabetArray[q]+"+"+itrnum2+"\\ $ ज्यात $"+alphabetArray[q]+"\\in N$ $\\}$ <br>";
					}					
					wrong_ans2="$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ all natural numbers divisible by $"+itrnum1+"$ $\\}$ <br> #$"+alphabetCapArray[p]+" = \\{"+alphabetArray[p]+" \\ | "+alphabetArray[p]+" \\ $ अशा सर्व नैसर्गिक संख्या ज्यांना $"+itrnum1+"$ ने पूर्ण भाग जातो $\\}$ <br>";

				break;

				default:
					break;
			}

			
			Que="If set $"+alphabetCapArray[p]+"$ is represented as $"+setString+"$, then which of the following rule will generate this set? <br>";
			Que1="#जर संच $"+alphabetCapArray[p]+"="+setString+"$, तर खालील पैकी कोणता नियम हा संच दाखवितो? <br>";

			Sol="Ans : $"+alphabetCapArray[p]+" = "+correct_ans_eng_term1+"$<br>" +
								"Here the set given is in listing or roster form. <br>We are asked to find out the correct rule, which will generate the given required set. <br>Therefore, we need to find out the set generated by each rule. <br>The generated set which will match with the given $"+alphabetCapArray[p]+" = "+correct_ans_eng_term1+"$ generates the required set as, $"+setString+"$. <br>This set matches with the given set. <br>The sets generated by all other rules don't match with the given set. <br>" +
								"Hence, $"+alphabetCapArray[p]+" = "+correct_ans_eng_term1+"$ is the correct option, is the answer. <br>";
			Sol1="#उत्तर : $"+alphabetCapArray[p]+" = "+correct_ans_mar_term1+"$<br>" + 
								"येथे दिलेला संच यादी पद्धतीने लिहिला आहे. <br>" +
								"या संचासाठी आपल्याला असा योग्य नियम शोधून काढायचा आहे, की ज्या नियमाने आपल्याला हवा असलेला संच मिळेल. <br>या साठी दिलेल्या प्रत्येक नियमानुसार तयार होणार संच शोधावा लागेल. <br>अशा रीतीने मिळणाऱ्या संचातील जो संच दिलेल्या संचाशी जुळतो, तो नियम आपल्याला हवा असलेला नियम असेल. <br>" +
								"तपासणी पद्धतीने आपल्याला हे लक्षात येते की, $"+alphabetCapArray[p]+" = "+correct_ans_mar_term1+"$ या नियमा नुसार आपल्याला असा $"+setString+"$ संच मिळतो. <br>हा संच दिलेल्या संचाशी जुळणारा संच आहे. <br> नियमा नुसार मिळणारे इतर कोणतेही संच दिलेल्या संचाशी जुळत नाहीत. <br>म्हणून, $"+alphabetCapArray[p]+" = "+correct_ans_mar_term+"$ हा आपल्याला हवा असलेला योग्य पर्याय आहे, हे उत्तर. <br> ";
			
			
			String Solution = ""+Sol+" "+Sol1+"";
			String Question =""+Que+" "+Que1+"";
			
			

			row.createCell(4).setCellValue(Question);
			row.createCell(5).setCellValue(Correct_ans);
			//				 row.createCell(6).setCellValue(" ");
			//				 row.createCell(7).setCellValue(" ");
			//				 row.createCell(8).setCellValue(" ");
			row.createCell(9).setCellValue(wrong_ans);
			row.createCell(10).setCellValue(wrong_ans1);
			row.createCell(11).setCellValue(wrong_ans2);
			row.createCell(12).setCellValue(120);
			row.createCell(13).setCellValue(2);
			//				  row.createCell(14).setCellValue(" ");
			row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			//Generate Solution
								
			row.createCell(16).setCellValue(Solution);
			//				  row.createCell(17).setCellValue(" ");
			row.createCell(18).setCellValue(105);

				
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
