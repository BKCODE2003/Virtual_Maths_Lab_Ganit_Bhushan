import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VESIT_03040301_136_Assign6_Bhushan {
	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VESIT_03040301_136_Assign6_Bhushan.xlsx";     //Location where excel file is getting generated
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

			   String femaleEng[] = {"Smita","Radhika","Priya","Swapnali","Swara","Riya","Sonia","Jiya","Jasmine","Rita","Siya","Rukhsana","Muskan","Kaveri"};
			   String femaleMar[] = {"स्मिता", "राधिका","प्रिया", "स्वप्नाली", "स्वरा","रिया"," सोनिया","जिया ","जस्मिन ","रिटा ","सिया ","रुखसाना","मुस्कान ","कावेरी" };
			   String maleEng[] = {"Ajay","Rakesh","Prem","Swapnil","Swaraj","Amar","Anthony","Abhishek","Tushar","Abhinav","Harsh","Adarsh","Sham","Rajveer"};
			   String maleMar[]= { "अजय" ,"राकेश" ,"प्रेम" ,"स्वप्नील" ,"स्वराज","अमर","अँथनी","अभिषेक","तुषार","अभिनव","हर्ष","आदर्श","श्याम","राजवीर"};
			   
			   String monthsEng[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
			   String monthsMar[]={"जानेवारी","फेब्रुवारी","मार्च","एप्रिल","मे","जून","जुलै","ऑगस्ट","सप्टेंबर","ऑक्टोबर","नोव्हेंबर","डिसेंबर"};

			   String engPlace []={"office", "library", "pharmacy", "shop", "dairy", "hospital", "dispensary", "farm", "garden"};
			   String marPlace []={"कार्यालयात", "ग्रंथालयात", "औषधालयात", "दुकानात", "दुग्धालयात", "रुग्णालयात", "दवाखान्यात", "शेतात", "बागेत"};

			int a=(int)(Math.random()*14); 

			int b=(int)(Math.random()*12);
			int c=(int)(Math.random()*12);
			int d=(int)(Math.random()*12);
			int m=(int)(Math.random()*12);
			while(b==c || b==d  || b==m || c==d || c==m || d==m)
			{
			 b=(int)(Math.random()*12);
			 c=(int)(Math.random()*12);
			 d=(int)(Math.random()*12);
			 m=(int)(Math.random()*12);
			}
			int e=(int)(Math.random()*2);

			int l=(int)(Math.random()*3);

			ArrayList<String> sumarr = new ArrayList<String>();
			int  [] powArr2=new int[4];

			Integer f=(int)(Math.random()*9)+1; 
			Integer g=(int)(Math.random()*9)+1;
			Integer h=(int)(Math.random()*9)+1;
			Integer k=(int)(Math.random()*9)+1;

			while(f==g || f==h || f==k || g==h || g==k || h==k)
			{
			f=(int)(Math.random()*9)+1; 
			g=(int)(Math.random()*9)+1;
			h=(int)(Math.random()*9)+1;
			k=(int)(Math.random()*9)+1;
			}
			powArr2[0]=f;
			powArr2[1]=g;
			powArr2[2]=h;
			powArr2[3]=k;

			
			
			if(f==1){
				sumarr.add("");
			}
			else{
				sumarr.add(f.toString());
			}

			if(g==1){
				sumarr.add("");
			}
			else{
				sumarr.add(g.toString());
			}

			if(h==1){
				sumarr.add("");
			}
			else{
				sumarr.add(h.toString());
			}

			if(k==1){
				sumarr.add("");
			}
			else{
				sumarr.add(k.toString());
			}

			String Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Que,Que1,sol,sol1;
			
			if(l==0){
			
				if(e==0){
				  Que = ""+maleEng[a]+" worked in "+engPlace[f-1]+" in "+monthsEng[c]+" and "+monthsEng[d]+" for $"+sumarr.get(0)+"x$ and $"+sumarr.get(1)+"x$ days respectively. For how many days did he work in these $2$ months in the "+engPlace[f-1]+" ?<br>";
				  Que1 = "# "+maleMar[a]+"ने "+marPlace[f-1]+" "+monthsMar[c]+" आणि "+monthsMar[d]+" महिन्यात अनुक्रमे $"+sumarr.get(0)+"x$ आणि $"+sumarr.get(1)+"x$ दिवस काम केले. तर त्यांने या $2$ महिन्यात एकूण किती दिवस "+marPlace[f-1]+" काम केले? <br>";
				}
				else{
				  Que = ""+femaleEng[a]+" worked in "+engPlace[f-1]+" in "+monthsEng[c]+" and "+monthsEng[d]+" for $"+sumarr.get(0)+"x$ and $"+sumarr.get(1)+"x$ days respectively. For how many days did she work in these $2$ months in the "+engPlace[f-1]+" ?<br>";
				  Que1 = "# "+femaleMar[a]+"ने "+marPlace[f-1]+" "+monthsMar[c]+" आणि "+monthsMar[d]+" महिन्यात अनुक्रमे $"+sumarr.get(0)+"x$ आणि $"+sumarr.get(1)+"x$ दिवस काम केले. तर तिने या $2$ महिन्यात एकूण किती दिवस "+marPlace[f-1]+" काम केले? <br>";
				}

			}
			else if(l==1){
				
				if(e==0){
				  Que = ""+maleEng[a]+" worked in "+engPlace[f-1]+" in "+monthsEng[b]+", "+monthsEng[c]+" and "+monthsEng[d]+" for $"+sumarr.get(0)+"x$, $"+sumarr.get(1)+"x$ and $"+sumarr.get(2)+"x$ days respectively. For how many days did he work in these $3$ months in the "+engPlace[f-1]+" ?<br>";
				  Que1 = "# "+maleMar[a]+"ने "+marPlace[f-1]+" "+monthsMar[b]+", "+monthsMar[c]+" आणि "+monthsMar[d]+" महिन्यात अनुक्रमे $"+sumarr.get(0)+"x$, $"+sumarr.get(1)+"x$ आणि $"+sumarr.get(2)+"x$ दिवस काम केले. तर त्यांने या $3$ महिन्यात एकूण किती दिवस "+marPlace[f-1]+" काम केले? <br>";
				}
				else{
			  Que = ""+femaleEng[a]+" worked in "+engPlace[f-1]+" in "+monthsEng[b]+", "+monthsEng[c]+" and "+monthsEng[d]+" for $"+sumarr.get(0)+"x$, $"+sumarr.get(1)+"x$ and $"+sumarr.get(2)+"x$ days respectively. For how many days did she work in these $3$ months in the "+engPlace[f-1]+" ?<br>";
			  Que1 = "# "+femaleMar[a]+"ने "+marPlace[f-1]+" "+monthsMar[b]+", "+monthsMar[c]+" आणि "+monthsMar[d]+" महिन्यात अनुक्रमे $"+sumarr.get(0)+"x$, $"+sumarr.get(1)+"x$ आणि $"+sumarr.get(2)+"x$ दिवस काम केले. तर तिने या $3$ महिन्यात एकूण किती दिवस "+marPlace[f-1]+" काम केले? <br>";
				}
				

			}
			else{

				if(e==0){
				  Que = ""+maleEng[a]+" worked in "+engPlace[f-1]+" in "+monthsEng[b]+", "+monthsEng[c]+", "+monthsEng[d]+" and "+monthsEng[m]+" for $"+sumarr.get(0)+"x$, $"+sumarr.get(1)+"x$, $"+sumarr.get(2)+"x$ and $"+sumarr.get(3)+"x$ days respectively. For how many days did he work in these $4$ months in the "+engPlace[f-1]+" ?<br>";
				 Que1 = "# "+maleMar[a]+"ने "+marPlace[f-1]+" "+monthsMar[b]+", "+monthsMar[c]+", "+monthsMar[d]+" आणि "+monthsMar[m]+" महिन्यात अनुक्रमे $"+sumarr.get(0)+"x$, $"+sumarr.get(1)+"x$, $"+sumarr.get(2)+"x$ आणि $"+sumarr.get(3)+"x$ दिवस काम केले. तर त्यांने या $4$ महिन्यात एकूण किती दिवस "+marPlace[f-1]+" काम केले? <br>";
				}
				else{
			  Que = ""+femaleEng[a]+" worked in "+engPlace[f-1]+" in "+monthsEng[b]+", "+monthsEng[c]+", "+monthsEng[d]+" and "+monthsEng[m]+" for $"+sumarr.get(0)+"x$, $"+sumarr.get(1)+"x$, $"+sumarr.get(2)+"x$ and $"+sumarr.get(3)+"x$ days respectively. For how many days did she work in these $4$ months in the "+engPlace[f-1]+" ?<br>";
			  Que1 = "# "+femaleMar[a]+"ने "+marPlace[f-1]+" "+monthsMar[b]+", "+monthsMar[c]+", "+monthsMar[d]+" आणि "+monthsMar[m]+" महिन्यात अनुक्रमे $"+sumarr.get(0)+"x$, $"+sumarr.get(1)+"x$, $"+sumarr.get(2)+"x$ आणि $"+sumarr.get(3)+"x$ दिवस काम केले. तर तिने या $4$ महिन्यात एकूण किती दिवस "+marPlace[f-1]+" काम केले? <br>";
				}
				
			}



			if(l==0){
			
				if(e==0){
				  sol ="Ans : $"+(powArr2[0]+powArr2[1])+"x$ days .<br>The days he worked in each month is given. After adding them all we will get the total number of days he worked in $2$ months.<br>$\\therefore$ Total no. of days he worked <br>$="+sumarr.get(0)+"x + "+sumarr.get(1)+"x$<br>$= ("+powArr2[0]+"+"+powArr2[1]+")x$ . . . . by taking out the variable as common<br>$="+(powArr2[0]+powArr2[1])+"x$ days is the answer.<br>";
				 sol1 ="#उत्तर : $"+(powArr2[0]+powArr2[1])+"x$ दिवस. <br>प्रत्येक महिन्यात त्याने किती दिवस काम केले, ते दिले आहे. त्या सर्व दिवसांची बेरीज करून त्याने त्या $2$ महिन्यात किती दिवस काम केले ते मिळेल. <br>$\\therefore$ एकूण काम केलेले दिवस <br>$="+sumarr.get(0)+"x + "+sumarr.get(1)+"x$<br>$= ("+powArr2[0]+"+"+powArr2[1]+")x$ . . . . सामायिक चल बाहेर घेऊन<br>$="+(powArr2[0]+powArr2[1])+"x$ दिवस हे उत्तर.<br>";
				    Correct_ans="$"+(powArr2[0]+powArr2[1])+"x$ <br>";
				}
				else{
				  sol ="Ans : $"+(powArr2[0]+powArr2[1])+"x$ days .<br>The days she worked in each month is given. After adding them all we will get the total number of days she worked in $2$ months.<br>$\\therefore$ Total no. of days she worked <br>$="+sumarr.get(0)+"x + "+sumarr.get(1)+"x$<br>$= ("+powArr2[0]+"+"+powArr2[1]+")x$ . . . . by taking out the variable as common<br>$="+(powArr2[0]+powArr2[1])+"x$ days is the answer.<br>";
				 sol1 ="#उत्तर : $"+(powArr2[0]+powArr2[1])+"x$ दिवस. <br>प्रत्येक महिन्यात तिने किती दिवस काम केले, ते दिले आहे. त्या सर्व दिवसांची बेरीज करून तिने त्या $2$ महिन्यात किती दिवस काम केले ते मिळेल. <br>$\\therefore$ एकूण काम केलेले दिवस <br>$="+sumarr.get(0)+"x + "+sumarr.get(1)+"x$<br>$= ("+powArr2[0]+"+"+powArr2[1]+")x$ . . . . सामायिक चल बाहेर घेऊन<br>$="+(powArr2[0]+powArr2[1])+"x$ दिवस हे उत्तर.<br>";
					Correct_ans="$"+(powArr2[0]+powArr2[1])+"x$ <br>";
				}

				if(f+g-3==0){
					wrong_ans="$0$ <br>";
				}
				else if(f+g-3==1){
					wrong_ans="$x$ <br>";
				}
				else if(f+g-3==-1){
					wrong_ans="$-x$ <br>";
				}
				else{
					wrong_ans="$"+(f+g-3)+"x$ <br>";
				}
				wrong_ans1="$"+(f+g+1)+"x$ <br>";
				wrong_ans2="$"+(f+g+8)+"x$ <br>";

			}
			else if(l==1){
				
				if(e==0){
				  sol ="Ans : $"+(powArr2[0]+powArr2[1]+powArr2[2])+"x$ days .<br>The days he worked in each month is given. After adding them all we will get the total number of days he worked in $3$ months.<br>$\\therefore$ Total no. of days he worked <br>$="+sumarr.get(0)+"x + "+sumarr.get(1)+"x + "+sumarr.get(2)+"x$<br>$= ("+powArr2[0]+"+"+powArr2[1]+"+"+powArr2[2]+")x$ . . . . by taking out the variable as common<br>$="+(powArr2[0]+powArr2[1]+powArr2[2])+"x$ days is the answer.<br>";
				 sol1 ="#उत्तर : $"+(powArr2[0]+powArr2[1]+powArr2[2])+"x$ दिवस. <br>प्रत्येक महिन्यात त्याने किती दिवस काम केले, ते दिले आहे. त्या सर्व दिवसांची बेरीज करून त्याने त्या $3$ महिन्यात किती दिवस काम केले ते मिळेल. <br>$\\therefore$ एकूण काम केलेले दिवस <br>$="+sumarr.get(0)+"x + "+sumarr.get(1)+"x + "+sumarr.get(2)+"x$<br>$= ("+powArr2[0]+"+"+powArr2[1]+"+"+powArr2[2]+")x$ . . . . सामायिक चल बाहेर घेऊन<br>$="+(powArr2[0]+powArr2[1]+powArr2[2])+"x$ दिवस हे उत्तर.<br>";
					Correct_ans="$"+(powArr2[0]+powArr2[1]+powArr2[2])+"x$ <br>";
				}
				else{
				  sol ="Ans : $"+(powArr2[0]+powArr2[1]+powArr2[2])+"x$ days .<br>The days she worked in each month is given. After adding them all we will get the total number of days she worked in $3$ months.<br>$\\therefore$ Total no. of days she worked <br>$="+sumarr.get(0)+"x + "+sumarr.get(1)+"x + "+sumarr.get(2)+"x$<br>$= ("+powArr2[0]+"+"+powArr2[1]+"+"+powArr2[2]+")x$ . . . . by taking out the variable as common<br>$="+(powArr2[0]+powArr2[1]+powArr2[2])+"x$ days is the answer.<br>";
				 sol1 ="#उत्तर : $"+(powArr2[0]+powArr2[1]+powArr2[2])+"x$ दिवस. <br>प्रत्येक महिन्यात तिने किती दिवस काम केले, ते दिले आहे. त्या सर्व दिवसांची बेरीज करून तिने त्या $3$ महिन्यात किती दिवस काम केले ते मिळेल. <br>$\\therefore$ एकूण काम केलेले दिवस <br>$="+sumarr.get(0)+"x + "+sumarr.get(1)+"x + "+sumarr.get(2)+"x$<br>$= ("+powArr2[0]+"+"+powArr2[1]+"+"+powArr2[2]+")x$ . . . . सामायिक चल बाहेर घेऊन<br>$="+(powArr2[0]+powArr2[1]+powArr2[2])+"x$ दिवस हे उत्तर.<br>";
					Correct_ans="$"+(powArr2[0]+powArr2[1]+powArr2[2])+"x$ <br>"; 
				}

				if(f+g-3==0){
					wrong_ans="$0$ <br>";
				}
				else if(f+g-3==1){
					wrong_ans="$x$ <br>";
				}
				else if(f+g-3==-1){
					wrong_ans="$-x$ <br>";
				}
				else{
					wrong_ans="$"+(f+g+h-3)+"x$ <br>";
				}
				
				wrong_ans1="$"+(f+g+h+1)+"x$ <br>";
				wrong_ans2="$"+(f+g+h+8)+"x$ <br>";

			}
			else{

				if(e==0){
				  sol ="Ans : $"+(powArr2[0]+powArr2[1]+powArr2[2]+powArr2[3])+"x$ days .<br>The days he worked in each month is given. After adding them all we will get the total number of days he worked in $4$ months.<br>$\\therefore$ Total no. of days he worked <br>$="+sumarr.get(0)+"x + "+sumarr.get(1)+"x + "+sumarr.get(2)+"x + "+sumarr.get(3)+"x$<br>$= ("+powArr2[0]+"+"+powArr2[1]+"+"+powArr2[2]+"+"+powArr2[3]+")x$ . . . . by taking out the variable as common<br>$="+(powArr2[0]+powArr2[1]+powArr2[2]+powArr2[3])+"x$ days is the answer.<br>";
				 sol1 ="#उत्तर : $"+(powArr2[0]+powArr2[1]+powArr2[2]+powArr2[3])+"x$ दिवस. <br>प्रत्येक महिन्यात त्याने किती दिवस काम केले, ते दिले आहे. त्या सर्व दिवसांची बेरीज करून त्याने त्या $4$ महिन्यात किती दिवस काम केले ते मिळेल. <br>$\\therefore$ एकूण काम केलेले दिवस <br>$="+sumarr.get(0)+"x + "+sumarr.get(1)+"x + "+sumarr.get(2)+"x + "+sumarr.get(3)+"x$<br>$= ("+powArr2[0]+"+"+powArr2[1]+"+"+powArr2[2]+"+"+powArr2[3]+")x$ . . . . सामायिक चल बाहेर घेऊन<br>$="+(powArr2[0]+powArr2[1]+powArr2[2]+powArr2[3])+"x$ दिवस हे उत्तर.<br>";
					Correct_ans="$"+(powArr2[0]+powArr2[1]+powArr2[2]+powArr2[3])+"x$ <br>";
				}
				else{
				  sol ="Ans : $"+(powArr2[0]+powArr2[1]+powArr2[2]+powArr2[3])+"x$ days .<br>The days she worked in each month is given. After adding them all we will get the total number of days she worked in $4$ months.<br>$\\therefore$ Total no. of days she worked <br>$="+sumarr.get(0)+"x + "+sumarr.get(1)+"x + "+sumarr.get(2)+"x + "+sumarr.get(3)+"x$<br>$= ("+powArr2[0]+"+"+powArr2[1]+"+"+powArr2[2]+"+"+powArr2[3]+")x$ . . . . by taking out the variable as common<br>$="+(powArr2[0]+powArr2[1]+powArr2[2]+powArr2[3])+"x$ days is the answer.<br>";
				 sol1 ="#उत्तर : $"+(powArr2[0]+powArr2[1]+powArr2[2]+powArr2[3])+"x$ दिवस. <br>प्रत्येक महिन्यात तिने किती दिवस काम केले, ते दिले आहे. त्या सर्व दिवसांची बेरीज करून तिने त्या $4$ महिन्यात किती दिवस काम केले ते मिळेल. <br>$\\therefore$ एकूण काम केलेले दिवस <br>$="+sumarr.get(0)+"x + "+sumarr.get(1)+"x + "+sumarr.get(2)+"x + "+sumarr.get(3)+"x$<br>$= ("+powArr2[0]+"+"+powArr2[1]+"+"+powArr2[2]+"+"+powArr2[3]+")x$ . . . . सामायिक चल बाहेर घेऊन<br>$="+(powArr2[0]+powArr2[1]+powArr2[2]+powArr2[3])+"x$ दिवस हे उत्तर.<br>";
					Correct_ans="$"+(powArr2[0]+powArr2[1]+powArr2[2]+powArr2[3])+"x$ <br>";
				}

				if(f+g-3==0){
					wrong_ans="$0$ <br>";
				}
				else if(f+g-3==1){
					wrong_ans="$x$ <br>";
				}
				else if(f+g-3==-1){
					wrong_ans="$-x$ <br>";
				}
				else{
					wrong_ans="$"+(f+g+h+k-3)+"x$ <br>";
				}
				
				wrong_ans1="$"+(f+g+h+k+1)+"x$ <br>";
				wrong_ans2="$"+(f+g+h+k+8)+"x$ <br>";
				
			}
			System.out.println(sumarr);

			
			String Solution = ""+sol+" "+sol1+"";
			String Question =""+Que+" "+Que1+"";
			
           
		
			    row.createCell(4).setCellValue(Question);
		        row.createCell(5).setCellValue(Correct_ans);
//				 row.createCell(6).setCellValue(" ");
//				 row.createCell(7).setCellValue(" ");
//				 row.createCell(8).setCellValue(" ");
				 row.createCell(9).setCellValue(wrong_ans);
				 row.createCell(10).setCellValue(wrong_ans1);
				 row.createCell(11).setCellValue(wrong_ans2);
				 row.createCell(12).setCellValue(60);
				   row.createCell(13).setCellValue(2);
//				  row.createCell(14).setCellValue(" ");
				  row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				  
				//Generate Solution
				  				 
				  row.createCell(16).setCellValue(Solution);
//				  row.createCell(17).setCellValue(" ");
				  row.createCell(18).setCellValue(136);

					
				String Checker =""+Solution+""+Correct_ans+""+wrong_ans+""+wrong_ans1+""+wrong_ans2+""+Question+"";
				mapsize = map.size();
				map.put(Checker,i);
				mapsizeafter = map.size();
								
                //In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
				if(mapsize == mapsizeafter) {
					System.out.println(Checker);
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
