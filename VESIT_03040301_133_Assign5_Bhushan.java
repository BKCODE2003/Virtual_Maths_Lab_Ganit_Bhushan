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

public class VESIT_03040301_133_Assign5_Bhushan {

	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VESIT_03040301_133_Assign5_Bhushan.xlsx";     //Location where excel file is getting generated
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
			int[] probabilities = {70, 30}; // Probabilities for ch: 0, 1

			
			for (int j=1;j<q+1;j++)
		 {
			XSSFRow row = sheet1.createRow(j);
						row.createCell(0).setCellValue(j); 
						row.createCell(1).setCellValue("Text"); 
						row.createCell(2).setCellValue(1);
						row.createCell(3).setCellValue("03040301");


						


						ArrayList<String> powArr = new ArrayList<String>();
						ArrayList<String> powArr2 = new ArrayList<String>();
						
					
						String []var={"a", "b", "c", "d", "f", "g", "h", "m", "n", "p", "s", "t", "u", "v", "w", "x", "y", "z"};
						
						Integer a,c,b1,b2,b3,b4,V1,V2,V3,V4,absb1,absb2,absb3,absb4;
						int p;
						String s1="";
						String s2="";
						String s3="";
						String s4="";
						String s5="";

						p=(int) (Math.random() * 18);
					
						
						
						//Variables for question

						
						a = (int) (Math.random() * 3)+1; // Generate random number between 1 and 3
						c = (int) (Math.random() * 3)+1;
						while(a==c)
						{
							a = (int) (Math.random() * 3)+1; 
							c = (int) (Math.random() * 3)+1;
						}
				
						do{
							b1 = (int) (Math.random() * 100)-50;
							b2 = (int) (Math.random() * 100)-50;
							b3 = (int) (Math.random() * 100)-50;
							b4 = (int) (Math.random() * 100)-50;
						}while(b1==0 || b2==0 || b3==0 || b4==0);
				
					
						if(a==1){
							powArr.add(var[p]);	
						}
						else{
							powArr.add(var[p]+"^"+a.toString());
						}
					
						if(c==1){
							powArr.add(var[p]);
						}
						else{
							powArr.add(var[p]+"^"+c.toString()); 
						}
					    //powArr2[i]=a+c;

						ArrayList<String> coeffArr = new ArrayList<String>();
						
						//Coefficient for question

						if(b1==1 || b1==-1){
							coeffArr.add("");
						}
						else{
							absb1=Math.abs(b1);
							coeffArr.add(absb1.toString());
						}

						if(b2==1 || b2==-1){
							coeffArr.add("");
						}
						else{
							absb2=Math.abs(b2);
							coeffArr.add(absb2.toString());
						}

						if(b3==1 || b3==-1){
							coeffArr.add("");
						}
						else{
							absb3=Math.abs(b3);
							coeffArr.add(absb3.toString());
						}

						if(b4==1 || b4==-1){
							coeffArr.add("");
						}
						else{
							absb4=Math.abs(b4);
							coeffArr.add(absb4.toString());
						}


						// Vertical Addition for question

						if(b1==Math.abs(b1))
						{
							s1=s1.concat("&{} {}&"+coeffArr.get(0)+powArr.get(0));
						}
						else{
							s1=s1.concat("&{}-{}&"+coeffArr.get(0)+powArr.get(0));

						}

						
						if(b2==Math.abs(b2))
						{
							s1=s1.concat("&{}+{}&"+coeffArr.get(1)+powArr.get(1));
						}
						else{
							s1=s1.concat("&{}-{}&"+coeffArr.get(1)+powArr.get(1));
						}

						
						if(b3==Math.abs(b3))
						{
							s2=s2.concat("&{} {}&"+coeffArr.get(2)+powArr.get(0));
						}
						else{
							s2=s2.concat("&{}-{}&"+coeffArr.get(2)+powArr.get(0));
						}

						
						if(b4==Math.abs(b4))
						{
							s2=s2.concat("&{}+{}&"+coeffArr.get(3)+powArr.get(1));
						}
						else{
							s2=s2.concat("&{}-{}&"+coeffArr.get(3)+powArr.get(1));
						}

						//Result for Solution
						V1=b1+b3;
						V2=b2+b4;
						V3=b1-b3;
						V4=b2-b4;

						if(V1==0){
							s3=s3.concat("&{} {}&"+V1);
							s4=s4.concat("");
						}
						else if(V1==Math.abs(V1))
						{
							
							if(V1==1){
								s4=s4.concat(powArr.get(0));
								s3=s3.concat("&{} {}&"+powArr.get(0));
							}
							else{
								s4=s4.concat(V1+powArr.get(0));
								s3=s3.concat("&{} {}&"+V1+powArr.get(0));
							}
							
						}
						else{
							
							if(V1==-1){
								s4=s4.concat("-"+powArr.get(0));
								s3=s3.concat("&{}-{}&"+powArr.get(0));
							}
							else{
								s4=s4.concat(V1+powArr.get(0));
								s3=s3.concat("&{}-{}&"+(-V1)+powArr.get(0));
							}
						}

						if(V2==0){
							s3=s3.concat("&{} {}&"+V2);
							s4=s4.concat("");
						}
						else if(V2==Math.abs(V2))
						{
							if(V2==1){
								s3=s3.concat("&{}+{}&"+powArr.get(1));
							}
							else{
								s3=s3.concat("&{}+{}&"+V2+powArr.get(1));
							}

							if(V1==0){
								if(V2==1){
									s4=s4.concat(powArr.get(1));
								}
								else{
									s4=s4.concat(V2+powArr.get(1));
								}
							}
							else{
								if(V2==1){
									s4=s4.concat("+"+powArr.get(1));
								}
								else{
									s4=s4.concat("+"+V2+powArr.get(1));
								}
						   }
							
						}
						else{
							
							if(V2==-1){
								s3=s3.concat("&{}-{}&"+powArr.get(1));
								}
							else{
								s3=s3.concat("&{}-{}&"+(-V2)+powArr.get(1));
							}

							if(V2==-1){
								s4=s4.concat("-"+powArr.get(1));
							}
							else{
								s4=s4.concat(V2+powArr.get(1));
							}
							
						}

						
						
						powArr2.add(s1);
						powArr2.add(s2);
						powArr2.add(s3);
						
						if(V3==0){
							s5=s5.concat("");
						}
						else if(V3==Math.abs(V3))
						{
							if(V3==1){
								s5=s5.concat(powArr.get(0));
							}
							else{
								s5=s5.concat(V3+powArr.get(0));
							}
							
						}
						else{
							if(V3==-1){
								s5=s5.concat("-"+powArr.get(0));
							}
							else{
								s5=s5.concat(V3+powArr.get(0));
							}
						}

						if(V4==0){
							
							s5=s5.concat("");
						}
						else if(V4==Math.abs(V4))
						{
							if(V3==0){
								if(V4==1){
									s5=s5.concat(powArr.get(1));
								}
								else{
									s5=s5.concat(V4+powArr.get(1));
								}
							}
							else{
								if(V4==1){
									s5=s5.concat("+"+powArr.get(1));
								}
								else{
									s5=s5.concat("+"+V4+powArr.get(1));
								}
						    }
							
						}
						else{
							
							if(V4==-1){
								s5=s5.concat("-"+powArr.get(1));
							}
							else{
								s5=s5.concat(V4+powArr.get(1));
							}
							
						}
						

						ArrayList<String> coeffArr2 = new ArrayList<String>();
						//int ch=(int) (Math.random() *3);
						// Generate random number based on probabilities
						int rand = random.nextInt(100); // Generate random number between 0 and 99
						int ch = getChBasedOnProbabilities(rand, probabilities);
						if(ch==0){
							if(b1==1){
								coeffArr2.add("");
							}
							else if(b1==-1){
								coeffArr2.add("-");
							}
							else{
								coeffArr2.add(b1.toString());
							}

							if(b2==1){
								coeffArr2.add("+");
							}
							else if(b2==-1){
								coeffArr2.add("-");
							}
							else{
							if(b2==Math.abs(b2)){
								coeffArr2.add("+"+b2.toString());
							}
							else{
								coeffArr2.add(b2.toString());
							}
								
							}

							if(b3==1){
								coeffArr2.add("");
							}
							else if(b3==-1){
								coeffArr2.add("-");
							}
							else{
								coeffArr2.add(b3.toString());
							}

							if(b4==1){
								coeffArr2.add("+");
							}
							else if(b4==-1){
								coeffArr2.add("-");
							}
							else{
								if(b4==Math.abs(b4)){
									coeffArr2.add("+"+b4.toString());
								}
								else{
									coeffArr2.add(b4.toString());
								}	
							}

					    }
						else {
							if(b1==1){
								coeffArr2.add("");
							}
							else if(b1==-1){
								coeffArr2.add("-");
							}
							else{
								coeffArr2.add(b1.toString());
							}

							if(b2==1){
								coeffArr2.add("+");
							}
							else if(b2==-1){
								coeffArr2.add("-");
							}
							else{
							if(b2==Math.abs(b2)){
								coeffArr2.add("+"+b2.toString());
							}
							else{
								coeffArr2.add(b2.toString());
							}
								
							}

							if(b3==1){
								coeffArr2.add("+");
							}
							else if(b3==-1){
								coeffArr2.add("-");
							}
							else{
								if(b3==Math.abs(b3)){
									coeffArr2.add("+"+b3.toString());
								}
								else{
									coeffArr2.add(b3.toString());
								}	
								
							}

							if(b4==1){
								coeffArr2.add("");
							}
							else if(b4==-1){
								coeffArr2.add("-");
							}
							else{
								coeffArr2.add(b4.toString());
							}

						}
						// else if(ch==1){
							// 	if(b1==1){
							// 		coeffArr2.add("+");
							// 	}
							// 	else if(b1==-1){
							// 		coeffArr2.add("-");
							// 	}
							// 	else{
							// 		if(b1==Math.abs(b1)){
							// 			coeffArr2.add("+"+b1.toString());
							// 		}
							// 		else{
							// 			coeffArr2.add(b1.toString());
							// 		}
									
							// 	}
	
							// 	if(b2==1){
							// 		coeffArr2.add("");
							// 	}
							// 	else if(b2==-1){
							// 		coeffArr2.add("-");
							// 	}
							// 	else{
							// 		coeffArr2.add(b2.toString());	
							// 	}
	
							// 	if(b3==1){
							// 		coeffArr2.add("");
							// 	}
							// 	else if(b3==-1){
							// 		coeffArr2.add("-");
							// 	}
							// 	else{
							// 		coeffArr2.add(b3.toString());
							// 	}
	
							// 	if(b4==1){
							// 		coeffArr2.add("+");
							// 	}
							// 	else if(b4==-1){
							// 		coeffArr2.add("-");
							// 	}
							// 	else{
							// 		if(b4==Math.abs(b4)){
							// 			coeffArr2.add("+"+b4.toString());
							// 		}
							// 		else{
							// 			coeffArr2.add(b4.toString());
							// 		}	
							// 	}
	
							// }

						coeffArr2.add(s4);//final result
						coeffArr2.add(s5);//final result

					
						String Que,Que1,Solu,Solu1,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2;

						if(ch==0){
							Que="Perform the addition vertically <br>$("+coeffArr2.get(0)+powArr.get(0)+coeffArr2.get(1)+powArr.get(1)+")+("+coeffArr2.get(2)+powArr.get(0)+coeffArr2.get(3)+powArr.get(1)+")$ .<br>";
							Que1="#दिलेली बेरीज उभ्या मांडणीने करा <br> $("+coeffArr2.get(0)+powArr.get(0)+coeffArr2.get(1)+powArr.get(1)+")+("+coeffArr2.get(2)+powArr.get(0)+coeffArr2.get(3)+powArr.get(1)+")$ .<br>";
						}
						else{
							Que="Perform the addition vertically <br>$("+coeffArr2.get(0)+powArr.get(0)+coeffArr2.get(1)+powArr.get(1)+")+("+coeffArr2.get(3)+powArr.get(1)+coeffArr2.get(2)+powArr.get(0)+")$ .<br>";
							Que1="#दिलेली बेरीज उभ्या मांडणीने करा <br> $("+coeffArr2.get(0)+powArr.get(0)+coeffArr2.get(1)+powArr.get(1)+")+("+coeffArr2.get(3)+powArr.get(1)+coeffArr2.get(2)+powArr.get(0)+")$ .<br>";
	
						}
						// else if(ch==1){
						// 	Que="Perform the addition vertically <br>$("+coeffArr2.get(1)+powArr.get(1)+coeffArr2.get(0)+powArr.get(0)+")+("+coeffArr2.get(2)+powArr.get(0)+coeffArr2.get(3)+powArr.get(1)+")$ .<br>";
						// 	Que1="#दिलेली बेरीज उभ्या मांडणीने करा <br> $("+coeffArr2.get(1)+powArr.get(1)+coeffArr2.get(0)+powArr.get(0)+")+("+coeffArr2.get(2)+powArr.get(0)+coeffArr2.get(3)+powArr.get(1)+")$ .<br>";
	
						// }

						Solu="Ans: $"+coeffArr2.get(4)+"$<br> In case of vertical addition of algebraic expressions<br>$i)$ Write down like terms from both the expressions, one below another <br>$ii)$ If there is no corresponding like term leave the space as blank and use next column. <br>$iii)$ If for some term in second expression, we get a term which don't have a corresponding like term in first expression, then write that term in a new column.<br>$iv)$ After arranging terms in this fashion add coefficients of the terms in the column and write below them as result with the variable to get actual addition. <br>  $v)$ If it is subtraction, change the signs of all terms in second row and add corresponding terms in each row to get the answer.<br>By doing this we get the arrangement as shown <br>$\\begin{alignat*}{13}"+powArr2.get(0)+"\\\\+\\quad"+powArr2.get(1)+"&\\\\\\hline"+powArr2.get(2)+"& \\ \\ \\end{alignat*}$<br>$\\therefore$ $"+coeffArr2.get(4)+"$ is the answer.<br>";
						Solu1="#उत्तर: $"+coeffArr2.get(4)+"$<br> बैजिक राशींची उभी बेरीज करताना <br>$i)$ दोन्ही बैजिक राशींमधील सजातीय पदे एकाखाली एक लिहा. <br>$ii)$ ​जर वरच्या ओळीतील पदासाठी दुसऱ्या राशीत सजातीय पद नसेल तर ती जागा रिकामी सोडा. <br>$iii)$ जर दुसऱ्या राशीतील कोणत्याही पदासाठी वरील ओळीत (पहिल्या राशीत) सजातीय पद नसेल तर ​ते पद दुसऱ्या ओळीत नवीन रकान्यात लिहावे. <br>$iv)$ या पद्धतीने पदांची मांडणी केल्यानंतर त्या त्या रकान्यातील पदांच्या सहगुणकांची बेरीज करून त्याच रकान्याखाली ती बेरीज योग्य त्या चलासह लिहावी. <br>$v)$ वजाबाकी असल्यास दुसऱ्या ओळीतील सर्व पदांची चिन्हे बदलून प्रत्येक रकान्यातील पदांची बेरीज करून उत्तर काढावे. <br>या पद्धतीने आपल्याला पुढील मांडणी मिळते <br>$\\begin{alignat*}{13}"+powArr2.get(0)+"\\\\+\\quad"+powArr2.get(1)+"&\\\\\\hline"+powArr2.get(2)+"& \\ \\ \\end{alignat*}$<br>$\\therefore$ $"+coeffArr2.get(4)+"$ हे उत्तर.<br>";
						
						if(coeffArr2.get(4)==""){
							Correct_ans="$0$ <br>";
						}
						else{
						Correct_ans="$"+coeffArr2.get(4)+"$ <br>";
						}
						
						if(coeffArr2.get(5)==""){
							wrong_ans="$0$ <br>";
						}
						else{
						    wrong_ans="$"+coeffArr2.get(5)+"$ <br>";
						}
						if(a==1){
						  wrong_ans1="$"+coeffArr2.get(0)+powArr.get(0)+coeffArr2.get(1)+powArr.get(1)+"$ <br>";
						}
						else{
							wrong_ans1="$"+coeffArr2.get(2)+powArr.get(0)+coeffArr2.get(3)+powArr.get(1)+"$ <br>";
						}

						if(a==1){
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
						row.createCell(18).setCellValue(133);

						
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