import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VESIT_03040303_125_Assign7_Bhushan { 

	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VESIT_03040303_125_Assign7_Bhushan.xlsx";     //Location where excel file is getting generated
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
		
		   
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of question :");
		int q=sc.nextInt();
			int mapsize,mapsizeafter;
			HashMap<String, Integer> map = new HashMap<String, Integer> ();

			Random random = new Random();
			int[] probabilities = {70,15,15}; // Probabilities for ch: 0, 1 ,2

			
			for (int j=1;j<q+1;j++)
		 {
			XSSFRow row = sheet1.createRow(j);
						row.createCell(0).setCellValue(j); 
						row.createCell(1).setCellValue("Text"); 
						row.createCell(2).setCellValue(1);
						row.createCell(3).setCellValue("03040303");


						


						
						ArrayList<String> powArr2 = new ArrayList<String>();
						
						String []var1={"a","c","g","l","m","p","r","s","u","v","x","y"};
        
						String []var2={"b","d","h","m","n","q","s","t","v","w","y","z"};
						int p=(int) (Math.random() * 12);
						
						ArrayList<String> powArr = new ArrayList<String>();
						
						powArr.add(var1[p]);
						powArr.add(var2[p]);
						powArr.add(var1[p]+var2[p]);
						powArr.add(var1[p]+"^2");
						powArr.add(var2[p]+"^2");
						powArr.add(var1[p]+var2[p]+"^2");
						powArr.add(var1[p]+"^2"+var2[p]);
						powArr.add(var1[p]+"^3");
						powArr.add(var2[p]+"^3");
					
						
						
						Integer a,b,c,d,b1,b2,b3,b4,b5,b6,b7,b8,V1,V2,V3,V4,V5,V6,V7,V8,absb1,absb2,absb3,absb4,absb5,absb6,absb7,absb8;
					
						String s1="";
						String s2="";
						String s3="";
						String s4="";
						String s5="";

					
						a = (int) (Math.random() * 9); 
						b = (int) (Math.random() * 9);
						c = (int) (Math.random() * 9); 
						d = (int) (Math.random() * 9);
						while(a==b||a==c||a==d||b==c||b==d||c==d)
						{
							a = (int) (Math.random() * 9); 
							b = (int) (Math.random() * 9);
							c = (int) (Math.random() * 9); 
							d = (int) (Math.random() * 9);
						}

				
						do{
							b1 = (int) (Math.random() * 50)-50;
							b2 = (int) (Math.random() * 50)-50;
							b3 = (int) (Math.random() * 50)-50;
							b4 = (int) (Math.random() * 50)-50;
							b5 = (int) (Math.random() * 50)-50;
							b6 = (int) (Math.random() * 50)-50;
							b7 = (int) (Math.random() * 50)-50;
							b8 = (int) (Math.random() * 50)-50;
						}while(b1==0 || b2==0 || b3==0 || b4==0 || b5==0 || b6==0 || b7==0 || b8==0);
				
					
						

						ArrayList<String> coeffArr = new ArrayList<String>();
						
						//Coefficient for question

						if(b1==-1){
							coeffArr.add("");
						}
						else{
							absb1=Math.abs(b1);
							coeffArr.add(absb1.toString());
						}

						if(b2==-1){
							coeffArr.add("");
						}
						else{
							absb2=Math.abs(b2);
							coeffArr.add(absb2.toString());
						}

						if(b3==-1){
							coeffArr.add("");
						}
						else{
							absb3=Math.abs(b3);
							coeffArr.add(absb3.toString());
						}

						if(b4==-1){
							coeffArr.add("");
						}
						else{
							absb4=Math.abs(b4);
							coeffArr.add(absb4.toString());
						}

						if(b5==-1){
							coeffArr.add("");
						}
						else{
							absb5=Math.abs(b5);
							coeffArr.add(absb5.toString());
						}

						if(b6==-1){
							coeffArr.add("");
						}
						else{
							absb6=Math.abs(b6);
							coeffArr.add(absb6.toString());
						}

						if(b7==-1){
							coeffArr.add("");
						}
						else{
							absb7=Math.abs(b7);
							coeffArr.add(absb7.toString());
						}

						if(b8==-1){
							coeffArr.add("");
						}
						else{
							absb8=Math.abs(b8);
							coeffArr.add(absb8.toString());
						}


							s1=s1.concat("&{}-{}&"+coeffArr.get(0)+powArr.get(a));

							s1=s1.concat("&{}-{}&"+coeffArr.get(1)+powArr.get(b));

							s1=s1.concat("&{}-{}&"+coeffArr.get(2)+powArr.get(c));

							s1=s1.concat("&{}-{}&"+coeffArr.get(3)+powArr.get(d));
					
							s2=s2.concat("&{}-{}&"+coeffArr.get(4)+powArr.get(a));
						
							s2=s2.concat("&{}-{}&"+coeffArr.get(5)+powArr.get(b));

							s2=s2.concat("&{}-{}&"+coeffArr.get(6)+powArr.get(c));
						
							s2=s2.concat("&{}-{}&"+coeffArr.get(7)+powArr.get(d));
						

						//Result for Solution
						V1=b1+b5;
						V2=b2+b6;
						V3=b3+b7;
						V4=b4+b8;

						V5=b1-b5;
						V6=b2-b6;
						V7=b3-b7;
						V8=b4-b8;

						if(V1==0){
							s3=s3.concat("&{} {}&"+V1);
							s4=s4.concat("");
						}
						else{
							
							if(V1==-1){
								s4=s4.concat("-"+powArr.get(a));
								s3=s3.concat("&{}-{}&"+powArr.get(a));
							}
							else{
								s4=s4.concat(V1+powArr.get(a));
								s3=s3.concat("&{}-{}&"+(-V1)+powArr.get(a));
							}
						}



						if(V2==0){
							s3=s3.concat("&{} {}&"+V2);
							s4=s4.concat("");
						}
						else{
							
							if(V2==-1){
								s4=s4.concat("-"+powArr.get(b));
								s3=s3.concat("&{}-{}&"+powArr.get(b));
							}
							else{
								s4=s4.concat(V2+powArr.get(b));
								s3=s3.concat("&{}-{}&"+(-V2)+powArr.get(b));
							}
						}

						if(V3==0){
							s3=s3.concat("&{} {}&"+V3);
							s4=s4.concat("");
						}
						else{
							
							if(V3==-1){
								s4=s4.concat("-"+powArr.get(c));
								s3=s3.concat("&{}-{}&"+powArr.get(c));
							}
							else{
								s4=s4.concat(V3+powArr.get(c));
								s3=s3.concat("&{}-{}&"+(-V3)+powArr.get(c));
							}
						}


						if(V4==0){
							s3=s3.concat("&{} {}&"+V4);
							s4=s4.concat("");
						}
						else{
							
							if(V4==-1){
								s4=s4.concat("-"+powArr.get(d));
								s3=s3.concat("&{}-{}&"+powArr.get(d));
							}
							else{
								s4=s4.concat(V4+powArr.get(d));
								s3=s3.concat("&{}-{}&"+(-V4)+powArr.get(d));
							}
						}
						
						
						powArr2.add(s1);
						powArr2.add(s2);
						powArr2.add(s3);
						
						if(V5==0){
							s5=s5.concat("");
						}
						else if(V5==Math.abs(V5))
						{
							if(V5==1){
								s5=s5.concat(powArr.get(a));
							}
							else{
								s5=s5.concat(V5+powArr.get(a));
							}
							
						}
						else{
							if(V5==-1){
								s5=s5.concat("-"+powArr.get(a));
							}
							else{
								s5=s5.concat(V5+powArr.get(a));
							}
						}


						if(V6==0){
							s5=s5.concat("");
						}
						else if(V6==Math.abs(V6))
						{
							if(V6==1){
								s5=s5.concat("+"+powArr.get(b));
							}
							else{
								s5=s5.concat("+"+V6+powArr.get(b));
							}
							
						}
						else{
							if(V6==-1){
								s5=s5.concat("-"+powArr.get(b));
							}
							else{
								s5=s5.concat(V6+powArr.get(b));
							}
						}


						if(V7==0){
							s5=s5.concat("");
						}
						else if(V7==Math.abs(V7))
						{
							if(V7==1){
								s5=s5.concat("+"+powArr.get(c));
							}
							else{
								s5=s5.concat("+"+V7+powArr.get(c));
							}
							
						}
						else{
							if(V7==-1){
								s5=s5.concat("-"+powArr.get(c));
							}
							else{
								s5=s5.concat(V7+powArr.get(c));
							}
						}


						if(V8==0){
							s5=s5.concat("");
						}
						else if(V8==Math.abs(V8))
						{
							if(V8==1){
								s5=s5.concat("+"+powArr.get(d));
							}
							else{
								s5=s5.concat("+"+V8+powArr.get(d));
							}
							
						}
						else{
							if(V8==-1){
								s5=s5.concat("-"+powArr.get(d));
							}
							else{
								s5=s5.concat(V8+powArr.get(d));
							}
						}
						

						ArrayList<String> coeffArr2 = new ArrayList<String>();
						//int ch=(int) (Math.random() *3);
						// Generate random number based on probabilities
						int rand = random.nextInt(100); // Generate random number between 0 and 99
						int ch = getChBasedOnProbabilities(rand, probabilities);
						
						if(b1==-1){
							coeffArr2.add("-");
						}
						else{
							coeffArr2.add(b1.toString());
						}

						if(b2==-1){
							coeffArr2.add("-");
						}
						else{
							coeffArr2.add(b2.toString());
						}
						
						if(b3==-1){
							coeffArr2.add("-");
						}
						else{
							coeffArr2.add(b3.toString());
						}

						if(b4==-1){
							coeffArr2.add("-");
						}
						else{
								coeffArr2.add(b4.toString());
						}	
						

						if(b5==-1){
							coeffArr2.add("-");
						}
						else{
							coeffArr2.add(b5.toString());
						}

						if(b6==-1){
							coeffArr2.add("-");
						}
						else{
							coeffArr2.add(b6.toString());
						}
						
						if(b7==-1){
							coeffArr2.add("-");
						}
						else{
							coeffArr2.add(b7.toString());
						}

						if(b8==-1){
							coeffArr2.add("-");
						}
						else{
								coeffArr2.add(b8.toString());
						}	

						coeffArr2.add(s4);//Correct final result
						coeffArr2.add(s5);//Wrong final result

					
						String Que,Que1,Solu,Solu1,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2;

						if(ch==0){
							Que="Add given algebraic expressions by vertical addition method<br> $("+coeffArr2.get(0)+powArr.get(a)+coeffArr2.get(1)+powArr.get(b)+coeffArr2.get(2)+powArr.get(c)+coeffArr2.get(3)+powArr.get(d)+")+("+coeffArr2.get(4)+powArr.get(a)+coeffArr2.get(5)+powArr.get(b)+coeffArr2.get(6)+powArr.get(c)+coeffArr2.get(7)+powArr.get(d)+")$ .<br>";
							Que1="#दिलेली राशींची बेरीज उभी मांडणी पद्धतीने करा <br> $("+coeffArr2.get(0)+powArr.get(a)+coeffArr2.get(1)+powArr.get(b)+coeffArr2.get(2)+powArr.get(c)+coeffArr2.get(3)+powArr.get(d)+")+("+coeffArr2.get(4)+powArr.get(a)+coeffArr2.get(5)+powArr.get(b)+coeffArr2.get(6)+powArr.get(c)+coeffArr2.get(7)+powArr.get(d)+")$ .<br>";
						}
						else if(ch==1){
							Que="Add given algebraic expressions by vertical addition method<br> $("+coeffArr2.get(0)+powArr.get(a)+coeffArr2.get(1)+powArr.get(b)+coeffArr2.get(2)+powArr.get(c)+coeffArr2.get(3)+powArr.get(d)+")+("+coeffArr2.get(7)+powArr.get(d)+coeffArr2.get(6)+powArr.get(c)+coeffArr2.get(4)+powArr.get(a)+coeffArr2.get(5)+powArr.get(b)+")$ .<br>";
							Que1="#दिलेली राशींची बेरीज उभी मांडणी पद्धतीने करा <br> $("+coeffArr2.get(0)+powArr.get(a)+coeffArr2.get(1)+powArr.get(b)+coeffArr2.get(2)+powArr.get(c)+coeffArr2.get(3)+powArr.get(d)+")+("+coeffArr2.get(7)+powArr.get(d)+coeffArr2.get(6)+powArr.get(c)+coeffArr2.get(4)+powArr.get(a)+coeffArr2.get(5)+powArr.get(b)+")$ .<br>";
						}
						else{
							Que="Add given algebraic expressions by vertical addition method<br> $("+coeffArr2.get(0)+powArr.get(a)+coeffArr2.get(1)+powArr.get(b)+coeffArr2.get(2)+powArr.get(c)+coeffArr2.get(3)+powArr.get(d)+")+("+coeffArr2.get(6)+powArr.get(c)+coeffArr2.get(7)+powArr.get(d)+coeffArr2.get(5)+powArr.get(b)+coeffArr2.get(4)+powArr.get(a)+")$ .<br>";
							Que1="#दिलेली राशींची बेरीज उभी मांडणी पद्धतीने करा <br> $("+coeffArr2.get(0)+powArr.get(a)+coeffArr2.get(1)+powArr.get(b)+coeffArr2.get(2)+powArr.get(c)+coeffArr2.get(3)+powArr.get(d)+")+("+coeffArr2.get(6)+powArr.get(c)+coeffArr2.get(7)+powArr.get(d)+coeffArr2.get(5)+powArr.get(b)+coeffArr2.get(4)+powArr.get(a)+")$ .<br>";
						}
						

						Solu="Ans: $"+coeffArr2.get(8)+"$<br>As per convention learnt previously about vertical addition, we will write like terms from both expression one below other and will use a new column for the next term. <br> Accordingly we get following arrangement, and then by adding vertically we get <br> $\\begin{alignat*}{13}"+powArr2.get(0)+"\\\\+\\quad"+powArr2.get(1)+"&\\\\\\hline"+powArr2.get(2)+"& \\ \\ \\end{alignat*}$<br>$\\therefore$ $"+coeffArr2.get(8)+"$ is the answer.<br>";
						Solu1="#उत्तर: $"+coeffArr2.get(8)+"$<br>आधीच्या भागात शिकल्यानुसार दोन्ही राशीतील सजातीय पदे एकाखाली एक लिहू आणि नवीन पद नव्या रकान्यात लिहून आपल्या खालील प्रमाणे रचना मिळेल. आता त्या त्या रकान्यातील पदांची उभी बेरीज करून  आपल्याला <br>$\\begin{alignat*}{13}"+powArr2.get(0)+"\\\\+\\quad"+powArr2.get(1)+"&\\\\\\hline"+powArr2.get(2)+"& \\ \\ \\end{alignat*}$<br>$\\therefore$ $"+coeffArr2.get(8)+"$ हे उत्तर.<br>";
						

						int cho=(int) (Math.random() * 2);

						if(coeffArr2.get(8)==""){
							Correct_ans="$0$ <br>";
						}
						else{
						Correct_ans="$"+coeffArr2.get(8)+"$ <br>";
						}
						
						if(coeffArr2.get(9)==""){
							wrong_ans="$0$ <br>";
						}
						else{
						    wrong_ans="$"+coeffArr2.get(9)+"$ <br>";
						}
						if(cho==0){
						  wrong_ans1="$"+coeffArr2.get(0)+powArr.get(a)+coeffArr2.get(1)+powArr.get(b)+coeffArr2.get(2)+powArr.get(c)+coeffArr2.get(3)+powArr.get(d)+"$ <br>";
						}
						else{
							wrong_ans1="$"+coeffArr2.get(6)+powArr.get(c)+coeffArr2.get(7)+powArr.get(d)+coeffArr2.get(5)+powArr.get(b)+coeffArr2.get(4)+powArr.get(a)+"$ <br>";
						}

						if(cho==0){
							wrong_ans2=" Nothing can be said <br> # काही सांगता येत नाही <br>";
						}
						else{
							wrong_ans2=" None of the given <br> # दिलेल्या पैकी कोणतेच नाही <br> ";
						}

						String Question=""+Que+" "+Que1+"";
						String Solution = ""+Solu+" "+Solu1+"";	

						row.createCell(4).setCellValue(Question);
			//				 row.createCell(6).setCellValue(" ");
			//				 row.createCell(7).setCellValue(" ");
			//				 row.createCell(8).setCellValue(" ");
						row.createCell(5).setCellValue(Correct_ans);
						row.createCell(9).setCellValue(wrong_ans);
						row.createCell(10).setCellValue(wrong_ans1);
						row.createCell(11).setCellValue(wrong_ans2);
					
						row.createCell(12).setCellValue(60);
						row.createCell(13).setCellValue(2);
			//				  row.createCell(14).setCellValue(" ");
						row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
						row.createCell(16).setCellValue(Solution);
			//				  row.createCell(17).setCellValue(" ");
						row.createCell(18).setCellValue(125);

						
			String Checker =""+Question+""+Solution+""+Correct_ans+""+wrong_ans+""+wrong_ans1+""+wrong_ans2+"";
			mapsize = map.size();
			map.put(Checker,j);
			mapsizeafter = map.size();
		
		//In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
		if(mapsize == mapsizeafter) {
			System.out.println(Checker);
			j--;
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
	// Method to get ch based on probabilities
    private static int getChBasedOnProbabilities(int rand, int[] probabilities) {
        int sum = 0;
        for (int i = 0; i < probabilities.length; i++) {
            sum += probabilities[i];
            if (rand < sum) {
                return i;
            }
        }
        return probabilities.length - 1; // Default to last value if rand exceeds sum of probabilities
    }

	
}