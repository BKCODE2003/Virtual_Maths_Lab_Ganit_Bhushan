import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.Color;

import java.io.FileInputStream;



import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;

import org.apache.poi.ss.usermodel.*;



import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VLab_0304060403_104_1_Assign12_Bhushan {

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

	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VLab_0304060403_104_1_Assign12_Bhushan.xlsx";     //Location where excel file is getting generated
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
		sheet1.setColumnWidth(6, 57*256);
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
			// VESIT_0304060403_104_Assign12_Bhushan objs=new VESIT_0304060403_104_Assign12_Bhushan();
			
			// VESIT_0304060403_104_Assign12_Bhushan.MessagePrinter obj=objs.new MessagePrinter();
			
			XSSFRow row = sheet1.createRow(j);
					row.createCell(0).setCellValue(j); 
					row.createCell(1).setCellValue("Text"); 
					row.createCell(2).setCellValue(1);
					row.createCell(3).setCellValue("0304060403");
                    

					// Generate a random intersection point within the range -10 to 10
                    int xIntersect = (int)(Math.random()*17)-8; // Intersection x-coordinate between -8 and 8
                    int yIntersect = (int)(Math.random()*17)-8; // Intersection y-coordinate between -8 and 8
            
            
                    // Generate coefficients for the first line (A1, B1, C1)
                    int A1, B1, C1;
                    do {
                        A1 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
                        B1 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
                    } while (A1 == 0 && B1 == 0); // Ensure A1 and B1 are not both zero
            
                    // Calculate C1 such that (xIntersect, yIntersect) is a solution
                    C1 = A1 * xIntersect + B1 * yIntersect;
            
                    // Generate coefficients for the second line (A2, B2, C2)
                    int A2, B2, C2;
                    do {
                        A2 = (int)(Math.random()*21)-10; // Coefficient A2 between -10 and 10
                        B2 = (int)(Math.random()*21)-10; // Coefficient B2 between -10 and 10
                    } while ((A2 == 0 && B2 == 0) || (A1 * B2 == A2 * B1)); // Ensure lines are not parallel and A2, B2 are not both zero
            
                    // Calculate C2 such that (xIntersect, yIntersect) is also a solution for the second line
                    C2 = A2 * xIntersect + B2 * yIntersect;
            
					
                    String line1,line2;
					
					
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

					if(A2==0){
						line2=""+(B2==Math.abs(B2) ? (B2==1 ? "":""+B2):(B2==-1 ? "-":B2))+"y="+C2+"";
						if(C2==0){
							line2="y="+C2+"";
						}	
					}
					else if(B2==0){
						line2=""+(A2==Math.abs(A2) ? (A2==1 ? "":A2):(A2==-1 ? "-":A2))+"x="+C2+"";
						if(C2==0){
							line2="x="+C2+"";
						}	
					}
					else{
						line2=""+(A2==Math.abs(A2) ? (A2==1 ? "":A2):(A2==-1 ? "-":A2))+"x"+(B2==Math.abs(B2) ? (B2==1 ? "+":"+"+B2):(B2==-1 ? "-":B2))+"y="+C2+"";
					}


					double nx1,nx2,nx3,nx4,ny1,ny2,ny3,ny4;

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

					if(A2==0){
						nx3=-10.0;
						nx4=10.0;
						ny3=(C2/1.0)/(B2/1.0);
						ny4=(C2/1.0)/(B2/1.0);
					}
					else if(B2==0){
						nx3=(C2/1.0)/(A2/1.0);
						nx4=(C2/1.0)/(A2/1.0);
						ny3=-10.0;
						ny4=10.0;
					}
					else{
						nx3=-10.0;
						nx4=10.0;
						ny3=((-A2/1.0)/(B2/1.0))*(-10)+((C2/1.0)/(B2/1.0));
						ny4=((-A2/1.0)/(B2/1.0))*(10)+((C2/1.0)/(B2/1.0));
					}

					//Images
					Plot plot = Plot.plot(Plot.plotOpts().
								width(800).
								height(800).
								legend(Plot.LegendFormat.BOTTOM)).	
							xAxis("x", Plot.axisOpts().
								range(-10, 10)).
							yAxis("y", Plot.axisOpts().
								range(-10, 10)).
							series("Line-1 : "+line1+" ", Plot.data().
								xy(nx1, ny1).
								xy(nx2, ny2),
								Plot.seriesOpts().
									line(Plot.Line.SOLID).
									color(Color.BLACK).
									marker(Plot.Marker.DIAMOND).
									markerColor(Color.RED).
									markerSize(5)).
							series("Line-2 : "+line2+" ", Plot.data().
									xy(nx3, ny3).
									xy(nx4,ny4),
									Plot.seriesOpts().
										line(Plot.Line.SOLID).
										color(Color.BLUE).
										marker(Plot.Marker.SQUARE).
										markerColor(Color.RED).
										markerSize(5)).
							series("Intersection", Plot.data().
										xy(xIntersect,yIntersect),
										Plot.seriesOpts().
											line(Plot.Line.NONE).
											color(Color.BLACK).
											marker(Plot.Marker.CIRCLE).
											markerColor(Color.RED).
											markerSize(12));

					plot.save("C:\\Users\\bhush\\Downloads\\Assign12_Images\\Graph"+j+"", "png");
											//Images
						
				String imagePath = "C:\\Users\\bhush\\Downloads\\Assign12_Images\\Graph"+j+".png";
					// int rowNumber = j; 
					// int columnNumber = 6; 


					// Insert the image into the Excel sheet
					insertImageIntoExcel(sheet1, imagePath, j, 6,workbook);

					
					ArrayList<String> quearr = new ArrayList<String>();
					quearr.add(line1);
					quearr.add(line2);
				
					
				

					String Que1,Que2,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Solu,Solu1;
                    Que1="If the graphs of $ "+quearr.get(0)+","+quearr.get(1)+"$ intersect each other at $ ("+xIntersect+","+yIntersect+")$ then which of the following points will satisfy both the given equations simultaneously? <br>$ ("+yIntersect+","+xIntersect+"), ("+(xIntersect+1)+","+(yIntersect+1)+"), ("+A1+","+B1+"), ("+B2+","+A2+")$ <br>";
                    Que2="#जर $ "+quearr.get(0)+","+quearr.get(1)+"$ या दोन एकसामायिक रेषीय समीकरणांचा छेदन बिंदू $ ("+xIntersect+","+yIntersect+")$ हा असेल तर, या बिंदू शिवाय खालील पैकी आणखीन कोणते बिंदू दिलेल्या समीकरणांचें एकाच वेळी समाधान करतील? <br>$ ("+yIntersect+","+xIntersect+"), ("+(xIntersect+1)+","+(yIntersect+1)+"), ("+A1+","+B1+"), ("+B2+","+A2+")$ <br>";


					if(xIntersect==yIntersect){
						Que1="If the graphs of $ "+quearr.get(0)+","+quearr.get(1)+"$ intersect each other at $ ("+xIntersect+","+yIntersect+")$ then which of the following points will satisfy both the given equations simultaneously? <br>$ ("+C1+","+xIntersect+"), ("+(xIntersect+1)+","+(yIntersect-1)+"), ("+A1+","+B1+"), ("+B2+","+A2+")$ <br>";
						Que2="#जर $ "+quearr.get(0)+","+quearr.get(1)+"$ या दोन एकसामायिक रेषीय समीकरणांचा छेदन बिंदू $ ("+xIntersect+","+yIntersect+")$ हा असेल तर, या बिंदू शिवाय खालील पैकी आणखीन कोणते बिंदू दिलेल्या समीकरणांचें एकाच वेळी समाधान करतील? <br>$ ("+C1+","+xIntersect+"), ("+(xIntersect+1)+","+(yIntersect-1)+"), ("+A1+","+B1+"), ("+B2+","+A2+")$ <br>";		
					}
					String Question=""+Que1+""+Que2+"";

                    Correct_ans="None of the given <br>#दिलेल्या पैकी कोणतेच नाही<br>";
                    wrong_ans="$ ("+yIntersect+","+xIntersect+")$ <br>";
                    wrong_ans1="$ ("+(xIntersect+1)+","+(yIntersect+1)+")$ <br>";
                    wrong_ans2="$ ("+A1+","+B1+")$ <br>";

					if(xIntersect==yIntersect){
						wrong_ans="$ ("+B1+","+xIntersect+")$ <br>";
						wrong_ans1="$ ("+(xIntersect+1)+","+(yIntersect-1)+")$ <br>";
						wrong_ans2="$ ("+A1+","+B1+")$ <br>";
					}
					row.createCell(4).setCellValue(Question);
				    //row.createCell(6).setCellFormula("");
		//				 row.createCell(7).setCellValue(" ");
		//				 row.createCell(8).setCellValue(" ");
					row.createCell(5).setCellValue(Correct_ans);
					row.createCell(9).setCellValue(wrong_ans);
					row.createCell(10).setCellValue(wrong_ans1);
					row.createCell(11).setCellValue(wrong_ans2);
				
					row.createCell(12).setCellValue(60);
					row.createCell(13).setCellValue(2);
				//	row.createCell(14).setCellValue("");
					row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			
                    Solu="Ans : None of the given<br>Point of intersection of the graphs for linear equations, lies on both the graphs simultaneously and it also satisfies both the equations simultaneously. As, we know that the solution for simultaneous equations is always unique, and therefore, there can't be any other point apart from $ ("+xIntersect+","+yIntersect+")$  which will lie on both the graphs simultaneously. <br>Hence None of the given is the answer. <br>";
					Solu1="#उत्तर : दिलेल्या पैकी काहीही नाही<br>दिलेल्या एकसामायिक रेषीय समीकरणांचा छेदन बिंदू, हा त्यांच्या दोन्ही आलेखाचा भाग असतो, तसेच तो बिंदू दोन्ही समीकरणांचें समाधान देखील करतो. आपल्याला हे माहिती आहे की, एकसामायिक रेषीय समीकरणांचे समाधान फक्त एकच असते आणि म्हणून $ ("+xIntersect+","+yIntersect+")$ या शिवाय दुसरा कोणताही बिंदू या दोन्ही समीकरणांचें एकाच वेळी समाधान करणार नाहीत. <br>म्हणून दिलेल्या पैकी काहीही नाही हे उत्तर. <br>";

					String Solution = ""+Solu+" "+Solu1+"";	
				
				
					row.createCell(16).setCellValue(Solution);
					row.createCell(17).setCellValue(imagePath);
						row.createCell(18).setCellValue(104);

				

		String Checker =""+line1+""+line2+""+xIntersect+""+yIntersect+"";
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