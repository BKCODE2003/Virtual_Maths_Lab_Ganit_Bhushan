// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;
// import java.io.IOException;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Scanner;
// import java.awt.Color;

// import java.io.FileInputStream;



// import org.apache.poi.util.IOUtils;
// import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
// import org.apache.poi.xssf.usermodel.XSSFCreationHelper;

// import org.apache.poi.ss.usermodel.*;



// import org.apache.poi.xssf.usermodel.XSSFRow;
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// public class VLab_0304060403_112_Assign20_Bhushan {

// 	public static int gcd(int a, int b) {
//         if (b==0) return a;
//         return gcd(b,a%b);
//     }

// 	public static void insertImageIntoExcel(XSSFSheet sheet, String imagePath, int rowNumber, int columnNumber ,XSSFWorkbook wb) throws IOException {
//         // Add the picture to the workbook
//         FileInputStream inputStream = new FileInputStream(imagePath);
//         byte[] bytes = IOUtils.toByteArray(inputStream);
//         int pictureIdx = sheet.getWorkbook().addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
//         inputStream.close();

// 		XSSFCreationHelper helper = wb.getCreationHelper();
//         // Create the drawing patriarch
//         Drawing drawing = sheet.createDrawingPatriarch();
		

//         // Add a picture shape
//         //XSSFClientAnchor anchor = new XSSFClientAnchor();
// 		XSSFClientAnchor anchor = helper.createClientAnchor();
        
//         anchor.setCol1(columnNumber);
//         anchor.setRow1(rowNumber);
// 		anchor.setCol2(columnNumber + 1);
//         anchor.setRow2(rowNumber+1);
        
//         Picture pict = drawing.createPicture(anchor, pictureIdx);
// 		pict.resize(0.5);
		

		
//     }

//     public static int[] extractNumbers(String input) {
//         String[] parts = input.replace("(", "").replace(")", "").split(",");
//         int x = Integer.parseInt(parts[0].trim());
//         int y = Integer.parseInt(parts[1].trim());
//         return new int[]{x, y};
//     }

// 	public static void main(String args[]) throws IOException,FileNotFoundException{
// 		String filename = "D:/excel files/VLab_0304060403_112_Assign20_Bhushan.xlsx";     //Location where excel file is getting generated
// 		XSSFWorkbook workbook = new XSSFWorkbook();
// 		XSSFSheet sheet = workbook.createSheet("Instruction");      //Generating first sheet as Instruction
		
// 		XSSFSheet sheet1 = workbook.createSheet("Questions");       //Generating second sheet as Questions
		
// 		//Adding first row in second sheet(Questions)
// 		String[] header = {"Sr. No","Question Type","Answer Type","Topic Number","Question (Text Only)","Correct Answer 1","Correct Answer 2",
// 				"Correct Answer 3","Correct Answer 4","Wrong Answer 1","Wrong Answer 2","Wrong Answer 3","Time in seconds","Difficulty Level",
// 				"Question (Image/ Audio/ Video)","Contributor's Registered mailId","Solution (Text Only)","Solution (Image/ Audio/ Video)","Variation Number"};
// 		XSSFRow rowhead = sheet1.createRow(0);	
		
		
// 		//Set height and width to the column and row
// 		sheet1.setColumnWidth(4, 35*250);
// 		sheet1.setColumnWidth(16, 45*250);
		
		
// 		// Set height and width for the image column only
// 		// int imageColumnWidth = 400/7;
// 		// sheet1.setColumnWidth(6, imageColumnWidth * 256);  // Adjust the width to fit the image (810 pixels)
// 		sheet1.setColumnWidth(6, 57*256);
// 		sheet1.setColumnWidth(10, 57*256);
// 		sheet1.setColumnWidth(11, 57*256);
// 		sheet1.setColumnWidth(12, 57*256);
// 		//Adding header to the second sheet
// 		for(int head=0; head<header.length; head++) {
// 			rowhead.createCell(head).setCellValue(header[head]);
			
// 		}
// 		Scanner sc=new Scanner(System.in);
// 		System.out.println("Enter Number of question :");
// 		int q=sc.nextInt();

		
// 			int mapsize,mapsizeafter;
// 			HashMap<String, Integer> map = new HashMap<String, Integer> ();
//             HashSet<String> uniquePairEquations = new HashSet<>();

// 		for (int j=1;j<q+1;j++)
//  		{
			
// 			XSSFRow row = sheet1.createRow(j);
// 					row.createCell(0).setCellValue(j); 
// 					row.createCell(1).setCellValue("Text"); 
// 					row.createCell(2).setCellValue(1);
// 					row.createCell(3).setCellValue("0304060403");
                    
//                     int m1, c1, m2, c2,m3,c3,m4,c4;
//                     String pair,reversePair;
//                     ArrayList<String> quearr = new ArrayList<String>();
//                     ArrayList<String> quearr2 = new ArrayList<String>();
//                     String line1="",line2="";
//                     ArrayList<Integer> xWrPlot =new ArrayList<Integer>();
//                     ArrayList<Integer> yWrPlot =new ArrayList<Integer>();


//                     do {
//                         m1 = (int)(Math.random()*21)- 10; // Slope of first line between -5 and 5
//                         c1 = (int)(Math.random()*21)- 10; // Intercept of first line between -10 and 10
//                         m2 = (int)(Math.random()*21)- 10; // Slope of second line between -5 and 5
//                         c2 = (int)(Math.random()*21)- 10; // Intercept of second line between -10 and 10
//                         m3 = (int)(Math.random()*21)- 10; // Slope of first line between -5 and 5
//                         c3 = (int)(Math.random()*21)- 10; // Intercept of first line between -10 and 10
//                         m4 = (int)(Math.random()*21)- 10; // Slope of second line between -5 and 5
//                         c4 = (int)(Math.random()*21)- 10; // Intercept of second line between -10 and 10
                        
