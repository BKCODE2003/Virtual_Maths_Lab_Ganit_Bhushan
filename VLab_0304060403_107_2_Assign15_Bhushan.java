// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;
// import java.io.IOException;

// import java.util.ArrayList;
// import java.util.HashMap;
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

// public class VLab_0304060403_107_2_Assign15_Bhushan {

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

// 	public static void main(String args[]) throws IOException,FileNotFoundException{
// 		String filename = "D:/excel files/VLab_0304060403_107_2_Assign15_Bhushan.xlsx";     //Location where excel file is getting generated
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
// 		//Adding header to the second sheet
// 		for(int head=0; head<header.length; head++) {
// 			rowhead.createCell(head).setCellValue(header[head]);
			
// 		}
// 		Scanner sc=new Scanner(System.in);
// 		System.out.println("Enter Number of question :");
// 		int q=sc.nextInt();

		
// 			int mapsize,mapsizeafter;
// 			HashMap<String, Integer> map = new HashMap<String, Integer> ();
		
// 			for (int j=1;j<q+1;j++)
//  		{
			
// 			XSSFRow row = sheet1.createRow(j);
// 					row.createCell(0).setCellValue(j); 
// 					row.createCell(1).setCellValue("Text"); 
// 					row.createCell(2).setCellValue(5);
// 					row.createCell(3).setCellValue("0304060403");
                    

// 					// Generate a random intersection point within the range -10 to 10
// 					int qx1,qy1,qx2,qy2,qx3,qy3,xIntersect,yIntersect;
// 					int A1, B1, C1, A2, B2, C2, A3, B3, C3, A4, B4, C4, A5, B5, C5, A6=0, B6=0, C6=0;
// 					String line1,line2,line3,line4,line5,line6="";
// 					double pd1,pd2,pd3;

// 					do{
// 						do{
// 						xIntersect=(int)(Math.random()*17)-8;
// 						yIntersect=(int)(Math.random()*17)-8;
// 						}while(xIntersect==0 && yIntersect==0);

// 						do {
// 							A4 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
// 							B4 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
// 						} while ((A4 == 0 && B4 == 0)); // Ensure A1 and B1 are not  zero
				
// 						C4 = A4 * xIntersect + B4 * yIntersect;

// 						do {
// 							A5 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
// 							B5 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
// 						} while ((A5 == 0 && B5 == 0 )|| (A4==A5 && B4==B5)); // Ensure A1 and B1 are not  zero
				
// 						C5 = A5 * xIntersect + B5 * yIntersect;

//                         if(j%2==0){
//                             do {
//                                 A6 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
//                                 B6 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
//                             } while ((A6 == 0 && B6 == 0 )||(A6==A4 && B6==B4) ||(A6==A5 && B6==B5)); // Ensure A1 and B1 are not  zero
                    
//                             C6 = A6 * xIntersect + B6 * yIntersect;
// 							if(A6==0){
// 								line6=""+(B6==Math.abs(B6) ? (B6==1 ? "":B6):(B6==-1 ? "-":B6))+"y="+C6+"";		
// 							}
// 							else if(B6==0){
// 								line6=""+(A6==Math.abs(A6) ? (A6==1 ? "":A6):(A6==-1 ? "-":A6))+"x="+C6+"";		
// 							}
// 							else{
// 								line6=""+(A6==Math.abs(A6) ? (A6==1 ? "":A6):(A6==-1 ? "-":A6))+"x"+(B6==Math.abs(B6) ? (B6==1 ? "+":"+"+B6):(B6==-1 ? "-":B6))+"y="+C6+"";	
// 							}
//                             //line6=""+(A6==Math.abs(A6) ? (A6==1 ? "":A6):(A6==-1 ? "-":A6))+"x"+(B6==Math.abs(B6) ? (B6==1 ? "+":"+"+B6):(B6==-1 ? "-":B6))+"y="+C6+"";	
//                         }


					
// 						do{
// 							qx1 = (int)(Math.random()*17)-8;
// 							qy1 = (int)(Math.random()*17)-8;
						
// 							A1 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
// 							B1 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
// 							C1 = A1 * qx1 + B1 * qy1;
// 							pd1=Math.abs(A1*xIntersect+B1*yIntersect-C1)/Math.sqrt(A1*A1+B1*B1);
// 						} while (j%2==0 ? ((A1 == 0 && B1 == 0) || (A1==A4 && B1==B4) ||(A1==A5 && B1==B5) ||(A1==A6 && B1==B6)|| pd1<1 ||(qx1==0 && qy1==0)):((A1 == 0 && B1 == 0) || (A1==A4 && B1==B4) ||(A1==A5 && B1==B5)|| pd1<1||(qx1==0 && qy1==0))); // Ensure A1 and B1 are not both zero
					
							
							
// 						do{
// 							qx2 = (int)(Math.random()*17)-8;
// 							qy2 = (int)(Math.random()*17)-8;
							
// 							A2 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
// 							B2 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
// 							C2 = A2 * qx2 + B2 * qy2;
// 							pd2=Math.abs(A2*xIntersect+B2*yIntersect-C2)/Math.sqrt(A2*A2+B2*B2);
// 						} while (j%2==0 ? ((A2 == 0 && B2 == 0) || (A2==A4 && B2==B4) ||(A2==A5 && B2==B5) ||(A2==A6 && B2==B6)|| pd2<1 ||(qx2==0 && qy2==0)):((A2 == 0 && B2 == 0) || (A2==A4 && B2==B4) ||(A2==A5 && B2==B5)|| pd2<1||(qx2==0 && qy2==0))); // Ensure A1 and B1 are not both zero
					
							
	
// 						// do{
// 						// qx3 = (int)(Math.random()*17)-8;
// 						// qy3 = (int)(Math.random()*17)-8;
// 						// }while(qx3==0 || qy3==0);

// 						// do {
// 						// 	A3 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
// 						// 	B3 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
// 						// 	C3 = A3 * qx3 + B3 * qy3;
// 						// 	pd3=Math.abs(C3)/Math.sqrt(A3*A3+B3*B3);
// 						// } while (j%2==0 ? ((A3 == 0 && B3 == 0) || (A3==A4 && B3==B4) ||(A3==A5 && B3==B5) ||(A3==A6 && B3==B6)|| pd3<1):((A3 == 0 && B3 == 0) || (A3==A4 && B3==B4) ||(A3==A5 && B3==B5)|| pd3<1)); // Ensure A1 and B1 are not both zero
				
						
						
						
// 						if(A1==0){
// 							line1=""+(B1==Math.abs(B1) ? (B1==1 ? "":""+B1):(B1==-1 ? "-":B1))+"y="+C1+"";		
// 						}
// 						else if(B1==0){
// 							line1=""+(A1==Math.abs(A1) ? (A1==1 ? "":A1):(A1==-1 ? "-":A1))+"x="+C1+"";		
// 						}
// 						else{
// 							line1=""+(A1==Math.abs(A1) ? (A1==1 ? "":A1):(A1==-1 ? "-":A1))+"x"+(B1==Math.abs(B1) ? (B1==1 ? "+":"+"+B1):(B1==-1 ? "-":B1))+"y="+C1+"";	
// 						}

// 						if(A2==0){
// 							line2=""+(B2==Math.abs(B2) ? (B2==1 ? "":""+B2):(B2==-1 ? "-":B2))+"y="+C2+"";		
// 						}
// 						else if(B2==0){
// 							line2=""+(A2==Math.abs(A2) ? (A2==1 ? "":A2):(A2==-1 ? "-":A2))+"x="+C2+"";		
// 						}
// 						else{
// 							line2=""+(A2==Math.abs(A2) ? (A2==1 ? "":A2):(A2==-1 ? "-":A2))+"x"+(B2==Math.abs(B2) ? (B2==1 ? "+":"+"+B2):(B2==-1 ? "-":B2))+"y="+C2+"";	
// 						}

// 						// if(A3==0){
// 						// 	line3=""+(B3==Math.abs(B3) ? (B3==1 ? "":""+B3):(B3==-1 ? "-":B3))+"y="+C3+"";		
// 						// }
// 						// else if(B3==0){
// 						// 	line3=""+(A3==Math.abs(A3) ? (A3==1 ? "":A3):(A3==-1 ? "-":A3))+"x="+C3+"";		
// 						// }
// 						// else{
// 						// 	line3=""+(A3==Math.abs(A3) ? (A3==1 ? "":A3):(A3==-1 ? "-":A3))+"x"+(B3==Math.abs(B3) ? (B3==1 ? "+":"+"+B3):(B3==-1 ? "-":B3))+"y="+C3+"";	
// 						// }

// 						if(A4==0){
// 							line4=""+(B4==Math.abs(B4) ? (B4==1 ? "":B4):(B4==-1 ? "-":B4))+"y="+C4+"";		
// 						}
// 						else if(B4==0){
// 							line4=""+(A4==Math.abs(A4) ? (A4==1 ? "":A4):(A4==-1 ? "-":A4))+"x="+C4+"";		
// 						}
// 						else{
// 							line4=""+(A4==Math.abs(A4) ? (A4==1 ? "":A4):(A4==-1 ? "-":A4))+"x"+(B4==Math.abs(B4) ? (B4==1 ? "+":"+"+B4):(B4==-1 ? "-":B4))+"y="+C4+"";	
// 						}
// 						//line4=""+(A4==Math.abs(A4) ? (A4==1 ? "":A4):(A4==-1 ? "-":A4))+"x"+(B4==Math.abs(B4) ? (B4==1 ? "+":"+"+B4):(B4==-1 ? "-":B4))+"y="+C4+"";	
//                         if(A5==0){
// 							line5=""+(B5==Math.abs(B5) ? (B5==1 ? "":B5):(B5==-1 ? "-":B5))+"y="+C5+"";		
// 						}
// 						else if(B5==0){
// 							line5=""+(A5==Math.abs(A5) ? (A5==1 ? "":A5):(A5==-1 ? "-":A5))+"x="+C5+"";		
// 						}
// 						else{
// 							line5=""+(A5==Math.abs(A5) ? (A5==1 ? "":A5):(A5==-1 ? "-":A5))+"x"+(B5==Math.abs(B5) ? (B5==1 ? "+":"+"+B5):(B5==-1 ? "-":B5))+"y="+C5+"";	
// 						}
// 						//line5=""+(A5==Math.abs(A5) ? (A5==1 ? "":A5):(A5==-1 ? "-":A5))+"x"+(B5==Math.abs(B5) ? (B5==1 ? "+":"+"+B5):(B5==-1 ? "-":B5))+"y="+C5+"";	
						                       
// 					}while(line1==line2);

// 					double nx1,nx2,ny1,ny2,nx3,nx4,ny3,ny4,nx5,nx6,ny5,ny6,nx7,nx8,ny7,ny8,nx9,nx10,ny9,ny10,nx11=0,nx12=0,ny11=0,ny12=0;

// 					if(A1==0){
// 						nx1=-10.0;
// 						nx2=10.0;
// 						ny1=(C1/1.0)/(B1/1.0);
// 						ny2=(C1/1.0)/(B1/1.0);
// 					}
// 					else if(B1==0){
// 						nx1=(C1/1.0)/(A1/1.0);
// 						nx2=(C1/1.0)/(A1/1.0);
// 						ny1=-10.0;
// 						ny2=10.0;
// 					}
// 					else{
// 						nx1=-10.0;
// 						nx2=10.0;
// 						ny1=((-A1/1.0)/(B1/1.0))*(-10)+((C1/1.0)/(B1/1.0));
// 						ny2=((-A1/1.0)/(B1/1.0))*(10)+((C1/1.0)/(B1/1.0));
// 					}

