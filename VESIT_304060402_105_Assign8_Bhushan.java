import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VESIT_304060402_105_Assign8_Bhushan {

    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VESIT_304060402_105_Assign8_Bhushan.xlsx";     //Location where excel file is getting generated
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
					row.createCell(3).setCellValue("304060402");
                    int z,a,b,c,d,num1,num2;
                    int val1,val2,val3;
                    String res1,res2,fres1,fres2;
                    do{
                         a=(int) (Math.random()*19)-9;
                         b=(int) (Math.random()*19)-9;
                         c=(int) (Math.random()*19)-9;
                         d=(int) (Math.random()*19)-9;
                        while(a==b||a==c||a==d||b==c||b==d||c==d||a==0||b==0||c==0||d==0){
                            a=(int) (Math.random()*19)-9;
                            b=(int) (Math.random()*19)-9;
                            c=(int) (Math.random()*19)-9;
                            d=(int) (Math.random()*19)-9;
                        }
                        
                         num1=(int) (Math.random()*41)-20;
                         num2=(int) (Math.random()*41)-20;
                        while(num1==0||num2==0){
                            num1=(int) (Math.random()*41)-20;
                            num2=(int) (Math.random()*41)-20;
                        }
                        z=d*a-b*c;
                        val1=d*num1-b*num2;
                        val2=num2*a-num1*c;
                        val3=d*a-b*c;

                    }while(z==0 || val1==0 ||val2==0 || val1%val3!=0 || val2%val3!=0 || num1+num2>100 || (a!=Math.abs(a) && b!=Math.abs(b)) || (c!=Math.abs(c) && d!=Math.abs(d)));

                    String []var1={"a","c","g","l","m","p","r","s","u","v","x","y"};
        
                    String []var2={"b","d","h","m","n","q","s","t","v","w","y","z"};
                    int p=(int) (Math.random() * 12);
                    int p2=(int) (Math.random() * 12);

                    while(p==p2){
                        p2=(int) (Math.random() * 12);
                    }

                    String Que1,Que2,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Solu,Solu1;
                    Que1="Solve : $"+(a==Math.abs(a) ? "":"-")+"\\dfrac{"+Math.abs(a)+"}{"+var1[p]+"}"+(b==Math.abs(b) ? "+":"-")+"\\dfrac{"+Math.abs(b)+"}{"+var2[p]+"} = "+num1+"; "+(c==Math.abs(c) ? "":"-")+"\\dfrac{"+Math.abs(c)+"}{"+var1[p]+"}"+(d==Math.abs(d) ? "+":"-")+"\\dfrac{"+Math.abs(d)+"}{"+var2[p]+"} = "+num2+" $ <br><br>";
                    Que2="#सोडवा : $"+(a==Math.abs(a) ? "":"-")+"\\dfrac{"+Math.abs(a)+"}{"+var1[p]+"}"+(b==Math.abs(b) ? "+":"-")+"\\dfrac{"+Math.abs(b)+"}{"+var2[p]+"} = "+num1+"; "+(c==Math.abs(c) ? "":"-")+"\\dfrac{"+Math.abs(c)+"}{"+var1[p]+"}"+(d==Math.abs(d) ? "+":"-")+"\\dfrac{"+Math.abs(d)+"}{"+var2[p]+"} = "+num2+" $ <br><br>";

                    String Question=""+Que1+""+Que2+"";
                     
                    //else part of below two is not of used but it can be used for answers in fraction in which have integer/integer but here we want only 1/integer.
                    // if want to remove else part remove else part and if part also just keep contents of if part in code .

                    if(val1%val3==0){
                        res1=""+(val1/val3)+"";
                        fres1=((val1/val3)==Math.abs((val1/val3)) ? "":"-")+(Math.abs((val1/val3))==1 ? "1" :"\\dfrac {1}{"+Math.abs((val1/val3))+"}");
                    }
                    else{
                       int n1=gcd(val1,val3);
                       res1=(((val1/n1)==Math.abs((val1/n1)) || (val3/n1)==Math.abs((val3/n1))) && !((val1/n1)==Math.abs((val1/n1)) && (val3/n1)==Math.abs((val3/n1))) ? "":"-")+"\\dfrac {"+Math.abs(val1/n1)+"}{"+Math.abs(val3/n1)+"}";
                       fres1=(((val1/n1)==Math.abs((val1/n1)) || (val3/n1)==Math.abs((val3/n1))) && !((val1/n1)==Math.abs((val1/n1)) && (val3/n1)==Math.abs((val3/n1))) ? "":"-")+"\\dfrac {"+Math.abs(val3/n1)+"}{"+Math.abs(val1/n1)+"}";
                      // System.out.println("1:"+j);
                    } 

                    if(val2%val3==0){
                        res2=""+(val2/val3)+"";
                        fres2=((val2/val3)==Math.abs((val2/val3)) ? "":"-")+(Math.abs((val2/val3))==1 ? "1" :"\\dfrac {1}{"+Math.abs((val2/val3))+"}");
                    }
                    else{
                        int n2=gcd(val2,val3);
                        res2=(((val2/n2)==Math.abs((val2/n2)) || (val3/n2)==Math.abs((val3/n2))) && !((val2/n2)==Math.abs((val2/n2)) && (val3/n2)==Math.abs((val3/n2))) ? "":"-")+"\\dfrac {"+Math.abs(val2/n2)+"}{"+Math.abs(val3/n2)+"}";
                        fres2=(((val2/n2)==Math.abs((val2/n2)) || (val3/n2)==Math.abs((val3/n2))) && !((val2/n2)==Math.abs((val2/n2)) && (val3/n2)==Math.abs((val3/n2))) ? "":"-")+"\\dfrac {"+Math.abs(val3/n2)+"}{"+Math.abs(val2/n2)+"}";
                       // System.out.println("2:"+j);
                    }

                   
                   Correct_ans="$"+var1[p]+" = "+fres1+"$ and $"+var2[p]+" = "+fres2+"$<br>#$"+var1[p]+" = "+fres1+"$ आणि $"+var2[p]+" = "+fres2+"$<br>";

                   if((fres1.equals("1") || fres1.equals("-1")) && (fres2.equals("1") || fres2.equals("-1")) || res1.equals(res2) ){
                    wrong_ans="$"+var1[p]+" = "+a+"$ and $"+var2[p]+" = "+d+"$<br>#$"+var1[p]+" = "+a+"$ आणि $"+var2[p]+" = "+d+"$<br>";
                    wrong_ans1="$"+var1[p]+" = "+(a+b)+"$ and $"+var2[p]+" = "+(c+d)+"$<br>#$"+var1[p]+" = "+fres2+"$ आणि $"+var2[p]+" = "+fres1+"$<br>";
                    wrong_ans2="$"+var1[p]+" = "+b+"$ and $"+var2[p]+" = "+c+"$<br>#$"+var1[p]+" = "+b+"$ आणि $"+var2[p]+" = "+c+"$<br>"; 
                    //System.err.println(j);
                   }
                   else{
                        wrong_ans="$"+var1[p]+" = "+res1+"$ and $"+var2[p]+" = "+res2+"$<br>#$"+var1[p]+" = "+res1+"$ आणि $"+var2[p]+" = "+res2+"$<br>";
                        wrong_ans1="$"+var1[p]+" = "+fres2+"$ and $"+var2[p]+" = "+fres1+"$<br>#$"+var1[p]+" = "+fres2+"$ आणि $"+var2[p]+" = "+fres1+"$<br>";
                        wrong_ans2="$"+var1[p]+" = "+res2+"$ and $"+var2[p]+" = "+res1+"$<br>#$"+var1[p]+" = "+res2+"$ आणि $"+var2[p]+" = "+res1+"$<br>"; 
                   }

					row.createCell(4).setCellValue(Question);
		//				 row.createCell(6).setCellValue(" ");
		//				 row.createCell(7).setCellValue(" ");
		//				 row.createCell(8).setCellValue(" ");
					row.createCell(5).setCellValue(Correct_ans);
					row.createCell(9).setCellValue(wrong_ans);
					row.createCell(10).setCellValue(wrong_ans1);
					row.createCell(11).setCellValue(wrong_ans2);
				
					row.createCell(12).setCellValue(120);
					row.createCell(13).setCellValue(4);
		//				  row.createCell(14).setCellValue(" ");
					row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			
                    Solu="Ans : $"+var1[p]+"="+fres1+"$ and $"+var2[p]+"="+fres2+"$<br> This problem can't be solved by conventional method, as both $"+var1[p]+"$ and $"+var2[p]+"$ are appearing in denominator.<br>Here we will use substitution as $\\dfrac{1}{"+var1[p]+"} = "+var1[p2]+"$ and $\\dfrac{1}{"+var2[p]+"} = "+var2[p2]+"$ for both the given equations.<br>Therefore substituting these values of $\\dfrac{1}{"+var1[p]+"}$ and $\\dfrac{1}{"+var2[p]+"}$ we get,<br>$"+(a==Math.abs(a) ? (a==1 ? "":Math.abs(a)) : (a==-1 ? "-" : a) )+var1[p2]+""+(b==Math.abs(b) ? (b==1 ? "+":"+"+Math.abs(b)) : (b==-1 ? "-" : b) )+var2[p2]+"="+num1+"$ and $"+(c==Math.abs(c) ? (c==1 ? "":Math.abs(c)) : (c==-1 ? "-" : c) )+var1[p2]+""+(d==Math.abs(d) ? (d==1 ? "+" :"+"+Math.abs(d)) : (d==-1 ? "-" : d) )+var2[p2]+"="+num2+"$<br>Now, by following usual method of elimination of one of the two variables, we get $"+var1[p2]+"="+res1+"$ and $"+var2[p2]+"="+res2+"$<br>Now, re-substituting values $"+var1[p2]+"$ and $"+var2[p2]+"$ in terms of $"+var1[p]+"$ and $"+var2[p]+"$, we get,<br>$\\dfrac{1}{"+var1[p]+"} = "+var1[p2]+" = "+res1+"$<br>$\\therefore "+var1[p]+"= "+fres1+"$ and<br>$\\dfrac{1}{"+var2[p]+"} = "+var2[p2]+"= "+res2+"$<br>$\\therefore  "+var2[p]+"= "+fres2+"$<br>$\\therefore "+var1[p]+"= "+fres1+"$ and $"+var2[p]+"= "+fres2+"$ is the answer.<br>";
                    Solu1="#उत्तर : $"+var1[p]+"="+fres1+"$ आणि $"+var2[p]+"="+fres2+"$<br>$"+var1[p]+"$ ​आणि $"+var2[p]+"$ हे दोन्ही चल छेद स्थानी असल्याने हे गणित नेहेमीच्या पद्धतीने सोडवता येणार नाही.<br> येथे आपण $\\dfrac{1}{"+var1[p]+"} = "+var1[p2]+"$ आणि $\\dfrac{1}{"+var2[p]+"} = "+var2[p2]+"$ अशा किमती ठेवू.<br>म्हणून$\\dfrac{1}{"+var1[p]+"}$ आणि $\\dfrac{1}{"+var2[p]+"}$ ​च्या अशा किमती ​दिलेल्या समिकरणात ​ठेऊन आपल्याला <br>$"+(a==Math.abs(a) ? (a==1 ? "":Math.abs(a)) : (a==-1 ? "-" : a) )+var1[p2]+""+(b==Math.abs(b) ? (b==1 ? "+" :"+"+Math.abs(b)) : (b==-1 ? "-" : b) )+var2[p2]+"="+num1+"$ आणि $"+(c==Math.abs(c) ? (c==1 ? "" : Math.abs(c)) : (c==-1 ? "-" : c) )+var1[p2]+""+(d==Math.abs(d) ? (d==1 ? "+" :"+"+Math.abs(d)) : (d==-1 ? "-" : d) )+var2[p2]+"="+num2+"$ अशी नवीन समीकरणे मिळतात. <br>​आता नेहेमीची एका चलाचा लोप करण्याची ​पद्धत वापरून आपल्याला $"+var1[p2]+"="+res1+"$ आणि $"+var2[p2]+"="+res2+"$ असे मिळते, <br>​आता $"+var1[p2]+"$ आणि $"+var2[p2]+"$ ​च्या किमती पुन्हा $"+var1[p]+"$ आणि $"+var2[p]+"$, च्या रूपात लिहून आपल्याला <br>$\\dfrac{1}{"+var1[p]+"} = "+var1[p2]+" = "+res1+"$<br>$\\therefore "+var1[p]+"= "+fres1+"$ ​आणि <br>$\\dfrac{1}{"+var2[p]+"} = "+var2[p2]+"= "+res2+"$<br>$\\therefore  "+var2[p]+"= "+fres2+"$<br>$\\therefore "+var1[p]+"= "+fres1+"$ आणि $"+var2[p]+"= "+fres2+"$ ​हे उत्तर आहे.<br>";

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