//                         pair = m1 + "," + c1 + ";" + m2 + "," + c2;
//                         reversePair = m2 + "," + c2 + ";" + m1 + "," + c1;
//                     } while ((!uniquePairEquations.add(pair) && !uniquePairEquations.add(reversePair))||(m1==m2 || c1==c2)||(m1==m3)||(m1==m4)||(m2==m3)||(m2==m4)||(m3==m4)||m1==0||m2==0||m3==0||m4==0||c1==0||c2==0||c3==0||c4==0);
//                     System.out.println(j);
//                     for (int x = -5; x <= 5; x++) {
//                         int y = m1 * x + c1;
//                         if(y>=-10 && y<=10){
//                             quearr.add("(" + x + "," + y + ")");
//                         }
//                         // System.out.println("(" + x + ", " + y + ")");
//                     }

// 					for (int x1 = -5; x1 <= 5; x1++) {
//                         int y1 = m2 * x1 + c2;
//                         if(y1>=-10 && y1<=10){
//                             quearr2.add("(" + x1 + "," + y1 + ")");
//                         }
//                         // System.out.println("(" + x1 + ", " + y1 + ")");
        
//                     }
//                     for (int x2 = -5; x2 <= 5; x2++) {
//                         int y2 = m3 * x2 + c3;
//                         if(y2>=-10 && y2<=10 && xWrPlot.size()<=2){
//                             xWrPlot.add(x2);
//                             yWrPlot.add(y2);
//                         }
//                         // System.out.println("(" + x + ", " + y + ")");
//                     }

// 					for (int x3 = -5; x3 <= 5; x3++) {
//                         int y3 = m4 * x3 + c4;
//                         if(y3>=-10 && y3<=10 && xWrPlot.size()<=4){
//                             xWrPlot.add(x3);
//                             yWrPlot.add(y3);
//                         }
//                         // System.out.println("(" + x1 + ", " + y1 + ")");
        
//                     }

//                     if(m1==Math.abs(m1) && c1==Math.abs(c1)){
                
//                         line1=""+(m1==Math.abs(m1) ? (m1==1 ? "-":"-"+m1):(m1==-1 ? "":Math.abs(m1)))+"x+y="+c1+"";
        
//                     }
//                     else if(m1==Math.abs(m1) && c1!=Math.abs(c1)){
                       
//                         line1=""+(m1==Math.abs(m1) ? (m1==1 ? "":m1):(m1==-1 ? "-":m1))+"x-y="+Math.abs(c1)+"";
        
//                     }
//                     else if(m1!=Math.abs(m1) && c1==Math.abs(c1)){
                        
//                         line1=""+(m1==Math.abs(m1) ? (m1==1 ? "-":"-"+m1):(m1==-1 ? "":Math.abs(m1)))+"x+y="+c1+"";
        
//                     }
//                     else if(m1!=Math.abs(m1) && c1!=Math.abs(c1)){
                        
//                         line1=""+(m1==Math.abs(m1) ? (m1==1 ? "-":"-"+m1):(m1==-1 ? "":Math.abs(m1)))+"x+y="+c1+"";
        
//                     }
        
        
//                     if(m2==Math.abs(m2) && c2==Math.abs(c2)){
                        
//                         line2=""+(m2==Math.abs(m2) ? (m2==1 ? "-":"-"+m2):(m2==-1 ? "":Math.abs(m2)))+"x+y="+c2+"";
        
//                     }
//                     else if(m2==Math.abs(m2) && c2!=Math.abs(c2)){
                       
//                         line2=""+(m2==Math.abs(m2) ? (m2==1 ? "":m2):(m2==-1 ? "-":m2))+"x-y="+Math.abs(c2)+"";
        
//                     }
//                     else if(m2!=Math.abs(m2) && c2==Math.abs(c2)){
                        
//                         line2=""+(m2==Math.abs(m2) ? (m2==1 ? "-":"-"+m2):(m2==-1 ? "":Math.abs(m2)))+"x+y="+c2+"";
        
        
//                     }
//                     else if(m2!=Math.abs(m2) && c2!=Math.abs(c2)){
                        
//                         line2=""+(m2==Math.abs(m2) ? (m2==1 ? "-":"-"+m2):(m2==-1 ? "":Math.abs(m2)))+"x+y="+c2+"";
        
//                     }
//                     int prevJ=j;
//                     System.out.println("Ar1: "+quearr.size()+" Ar2: "+quearr2.size());
// 					if(quearr.size()<4 ||quearr2.size()<4){
//                         j--;
//                         quearr.add("(1,1)");
//                         quearr.add("(2,2)");
//                         quearr.add("(3,3)");
//                         quearr.add("(4,4)");
//                         quearr2.add("(1,1)");
//                         quearr2.add("(2,2)");
//                         quearr2.add("(3,3)");
//                         quearr2.add("(4,4)");
//                     }
                    

//                     int sel1,sel2,sel3,sel4;
//                     do{
//                         sel1=(int)(Math.random()*(quearr.size()));
//                         sel2=(int)(Math.random()*(quearr.size()));
//                         sel3=(int)(Math.random()*(quearr.size()));
//                         sel4=(int)(Math.random()*(quearr.size()));
//                     }while(sel1==sel2||sel1==sel3||sel1==sel4||sel2==sel3||sel2==sel4||sel3==sel4);

//                     int sel5,sel6,sel7,sel8;
//                     do{
//                         sel5=(int)(Math.random()*(quearr2.size()));
//                         sel6=(int)(Math.random()*(quearr2.size()));
//                         sel7=(int)(Math.random()*(quearr2.size()));
//                         sel8=(int)(Math.random()*(quearr2.size()));
//                     }while(sel5==sel6||sel5==sel7||sel5==sel8||sel6==sel7||sel6==sel8||sel7==sel8);

//                     String[] inputs = {quearr.get(sel1),quearr.get(sel2),quearr2.get(sel5),quearr2.get(sel6)};
//                     ArrayList<Integer> xPlot =new ArrayList<Integer>();
//                     ArrayList<Integer> yPlot =new ArrayList<Integer>();

