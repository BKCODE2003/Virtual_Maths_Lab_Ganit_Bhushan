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

public class VLab_0304060403_106_2_Assign14_Bhushan {

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
		String filename = "D:/excel files/VLab_0304060403_106_2_Assign14_Bhushan.xlsx";     //Location where excel file is getting generated
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
						xIntersect=0;
						yIntersect=0;
						do {
							A4 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
							B4 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
						} while (A4 == 0 || B4 == 0); // Ensure A1 and B1 are not  zero
				
						C4 = A4 * xIntersect + B4 * yIntersect;

						do {
							A5 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
							B5 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
						} while (A5 == 0 || B5 == 0 || (A4==A5 && B4==B5)); // Ensure A1 and B1 are not  zero
				
						C5 = A5 * xIntersect + B5 * yIntersect;

                        if(j%2==0){
                            do {
                                A6 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
                                B6 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
                            } while (A6 == 0 || B6 == 0 ||(A6==A4 && B6==B4) ||(A6==A5 && B6==B5)); // Ensure A1 and B1 are not  zero
                    
                            C6 = A6 * xIntersect + B6 * yIntersect;
                            line6=""+(A6==Math.abs(A6) ? (A6==1 ? "":A6):(A6==-1 ? "-":A6))+"x"+(B6==Math.abs(B6) ? (B6==1 ? "+":"+"+B6):(B6==-1 ? "-":B6))+"y="+C6+"";	
                        }


					
						do{
							qx1 = (int)(Math.random()*17)-8;
							qy1 = (int)(Math.random()*17)-8;
						}while(qx1==0 || qy1==0);
	
						do{
							A1 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
							B1 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
							C1 = A1 * qx1 + B1 * qy1;
							pd1=Math.abs(C1)/Math.sqrt(A1*A1+B1*B1);
						} while (j%2==0 ? ((A1 == 0 && B1 == 0) || (A1==A4 && B1==B4) ||(A1==A5 && B1==B5) ||(A1==A6 && B1==B6)|| pd1<1):((A1 == 0 && B1 == 0) || (A1==A4 && B1==B4) ||(A1==A5 && B1==B5)|| pd1<1)); // Ensure A1 and B1 are not both zero
					
							
							
						do{
						qx2 = (int)(Math.random()*17)-8;
						qy2 = (int)(Math.random()*17)-8;
						}while(qx2==0 || qy2==0);

						do{
							A2 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
							B2 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
							C2 = A2 * qx2 + B2 * qy2;
							pd2=Math.abs(C2)/Math.sqrt(A2*A2+B2*B2);
						} while (j%2==0 ? ((A2 == 0 && B2 == 0) || (A2==A4 && B2==B4) ||(A2==A5 && B2==B5) ||(A2==A6 && B2==B6)|| pd2<1):((A2 == 0 && B2 == 0) || (A2==A4 && B2==B4) ||(A2==A5 && B2==B5)|| pd2<1)); // Ensure A1 and B1 are not both zero
					
							
	
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

						
						line4=""+(A4==Math.abs(A4) ? (A4==1 ? "":A4):(A4==-1 ? "-":A4))+"x"+(B4==Math.abs(B4) ? (B4==1 ? "+":"+"+B4):(B4==-1 ? "-":B4))+"y="+C4+"";	
                        line5=""+(A5==Math.abs(A5) ? (A5==1 ? "":A5):(A5==-1 ? "-":A5))+"x"+(B5==Math.abs(B5) ? (B5==1 ? "+":"+"+B5):(B5==-1 ? "-":B5))+"y="+C5+"";	
						                       
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


					
					nx7=-10.0;
					nx8=10.0;
					ny7=((-A4/1.0)/(B4/1.0))*(-10);
					ny8=((-A4/1.0)/(B4/1.0))*(10);

                    nx9=-10.0;
					nx10=10.0;
					ny9=((-A5/1.0)/(B5/1.0))*(-10);
					ny10=((-A5/1.0)/(B5/1.0))*(10);

