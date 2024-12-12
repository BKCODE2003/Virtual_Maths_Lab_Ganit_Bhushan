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
			int b=(int)(Math.random()*20);
			while(a==b){
				b=(int)(Math.random()*20);
			}
			int attempted=(int)(Math.random()*91+10); 
			int attempted1=(int)(Math.random()*91+10); 

			int correct_attempt=(int)(Math.random()*(attempted)+1);
			int correct_attempt1=(int)(Math.random()*(attempted1)+1);

			int wrong_attempt=attempted-correct_attempt;
			int wrong_attempt1=attempted1-correct_attempt1;

			while(correct_attempt==0 ||correct_attempt1==0 || wrong_attempt==0 ||wrong_attempt1==0 ||correct_attempt==1||correct_attempt1==1||wrong_attempt==1||wrong_attempt1==1){
				correct_attempt=(int)(Math.random()*(attempted)+1);
				correct_attempt1=(int)(Math.random()*(attempted1)+1);
	
				wrong_attempt=attempted-correct_attempt;
				wrong_attempt1=attempted1-correct_attempt1;
	
			}
			int pos_marks=2;
			int neg_marks=-1;
			String Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Que,Que1,Sol,Sol1;
			wrong_ans="";
			wrong_ans1="";
			wrong_ans2="";
			int marks_system=(int)(Math.random()*10);
			
			switch (marks_system) {
				case 0:
					pos_marks=5;
					neg_marks=-3;
					wrong_ans="Correct answer $2$ marks and wrong answer $-3$ marks. <br> #बरोबर उत्तर $2$ गुण आणि चूक उत्तर $-3$ गुण. <br> ";
					wrong_ans1="Correct answer $4$ marks and wrong answer $-2$ marks. <br> #बरोबर उत्तर $4$ गुण आणि चूक उत्तर $-2$ गुण. <br> ";
					wrong_ans2="Correct answer $3$ marks and wrong answer $-1$ marks. <br> #बरोबर उत्तर $3$ गुण आणि चूक उत्तर $-1$ गुण. <br> ";
					break;
				case 1:
					pos_marks=5;
					neg_marks=-2;
					wrong_ans="Correct answer $2$ marks and wrong answer $-3$ marks. <br> #बरोबर उत्तर $2$ गुण आणि चूक उत्तर $-3$ गुण. <br> ";
					wrong_ans1="Correct answer $4$ marks and wrong answer $-2$ marks. <br> #बरोबर उत्तर $4$ गुण आणि चूक उत्तर $-2$ गुण. <br> ";
					wrong_ans2="Correct answer $3$ marks and wrong answer $-1$ marks. <br> #बरोबर उत्तर $3$ गुण आणि चूक उत्तर $-1$ गुण. <br> ";
					break;
				case 2:
					pos_marks=5;
					neg_marks=-1;
					wrong_ans="Correct answer $5$ marks and wrong answer $-3$ marks. <br> #बरोबर उत्तर $5$ गुण आणि चूक उत्तर $-3$ गुण. <br> ";
					wrong_ans1="Correct answer $3$ marks and wrong answer $-2$ marks. <br> #बरोबर उत्तर $3$ गुण आणि चूक उत्तर $-2$ गुण. <br> ";
					wrong_ans2="Correct answer $1$ marks and wrong answer $-1$ marks. <br> #बरोबर उत्तर $1$ गुण आणि चूक उत्तर $-1$ गुण. <br> ";
					break;
				case 3:
					pos_marks=4;
					neg_marks=-3;
					wrong_ans="Correct answer $2$ marks and wrong answer $-1$ marks. <br> #बरोबर उत्तर $2$ गुण आणि चूक उत्तर $-1$ गुण. <br> ";
					wrong_ans1="Correct answer $1$ marks and wrong answer $-4$ marks. <br> #बरोबर उत्तर $1$ गुण आणि चूक उत्तर $-4$ गुण. <br> ";
					wrong_ans2="Correct answer $3$ marks and wrong answer $-1$ marks. <br> #बरोबर उत्तर $3$ गुण आणि चूक उत्तर $-1$ गुण. <br> ";
					break;
				case 4:
					pos_marks=4;
					neg_marks=-2;
					wrong_ans="Correct answer $2$ marks and wrong answer $-1$ marks. <br> #बरोबर उत्तर $2$ गुण आणि चूक उत्तर $-1$ गुण. <br> ";
					wrong_ans1="Correct answer $5$ marks and wrong answer $-3$ marks. <br> #बरोबर उत्तर $5$ गुण आणि चूक उत्तर $-3$ गुण. <br> ";
					wrong_ans2="Correct answer $3$ marks and wrong answer $-2$ marks. <br> #बरोबर उत्तर $3$ गुण आणि चूक उत्तर $-2$ गुण. <br> ";
					break;
				case 5:
					pos_marks=4;
					neg_marks=-1;
					wrong_ans="Correct answer $2$ marks and wrong answer $-3$ marks. <br> #बरोबर उत्तर $2$ गुण आणि चूक उत्तर $-3$ गुण. <br> ";
					wrong_ans1="Correct answer $4$ marks and wrong answer $-2$ marks. <br> #बरोबर उत्तर $4$ गुण आणि चूक उत्तर $-2$ गुण. <br> ";
					wrong_ans2="Correct answer $3$ marks and wrong answer $-1$ marks. <br> #बरोबर उत्तर $3$ गुण आणि चूक उत्तर $-1$ गुण. <br> ";
					break;
				case 6:
					pos_marks=3;
					neg_marks=-2;
					wrong_ans="Correct answer $2$ marks and wrong answer $-3$ marks. <br> #बरोबर उत्तर $2$ गुण आणि चूक उत्तर $-3$ गुण. <br> ";
					wrong_ans1="Correct answer $4$ marks and wrong answer $-2$ marks. <br> #बरोबर उत्तर $4$ गुण आणि चूक उत्तर $-2$ गुण. <br> ";
					wrong_ans2="Correct answer $3$ marks and wrong answer $-1$ marks. <br> #बरोबर उत्तर $3$ गुण आणि चूक उत्तर $-1$ गुण. <br> ";
					break;
				case 7:
					pos_marks=3;
					neg_marks=-1;
					wrong_ans="Correct answer $5$ marks and wrong answer $-3$ marks. <br> #बरोबर उत्तर $5$ गुण आणि चूक उत्तर $-3$ गुण. <br> ";
					wrong_ans1="Correct answer $4$ marks and wrong answer $-1$ marks. <br> #बरोबर उत्तर $4$ गुण आणि चूक उत्तर $-1$ गुण. <br> ";
					wrong_ans2="Correct answer $2$ marks and wrong answer $-2$ marks. <br> #बरोबर उत्तर $2$ गुण आणि चूक उत्तर $-2$ गुण. <br> ";
					break;
				case 8:
					pos_marks=2;
					neg_marks=-1;	
					wrong_ans="Correct answer $4$ marks and wrong answer $-2$ marks. <br> #बरोबर उत्तर $4$ गुण आणि चूक उत्तर $-2$ गुण. <br> ";
					wrong_ans1="Correct answer $1$ marks and wrong answer $-2$ marks. <br> #बरोबर उत्तर $1$ गुण आणि चूक उत्तर $-2$ गुण. <br> ";
					wrong_ans2="Correct answer $3$ marks and wrong answer $-1$ marks. <br> #बरोबर उत्तर $3$ गुण आणि चूक उत्तर $-1$ गुण. <br> ";
					break;
				case 9:
					pos_marks=1;
					neg_marks=-1;	
					wrong_ans="Correct answer $5$ marks and wrong answer $-3$ marks. <br> #बरोबर उत्तर $5$ गुण आणि चूक उत्तर $-3$ गुण. <br> ";
					wrong_ans1="Correct answer $1$ marks and wrong answer $-2$ marks. <br> #बरोबर उत्तर $1$ गुण आणि चूक उत्तर $-2$ गुण. <br> ";
					wrong_ans2="Correct answer $3$ marks and wrong answer $-3$ marks. <br> #बरोबर उत्तर $3$ गुण आणि चूक उत्तर $-3$ गुण. <br> ";
					break;
				default:
					break;
			}

			int score=correct_attempt*pos_marks+wrong_attempt*neg_marks;
			int score1=correct_attempt1*pos_marks+wrong_attempt1*neg_marks;
			// System.out.println(""+correct_attempt+"   "+correct_attempt1+"    "+wrong_attempt+"    "+wrong_attempt1+"    "+score+"    "+score1+"");

			int term1,term2,term3;
			term1=((wrong_attempt1*correct_attempt)-(correct_attempt1*wrong_attempt));
			term2=((correct_attempt*score1)-(correct_attempt1*score));
			term3=(term2/term1);
			Que="In a competitive examination, there were $100$ questions. <br>Out of questions attempted by "+ename[a]+" $"+correct_attempt+"$ were correct and $"+wrong_attempt+"$ were wrong. "+(a>9 ? "Her":"His")+" score was $"+score+"$. <br> "+ename[b]+" answered $"+correct_attempt1+"$ questions correct and $"+wrong_attempt1+"$ answers were wrong. "+(a>9 ? "Her":"His")+" score was $"+score1+"$ . <br> Unattempted questions were not carrying any weightage. <br> How many marks were assigned for correct and wrong answers? <br>";
			Que1="#एका स्पर्धा परीक्षेत $100$ प्रश्न होते. <br> "+mname[a]+"ने सोडविलेल्या प्रश्नांपैकी $"+correct_attempt+"$ उत्तरे बरोबर होती आणि $"+wrong_attempt+"$ प्रश्नांची उत्तरे चूक होती. "+(a>9 ? "तिला":"त्याला")+" मिळालेले गुण $"+score+"$ होते. <br> "+mname[b]+"ने सोडविलेल्या प्रश्नांपैकी $"+correct_attempt1+"$ उत्तरे बरोबर होती आणि $"+wrong_attempt1+"$ प्रश्नांची उत्तरे चूक होती. "+(a>9 ? "तिला":"त्याला")+" मिळालेले गुण $"+score1+"$ होते. <br> उत्तर न दिलेले प्रश्न विचारात घेतले गेले नाहीत. <br> तर प्रत्येक बरोबर आणि चूक उत्तरासाठी किती गुण ठरवले होत? <br>";

			// Sol="Ans: $"+wrong_attempt+"$ <br> Let us assume that "+ename[a]+" got $x$ questions correct and $y$ questions wrong. From the given information, we get<br> $x+y="+attempted+". . . . (i)$, and $2x-y="+score+". . . . (ii)$<br> From $(i)$ we get $x="+attempted+"-y$ <br> Substituting this value of $x$ in $(ii)$, we get <br> $2("+attempted+"-y)-y="+score+"$ <br> $ \\therefore y= "+wrong_attempt+" =$ no. of wrong answers given by "+ename[a]+". <br> ";
			// Sol1="#उत्तर: $"+wrong_attempt+"$ <br> "+mname[a]+"ने $x$ प्रश्न बरोबर सोडवले आणि $y$ प्रश्न चूक सोडवले असे मानू. दिलेल्या माहितीनुसार आपल्याला <br> $x+y="+attempted+". . . . (i)$ , आणि $2x-y="+score+". . . . (ii)$ अशी समीकरणे मिळतात <br> आता समीकरण $(i)$ वरून $x="+attempted+"-y$ मिळते <br> ही  $x$ ची किंमत आपण $(ii)$ मध्ये ठेऊन आपल्याला <br> $2("+attempted+"-y)-y="+score+"$ <br> $ \\therefore y= "+wrong_attempt+" =$ चूक सोडविलेल्या प्रश्नांची संख्या हे उत्तर मिळते. <br> ";
			Sol="Ans : Correct answer $"+pos_marks+"$ "+(pos_marks==1 || pos_marks==-1? "mark":"marks")+" and wrong answer $"+neg_marks+"$ "+(neg_marks==1 || neg_marks==-1? "mark":"marks")+". <br>" + //
                        "Let us assume that correct answer gets $x$ marks and wrong answer gets $y$ marks. <br>" + //
                        "As "+ename[a]+" answered $"+correct_attempt+"$ correct and $"+wrong_attempt+"$ wrong answers, "+(a>9 ? "her":"his")+" score will be <br>" + //
                        "$"+correct_attempt+"x+"+wrong_attempt+"y="+score+" . . . . . (i)$ <br>" + //
                        "and "+ename[b]+" answered $"+correct_attempt1+"$ correct and $"+wrong_attempt1+"$  wrong answers, "+(a>9 ? "her":"his")+" score can be written as <br>" + //
                        "$"+correct_attempt1+"x+"+wrong_attempt1+"y="+score1+" . . . . . (ii)$ <br>" + //
                        "Since unattempted answers to not contribute (same as carrying $0$ marks), we will not worry about the number of unanswered questions. <br>" + //
                        "From equation $(i)$ we get the value of $x$ in terms of $y$ as <br>" + //
                        "$x= \\dfrac {"+score+"-"+wrong_attempt+"y}{"+correct_attempt+"}$ <br>" + //
                        "Substituting this value of $x$ in equation $(ii)$ we get, <br>" + //
                        "$"+correct_attempt1+"\\times \\dfrac {"+score+"-"+wrong_attempt+"y}{"+correct_attempt+"} +"+wrong_attempt1+"y="+score1+"$ <br>" + //
                        "$\\dfrac {"+(correct_attempt1*score)+"-"+(correct_attempt1*wrong_attempt)+"y}{"+correct_attempt+"}+"+wrong_attempt1+"y="+score1+"$ <br>" + //
                        "$\\therefore "+(correct_attempt1*score)+"-"+(correct_attempt1*wrong_attempt)+"y+"+(wrong_attempt1*correct_attempt)+"y= "+(correct_attempt*score1)+"$ . . . .  by simplyfying <br>" + //
                        "$\\therefore "+term1+"y = "+term2+"$ <br>" + //
                        "$\\therefore y="+(term3)+"$ which gives the marks for wrong answer. <br>" + //
                        "By putting this value of $y$ in equation $(i)$ we get <br>" + //
                        "$"+correct_attempt+"x+\\{"+wrong_attempt+" \\times ("+term3+")\\}= "+score+"$ <br>" + //
                        "$\\therefore "+correct_attempt+"x= "+score+"+"+((-1)*(wrong_attempt)*term3)+"="+((score)+((-1)*(wrong_attempt)*term3))+"$  . . . .  by simplyfying <br>" + //
                        "$\\therefore x="+(((score)+((-1)*(wrong_attempt)*term3))/correct_attempt)+"$ which gives the marks for correct answer. <br>" + //
                        "Thus correct answer carries $"+pos_marks+"$ marks and wrong answer carries $"+neg_marks+"$ mark is the answer. <br> ";
    
			Sol1="उत्तर : बरोबर उत्तर $"+pos_marks+"$ गुण आणि चूक उत्तर $"+neg_marks+"$ गुण. <br> " + //
                        "आपण बरोबर उत्तरासाठी $x$ गुण आणि चूक उत्तरासाठी $y$ गुण मिळतील असे मानू. <br>" + //
                        ""+mname[a]+"ची $"+correct_attempt+"$ उत्तरे बरोबर आणि $"+wrong_attempt+"$ उत्तरे चूक आहेत, म्हणून "+(a>9 ? "तिला":"त्याला")+" मिळालेले एकूण गुण <br>" + //
                        "$"+correct_attempt+"x+"+wrong_attempt+"y="+score+" . . . . . (i)$ असे असतील. <br>" + //
                        "आणि "+mname[b]+"ने $"+correct_attempt1+"$ उत्तरे बरोबर आणि $"+wrong_attempt1+"$ उत्तरे चूक आहेत, म्हणून "+(a>9 ? "तिला":"त्याला")+" मिळालेले एकूण गुण <br>" + //
                        "$"+correct_attempt1+"x+"+wrong_attempt1+"y="+score1+" . . . . . (ii)$ असे असतील. <br>" + //
                        "उत्तर न दिलेले प्रश्न विचारात घेतले नाहीत म्हणजेच त्यांना प्रत्येक $0$ गुण आहेत. <br>" + //
                        "समीकरण $(i)$ वरून आपण $x$ ची किंमत $y$ च्या रूपात <br>" + //
                        "$x= \\dfrac {"+score+"-"+wrong_attempt+"y}{"+correct_attempt+"}$ अशी लिहू शकतो. <br>" + //
                        "$x$ ची ही किंमत समीकरण $(ii)$ मध्ये ठेवून आपल्याला,<br>" + //
                        "$"+correct_attempt1+"\\times \\dfrac {"+score+"-"+wrong_attempt+"y}{"+correct_attempt+"} +"+wrong_attempt1+"y="+score1+"$ असे मिळते. <br>" + //
                        "$\\dfrac {"+(correct_attempt1*score)+"-"+(correct_attempt1*wrong_attempt)+"y}{"+correct_attempt+"}+"+wrong_attempt1+"y="+score1+"$ <br>" + //
                        "$\\therefore "+(correct_attempt1*score)+"-"+(correct_attempt1*wrong_attempt)+"y+"+(wrong_attempt1*correct_attempt)+"y= "+(correct_attempt*score1)+"$ . . . .  सोडवून आणि सरळ रूप देऊन <br>" + //
                        "$\\therefore "+term1+"y = "+term2+"$ <br>" + //
                        "$\\therefore y="+(term3)+"$ हे चूक उत्तरासाठी असलेले गुण आहेत. ( म्हणजे चूक उत्तरासाठी $"+(-1)*(term3)+"$ गुण वजा होतो. )<br>" + //
                        "$y$ ची ही किंमत समीकरण $(i)$ ठेवून आपल्याला <br>" + //
                        "$"+correct_attempt+"x+\\{"+wrong_attempt+" \\times ("+term3+")\\}= "+score+"$ असे मिळते. <br>" + //
                        "$\\therefore "+correct_attempt+"x= "+score+"+"+((-1)*(wrong_attempt)*term3)+"="+((score)+((-1)*(wrong_attempt)*term3))+"$ . . . . . सोडवून आणि सरळ रूप देऊन <br>" + //
                        "$\\therefore x="+(((score)+((-1)*(wrong_attempt)*term3))/correct_attempt)+"$ हे बरोबर उत्तरासाठी असलेले गुण आहेत. <br>" + //
                        "म्हणजे बरोबर उत्तरासाठी $"+pos_marks+"$ गुण आणि  चूक उत्तरासाठी $"+neg_marks+"$ गुण हे उत्तर. <br>";
			
			String Solution = ""+Sol+" "+Sol1+"";
			String Question =""+Que+" "+Que1+"";
			
			Correct_ans="Correct answer $"+pos_marks+"$ "+(pos_marks==1 || pos_marks==-1? "mark":"marks")+" and wrong answer $"+neg_marks+"$ "+(neg_marks==1 || neg_marks==-1? "mark":"marks")+". <br> #बरोबर उत्तर $"+pos_marks+"$ गुण आणि चूक उत्तर $"+neg_marks+"$ गुण. <br> ";
			// wrong_ans="Correct answer $"+(pos_marks+1)+"$ "+((pos_marks+1)==1 || (pos_marks+1)==-1? "mark":"marks")+" and wrong answer $"+(neg_marks+1)+"$ "+((neg_marks+1)==1 || (neg_marks+1)==-1? "mark":"marks")+". <br> #बरोबर उत्तर $"+(pos_marks+1)+"$ गुण आणि चूक उत्तर $"+(neg_marks+1)+"$ गुण. <br> ";
			// wrong_ans1="Correct answer $"+((pos_marks-1)==0 ? "-1":pos_marks-1)+"$ "+((pos_marks-1)==1 || (pos_marks-1)==-1? "mark":"marks")+" and wrong answer $"+((neg_marks+1)==0 ? "-2":pos_marks-1)+"$ "+((neg_marks+1)==1 || (neg_marks+1)==-1? "mark":"marks")+". <br> #बरोबर उत्तर $"+(pos_marks+1)+"$ गुण आणि चूक उत्तर $"+(neg_marks+1)+"$ गुण. <br> ";
			// wrong_ans2="Correct answer $"+(pos_marks+1)+"$ "+((pos_marks+1)==1 || (pos_marks+1)==-1? "mark":"marks")+" and wrong answer $"+(neg_marks-1)+"$ marks. <br> #बरोबर उत्तर $"+(pos_marks+1)+"$ गुण आणि चूक उत्तर $"+(neg_marks+1)+"$ गुण. <br> ";
			

			row.createCell(4).setCellValue(Question);
			row.createCell(5).setCellValue(Correct_ans);
			//				 row.createCell(6).setCellValue(" ");
			//				 row.createCell(7).setCellValue(" ");
			//				 row.createCell(8).setCellValue(" ");
			row.createCell(9).setCellValue(wrong_ans);
			row.createCell(10).setCellValue(wrong_ans1);
			row.createCell(11).setCellValue(wrong_ans2);
			row.createCell(12).setCellValue(240);
			row.createCell(13).setCellValue(4);
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
			int prv=i;	
			
			//In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
			if(mapsize == mapsizeafter) {
				// System.out.println(Checker);
				i--;
			}
			
			if(prv==i){
				if(score==0 || score1==0){
					i--;
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