// 					if(A2==0){
// 						nx3=-10.0;
// 						nx4=10.0;
// 						ny3=(C2/1.0)/(B2/1.0);
// 						ny4=(C2/1.0)/(B2/1.0);
// 					}
// 					else if(B2==0){
// 						nx3=(C2/1.0)/(A2/1.0);
// 						nx4=(C2/1.0)/(A2/1.0);
// 						ny3=-10.0;
// 						ny4=10.0;
// 					}
// 					else{
// 						nx3=-10.0;
// 						nx4=10.0;
// 						ny3=((-A2/1.0)/(B2/1.0))*(-10)+((C2/1.0)/(B2/1.0));
// 						ny4=((-A2/1.0)/(B2/1.0))*(10)+((C2/1.0)/(B2/1.0));
// 					}

// 					// if(A3==0){
// 					// 	nx5=-10.0;
// 					// 	nx6=10.0;
// 					// 	ny5=(C3/1.0)/(B3/1.0);
// 					// 	ny6=(C3/1.0)/(B3/1.0);
// 					// }
// 					// else if(B3==0){
// 					// 	nx5=(C3/1.0)/(A3/1.0);
// 					// 	nx6=(C3/1.0)/(A3/1.0);
// 					// 	ny5=-10.0;
// 					// 	ny6=10.0;
// 					// }
// 					// else{
// 					// 	nx5=-10.0;
// 					// 	nx6=10.0;
// 					// 	ny5=((-A3/1.0)/(B3/1.0))*(-10)+((C3/1.0)/(B3/1.0));
// 					// 	ny6=((-A3/1.0)/(B3/1.0))*(10)+((C3/1.0)/(B3/1.0));
// 					// }


					
// 					if(A4==0){
// 						nx7=-10.0;
// 						nx8=10.0;
// 						ny7=(C4/1.0)/(B4/1.0);
// 						ny8=(C4/1.0)/(B4/1.0);
// 					}
// 					else if(B4==0){
// 						nx7=(C4/1.0)/(A4/1.0);
// 						nx8=(C4/1.0)/(A4/1.0);
// 						ny7=-10.0;
// 						ny8=10.0;
// 					}
// 					else{
// 						nx7=-10.0;
// 						nx8=10.0;
// 						ny7=((-A4/1.0)/(B4/1.0))*(-10)+((C4/1.0)/(B4/1.0));
// 						ny8=((-A4/1.0)/(B4/1.0))*(10)+((C4/1.0)/(B4/1.0));
// 					}


//                     if(A5==0){
// 						nx9=-10.0;
// 						nx10=10.0;
// 						ny9=(C5/1.0)/(B5/1.0);
// 						ny10=(C5/1.0)/(B5/1.0);
// 					}
// 					else if(B5==0){
// 						nx9=(C5/1.0)/(A5/1.0);
// 						nx10=(C5/1.0)/(A5/1.0);
// 						ny9=-10.0;
// 						ny10=10.0;
// 					}
// 					else{
// 						nx9=-10.0;
// 						nx10=10.0;
// 						ny9=((-A5/1.0)/(B5/1.0))*(-10)+((C5/1.0)/(B5/1.0));
// 						ny10=((-A5/1.0)/(B5/1.0))*(10)+((C5/1.0)/(B5/1.0));
// 					}

//                     if(j%2==0){
//                         if(A6==0){
// 							nx11=-10.0;
// 							nx12=10.0;
// 							ny11=(C6/1.0)/(B6/1.0);
// 							ny12=(C6/1.0)/(B6/1.0);
// 						}
// 						else if(B6==0){
// 							nx11=(C6/1.0)/(A6/1.0);
// 							nx12=(C6/1.0)/(A6/1.0);
// 							ny11=-10.0;
// 							ny12=10.0;
// 						}
// 						else{
// 							nx11=-10.0;
// 							nx12=10.0;
// 							ny11=((-A6/1.0)/(B6/1.0))*(-10)+((C6/1.0)/(B6/1.0));
// 							ny12=((-A6/1.0)/(B6/1.0))*(10)+((C6/1.0)/(B6/1.0));
// 						}
//                     }

					

// 					//Images
//                     if(j%2!=0){
//                         Plot plot = Plot.plot(Plot.plotOpts().
//                                     width(800).
//                                     height(800).
//                                     legend(Plot.LegendFormat.BOTTOM)).	
//                                 xAxis("x", Plot.axisOpts().
//                                     range(-10, 10)).
//                                 yAxis("y", Plot.axisOpts().
//                                     range(-10, 10)).
//                                 series("L1:"+line1+"", Plot.data().
//                                     xy(nx1, ny1).
//                                     xy(nx2, ny2),
//                                     Plot.seriesOpts().
//                                         line(Plot.Line.SOLID).
//                                         color(Color.ORANGE).
//                                         marker(Plot.Marker.DIAMOND).
//                                         markerColor(Color.RED).
//                                         markerSize(5)).
//                                 series("L2:"+line2+"", Plot.data().
//                                     xy(nx3, ny3).
//                                     xy(nx4, ny4),
//                                     Plot.seriesOpts().
//                                         line(Plot.Line.SOLID).
//                                         color(Color.BLUE).
//                                         marker(Plot.Marker.DIAMOND).
//                                         markerColor(Color.RED).
//                                         markerSize(5)).
//                                 // series("L3:"+line3+"", Plot.data().
//                                 //     xy(nx5, ny5).
//                                 //     xy(nx6, ny6),
//                                 //     Plot.seriesOpts().
//                                 //         line(Plot.Line.SOLID).
//                                 //         color(Color.RED).
//                                 //         marker(Plot.Marker.DIAMOND).
//                                 //         markerColor(Color.RED).
//                                 //         markerSize(5)).
//                                 series("L3:"+line4+"", Plot.data().
//                                     xy(nx7, ny7).
//                                     xy(nx8, ny8),
//                                     Plot.seriesOpts().
//                                         line(Plot.Line.SOLID).
//                                         color(Color.BLACK).
//                                         marker(Plot.Marker.DIAMOND).
//                                         markerColor(Color.RED).
//                                         markerSize(5)).
//                                 series("L4:"+line5+"", Plot.data().
//                                     xy(nx9, ny9).
//                                     xy(nx10, ny10),
//                                     Plot.seriesOpts().
//                                         line(Plot.Line.SOLID).
//                                         color(Color.RED).
//                                         marker(Plot.Marker.DIAMOND).
//                                         markerColor(Color.RED).
//                                         markerSize(5)).
//                                 series("Point", Plot.data().
//                                             xy(xIntersect,yIntersect),
//                                             Plot.seriesOpts().
//                                                 line(Plot.Line.NONE).
//                                                 color(Color.BLACK).
//                                                 marker(Plot.Marker.CIRCLE).
//                                                 markerColor(Color.RED).
//                                                 markerSize(12));

//                         plot.save("C:\\Users\\bhush\\Downloads\\Assign15_Images\\Graph"+j+"", "png");
// 					}
//                     else{
//                         Plot plot = Plot.plot(Plot.plotOpts().
// 								width(800).
// 								height(800).
// 								legend(Plot.LegendFormat.BOTTOM)).	
// 							xAxis("x", Plot.axisOpts().
// 								range(-10, 10)).
// 							yAxis("y", Plot.axisOpts().
// 								range(-10, 10)).
// 							series("L1: "+line1+"", Plot.data().
// 								xy(nx1, ny1).
// 								xy(nx2, ny2),
// 								Plot.seriesOpts().
// 									line(Plot.Line.SOLID).
// 									color(Color.ORANGE).
// 									marker(Plot.Marker.DIAMOND).
// 									markerColor(Color.RED).
// 									markerSize(5)).
// 							// series("L2: "+line2+"", Plot.data().
// 							// 	xy(nx3, ny3).
// 							// 	xy(nx4, ny4),
// 							// 	Plot.seriesOpts().
// 							// 		line(Plot.Line.SOLID).
// 							// 		color(Color.BLUE).
// 							// 		marker(Plot.Marker.DIAMOND).
// 							// 		markerColor(Color.RED).
// 							// 		markerSize(5)).
// 							// series("L3: "+line3+"", Plot.data().
// 							// 	xy(nx5, ny5).
// 							// 	xy(nx6, ny6),
// 							// 	Plot.seriesOpts().
// 							// 		line(Plot.Line.SOLID).
// 							// 		color(Color.RED).
// 							// 		marker(Plot.Marker.DIAMOND).
// 							// 		markerColor(Color.RED).
// 							// 		markerSize(5)).
// 							series("L2: "+line4+"", Plot.data().
// 								xy(nx7, ny7).
// 								xy(nx8, ny8),
// 								Plot.seriesOpts().
// 									line(Plot.Line.SOLID).
// 									color(Color.BLACK).
// 									marker(Plot.Marker.DIAMOND).
// 									markerColor(Color.RED).
// 									markerSize(5)).
//                             series("L3: "+line5+"", Plot.data().
// 								xy(nx9, ny9).
// 								xy(nx10, ny10),
// 								Plot.seriesOpts().
// 									line(Plot.Line.SOLID).
// 									color(Color.RED).
// 									marker(Plot.Marker.DIAMOND).
// 									markerColor(Color.RED).
// 									markerSize(5)).
//                             series("L4: "+line6+"", Plot.data().
// 								xy(nx11, ny11).
// 								xy(nx12, ny12),
// 								Plot.seriesOpts().
// 									line(Plot.Line.SOLID).
// 									color(Color.BLUE).
// 									marker(Plot.Marker.DIAMOND).
// 									markerColor(Color.RED).
// 									markerSize(5)).
// 							series("Point", Plot.data().
// 										xy(xIntersect,yIntersect),
// 										Plot.seriesOpts().
// 											line(Plot.Line.NONE).
// 											color(Color.BLACK).
// 											marker(Plot.Marker.CIRCLE).
// 											markerColor(Color.RED).
// 											markerSize(12));

// 					    plot.save("C:\\Users\\bhush\\Downloads\\Assign15_Images\\Graph"+j+"", "png");
//                     }
						
				    
//                 String imagePath = "C:\\Users\\bhush\\Downloads\\Assign15_Images\\Graph"+j+".png";
// 					// int rowNumber = j; 
// 					// int columnNumber = 6; 


// 					// Insert the image into the Excel sheet
// 					insertImageIntoExcel(sheet1, imagePath, j, 6,workbook);

					
// 					ArrayList<String> quearr = new ArrayList<String>();
// 					quearr.add(line1);
// 					quearr.add(line2);
// 					//quearr.add(line3);
// 					quearr.add(line4);
// 					quearr.add(line5);
// 					if(j%2==0){
// 					quearr.add(line6);
// 					}

// 					// int c1,c2,c3,c4;
// 					// do{
// 					// c1=(int)(Math.random()*4);
// 					// c2=(int)(Math.random()*4);
// 					// c3=(int)(Math.random()*4);
// 					// c4=(int)(Math.random()*4);
// 					// }while(c1==c2 ||c1==c3 || c1==c4 || c2==c3 || c2==c4 || c3==c4);
					
