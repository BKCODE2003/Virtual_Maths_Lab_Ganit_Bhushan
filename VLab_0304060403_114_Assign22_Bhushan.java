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

public class VLab_0304060403_114_Assign22_Bhushan {

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

	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VLab_0304060403_114_Assign22_Bhushan.xlsx";     //Location where excel file is getting generated
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
		sheet1.setColumnWidth(10, 57*256);
		sheet1.setColumnWidth(11, 57*256);
		sheet1.setColumnWidth(12, 57*256);
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
                    

					
					Integer nx1=0,ny1=0,nx2=0,ny2=0,nx3=0,ny3=0,nx4=0,ny4=0;
					double k1,k2,l1,l2,m1,m2,g1,g2,ans1,ans2,del1,nx5,ny5;

					do{
						do{
							nx1=(int)(Math.random()*21)-10;
							ny1=(int)(Math.random()*21)-10;
							nx2=(int)(Math.random()*21)-10;
							ny2=(int)(Math.random()*21)-10;
							nx3=(int)(Math.random()*21)-10;
							ny3=(int)(Math.random()*21)-10;
							nx4=(int)(Math.random()*21)-10;
							ny4=(int)(Math.random()*21)-10;
								
							 
							g1=gcd(ny2-ny1,nx2-nx1);
							g2=gcd(ny4-ny3,nx4-nx3);
						}while(g1==0 || g2==0 ||nx1==0||nx2==0||nx3==0||nx4==0||ny1==0||ny2==0||ny3==0||ny4==0);

					//System.out.println("g1="+g1+" g2="+g2+"");
					k1=Math.round((ny2-ny1)*100)/(g1*100.0);
					l1=Math.round((nx2-nx1)*100)/(g1*100.0);

					k2=Math.round((ny4-ny3)*100)/(g2*100.0);
					l2=Math.round((nx4-nx3)*100)/(g2*100.0);

					m1=(-ny1*l1+k1*nx1);
					m2=(-ny3*l2+k2*nx3);
                                                                                                                  
					del1=-k1*l2+l1*k2;

					}while((nx1==nx2 && ny1==ny2)||(nx3==nx4 && ny3==ny4)|| del1==0);


					ans1=(-m1*l2+m2*l1);
					ans2=k1*m2-k2*m1;

					//System.out.println(""+(ans1/del1)+"");
					//System.out.println(""+(ans2/del1)+"");

					nx5=(ans1/del1)*100;
					nx5=Math.round(nx5)/100.0;
					ny5=(ans2/del1)*100;
					ny5=Math.round(ny5)/100.0;

					//System.out.println(""+nx5+" "+ny5+"");

					//System.out.println("nx1="+nx1+" ny1="+ny1+" nx2="+nx2+" ny2="+ny2+" nx3="+nx3+" ny3="+ny3+" nx4="+nx4+" ny4="+ny4+" Answer   nx5="+nx5+" ny5="+ny5+" k1="+k1+" k2="+k2+" l1="+l1+" l2="+l2+" m1="+m1+" m2="+m2+"");
					String line1,line2;
					
					line1=""+(k1==Math.abs(k1) ? (k1==1 ? "":k1):(k1==-1 ? "-":k1))+"x"+(l1==Math.abs(l1) ? (l1==1 ? "-":"-"+l1):(l1==-1 ? "+":"+"+(Math.abs(l1))))+"y="+m1+"";
					line2=""+(k2==Math.abs(k2) ? (k2==1 ? "":k2):(k2==-1 ? "-":k2))+"x"+(l2==Math.abs(l2) ? (l2==1 ? "-":"-"+l2):(l2==-1 ? "+":"+"+(Math.abs(l2))))+"y="+m2+"";

					// obj.setMessage(line1);
					// obj.setMessage1(line2);
    				// System.out.println("nx1 to nx8 :("+nx1+","+ny1+")("+nx2+","+ny2+")("+nx3+","+ny3+")("+nx4+","+ny4+")("+nx5+","+ny5+")");

					//Images
					Plot plot = Plot.plot(Plot.plotOpts().
								width(800).
								height(800).
								legend(Plot.LegendFormat.NONE)).	
							xAxis("x", Plot.axisOpts().
								range(-10, 10)).
							yAxis("y", Plot.axisOpts().
								range(-10, 10)).
							series("Line1", Plot.data().
								xy(nx1, ny1).
								xy(nx2, ny2),
								Plot.seriesOpts().
									line(Plot.Line.SOLID).
									color(Color.BLACK).
									marker(Plot.Marker.DIAMOND).
									markerColor(Color.RED).
									markerSize(5)).
							series("Line2", Plot.data().
									xy(nx3, ny3).
									xy(nx4,ny4),
									Plot.seriesOpts().
										line(Plot.Line.SOLID).
										color(Color.BLUE).
										marker(Plot.Marker.SQUARE).
										markerColor(Color.RED).
										markerSize(5)).
							series("Point", Plot.data().
										xy(nx5,ny5),
										Plot.seriesOpts().
											line(Plot.Line.NONE).
											color(Color.BLACK).
											marker(Plot.Marker.INCIRCLE).
											markerColor(Color.RED).
											markerSize(12));