                    if(j%2==0){
                        nx11=-10.0;
                        nx12=10.0;
                        ny11=((-A6/1.0)/(B6/1.0))*(-10);
                        ny12=((-A6/1.0)/(B6/1.0))*(10);
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
                                series("Origin", Plot.data().
                                            xy(0,0),
                                            Plot.seriesOpts().
                                                line(Plot.Line.NONE).
                                                color(Color.BLACK).
                                                marker(Plot.Marker.CIRCLE).
                                                markerColor(Color.RED).
                                                markerSize(12));

                        plot.save("C:\\Users\\bhush\\Downloads\\Assign14_Images\\Graph"+j+"", "png");
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
							series("Origin", Plot.data().
										xy(0,0),
										Plot.seriesOpts().
											line(Plot.Line.NONE).
											color(Color.BLACK).
											marker(Plot.Marker.CIRCLE).
											markerColor(Color.RED).
											markerSize(12));

					    plot.save("C:\\Users\\bhush\\Downloads\\Assign14_Images\\Graph"+j+"", "png");
                    }
						
				    
                String imagePath = "C:\\Users\\bhush\\Downloads\\Assign14_Images\\Graph"+j+".png";
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
						Que1="2) Which of the following linear equations in two variables will have graphs passing through origin ? <br>";//$ "+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";
						Que2="#खालील पैकी कोणकोणत्या रेषीय समीकरणाचा आलेख आरंभ बिंदूतून जातो ? <br>"; //+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";
					}
					else{
						Que1="1) Which of the following linear equations in two variables will have graphs passing through origin ? <br>";//$ "+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";
                        Que2="#खालील पैकी कोणकोणत्या रेषीय समीकरणाचा आलेख आरंभ बिंदूतून जातो ? <br>"; //+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";

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
						Solu="Ans : $ "+line4+"$ <br>$ "+line5+"$ <br>$ "+line6+"$ <br>If graph of any equation is to pass through the origin $ (0,0)$ , it means the point $ (0,0)$ must satisfy the equation.<br>By inspection, we can see that, only $ "+line4+", "+line5+"$ and $ "+line6+"$ are the equations, which are getting satisfied by the ordered pair $ (0,0)$ . And none other equation is satisfied by the ordered pair $ (0,0)$ or origin. <br>Answer $ 1:\\ "+line4+", $ <br>Answer $ 2:\\ "+line5+"$ and<br> Answer $ 3:\\ "+line6+"$ are the answers. <br>";

						Solu1="#उत्तर : $ "+line4+"$ <br>$ "+line5+"$ <br>$ "+line6+"$ <br> जर कोणताही आलेख आरंभ बिंदूतून म्हणजे $ (0,0)$ मधून जाणारा असेल तर $ (0,0)$ हा बिंदू (क्रमित जोडी) दिलेल्या समीकरणाचे समाधान करत असायलाच हवा. <br>तपासणी पद्धतीने आपल्याला हे कळते की $ (0,0)$ हा बिंदू $ "+line4+", "+line5+"$ and $ "+line6+"$ याच तीन समीकरणांचे समाधान करतो आणि दुसऱ्या कोणत्याही समीकरणांचे समाधान करीत नाही. <br>उत्तर $ 1:\\ "+line4+", $ <br>उत्तर $ 2:\\ "+line5+"$ आणि<br> उत्तर $ 3:\\ "+line6+"$ ही उत्तरे आहेत. <br>";
					}
					else{
						Solu="Ans : $ "+line4+"$ <br>$ "+line5+"$ <br> If graph of any equation is to pass through the origin $ (0,0)$ , it means the point $ (0,0)$ must satisfy the equation.<br>By inspection, we can see that, only $ "+line4+"$ and $ "+line5+"$ are the equations, which are getting satisfied by the ordered pair $ (0,0)$ . And none other equation is satisfied by the ordered pair $ (0,0)$ or origin. <br>Answer $ 1:\\ "+line4+"$ and<br> Answer $ 2:\\ "+line5+"$ are the answers. <br>";

						Solu1="#उत्तर : $ "+line4+"$ <br>$ "+line5+"$ <br> जर कोणताही आलेख आरंभ बिंदूतून म्हणजे $ (0,0)$ मधून जाणारा असेल तर $ (0,0)$ हा बिंदू (क्रमित जोडी) दिलेल्या समीकरणाचे समाधान करत असायलाच हवा. <br>तपासणी पद्धतीने आपल्याला हे कळते की $ (0,0)$ हा बिंदू $ "+line4+"$ and $ "+line5+"$ याच दोन समीकरणांचे समाधान करतो आणि दुसऱ्या कोणत्याही समीकरणांचे समाधान करीत नाही. <br>उत्तर $ 1:\\ "+line4+"$ आणि<br> उत्तर $ 2:\\ "+line5+"$ ही उत्तरे आहेत. <br>";
					}
					String Solution =""+Solu+" "+Solu1+"";	
				
				
					row.createCell(16).setCellValue(Solution);
    				row.createCell(17).setCellValue(imagePath);
						row.createCell(18).setCellValue(106);

				
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
				row.createCell(0).setCellValue("****");

					//Writing data to the file
					FileOutputStream fileout = new FileOutputStream(filename);
					workbook.write(fileout);
					fileout.close();
					
					System.out.println("file created");
			    
}

}