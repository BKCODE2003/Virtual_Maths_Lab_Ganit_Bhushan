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
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.ss.usermodel.*;



import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VLab_0304060403_102_1_Assign10_Bhushan {

	public static void insertImageIntoExcel(XSSFSheet sheet, String imagePath, int rowNumber, int columnNumber) throws IOException {
        // Add the picture to the workbook
        FileInputStream inputStream = new FileInputStream(imagePath);
        byte[] bytes = IOUtils.toByteArray(inputStream);
        int pictureIdx = sheet.getWorkbook().addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
        inputStream.close();

        // Create the drawing patriarch
        XSSFDrawing drawing = sheet.createDrawingPatriarch();
		

        // Add a picture shape
        ClientAnchor anchor = new XSSFClientAnchor();
		
        
        anchor.setCol1(columnNumber);
        anchor.setRow1(rowNumber);
        anchor.setCol2(columnNumber + 1);
        anchor.setRow2(rowNumber+1);
		

        
        Picture pict = drawing.createPicture(anchor, pictureIdx);
		pict.resize(0.5);
    }

	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VLab_0304060403_102_1_Assign10_Bhushan.xlsx";     //Location where excel file is getting generated
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
		//int imageColumnWidth = 400/7;
		//sheet1.setColumnWidth(6, imageColumnWidth * 256);  // Adjust the width to fit the image (810 pixels)
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
                    
                   

                    

                  
					int a=(int)(Math.random()*12)+1;
					Integer nx1=0,ny1=0,nx2=0,ny2=0,nx3=0,ny3=0,nx4=0,ny4=0,nx5=0,ny5=0;
					do{
						switch(a){
							case 1:	
							nx1=(int)(Math.random()*10)-10;
							ny1=(int)(Math.random()*10)+1;

							nx2=(int)(Math.random()*10)+1;
							ny2=(int)(Math.random()*10)+1;
							nx3=(int)(Math.random()*10)+1;
							ny3=(int)(Math.random()*10)+1;
							nx4=(int)(Math.random()*10)+1;
							ny4=(int)(Math.random()*10)+1;
							nx5=(int)(Math.random()*10)+1;
							ny5=(int)(Math.random()*10)+1;
							break;

							case 2:
							nx1=(int)(Math.random()*10)-10;
							ny1=(int)(Math.random()*10)-10;

							nx2=(int)(Math.random()*10)+1;
							ny2=(int)(Math.random()*10)+1;
							nx3=(int)(Math.random()*10)+1;
							ny3=(int)(Math.random()*10)+1;
							nx4=(int)(Math.random()*10)+1;
							ny4=(int)(Math.random()*10)+1;
							nx5=(int)(Math.random()*10)+1;
							ny5=(int)(Math.random()*10)+1;
							break;
							
							case 3:
							nx1=(int)(Math.random()*10)+1;
							ny1=(int)(Math.random()*10)-10;
							

							nx2=(int)(Math.random()*10)+1;
							ny2=(int)(Math.random()*10)+1;
							nx3=(int)(Math.random()*10)+1;
							ny3=(int)(Math.random()*10)+1;
							nx4=(int)(Math.random()*10)+1;
							ny4=(int)(Math.random()*10)+1;
							nx5=(int)(Math.random()*10)+1;
							ny5=(int)(Math.random()*10)+1;

							break;

							case 4:
							nx1=(int)(Math.random()*10)+1;
							ny1=(int)(Math.random()*10)-10;

							nx2=(int)(Math.random()*10)-10;
							ny2=(int)(Math.random()*10)+1;
							nx3=(int)(Math.random()*10)-10;
							ny3=(int)(Math.random()*10)+1;
							nx4=(int)(Math.random()*10)-10;
							ny4=(int)(Math.random()*10)+1;
							nx5=(int)(Math.random()*10)-10;
							ny5=(int)(Math.random()*10)+1;

							break;

							case 5:
							nx1=(int)(Math.random()*10)+1;
							ny1=(int)(Math.random()*10)+1;

							nx2=(int)(Math.random()*10)-10;
							ny2=(int)(Math.random()*10)+1;
							nx3=(int)(Math.random()*10)-10;
							ny3=(int)(Math.random()*10)+1;
							nx4=(int)(Math.random()*10)-10;
							ny4=(int)(Math.random()*10)+1;
							nx5=(int)(Math.random()*10)-10;
							ny5=(int)(Math.random()*10)+1;

							break;

							case 6:
							nx1=(int)(Math.random()*10)-10;
							ny1=(int)(Math.random()*10)-10;

							nx2=(int)(Math.random()*10)-10;
							ny2=(int)(Math.random()*10)+1;
							nx3=(int)(Math.random()*10)-10;
							ny3=(int)(Math.random()*10)+1;
							nx4=(int)(Math.random()*10)-10;
							ny4=(int)(Math.random()*10)+1;
							nx5=(int)(Math.random()*10)-10;
							ny5=(int)(Math.random()*10)+1;

							break;

							case 7:
							nx1=(int)(Math.random()*10)+1;
							ny1=(int)(Math.random()*10)+1;

							nx2=(int)(Math.random()*10)-10;
							ny2=(int)(Math.random()*10)-10;
							nx3=(int)(Math.random()*10)-10;
							ny3=(int)(Math.random()*10)-10;
							nx4=(int)(Math.random()*10)-10;
							ny4=(int)(Math.random()*10)-10;
							nx5=(int)(Math.random()*10)-10;
							ny5=(int)(Math.random()*10)-10;

							break;

							case 8:
							nx1=(int)(Math.random()*10)-10;
							ny1=(int)(Math.random()*10)+1;

							nx2=(int)(Math.random()*10)-10;
							ny2=(int)(Math.random()*10)-10;
							nx3=(int)(Math.random()*10)-10;
							ny3=(int)(Math.random()*10)-10;
							nx4=(int)(Math.random()*10)-10;
							ny4=(int)(Math.random()*10)-10;
							nx5=(int)(Math.random()*10)-10;
							ny5=(int)(Math.random()*10)-10;

							break;

							case 9:
							nx1=(int)(Math.random()*10)+1;
							ny1=(int)(Math.random()*10)-10;

							nx2=(int)(Math.random()*10)-10;
							ny2=(int)(Math.random()*10)-10;
							nx3=(int)(Math.random()*10)-10;
							ny3=(int)(Math.random()*10)-10;
							nx4=(int)(Math.random()*10)-10;
							ny4=(int)(Math.random()*10)-10;
							nx5=(int)(Math.random()*10)-10;
							ny5=(int)(Math.random()*10)-10;

							break;

							case 10:
							nx1=(int)(Math.random()*10)+1;
							ny1=(int)(Math.random()*10)+1;

							nx2=(int)(Math.random()*10)+1;
							ny2=(int)(Math.random()*10)-10;
							nx3=(int)(Math.random()*10)+1;
							ny3=(int)(Math.random()*10)-10;
							nx4=(int)(Math.random()*10)+1;
							ny4=(int)(Math.random()*10)-10;
							nx5=(int)(Math.random()*10)+1;
							ny5=(int)(Math.random()*10)-10;

							break;


							case 11:
							nx1=(int)(Math.random()*10)-10;
							ny1=(int)(Math.random()*10)+1;

							nx2=(int)(Math.random()*10)+1;
							ny2=(int)(Math.random()*10)-10;
							nx3=(int)(Math.random()*10)+1;
							ny3=(int)(Math.random()*10)-10;
							nx4=(int)(Math.random()*10)+1;
							ny4=(int)(Math.random()*10)-10;
							nx5=(int)(Math.random()*10)+1;
							ny5=(int)(Math.random()*10)-10;

							break;


							case 12:
							nx1=(int)(Math.random()*10)-10;
							ny1=(int)(Math.random()*10)-10;

							nx2=(int)(Math.random()*10)+1;
							ny2=(int)(Math.random()*10)-10;
							nx3=(int)(Math.random()*10)+1;
							ny3=(int)(Math.random()*10)-10;
							nx4=(int)(Math.random()*10)+1;
							ny4=(int)(Math.random()*10)-10;
							nx5=(int)(Math.random()*10)+1;
							ny5=(int)(Math.random()*10)-10;

							break;

							default:
							break;
						}
					}while(((nx2==nx3)&&(ny2==ny3))||((nx2==nx4)&&(ny2==ny4))||((nx2==nx5)&&(ny2==ny5))||((nx3==nx4)&&(ny3==ny4))||((nx3==nx5)&&(ny3==ny5))||((nx4==nx5)&&(ny4==ny5)));
					//Images
					Plot plot = Plot.plot(Plot.plotOpts().
								width(800).
								height(800).
								legend(Plot.LegendFormat.NONE)).	
							xAxis("x", Plot.axisOpts().
								range(-10, 10)).
							yAxis("y", Plot.axisOpts().
								range(-10, 10)).
							series("Same1", Plot.data().
								xy(nx1, ny1),
								Plot.seriesOpts().
									line(Plot.Line.NONE).
									color(Color.BLACK).
									marker(Plot.Marker.CIRCLE).
									markerColor(Color.RED).
									markerSize(12)).
							series("Different5", Plot.data().
									xy(nx2, ny2),
									Plot.seriesOpts().
										line(Plot.Line.NONE).
										color(Color.BLACK).
										marker(Plot.Marker.CIRCLE).
										markerColor(Color.BLACK).
										markerSize(12)).
							series("Different1", Plot.data().
								xy(nx3, ny3),
								Plot.seriesOpts().
									line(Plot.Line.NONE).
									color(Color.BLACK).
									marker(Plot.Marker.CIRCLE).
									markerColor(Color.BLACK).
									markerSize(12)).
							series("Different2", Plot.data().
									xy(nx4, ny4),
									Plot.seriesOpts().
										line(Plot.Line.NONE).
										color(Color.BLACK).
										marker(Plot.Marker.CIRCLE).
										markerColor(Color.BLACK).
										markerSize(12)).
							series("Different3", Plot.data().
										xy(nx5, ny5),
										Plot.seriesOpts().
											line(Plot.Line.NONE).
											color(Color.BLACK).
											marker(Plot.Marker.CIRCLE).
											markerColor(Color.BLACK).
											markerSize(12));
						plot.save("C:\\Users\\bhush\\Downloads\\Assign10_Images\\Graph"+j+"", "png");
					//Images

					String imagePath = "C:\\Users\\bhush\\Downloads\\Assign10_Images\\Graph"+j+".png";
					// int rowNumber = j; 
					// int columnNumber = 6; 


					// Insert the image into the Excel sheet
					insertImageIntoExcel(sheet1, imagePath, j, 6);



					ArrayList<String> quearr = new ArrayList<String>();
					quearr.add(nx1.toString());
					quearr.add(nx2.toString());
					quearr.add(nx3.toString());
					quearr.add(nx4.toString());
					quearr.add(nx5.toString());

					ArrayList<String> quearr2 = new ArrayList<String>();
					quearr2.add(ny1.toString());
					quearr2.add(ny2.toString());
					quearr2.add(ny3.toString());
					quearr2.add(ny4.toString());
					quearr2.add(ny5.toString());


					int c1,c2,c3,c4,c5;
					do{
					c1=(int)(Math.random()*5);
					c2=(int)(Math.random()*5);
					c3=(int)(Math.random()*5);
					c4=(int)(Math.random()*5);
					c5=(int)(Math.random()*5);
					}while(c1==c2 ||c1==c3 || c1==c4 || c1==c5 ||c2==c3 || c2==c4 || c2==c5 || c3==c4 || c3==c5 || c4==c5 );
					

					String Que1,Que2,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Solu,Solu1;
                    Que1="From the following given ordered pairs of points, identify a point which lies in different quadrant as compared to others.<br>$("+quearr.get(c1)+","+quearr2.get(c1)+"), ("+quearr.get(c2)+","+quearr2.get(c2)+"), ("+quearr.get(c3)+","+quearr2.get(c3)+"), ("+quearr.get(c4)+","+quearr2.get(c4)+"), ("+quearr.get(c5)+","+quearr2.get(c5)+")$<br>";
                    Que2="#खाली दिलेल्या बिंदूंच्या क्रमित जोड्यांपैकी कोणती क्रमित जोडी (बिंदू) इतर बिंदूंपेक्षा वेगळ्या चरणात आहे?<br>$("+quearr.get(c1)+","+quearr2.get(c1)+"), ("+quearr.get(c2)+","+quearr2.get(c2)+"), ("+quearr.get(c3)+","+quearr2.get(c3)+"), ("+quearr.get(c4)+","+quearr2.get(c4)+"), ("+quearr.get(c5)+","+quearr2.get(c5)+")$<br>";

					String Question=""+Que1+""+Que2+"";

                    Correct_ans="$("+nx1+","+ny1+")$ <br>";
                    int cx=(int)(Math.random()*4);

                    if(cx==0){
                    wrong_ans="$("+nx2+","+ny2+")$ <br>";
                    wrong_ans1="$("+nx4+","+ny4+")$ <br>";
                    wrong_ans2="$("+nx5+","+ny5+")$ <br>";
                    }
                    else if(cx==1){
                    wrong_ans="$("+nx3+","+ny3+")$ <br>";
                    wrong_ans1="$("+nx5+","+ny5+")$ <br>";
                    wrong_ans2="$("+nx2+","+ny2+")$ <br>";
                    }
                    else if(cx==2){
                    wrong_ans="$("+nx3+","+ny3+")$ <br>";
                    wrong_ans1="$("+nx4+","+ny4+")$ <br>";
                    wrong_ans2="$("+nx5+","+ny5+")$ <br>";
                    }
                    else{
                    wrong_ans="$("+nx2+","+ny2+")$ <br>";
                    wrong_ans1="$("+nx4+","+ny4+")$ <br>";
                    wrong_ans2="$("+nx3+","+ny3+")$ <br>";
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
					row.createCell(13).setCellValue(1);
		//				  row.createCell(14).setCellValue(" ");
					row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			
                    Solu="Ans : $("+nx1+","+ny1+")$ <br>We know that points<br> in first quadrant have both $x$ and $y$ coordinates positive as $(+,\\ +)$<br>In second quadrant we have $x$ coordinate is negative and $y$ coordinate is positive as $(-,\\ +)$<br>In third quadrant we have $x$ coordinate is negative and $y$ coordinate is negative as $(-,\\ -)$<br>In forth quadrant we have $x$ coordinate is positive and $y$ coordinate is negative as $(+,\\ -)$<br>Accordingly, as shown in the figure, for the given points we get that $("+nx2+","+ny2+"), ("+nx3+","+ny3+"), ("+nx4+","+ny4+"), ("+nx5+","+ny5+")$ these points lie in "+(nx2 >= 0 && ny2 >= 0 ? "first" :nx2 < 0 && ny2 >= 0 ? "second" :nx2 < 0 && ny2 < 0 ? "third" :"fourth")+" quadrant<br>and only $("+nx1+","+ny1+")$ lies in "+(nx1 >= 0 && ny1 >= 0 ? "first" :nx1 < 0 && ny1 >= 0 ? "second" :nx1 < 0 && ny1 < 0 ? "third" :"fourth")+" quadrant.<br>$\\therefore$ as compared to other points, the point  $("+nx1+","+ny1+")$ lies in different quadrant is the answer.<br>";
					Solu1="#उत्तर : $("+nx1+","+ny1+")$<br>आपल्याला माहिती आहे की आलेखावरच्या<br> पहिल्या चरणातील बिंदूंसाठी $x$ आणि $y$ दोन्हीच्या किमती धन असतात, जसे $(+,\\ +)$<br>तसेच दुसऱ्या चरणातील बिंदूंसाठी $x$ ची किंमत ऋण आणि $y$ ची किंमत धन असते, जसे $(-,\\ +)$<br>तिसऱ्या चरणातील बिंदूंसाठी $x$ ची किंमत ऋण आणि $y$ ची किंमत सुद्धा ऋण असते, जसे $(-,\\ -)$<br>चौथ्या चरणातील बिंदूंसाठी $x$ ची किंमत धन आणि $y$ ची किंमत ऋण असते, जसे $(+,\\ -)$<br>या नुसार, आपण हे सर्व बिंदू सोबतच्या आलेखात दाखविले असता दिलेल्या बिंदूंपैकी  $("+nx2+","+ny2+"), ("+nx3+","+ny3+"), ("+nx4+","+ny4+"), ("+nx5+","+ny5+")$ हे सर्व बिंदू "+(nx2 >= 0 && ny2 >= 0 ? "पहिल्या" :nx2 < 0 && ny2 >= 0 ? "दुसऱ्या" :nx2 < 0 && ny2 < 0 ? "तिसऱ्या" :"चौथ्या") +" चरणात येतात<br>आणि फक्त  $("+nx1+","+ny1+")$ हा बिंदू "+(nx1 >= 0 && ny1 >= 0 ? "पहिल्या" :nx1 < 0 && ny1 >= 0 ? "दुसऱ्या" :nx1 < 0 && ny1 < 0 ? "तिसऱ्या" :"चौथ्या") +" चरणात येतो.<br>$\\therefore$ सर्व बिंदूंची तुलना करता  $("+nx1+","+ny1+")$ हा एकमेव बिंदू वेगळ्या चरणात येतो, हे उत्तर.<br>";

					String Solution = ""+Solu+" "+Solu1+"";	
				
				
					row.createCell(16).setCellValue(Solution);
					row.createCell(17).setCellValue(imagePath);
					row.createCell(18).setCellValue(102);

				

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