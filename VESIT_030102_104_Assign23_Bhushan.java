import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VESIT_030102_104_Assign23_Bhushan {
	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VESIT_030102_104_Assign23_Bhushan.xlsx";     //Location where excel file is getting generated
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
			row.createCell(2).setCellValue(5);
			row.createCell(3).setCellValue("030102");

            String Engname[] = {"Smita","Radhika","Priya","Swapnali","Swara","Riya","Sonia","Jiya","Jasmine","Rita","Siya","Rukhsana","Muskan","Kaveri","Ajay","Rakesh","Prem","Swapnil","Swaraj","Amar","Anthony","Abhishek","Tushar","Abhinav","Harsh","Adarsh","Sham","Rajveer"};
            String Marname[] = {"स्मिता", "राधिका","प्रिया", "स्वप्नाली", "स्वरा","रिया"," सोनिया","जिया ","जस्मिन ","रिटा ","सिया ","रुखसाना","मुस्कान ","कावेरी","अजय" ,"राकेश" ,"प्रेम" ,"स्वप्नील" ,"स्वराज","अमर","अँथनी","अभिषेक","तुषार","अभिनव","हर्ष","आदर्श","श्याम","राजवीर" };
           
            int nm1,nm2,nm3,nm4;
            do{
                nm1=(int)(Math.random()*28);
                nm2=(int)(Math.random()*28);
                nm3=(int)(Math.random()*28);
                nm4=(int)(Math.random()*28);
            }while(nm1==nm2 || nm1==nm3 || nm1==nm4 || nm2==nm3 || nm2==nm4 || nm3==nm4);
            
            int num1,num2,num3,num4,diff;
            diff=(int)(Math.random()*20+1);
            num1=(int)(Math.random()*50+1);
            num2=num1+diff;
            num3=(int)(Math.random()*50+1);
            num4=num3+diff;

            while(num1==num3 || num1==num4 || num2==num3 || num2==num4){
                num1=(int)(Math.random()*50+1);
                num2=num1+diff;
                num3=(int)(Math.random()*50+1);
                num4=num3+diff;
            }
            
			
			String Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Que,Que1,Sol,Sol1,p1,p2,p3,name1,name2,name3,name4,Mname1,Mname2,Mname3,Mname4;
            p2="";
            p3="";
            name1="";
            name2="";
            name3="";
            name4="";
            Mname1="";
            Mname2="";
            Mname3="";
            Mname4="";
            int ch=(int)(Math.random()*24+1);

            switch (ch) {
                case 1:
                    p2="$"+num1+"$, $"+num2+"$, $"+num3+"$ and $"+num4+"$";
                    p3="$"+num1+"$, $"+num2+"$, $"+num3+"$ आणि $"+num4+"$";
                    name1=""+Engname[nm1]+"";  Mname1=""+Marname[nm1]+"";
                    name2=""+Engname[nm2]+"";  Mname2=""+Marname[nm2]+"";
                    name3=""+Engname[nm3]+"";  Mname3=""+Marname[nm3]+"";
                    name4=""+Engname[nm4]+"";  Mname4=""+Marname[nm4]+"";
                    break;
                
                case 2:
                    p2="$"+num1+"$, $"+num2+"$, $"+num4+"$ and $"+num3+"$";
                    p3="$"+num1+"$, $"+num2+"$, $"+num4+"$ आणि $"+num3+"$";
                    name1=""+Engname[nm1]+"";  Mname1=""+Marname[nm1]+"";
                    name2=""+Engname[nm2]+"";  Mname2=""+Marname[nm2]+"";
                    name3=""+Engname[nm4]+"";  Mname3=""+Marname[nm4]+"";
                    name4=""+Engname[nm3]+"";  Mname4=""+Marname[nm3]+"";
                    break;
                
                case 3:
                    p2="$"+num1+"$, $"+num3+"$, $"+num2+"$ and $"+num4+"$";
                    p3="$"+num1+"$, $"+num3+"$, $"+num2+"$ आणि $"+num4+"$";
                    name1=""+Engname[nm1]+"";  Mname1=""+Marname[nm1]+"";
                    name2=""+Engname[nm3]+"";  Mname2=""+Marname[nm3]+"";
                    name3=""+Engname[nm2]+"";  Mname3=""+Marname[nm2]+"";
                    name4=""+Engname[nm4]+"";  Mname4=""+Marname[nm4]+"";
                    break;
                
                case 4:
                    p2="$"+num1+"$, $"+num3+"$, $"+num4+"$ and $"+num2+"$";
                    p3="$"+num1+"$, $"+num3+"$, $"+num4+"$ आणि $"+num2+"$";
                    name1=""+Engname[nm1]+"";  Mname1=""+Marname[nm1]+"";
                    name2=""+Engname[nm3]+"";  Mname2=""+Marname[nm3]+"";
                    name3=""+Engname[nm4]+"";  Mname3=""+Marname[nm4]+"";
                    name4=""+Engname[nm2]+"";  Mname4=""+Marname[nm2]+"";
                    break;
                
                case 5:
                    p2="$"+num1+"$, $"+num4+"$, $"+num2+"$ and $"+num3+"$";
                    p3="$"+num1+"$, $"+num4+"$, $"+num2+"$ आणि $"+num3+"$";
                    name1=""+Engname[nm1]+"";  Mname1=""+Marname[nm1]+"";
                    name2=""+Engname[nm4]+"";  Mname2=""+Marname[nm4]+"";
                    name3=""+Engname[nm2]+"";  Mname3=""+Marname[nm2]+"";
                    name4=""+Engname[nm3]+"";  Mname4=""+Marname[nm3]+"";
                    break;
                
                case 6:
                    p2="$"+num1+"$, $"+num4+"$, $"+num3+"$ and $"+num2+"$";
                    p3="$"+num1+"$, $"+num4+"$, $"+num3+"$ आणि $"+num2+"$";
                    name1=""+Engname[nm1]+"";  Mname1=""+Marname[nm1]+"";
                    name2=""+Engname[nm4]+"";  Mname2=""+Marname[nm4]+"";
                    name3=""+Engname[nm3]+"";  Mname3=""+Marname[nm3]+"";
                    name4=""+Engname[nm2]+"";  Mname4=""+Marname[nm2]+"";
                    break;
                
                case 7:
                    p2="$"+num2+"$, $"+num1+"$, $"+num3+"$ and $"+num4+"$";
                    p3="$"+num2+"$, $"+num1+"$, $"+num3+"$ आणि $"+num4+"$";
                    name1=""+Engname[nm2]+"";  Mname1=""+Marname[nm2]+"";
                    name2=""+Engname[nm1]+"";  Mname2=""+Marname[nm1]+"";
                    name3=""+Engname[nm3]+"";  Mname3=""+Marname[nm3]+"";
                    name4=""+Engname[nm4]+"";  Mname4=""+Marname[nm4]+"";
                    break;
                
                case 8:
                    p2="$"+num2+"$, $"+num1+"$, $"+num4+"$ and $"+num3+"$";
                    p3="$"+num2+"$, $"+num1+"$, $"+num4+"$ आणि $"+num3+"$";
                    name1=""+Engname[nm2]+"";  Mname1=""+Marname[nm2]+"";
                    name2=""+Engname[nm1]+"";  Mname2=""+Marname[nm1]+"";
                    name3=""+Engname[nm4]+"";  Mname3=""+Marname[nm4]+"";
                    name4=""+Engname[nm3]+"";  Mname4=""+Marname[nm3]+"";
                    break;
                
                case 9:
                    p2="$"+num2+"$, $"+num3+"$, $"+num1+"$ and $"+num4+"$";
                    p3="$"+num2+"$, $"+num3+"$, $"+num1+"$ आणि $"+num4+"$";
                    name1=""+Engname[nm2]+"";  Mname1=""+Marname[nm2]+"";
                    name2=""+Engname[nm3]+"";  Mname2=""+Marname[nm3]+"";
                    name3=""+Engname[nm1]+"";  Mname3=""+Marname[nm1]+"";
                    name4=""+Engname[nm4]+"";  Mname4=""+Marname[nm4]+"";
                    break;
                
                case 10:
                    p2="$"+num2+"$, $"+num3+"$, $"+num4+"$ and $"+num1+"$";
                    p3="$"+num2+"$, $"+num3+"$, $"+num4+"$ आणि $"+num1+"$";
                    name1=""+Engname[nm2]+"";  Mname1=""+Marname[nm2]+"";
                    name2=""+Engname[nm3]+"";  Mname2=""+Marname[nm3]+"";
                    name3=""+Engname[nm4]+"";  Mname3=""+Marname[nm4]+"";
                    name4=""+Engname[nm1]+"";  Mname4=""+Marname[nm1]+"";
                    break;
                
                case 11:
                    p2="$"+num2+"$, $"+num4+"$, $"+num1+"$ and $"+num3+"$";
                    p3="$"+num2+"$, $"+num4+"$, $"+num1+"$ आणि $"+num3+"$";
                    name1=""+Engname[nm2]+"";  Mname1=""+Marname[nm2]+"";
                    name2=""+Engname[nm4]+"";  Mname2=""+Marname[nm4]+"";
                    name3=""+Engname[nm1]+"";  Mname3=""+Marname[nm1]+"";
                    name4=""+Engname[nm3]+"";  Mname4=""+Marname[nm3]+"";
                    break;
                
                case 12:
                    p2="$"+num2+"$, $"+num4+"$, $"+num3+"$ and $"+num1+"$";
                    p3="$"+num2+"$, $"+num4+"$, $"+num3+"$ आणि $"+num1+"$";
                    name1=""+Engname[nm2]+"";  Mname1=""+Marname[nm2]+"";
                    name2=""+Engname[nm4]+"";  Mname2=""+Marname[nm4]+"";
                    name3=""+Engname[nm3]+"";  Mname3=""+Marname[nm3]+"";
                    name4=""+Engname[nm1]+"";  Mname4=""+Marname[nm1]+"";
                    break;
                
                case 13:
                    p2="$"+num3+"$, $"+num1+"$, $"+num2+"$ and $"+num4+"$";
                    p3="$"+num3+"$, $"+num1+"$, $"+num2+"$ आणि $"+num4+"$";
                    name1=""+Engname[nm3]+"";  Mname1=""+Marname[nm3]+"";
                    name2=""+Engname[nm1]+"";  Mname2=""+Marname[nm1]+"";
                    name3=""+Engname[nm2]+"";  Mname3=""+Marname[nm2]+"";
                    name4=""+Engname[nm4]+"";  Mname4=""+Marname[nm4]+"";
                    break;
                
                case 14:
                    p2="$"+num3+"$, $"+num1+"$, $"+num4+"$ and $"+num2+"$";
                    p3="$"+num3+"$, $"+num1+"$, $"+num4+"$ आणि $"+num2+"$";
                    name1=""+Engname[nm3]+"";  Mname1=""+Marname[nm3]+"";
                    name2=""+Engname[nm1]+"";  Mname2=""+Marname[nm1]+"";
                    name3=""+Engname[nm4]+"";  Mname3=""+Marname[nm4]+"";
                    name4=""+Engname[nm2]+"";  Mname4=""+Marname[nm2]+"";
                    break;
                
                case 15:
                    p2="$"+num3+"$, $"+num2+"$, $"+num1+"$ and $"+num4+"$";
                    p3="$"+num3+"$, $"+num2+"$, $"+num1+"$ आणि $"+num4+"$";
                    name1=""+Engname[nm3]+"";  Mname1=""+Marname[nm3]+"";
                    name2=""+Engname[nm2]+"";  Mname2=""+Marname[nm2]+"";
                    name3=""+Engname[nm1]+"";  Mname3=""+Marname[nm1]+"";
                    name4=""+Engname[nm4]+"";  Mname4=""+Marname[nm4]+"";
                    break;
                
                case 16:
                    p2="$"+num3+"$, $"+num2+"$, $"+num4+"$ and $"+num1+"$";
                    p3="$"+num3+"$, $"+num2+"$, $"+num4+"$ आणि $"+num1+"$";
                    name1=""+Engname[nm3]+"";  Mname1=""+Marname[nm3]+"";
                    name2=""+Engname[nm2]+"";  Mname2=""+Marname[nm2]+"";
                    name3=""+Engname[nm4]+"";  Mname3=""+Marname[nm4]+"";
                    name4=""+Engname[nm1]+"";  Mname4=""+Marname[nm1]+"";
                    break;
                
                case 17:
                    p2="$"+num3+"$, $"+num4+"$, $"+num1+"$ and $"+num2+"$";
                    p3="$"+num3+"$, $"+num4+"$, $"+num1+"$ आणि $"+num2+"$";
                    name1=""+Engname[nm3]+"";  Mname1=""+Marname[nm3]+"";
                    name2=""+Engname[nm4]+"";  Mname2=""+Marname[nm4]+"";
                    name3=""+Engname[nm1]+"";  Mname3=""+Marname[nm1]+"";
                    name4=""+Engname[nm2]+"";  Mname4=""+Marname[nm2]+"";
                    break;
                
                case 18:
                    p2="$"+num3+"$, $"+num4+"$, $"+num2+"$ and $"+num1+"$";
                    p3="$"+num3+"$, $"+num4+"$, $"+num2+"$ आणि $"+num1+"$";
                    name1=""+Engname[nm3]+"";  Mname1=""+Marname[nm3]+"";
                    name2=""+Engname[nm4]+"";  Mname2=""+Marname[nm4]+"";
                    name3=""+Engname[nm2]+"";  Mname3=""+Marname[nm2]+"";
                    name4=""+Engname[nm1]+"";  Mname4=""+Marname[nm1]+"";
                    break;
                
                case 19:
                    p2="$"+num4+"$, $"+num1+"$, $"+num2+"$ and $"+num3+"$";
                    p3="$"+num4+"$, $"+num1+"$, $"+num2+"$ आणि $"+num3+"$";
                    name1=""+Engname[nm4]+"";  Mname1=""+Marname[nm4]+"";
                    name2=""+Engname[nm1]+"";  Mname2=""+Marname[nm1]+"";
                    name3=""+Engname[nm2]+"";  Mname3=""+Marname[nm2]+"";
                    name4=""+Engname[nm3]+"";  Mname4=""+Marname[nm3]+"";
                    break;
                
                case 20:
                    p2="$"+num4+"$, $"+num1+"$, $"+num3+"$ and $"+num2+"$";
                    p3="$"+num4+"$, $"+num1+"$, $"+num3+"$ आणि $"+num2+"$";
                    name1=""+Engname[nm4]+"";  Mname1=""+Marname[nm4]+"";
                    name2=""+Engname[nm1]+"";  Mname2=""+Marname[nm1]+"";
                    name3=""+Engname[nm3]+"";  Mname3=""+Marname[nm3]+"";
                    name4=""+Engname[nm2]+"";  Mname4=""+Marname[nm2]+"";
                    break;
                
                case 21:
                    p2="$"+num4+"$, $"+num2+"$, $"+num1+"$ and $"+num3+"$";
                    p3="$"+num4+"$, $"+num2+"$, $"+num1+"$ आणि $"+num3+"$";
                    name1=""+Engname[nm4]+"";  Mname1=""+Marname[nm4]+"";
                    name2=""+Engname[nm2]+"";  Mname2=""+Marname[nm2]+"";
                    name3=""+Engname[nm1]+"";  Mname3=""+Marname[nm1]+"";
                    name4=""+Engname[nm3]+"";  Mname4=""+Marname[nm3]+"";
                    break;
                
                case 22:
                    p2="$"+num4+"$, $"+num2+"$, $"+num3+"$ and $"+num1+"$";
                    p3="$"+num4+"$, $"+num2+"$, $"+num3+"$ आणि $"+num1+"$";
                    name1=""+Engname[nm4]+"";  Mname1=""+Marname[nm4]+"";
                    name2=""+Engname[nm2]+"";  Mname2=""+Marname[nm2]+"";
                    name3=""+Engname[nm3]+"";  Mname3=""+Marname[nm3]+"";
                    name4=""+Engname[nm1]+"";  Mname4=""+Marname[nm1]+"";
                    break;
                
                case 23:
                    p2="$"+num4+"$, $"+num3+"$, $"+num1+"$ and $"+num2+"$";
                    p3="$"+num4+"$, $"+num3+"$, $"+num1+"$ आणि $"+num2+"$";
                    name1=""+Engname[nm4]+"";  Mname1=""+Marname[nm4]+"";
                    name2=""+Engname[nm3]+"";  Mname2=""+Marname[nm3]+"";
                    name3=""+Engname[nm1]+"";  Mname3=""+Marname[nm1]+"";
                    name4=""+Engname[nm2]+"";  Mname4=""+Marname[nm2]+"";
                    break;
                
                case 24:
                    p2="$"+num4+"$, $"+num3+"$, $"+num2+"$ and $"+num1+"$";
                    p3="$"+num4+"$, $"+num3+"$, $"+num2+"$ आणि $"+num1+"$";
                    name1=""+Engname[nm4]+"";  Mname1=""+Marname[nm4]+"";
                    name2=""+Engname[nm3]+"";  Mname2=""+Marname[nm3]+"";
                    name3=""+Engname[nm2]+"";  Mname3=""+Marname[nm2]+"";
                    name4=""+Engname[nm1]+"";  Mname4=""+Marname[nm1]+"";
                    break;
                
                default:
                    break;
            }

            Que=""+name1+", "+name2+", "+name3+", and "+name4+" have "+p2+" watermelons respectively.<br>We need to form two pairs of individuals such that the difference in the number of watermelons in each pair can form an equation.<br>#The pairs should be such that the pairs can form an equation after subtraction.<br>";
			Que1="#"+Mname1+", "+Mname2+", "+Mname3+", आणि "+Mname4+" यांच्याकडे अनुक्रमे  "+p3+" इतकी टरबुजे आहेत. यांच्या कशा जोड्या कराव्या लागतील की त्यांच्याकडील असणाऱ्या टरबुजांची वजाबाकी आपल्याला समीकरण पद्धतीने मांडता येईल ?<br>";

			wrong_ans="";
			wrong_ans1="";
			wrong_ans2="";
			String p4="",p5="",p6="",p7="";
            if(num4>num2){
                p1=""+num4+"-"+num2+"="+num3+"-"+num1+"="+(num4-num2)+"";
                p4=""+Engname[nm4]+"/"+Engname[nm2]+" and "+Engname[nm3]+"/"+Engname[nm1]+"";
                p7=""+Engname[nm4]+" - "+Engname[nm2]+" and "+Engname[nm3]+" - "+Engname[nm1]+"";
                p5=""+Marname[nm4]+"/"+Marname[nm2]+" आणि "+Marname[nm3]+"/"+Marname[nm1]+"";
                p6=""+Marname[nm4]+" - "+Marname[nm2]+" आणि "+Marname[nm3]+" - "+Marname[nm1]+"";
            }
            else{
                p1=""+num2+"-"+num4+"="+num1+"-"+num3+"="+(num2-num4)+"";
                p4=""+Engname[nm2]+"/"+Engname[nm4]+" and "+Engname[nm1]+"/"+Engname[nm3]+"";
                p7=""+Engname[nm2]+" - "+Engname[nm4]+" and "+Engname[nm1]+" - "+Engname[nm3]+"";
                p5=""+Marname[nm2]+"/"+Marname[nm4]+" आणि "+Marname[nm1]+"/"+Marname[nm3]+"";
                p6=""+Marname[nm2]+" - "+Marname[nm4]+" आणि "+Marname[nm1]+" - "+Marname[nm3]+"";
            }
			
			
			Sol="Ans - The two pairs are: <br/>"+Engname[nm2]+" - "+Engname[nm1]+" and "+Engname[nm4]+" - "+Engname[nm3]+" and <br> "+p7+" <br>" +
                                "For an equation to form, we must have two sides (quantities) and they must be equal.<br>" +
                                "We will try subtractions with various combinations of pairs for number of watermelons.<br>" +
                                "We can observed that the subtraction of number of watermelons with "+Engname[nm2]+" and "+Engname[nm1]+" is $"+num2+" - "+num1+" = "+diff+" . . . .  (i)$. <br>" +
                                "And subtraction of number of watermelons with "+Engname[nm4]+" and "+Engname[nm3]+" is $"+num4+" - "+num3+" = "+diff+" . . . .  (ii)$.<br>" +
                                "We can see that the subtractions in $(i)$ and $(ii)$ are equal.<br>" +
                                "Hence, number of watermelons with "+Engname[nm2]+" - number of watermelons with "+Engname[nm1]+" <br>" +
                                "$=$ number of watermelons with "+Engname[nm4]+" - number of watermelons with "+Engname[nm3]+", as <br>" +
                                "$"+num2+"-"+num1+"="+num4+"-"+num3+"="+diff+"$<br>" +
                                "$\\therefore$ "+Engname[nm2]+"/"+Engname[nm1]+" and "+Engname[nm4]+"/"+Engname[nm3]+" is  . . . .  First correct answer<br>" +
                                "Similaraly other pair is "+p4+" form other pair, which can be verified, as $"+p1+"$<br>" +
                                "$\\therefore$ "+p4+" is  . . . .  Second correct answer.<br>" +
                                "$\\therefore$ "+Engname[nm2]+"/"+Engname[nm1]+" and "+Engname[nm4]+"/"+Engname[nm3]+"  . . . .  First correct answer,<br>" +
                                "and "+p4+" . .  . .  Second correct answer.<br>" +
                                "<br>";
    
			Sol1="#उत्तर  $1$ : "+Marname[nm2]+" - "+Marname[nm1]+" आणि "+Marname[nm4]+" - "+Marname[nm3]+", आणि <br>" +
                                "उत्तर $2$ : "+p6+" <br>" +
                                "कोणतेही समीकरण तयार होण्यासाठी दोन बाजू असणे आवश्यक आहे, आणि शिवाय दोनही बाजूंचे मूल्य समान असावे लागते. <br>" +
                                "लक्ष पूर्वक पाहिल्यास आपल्याला हे समजेल की "+Marname[nm2]+" आणि "+Marname[nm1]+" यांच्या कडील टरबुजांच्या संख्येतील फरक $"+num2+" - "+num1+" = "+diff+" . . . .  (i)$ असा आहे. <br>" +
                                "आणि "+Marname[nm4]+" आणि "+Marname[nm3]+" यांच्या कडील टरबुजांच्या संख्येतील फरक $"+num4+" - "+num3+" = "+diff+" . . . .  (ii)$ असा आहे. <br>" +
                                "$(i)$ आणि $(ii)$ वरून आपल्याला हे कळते की दोन्ही वजाबाकी समान  आहेत. <br>" +
                                "म्हणून "+Marname[nm2]+" कडील टरबुजांची संख्या $-$ "+Marname[nm1]+" कडील टरबुजांची संख्या <br>" +
                                "$=$ "+Marname[nm4]+" कडील टरबुजांची संख्या $-$ "+Marname[nm3]+" कडील टरबुजांची संख्या, कारण  <br>" +
                                "$"+num2+"-"+num1+"="+num4+"-"+num3+"="+diff+"$<br>" +
                                "$\\therefore$ "+Marname[nm2]+"/"+Marname[nm1]+" आणि "+Marname[nm4]+"/"+Marname[nm3]+" . . . .  हे पहिले बरोबर उत्तर आहे. <br>" +
                                "तसेच दुसरी जोडी "+p5+" अशी आहे, हे पुढील प्रमाणे तपासात येईल, <br>" +
                                "$"+p1+"$<br>" +
                                "$\\therefore$ "+p5+" . . . .  हे दुसरे बरोबर उत्तर आहे. <br>" +
                                "म्हणून "+Marname[nm2]+"/"+Marname[nm1]+" आणि "+Marname[nm4]+"/"+Marname[nm3]+" . . . .  बरोबर उत्तर एक . <br>" +
                                ""+p5+" . . . .  बरोबर उत्तर दोन . <br>";
			
			String Solution = ""+Sol+" "+Sol1+"";
			String Question =""+Que+" "+Que1+"";
			
			Correct_ans="";
			
			row.createCell(4).setCellValue(Question);
			row.createCell(5).setCellValue(Correct_ans);
			//				 row.createCell(6).setCellValue(" ");
			//				 row.createCell(7).setCellValue(" ");
			//				 row.createCell(8).setCellValue(" ");
			row.createCell(9).setCellValue(wrong_ans);
			row.createCell(10).setCellValue(wrong_ans1);
			row.createCell(11).setCellValue(wrong_ans2);
			row.createCell(12).setCellValue(180);
			row.createCell(13).setCellValue(3);
			//				  row.createCell(14).setCellValue(" ");
			row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			//Generate Solution
								
			row.createCell(16).setCellValue(Solution);
			//				  row.createCell(17).setCellValue(" ");
			row.createCell(18).setCellValue(104);

				
			String Checker =""+Question+""+Solution+""+Correct_ans+""+wrong_ans+""+wrong_ans1+""+wrong_ans2+"";
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
