
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class VESIT_030402_126_Assign3_Bhushan {

	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VESIT_030402_126_Assign3_Bhushan.xlsx";     //Location where excel file is getting generated
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
	  	     row.createCell(3).setCellValue("030402");

			ArrayList<String> powArr = new ArrayList<String>();
			ArrayList<String> sumarr = new ArrayList<String>();
			ArrayList<String> sumarrMar = new ArrayList<String>();


			int  [] powArr2=new int[4];
			String []var={"x","y","z"};
			Integer a,c,d;
			int k,m,p;
			String s1="";

			for (int i = 0; i < 4; i++)
			{
			k=(int) (Math.random() * 3)+1;
			p=(int) (Math.random() * 3);
			m=(int) (Math.random() * 3)+1;
			s1="";
			switch (k){
				case 1:
						do {
							a = (int) (Math.random() * 8)+1; // Generate random number between 1 and 8
						} while (contains(powArr2, a)); // Check if the number is already in the array
					
						if(a==1){
							//powArr.add(var[p]);
							s1=s1.concat(var[p]);
						}
						else{
							//powArr.add(var[p]+"^"+a.toString());
							s1=s1.concat(var[p]+"^"+a.toString());
						}
						powArr.add(s1);
						powArr2[i]=a;
						sumarr.add("$power of $"+var[p]);
						sumarrMar.add(""+var[p]+"$ चा घात $");


				break;
				
				case 2:
						if(m==1){
								do {
									a = (int) (Math.random() * 8)+1; // Generate random number between 1 and 8
									c = (int) (Math.random() * 8)+1;
									while(a+c>8)
									{
										a = (int) (Math.random() * 8)+1; 
										c = (int) (Math.random() * 8)+1;
									}
								} while (contains(powArr2, a+c)); // Check if the number is already in the array
							
								if(a==1){
									//powArr.add(var[0]);
									s1=s1.concat(var[0]);
								}
								else{
									//powArr.add("x^"+a.toString());
									s1=s1.concat("x^"+a.toString());
								}

								if(c==1){
									//powArr.add(var[1]);
									s1=s1.concat(var[1]);
								}
								else{
									//powArr.add("y^"+c.toString());
									s1=s1.concat("y^"+c.toString());
								}
								powArr.add(s1);
								powArr2[i]=a+c;
								sumarr.add("$power of $x + $power of $y = "+a.toString()+" + "+c.toString());
								sumarrMar.add("x$ चा घात $ + y$ चा घात $ = "+a.toString()+" + "+c.toString());

						}	
						else if(m==2){
										do {
											a = (int) (Math.random() * 8)+1; // Generate random number between 1 and 8
											c = (int) (Math.random() * 8)+1;
											while(a+c>8)
											{
												a = (int) (Math.random() * 8)+1; 
												c = (int) (Math.random() * 8)+1;
											}
										} while (contains(powArr2, a+c)); // Check if the number is already in the array
									
										if(a==1){
											//powArr.add(var[1]);
											s1=s1.concat(var[1]);
										}
										else{
											//powArr.add("y^"+a.toString());
											s1=s1.concat("y^"+a.toString());
										}

										if(c==1){
											//powArr.add(var[2]);
											s1=s1.concat(var[2]);
										}
										else{
											//powArr.add("z^"+c.toString());
											s1=s1.concat("z^"+c.toString());
										}
										powArr.add(s1);
										powArr2[i]=a+c;
										sumarr.add("$power of $y + $power of $z = "+a.toString()+" + "+c.toString());
										sumarrMar.add("y$ चा घात $ + z$ चा घात $ = "+a.toString()+" + "+c.toString());

								   }

						else{
								do {
									a = (int) (Math.random() * 8)+1; // Generate random number between 1 and 8
									c = (int) (Math.random() * 8)+1;
									while(a+c>8)
									{
										a = (int) (Math.random() * 8)+1; 
										c = (int) (Math.random() * 8)+1;
									}
								} while (contains(powArr2, a+c)); // Check if the number is already in the array
							
								if(a==1){
									//powArr.add(var[0]);
									s1=s1.concat(var[0]);
								}
								else{
									//powArr.add("x^"+a.toString());
									s1=s1.concat("x^"+a.toString());
								}

								if(c==1){
									//powArr.add(var[2]);
									s1=s1.concat(var[2]);
								}
								else{
									//powArr.add("z^"+c.toString());
									s1=s1.concat("z^"+c.toString());
								}

								powArr.add(s1);
								powArr2[i]=a+c;
								sumarr.add("$power of $x + $power of $z = "+a.toString()+" + "+c.toString());
								sumarrMar.add("x$ चा घात $ + z$ चा घात $ = "+a.toString()+" + "+c.toString());

							}

				break;

				case 3:
						do {
							a = (int) (Math.random() * 8)+1; // Generate random number between 1 and 8
							c = (int) (Math.random() * 8)+1;
							d = (int) (Math.random() * 8)+1;
							while(a+c+d>8)
							{
								a = (int) (Math.random() * 8)+1; 
							    c = (int) (Math.random() * 8)+1;
								d = (int) (Math.random() * 8)+1;
							}
						} while (contains(powArr2, a+c+d)); // Check if the number is already in the array
					
						if(a==1){
							//powArr.add(var[0]);
							s1=s1.concat(var[0]);
						}
						else{
							//powArr.add("x^"+a.toString());
							s1=s1.concat("x^"+a.toString());
						}

						if(c==1){
							//powArr.add(var[1]);
							s1=s1.concat(var[1]);
						}
						else{
							//powArr.add("y^"+c.toString());
							s1=s1.concat("y^"+c.toString());
						}
						
						if(d==1){
							//powArr.add(var[2]);
							s1=s1.concat(var[2]);
						}
						else{
							//powArr.add("z^"+d.toString());
							s1=s1.concat("z^"+d.toString());
						}
						powArr.add(s1);
						powArr2[i]=a+c+d;
						sumarr.add("$power of $x + $power of $y + $power of $z = "+a.toString()+" + "+c.toString()+" + "+d.toString());
						sumarrMar.add("x$ चा घात $ + y$ चा घात $+ z$ चा घात $ = "+a.toString()+" + "+c.toString()+" + "+d.toString());
				break;


			}
		   }
		//    System.out.println(Arrays.toString(powArr2));
		//    System.out.println(powArr);

	
			ArrayList<String> coeffArr = new ArrayList<String>();
			//int coeffArr2 [];
			Integer b;
			for (int i = 0; i < 3; i++) {
				b = (int) (Math.random() * 19)+1;
				if(b==1){
					coeffArr.add("");
				}
				else{
					coeffArr.add(b.toString());
				}
				//coeffArr2[i]=b;
			}
			
	
			String Que,Que1,Solu,Solu1,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2;
	
			int h=(int)(Math.random()*4);
			int e=(int)(Math.random()*4);
			int f=(int)(Math.random()*4);
			int g=(int)(Math.random()*4);
          
			while(h==e || h==f || h==g || e==f || e==g || f==g )
			{
			 h=(int)(Math.random()*4);
			 e=(int)(Math.random()*4);
			 f=(int)(Math.random()*4);
			 g=(int)(Math.random()*4);
			}
			Integer same;
			same=powArr2[h];
			if(powArr2[h]==1)
			{
				coeffArr.add("");
			}
			else{
				coeffArr.add(same.toString());
			}
			
			if((coeffArr.get(h)).equals("")){
				Correct_ans="$"+coeffArr.get(g)+powArr.get(h)+"$ <br>";
				wrong_ans="$"+coeffArr.get(e)+powArr.get(e)+"$ <br>";
				wrong_ans1="$"+coeffArr.get(f)+powArr.get(f)+"$ <br>";
				wrong_ans2="$"+""+powArr.get(g)+"$ <br>";	
			}
			else if((coeffArr.get(h)).equals(same.toString()))
			{
				Correct_ans="$"+coeffArr.get(g)+powArr.get(h)+"$ <br>";
				wrong_ans="$"+coeffArr.get(e)+powArr.get(e)+"$ <br>";
				wrong_ans1="$"+coeffArr.get(f)+powArr.get(f)+"$ <br>";
				wrong_ans2="$"+coeffArr.get(h)+powArr.get(g)+"$ <br>";	
			}
			else
			{
			Correct_ans="$"+coeffArr.get(h)+powArr.get(h)+"$ <br>";
			wrong_ans="$"+coeffArr.get(e)+powArr.get(e)+"$ <br>";
            wrong_ans1="$"+coeffArr.get(f)+powArr.get(f)+"$ <br>";
            wrong_ans2="$"+coeffArr.get(g)+powArr.get(g)+"$ <br>";
			}
			Que="From the given set of terms identify the term with degree $"+powArr2[h]+"$ <br>";
			Que1="#पुढे दिलेल्या पदांपैकी कोटी $"+powArr2[h]+"$ असणारे पद ओळखा <br>";
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
      
			if((coeffArr.get(h)).equals("")){
				Solu ="Ans : $"+coeffArr.get(g)+powArr.get(h)+"$ <br>For a term with one variable, the degree is the variable's exponent. With more than one variable, the degree is the sum of the exponents of all variables.<br> Accordingly, $"+coeffArr.get(g)+powArr.get(h)+"$ this term has the degree $"+powArr2[h]+"$ , <br> because degree of $"+coeffArr.get(g)+powArr.get(h)+" = "+sumarr.get(h)+" = "+powArr2[h]+"$ <br> $ \\therefore "+coeffArr.get(g)+powArr.get(h)+"$ is the term with degree $"+powArr2[h]+"$ is the answer. <br>";
				Solu1 ="#उत्तर : $"+coeffArr.get(g)+powArr.get(h)+"$ <br> पद जर एका चलातील असेल तर त्या चलाचा घातांक हाच त्या पदाची कोटी असते. पद जर एकापेक्षा अधिक चलातील असेल तर सर्व चलांच्या घातांकांची बेरीज ही त्या पदाची कोटी असते. <br> या नुसार $"+coeffArr.get(g)+powArr.get(h)+"$ या पदाचा घातांक $"+powArr2[h]+"$ आहे, कारण $"+coeffArr.get(g)+powArr.get(h)+"$ या पदाचा घातांक $ = "+sumarrMar.get(h)+" = "+powArr2[h]+"$ <br> म्हणून $"+powArr2[h]+"$ कोटी असलेले पद $"+coeffArr.get(g)+powArr.get(h)+"$ हे आहे, हे उत्तर. <br>";  
			}
			else if((coeffArr.get(h)).equals(same.toString()))
			{
			  Solu ="Ans : $"+coeffArr.get(g)+powArr.get(h)+"$ <br>For a term with one variable, the degree is the variable's exponent. With more than one variable, the degree is the sum of the exponents of all variables.<br> Accordingly, $"+coeffArr.get(g)+powArr.get(h)+"$ this term has the degree $"+powArr2[h]+"$ , <br> because degree of $"+coeffArr.get(g)+powArr.get(h)+" = "+sumarr.get(h)+" = "+powArr2[h]+"$ <br> $ \\therefore "+coeffArr.get(g)+powArr.get(h)+"$ is the term with degree $"+powArr2[h]+"$ is the answer. <br>";
			  Solu1 ="#उत्तर : $"+coeffArr.get(g)+powArr.get(h)+"$ <br> पद जर एका चलातील असेल तर त्या चलाचा घातांक हाच त्या पदाची कोटी असते. पद जर एकापेक्षा अधिक चलातील असेल तर सर्व चलांच्या घातांकांची बेरीज ही त्या पदाची कोटी असते. <br> या नुसार $"+coeffArr.get(g)+powArr.get(h)+"$ या पदाचा घातांक $"+powArr2[h]+"$ आहे, कारण $"+coeffArr.get(g)+powArr.get(h)+"$ या पदाचा घातांक $ = "+sumarrMar.get(h)+" = "+powArr2[h]+"$ <br> म्हणून $"+powArr2[h]+"$ कोटी असलेले पद $"+coeffArr.get(g)+powArr.get(h)+"$ हे आहे, हे उत्तर. <br>";  
			}
			else{
			   Solu ="Ans : $"+coeffArr.get(h)+powArr.get(h)+"$ <br>For a term with one variable, the degree is the variable's exponent. With more than one variable, the degree is the sum of the exponents of all variables.<br> Accordingly, $"+coeffArr.get(h)+powArr.get(h)+"$ this term has the degree $"+powArr2[h]+"$ , <br> because degree of $"+coeffArr.get(h)+powArr.get(h)+" = "+sumarr.get(h)+" = "+powArr2[h]+"$ <br> $ \\therefore "+coeffArr.get(h)+powArr.get(h)+"$ is the term with degree $"+powArr2[h]+"$ is the answer. <br>";
			   Solu1 ="#उत्तर : $"+coeffArr.get(h)+powArr.get(h)+"$ <br> पद जर एका चलातील असेल तर त्या चलाचा घातांक हाच त्या पदाची कोटी असते. पद जर एकापेक्षा अधिक चलातील असेल तर सर्व चलांच्या घातांकांची बेरीज ही त्या पदाची कोटी असते. <br> या नुसार $"+coeffArr.get(h)+powArr.get(h)+"$ या पदाचा घातांक $"+powArr2[h]+"$ आहे, कारण $"+coeffArr.get(h)+powArr.get(h)+"$ या पदाचा घातांक $ = "+sumarrMar.get(h)+" = "+powArr2[h]+"$ <br> म्हणून $"+powArr2[h]+"$ कोटी असलेले पद $"+coeffArr.get(h)+powArr.get(h)+"$ हे आहे, हे उत्तर. <br>";  
			}	

            String Solution = ""+Solu+" "+Solu1+"";	
        
        
        row.createCell(16).setCellValue(Solution);
//				  row.createCell(17).setCellValue(" ");
				  row.createCell(18).setCellValue(126);

          

String Checker =""+Solution+""+Correct_ans+""+wrong_ans+""+wrong_ans1+""+wrong_ans2+"";
                    mapsize = map.size();
					map.put(Checker,j);
				    mapsizeafter = map.size();
				
                //In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
				if(mapsize == mapsizeafter) {
					System.out.println(Checker);
					j--;
				}
				
				//  if(a==b||a==c||a==d||b==c||b==d||c==d) {
				// 		System.out.println("duplicate"+ j);  
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
	   // Define the contains method to check if an array contains a specific value
	   private static boolean contains(int[] arr, int targetValue) {
        for (int s : arr) {
            if (s == targetValue) {
                return true;
            }
        }
        return false;
    }

	
}