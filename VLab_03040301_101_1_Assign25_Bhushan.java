import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VLab_03040301_101_1_Assign25_Bhushan {
	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VLab_03040301_101_1_Assign25_Bhushan.xlsx";     //Location where excel file is getting generated
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
			row.createCell(3).setCellValue("03040301");

			String pluralFruits[] = {
				"mangoes", "apples", "oranges", "grapes", "guavas", "pomegranates", 
				"custard apples", "bananas", "papayas", "pineapples", "strawberries", 
				"watermelons","Jamun", "raspberries", "pears", 
				"cherries", "kiwis", "plums"
			};

			String singularFruits[] = {
				"mango", "apple", "orange", "grape", "guava", "pomegranate", 
				"custard apple", "banana", "papaya", "pineapple", "strawberry", 
				"watermelon", "Jamun", "raspberry", "pear", 
				"cherry", "kiwi", "plum"
			};
			
			
			String fruitsMarathi[] = {
				"आंबे", "सफरचंद", "संत्र", "द्राक्ष", "पेरू", "डाळिंब", 
				"सीताफळ", "केळी", "पपई", "अननस", "स्ट्रॉबेरी", 
				"कलिंगड", "जांभूळ", "रासबेरी", "नासपती", 
				"चेरी", "कीवी", "आलुबुखार"
			};

			String fruitsMarathiPlural[] = {
				"आंबे", "सफरचंदे", "संत्री", "द्राक्षे", "पेरू", "डाळिंबे", 
				"सीताफळे", "केळी", "पपया", "अननस", "स्ट्रॉबेरी", 
				"कलिंगडे", "जांभळे", "रासबेरी", "नासपती", 
				"चेरी", "कीवी", "आलुबुखार"
			};
			
			String multifruitsMarathi[] = {
				"आंब्यामध्ये आंबे", "सफरचंदामध्ये सफरचंदे", "संत्र्यांमधे संत्री", 
				"द्राक्षामध्ये द्राक्षे", "पेरूमध्ये पेरू", "डाळिंबामध्ये डाळिंबे", 
				"सीताफळामध्ये सीताफळे", "केळ्यामध्ये केळी", "पपयांमधे पपया", 
				"अननसां मधे अननस", "स्ट्रॉबेरीं मधे स्ट्रॉबेरी", "कलिंगडामध्ये कलिंगडे", 
				"जांभळामध्ये जांभळे", "रासबेरीं मधे रासबेरी", 
				"नासपतीं मधे  नासपती", "चेरीं मधे चेरी", 
				"किवीं मधे कीवी", "अलुबुखारां मधे आलुबुखार"
			};
			
			
			int a=(int)(Math.random()*18); 
			
			int b=(int)(Math.random()*20+2);

			int c=(int)(Math.random()*20+2);


			String Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Que,Que1,Sol,Sol1;
			
			Que="$"+b+"$ "+pluralFruits[a]+" + $"+c+"$ "+pluralFruits[a]+" = ? <br>";
			Que1="# $"+b+"$ "+fruitsMarathiPlural[a]+" + $"+c+"$ "+fruitsMarathiPlural[a]+" = ? <br>";

			Sol="Ans: $"+(b+c)+"$ "+pluralFruits[a]+"<br>Since it is asked to add "+singularFruits[a]+" in "+pluralFruits[a]+", and they are same type of fruits, we can add them as follows<br> $"+b+"$ "+pluralFruits[a]+" + $"+c+"$ "+pluralFruits[a]+"<br> $ = ("+b+" + "+c+")$ "+pluralFruits[a]+" . . . . by adding numbers $"+b+"$ and $"+c+"$ to get $"+(b+c)+"$ <br>$ = "+(b+c)+"$ "+pluralFruits[a]+" . . . write "+pluralFruits[a]+" with this number as $"+(b+c)+"$ "+pluralFruits[a]+".<br> $ \\therefore "+(b+c)+"$ "+pluralFruits[a]+" is the answer.<br> ";
			Sol1="# उत्तर : $"+(b+c)+"$ "+fruitsMarathiPlural[a]+"<br> आपल्याला "+multifruitsMarathi[a]+" मिळवायला सांगितले आहेत. मिळवायची दोन्ही फळे एकाच प्रकारची आहेत. म्हणून आपण त्यांची बेरीज खाली दाखविल्या प्रमाणे करू शकतो. <br> $"+b+"$ "+fruitsMarathiPlural[a]+" + $"+c+"$ "+fruitsMarathiPlural[a]+" <br>$ = ("+b+" + "+c+")$ "+fruitsMarathiPlural[a]+" . . . . $"+b+"$ आणि $"+c+"$ या संख्यांची बेरीज करून $"+(b+c)+"$ मिळाले <br>$ = "+(b+c)+"$ "+fruitsMarathiPlural[a]+" . . . . $"+(b+c)+"$ पुढे "+fruitsMarathiPlural[a]+" लिहून <br> $ \\therefore "+(b+c)+" $ "+fruitsMarathiPlural[a]+" हे उत्तर मिळते.<br> ";
			

			
			String Solution = ""+Sol+" "+Sol1+"";
			String Question =""+Que+" "+Que1+"";
			
			Correct_ans="$"+(b+c)+"$ "+pluralFruits[a]+" <br> # $"+(b+c)+"$ "+fruitsMarathiPlural[a]+" <br> ";
			wrong_ans="$"+(b+c+1)+"$ "+pluralFruits[a]+" <br> # $"+(b+c+1)+"$ "+fruitsMarathiPlural[a]+" <br> ";
			int num=2;
			do{
			wrong_ans1="$"+(c+num)+"$ "+pluralFruits[a]+" <br> # $"+(b+c-2)+"$ "+fruitsMarathiPlural[a]+" <br> ";
			// System.out.println(num);
			num++;
			}while((c+num-1)==b || (c+num-1)==(b+c+1) ||(c+num-1)==(b+c));

			wrong_ans2="$"+(b)+"$ "+pluralFruits[a]+" <br> # $"+(b)+"$ "+fruitsMarathiPlural[a]+" <br> ";

			row.createCell(4).setCellValue(Question);
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
								
			row.createCell(16).setCellValue(Solution);
			//				  row.createCell(17).setCellValue(" ");
			row.createCell(18).setCellValue(101);

				
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