// 					String Que1,Que2,Correct_ans,Correct_ans1,Correct_ans2="",wrong_ans,wrong_ans1="",wrong_ans2,Solu,Solu1;
// 					if(j%2==0){
// 						Que1="2) Which of the following linear equations in two variables will have graphs passing through point $ ("+xIntersect+","+yIntersect+")$ ? <br>";//$ "+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";
// 						Que2="#खालील पैकी कोणकोणत्या रेषीय समीकरणाचा आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूतून जातो ? <br>"; //+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";
// 					}
// 					else{
// 						Que1="1) Which of the following linear equations in two variables will have graphs passing through point $ ("+xIntersect+","+yIntersect+")$ ? <br>";//$ "+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";
//                         Que2="#खालील पैकी कोणकोणत्या रेषीय समीकरणाचा आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूतून जातो ? <br>"; //+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";

// 					}
// 					String Question=""+Que1+""+Que2+"";

// 					if(j%2==0){
//                     Correct_ans="$ "+line4+"$ <br>";
// 					Correct_ans1="$ "+line5+"$ <br>";
// 					Correct_ans2="$ "+line6+"$ <br>";
// 					wrong_ans="$ "+line1+"$ <br>";
// 					}
// 					else{
// 						Correct_ans="$ "+line4+"$ <br>";
// 						Correct_ans1="$ "+line5+"$ <br>";	
// 						wrong_ans="$ "+line1+"$ <br>";
// 						wrong_ans1="$ "+line2+"$ <br>";
// 					}
                    
                    
//                     //wrong_ans2="$ "+line2+"$ <br>";

					
// 					row.createCell(4).setCellValue(Question);
// 				    //row.createCell(6).setCellFormula("");
// 		//				 row.createCell(7).setCellValue(" ");
// 		//				 row.createCell(8).setCellValue(" ");
// 					row.createCell(5).setCellValue(Correct_ans);
// 					row.createCell(7).setCellValue(Correct_ans1);
// 					if(j%2==0){
// 						row.createCell(8).setCellValue(Correct_ans2);
// 					}
// 					row.createCell(9).setCellValue(wrong_ans);
// 					if(j%2!=0){
// 					row.createCell(10).setCellValue(wrong_ans1);
// 					}
// 					//row.createCell(11).setCellValue(wrong_ans2);
				
// 					row.createCell(12).setCellValue(120);
// 					row.createCell(13).setCellValue(4);
// 				//	row.createCell(14).setCellValue("");
// 					row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
// 					if(j%2==0){
// 						Solu="Ans $ 1\\ : "+line4+"$ <br>Ans $ 2\\ : "+line5+"$ <br>Ans $ 3\\ : "+line6+"$ <br> If graph of any equation is to pass through the point $ ("+xIntersect+","+yIntersect+")$ , it means the point $ ("+xIntersect+","+yIntersect+")$ must satisfy the equation.<br>"+
// 											"For point $ ("+xIntersect+","+yIntersect+")$, we will find the values of all equations one by by substituting $ x="+xIntersect+"$ and $ y="+yIntersect+"$.<br>"+
// 											"If the value of the equation comes out to be equal to the given value of that equation, then point $ ("+xIntersect+","+yIntersect+")$ will be lying on the graph corresponding to that equation.<br>"+
// 											"We will verify this as follows, <br>"+
// 											"For equation $ "+line4+"$ by putting the values as $ x="+xIntersect+"$ and $ y="+yIntersect+"$ we get<br>"+
// 											"$ "+(A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B4==Math.abs(B4)? "+":"-")+""+(B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A4*xIntersect+""+(B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)+"="+C4+"$ which is same as given value.<br>"+
// 											"$ \\therefore$ equation $ "+line4+"$ gets satisfied by point $ ("+xIntersect+","+yIntersect+")$.<br>"+
// 											"$ \\therefore$ point $ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line4+" . . . .  (i)$<br>"+
// 											"For equation $ "+line1+"$ , <br>"+
// 											"By putting the values as $x="+xIntersect+"$ and $y="+yIntersect+"$ we get<br>"+
// 											"$ "+(A1==Math.abs(A1) ? (A1==1 ? xIntersect : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A1==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B1==Math.abs(B1)? "+":"-")+""+(B1==Math.abs(B1) ? (B1==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B1==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A1*xIntersect+""+(B1*yIntersect==Math.abs(B1*yIntersect) ? "+"+B1*yIntersect : B1*yIntersect)+"="+(A1*xIntersect+B1*yIntersect)+"\\ne"+C1+"$ the given value of the equation<br>"+
// 											"$ \\therefore$ point $ ("+xIntersect+","+yIntersect+")$ doesn't lie on the graph corresponding to equation $ "+line1+"  . . . .  (ii)$ <br>"+
// 											"Similarly we can check for remaining equations and the result will be, <br>$ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line5+"  . . . .  (iii)$ and <br>"+
// 											"$ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line2+" . . . .  (iv)$ <br>"+
// 											"From $ (i)$ to $ (iv)$, we can conclude that, <br>"+
// 											"the ordered pair $ ("+xIntersect+","+yIntersect+")$ lies on the graph for equations only for $ "+line4+"$ , $ "+line5+"$ and $ "+line6+"$ <br>"+
// 											"No other equation is satisfied by the ordered pair $ ("+xIntersect+","+yIntersect+")$ .<br>"+
// 											"We can observe this from the graph drawn for all given equations.<br> Answer $ 1:\\ "+line4+"$ , <br> Answer $ 2:\\ "+line5+"$ and<br>Answer $ 3:\\ "+line6+"$ <br>";

// 						Solu1="#उत्तर $ 1\\ : "+line4+"$ <br>उत्तर $ 2\\ : "+line5+"$ <br>उत्तर $ 3\\ : "+line6+"$  जर कोणताही आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूमधून जाणारा असेल तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या समीकरणाचे समाधान करत असायलाच हवा. <br>"+
// 											"$ ("+xIntersect+","+yIntersect+")$ या बिंदू नुसार $ x="+xIntersect+"$ आणि $ y="+yIntersect+"$ अशा किमती प्रत्येक समीकरणात ठेवून त्या समीकरणाच्या किंमत शोधू. <br>"+
// 											"जर समीकरणाची किंमत त्याच्या दिलेल्या किमती एवढी मिळाली, तरच $ ("+xIntersect+","+yIntersect+")$ हा बिंदू त्या समीकरणाच्या आलेखावर असेल. जर तेवढीच किंमत मिळाली नाही, तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू त्या समीकरणाच्या आलेखावर असू शकणार नाही. <br>"+
// 											"हे आपण खाली दाखविल्या नुसार तपासू. <br>"+
// 											"$ "+line4+"$ या समीकरणात $ ("+xIntersect+","+yIntersect+")$ या बिंदू साठी $ x="+xIntersect+"$ आणि  $ y="+yIntersect+"$ अशा किमती ठेवून आपल्याला <br>"+
// 											"$ "+(A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B4==Math.abs(B4)? "+":"-")+""+(B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A4*xIntersect+""+(B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)+"="+C4+"$  असे उत्तर मिळते. आणि ही किंमत त्या समीकरणाच्या दिलेल्या किमती एवढीच आहे.<br>"+
// 											"$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line4+"$  या समीकरणाचे समाधान करतो<br>"+
// 											"$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू  $ "+line4+"$ या समीकरणाच्या आलेखावर असेल.$  . . . .(i)$<br>"+
// 											"आता $ "+line1+"$ या समीकरणात $ ("+xIntersect+","+yIntersect+")$ या बिंदू साठी $ x="+xIntersect+"$ आणि  $ y="+yIntersect+"$ अशा किमती ठेवून आपल्याला <br>"+
// 											"$ "+(A1==Math.abs(A1) ? (A1==1 ? xIntersect : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A1==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B1==Math.abs(B1)? "+":"-")+""+(B1==Math.abs(B1) ? (B1==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B1==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A1*xIntersect+""+(B1*yIntersect==Math.abs(B1*yIntersect) ? "+"+B1*yIntersect : B1*yIntersect)+"="+(A1*xIntersect+B1*yIntersect)+"\\ne"+C1+"$ असे उत्तर मिळते. आणि ही किंमत त्या समीकरणाच्या दिलेल्या किमती एवढी नाही.<br>"+
// 											"$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line1+"$  या समीकरणाचे समाधान करत नाही.<br>"+
// 											"$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू  $ "+line1+"$ या समीकरणाच्या आलेखावर नाही $ . .  . . . .(ii)$<br>"+
// 											"याच पद्धतीने आपण दिलेल्या इतर समीकरणांसाठी हे तपासून पाहिले असता आपल्याला हे समजते की,<br>"+
// 											"$ ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line5+"$ या समीकरणाच्या आलेखावर असेल. $  . . . .  (iii)$ आणि <br>"+
// 											"$ ("+xIntersect+","+yIntersect+")$  हा बिंदू $ "+line6+"$ या समीकरणाच्या आलेखावर असेल. $ . . . .  (iv)$<br>"+
// 											"$(i)$ ते $(iv)$ या वरून आपण असा निष्कर्ष काढू शकतो की,<br>"+
// 											"$ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या पैकी फक्त $ "+line4+"$ , $ "+line5+"$ आणि $ "+line6+"$ या तीनच समीकरणांच्या आलेखावर असू शकतो. <br>"+
// 											"इतर कोणत्याही समीकरणाच्या आलेखावर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू असू शकत नाही.<br>"+
// 											"दिलेल्या सर्व समीकरणांच्या दाखविलेल्या आलेखावरून आपण याची खात्री करून घेऊ शकतो. <br> उत्तर $ 1:\\ "+line4+"$ , <br>उत्तर  $ 2:\\ "+line5+"$ आणि <br>उत्तर  $ 3:\\ "+line6+"$<br>";
// 					}
// 					else{
// 						Solu="Ans $ 1\\ : "+line4+"$ <br>Ans $ 2\\ : "+line5+"$ <br> If graph of any equation is to pass through the point $ ("+xIntersect+","+yIntersect+")$ , it means the point $ ("+xIntersect+","+yIntersect+")$ must satisfy the equation.<br>"+
// 											"For point $ ("+xIntersect+","+yIntersect+")$, we will find the values of all equations one by by substituting $ x="+xIntersect+"$ and $ y="+yIntersect+"$.<br>"+
// 											"If the value of the equation comes out to be equal to the given value of that equation, then point $ ("+xIntersect+","+yIntersect+")$ will be lying on the graph corresponding to that equation.<br>"+
// 											"We will verify this as follows, <br>"+
// 											"For equation $ "+line4+"$ by putting the values as $ x="+xIntersect+"$ and $ y="+yIntersect+"$ we get<br>"+
// 											"$ "+(A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B4==Math.abs(B4)? "+":"-")+""+(B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A4*xIntersect+""+(B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)+"="+C4+"$ which is same as given value.<br>"+
// 											"$ \\therefore$ equation $ "+line4+"$ gets satisfied by point $ ("+xIntersect+","+yIntersect+")$.<br>"+
// 											"$ \\therefore$ point $ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line4+" . . . .  (i)$<br>"+
// 											"For equation $ "+line1+"$ , <br>"+
// 											"By putting the values as $ x="+xIntersect+"$ and $ y="+yIntersect+"$ we get<br>"+
// 											"$ "+(A1==Math.abs(A1) ? (A1==1 ? xIntersect : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A1==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B1==Math.abs(B1)? "+":"-")+""+(B1==Math.abs(B1) ? (B1==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B1==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A1*xIntersect+""+(B1*yIntersect==Math.abs(B1*yIntersect) ? "+"+B1*yIntersect : B1*yIntersect)+"="+(A1*xIntersect+B1*yIntersect)+"\\ne"+C1+"$ the given value of the equation<br>"+
// 											"$ \\therefore$ point $ ("+xIntersect+","+yIntersect+")$ doesn't lie on the graph corresponding to equation $ "+line1+"  . . . .  (ii)$ <br>"+
// 											"Similarly we can check for remaining equations and the result will be,<br>$ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line5+"  . . . .  (iii)$ and <br>"+
// 											"$ ("+xIntersect+","+yIntersect+")$ doesn't lie on the graph corresponding to equation $ "+line2+" . . . .  (iv)$ <br>"+
// 											"From $ (i)$ to $ (iv)$ , we can conclude that, <br>"+
// 											"the ordered pair $ ("+xIntersect+","+yIntersect+")$ lies on the graph for equations only for $ "+line4+"$ and $ "+line5+"$ <br>"+
// 											"No other equation is satisfied by the ordered pair $ ("+xIntersect+","+yIntersect+")$ .<br>"+
// 											"We can observe this from the graph drawn for all given equations. <br> Answer $ 1:\\ "+line4+"$ and<br> Answer $ 2:\\ "+line5+"$ <br>";

