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

public class VLab_0304060403_108_1_Assign16_Bhushan {

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
		String filename = "D:/excel files/VLab_0304060403_108_1_Assign16_Bhushan.xlsx";     //Location where excel file is getting generated
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
					row.createCell(2).setCellValue(1);
					row.createCell(3).setCellValue("0304060403");
                    

					// Generate a random intersection point within the range -10 to 10
					int qx1,qy1,qx2,qy2,qx3,qy3,xIntersect,yIntersect;
					int A1, B1, C1, A2, B2, C2, A3, B3, C3, A4, B4, C4;
					double pd1,pd2,pd3;
					String line1,line2,line3,line4;

					do{
						do{
						xIntersect=(int)(Math.random()*17)-8;
						yIntersect=(int)(Math.random()*17)-8;
						}while(xIntersect==0 && yIntersect==0);

						do {
							A4 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
							B4 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
						} while (A4 == B4); // Ensure A1 and B1 are not  zero
				
						C4 = A4 * xIntersect + B4 * yIntersect;
						
						do{
							qx1 = (int)(Math.random()*17)-8;
							qy1 = (int)(Math.random()*17)-8;
					
							A1 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
							B1 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
							C1 = A1 * qx1 + B1 * qy1;
							pd1=Math.abs(A1*xIntersect+B1*yIntersect-C1)/Math.sqrt(A1*A1+B1*B1);
						} while ((A1 == B1) || (A1==A4 && B1==B4) || pd1<1 ||(qx1==0 && qy1==0)); // Ensure A1 and B1 are not both zero
				
						
						
						do{
							qx2 = (int)(Math.random()*17)-8;
							qy2 = (int)(Math.random()*17)-8;
						
							A2 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
							B2 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
							C2 = A2 * qx2 + B2 * qy2;
							pd2=Math.abs(A2*xIntersect+B2*yIntersect-C2)/Math.sqrt(A2*A2+B2*B2);
						} while ((A2 == B2)|| (A2==A4 && B2==B4) || pd2<1 ||(qx2==0 && qy2==0)); // Ensure A1 and B1 are not both zero
				
						
						do{
							qx3 = (int)(Math.random()*17)-8;
							qy3 = (int)(Math.random()*17)-8;
							
							A3 =(int)(Math.random()*21)-10; // Coefficient A1 between -10 and 10
							B3 =(int)(Math.random()*21)-10; // Coefficient B1 between -10 and 10
							C3 = A3 * qx3 + B3 * qy3;
							pd3=Math.abs(A3*xIntersect+B3*yIntersect-C3)/Math.sqrt(A3*A3+B3*B3);
						} while ((A3 == B3)|| (A3==A4 && B3==B4) || pd3<1 ||(qx3==0 && qy3==0)); // Ensure A1 and B1 are not both zero
				
						
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

						if(A3==0){
							line3=""+(B3==Math.abs(B3) ? (B3==1 ? "":""+B3):(B3==-1 ? "-":B3))+"y="+C3+"";	
							if(C3==0){
								line3="y="+C3+"";
							}	
						}
						else if(B3==0){
							line3=""+(A3==Math.abs(A3) ? (A3==1 ? "":A3):(A3==-1 ? "-":A3))+"x="+C3+"";		
							if(C3==0){
								line3="x="+C3+"";
							}
						}
						else{
							line3=""+(A3==Math.abs(A3) ? (A3==1 ? "":A3):(A3==-1 ? "-":A3))+"x"+(B3==Math.abs(B3) ? (B3==1 ? "+":"+"+B3):(B3==-1 ? "-":B3))+"y="+C3+"";	
						}

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

					}while(line1==line2 || line1==line3 || line2==line3);
				
				

					double nx1,nx2,ny1,ny2,nx3,nx4,ny3,ny4,nx5,nx6,ny5,ny6,nx7,nx8,ny7,ny8;

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