//                     for (String input : inputs) {
//                         int[] result = extractNumbers(input);
//                         xPlot.add(result[0]);
//                         yPlot.add(result[1]);
//                     }
//                     if(j>0){
// 					Plot plot = Plot.plot(Plot.plotOpts().
// 								width(800).
// 								height(800).
// 								legend(Plot.LegendFormat.BOTTOM)).	
// 							xAxis("x", Plot.axisOpts().
// 								range(-10, 10)).
// 							yAxis("y", Plot.axisOpts().
// 								range(-10, 10)).
// 							series("Line1 :"+line1, Plot.data().
// 								xy(xPlot.get(0), yPlot.get(0)).
// 								xy(xPlot.get(1), yPlot.get(1)),
// 								Plot.seriesOpts().
// 									line(Plot.Line.SOLID).
// 									color(Color.BLACK).
// 									marker(Plot.Marker.DIAMOND).
// 									markerColor(Color.RED).
// 									markerSize(5)).
// 							series("Line2 :"+line2, Plot.data().
// 									xy(xPlot.get(2), yPlot.get(2)).
// 									xy(xPlot.get(3), yPlot.get(3)),
// 									Plot.seriesOpts().
// 										line(Plot.Line.SOLID).
// 										color(Color.BLUE).
// 										marker(Plot.Marker.SQUARE).
// 										markerColor(Color.RED).
// 										markerSize(5));

// 						plot.save("C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphCorrect-"+j+"", "png");
// 					//Images

//                     Plot plot1 = Plot.plot(Plot.plotOpts().
// 								width(800).
// 								height(800).
// 								legend(Plot.LegendFormat.BOTTOM)).	
// 							xAxis("x", Plot.axisOpts().
// 								range(-10, 10)).
// 							yAxis("y", Plot.axisOpts().
// 								range(-10, 10)).
// 							series("Line1 :"+line1, Plot.data().
// 								xy(xPlot.get(0), yPlot.get(0)).
// 								xy(xPlot.get(1), yPlot.get(1)),
// 								Plot.seriesOpts().
// 									line(Plot.Line.SOLID).
// 									color(Color.BLACK).
// 									marker(Plot.Marker.DIAMOND).
// 									markerColor(Color.RED).
// 									markerSize(5)).
// 							series("Line2 :"+line2, Plot.data().
//                                     xy(xWrPlot.get(0), yWrPlot.get(0)).
//                                     xy(xWrPlot.get(1), yWrPlot.get(1)),
// 									Plot.seriesOpts().
// 										line(Plot.Line.SOLID).
// 										color(Color.BLUE).
// 										marker(Plot.Marker.SQUARE).
// 										markerColor(Color.RED).
// 										markerSize(5));

// 						plot1.save("C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphWrong1-"+j+"", "png");

                    
//                         Plot plot2 = Plot.plot(Plot.plotOpts().
//                                     width(800).
//                                     height(800).
//                                     legend(Plot.LegendFormat.BOTTOM)).	
//                                 xAxis("x", Plot.axisOpts().
//                                      range(-10, 10)).
//                                 yAxis("y", Plot.axisOpts().
//                                     range(-10, 10)).
//                                 series("Line1 :"+line1, Plot.data().
//                                     xy(xWrPlot.get(0), yWrPlot.get(0)).
//                                     xy(xWrPlot.get(1), yWrPlot.get(1)),
//                                     Plot.seriesOpts().
//                                         line(Plot.Line.SOLID).
//                                         color(Color.BLACK).
//                                         marker(Plot.Marker.DIAMOND).
//                                         markerColor(Color.RED).
//                                         markerSize(5)).
//                                 series("Line2 :"+line2, Plot.data().
//                                         xy(xWrPlot.get(2), yWrPlot.get(2)).
//                                         xy(xWrPlot.get(3), yWrPlot.get(3)),
//                                         Plot.seriesOpts().
//                                             line(Plot.Line.SOLID).
//                                             color(Color.BLUE).
//                                             marker(Plot.Marker.SQUARE).
//                                             markerColor(Color.RED).
//                                             markerSize(5));

//                             plot2.save("C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphWrong2-"+j+"", "png");

//                         Plot plot3 = Plot.plot(Plot.plotOpts().
//                                         width(800).
//                                         height(800).
//                                         legend(Plot.LegendFormat.BOTTOM)).	
//                                     xAxis("x", Plot.axisOpts().
//                                         range(-10, 10)).
//                                     yAxis("y", Plot.axisOpts().
//                                         range(-10, 10)).
//                                     series("Line1 :"+line1, Plot.data().
//                                         xy(xWrPlot.get(2), yWrPlot.get(2)).
//                                         xy(xWrPlot.get(3), yWrPlot.get(3)),
//                                         Plot.seriesOpts().
//                                             line(Plot.Line.SOLID).
//                                             color(Color.BLACK).
//                                             marker(Plot.Marker.DIAMOND).
//                                             markerColor(Color.RED).
//                                             markerSize(5)).
//                                     series("Line2 :"+line2, Plot.data().
//                                             xy(xPlot.get(2), yPlot.get(2)).
//                                             xy(xPlot.get(3), yPlot.get(3)),
//                                             Plot.seriesOpts().
//                                                 line(Plot.Line.SOLID).
//                                                 color(Color.BLUE).
//                                                 marker(Plot.Marker.SQUARE).
//                                                 markerColor(Color.RED).
//                                                 markerSize(5));

//                                 plot3.save("C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphWrong3-"+j+"", "png");


// 					String imagePath = "C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphCorrect-"+j+".png";
//                     String imagePath1 = "C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphWrong1-"+j+".png";
//                     String imagePath2 = "C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphWrong2-"+j+".png";
//                     String imagePath3 = "C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphWrong3-"+j+".png";
// 					// int rowNumber = j; 
// 					// int columnNumber = 6; 


