import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VESIT_03040302_138_Assign26_Bhushan {
	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VESIT_03040302_138_Assign26_Bhushan.xlsx";     //Location where excel file is getting generated
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
					row.createCell(3).setCellValue("03040302");

					ArrayList<String> powArr = new ArrayList<String>();
                    ArrayList<String> powArr138= new ArrayList<String>();
					
					//int  [] powArr2=new int[2];
					Integer a,c,a1,c1,a2,c2,a3,c3;

					String []var1={"a","c","g","l","m","p","r","s","u","v","x","y"};
        
					String []var2={"b","d","h","m","n","q","s","t","v","w","y","z"};
					int p=(int) (Math.random() * 12);

					int k;
					String s1="",s2="";

					
					{
					k=(int) (Math.random() * 2)+1;
					s1="";
                    s2="";
					switch (k){
						case 1:
                                int temp=(int) (Math.random() * 10);
								if(temp==1){
								    a = (int) (Math.random() * 4)+2; // Generate random number between 1 and 8
                                    s1=s1.concat(var1[p]+"^"+a.toString());
                                    powArr.add(s1);
                                }else{
                                    a = (int) (Math.random() * 3)+1; // Generate random number between 1 and 8
                                    c = (int) (Math.random() * 3)+1;
                                    while(a+c>5)
                                    {
                                        a = (int) (Math.random() * 3)+1; 
                                        c = (int) (Math.random() * 3)+1;
                                    }
                                    
                                    if(a==1){
                                    
                                        s1=s1.concat(var1[p]);
                                    }
                                    else{
                                        
                                        s1=s1.concat(var1[p]+"^"+a.toString());
                                    }

                                    if(c==1){
                                        
                                        s1=s1.concat(var2[p]);
                                    }
                                    else{
                                        
                                        s1=s1.concat(var2[p]+"^"+c.toString());
                                    }
                                    powArr.add(s1);
                                }


                                
										
                                a1 = (int) (Math.random() * 3)+1; // Generate random number between 1 and 8
                                c1 = (int) (Math.random() * 3)+1;
                                while(a1+c1>5)
                                {
                                    a1 = (int) (Math.random() * 3)+1; 
                                    c1 = (int) (Math.random() * 3)+1;
                                }
                            
                                if(a1==1){
                                
                                    s2=s2.concat(var1[p]);
                                }
                                else{
                                    
                                    s2=s2.concat(var1[p]+"^"+a1.toString());
                                }

                                if(c1==1){
                                    
                                    s2=s2.concat(var2[p]);
                                }
                                else{
                                    
                                    s2=s2.concat(var2[p]+"^"+c1.toString());
                                }
                                powArr138.add(s2);
                                s2="";
                                a3 = (int) (Math.random() * 3)+1; // Generate random number between 1 and 8
                                c3 = (int) (Math.random() * 3)+1;
                                while(a3+c3>5 || (a1==a3 &&c1==c3))
                                {
                                    a3 = (int) (Math.random() * 3)+1; 
                                    c3 = (int) (Math.random() * 3)+1;
                                }
                            
                                if(a3==1){
                                
                                    s2=s2.concat(var1[p]);
                                }
                                else{
                                    
                                    s2=s2.concat(var1[p]+"^"+a3.toString());
                                }

                                if(c3==1){
                                    
                                    s2=s2.concat(var2[p]);
                                }
                                else{
                                    
                                    s2=s2.concat(var2[p]+"^"+c3.toString());
                                }
                                powArr138.add(s2);
                                

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
										
											s1=s1.concat(var1[p]);
										}
										else{
											
											s1=s1.concat(var1[p]+"^"+a.toString());
										}

										if(c==1){
											
											s1=s1.concat(var2[p]);
										}
										else{
											
											s1=s1.concat(var2[p]+"^"+c.toString());
										}
										powArr.add(s1);
                                        s1="";
                                        a2 = (int) (Math.random() * 3)+1; // Generate random number between 1 and 8
                                        c2 = (int) (Math.random() * 3)+1;
                                        while(a2+c2>5|| (a==a2 && c==c2))
                                        {
                                            a2 = (int) (Math.random() * 3)+1; 
                                            c2 = (int) (Math.random() * 3)+1;
                                        }
                                    
                                        if(a2==1){
                                        
                                            s1=s1.concat(var1[p]);
                                        }
                                        else{
                                            
                                            s1=s1.concat(var1[p]+"^"+a2.toString());
                                        }

                                        if(c2==1){
                                            
                                            s1=s1.concat(var2[p]);
                                        }
                                        else{
                                            
                                            s1=s1.concat(var2[p]+"^"+c2.toString());
                                        }
                                        powArr.add(s1);


									
										
                                        a1 = (int) (Math.random() * 3)+1; // Generate random number between 1 and 8
                                        c1 = (int) (Math.random() * 3)+1;
                                        while(a1+c1>5)
                                        {
                                            a1 = (int) (Math.random() * 3)+1; 
                                            c1 = (int) (Math.random() * 3)+1;
                                        }
                                    
                                        if(a1==1){
                                        
                                            s2=s2.concat(var1[p]);
                                        }
                                        else{
                                            
                                            s2=s2.concat(var1[p]+"^"+a1.toString());
                                        }

                                        if(c1==1){
                                            
                                            s2=s2.concat(var2[p]);
                                        }
                                        else{
                                            
                                            s2=s2.concat(var2[p]+"^"+c1.toString());
                                        }
                                        powArr138.add(s2);
                                        s2="";
                                        a3 = (int) (Math.random() * 3)+1; // Generate random number between 1 and 8
                                        c3 = (int) (Math.random() * 3)+1;
                                        while(a3+c3>5|| (a1==a3 && c1==c3))
                                        {
                                            a3 = (int) (Math.random() * 3)+1; 
                                            c3 = (int) (Math.random() * 3)+1;
                                        }
                                    
                                        if(a3==1){
                                        
                                            s2=s2.concat(var1[p]);
                                        }
                                        else{
                                            
                                            s2=s2.concat(var1[p]+"^"+a3.toString());
                                        }

                                        if(c3==1){
                                            
                                            s2=s2.concat(var2[p]);
                                        }
                                        else{
                                            
                                            s2=s2.concat(var2[p]+"^"+c3.toString());
                                        }
                                        powArr138.add(s2);
                            
                                    }

						break;

						
					}
				}
				//   System.out.println(Arrays.toString(powArr2));
					

					ArrayList<String> coeffArr = new ArrayList<String>();
					
					//int coeffArr2 [];
					Integer b,b2,b3,b4;
						do{
							b  = (int) (Math.random() * 50);
							b2 = (int) (Math.random() * 50)-25;
						}while(b==0 || b2==0);

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
						

                        do{
							b3  = (int) (Math.random() * 50);
							b4 = (int) (Math.random() * 50)-25;
						}while(b3==0 || b4==0);

						if(b3==1){
							coeffArr.add("");
						}
						else if(b3==-1){
							coeffArr.add("-");
						}
						else{
							coeffArr.add(b3.toString());
						}

						if(b4==1){
							coeffArr.add("");
						}
						else if(b4==-1){
							coeffArr.add("-");
						}
						else{
							coeffArr.add(b4.toString());
						}
						
			
					String Que,Que1,Solu,Solu1,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,term1,term2,term3,term4,exp1,exp2,mainTerm;
                    term1="";
                    term2="";
                    term3="";
                    term4="";
                    exp1="";
                    exp2="";
                    mainTerm="";
					wrong_ans="";
					wrong_ans1="";
					wrong_ans2="";
                    if(k==1) {
                        term1=""+coeffArr.get(0)+powArr.get(0)+"";
                        // term2=""+coeffArr.get(1)+powArr.get(1)+"";
                        term3=""+coeffArr.get(2)+powArr138.get(0)+"";
                        term4=""+coeffArr.get(3)+powArr138.get(1)+"";
                    } 
                    else{
                        term1=""+coeffArr.get(0)+powArr.get(0)+"";
                        term2=""+coeffArr.get(1)+powArr.get(1)+"";
                        term3=""+coeffArr.get(2)+powArr138.get(0)+"";
                        term4=""+coeffArr.get(3)+powArr138.get(1)+"";
                    } 
                    

                    if(k==0) {
                        exp1=""+term1+"";
                        exp2=""+term3+(b4==Math.abs(b4) ? "+" :"")+term4+"";
                    } 
                    else{
                        exp1=""+term1+(b2==Math.abs(b2) ? "+" :"")+term2+"";
                        exp2=""+term3+(b4==Math.abs(b4) ? "+" :"")+term4+"";
                    }
                    // String Iam="";
                    // int selc=(int)(Math.random()*2);
                    int prevI=j;
                    if(k==1){
                        if((!powArr138.get(0).equals(powArr.get(0)))){
                            mainTerm=term3;
							// Iam=" K1 1";
							// System.out.println("K111111111111");
                        }else if((!powArr138.get(1).equals(powArr.get(0)))){
                            mainTerm=term4;
							// Iam=" K1 2";
							// System.out.println("K22222222222");
                        }
                        else{
                           j--; 
                        }

                    }else{
						// System.out.println(!powArr138.get(0).equals(powArr.get(0)));
						// System.out.println(!powArr138.get(0).equals(powArr.get(1)));

                        if((!powArr138.get(0).equals(powArr.get(0)))&&(!powArr138.get(0).equals(powArr.get(1)))){
                            mainTerm=term3;
							// Iam=" K2 1";
                        }else if((!powArr138.get(1).equals(powArr.get(0)))&&(!powArr138.get(1).equals(powArr.get(1)))){
                            mainTerm=term4;
							// Iam=" K2 2";
                        }
                        else{
                           j--; 
                        }
                    }
				
					Correct_ans="None of the Given"; 

                    if(!mainTerm.equals(term3)){
                        wrong_ans="$"+term3+"$";
						wrong_ans1="$"+term4+"$";
                    }else if(!mainTerm.equals(term4)){
                        wrong_ans="$"+term4+"$";
						wrong_ans1="$"+term3+"$";
                    }
                    
                    wrong_ans2="$"+term1+"$";
					// System.out.println("Powarr:["+powArr+"] Powarr138:["+powArr138+"] Mainterm:"+mainTerm+" Term3:"+term3+" Term4:"+term4+" J:"+j+"  Iam:"+Iam+"");
					// Iam="";
					//System.out.println(powArr);
					//System.out.println(coeffArr);
					Que="In vertical arrangement method for addition of $"+exp1+"$ and $"+exp2+"$ which term will appear above $"+mainTerm+"$ ? <br>";
					Que1="#उभी मांडणी पद्धतीने $"+exp1+"$ आणि $"+exp2+"$ या राशींची बेरीज करतांना $"+mainTerm+"$ या पदाच्या वर कोणते पद येईल? <br>";
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
					row.createCell(13).setCellValue(2);
		//				  row.createCell(14).setCellValue(" ");
					row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
					Solu="Ans : None of the given <br> In vertical arrangement method of addition, the like terms from all the given expressions are required to be written in one column. Accordingly for $"+mainTerm+"$ there is no like term in the first expression and hence 'None of the given' term will appear above $"+mainTerm+"$ in vertical arrangement method of addition. Hence, 'None of the given' is the answer.<br>";
					Solu1="#उत्तर : दिलेल्या पैकी एकही नाही <br>उभी मांडणी पद्धतीने बेरीज करतांना दिलेल्या सर्व बैजिक राशीतील सजातीय पदे एकाच रकान्यात लिहितात. त्यानुसार $"+mainTerm+"$ या पदाच्या रकान्यात पहिल्या राशीतील कोणतेही पद येणार नाही कारण पहिल्या राशीत $"+mainTerm+"$ या पदाला सजातीय पद कोणतेही नाही. म्हणून 'दिलेल्या पैकी एकही नाही' हे उत्तर. <br>";
					
			

					String Solution = ""+Solu+" "+Solu1+"";	
				
				
					row.createCell(16).setCellValue(Solution);
		//				  row.createCell(17).setCellValue(" ");
						row.createCell(18).setCellValue(138);

				

		String Checker =""+Question+""+Solution+""+Correct_ans+""+wrong_ans+""+wrong_ans1+""+wrong_ans2+"";
							mapsize = map.size();
							map.put(Checker,j);
							mapsizeafter = map.size();
						
						//In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
						
                        if(mapsize == mapsizeafter) {
							System.out.println(Checker);
                            if(prevI==j){
                                j--;
                            }
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