					if(A3==0){
						nx5=-10.0;
						nx6=10.0;
						ny5=(C3/1.0)/(B3/1.0);
						ny6=(C3/1.0)/(B3/1.0);
					}
					else if(B3==0){
						nx5=(C3/1.0)/(A3/1.0);
						nx6=(C3/1.0)/(A3/1.0);
						ny5=-10.0;
						ny6=10.0;
					}
					else{
						nx5=-10.0;
						nx6=10.0;
						ny5=((-A3/1.0)/(B3/1.0))*(-10)+((C3/1.0)/(B3/1.0));
						ny6=((-A3/1.0)/(B3/1.0))*(10)+((C3/1.0)/(B3/1.0));
					}


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

					
					// System.out.println("nx1 to nx8 :("+nx1+","+ny1+")("+nx2+","+ny2+")("+nx3+","+ny3+")("+nx4+","+ny4+")("+nx5+","+ny5+")("+nx6+","+ny6+")("+nx7+","+ny7+")("+nx8+","+ny8+")");
					//Images
					Plot plot = Plot.plot(Plot.plotOpts().
								width(800).
								height(800).
								legend(Plot.LegendFormat.BOTTOM)).	
							xAxis("x", Plot.axisOpts().
								range(-10, 10)).
							yAxis("y", Plot.axisOpts().
								range(-10, 10)).
							series("Line-1: "+line1+"", Plot.data().
								xy(nx1, ny1).
								xy(nx2, ny2),
								Plot.seriesOpts().
									line(Plot.Line.SOLID).
									color(Color.ORANGE).
									marker(Plot.Marker.DIAMOND).
									markerColor(Color.RED).
									markerSize(5)).
							series("Line-2: "+line2+"", Plot.data().
								xy(nx3, ny3).
								xy(nx4, ny4),
								Plot.seriesOpts().
									line(Plot.Line.SOLID).
									color(Color.BLUE).
									marker(Plot.Marker.DIAMOND).
									markerColor(Color.RED).
									markerSize(5)).
							series("Line-3: "+line3+"", Plot.data().
								xy(nx5, ny5).
								xy(nx6, ny6),
								Plot.seriesOpts().
									line(Plot.Line.SOLID).
									color(Color.RED).
									marker(Plot.Marker.DIAMOND).
									markerColor(Color.RED).
									markerSize(5)).
							series("Line-4: "+line4+"", Plot.data().
								xy(nx7, ny7).
								xy(nx8, ny8),
								Plot.seriesOpts().
									line(Plot.Line.SOLID).
									color(Color.BLACK).
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

					plot.save("C:\\Users\\bhush\\Downloads\\Assign16_Images\\Graph"+j+"", "png");
											//Images
						
				    
                String imagePath = "C:\\Users\\bhush\\Downloads\\Assign16_Images\\Graph"+j+".png";
					// int rowNumber = j; 
					// int columnNumber = 6; 

					//System.out.println(j);
					// Insert the image into the Excel sheet
					insertImageIntoExcel(sheet1, imagePath, j, 6,workbook);

					
					ArrayList<String> quearr = new ArrayList<String>();
					quearr.add(line1);
					quearr.add(line2);
					quearr.add(line3);
					quearr.add(line4);

					int c1,c2,c3,c4;
					do{
					c1=(int)(Math.random()*4);
					c2=(int)(Math.random()*4);
					c3=(int)(Math.random()*4);
					c4=(int)(Math.random()*4);
					}while(c1==c2 ||c1==c3 || c1==c4 || c2==c3 || c2==c4 || c3==c4);
					
					String Que1,Que2,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Solu,Solu1;
                    Que1="Which of the following linear equations in two variables will have a graph passing through $ ("+xIntersect+","+yIntersect+")$ ? <br>";//$ "+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";
                    Que2="#खालील पैकी कोणत्या रेषीय समीकरणाचा आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूतून जातो ? <br>";//$ "+quearr.get(c1)+", "+quearr.get(c2)+", "+quearr.get(c3)+", "+quearr.get(c4)+"$ <br>";

					String Question=""+Que1+""+Que2+"";

                    Correct_ans="$ "+line4+"$ <br>";
                    wrong_ans="$ "+line1+"$ <br>";
                    wrong_ans1="$ "+line3+"$ <br>";
                    wrong_ans2="$ "+line2+"$ <br>";

					
					row.createCell(4).setCellValue(Question);
				    //row.createCell(6).setCellFormula("");
		//				 row.createCell(7).setCellValue(" ");
		//				 row.createCell(8).setCellValue(" ");
					row.createCell(5).setCellValue(Correct_ans);
					row.createCell(9).setCellValue(wrong_ans);
					row.createCell(10).setCellValue(wrong_ans1);
					row.createCell(11).setCellValue(wrong_ans2);
				
					row.createCell(12).setCellValue(120);
					row.createCell(13).setCellValue(4);
				//	row.createCell(14).setCellValue("");
					row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			
                    Solu="Ans : $ "+line4+"$ <br>If graph of any equation is to pass through the point $ ("+xIntersect+","+yIntersect+")$ , it means the point $ ("+xIntersect+","+yIntersect+")$ must satisfy the equation. <br>By inspection, we can see that, only $ "+line4+"$ is the equation, which is getting satisfied by the ordered pair $ ("+xIntersect+","+yIntersect+")$ .<br>$ \\therefore$ graph of $ "+line4+"$ passes through the point $ ("+xIntersect+","+yIntersect+")$ . <br>None other equation is satisfied by the ordered pair $ ("+xIntersect+","+yIntersect+")$ . <br>$ \\therefore "+line4+"$ is the answer.<br>";

					Solu1="#उत्तर : $ "+line4+"$ <br> जर कोणताही आलेख $ ("+xIntersect+","+yIntersect+")$ बिंदूमधून जाणारा असेल तर $ ("+xIntersect+","+yIntersect+")$ हा बिंदू (क्रमित जोडी) दिलेल्या समीकरणाचे समाधान करत असायलाच हवा. <br>तपासणी पद्धतीने आपल्याला हे कळते की $ ("+xIntersect+","+yIntersect+")$ हा बिंदू फक्त $ "+line4+"$ याच समीकरणाचे समाधान करतो. <br>$ \\therefore "+line4+"$ या समीकरणाचा आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूतून जातो. <br>$ ("+xIntersect+","+yIntersect+")$ हा बिंदू दुसऱ्या कोणत्याही समीकरणाचे समाधान करीत नाही. <br>$ \\therefore "+line4+"$ हे उत्तर. <br>";

					String Solution = ""+Solu+" "+Solu1+"";	
				
				
					row.createCell(16).setCellValue(Solution);
    				row.createCell(17).setCellValue(imagePath);
						row.createCell(18).setCellValue(108);

				

		String Checker =""+line1+""+line2+""+line3+""+line4+"";
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