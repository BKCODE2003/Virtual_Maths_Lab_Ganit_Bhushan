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

public class VLab_0304060403_113_Assign21_Bhushan {

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
		String filename = "D:/excel files/VLab_0304060403_113_Assign21_Bhushan.xlsx";     //Location where excel file is getting generated
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
					double pI1=0,pI2=0;
					int checkIx=0,checkIy=0,checkA1=0,checkB1=0;
                    for (int i = 1; i <= 4; i++) {
                        int xIntersect,yIntersect,xIntersect1, yIntersect1, A1=0, B1=0, C1=0,A=0,B=0,C=0;

                        String line;
                        String line1;
						
						
                        while (true) {

                            if(i==1){
                                do{
                                    xIntersect=(int)(Math.random()*17)-8;
                                    yIntersect=(int)(Math.random()*17)-8;
                                }while(xIntersect==0 && yIntersect==0);
                                checkIx=xIntersect;
                                checkIy=yIntersect;
                                checkA1=A1;
                                checkB1=B1;

                                do {
                                    A1 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
                                    B1 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
                                } while (A1==B1); // Ensure A1 and B1 are same at a time  zero
                
                                C1 = A1 * xIntersect + B1 * yIntersect;
                            }
                            else if(i==2){
                                do {
                                    A1 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
                                    B1 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
                                } while ((A1 == B1 )|| (A1==checkA1 && B1==checkB1)); // Ensure A1 and B1 are not  zero
                
                                C1 = A1 * checkIx + B1 * checkIy;
                            }
                            else{
                                xIntersect = (int)(Math.random()*17)-8; // Intersection x-coordinate between -8 and 8
                                yIntersect = (int)(Math.random()*17)-8; // Intersection y-coordinate between -8 and 8
                                do{
                                    
                                    xIntersect1=(int)(Math.random()*17)-8;
                                    yIntersect1=(int)(Math.random()*17)-8;
                                
                                    A1=yIntersect1-yIntersect;
                                    B1=xIntersect-xIntersect1;
                                } while ((A1 == B1)|| (A1 <= -10 || A1 >= 10) || (B1 <= -10 || B1>= 10) ||(xIntersect==xIntersect1 && yIntersect==yIntersect1) ); // Ensure A1 and B1 are not  zero
                        
                                C1 = A1 * xIntersect + B1 * yIntersect;
                            }
            
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
                        // my4x4points.add(generatePointOnLine(A1, B1, C1, xIntersect, yIntersect,xIntersect1, yIntersect1));
                        
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
										markerSize(5)).
                            series("Point", Plot.data().
                                        xy(checkIx,checkIy),
                                        Plot.seriesOpts().
                                                line(Plot.Line.NONE).
                                                color(Color.BLACK).
                                                marker(Plot.Marker.CIRCLE).
                                                markerColor(Color.RED).
                                                markerSize(12));
						plot.save("C:\\Users\\bhush\\Downloads\\Assign21_Images\\GraphCorrect-"+j+"", "png");
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

					plot1.save("C:\\Users\\bhush\\Downloads\\Assign21_Images\\GraphWrong1-"+j+"", "png");

                    
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

                    plot2.save("C:\\Users\\bhush\\Downloads\\Assign21_Images\\GraphWrong2-"+j+"", "png");

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

                    plot3.save("C:\\Users\\bhush\\Downloads\\Assign21_Images\\GraphWrong3-"+j+"", "png");


					String imagePath = "C:\\Users\\bhush\\Downloads\\Assign21_Images\\GraphCorrect-"+j+".png";
                    String imagePath1 = "C:\\Users\\bhush\\Downloads\\Assign21_Images\\GraphWrong1-"+j+".png";
                    String imagePath2 = "C:\\Users\\bhush\\Downloads\\Assign21_Images\\GraphWrong2-"+j+".png";
                    String imagePath3 = "C:\\Users\\bhush\\Downloads\\Assign21_Images\\GraphWrong3-"+j+".png";
					// int rowNumber = j; 
					// int columnNumber = 6; 


					// Insert the image into the Excel sheet
					insertImageIntoExcel(sheet1, imagePath, j,5 ,workbook);
                    insertImageIntoExcel(sheet1, imagePath1, j, 9,workbook);
                    insertImageIntoExcel(sheet1, imagePath2, j, 10,workbook);
                    insertImageIntoExcel(sheet1, imagePath3, j, 11,workbook);
                    
					


					

					String Que1,Que2,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Solu,Solu1;
                    Que1="For the simultaneous linear equations in two variables, $"+ourLines.get(0)+", "+ourLines.get(1)+"$ the graphs are drawn. Identify the correct graph from the given options and therefrom find the soluiton for these equations. <br>";
                    Que2="#$"+ourLines.get(0)+", "+ourLines.get(1)+"$ या दोन एकसामायिक रेषीय समीकरणांसाठीचे आलेख खाली दिलेले आहेत. दिलेल्या पर्यायातून त्यातील योग्य आलेख शोधून त्या वरून या समीकरणांचे समाधान करणारी क्रमित जोडी (उकल) कोणती आहे ते ठरवा. <br>";

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
				
					row.createCell(12).setCellValue(120);
					row.createCell(13).setCellValue(4);
		//				  row.createCell(14).setCellValue(" ");
					row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
                    // String P1list="",P2list="";

                    // P1list="("+my4x4points.get(0)[0]+","+my4x4points.get(0)[1]+"), ("+my4x4points.get(0)[2]+","+my4x4points.get(0)[3]+"), ("+my4x4points.get(0)[4]+","+my4x4points.get(0)[5]+"), ("+my4x4points.get(0)[6]+","+my4x4points.get(0)[7]+")";
                    // P2list="("+my4x4points.get(1)[0]+","+my4x4points.get(1)[1]+"), ("+my4x4points.get(1)[2]+","+my4x4points.get(1)[3]+"), ("+my4x4points.get(1)[4]+","+my4x4points.get(1)[5]+"), ("+my4x4points.get(1)[6]+","+my4x4points.get(1)[7]+")";
                    int randomNumber=(int)(Math.random()*4);
					char choiceG = 'A';
                    char randomAnswer=(char)(choiceG+randomNumber);
					// Solu="Answer : $"+randomAnswer+"$ and $("+checkIx+","+checkIy+")$ <br>"+
					// 		"In graphical method of finding the solution of simultaneous linear equations, we plot the graphs of both equations on same graphpaper. We know that the coordinates of the point of intersection of these graphs will be the solution for given simultaneous linear equations. <br>"+
					// 		"But, we are provided with four different combinations of the graphs.<br> Therefore, we need to identify the combination, which represents the correct graphs for the given simultaneous linear equations. <br>"+
					// 		"For this, we need to find out a set of ordered pairs (points), which satisfies the given equations. <br>"+
					// 		"Accordingly for $"+ourLines.get(0)+"$, the set of ordered pairs is $"+P1list+"$ and <br>"+
					// 		"for $"+ourLines.get(1)+"$, the set of ordered pairs is $"+P2list+"$ etc. <br>"+
					// 		"By inspection, we can identify that option $"+randomAnswer+"$ represents the correct graph. <br>"+
					// 		"In all other options, either for both graphs or for one of the graphs, condition is not satisfied. <br> Now by observing graphs in correct option $"+randomAnswer+"$, we can observe that, $x="+pI1+",\\ y="+pI2+"$ is the point of intersection for this graph. <br> $\\therefore$ ordered pair $("+pI1+","+pI2+")$ is the solution of the given simultaneous linear equations, is the answer. <br>";
                   
					// Solu1="#उत्तर : $"+randomAnswer+"$ आणि $("+checkIx+","+checkIy+")$ <br>"+
					// 		"एकसामायिक रेषीय समीकरणासाठीचे समाधान शोधण्याच्या आलेख पद्धतीत आपण प्रथम दिलेल्या समीकरणांसाठी आलेख काढतो. त्या आलेखांच्या छेदन बिंदूचे (क्रमित जोडीचे) निर्देशांक म्हणजेच एकसामायिक रेषीय समीकरणासाठीचे समाधान (उकल) असते. <br>"+
					// 		"परंतु आपल्याला येथे चार आलेख दिलेले आहेत. म्हणून आपल्याला आधी यातला असा पर्याय शोधायला हवा जो दिलेल्या समीकरणांसाठी बरोबर आलेख आहे. <br>या साठी आपण दिलेली समीकरणांचे समाधान करणाऱ्या क्रमित जोड्या शोधू. <br>"+
					// 		"त्या नुसार<br> $"+ourLines.get(0)+"$, या समीकरणासाठी<br> $"+P1list+"$ अशा क्रमित जोड्या मिळतात आणि <br>"+
					// 		"$"+ourLines.get(1)+"$ या समीकरणासाठी<br> $"+P2list+"$ अशा क्रमित जोड्या मिळतात. <br>तपासणी पद्धतीने आपल्याला  $"+randomAnswer+"$ हा पर्याय बरोबर असल्याचे कळते. <br>बाकी सर्व पर्यायात किमान एक तरी आलेख असा आहे जो दिलेल्या पैकी कोणत्या तरी एका किंवा दोन्ही समीकरणा साठी योग्य नाही. <br>आता $"+randomAnswer+"$ या आलेखाचे निरीक्षण करून, त्याच्या छेदन बिंदूचे निर्देशांक $x="+pI1+",\\ y="+pI2+"$ आहेत हे कळते. <br> $\\therefore$ छेदन बिंदू (क्रमित जोडी) $("+pI1+","+pI2+")$ ही दिलेल्या समीकरणांची उकल आहे हे उत्तर. <br>";
					
                    // Solu="Answer : $"+randomAnswer+"$ and $("+checkIx+","+checkIy+")$ <br> " + 
                    //                             "Let us understand first, that the point of intersection for the correct graphs, will be satisfying the given equations. <br>" +
                    //                             "The point of intersection of both graphs will be a point lying on both lines simultaneously. <br>Graphs of lines are the graphs for the given equations. <br> Thus the point of intersection will necessarily satisfy the given equations. <br>" + 
                    //                             "Therefore, we will check, if the point of intersections of all pairs of graphs, satisfies the given equations. <br>" + 
                    //                             "We will substitute the values of $x$ and $y$ corresponding to each point of intersection in the given pair of equations. <br>If both the equations get satisfied simultaneously, then this is the required graph and the corresponding point of intersection is the required point of intersection. <br>" + 
                    //                             "Accordingly, the point of intersection corresponding to $"+randomAnswer+"$, satisfies the given equations. <br>and <br>$("+checkIx+","+checkIy+")$ is the required point of intersection is the answer. <br>";

                    // Solu1="#उत्तर : $"+randomAnswer+"$ आणि $("+checkIx+","+checkIy+")$ <br>" +
                    //         "आपण प्रथम हे लक्षात घेऊ की, योग्य (हव्या असलेल्या) आलेखांचा छेदन बिंदू हा दिलेल्या दोन्ही समीकरणांची उकल असेल म्हणजेच त्यांचे समाधान करेल. <br>" +
                    //         "दोन्ही समीकरणांच्या आलेखांचा छेदन बिंदू हा त्या दोन्ही आलेखांवर असतोच. <br>" +
                    //         "म्हणजेच दोन्ही आलेखांचा छेदन बिंदू हा दोन्ही समीकरणांचे समाधान करणारच असेल. <br>" +
                    //         "म्हणून, आपण प्रत्येक आलेखातील छेदन बिंदू विचारात घेऊ आणि हा छेदन बिंदू दिलेल्या समीकरणांचे समाधान करतो किंवा कसे हे तपासू. <br>" +
                    //         "या साठी प्रत्येक छेदन बिंदूच्या $x$ आणि $y$ च्या किमती दिलेल्या समीकरणात ठेवू. <br>जर या किमती नुसार दिलेल्या समीकरणांचे समाधान होत असेल तर हा छेदन बिंदू असलेले आलेख म्हणजेच आपल्याला हवा असलेला आलेख असेल. <br>" +
                    //         "म्हणजेच आपल्याला हवा असलेला आलेख म्हणजे पर्याय $"+randomAnswer+"$ आहे. <br>आणि छेदन बिंदू $("+checkIx+","+checkIy+")$ हा आहे, हे उत्तर. <br>";

                    Solu="Answer : $"+randomAnswer+"$ and $("+checkIx+","+checkIy+")$ <br> " + //
                                                "Let us understand first, that the point of intersection for the correct graphs, will be satisfying the given equations. <br>" +
                                                "The point of intersection of graphs will be a point lying on both lines simultaneously. <br>Graphs of lines are the graphs for the given equations. <br> Thus the point of intersection will necessarily satisfy the given equations. <br>" + 
                                                "Therefore, we will check, if the point of intersection of all pairs of graphs, satisfy the given equations0/. <br>" + 
                                                "We will substitute the values of $x$ and $y$ corresponding to each point of intersection in the given pair of equations. <br>If both the equations get satisfied simultaneously, then this is the required graph and the corresponding point of intersection is the required point of intersection. <br>" + 
                                                "Accordingly, the point of intersection corresponding to $"+randomAnswer+"$, satisfies the given equations and $("+checkIx+","+checkIy+")$ is the required point of intersection is the answer. <br>";

                    Solu1="#उत्तर : $"+randomAnswer+"$ आणि $("+checkIx+","+checkIy+")$ <br>" +
                            "आपण प्रथम हे लक्षात घेऊ की, योग्य (हव्या असलेल्या) आलेखांचा छेदन बिंदू हा दिलेल्या दोन्ही समीकरणांची उकल असेल म्हणजेच त्यांचे समाधान करेल. <br>" +
                            "दोन्ही समीकरणांच्या आलेखांचा छेदन बिंदू हा त्या दोन्ही आलेखांवर असतोच. <br>" +
                            "म्हणजेच दोन्ही आलेखांचा छेदन बिंदू हा दोन्ही समीकरणांचे समाधान करणारा असेलच. <br>" +
                            "म्हणून, आपण प्रत्येक आलेखातील छेदन बिंदू विचारात घेऊ आणि हा छेदन बिंदू दिलेल्या समीकरणांचे समाधान करतो किंवा कसे हे तपासू. <br>" +
                            "या साठी प्रत्येक छेदन बिंदूच्या $x$ आणि $y$ च्या किमती दिलेल्या समीकरणात ठेवू. <br>जर या किमती नुसार दिलेल्या समीकरणांचे समाधान होत असेल तर हा छेदन बिंदू असलेला आलेख म्हणजेच आपल्याला हवा असलेला आलेख असेल. <br>" +
                            "म्हणजेच आपल्याला हवा असलेला आलेख म्हणजे पर्याय $"+randomAnswer+"$ आहे. <br>आणि छेदन बिंदू $("+checkIx+","+checkIy+")$ हा आहे, हे उत्तर. <br>";


					String Solution = ""+Solu+" "+Solu1+"";	
                    int prevJ=j;
                    if(!uniquePairEquations.add(""+ourLines.get(0)+","+ourLines.get(1)+"")&&!uniquePairEquations.add(""+ourLines.get(1)+","+ourLines.get(0)+"")){
                        j--;
                    }
                    

					row.createCell(16).setCellValue(Solution);
                    row.createCell(17).setCellValue(imagePath);
					row.createCell(18).setCellValue(113);

				

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