// 					// Insert the image into the Excel sheet
// 					insertImageIntoExcel(sheet1, imagePath, j, 6,workbook);
//                     insertImageIntoExcel(sheet1, imagePath1, j, 10,workbook);
//                     insertImageIntoExcel(sheet1, imagePath2, j, 11,workbook);
//                     insertImageIntoExcel(sheet1, imagePath3, j, 12,workbook);
//                     }
					
					

					

// 					String Que1,Que2,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Solu,Solu1;
//                     Que1="For the simultaneous linear equations in two variables $"+line1+", "+line2+"$ the graphs are drawn. Which of the following options shows the correct combined graphs for these equations? <br>";
//                     Que2="#खाली दिलेल्या आलेखांपैकी $"+line1+", "+line2+"$ या दोन एकसामायिक रेषीय समीकरणा साठीचा एकत्रित आलेख कोणता आहे? <br>";

// 					String Question=""+Que1+""+Que2+"";

//                     // Correct_ans="$3$ <br>";
//                     // wrong_ans="$1$ <br>";
//                     // wrong_ans1="$2$ <br>";
//                     // wrong_ans2="$4$ <br>";

// 					row.createCell(4).setCellValue(Question);
// 				    //row.createCell(6).setCellFormula("");
// 		//				 row.createCell(7).setCellValue(" ");
// 		//				 row.createCell(8).setCellValue(" ");
// 					// row.createCell(5).setCellValue(Correct_ans);
// 					// row.createCell(9).setCellValue(wrong_ans);
// 					// row.createCell(10).setCellValue(wrong_ans1);
// 					// row.createCell(11).setCellValue(wrong_ans2);
				
// 					row.createCell(12).setCellValue(360);
// 					row.createCell(13).setCellValue(4);
// 		//				  row.createCell(14).setCellValue(" ");
// 					row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			
//                     Solu="Answer : $3$ <br>"+
//                         "Only way to check the correct graphical representation for the given equations, is to find out various solutions (ordered pairs) satisfying each equation. <br>"+
//                         "Let us consider equation $"+line1+"$ <br>"+
//                         "We will find out various ordered pairs which satisfy this equation, by putting different values for $x$ and solve for $y$. <br>"+
//                         "Accordingly, $"+quearr.get(sel1)+", "+quearr.get(sel2)+", "+quearr.get(sel3)+", "+quearr.get(sel4)+"$ etc. these are the points lying on the graph of $"+line1+"$ <br>"+
//                         "Now we will identify that graph from the given options, on which all these points lye simultaneouly. <br>"+
//                         "All these solutions will be part of a single graph simultaneously. <br>"+
//                         "Thus we have identified the graph corresponding to equation $"+line1+"$ . . . . $(i)$ <br>"+
//                         "We will follow similar procedure for $"+line2+"$. <br>"+
//                         "For this $"+quearr2.get(sel5)+", "+quearr2.get(sel6)+", "+quearr2.get(sel7)+", "+quearr2.get(sel8)+"$ etc. these are the points lying on the graph of $"+line2+"$ <br>"+
//                         "We will identify the graph corresponding to equation $"+line2+"$ . . . . . $(ii)$ <br>"+
//                         "There will be only one combined graph, satisfying condition $(i)$ and $(ii)$ simultaneously. <br>"+
//                         "This graph is the answer for our question. <br>"+
//                         "By inspection, we can see that figure $3$ satisfies these requirements $(i)$ and $(ii)$ simultaneously. <br>In all other options, either for both graphs or for one of the graphs, condition is not satisfied. <br>Hence the graphs in fig. $3$ represents the given equations correctly. <br>";

//                     Solu1="#"+
//                         "उत्तर : $3$<br>"+
//                         "बरोबर आलेख कोणते हे शोधण्याचा एकमेव मार्ग म्हणजे, प्रत्येक समीकरणासाठी त्या समीकरणाचे समाधान करणाऱ्या क्रमित जोड्या (उकली) शोधणे आणि त्या सर्व जोड्यांच्या मदतीने त्या समीकरणाच्या आलेख कोणता हे तपासणे होय. <br>"+
//                         "या नुसार आपण $"+line1+"$ या समीकरणाचे समाधान करणाऱ्या क्रमित जोड्या शोधू. या साठी समीकरणात $x$ च्या वेगवेगळ्या किमती गृहीत धरून नंतर ते समीकरण $y$ साठी सोडवू. <br>या रीतीने आपल्याला $"+quearr.get(sel1)+", "+quearr.get(sel2)+", "+quearr.get(sel3)+", "+quearr.get(sel4)+"$ इ. अशा क्रमित जोड्या (उकली) मिळतात. <br>या सर्व जोड्यांच्या मदतीने $"+line1+"$ या समीकरणा साठीचा योग्य आलेख कोणता ते ठरवू.  . . . . $(i)$ <br>"+
//                         "याच पद्धतीने आता $"+line2+"$ या समीकरणासाठी $"+quearr2.get(sel5)+", "+quearr2.get(sel6)+", "+quearr2.get(sel7)+", "+quearr2.get(sel8)+"$ अशा क्रमित जोड्या (उकली) मिळतात. <br>"+
//                         "या सर्व जोड्यांच्या मदतीने $"+line2+"$ या समीकरणा साठीचा योग्य आलेख कोणता ते ठरवू.  . . . . $(ii)$ <br>"+
//                         "आता असा एकच पर्याय असेल जो $(i)$ आणि $(ii)$ या दोन्ही अटी एकाच वेळी पूर्ण करतो. <br>"+
//                         "निरीक्षण करून आपल्याला आलेख क्र. $3$ या सर्व अटी पूर्ण करतो हे दिसेल. <br>इतर सर्व आलेखांसाठी किमान एक किंवा दोन्ही अटी पूर्ण करीत नाही. <br>म्हणून दिलेल्या आलेखांपैकी आलेख क्र. $3$ हेच बरोबर उत्तर आहे. <br>";