// 						Solu1="#उत्तर $ 1\\ : "+line4+"$ <br>उत्तर $ 2\\ : "+line5+"$ <br> जर कोणताही आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूमधून जाणारा असेल तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या समीकरणाचे समाधान करत असायलाच हवा. <br>"+
// 											"$ ("+xIntersect+","+yIntersect+")$ या बिंदू नुसार $ x="+xIntersect+"$ आणि $ y="+yIntersect+"$ अशा किमती प्रत्येक समीकरणात ठेवून त्या समीकरणाच्या किंमत शोधू. <br>"+
// 											"जर समीकरणाची किंमत त्याच्या दिलेल्या किमती एवढी मिळाली, तरच $ ("+xIntersect+","+yIntersect+")$ हा बिंदू त्या समीकरणाच्या आलेखावर असेल. जर तेवढीच किंमत मिळाली नाही, तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू त्या समीकरणाच्या आलेखावर असू शकणार नाही. <br>"+
// 											"हे आपण खाली दाखविल्या नुसार तपासू. <br>"+
// 											"$ "+line4+"$ या समीकरणात $ ("+xIntersect+","+yIntersect+")$ या बिंदू साठी $ x="+xIntersect+"$ आणि  $ y="+yIntersect+"$ अशा किमती ठेवून आपल्याला <br>"+
// 											"$ "+(A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B4==Math.abs(B4)? "+":"-")+""+(B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A4*xIntersect+""+(B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)+"="+C4+"$  असे उत्तर मिळते. आणि ही किंमत त्या समीकरणाच्या दिलेल्या किमती एवढीच आहे.<br>"+
// 											"$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line4+"$  या समीकरणाचे समाधान करतो<br>"+
// 											"$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू  $ "+line4+"$ या समीकरणाच्या आलेखावर असेल.$  . . . .(i)$<br>"+
// 											"आता $ "+line1+"$ या समीकरणात $ ("+xIntersect+","+yIntersect+")$ या बिंदू साठी $ x="+xIntersect+"$ आणि  $ y="+yIntersect+"$ अशा किमती ठेवून आपल्याला <br>"+
// 											"$ "+(A1==Math.abs(A1) ? (A1==1 ? xIntersect : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A1==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B1==Math.abs(B1)? "+":"-")+""+(B1==Math.abs(B1) ? (B1==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B1==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A1*xIntersect+""+(B1*yIntersect==Math.abs(B1*yIntersect) ? "+"+B1*yIntersect : B1*yIntersect)+"="+(A1*xIntersect+B1*yIntersect)+"\\ne"+C1+"$ असे उत्तर मिळते. आणि ही किंमत त्या समीकरणाच्या दिलेल्या किमती एवढी नाही.<br>"+
// 											"$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line1+"$  या समीकरणाचे समाधान करत नाही.<br>"+
// 											"$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू  $ "+line1+"$ या समीकरणाच्या आलेखावर नाही $ . .  . . . .(ii)$<br>"+
// 											"याच पद्धतीने आपण दिलेल्या इतर समीकरणांसाठी हे तपासून पाहिले असता आपल्याला हे समजते की,<br>"+
// 											"$ ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line5+"$ या समीकरणाच्या आलेखावर असेल.$  . . . .  (iii)$ आणि <br>"+
// 											"$ ("+xIntersect+","+yIntersect+")$  हा बिंदू $ "+line2+"$ या समीकरणाच्या आलेखावर नाही. $ . . . .  (iv)$<br>"+
// 											"$(i)$ ते $(iv)$ या वरून आपण असा निष्कर्ष काढू शकतो की,<br>"+
// 											"$ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या पैकी फक्त $ "+line4+"$ आणि $ "+line5+"$ या दोनच समीकरणांच्या आलेखावर असू शकतो. <br>"+
// 											"इतर कोणत्याही समीकरणाच्या आलेखावर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू असू शकत नाही.<br>"+
// 											"दिलेल्या सर्व समीकरणांच्या दाखविलेल्या आलेखावरून आपण याची खात्री करून घेऊ शकतो. <br> उत्तर $ 1:\\ "+line4+"$ आणि <br>उत्तर  $ 2:\\ "+line5+"$<br>";
// 					}
// 					String Solution =""+Solu+" "+Solu1+"";	
				
// 					// String abc="Ans $ 1\\ : "+line4+"$ <br>Ans $ 2\\ : "+line5+"$ <br> If graph of any equation is to pass through the point $ ("+xIntersect+","+yIntersect+")$ , it means the point $ ("+xIntersect+","+yIntersect+")$ must satisfy the equation.<br>"+
// 					// 	"For point $ ("+xIntersect+","+yIntersect+")$, we will find the values of all equations one by by substituting $ x="+xIntersect+"$ and $ y="+yIntersect+"$.<br>"+
// 					// 	"If the value of the equation comes out to be equal to the given value of that equation, then point $ ("+xIntersect+","+yIntersect+")$ will be lying on the graph corresponding to that equation.<br>"+
// 					// 	"We will verify this as follows, <br>"+
// 					// 	"For equation $ "+line4+"$ by putting the values as $ x="+xIntersect+"$ and $ y="+yIntersect+"$ we get<br>"+
// 					// 	"$ "+(A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B4==Math.abs(B4)? "+":"-")+""+(B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A4*xIntersect+""+(B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)+"="+C4+"$ which is same as given value.<br>"+
// 					// 	"$ \\therefore$ equation $ "+line4+"$ gets satisfied by point $ ("+xIntersect+","+yIntersect+")$.<br>"+
// 					// 	"$ \\therefore$ point $ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line4+" . . . .  (i)$<br>"+
// 					// 	"For equation $ "+line1+"$ , <br>"+
// 					// 	"By putting the values as $ x="+xIntersect+"$ and $ y="+yIntersect+"$ we get<br>"+
// 					// 	"$ "+(A1==Math.abs(A1) ? (A1==1 ? xIntersect : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A1==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B1==Math.abs(B1)? "+":"-")+""+(B1==Math.abs(B1) ? (B1==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B1==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A1*xIntersect+""+(B1*yIntersect==Math.abs(B1*yIntersect) ? "+"+B1*yIntersect : B1*yIntersect)+"="+(A1*xIntersect+B1*yIntersect)+"\\ne"+C1+"$ the given value of the equation<br>"+
// 					// 	"$ \\therefore$ point $ ("+xIntersect+","+yIntersect+")$ doesn't lie on the graph corresponding to equation $ "+line1+"  . . . .  (ii)$<br>"+
// 					// 	"Similarly we can check for remaining equations and the result will be,<br>$ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line5+"  . . . .  (iii)$ and <br>"+
// 					// 	"$ ("+xIntersect+","+yIntersect+")$ doesn't lie on the graph corresponding to equation $ "+line2+" . . . .  (iv)$ <br>"+
// 					// 	"From $ (i)$ to $ (iv)$ , we can conclude that,<br>"+
// 					// 	"the ordered pair $ ("+xIntersect+","+yIntersect+")$ lies on the graph for equations only for $ "+line4+"$ and $ "+line5+"$ <br>"+
// 					// 	"No other equation is satisfied by the ordered pair $ ("+xIntersect+","+yIntersect+")$ .<br>"+
// 					// 	"We can observe this from the graph drawn for all given equations.<br> Answer $ 1:\\ "+line4+"$ and<br> Answer $ 2:\\ "+line5+"$ <br>";


// 						// (A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))
// 						// (B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))

// 						//B4*yIntersect  (B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)
// 					// String abc2="#उत्तर $1\\ : "+line4+"$ <br>उत्तर $2\\ : "+line5+"$ <br> जर कोणताही आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूमधून जाणारा असेल तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या समीकरणाचे समाधान करत असायलाच हवा. <br>"+
// 					// "$ ("+xIntersect+","+yIntersect+")$ या बिंदू नुसार $ x="+xIntersect+"$ आणि $ y="+yIntersect+"$ अशा किमती प्रत्येक समीकरणात ठेवून त्या समीकरणाच्या किंमत शोधू. <br>"+
// 					// "जर समीकरणाची किंमत त्याच्या दिलेल्या किमती एवढी मिळाली, तरच $ ("+xIntersect+","+yIntersect+")$ हा बिंदू त्या समीकरणाच्या आलेखावर असेल. जर तेवढीच किंमत मिळाली नाही, तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू त्या समीकरणाच्या आलेखावर असू शकणार नाही. <br>"+
// 					// "हे आपण खाली दाखविल्या नुसार तपासू. <br>"+
// 					// "$ "+line4+"$ या समीकरणात $ ("+xIntersect+","+yIntersect+")$ या बिंदू साठी $ x="+xIntersect+"$ आणि  $ y="+yIntersect+"$ अशा किमती ठेवून आपल्याला <br>"+
// 					// "$ "+(A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B4==Math.abs(B4)? "+":"-")+""+(B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A4*xIntersect+""+(B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)+"="+C4+"$  असे उत्तर मिळते. आणि ही किंमत त्या समीकरणाच्या दिलेल्या किमती एवढीच आहे.<br>"+
// 					// "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line4+"$  या समीकरणाचे समाधान करतो<br>"+
// 					// "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू  $ "+line4+"$ या समीकरणाच्या आलेखावर असेल.$  . . . .(i)$<br>"+
// 					// "आता $ "+line1+"$ या समीकरणात $ ("+xIntersect+","+yIntersect+")$ या बिंदू साठी $ x="+xIntersect+"$ आणि  $ y="+yIntersect+"$ अशा किमती ठेवून आपल्याला <br>"+
// 					// "$ "+(A1==Math.abs(A1) ? (A1==1 ? xIntersect : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A1==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B1==Math.abs(B1)? "+":"-")+""+(B1==Math.abs(B1) ? (B1==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B1==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A1*xIntersect+""+(B1*yIntersect==Math.abs(B1*yIntersect) ? "+"+B1*yIntersect : B1*yIntersect)+"="+(A1*xIntersect+B1*yIntersect)+"\\ne"+C1+"$ असे उत्तर मिळते. आणि ही किंमत त्या समीकरणाच्या दिलेल्या किमती एवढी नाही.<br>"+
// 					// "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line1+"$  या समीकरणाचे समाधान करत नाही.<br>"+
// 					// "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू  $ "+line1+"$ या समीकरणाच्या आलेखावर नाही $ . .  . . . .(ii)$<br>"+
// 					// "याच पद्धतीने आपण दिलेल्या इतर समीकरणांसाठी हे तपासून पाहिले असता आपल्याला हे समजते की,<br>"+
// 					// "$ ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line5+"$ या समीकरणाच्या आलेखावर असेल.$  . . . .  (iii)$ आणि <br>"+
// 					// "$ ("+xIntersect+","+yIntersect+")$  हा बिंदू $ "+line2+"$ या समीकरणाच्या आलेखावर नाही. $ . . . .  (iv)$<br>"+
// 					// "$(i)$ ते $(iv)$ या वरून आपण असा निष्कर्ष काढू शकतो की,<br>"+
// 					// "$ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या पैकी फक्त $ "+line4+"$ आणि $ "+line5+"$ या दोनच समीकरणांच्या आलेखावर असू शकतो. <br>"+
// 					// "इतर कोणत्याही समीकरणाच्या आलेखावर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू असू शकत नाही.<br>"+
// 					// "दिलेल्या सर्व समीकरणांच्या दाखविलेल्या आलेखावरून आपण याची खात्री करून घेऊ शकतो. <br> उत्तर $ 1:\\ "+line4+"$ आणि <br>उत्तर  $ 2:\\ "+line5+"$<br>";