						plot.save("Assign12", "png");
					//Images

					String imagePath = "Assign12.png";
					// int rowNumber = j; 
					// int columnNumber = 6; 


					// Insert the image into the Excel sheet
					insertImageIntoExcel(sheet1, imagePath, j, 6,workbook);

					
					ArrayList<String> quearr = new ArrayList<String>();
					quearr.add(line1);
					quearr.add(line2);
				
					ArrayList<String> quearr1 = new ArrayList<String>();
					quearr1.add(nx1.toString());
					quearr1.add(nx2.toString());
					quearr1.add(nx3.toString());
					quearr1.add(nx4.toString());
					quearr1.add(""+ny5);
					

					ArrayList<String> quearr2 = new ArrayList<String>();
					quearr2.add(ny1.toString());
					quearr2.add(ny2.toString());
					quearr2.add(ny3.toString());
					quearr2.add(ny4.toString());
					quearr2.add(""+nx5);
					
					int c1,c2,c3,c4;
					do{
					c1=(int)(Math.random()*4);
					c2=(int)(Math.random()*4);
					c3=(int)(Math.random()*4);
					c4=(int)(Math.random()*4);
					}while(c1==c2 ||c1==c3 || c1==c4 || c2==c3 || c2==c4 || c3==c4);
					

					String Que1,Que2,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Solu,Solu1;
                    Que1="If the graphs of $"+quearr.get(0)+", "+quearr.get(1)+"$ intersect each other at $("+nx5+","+ny5+")$ then which of the following points will satisfy both the given equations simultaneously?<br>$("+quearr1.get(c1)+","+quearr2.get(c1)+"), ("+quearr1.get(c2)+","+quearr2.get(c2)+"), ("+quearr1.get(c3)+","+quearr2.get(c3)+"), ("+quearr1.get(c4)+","+quearr2.get(c4)+")$<br>";
                    Que2="#जर $"+quearr.get(0)+", "+quearr.get(1)+"$ या दोन एकसामायिक रेषीय समीकरणांचा छेदन बिंदू $("+nx5+","+ny5+")$ हा असेल तर, या बिंदू शिवाय खालील पैकी आणखीन कोणते बिंदू दिलेल्या समीकरणांचें एकाच वेळी समाधान करतील?<br>$("+quearr1.get(c1)+","+quearr2.get(c1)+"), ("+quearr1.get(c2)+","+quearr2.get(c2)+"), ("+quearr1.get(c3)+","+quearr2.get(c3)+"), ("+quearr1.get(c4)+","+quearr2.get(c4)+")$<br>";

					String Question=""+Que1+""+Que2+"";

                    Correct_ans="None of the given <br>#दिलेल्या पैकी कोणतेच नाही<br>";
                    wrong_ans="$("+quearr1.get(3)+","+quearr2.get(3)+")$<br>";
                    wrong_ans1="$("+quearr1.get(4)+","+quearr2.get(4)+")$<br>";
                    wrong_ans2="$("+quearr1.get(1)+","+quearr2.get(1)+")$<br>";

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
		//				  row.createCell(14).setCellValue(" ");
					row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			
                    Solu="Ans : None of the given<br>Point of intersection of the graphs for linear equations, lies on both the graphs simultaneously and it also satisfies both the equations simultaneously. As, we know that the solution for simultaneous equations is always unique, and therefore, there can't be any other point apart from $("+nx5+","+ny5+")$  which will lie on both the graphs simultaneously.<br>Hence None of the given is the answer.<br>";
					Solu1="उत्तर : दिलेल्या पैकी काहीही नाही<br>दिलेल्या एकसामायिक रेषीय समीकरणांचा छेदन बिंदू, हा त्यांच्या दोन्ही आलेखाचा भाग असतो, तसेच तो बिंदू दोन्ही समीकरणांचें समाधान देखील करतो. आपल्याला हे माहिती आहे की, एकसामायिक रेषीय समीकरणांचे समाधान फक्त एकच असते आणि म्हणून $("+nx5+","+ny5+")$ या शिवाय दुसरा कोणताही बिंदू या दोन्ही समीकरणांचें एकाच वेळी समाधान करणार नाहीत.<br>म्हणून 'दिलेल्या पैकी काहीही नाही' न्हे उत्तर. <br>";

					String Solution = ""+Solu+" "+Solu1+"";	
				
				
					row.createCell(16).setCellValue(Solution);
		//				  row.createCell(17).setCellValue(" ");
						row.createCell(18).setCellValue(104);

				

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