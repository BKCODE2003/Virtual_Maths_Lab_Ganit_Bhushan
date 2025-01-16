import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VLab_0304070202_122_Assign30_Bhushan {
	public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
	private static final Set<String> usedPairs = new HashSet<>();

	public static boolean isInUse(int a, int b,int c) {
        
        String pair = a + "-" + b +	"-" + c;

        if (usedPairs.contains(pair)) {
            return true; 
		}
        usedPairs.add(pair);
        return false;
    }

	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VLab_0304070202_122_Assign30_Bhushan.xlsx";     //Location where excel file is getting generated
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
			row.createCell(3).setCellValue("0304070202");
			String []var1={"a","c","g","l","m","p","r","s","u","v","x","y","b","d","h","m","n","q","s","t","v","w","y","z"};
    		
			int Chr1[] = { 3, 6, 9, 12, 15, 18, 5, 10, 8, 7};
			int Chr2[] = { 4, 8, 12, 16, 20, 24, 12, 24, 15, 24 };
			int Chr3[] = { 5, 10, 15, 20, 25, 30, 13, 26, 17, 25};

			int p=(int)(Math.random()*24);
			int nim=(int)(Math.random()*10);
			int div=(int)(Math.random()*9)+1;

			while(isInUse(nim,div,p)){
				p=(int)(Math.random()*24);
				nim=(int)(Math.random()*10);
				div=(int)(Math.random()*9)+1;
			}

			int diff=Chr2[nim]-Chr1[nim];
			String Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Que,Que1,Sol,Sol1;
			int term1=diff*diff-Chr3[nim]*Chr3[nim];
			int gcd3=gcd(2*div*div,gcd(2*div*diff,Math.abs(term1)));
			
			Que="";
			Que1="";

			Sol="As the measure of base is not given let us assume base to be $"+var1[p]+"$ cm. <br>" +
								"$\\therefore $ Altitude $="+var1[p]+"+\\dfrac{"+diff+"}{"+div+"}=\\dfrac {"+div+""+var1[p]+"+"+diff+"}{"+div+"} $ cm <br>" +
								"And hypotenuse is given as $\\dfrac{"+Chr3[nim]+"}{"+div+"}$ cm <br>" +
								"For right angle triangle, by using Pythagorus Theorem, we get<br>" +
								"Base$^2 +$ Altitude $^2 =$ Hypotenus$^2$<br>" +
								"$\\therefore "+var1[p]+"^2+(\\dfrac {"+div+""+var1[p]+"+"+diff+"}{"+div+"})^2=(\\dfrac{"+Chr3[nim]+"}{"+div+"})^2$ . . . .  by Pythagoras theorem <br>" +
								"$\\therefore "+div*div+""+var1[p]+"^2+("+div+""+var1[p]+"+"+diff+")^2 ="+Chr3[nim]+"$ <br>" +
								"$\\therefore "+div*div+""+var1[p]+"^2+"+div*div+""+var1[p]+"^2+"+2*div*diff+""+var1[p]+"+"+diff*diff+" = "+Chr3[nim]*Chr3[nim]+"$ <br>" +
								"$\\therefore "+2*div*div+""+var1[p]+"^2+"+2*div*diff+""+var1[p]+""+(term1==Math.abs(term1) ? "+":"-")+Math.abs(term1)+"=0$ <br>" +
								"$\\therefore "+(2*div*div)/gcd3+""+var1[p]+"^2+"+(2*div*diff)/gcd3+""+var1[p]+""+(term1==Math.abs(term1) ? "+":"-")+(Math.abs(term1)/gcd3)+"=0$ <br>" +
								"$\\therefore 2"+var1[p]+"^2 -12"+var1[p]+"+9"+var1[p]+"-54=0$ <br>" +
								"$\\therefore 2"+var1[p]+"("+var1[p]+"-6)+9("+var1[p]+"-6)=0$ <br>" +
								"$\\therefore ("+var1[p]+"-6)(2"+var1[p]+"+9)=0$ <br>" +
								"$\\therefore "+var1[p]+"-6=0$ or $2"+var1[p]+"+9=0$ <br>" +
								"$\\therefore "+var1[p]+"=6$ or $"+var1[p]+"=-\\dfrac {9}{2}$ <br>" +
								"But $"+var1[p]+"=-\\dfrac {9}{2}$ is not possible (being length of side of a triangle) <br>" +
								"$\\therefore "+var1[p]+"=6$ cm is one side and <br>" +
								"Other side $="+var1[p]+"-\\dfrac {3}{2} = 6-\\dfrac {3}{2}=\\dfrac {9}{2}$ cm <br>" +
								"$\\therefore$ two sides of the triangle are $6$ cm and $\\dfrac {9}{2}$ cm is the answer. <br>";

			Sol1="#पायाची किंमत दिलेली नसल्यामुळे आपण पाया $"+var1[p]+"$ सेंमी आहे असे मानू. <br>" +
								"$\\therefore $ उंची $="+var1[p]+"-\\dfrac{3}{2}=\\dfrac {2"+var1[p]+"-3}{2} $ सेंमी <br>" +
								"आणि कर्णाची लांबी  $\\dfrac{15}{2}$ सेंमी आहे <br>" +
								"म्हणून या काटकोन त्रिकोणासाठी पायथागोरसच्या प्रमेया नुसार <br>" +
								"पाया $^2 +$ उंची $^2 = $ कर्ण $^2$ <br>" +
								"$\\therefore "+var1[p]+"^2+("+var1[p]+"-7)^2={13}^2$ . . . .  पायथागोरस प्रमेया नुसार <br>" +
								"$\\therefore 4"+var1[p]+"^2+(2"+var1[p]+"-3)^2 =225$ <br>" +
								"$\\therefore 4"+var1[p]+"^2+4"+var1[p]+"^2-12"+var1[p]+"+9 =225$ <br>" +
								"$\\therefore 8"+var1[p]+"^2-12"+var1[p]+"-216=0$ <br>" +
								"$\\therefore 2"+var1[p]+"^2-3"+var1[p]+"-54=0$ <br>" +
								"$\\therefore 2"+var1[p]+"^2 -12"+var1[p]+"+9"+var1[p]+"-54=0$ <br>" +
								"$\\therefore 2"+var1[p]+"("+var1[p]+"-6)+9("+var1[p]+"-6)=0$ <br>" +
								"$\\therefore  ("+var1[p]+"-6)(2"+var1[p]+"+9)=0$ <br>" +
								"$\\therefore "+var1[p]+"-6=0$ or $2"+var1[p]+"+9=0$ <br>" +
								"$\\therefore "+var1[p]+"=6$ or $"+var1[p]+"=-\\dfrac {9}{2}$ <br>" +
								"But $"+var1[p]+"=-\\dfrac {9}{2}$ हे शक्य नाही (कारण ती त्रिकोणाची बाजू आहे) <br>" +
								"$\\therefore "+var1[p]+"=6$ सेंमी ही एक बाजू आहे <br>" +
								"दुसरी बाजू  $="+var1[p]+"-\\dfrac {3}{2} = 6-\\dfrac {3}{2}=\\dfrac {9}{2}$ सेंमी <br>" +
								"उरलेल्या दोन बाजू ह्या $6$ सेंमी आणि $\\dfrac {9}{2}$ सेंमी आहेत हे उत्तर. <br>";
			
			
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
			row.createCell(18).setCellValue(122);

				
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
