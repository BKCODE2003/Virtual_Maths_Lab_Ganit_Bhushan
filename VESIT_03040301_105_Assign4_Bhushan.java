import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VESIT_03040301_105_Assign4_Bhushan {
	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VESIT_03040301_105_Assign4_Bhushan.xlsx";     //Location where excel file is getting generated
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
		
			for (int j=1;j<q+1;j++)
 		{
		

			XSSFRow row = sheet1.createRow(j);
					row.createCell(0).setCellValue(j); 
					row.createCell(1).setCellValue("Text"); 
					row.createCell(2).setCellValue(1);
					row.createCell(3).setCellValue("03040301");

					ArrayList<String> powArr = new ArrayList<String>();
					
					//int  [] powArr2=new int[2];
					String []var={"a", "b", "c", "d", "f", "g", "h", "m", "n", "p","s", "t", "u", "v", "w", "x", "y", "z"};
					Integer a,c;
					int k,p,m;
					String s1="";

					
					{
					k=(int) (Math.random() * 2)+1;
					p=(int) (Math.random() * 18);
					m=(int) (Math.random() * 17);
					s1="";
					switch (k){
						case 1:
								
								a = (int) (Math.random() * 4)+2; // Generate random number between 1 and 8
								
								s1=s1.concat(var[p]+"^"+a.toString());
								powArr.add(s1);

						break;
						
						case 2:
									{
										
											a = (int) (Math.random() * 3)+1; // Generate random number between 1 and 8
											c = (int) (Math.random() * 3)+1;
											while(a+c>5)
											{
												a = (int) (Math.random() * 3)+1; 
												c = (int) (Math.random() * 3)+1;
											}
										
										if(a==1){
										
											s1=s1.concat(var[m]);
										}
										else{
											
											s1=s1.concat(var[m]+"^"+a.toString());
										}

										if(c==1){
											
											s1=s1.concat(var[m+1]);
										}
										else{
											
											s1=s1.concat(var[m+1]+"^"+c.toString());
										}
										powArr.add(s1);
								
									}

						break;

						
					}
				}
				//   System.out.println(Arrays.toString(powArr2));
					

					ArrayList<String> coeffArr = new ArrayList<String>();
					
					//int coeffArr2 [];
					Integer b,b2;
						do{
							b  = (int) (Math.random() * 50);
							b2 = (int) (Math.random() * 50)-50;
						}while(b==0 || b2==0 || b>Math.abs(b2));

						if(b==1){
							coeffArr.add("");
						}
						else if(b==-1){
							coeffArr.add("-");
						}
						else{
							coeffArr.add(b.toString());
						}

						if(b2==1){
							coeffArr.add("");
						}
						else if(b2==-1){
							coeffArr.add("-");
						}
						else{
							coeffArr.add(b2.toString());
						}
						
						
			
					String Que,Que1,Solu,Solu1,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2;
			
				
					{
						
						if(b-Math.abs(b2)==-1){
												Correct_ans="$-"+powArr.get(0)+"$ <br>";
												}
						else if(b-Math.abs(b2)==0){
							Correct_ans="$"+(b-Math.abs(b2))+"$ <br>";
						}
						else {
								Correct_ans="$"+(b-Math.abs(b2))+powArr.get(0)+"$ <br>";
							}


						wrong_ans="$"+coeffArr.get(0)+powArr.get(0)+"$ <br>";
						wrong_ans1="$"+coeffArr.get(1)+powArr.get(0)+"$ <br>";

						if(b+Math.abs(b2)==-1){
							wrong_ans2="$-"+powArr.get(0)+"$ <br>";
												}
						else if(b+Math.abs(b2)==0){
							wrong_ans2="$"+(b+Math.abs(b2))+"$ <br>";
						}
						else {
							wrong_ans2="$"+(b+Math.abs(b2))+powArr.get(0)+"$ <br>";
							}
										

					} 

					//System.out.println(powArr);
					//System.out.println(coeffArr);

					Que="Addition of $"+coeffArr.get(0)+powArr.get(0)+"$ and $"+coeffArr.get(1)+powArr.get(0)+"$ is . . . . . <br>";
					Que1="#$"+coeffArr.get(0)+powArr.get(0)+"$ आणि $"+coeffArr.get(1)+powArr.get(0)+"$ यांची बेरीज . . . . . <br>";
					String Question=""+Que+" "+Que1+"";
			

					row.createCell(4).setCellValue(Question);
		//				 row.createCell(6).setCellValue(" ");
		//				 row.createCell(7).setCellValue(" ");
		//				 row.createCell(8).setCellValue(" ");
					row.createCell(5).setCellValue(Correct_ans);
					row.createCell(9).setCellValue(wrong_ans);
					row.createCell(10).setCellValue(wrong_ans1);
					row.createCell(11).setCellValue(wrong_ans2);
				
					row.createCell(12).setCellValue(60);
					row.createCell(13).setCellValue(1);
		//				  row.createCell(14).setCellValue(" ");
					row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
				{
						if(b-Math.abs(b2)==-1){
							Solu ="Ans : $-"+powArr.get(0)+"$<br>"
									+ "In case of addition or subtraction of algebraic expressions we need to add or subtract coefficients of like terms,"
									+ " to get the result and is written with the variable to get actual addition or subtraction. <br>"
									+ "In this case both terms are like terms. <br>"
									+ "$\\therefore "+coeffArr.get(0)+powArr.get(0)+" + ("+coeffArr.get(1)+(powArr.get(0))+")$ <br>"
									+ " $ = "+coeffArr.get(0)+powArr.get(0)+coeffArr.get(1)+powArr.get(0)+"$ . . . . . by opening the bracket <br>"
									+ " $ = ("+b+"-"+Math.abs(b2)+")"+powArr.get(0)+"$ . . . . . by adding the coefficients <br>"
									+ " $ = -"+powArr.get(0)+"$ is the answer. <br> ";	
						
							Solu1 ="#उत्तर : $-"+powArr.get(0)+"$<br>"
									+ "बैजिक राशींची बेरीज किंवा वजाबाकी करताना आपण सजातीय राशींच्या सहगुणकांची बेरीज अथवा वजाबाकी करून येणाऱ्या उत्तरासह चल लिहितो. <br>"
									+ "येथे दोन्ही पदे सजातीय आहेत. <br>"
									+ "$\\therefore "+coeffArr.get(0)+powArr.get(0)+" + ("+coeffArr.get(1)+(powArr.get(0))+")$ <br>"
									+ " $ = "+coeffArr.get(0)+powArr.get(0)+coeffArr.get(1)+powArr.get(0)+"$ . . . . . कंस उघडून <br>"
									+ " $ = ("+b+"-"+Math.abs(b2)+")"+powArr.get(0)+"$ . . . . . सहगुणकांची बेरीज करून <br>"
									+ " $ = -"+powArr.get(0)+"$ हे उत्तर. <br> ";	
						}
						else if(b-Math.abs(b2)==0){
						Solu ="Ans : $"+(b-Math.abs(b2))+"$<br>"
								+ "In case of addition or subtraction of algebraic expressions we need to add or subtract coefficients of like terms,"
								+ " to get the result and is written with the variable to get actual addition or subtraction. <br>"
								+ "In this case both terms are like terms. <br>"
								+ "$\\therefore "+coeffArr.get(0)+powArr.get(0)+" + ("+coeffArr.get(1)+(powArr.get(0))+")$ <br>"
								+ " $ = "+coeffArr.get(0)+powArr.get(0)+coeffArr.get(1)+powArr.get(0)+"$ . . . . . by opening the bracket <br>"
								+ " $ = ("+b+"-"+Math.abs(b2)+")"+powArr.get(0)+"$ . . . . . by adding the coefficients <br>"
								+"$="+(b-Math.abs(b2))+""+powArr.get(0)+"$ . . . .  coefficient being $0$<br>"
								+ " $ = "+(b-Math.abs(b2))+"$ is the answer. <br> ";
						Solu1 ="#उत्तर : $"+(b-Math.abs(b2))+"$<br>"
								+ "बैजिक राशींची बेरीज किंवा वजाबाकी करताना आपण सजातीय राशींच्या सहगुणकांची बेरीज अथवा वजाबाकी करून येणाऱ्या उत्तरासह चल लिहितो. <br>"
								+ "येथे दोन्ही पदे सजातीय आहेत. <br>"
								+ "$\\therefore "+coeffArr.get(0)+powArr.get(0)+" + ("+coeffArr.get(1)+(powArr.get(0))+")$ <br>"
								+ " $ = "+coeffArr.get(0)+powArr.get(0)+coeffArr.get(1)+powArr.get(0)+"$ . . . . . कंस उघडून <br>"
								+ " $ = ("+b+"-"+Math.abs(b2)+")"+powArr.get(0)+"$ . . . . .  सहगुणकांची बेरीज करून <br>"
								+"$="+(b-Math.abs(b2))+""+powArr.get(0)+"$ . . . .  सहगुणक $0$ असल्याने <br> "
								+ " $ = "+(b-Math.abs(b2))+"$ हे उत्तर. <br> ";
						}
						else{
						Solu ="Ans : $"+(b-Math.abs(b2))+powArr.get(0)+"$<br>"
								+ "In case of addition or subtraction of algebraic expressions we need to add or subtract coefficients of like terms, to get the result and is written with the variable to get actual addition or subtraction. <br>"
								+ "In this case both terms are like terms. <br>"
								+ "$\\therefore "+coeffArr.get(0)+powArr.get(0)+" + ("+coeffArr.get(1)+(powArr.get(0))+")$ <br>"
										+ " $ = "+coeffArr.get(0)+powArr.get(0)+coeffArr.get(1)+powArr.get(0)+"$ . . . . . by opening the bracket <br>"
												+ " $ = ("+b+"-"+Math.abs(b2)+")"+powArr.get(0)+"$ . . . . . by adding the coefficients <br> "
														+ "$ = "+(b-Math.abs(b2))+powArr.get(0)+"$ is the answer. <br> ";
						Solu1 ="#उत्तर : $"+(b-Math.abs(b2))+powArr.get(0)+"$<br>बैजिक राशींची बेरीज किंवा वजाबाकी करताना आपण सजातीय राशींच्या सहगुणकांची बेरीज अथवा वजाबाकी करून येणाऱ्या उत्तरासह चल लिहितो. <br>"
								+ "येथे दोन्ही पदे सजातीय आहेत. <br>$\\therefore "+coeffArr.get(0)+powArr.get(0)+" + ("+coeffArr.get(1)+(powArr.get(0))+")$ <br>"
								+ " $ = "+coeffArr.get(0)+powArr.get(0)+coeffArr.get(1)+powArr.get(0)+"$ . . . . . कंस उघडून <br>"
								+ " $ = ("+b+"-"+Math.abs(b2)+")"+powArr.get(0)+"$ . . . . . सहगुणकांची बेरीज करून <br>"
								+ " $ = "+(b-Math.abs(b2))+powArr.get(0)+"$ हे उत्तर. <br> ";
						}
					}
					
			

					String Solution = ""+Solu+" "+Solu1+"";	
				
				
					row.createCell(16).setCellValue(Solution);
		//				  row.createCell(17).setCellValue(" ");
						row.createCell(18).setCellValue(105);

				

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
}
