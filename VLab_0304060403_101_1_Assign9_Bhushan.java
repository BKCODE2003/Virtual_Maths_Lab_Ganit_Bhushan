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

public class VLab_0304060403_101_1_Assign9_Bhushan {

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
		String filename = "D:/excel files/VLab_0304060403_101_1_Assign9_Bhushan.xlsx";     //Location where excel file is getting generated
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
                    
                   

                    

                  
					int a=(int)(Math.random()*4)+1;
					Integer nx1=0,ny1=0,nx2=0,ny2=0,nx3=0,ny3=0,nx4=0,ny4=0,nx5=0,ny5=0;
					do{
						switch(a){
							case 1:	
							nx1=(int)(Math.random()*10)+1;
							ny1=(int)(Math.random()*10)+1;
							nx2=(int)(Math.random()*10)+1;
							ny2=(int)(Math.random()*10)+1;

							nx3=(int)(Math.random()*10)-10;
							ny3=(int)(Math.random()*10)+1;
							nx4=(int)(Math.random()*10)-10;
							ny4=(int)(Math.random()*10)-10;
							nx5=(int)(Math.random()*10)+1;
							ny5=(int)(Math.random()*10)-10;
							break;

							case 2:
							nx1=(int)(Math.random()*10)-10;
							ny1=(int)(Math.random()*10)+1;
							nx2=(int)(Math.random()*10)-10;
							ny2=(int)(Math.random()*10)+1;


							nx3=(int)(Math.random()*10)+1;
							ny3=(int)(Math.random()*10)+1;
							nx4=(int)(Math.random()*10)-10;
							ny4=(int)(Math.random()*10)-10;
							nx5=(int)(Math.random()*10)+1;
							ny5=(int)(Math.random()*10)-10;
							break;
							
							case 3:
							nx1=(int)(Math.random()*10)-10;
							ny1=(int)(Math.random()*10)-10;
							nx2=(int)(Math.random()*10)-10;
							ny2=(int)(Math.random()*10)-10;


							nx3=(int)(Math.random()*10)-10;
							ny3=(int)(Math.random()*10)+1;
							nx4=(int)(Math.random()*10)+1;
							ny4=(int)(Math.random()*10)+1;
							nx5=(int)(Math.random()*10)+1;
							ny5=(int)(Math.random()*10)-10;

							break;

							case 4:
							nx1=(int)(Math.random()*10)+1;
							ny1=(int)(Math.random()*10)-10;
							nx2=(int)(Math.random()*10)+1;
							ny2=(int)(Math.random()*10)-10;


							nx3=(int)(Math.random()*10)-10;
							ny3=(int)(Math.random()*10)+1;
							nx4=(int)(Math.random()*10)-10;
							ny4=(int)(Math.random()*10)-10;
							nx5=(int)(Math.random()*10)+1;
							ny5=(int)(Math.random()*10)+1;

							break;

							default:
							break;
						}
					}while(((nx1==nx2)&&(ny1==ny2))||((nx3==nx4)&&(ny3==ny4))||((nx3==nx5)&&(ny3==ny5))||((nx4==nx5)&&(ny4==ny5)));
                    
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
							series("Same2", Plot.data().
									xy(nx2, ny2),
									Plot.seriesOpts().
										line(Plot.Line.NONE).
										color(Color.BLACK).
										marker(Plot.Marker.CIRCLE).
										markerColor(Color.RED).
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
						plot.save("C:\\Users\\bhush\\Downloads\\Assign9_Images\\Graph"+j+"", "png"); //Make folder Assign9_Images and replace C:\\Users\\bhush\\Downloads\\Assign9_Images\\ this part with your path Enter your path
					//Images

					String imagePath = "C:\\Users\\bhush\\Downloads\\Assign9_Images\\Graph"+j+".png";
					// int rowNumber = j; 
					// int columnNumber = 6; 


					// Insert the image into the Excel sheet
					insertImageIntoExcel(sheet1, imagePath, j, 6,workbook);

					
				

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
                    Que1="From the following given points identify two points which lie in same quadrant.<br>$("+quearr.get(c1)+","+quearr2.get(c1)+"), ("+quearr.get(c2)+","+quearr2.get(c2)+"), ("+quearr.get(c3)+","+quearr2.get(c3)+"), ("+quearr.get(c4)+","+quearr2.get(c4)+"), ("+quearr.get(c5)+","+quearr2.get(c5)+")$<br>";
                    Que2="#दिलेल्या बिंदूंपैकी कोणते दोन बिंदू एकाच चरणात आहेत ?<br>$("+quearr.get(c1)+","+quearr2.get(c1)+"), ("+quearr.get(c2)+","+quearr2.get(c2)+"), ("+quearr.get(c3)+","+quearr2.get(c3)+"), ("+quearr.get(c4)+","+quearr2.get(c4)+"), ("+quearr.get(c5)+","+quearr2.get(c5)+")$<br>";

					String Question=""+Que1+""+Que2+"";

                    Correct_ans="$("+nx1+","+ny1+")$ and $("+nx2+","+ny2+")$<br>"+"$("+nx1+","+ny1+")$ आणि  $("+nx2+","+ny2+")$<br>";
                    wrong_ans="$("+nx5+","+ny5+")$ and $("+nx3+","+ny3+")$<br>"+"$("+nx5+","+ny5+")$ आणि  $("+nx3+","+ny3+")$<br>";
                    wrong_ans1="$("+nx4+","+ny4+")$ and $("+nx2+","+ny2+")$<br>"+"$("+nx4+","+ny4+")$ आणि  $("+nx2+","+ny2+")$<br>";
                    wrong_ans2="$("+nx1+","+ny1+")$ and $("+nx3+","+ny3+")$<br>"+"$("+nx1+","+ny1+")$ आणि  $("+nx3+","+ny3+")$<br>";

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
				
			
                    Solu="Ans : $("+nx1+","+ny1+")$ and $("+nx2+","+ny2+")$<br> Any point on the graph is denoted by it's co-ordinates and the pair of $x$ and $y$ co-ordinates is called as ordered pair $(x, y)$.<br> For any two points to be in the same quadrant, their both respective $x$ and $y$ coordinates must have same sign.<br>All given points are shown in the graph below.<br> Accordingly for, $("+nx1+","+ny1+")$ and $("+nx2+","+ny2+")$, their $x$ coordinates have same sign.<br>In this case, $x$ co-ordinates $("+nx1+" $ and $"+nx2+"$ "+(a==1 ||a==4 ? "are both positive":"are both negative")+") and<br> their $y$ coordinates also have same sign $("+ny1+"$ and $"+ny2+"$ "+(a==1 ||a==2 ? "are both positive":"are both negative")+").<br> For no other pair of points this is true.<br> Therefore two points $("+nx1+","+ny1+")$ and $("+nx2+","+ny2+")$ are the only pair of points, lying in the same quadrant, is the answer.<br>";
					Solu1="# उत्तर : $("+nx1+","+ny1+")$ आणि $("+nx2+","+ny2+")$<br> आलेख कागदा वरचे  बिंदू  $x$ आणि $y$ या त्याच्या निर्देशांकाने दाखवितात आणि त्या निर्देशांकांना क्रमित जोडी $(x, y)$ असेही म्हणतात.<br> कोणतेही दोन बिंदू एकाच चरणात असण्यासाठी त्यांच्या $x$ आणि $y$ या दोन्ही संगत निर्देशांकाचे चिन्ह समान असायला हवे.<br>आपल्याला विचारलेले सर्व बिंदू सोबतच्या आलेखात दाखविले आहेत. <br> त्यानुसार  $("+nx1+","+ny1+")$ आणि $("+nx2+","+ny2+")$ या दोन बिंदूचे $x$ निर्देशांकाचे चिन्ह समान आहे.<br> यातील दोन्ही बिंदूंचे $x$ निर्देशांकाचे चिन्ह सारखे, $("+nx1+" $ आणि $"+nx2+"$ "+(a==1 ||a==4 ? "धन":"ऋण")+") आहे.<br> आणि त्यांचे $y$ या निर्देशकांचे चिन्ह सुद्धा सारखे $("+ny1+" $ आणि $"+ny2+",$ "+(a==1 ||a==2 ? "धन":"ऋण")+") आहे.<br> तसेच, इतर कोणत्याही बिंदूंच्या जोडी बाबत आपण असे म्हणू शकत नाही.<br> म्हणून $("+nx1+","+ny1+")$ आणि $("+nx2+","+ny2+")$ हेच दोन बिंदू एकाच चरणात आहेत, हे उत्तर. <br>";

					String Solution = ""+Solu+" "+Solu1+"";	
				
				
					row.createCell(16).setCellValue(Solution);
		 			row.createCell(17).setCellValue(imagePath);
					row.createCell(18).setCellValue(101);

				

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