// 					String Solution = ""+Solu+" "+Solu1+"";	
				
				
// 					row.createCell(16).setCellValue(Solution);
// 		//				  row.createCell(17).setCellValue(" ");
// 						row.createCell(18).setCellValue(104);
//                     System.out.println("Quearr :"+quearr+" Quearr2 :"+quearr2+" xPlot: "+xPlot+" yPlot: "+yPlot+" xWrPlot: "+xWrPlot+" yWrPlot: "+yWrPlot+" line1 : "+line1+" line2 : "+line2);

				

// 		String Checker =""+Question+""+Solution+"";//+Correct_ans+""+wrong_ans+""+wrong_ans1+""+wrong_ans2+"";
// 							mapsize = map.size();
// 							map.put(Checker,j);
// 							mapsizeafter = map.size();
						
// 						//In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
// 						if(mapsize == mapsizeafter) {
// 							System.out.println(Checker);
//                             if(prevJ==j){
//                                 j--;
//                             }
// 						}

// 		}

// 			int rowTotal = sheet1.getLastRowNum();
// 	//			  System.out.println(rowTotal);
// 				XSSFRow row = sheet1.createRow(rowTotal+1);
// 				row.createCell(0).setCellValue("****");

// 					//Writing data to the file
// 					FileOutputStream fileout = new FileOutputStream(filename);
// 					workbook.write(fileout);
// 					fileout.close();
					
// 					System.out.println("file created");
			    
// }
// }


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.awt.Color;
import java.util.List;

import java.io.FileInputStream;



import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;

import org.apache.poi.ss.usermodel.*;