// 					row.createCell(16).setCellValue(Solution);
//     				row.createCell(17).setCellValue(imagePath);
// 					row.createCell(18).setCellValue(107);

				
// 				String Checker;
// 				if(j%2==0){
// 					Checker =""+line1+""+line4+""+line5+""+line6+"";
// 				}
// 				else{
// 					Checker =""+line1+""+line2+""+line4+""+line5+"";
// 				}
// 							mapsize = map.size();
// 							map.put(Checker,j);
// 							mapsizeafter = map.size();
						
// 						//In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
// 						if(mapsize == mapsizeafter) {
// 							System.out.println(Checker);
// 							j--;
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

public class VLab_0304060403_107_2_Assign15_Bhushan {

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
        //String filename = "C:\\Users\\rajko\\OneDrive\\Desktop\\excel\\VLab_0304060403_107_2_Assign15_Bhushan.xlsx";
        String filename = "D:/excel files/VLab_0304060403_107_2_Assign15_Bhushan.xlsx";     //Location where excel file is getting generated
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

            XSSFRow row = sheet1.createRow(j);
            row.createCell(0).setCellValue(j);
            row.createCell(1).setCellValue("Text");
            row.createCell(2).setCellValue(5);
            row.createCell(3).setCellValue("0304060403");


            // Generate a random intersection point within the range -10 to 10
            int qx1,qy1,qx2,qy2,qx3,qy3,xIntersect,yIntersect;
            int A1, B1, C1, A2, B2, C2, A3, B3, C3, A4, B4, C4, A5, B5, C5, A6=0, B6=0, C6=0;
            String line1,line2,line3,line4,line5,line6="";
            double pd1,pd2,pd3;

            do{
                do{
                    xIntersect=(int)(Math.random()*17)-8;
                    yIntersect=(int)(Math.random()*17)-8;
                }while(xIntersect==0 && yIntersect==0);

                do {
                    A4 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
                    B4 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
                } while (A4==B4); // Ensure A1 and B1 are same at a time  zero

                C4 = A4 * xIntersect + B4 * yIntersect;

                do {
                    A5 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
                    B5 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
                } while ((A5 ==B5 )|| (A4==A5 && B4==B5)); // Ensure A1 and B1 are not  zero

                C5 = A5 * xIntersect + B5 * yIntersect;

                if(j%2==0){
                    do {
                        A6 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
                        B6 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
                    } while ((A6==B6 )||(A6==A4 && B6==B4) ||(A6==A5 && B6==B5)); // Ensure A1 and B1 are not  zero

                    C6 = A6 * xIntersect + B6 * yIntersect;
                    if(A6==0){
                        line6=""+(B6==Math.abs(B6) ? (B6==1 ? "":B6):(B6==-1 ? "-":B6))+"y="+C6+"";
						if(C6==0){
							line6="y="+C6+"";
						}
                    }
                    else if(B6==0){
                        line6=""+(A6==Math.abs(A6) ? (A6==1 ? "":A6):(A6==-1 ? "-":A6))+"x="+C6+"";
						if(C6==0){
							line6="x="+C6+"";
						}
                    }
                    else{
                        line6=""+(A6==Math.abs(A6) ? (A6==1 ? "":A6):(A6==-1 ? "-":A6))+"x"+(B6==Math.abs(B6) ? (B6==1 ? "+":"+"+B6):(B6==-1 ? "-":B6))+"y="+C6+"";
                    }
                    //line6=""+(A6==Math.abs(A6) ? (A6==1 ? "":A6):(A6==-1 ? "-":A6))+"x"+(B6==Math.abs(B6) ? (B6==1 ? "+":"+"+B6):(B6==-1 ? "-":B6))+"y="+C6+"";
                }



                do{
                    qx1 = (int)(Math.random()*17)-8;
                    qy1 = (int)(Math.random()*17)-8;

                    A1 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
                    B1 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
                    C1 = A1 * qx1 + B1 * qy1;
                    pd1=Math.abs(A1*xIntersect+B1*yIntersect-C1)/Math.sqrt(A1*A1+B1*B1);
                } while (j%2==0 ? ((A1 == B1) || (A1==A4 && B1==B4) ||(A1==A5 && B1==B5) ||(A1==A6 && B1==B6)|| pd1<1 ||(qx1==0 && qy1==0)):((A1 == B1) || (A1==A4 && B1==B4) ||(A1==A5 && B1==B5)|| pd1<1||(qx1==0 && qy1==0))); // Ensure A1 and B1 are not both zero



                do{
                    qx2 = (int)(Math.random()*17)-8;
                    qy2 = (int)(Math.random()*17)-8;

                    A2 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
                    B2 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
                    C2 = A2 * qx2 + B2 * qy2;
                    pd2=Math.abs(A2*xIntersect+B2*yIntersect-C2)/Math.sqrt(A2*A2+B2*B2);
                } while (j%2==0 ? ((A2 == B2 ) || (A2==A4 && B2==B4) ||(A2==A5 && B2==B5) ||(A2==A6 && B2==B6)|| pd2<1 ||(qx2==0 && qy2==0)):((A2 == B2 ) || (A2==A4 && B2==B4) ||(A2==A5 && B2==B5)|| pd2<1||(qx2==0 && qy2==0))); // Ensure A1 and B1 are not both zero



                // do{
                // qx3 = (int)(Math.random()*17)-8;
                // qy3 = (int)(Math.random()*17)-8;
                // }while(qx3==0 || qy3==0);

                // do {
                // 	A3 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
                // 	B3 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
                // 	C3 = A3 * qx3 + B3 * qy3;
                // 	pd3=Math.abs(C3)/Math.sqrt(A3*A3+B3*B3);
                // } while (j%2==0 ? ((A3 == 0 && B3 == 0) || (A3==A4 && B3==B4) ||(A3==A5 && B3==B5) ||(A3==A6 && B3==B6)|| pd3<1):((A3 == 0 && B3 == 0) || (A3==A4 && B3==B4) ||(A3==A5 && B3==B5)|| pd3<1)); // Ensure A1 and B1 are not both zero




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

                // if(A3==0){
                // 	line3=""+(B3==Math.abs(B3) ? (B3==1 ? "":""+B3):(B3==-1 ? "-":B3))+"y="+C3+"";
                // }
                // else if(B3==0){
                // 	line3=""+(A3==Math.abs(A3) ? (A3==1 ? "":A3):(A3==-1 ? "-":A3))+"x="+C3+"";
                // }
                // else{
                // 	line3=""+(A3==Math.abs(A3) ? (A3==1 ? "":A3):(A3==-1 ? "-":A3))+"x"+(B3==Math.abs(B3) ? (B3==1 ? "+":"+"+B3):(B3==-1 ? "-":B3))+"y="+C3+"";
                // }

                if(A4==0){
                    line4=""+(B4==Math.abs(B4) ? (B4==1 ? "":B4):(B4==-1 ? "-":B4))+"y="+C4+"";
					if(C4==0){
						line4="y="+C4+"";
					}
                }
                else if(B4==0){
                    line4=""+(A4==Math.abs(A4) ? (A4==1 ? "":A4):(A4==-1 ? "-":A4))+"x="+C4+"";
					if(C4==0){
						line4="x="+C4+"";
					}
                }
                else{
                    line4=""+(A4==Math.abs(A4) ? (A4==1 ? "":A4):(A4==-1 ? "-":A4))+"x"+(B4==Math.abs(B4) ? (B4==1 ? "+":"+"+B4):(B4==-1 ? "-":B4))+"y="+C4+"";
                }
                //line4=""+(A4==Math.abs(A4) ? (A4==1 ? "":A4):(A4==-1 ? "-":A4))+"x"+(B4==Math.abs(B4) ? (B4==1 ? "+":"+"+B4):(B4==-1 ? "-":B4))+"y="+C4+"";
                if(A5==0){
                    line5=""+(B5==Math.abs(B5) ? (B5==1 ? "":B5):(B5==-1 ? "-":B5))+"y="+C5+"";
					if(C5==0){
						line5="y="+C5+"";
					}
                }
                else if(B5==0){
                    line5=""+(A5==Math.abs(A5) ? (A5==1 ? "":A5):(A5==-1 ? "-":A5))+"x="+C5+"";
					if(C5==0){
						line5="x="+C5+"";
					}
                }
                else{
                    line5=""+(A5==Math.abs(A5) ? (A5==1 ? "":A5):(A5==-1 ? "-":A5))+"x"+(B5==Math.abs(B5) ? (B5==1 ? "+":"+"+B5):(B5==-1 ? "-":B5))+"y="+C5+"";
                }
                //line5=""+(A5==Math.abs(A5) ? (A5==1 ? "":A5):(A5==-1 ? "-":A5))+"x"+(B5==Math.abs(B5) ? (B5==1 ? "+":"+"+B5):(B5==-1 ? "-":B5))+"y="+C5+"";

            }while(line1==line2);

            double nx1,nx2,ny1,ny2,nx3,nx4,ny3,ny4,nx5,nx6,ny5,ny6,nx7,nx8,ny7,ny8,nx9,nx10,ny9,ny10,nx11=0,nx12=0,ny11=0,ny12=0;

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

            // if(A3==0){
            // 	nx5=-10.0;
            // 	nx6=10.0;
            // 	ny5=(C3/1.0)/(B3/1.0);
            // 	ny6=(C3/1.0)/(B3/1.0);
            // }
            // else if(B3==0){
            // 	nx5=(C3/1.0)/(A3/1.0);
            // 	nx6=(C3/1.0)/(A3/1.0);
            // 	ny5=-10.0;
            // 	ny6=10.0;
            // }
            // else{
            // 	nx5=-10.0;
            // 	nx6=10.0;
            // 	ny5=((-A3/1.0)/(B3/1.0))*(-10)+((C3/1.0)/(B3/1.0));
            // 	ny6=((-A3/1.0)/(B3/1.0))*(10)+((C3/1.0)/(B3/1.0));
            // }



