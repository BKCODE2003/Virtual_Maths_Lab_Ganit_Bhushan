import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.awt.Color;

import java.io.FileInputStream;



import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;

import org.apache.poi.ss.usermodel.*;



import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VLab_0304060403_103_1_Assign11_Bhushan {

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
		String filename = "D:/excel files/VLab_0304060403_103_1_Assign11_Bhushan.xlsx";     //Location where excel file is getting generated
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
                    

					// Generate a random intersection point within the range -8 to 8
					
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
					
                    String line1;
					
					
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


					// Generate unique fake points
                    ArrayList<int[]> fakePoints = new ArrayList<>();
                    Set<String> pointSet = new HashSet<>();

                    // Add specific points if they do not lie on the line
                    // addFakePoint(fakePoints, pointSet, A1, B1, C1, yIntersect, xIntersect);
                    // addFakePoint(fakePoints, pointSet, A1, B1, C1, -xIntersect, -yIntersect);
                    // addFakePoint(fakePoints, pointSet, A1, B1, C1, xIntersect, -yIntersect);
                    // addFakePoint(fakePoints, pointSet, A1, B1, C1, -xIntersect, yIntersect);

                    // Generate additional unique fake points if needed
                    while (fakePoints.size() < 3) {
                        int xFake = xIntersect + (int)(Math.random()*5 - 2); // Generate a fake x-coordinate near the intersection point
                        int yFake = yIntersect + (int)(Math.random()*5 - 2); // Generate a fake y-coordinate near the intersection point

                        // Check if the fake point lies on the line and is unique
                        addFakePoint(fakePoints, pointSet, A1, B1, C1, xFake, yFake);
                    }

                    int[] point = fakePoints.get(0);
                    int[] point1 = fakePoints.get(1);
                    int[] point2 = fakePoints.get(2);
                    
                    ArrayList<String> quearr1 = new ArrayList<String>();
					quearr1.add("("+point[0]+","+point[1]+")");
                    quearr1.add("("+point1[0]+","+point1[1]+")");
                    quearr1.add("("+point2[0]+","+point2[1]+")");
                    quearr1.add("("+xIntersect+","+yIntersect+")");


					

					//Images
					Plot plot = Plot.plot(Plot.plotOpts().
								width(800).
								height(800).
								legend(Plot.LegendFormat.BOTTOM)).	
							xAxis("x", Plot.axisOpts().
								range(-10, 10)).
							yAxis("y", Plot.axisOpts().
								range(-10, 10)).
							series("Line : "+line1+" ", Plot.data().
								xy(nx1, ny1).
								xy(nx2, ny2),
								Plot.seriesOpts().
									line(Plot.Line.SOLID).
									color(Color.BLACK).
									marker(Plot.Marker.DIAMOND).
									markerColor(Color.RED).
									markerSize(5)).
							series("Point on line ", Plot.data().
										xy(xIntersect,yIntersect),
										Plot.seriesOpts().
											line(Plot.Line.NONE).
											color(Color.BLACK).
											marker(Plot.Marker.CIRCLE).
											markerColor(Color.RED).
											markerSize(12)).
							series(""+quearr1.get(0)+"", Plot.data().
										xy(point[0],point[1]),
										Plot.seriesOpts().
											line(Plot.Line.NONE).
											color(Color.BLACK).
											marker(Plot.Marker.CIRCLE).
											markerColor(Color.BLACK).
											markerSize(8)).
							series(""+quearr1.get(1)+"", Plot.data().
										xy(point1[0],point1[1]),
										Plot.seriesOpts().
											line(Plot.Line.NONE).
											color(Color.BLACK).
											marker(Plot.Marker.CIRCLE).
											markerColor(Color.BLACK).
											markerSize(8)).
							series(""+quearr1.get(2)+"", Plot.data().
										xy(point2[0],point2[1]),
										Plot.seriesOpts().
											line(Plot.Line.NONE).
											color(Color.BLACK).
											marker(Plot.Marker.CIRCLE).
											markerColor(Color.BLACK).
											markerSize(8));

					plot.save("C:\\Users\\bhush\\Downloads\\Assign11_Images\\Graph"+j+"", "png");
											//Images
						
				    
                String imagePath = "C:\\Users\\bhush\\Downloads\\Assign11_Images\\Graph"+j+".png";
					// int rowNumber = j; 
					// int columnNumber = 6; 


					// Insert the image into the Excel sheet
					insertImageIntoExcel(sheet1, imagePath, j, 6,workbook);

					
					ArrayList<String> quearr = new ArrayList<String>();
					quearr.add(line1);
					
                    
                    
					int c1,c2,c3,c4;
					do{
					c1=(int)(Math.random()*4);
					c2=(int)(Math.random()*4);
					c3=(int)(Math.random()*4);
					c4=(int)(Math.random()*4);
					}while(c1==c2 ||c1==c3 || c1==c4 || c2==c3 || c2==c4 || c3==c4);
					
					String Que1,Que2,Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Solu,Solu1;
                    Que1="If a graph for a linear equation $ "+line1+"$ is passing through point $ ("+xIntersect+","+yIntersect+")$ as shown, then which of the following point satisfies the given equation. <br>" ;//+quearr1.get(c1)+", "+quearr1.get(c2)+", "+quearr1.get(c3)+", "+quearr1.get(c4)+"$ <br>";
                    Que2="#जर $ "+line1+"$ या रेषीय समीकरणासाठीचा आलेख आकृती मध्ये दाखविल्या नुसार $ ("+xIntersect+","+yIntersect+")$ या क्रमित जोडीतून (बिंदूतून) जातो, तर खालील पैकी कोणत्या क्रमित जोड्या (बिंदू) दिलेल्या समीकरणाचे समाधान करतात. <br>"; //+quearr1.get(c1)+", "+quearr1.get(c2)+", "+quearr1.get(c3)+", "+quearr1.get(c4)+"$ <br>";


				
					String Question=""+Que1+""+Que2+"";

                    Correct_ans="$ ("+xIntersect+","+yIntersect+")$<br>";
                    wrong_ans="$ "+quearr1.get(0)+"$ <br>";
                    wrong_ans1="$ "+quearr1.get(1)+"$ <br>";
                    wrong_ans2="$ "+quearr1.get(2)+"$ <br>";

					
					row.createCell(4).setCellValue(Question);
				    //row.createCell(6).setCellFormula("");
		//				 row.createCell(7).setCellValue(" ");
		//				 row.createCell(8).setCellValue(" ");
					row.createCell(5).setCellValue(Correct_ans);
					row.createCell(9).setCellValue(wrong_ans);
					row.createCell(10).setCellValue(wrong_ans1);
					row.createCell(11).setCellValue(wrong_ans2);
				
					row.createCell(12).setCellValue(90);
					row.createCell(13).setCellValue(2);
				//	row.createCell(14).setCellValue("");
					row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			
                    Solu="Ans : $ ("+xIntersect+","+yIntersect+")$ <br>As, the graph of given equation passes through the point (ordered pair) $ ("+xIntersect+","+yIntersect+")$ , therefore this point lies on the graph of given equation. <br> This is same as saying that, this point satisfies the given equation.<br>Since, only one answer is correct, it implies that all other options are wrong. <br>We can verify this, by putting the values of $x$ and $y$ co-ordinates in the given equation. <br> By this we will come to know that, none of the remaining point satisfies the given equation.<br>$ \\therefore$ only $ ("+xIntersect+","+yIntersect+")$ is the point which satisfies the equation, is the answer. <br>";
					Solu1="#उत्तर: $ ("+xIntersect+","+yIntersect+")$ <br>ज्या अर्थी दिलेल्या समीकरणाचा आलेख $ ("+xIntersect+","+yIntersect+")$ या बिंदूतून जातो, म्हणजेच हा बिंदू या समीकरणाच्या आलेखावर आहे. याचा अर्थ हा बिंदू दिलेल्या समीकरणाचे समाधान करतो हे निश्चित.<br>आणि एकच उत्तर बरोबर असल्याने, इतर बिंदू दिलेल्या समीकरणाचे नक्की समाधान करणार नाहीत.<br> हे आपण दिलेल्या बिंदूंमधील $x$ आणि $y$ निर्देशकांच्या किमती समीकरणात ठेवून हे तपासू शकतो. <br>यातून आपल्याला हे समजते, की दुसऱ्या कोणत्याही बिंदूंचे निर्देशक या समीकरणाच्या समाधान करीत नाहीत. <br>$ \\therefore$ फक्त $ ("+xIntersect+","+yIntersect+")$ हा बिंदू दिलेल्या समीकरणाचे समाधान करतो हे उत्तर. <br> ";

					String Solution = ""+Solu+" "+Solu1+"";	
				
				
					row.createCell(16).setCellValue(Solution);
					row.createCell(17).setCellValue(imagePath);
						row.createCell(18).setCellValue(103);

				

		String Checker =""+line1+""+xIntersect+""+yIntersect+"";
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
private static void addFakePoint(ArrayList<int[]> fakePoints, Set<String> pointSet, int A1, int B1, int C1, int x, int y) {
        if (A1 * x + B1 * y != C1) {
            String pointString = x + "," + y;
            if (!pointSet.contains(pointString)) {
                fakePoints.add(new int[]{x, y});
                pointSet.add(pointString);
            }
        }
    }
}