import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VLab_0304060403_112_Assign20_Bhushan {

	public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

	public static void insertImageIntoExcel(XSSFSheet sheet, String imagePath, int rowNumber, int columnNumber ,XSSFWorkbook wb) throws IOException {
        // Add the picture to the workbook
        FileInputStream inputStream = new FileInputStream(imagePath);
        byte[] bytes = IOUtils.toByteArray(inputStream);
        int pictureIdx = sheet.getWorkbook().addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
        inputStream.close();

		XSSFCreationHelper helper = wb.getCreationHelper();
        // Create the drawing patriarch
        Drawing drawing = sheet.createDrawingPatriarch();
		

        // Add a picture shape
        //XSSFClientAnchor anchor = new XSSFClientAnchor();
		XSSFClientAnchor anchor = helper.createClientAnchor();
        
        anchor.setCol1(columnNumber);
        anchor.setRow1(rowNumber);
		anchor.setCol2(columnNumber + 1);
        anchor.setRow2(rowNumber+1);
        
        Picture pict = drawing.createPicture(anchor, pictureIdx);
		pict.resize(0.5);
		

		
    }


    public static boolean isPointOnLine(int x, int y, int A, int B, int C) {
        return A * x + B * y == C;
    }

    // Helper method to generate a new point on the line
    public static int[] generatePointOnLine(int A, int B, int C, int xIntersect,int yIntersect,int xIntersect1,int yIntersect1) {
         // Generate two additional points
         // Store unique points to ensure no duplicates
        HashSet<String> uniquePoints = new HashSet<>();
        uniquePoints.add(xIntersect + "," + yIntersect);
        uniquePoints.add(xIntersect1 + "," + yIntersect1);
        int newX1 = 0, newY1 = 0, newX2 = 0, newY2 = 0;
        int t = 1; // Incremental parameter for generating new points
 
        while (true) {
            if (A == 0) { // Special case: Horizontal line (B != 0)
                newY1 = yIntersect; // y-coordinate remains constant
                newX1 = xIntersect1 + t; // Increment x-coordinate

                newY2 = yIntersect; // y-coordinate remains constant
                newX2 = xIntersect - t; // Decrement x-coordinate
            } else if (B == 0) { // Special case: Vertical line (A != 0)
                newX1 = xIntersect; // x-coordinate remains constant
                newY1 = yIntersect1 + t; // Increment y-coordinate

                newX2 = xIntersect; // x-coordinate remains constant
                newY2 = yIntersect - t; // Decrement y-coordinate
            } else { // General case: Solve for points on the line
                newX1 = xIntersect1 + t;
                newY1 = (C - A * newX1) / B; // Solve for y

                newX2 = xIntersect - t;
                newY2 = (C - A * newX2) / B; // Solve for y
            }

            // Ensure points are unique and satisfy the line equation
            if (isPointOnLine(newX1, newY1, A, B, C) &&
                isPointOnLine(newX2, newY2, A, B, C) &&
                uniquePoints.add(newX1 + "," + newY1) &&
                uniquePoints.add(newX2 + "," + newY2)) {
                break; // Found two valid unique points
            }

            t++; // Increment and try again
            
        }
        return new int[]{xIntersect,yIntersect,xIntersect1,yIntersect1,newX1,newY1,newX2,newY2};
    }
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VLab_0304060403_112_Assign20_Bhushan.xlsx";     //Location where excel file is getting generated
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
		
		
		// Set height and width for the image column only
		// int imageColumnWidth = 400/7;
		// sheet1.setColumnWidth(6, imageColumnWidth * 256);  // Adjust the width to fit the image (810 pixels)
		sheet1.setColumnWidth(5, 57*256);
		sheet1.setColumnWidth(9, 57*256);
		sheet1.setColumnWidth(10, 57*256);
		sheet1.setColumnWidth(11, 57*256);
		//Adding header to the second sheet
		for(int head=0; head<header.length; head++) {
			rowhead.createCell(head).setCellValue(header[head]);
			
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of question :");
		int q=sc.nextInt();

		
			int mapsize,mapsizeafter;
			HashMap<String, Integer> map = new HashMap<String, Integer> ();
            HashSet<String> uniquePairEquations = new HashSet<>();

		for (int j=1;j<q+1;j++)
 		{
			
			XSSFRow row = sheet1.createRow(j);
					row.createCell(0).setCellValue(j); 
					row.createCell(1).setCellValue("Text"); 
					row.createCell(2).setCellValue(1);
					row.createCell(3).setCellValue("0304060403");
                    
                    List<int[]> my4x4points = new ArrayList<>();
                    ArrayList<Double> PlotPoints=new ArrayList<Double>();

                    HashSet<String> uniqueLines = new HashSet<>();

                    ArrayList<String> ourLines =new ArrayList<String>();

                    for (int i = 1; i <= 4; i++) {
                        int xIntersect,yIntersect,xIntersect1, yIntersect1, A1, B1, C1,A=0,B=0,C=0;

                        String line;
                        String line1;

                        while (true) {
                            xIntersect = (int)(Math.random()*17)-8; // Intersection x-coordinate between -8 and 8
                            yIntersect = (int)(Math.random()*17)-8; // Intersection y-coordinate between -8 and 8
                            do{
                                
                                xIntersect1=(int)(Math.random()*17)-8;
                                yIntersect1=(int)(Math.random()*17)-8;
                            
                                A1=yIntersect1-yIntersect;
                                B1=xIntersect-xIntersect1;
                            } while ((A1 == B1)|| (A1 <= -10 || A1 >= 10) || (B1 <= -10 || B1>= 10) ||(xIntersect==xIntersect1 && yIntersect==yIntersect1) ); // Ensure A1 and B1 are not  zero
                    
                            C1 = A1 * xIntersect + B1 * yIntersect;

            
                            // Normalize coefficients to avoid duplicates (e.g., 2x + 4y = 6 and x + 2y = 3)
                            int div_num=gcd(Math.abs(A1), gcd(Math.abs(B1), Math.abs(C1)));
                            A1=A1/div_num;
                            B1=B1/div_num;
                            C1=C1/div_num;
        
                            A = A1;
                            B = B1;
                            C = C1;
                            // Ensure a consistent representation for negative coefficients
                            if (A1 < 0 || (A1 == 0 && B1 < 0)) {
                                A = -A1;
                                B = -B1;
                                C = -C1;
                            }

                            // Represent the line as a string for uniqueness check
                            line = A + "," + B + "," + C;
                            if(A1==-Math.abs(A1) && B1==-Math.abs(B1) && C1==-Math.abs(C1) ){
                                A1=Math.abs(A1);
                                B1=Math.abs(B1);
                                C1=Math.abs(C1);
                            }
        
                            if(A1==-Math.abs(A1) && B1==-Math.abs(B1) && C1!=-Math.abs(C1)){
                                A1=Math.abs(A1);
                                B1=Math.abs(B1);
                                C1=-Math.abs(C1);
                            }

                            if(A1==0){
                                line1=""+(B1==Math.abs(B1) ? (B1==1 ? "":""+B1):(B1==-1 ? "-":B1))+"y="+C1+"";	
                                if(C1==0){
                                    line1="y="+C1+"";
                                }	
                            }
                            else if(B1==0){
                                line1=""+(A1==Math.abs(A1) ? (A1==1 ? "":A1):(A1==-1 ? "-":A1))+"x="+C1+"";		
                                if(C1==0){
                                    line1="x="+C1+"";
                                }
                            }
                            else{
                                line1=""+(A1==Math.abs(A1) ? (A1==1 ? "":A1):(A1==-1 ? "-":A1))+"x"+(B1==Math.abs(B1) ? (B1==1 ? "+":"+"+B1):(B1==-1 ? "-":B1))+"y="+C1+"";	
                            }

                            double nx1,nx2,ny1,ny2;

                            if(A1==0){
                                nx1=-10.0;
                                nx2=10.0;
                                ny1=(C1/1.0)/(B1/1.0);
                                ny2=(C1/1.0)/(B1/1.0);
                            }
                            else if(B1==0){
                                nx1=(C1/1.0)/(A1/1.0);
                                nx2=(C1/1.0)/(A1/1.0);
                                ny1=-10.0;
                                ny2=10.0;
                            }
                            else{
                                nx1=-10.0;
                                nx2=10.0;
                                ny1=((-A1/1.0)/(B1/1.0))*(-10)+((C1/1.0)/(B1/1.0));
                                ny2=((-A1/1.0)/(B1/1.0))*(10)+((C1/1.0)/(B1/1.0));
                            }

                            // Check if this line is unique
                            if (uniqueLines.add(line)) {
                                ourLines.add(line1);
                                PlotPoints.add(nx1);
                                PlotPoints.add(ny1);
                                PlotPoints.add(nx2);
                                PlotPoints.add(ny2);
                                break; // Line is unique; proceed
                            }
                        }

                        // Generate two additional points on the line
                        my4x4points.add(generatePointOnLine(A1, B1, C1, xIntersect, yIntersect,xIntersect1, yIntersect1));
                        
                    }



					Plot plot = Plot.plot(Plot.plotOpts().
								width(800).
								height(800).
								legend(Plot.LegendFormat.BOTTOM)).	
							xAxis("x", Plot.axisOpts().
								range(-10, 10)).
							yAxis("y", Plot.axisOpts().
								range(-10, 10)).
							series("Line1 :"+ourLines.get(0), Plot.data().
								xy(PlotPoints.get(0), PlotPoints.get(1)).
								xy(PlotPoints.get(2), PlotPoints.get(3)),
								Plot.seriesOpts().
									line(Plot.Line.SOLID).
									color(Color.BLACK).
									marker(Plot.Marker.DIAMOND).
									markerColor(Color.RED).
									markerSize(5)).
							series("Line2 :"+ourLines.get(1), Plot.data().
                                    xy(PlotPoints.get(4), PlotPoints.get(5)).
                                    xy(PlotPoints.get(6), PlotPoints.get(7)),
									Plot.seriesOpts().
										line(Plot.Line.SOLID).
										color(Color.BLUE).
										marker(Plot.Marker.SQUARE).
										markerColor(Color.RED).
										markerSize(5));

						plot.save("C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphCorrect-"+j+"", "png");
					//Images

                    Plot plot1 = Plot.plot(Plot.plotOpts().
								width(800).
								height(800).
								legend(Plot.LegendFormat.BOTTOM)).	
							xAxis("x", Plot.axisOpts().
								range(-10, 10)).
							yAxis("y", Plot.axisOpts().
								range(-10, 10)).
							series("Line1 :"+ourLines.get(0), Plot.data().
                                xy(PlotPoints.get(0), PlotPoints.get(1)).
                                xy(PlotPoints.get(2), PlotPoints.get(3)),
								Plot.seriesOpts().
									line(Plot.Line.SOLID).
									color(Color.BLACK).
									marker(Plot.Marker.DIAMOND).
									markerColor(Color.RED).
									markerSize(5)).
							series("Line2 :"+ourLines.get(1), Plot.data().
                                    xy(PlotPoints.get(8), PlotPoints.get(9)).
                                    xy(PlotPoints.get(10), PlotPoints.get(11)),
									Plot.seriesOpts().
										line(Plot.Line.SOLID).
										color(Color.BLUE).
										marker(Plot.Marker.SQUARE).
										markerColor(Color.RED).
										markerSize(5));

					plot1.save("C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphWrong1-"+j+"", "png");

                    
                    Plot plot2 = Plot.plot(Plot.plotOpts().
                                    width(800).
                                    height(800).
                                    legend(Plot.LegendFormat.BOTTOM)).	
                                xAxis("x", Plot.axisOpts().
                                     range(-10, 10)).
                                yAxis("y", Plot.axisOpts().
                                    range(-10, 10)).
                                series("Line1 :"+ourLines.get(0), Plot.data().
                                    xy(PlotPoints.get(8), PlotPoints.get(9)).
                                    xy(PlotPoints.get(10), PlotPoints.get(11)),
                                    Plot.seriesOpts().
                                        line(Plot.Line.SOLID).
                                        color(Color.BLACK).
                                        marker(Plot.Marker.DIAMOND).
                                        markerColor(Color.RED).
                                        markerSize(5)).
                                series("Line2 :"+ourLines.get(1), Plot.data().
                                        xy(PlotPoints.get(12), PlotPoints.get(13)).
                                        xy(PlotPoints.get(14), PlotPoints.get(15)),
                                        Plot.seriesOpts().
                                            line(Plot.Line.SOLID).
                                            color(Color.BLUE).
                                            marker(Plot.Marker.SQUARE).
                                            markerColor(Color.RED).
                                            markerSize(5));

                    plot2.save("C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphWrong2-"+j+"", "png");

                    Plot plot3 = Plot.plot(Plot.plotOpts().
                                        width(800).
                                        height(800).
                                        legend(Plot.LegendFormat.BOTTOM)).	
                                    xAxis("x", Plot.axisOpts().
                                        range(-10, 10)).
                                    yAxis("y", Plot.axisOpts().
                                        range(-10, 10)).
                                    series("Line1 :"+ourLines.get(0), Plot.data().
                                        xy(PlotPoints.get(12), PlotPoints.get(13)).
                                        xy(PlotPoints.get(14), PlotPoints.get(15)),
                                        Plot.seriesOpts().
                                            line(Plot.Line.SOLID).
                                            color(Color.BLACK).
                                            marker(Plot.Marker.DIAMOND).
                                            markerColor(Color.RED).
                                            markerSize(5)).
                                    series("Line2 :"+ourLines.get(1), Plot.data().
                                            xy(PlotPoints.get(4), PlotPoints.get(5)).
                                            xy(PlotPoints.get(6), PlotPoints.get(7)),
                                            Plot.seriesOpts().
                                                line(Plot.Line.SOLID).
                                                color(Color.BLUE).
                                                marker(Plot.Marker.SQUARE).
                                                markerColor(Color.RED).
                                                markerSize(5));

                    plot3.save("C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphWrong3-"+j+"", "png");


					String imagePath = "C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphCorrect-"+j+".png";
                    String imagePath1 = "C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphWrong1-"+j+".png";
                    String imagePath2 = "C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphWrong2-"+j+".png";
                    String imagePath3 = "C:\\Users\\bhush\\Downloads\\Assign20_Images\\GraphWrong3-"+j+".png";
					// int rowNumber = j; 
					// int columnNumber = 6; 


					// Insert the image into the Excel sheet
					insertImageIntoExcel(sheet1, imagePath, j,5 ,workbook);
                    insertImageIntoExcel(sheet1, imagePath1, j, 9,workbook);
                    insertImageIntoExcel(sheet1, imagePath2, j, 10,workbook);
                    insertImageIntoExcel(sheet1, imagePath3, j, 11,workbook);
                    
					
					

					

					String Que1,Que2,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Solu,Solu1;
                    Que1="For the simultaneous linear equations in two variables $"+ourLines.get(0)+", "+ourLines.get(1)+"$ the graphs are drawn. Which of the following options shows the correct combined graphs for these equations? <br>";
                    Que2="#खाली दिलेल्या आलेखांपैकी $"+ourLines.get(0)+", "+ourLines.get(1)+"$ या दोन एकसामायिक रेषीय समीकरणा साठीचा एकत्रित आलेख कोणता आहे? <br>";

					String Question=""+Que1+""+Que2+"";

                    // Correct_ans="$3$ <br>";
                    // wrong_ans="$1$ <br>";
                    // wrong_ans1="$2$ <br>";
                    // wrong_ans2="$4$ <br>";

					row.createCell(4).setCellValue(Question);
				    //row.createCell(6).setCellFormula("");
		//				 row.createCell(7).setCellValue(" ");
		//				 row.createCell(8).setCellValue(" ");
					// row.createCell(5).setCellValue(Correct_ans);
					// row.createCell(9).setCellValue(wrong_ans);
					// row.createCell(10).setCellValue(wrong_ans1);
					// row.createCell(11).setCellValue(wrong_ans2);
				
					row.createCell(12).setCellValue(360);
					row.createCell(13).setCellValue(4);
		//				  row.createCell(14).setCellValue(" ");
					row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
                    String P1list="",P2list="";

                    P1list="("+my4x4points.get(0)[0]+","+my4x4points.get(0)[1]+"), ("+my4x4points.get(0)[2]+","+my4x4points.get(0)[3]+"), ("+my4x4points.get(0)[4]+","+my4x4points.get(0)[5]+"), ("+my4x4points.get(0)[6]+","+my4x4points.get(0)[7]+")";
                    P2list="("+my4x4points.get(1)[0]+","+my4x4points.get(1)[1]+"), ("+my4x4points.get(1)[2]+","+my4x4points.get(1)[3]+"), ("+my4x4points.get(1)[4]+","+my4x4points.get(1)[5]+"), ("+my4x4points.get(1)[6]+","+my4x4points.get(1)[7]+")";
                    int randomAnswer=(int)(Math.random()*4)+1;
                    Solu="Answer : $"+randomAnswer+"$ <br>"+
                        "Only way to check the correct graphical representation for the given equations, is to find out various solutions (ordered pairs) satisfying each equation. <br>"+
                        "Let us consider equation $"+ourLines.get(0)+"$ <br>"+
                        "We will find out various ordered pairs which satisfy this equation, by putting different values for $x$ and solve for $y$. <br>"+
                        "Accordingly, $"+P1list+"$ etc. these are the points lying on the graph of $"+ourLines.get(0)+"$ <br>"+
                        "Now we will identify that graph from the given options, on which all these points lye simultaneouly. <br>"+
                        "All these solutions will be part of a single graph simultaneously. <br>"+
                        "Thus we have identified the graph corresponding to equation $"+ourLines.get(0)+"$ . . . . $(i)$ <br>"+
                        "We will follow similar procedure for $"+ourLines.get(1)+"$. <br>"+
                        "For this $"+P2list+"$ etc. these are the points lying on the graph of $"+ourLines.get(1)+"$ <br>"+
                        "We will identify the graph corresponding to equation $"+ourLines.get(1)+"$ . . . . . $(ii)$ <br>"+
                        "There will be only one combined graph, satisfying condition $(i)$ and $(ii)$ simultaneously. <br>"+
                        "This graph is the answer for our question. <br>"+
                        "By inspection, we can see that figure $"+randomAnswer+"$ satisfies these requirements $(i)$ and $(ii)$ simultaneously. <br>In all other options, either for both graphs or for one of the graphs, condition is not satisfied. <br>Hence the graphs in fig. $"+randomAnswer+"$ represents the given equations correctly. <br>";

                    Solu1="#"+
                        "उत्तर : $"+randomAnswer+"$<br>"+
                        "बरोबर आलेख कोणते हे शोधण्याचा एकमेव मार्ग म्हणजे, प्रत्येक समीकरणासाठी त्या समीकरणाचे समाधान करणाऱ्या क्रमित जोड्या (उकली) शोधणे आणि त्या सर्व जोड्यांच्या मदतीने त्या समीकरणाच्या आलेख कोणता हे तपासणे होय. <br>"+
                        "या नुसार आपण $"+ourLines.get(0)+"$ या समीकरणाचे समाधान करणाऱ्या क्रमित जोड्या शोधू. या साठी समीकरणात $x$ च्या वेगवेगळ्या किमती गृहीत धरून नंतर ते समीकरण $y$ साठी सोडवू. <br>या रीतीने आपल्याला $"+P1list+"$ इ. अशा क्रमित जोड्या (उकली) मिळतात. <br>या सर्व जोड्यांच्या मदतीने $"+ourLines.get(0)+"$ या समीकरणा साठीचा योग्य आलेख कोणता ते ठरवू.  . . . . $(i)$ <br>"+
                        "याच पद्धतीने आता $"+ourLines.get(1)+"$ या समीकरणासाठी $"+P2list+"$ अशा क्रमित जोड्या (उकली) मिळतात. <br>"+
                        "या सर्व जोड्यांच्या मदतीने $"+ourLines.get(1)+"$ या समीकरणा साठीचा योग्य आलेख कोणता ते ठरवू.  . . . . $(ii)$ <br>"+
                        "आता असा एकच पर्याय असेल जो $(i)$ आणि $(ii)$ या दोन्ही अटी एकाच वेळी पूर्ण करतो. <br>"+
                        "निरीक्षण करून आपल्याला आलेख क्र. $"+randomAnswer+"$ या सर्व अटी पूर्ण करतो हे दिसेल. <br>इतर सर्व आलेखांसाठी किमान एक किंवा दोन्ही अटी पूर्ण करीत नाही. <br>म्हणून दिलेल्या आलेखांपैकी आलेख क्र. $"+randomAnswer+"$ हेच बरोबर उत्तर आहे. <br>";

					String Solution = ""+Solu+" "+Solu1+"";	
                    int prevJ=j;
                    if(!uniquePairEquations.add(""+ourLines.get(0)+","+ourLines.get(1)+"")&&!uniquePairEquations.add(""+ourLines.get(1)+","+ourLines.get(0)+"")){
                        j--;
                    }
                    

					row.createCell(16).setCellValue(Solution);
					row.createCell(17).setCellValue(imagePath);
					row.createCell(18).setCellValue(112);

				

		String Checker =""+Question+""+Solution+"";//+Correct_ans+""+wrong_ans+""+wrong_ans1+""+wrong_ans2+"";
							mapsize = map.size();
							map.put(Checker,j);
							mapsizeafter = map.size();
						
						//In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
						if(mapsize == mapsizeafter) {
							System.out.println(Checker);
                            if(prevJ==j){
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