            if(A4==0){
                nx7=-10.0;
                nx8=10.0;
                ny7=(C4/1.0)/(B4/1.0);
                ny8=(C4/1.0)/(B4/1.0);
            }
            else if(B4==0){
                nx7=(C4/1.0)/(A4/1.0);
                nx8=(C4/1.0)/(A4/1.0);
                ny7=-10.0;
                ny8=10.0;
            }
            else{
                nx7=-10.0;
                nx8=10.0;
                ny7=((-A4/1.0)/(B4/1.0))*(-10)+((C4/1.0)/(B4/1.0));
                ny8=((-A4/1.0)/(B4/1.0))*(10)+((C4/1.0)/(B4/1.0));
            }


            if(A5==0){
                nx9=-10.0;
                nx10=10.0;
                ny9=(C5/1.0)/(B5/1.0);
                ny10=(C5/1.0)/(B5/1.0);
            }
            else if(B5==0){
                nx9=(C5/1.0)/(A5/1.0);
                nx10=(C5/1.0)/(A5/1.0);
                ny9=-10.0;
                ny10=10.0;
            }
            else{
                nx9=-10.0;
                nx10=10.0;
                ny9=((-A5/1.0)/(B5/1.0))*(-10)+((C5/1.0)/(B5/1.0));
                ny10=((-A5/1.0)/(B5/1.0))*(10)+((C5/1.0)/(B5/1.0));
            }

            if(j%2==0){
                if(A6==0){
                    nx11=-10.0;
                    nx12=10.0;
                    ny11=(C6/1.0)/(B6/1.0);
                    ny12=(C6/1.0)/(B6/1.0);
                }
                else if(B6==0){
                    nx11=(C6/1.0)/(A6/1.0);
                    nx12=(C6/1.0)/(A6/1.0);
                    ny11=-10.0;
                    ny12=10.0;
                }
                else{
                    nx11=-10.0;
                    nx12=10.0;
                    ny11=((-A6/1.0)/(B6/1.0))*(-10)+((C6/1.0)/(B6/1.0));
                    ny12=((-A6/1.0)/(B6/1.0))*(10)+((C6/1.0)/(B6/1.0));
                }
            }



            //Images
            if(j%2!=0){
                Plot plot = Plot.plot(Plot.plotOpts().
                                width(800).
                                height(800).
                                legend(Plot.LegendFormat.BOTTOM)).
                        xAxis("x", Plot.axisOpts().
                                range(-10, 10)).
                        yAxis("y", Plot.axisOpts().
                                range(-10, 10)).
                        series("L1:"+line1+"", Plot.data().
                                        xy(nx1, ny1).
                                        xy(nx2, ny2),
                                Plot.seriesOpts().
                                        line(Plot.Line.SOLID).
                                        color(Color.ORANGE).
                                        marker(Plot.Marker.DIAMOND).
                                        markerColor(Color.RED).
                                        markerSize(5)).
                        series("L2:"+line2+"", Plot.data().
                                        xy(nx3, ny3).
                                        xy(nx4, ny4),
                                Plot.seriesOpts().
                                        line(Plot.Line.SOLID).
                                        color(Color.BLUE).
                                        marker(Plot.Marker.DIAMOND).
                                        markerColor(Color.RED).
                                        markerSize(5)).
                        // series("L3:"+line3+"", Plot.data().
                        //     xy(nx5, ny5).
                        //     xy(nx6, ny6),
                        //     Plot.seriesOpts().
                        //         line(Plot.Line.SOLID).
                        //         color(Color.RED).
                        //         marker(Plot.Marker.DIAMOND).
                        //         markerColor(Color.RED).
                        //         markerSize(5)).
                                series("L3:"+line4+"", Plot.data().
                                        xy(nx7, ny7).
                                        xy(nx8, ny8),
                                Plot.seriesOpts().
                                        line(Plot.Line.SOLID).
                                        color(Color.BLACK).
                                        marker(Plot.Marker.DIAMOND).
                                        markerColor(Color.RED).
                                        markerSize(5)).
                        series("L4:"+line5+"", Plot.data().
                                        xy(nx9, ny9).
                                        xy(nx10, ny10),
                                Plot.seriesOpts().
                                        line(Plot.Line.SOLID).
                                        color(Color.RED).
                                        marker(Plot.Marker.DIAMOND).
                                        markerColor(Color.RED).
                                        markerSize(5)).
                        series("Point", Plot.data().
                                        xy(xIntersect,yIntersect),
                                Plot.seriesOpts().
                                        line(Plot.Line.NONE).
                                        color(Color.BLACK).
                                        marker(Plot.Marker.CIRCLE).
                                        markerColor(Color.RED).
                                        markerSize(12));

                plot.save("C:\\Users\\bhush\\Downloads\\Assign15_Images\\Graph"+j+"", "png");
               
            }
            else{
                Plot plot = Plot.plot(Plot.plotOpts().
                                width(800).
                                height(800).
                                legend(Plot.LegendFormat.BOTTOM)).
                        xAxis("x", Plot.axisOpts().
                                range(-10, 10)).
                        yAxis("y", Plot.axisOpts().
                                range(-10, 10)).
                        series("L1: "+line1+"", Plot.data().
                                        xy(nx1, ny1).
                                        xy(nx2, ny2),
                                Plot.seriesOpts().
                                        line(Plot.Line.SOLID).
                                        color(Color.ORANGE).
                                        marker(Plot.Marker.DIAMOND).
                                        markerColor(Color.RED).
                                        markerSize(5)).
                        // series("L2: "+line2+"", Plot.data().
                        // 	xy(nx3, ny3).
                        // 	xy(nx4, ny4),
                        // 	Plot.seriesOpts().
                        // 		line(Plot.Line.SOLID).
                        // 		color(Color.BLUE).
                        // 		marker(Plot.Marker.DIAMOND).
                        // 		markerColor(Color.RED).
                        // 		markerSize(5)).
                        // series("L3: "+line3+"", Plot.data().
                        // 	xy(nx5, ny5).
                        // 	xy(nx6, ny6),
                        // 	Plot.seriesOpts().
                        // 		line(Plot.Line.SOLID).
                        // 		color(Color.RED).
                        // 		marker(Plot.Marker.DIAMOND).
                        // 		markerColor(Color.RED).
                        // 		markerSize(5)).
                                series("L2: "+line4+"", Plot.data().
                                        xy(nx7, ny7).
                                        xy(nx8, ny8),
                                Plot.seriesOpts().
                                        line(Plot.Line.SOLID).
                                        color(Color.BLACK).
                                        marker(Plot.Marker.DIAMOND).
                                        markerColor(Color.RED).
                                        markerSize(5)).
                        series("L3: "+line5+"", Plot.data().
                                        xy(nx9, ny9).
                                        xy(nx10, ny10),
                                Plot.seriesOpts().
                                        line(Plot.Line.SOLID).
                                        color(Color.RED).
                                        marker(Plot.Marker.DIAMOND).
                                        markerColor(Color.RED).
                                        markerSize(5)).
                        series("L4: "+line6+"", Plot.data().
                                        xy(nx11, ny11).
                                        xy(nx12, ny12),
                                Plot.seriesOpts().
                                        line(Plot.Line.SOLID).
                                        color(Color.BLUE).
                                        marker(Plot.Marker.DIAMOND).
                                        markerColor(Color.RED).
                                        markerSize(5)).
                        series("Point", Plot.data().
                                        xy(xIntersect,yIntersect),
                                Plot.seriesOpts().
                                        line(Plot.Line.NONE).
                                        color(Color.BLACK).
                                        marker(Plot.Marker.CIRCLE).
                                        markerColor(Color.RED).
                                        markerSize(12));

              
                plot.save("C:\\Users\\bhush\\Downloads\\Assign15_Images\\Graph"+j+"", "png");
            }


            String imagePath = "C:\\Users\\bhush\\Downloads\\Assign15_Images\\Graph"+j+".png";
            
            // int rowNumber = j;
            // int columnNumber = 6;


            // Insert the image into the Excel sheet
            insertImageIntoExcel(sheet1, imagePath, j, 6,workbook);


            ArrayList<String> quearr = new ArrayList<String>();
            quearr.add(line1);
            quearr.add(line2);
            //quearr.add(line3);
            quearr.add(line4);
            quearr.add(line5);
            if(j%2==0){
                quearr.add(line6);
            }

            // int c1,c2,c3,c4;
            // do{
            // c1=(int)(Math.random()*4);
            // c2=(int)(Math.random()*4);
            // c3=(int)(Math.random()*4);
            // c4=(int)(Math.random()*4);
            // }while(c1==c2 ||c1==c3 || c1==c4 || c2==c3 || c2==c4 || c3==c4);

            String Que1,Que2,Correct_ans,Correct_ans1,Correct_ans2="",wrong_ans,wrong_ans1="",wrong_ans2,Solu,Solu1;
            if(j%2==0){
                Que1="2) Which of the following linear equations in two variables will have graphs passing through point $ ("+xIntersect+","+yIntersect+")$ ? <br>";//$ "+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";
                Que2="#खालील पैकी कोणकोणत्या रेषीय समीकरणाचा आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूतून जातो ? <br>"; //+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";
            }
            else{
                Que1="1) Which of the following linear equations in two variables will have graphs passing through point $ ("+xIntersect+","+yIntersect+")$ ? <br>";//$ "+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";
                Que2="#खालील पैकी कोणकोणत्या रेषीय समीकरणाचा आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूतून जातो ? <br>"; //+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";

            }
            String Question=""+Que1+""+Que2+"";

            if(j%2==0){
                Correct_ans="$ "+line4+"$ <br>";
                Correct_ans1="$ "+line5+"$ <br>";
                Correct_ans2="$ "+line6+"$ <br>";
                wrong_ans="$ "+line1+"$ <br>";
            }
            else{
                Correct_ans="$ "+line4+"$ <br>";
                Correct_ans1="$ "+line5+"$ <br>";
                wrong_ans="$ "+line1+"$ <br>";
                wrong_ans1="$ "+line2+"$ <br>";
            }


            //wrong_ans2="$ "+line2+"$ <br>";


            row.createCell(4).setCellValue(Question);
            //row.createCell(6).setCellFormula("");
            //				 row.createCell(7).setCellValue(" ");
            //				 row.createCell(8).setCellValue(" ");
            row.createCell(5).setCellValue(Correct_ans);
            row.createCell(7).setCellValue(Correct_ans1);
            if(j%2==0){
                row.createCell(8).setCellValue(Correct_ans2);
            }
            row.createCell(9).setCellValue(wrong_ans);
            if(j%2!=0){
                row.createCell(10).setCellValue(wrong_ans1);
            }
            //row.createCell(11).setCellValue(wrong_ans2);

            row.createCell(12).setCellValue(120);
            row.createCell(13).setCellValue(4);
            //	row.createCell(14).setCellValue("");
            row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");

            if(j%2==0){
                Solu="Ans $ 1\\ : "+line4+"$ <br>Ans $ 2\\ : "+line5+"$ <br>Ans $ 3\\ : "+line6+"$ <br> If graph of any equation is to pass through the point $ ("+xIntersect+","+yIntersect+")$ , it means the point $ ("+xIntersect+","+yIntersect+")$ must satisfy the equation.<br>"+
                        "For point $ ("+xIntersect+","+yIntersect+")$, we will find the values of all equations one by by substituting $ x="+xIntersect+"$ and $ y="+yIntersect+"$.<br>"+
                        "If the value of the equation comes out to be equal to the given value of that equation, then point $ ("+xIntersect+","+yIntersect+")$ will be lying on the graph corresponding to that equation.<br>"+
                        "We will verify this as follows, <br>"+
                        "For equation $ "+line4+"$ by putting the values as $ x="+xIntersect+"$ and $ y="+yIntersect+"$ we get<br>"+
                        "$ "+(A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B4==Math.abs(B4)? "+":"-")+""+(B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A4*xIntersect+""+(B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)+"="+C4+"$ which is same as given value.<br>"+
                        "$ \\therefore$ equation $ "+line4+"$ gets satisfied by point $ ("+xIntersect+","+yIntersect+")$.<br>"+
                        "$ \\therefore$ point $ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line4+" . . . .  (i)$<br>"+
                        "For equation $ "+line1+"$ , <br>"+
                        "By putting the values as $x="+xIntersect+"$ and $y="+yIntersect+"$ we get<br>"+
                        "$ "+(A1==Math.abs(A1) ? (A1==1 ? xIntersect : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A1==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B1==Math.abs(B1)? "+":"-")+""+(B1==Math.abs(B1) ? (B1==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B1==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A1*xIntersect+""+(B1*yIntersect==Math.abs(B1*yIntersect) ? "+"+B1*yIntersect : B1*yIntersect)+"="+(A1*xIntersect+B1*yIntersect)+"\\ne"+C1+"$ the given value of the equation<br>"+
                        "$ \\therefore$ point $ ("+xIntersect+","+yIntersect+")$ doesn't lie on the graph corresponding to equation $ "+line1+"  . . . .  (ii)$ <br>"+
                        "Similarly we can check for remaining equations and the result will be, <br>$ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line5+"  . . . .  (iii)$ and <br>"+
                        "$ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line2+" . . . .  (iv)$ <br>"+
                        "From $ (i)$ to $ (iv)$, we can conclude that, <br>"+
                        "the ordered pair $ ("+xIntersect+","+yIntersect+")$ lies on the graph for equations only for $ "+line4+"$ , $ "+line5+"$ and $ "+line6+"$ <br>"+
                        "No other equation is satisfied by the ordered pair $ ("+xIntersect+","+yIntersect+")$ .<br>"+
                        "We can observe this from the graph drawn for all given equations.<br> Answer $ 1:\\ "+line4+"$ , <br> Answer $ 2:\\ "+line5+"$ and<br>Answer $ 3:\\ "+line6+"$ <br>";

                Solu1="#उत्तर $ 1\\ : "+line4+"$ <br>उत्तर $ 2\\ : "+line5+"$ <br>उत्तर $ 3\\ : "+line6+"$  जर कोणताही आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूमधून जाणारा असेल तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या समीकरणाचे समाधान करत असायलाच हवा. <br>"+
                        "$ ("+xIntersect+","+yIntersect+")$ या बिंदू नुसार $ x="+xIntersect+"$ आणि $ y="+yIntersect+"$ अशा किमती प्रत्येक समीकरणात ठेवून त्या समीकरणाच्या किंमत शोधू. <br>"+
                        "जर समीकरणाची किंमत त्याच्या दिलेल्या किमती एवढी मिळाली, तरच $ ("+xIntersect+","+yIntersect+")$ हा बिंदू त्या समीकरणाच्या आलेखावर असेल. जर तेवढीच किंमत मिळाली नाही, तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू त्या समीकरणाच्या आलेखावर असू शकणार नाही. <br>"+
                        "हे आपण खाली दाखविल्या नुसार तपासू. <br>"+
                        "$ "+line4+"$ या समीकरणात $ ("+xIntersect+","+yIntersect+")$ या बिंदू साठी $ x="+xIntersect+"$ आणि  $ y="+yIntersect+"$ अशा किमती ठेवून आपल्याला <br>"+
                        "$ "+(A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B4==Math.abs(B4)? "+":"-")+""+(B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A4*xIntersect+""+(B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)+"="+C4+"$  असे उत्तर मिळते. आणि ही किंमत त्या समीकरणाच्या दिलेल्या किमती एवढीच आहे.<br>"+
                        "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line4+"$  या समीकरणाचे समाधान करतो<br>"+
                        "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू  $ "+line4+"$ या समीकरणाच्या आलेखावर असेल.$  . . . .(i)$<br>"+
                        "आता $ "+line1+"$ या समीकरणात $ ("+xIntersect+","+yIntersect+")$ या बिंदू साठी $ x="+xIntersect+"$ आणि  $ y="+yIntersect+"$ अशा किमती ठेवून आपल्याला <br>"+
                        "$ "+(A1==Math.abs(A1) ? (A1==1 ? xIntersect : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A1==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B1==Math.abs(B1)? "+":"-")+""+(B1==Math.abs(B1) ? (B1==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B1==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A1*xIntersect+""+(B1*yIntersect==Math.abs(B1*yIntersect) ? "+"+B1*yIntersect : B1*yIntersect)+"="+(A1*xIntersect+B1*yIntersect)+"\\ne"+C1+"$ असे उत्तर मिळते. आणि ही किंमत त्या समीकरणाच्या दिलेल्या किमती एवढी नाही.<br>"+
                        "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line1+"$  या समीकरणाचे समाधान करत नाही.<br>"+
                        "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू  $ "+line1+"$ या समीकरणाच्या आलेखावर नाही $ . .  . . . .(ii)$<br>"+
                        "याच पद्धतीने आपण दिलेल्या इतर समीकरणांसाठी हे तपासून पाहिले असता आपल्याला हे समजते की,<br>"+
                        "$ ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line5+"$ या समीकरणाच्या आलेखावर असेल. $  . . . .  (iii)$ आणि <br>"+
                        "$ ("+xIntersect+","+yIntersect+")$  हा बिंदू $ "+line6+"$ या समीकरणाच्या आलेखावर असेल. $ . . . .  (iv)$<br>"+
                        "$(i)$ ते $(iv)$ या वरून आपण असा निष्कर्ष काढू शकतो की,<br>"+
                        "$ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या पैकी फक्त $ "+line4+"$ , $ "+line5+"$ आणि $ "+line6+"$ या तीनच समीकरणांच्या आलेखावर असू शकतो. <br>"+
                        "इतर कोणत्याही समीकरणाच्या आलेखावर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू असू शकत नाही.<br>"+
                        "दिलेल्या सर्व समीकरणांच्या दाखविलेल्या आलेखावरून आपण याची खात्री करून घेऊ शकतो. <br> उत्तर $ 1:\\ "+line4+"$ , <br>उत्तर  $ 2:\\ "+line5+"$ आणि <br>उत्तर  $ 3:\\ "+line6+"$<br>";
            }
            else{
                Solu="Ans $ 1\\ : "+line4+"$ <br>Ans $ 2\\ : "+line5+"$ <br> If graph of any equation is to pass through the point $ ("+xIntersect+","+yIntersect+")$ , it means the point $ ("+xIntersect+","+yIntersect+")$ must satisfy the equation.<br>"+
                        "For point $ ("+xIntersect+","+yIntersect+")$, we will find the values of all equations one by by substituting $ x="+xIntersect+"$ and $ y="+yIntersect+"$.<br>"+
                        "If the value of the equation comes out to be equal to the given value of that equation, then point $ ("+xIntersect+","+yIntersect+")$ will be lying on the graph corresponding to that equation.<br>"+
                        "We will verify this as follows, <br>"+
                        "For equation $ "+line4+"$ by putting the values as $ x="+xIntersect+"$ and $ y="+yIntersect+"$ we get<br>"+
                        "$ "+(A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B4==Math.abs(B4)? "+":"-")+""+(B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A4*xIntersect+""+(B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)+"="+C4+"$ which is same as given value.<br>"+
                        "$ \\therefore$ equation $ "+line4+"$ gets satisfied by point $ ("+xIntersect+","+yIntersect+")$.<br>"+
                        "$ \\therefore$ point $ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line4+" . . . .  (i)$<br>"+
                        "For equation $ "+line1+"$ , <br>"+
                        "By putting the values as $ x="+xIntersect+"$ and $ y="+yIntersect+"$ we get<br>"+
                        "$ "+(A1==Math.abs(A1) ? (A1==1 ? xIntersect : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A1==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B1==Math.abs(B1)? "+":"-")+""+(B1==Math.abs(B1) ? (B1==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B1==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A1*xIntersect+""+(B1*yIntersect==Math.abs(B1*yIntersect) ? "+"+B1*yIntersect : B1*yIntersect)+"="+(A1*xIntersect+B1*yIntersect)+"\\ne"+C1+"$ the given value of the equation<br>"+
                        "$ \\therefore$ point $ ("+xIntersect+","+yIntersect+")$ doesn't lie on the graph corresponding to equation $ "+line1+"  . . . .  (ii)$ <br>"+
                        "Similarly we can check for remaining equations and the result will be,<br>$ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line5+"  . . . .  (iii)$ and <br>"+
                        "$ ("+xIntersect+","+yIntersect+")$ doesn't lie on the graph corresponding to equation $ "+line2+" . . . .  (iv)$ <br>"+
                        "From $ (i)$ to $ (iv)$ , we can conclude that, <br>"+
                        "the ordered pair $ ("+xIntersect+","+yIntersect+")$ lies on the graph for equations only for $ "+line4+"$ and $ "+line5+"$ <br>"+
                        "No other equation is satisfied by the ordered pair $ ("+xIntersect+","+yIntersect+")$ .<br>"+
                        "We can observe this from the graph drawn for all given equations. <br> Answer $ 1:\\ "+line4+"$ and<br> Answer $ 2:\\ "+line5+"$ <br>";

                Solu1="#उत्तर $ 1\\ : "+line4+"$ <br>उत्तर $ 2\\ : "+line5+"$ <br> जर कोणताही आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूमधून जाणारा असेल तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या समीकरणाचे समाधान करत असायलाच हवा. <br>"+
                        "$ ("+xIntersect+","+yIntersect+")$ या बिंदू नुसार $ x="+xIntersect+"$ आणि $ y="+yIntersect+"$ अशा किमती प्रत्येक समीकरणात ठेवून त्या समीकरणाच्या किंमत शोधू. <br>"+
                        "जर समीकरणाची किंमत त्याच्या दिलेल्या किमती एवढी मिळाली, तरच $ ("+xIntersect+","+yIntersect+")$ हा बिंदू त्या समीकरणाच्या आलेखावर असेल. जर तेवढीच किंमत मिळाली नाही, तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू त्या समीकरणाच्या आलेखावर असू शकणार नाही. <br>"+
                        "हे आपण खाली दाखविल्या नुसार तपासू. <br>"+
                        "$ "+line4+"$ या समीकरणात $ ("+xIntersect+","+yIntersect+")$ या बिंदू साठी $ x="+xIntersect+"$ आणि  $ y="+yIntersect+"$ अशा किमती ठेवून आपल्याला <br>"+
                        "$ "+(A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B4==Math.abs(B4)? "+":"-")+""+(B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A4*xIntersect+""+(B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)+"="+C4+"$  असे उत्तर मिळते. आणि ही किंमत त्या समीकरणाच्या दिलेल्या किमती एवढीच आहे.<br>"+
                        "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line4+"$  या समीकरणाचे समाधान करतो<br>"+
                        "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू  $ "+line4+"$ या समीकरणाच्या आलेखावर असेल.$  . . . .(i)$<br>"+
                        "आता $ "+line1+"$ या समीकरणात $ ("+xIntersect+","+yIntersect+")$ या बिंदू साठी $ x="+xIntersect+"$ आणि  $ y="+yIntersect+"$ अशा किमती ठेवून आपल्याला <br>"+
                        "$ "+(A1==Math.abs(A1) ? (A1==1 ? xIntersect : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A1==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B1==Math.abs(B1)? "+":"-")+""+(B1==Math.abs(B1) ? (B1==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B1==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A1*xIntersect+""+(B1*yIntersect==Math.abs(B1*yIntersect) ? "+"+B1*yIntersect : B1*yIntersect)+"="+(A1*xIntersect+B1*yIntersect)+"\\ne"+C1+"$ असे उत्तर मिळते. आणि ही किंमत त्या समीकरणाच्या दिलेल्या किमती एवढी नाही.<br>"+
                        "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line1+"$  या समीकरणाचे समाधान करत नाही.<br>"+
                        "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू  $ "+line1+"$ या समीकरणाच्या आलेखावर नाही $ . .  . . . .(ii)$<br>"+
                        "याच पद्धतीने आपण दिलेल्या इतर समीकरणांसाठी हे तपासून पाहिले असता आपल्याला हे समजते की,<br>"+
                        "$ ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line5+"$ या समीकरणाच्या आलेखावर असेल.$  . . . .  (iii)$ आणि <br>"+
                        "$ ("+xIntersect+","+yIntersect+")$  हा बिंदू $ "+line2+"$ या समीकरणाच्या आलेखावर नाही. $ . . . .  (iv)$<br>"+
                        "$(i)$ ते $(iv)$ या वरून आपण असा निष्कर्ष काढू शकतो की,<br>"+
                        "$ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या पैकी फक्त $ "+line4+"$ आणि $ "+line5+"$ या दोनच समीकरणांच्या आलेखावर असू शकतो. <br>"+
                        "इतर कोणत्याही समीकरणाच्या आलेखावर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू असू शकत नाही.<br>"+
                        "दिलेल्या सर्व समीकरणांच्या दाखविलेल्या आलेखावरून आपण याची खात्री करून घेऊ शकतो. <br> उत्तर $ 1:\\ "+line4+"$ आणि <br>उत्तर  $ 2:\\ "+line5+"$<br>";
            }
            String Solution =""+Solu+" "+Solu1+"";

            // String abc="Ans $ 1\\ : "+line4+"$ <br>Ans $ 2\\ : "+line5+"$ <br> If graph of any equation is to pass through the point $ ("+xIntersect+","+yIntersect+")$ , it means the point $ ("+xIntersect+","+yIntersect+")$ must satisfy the equation.<br>"+
            // 	"For point $ ("+xIntersect+","+yIntersect+")$, we will find the values of all equations one by by substituting $ x="+xIntersect+"$ and $ y="+yIntersect+"$.<br>"+
            // 	"If the value of the equation comes out to be equal to the given value of that equation, then point $ ("+xIntersect+","+yIntersect+")$ will be lying on the graph corresponding to that equation.<br>"+
            // 	"We will verify this as follows, <br>"+
            // 	"For equation $ "+line4+"$ by putting the values as $ x="+xIntersect+"$ and $ y="+yIntersect+"$ we get<br>"+
            // 	"$ "+(A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B4==Math.abs(B4)? "+":"-")+""+(B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A4*xIntersect+""+(B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)+"="+C4+"$ which is same as given value.<br>"+
            // 	"$ \\therefore$ equation $ "+line4+"$ gets satisfied by point $ ("+xIntersect+","+yIntersect+")$.<br>"+
            // 	"$ \\therefore$ point $ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line4+" . . . .  (i)$<br>"+
            // 	"For equation $ "+line1+"$ , <br>"+
            // 	"By putting the values as $ x="+xIntersect+"$ and $ y="+yIntersect+"$ we get<br>"+
            // 	"$ "+(A1==Math.abs(A1) ? (A1==1 ? xIntersect : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A1==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B1==Math.abs(B1)? "+":"-")+""+(B1==Math.abs(B1) ? (B1==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B1==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A1*xIntersect+""+(B1*yIntersect==Math.abs(B1*yIntersect) ? "+"+B1*yIntersect : B1*yIntersect)+"="+(A1*xIntersect+B1*yIntersect)+"\\ne"+C1+"$ the given value of the equation<br>"+
            // 	"$ \\therefore$ point $ ("+xIntersect+","+yIntersect+")$ doesn't lie on the graph corresponding to equation $ "+line1+"  . . . .  (ii)$<br>"+
            // 	"Similarly we can check for remaining equations and the result will be,<br>$ ("+xIntersect+","+yIntersect+")$ lies on the graph corresponding to equation $ "+line5+"  . . . .  (iii)$ and <br>"+
            // 	"$ ("+xIntersect+","+yIntersect+")$ doesn't lie on the graph corresponding to equation $ "+line2+" . . . .  (iv)$ <br>"+
            // 	"From $ (i)$ to $ (iv)$ , we can conclude that,<br>"+
            // 	"the ordered pair $ ("+xIntersect+","+yIntersect+")$ lies on the graph for equations only for $ "+line4+"$ and $ "+line5+"$ <br>"+
            // 	"No other equation is satisfied by the ordered pair $ ("+xIntersect+","+yIntersect+")$ .<br>"+
            // 	"We can observe this from the graph drawn for all given equations.<br> Answer $ 1:\\ "+line4+"$ and<br> Answer $ 2:\\ "+line5+"$ <br>";


            // (A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))
            // (B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))

            //B4*yIntersect  (B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)
            // String abc2="#उत्तर $1\\ : "+line4+"$ <br>उत्तर $2\\ : "+line5+"$ <br> जर कोणताही आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूमधून जाणारा असेल तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या समीकरणाचे समाधान करत असायलाच हवा. <br>"+
            // "$ ("+xIntersect+","+yIntersect+")$ या बिंदू नुसार $ x="+xIntersect+"$ आणि $ y="+yIntersect+"$ अशा किमती प्रत्येक समीकरणात ठेवून त्या समीकरणाच्या किंमत शोधू. <br>"+
            // "जर समीकरणाची किंमत त्याच्या दिलेल्या किमती एवढी मिळाली, तरच $ ("+xIntersect+","+yIntersect+")$ हा बिंदू त्या समीकरणाच्या आलेखावर असेल. जर तेवढीच किंमत मिळाली नाही, तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू त्या समीकरणाच्या आलेखावर असू शकणार नाही. <br>"+
            // "हे आपण खाली दाखविल्या नुसार तपासू. <br>"+
            // "$ "+line4+"$ या समीकरणात $ ("+xIntersect+","+yIntersect+")$ या बिंदू साठी $ x="+xIntersect+"$ आणि  $ y="+yIntersect+"$ अशा किमती ठेवून आपल्याला <br>"+
            // "$ "+(A4==Math.abs(A4) ? (A4==1 ? xIntersect : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A4==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A4+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B4==Math.abs(B4)? "+":"-")+""+(B4==Math.abs(B4) ? (B4==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B4==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B4)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A4*xIntersect+""+(B4*yIntersect==Math.abs(B4*yIntersect) ? "+"+B4*yIntersect : B4*yIntersect)+"="+C4+"$  असे उत्तर मिळते. आणि ही किंमत त्या समीकरणाच्या दिलेल्या किमती एवढीच आहे.<br>"+
            // "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line4+"$  या समीकरणाचे समाधान करतो<br>"+
            // "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू  $ "+line4+"$ या समीकरणाच्या आलेखावर असेल.$  . . . .(i)$<br>"+
            // "आता $ "+line1+"$ या समीकरणात $ ("+xIntersect+","+yIntersect+")$ या बिंदू साठी $ x="+xIntersect+"$ आणि  $ y="+yIntersect+"$ अशा किमती ठेवून आपल्याला <br>"+
            // "$ "+(A1==Math.abs(A1) ? (A1==1 ? xIntersect : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}") : (A1==-1 ? (xIntersect==Math.abs(xIntersect) ? "-"+xIntersect : "-("+xIntersect+")") : "\\{"+A1+"\\times"+(xIntersect==Math.abs(xIntersect) ? xIntersect : "("+xIntersect+")")+"\\}"))+""+(B1==Math.abs(B1)? "+":"-")+""+(B1==Math.abs(B1) ? (B1==1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}") : (B1==-1 ? (yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")") : "\\{"+Math.abs(B1)+"\\times"+(yIntersect==Math.abs(yIntersect) ? yIntersect : "("+yIntersect+")")+"\\}"))+"= "+A1*xIntersect+""+(B1*yIntersect==Math.abs(B1*yIntersect) ? "+"+B1*yIntersect : B1*yIntersect)+"="+(A1*xIntersect+B1*yIntersect)+"\\ne"+C1+"$ असे उत्तर मिळते. आणि ही किंमत त्या समीकरणाच्या दिलेल्या किमती एवढी नाही.<br>"+
            // "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line1+"$  या समीकरणाचे समाधान करत नाही.<br>"+
            // "$\\therefore ("+xIntersect+","+yIntersect+")$ हा बिंदू  $ "+line1+"$ या समीकरणाच्या आलेखावर नाही $ . .  . . . .(ii)$<br>"+
            // "याच पद्धतीने आपण दिलेल्या इतर समीकरणांसाठी हे तपासून पाहिले असता आपल्याला हे समजते की,<br>"+
            // "$ ("+xIntersect+","+yIntersect+")$ हा बिंदू $ "+line5+"$ या समीकरणाच्या आलेखावर असेल.$  . . . .  (iii)$ आणि <br>"+
            // "$ ("+xIntersect+","+yIntersect+")$  हा बिंदू $ "+line2+"$ या समीकरणाच्या आलेखावर नाही. $ . . . .  (iv)$<br>"+
            // "$(i)$ ते $(iv)$ या वरून आपण असा निष्कर्ष काढू शकतो की,<br>"+
            // "$ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या पैकी फक्त $ "+line4+"$ आणि $ "+line5+"$ या दोनच समीकरणांच्या आलेखावर असू शकतो. <br>"+
            // "इतर कोणत्याही समीकरणाच्या आलेखावर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू असू शकत नाही.<br>"+
            // "दिलेल्या सर्व समीकरणांच्या दाखविलेल्या आलेखावरून आपण याची खात्री करून घेऊ शकतो. <br> उत्तर $ 1:\\ "+line4+"$ आणि <br>उत्तर  $ 2:\\ "+line5+"$<br>";



            row.createCell(16).setCellValue(Solution);
            row.createCell(17).setCellValue(imagePath);
            row.createCell(18).setCellValue(107);


            String Checker;
            if(j%2==0){
                Checker =""+line1+""+line4+""+line5+""+line6+"";
            }
            else{
                Checker =""+line1+""+line2+""+line4+""+line5+"";
            }
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
        row.createCell(0).setCellValue("");

        //Writing data to the file
        FileOutputStream fileout = new FileOutputStream(filename);
        workbook.write(fileout);
        fileout.close();

        System.out.println("file created");

    }

}