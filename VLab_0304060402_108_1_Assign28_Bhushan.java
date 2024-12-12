import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.HashMap;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.File;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VLab_0304060402_108_1_Assign28_Bhushan {

	private String carAName = "Car A";
    private String carBName = "Car B";
    private int carASpeed; // Speed of Car A
    private int carBSpeed; // Speed of Car B
    private int distanceBetweenCars; // Distance between the cars
    private int afterTime; // Time after which distances are calculated
    private int afterTimeDis; // Distance after time between cars
    private Image carAImageRight;
    private Image carAImageLeft;
    private Image carBImageRight;
    private Image carBImageLeft;

	public void draw_sol_img(int carASpeed, int carBSpeed, int distanceBetweenCars, int afterTime, int afterTimeDis,String saveLocation) {
        this.carASpeed = carASpeed;
        this.carBSpeed = carBSpeed;
        this.distanceBetweenCars = distanceBetweenCars;
        this.afterTime = afterTime;
        this.afterTimeDis = afterTimeDis;

        // Load car images
        try {
            carAImageRight = ImageIO.read(new File("Right_red_car.png")); // Right-facing Car A image
            carAImageLeft = ImageIO.read(new File("Left_red_car.png"));   // Left-facing Car A image
            carBImageRight = ImageIO.read(new File("Right_blue_car.png")); // Right-facing Car B image
            carBImageLeft = ImageIO.read(new File("Left_blue_car.png"));   // Left-facing Car B image
        } catch (IOException e) {
            e.printStackTrace();
        }
         // Create and save the image
        createImage(saveLocation);
    }

    public void createImage(String saveLocation) {
        // Create an image
        int width = 700;
        int height = 400;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        drawUpperPart(g);
        drawLowerPart(g);
        g.dispose();

        // Save the image to a file
        try {
            ImageIO.write(image, "png", new File(saveLocation));
            // System.out.println("Image saved as CarImage.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawUpperPart(Graphics g) {
        // Draw upper part background
        g.setColor(Color.white);
        g.fillRect(0, 0, 700, 200);

        // Position for cars in upper part
        int carASpace = 20; // Left corner space for Car A
        int carBSpace = carASpace + 500; // Right position for Car B

        // g.setColor(Color.BLACK);
       

        // Draw Car A
        drawCar(g, carASpace, 50, carAImageRight, carAName, carASpeed, "Right");

        // Draw connecting line centered between the cars
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(4)); // Set line thickness to 4
        g2d.draw(new Line2D.Double(
            carASpace + 160, 130, // Right end of Car A
            carBSpace - 20, 130 // Left end of Car B
        ));
        g.drawString("Car A : First Car        Car B : Second Car", 250, 30);
        g.drawString(" A ", 160, 150);
        g.drawString(" B ", 500, 150);
        // Draw Car B
        drawCar(g, carBSpace+10, 60, carBImageRight, carBName, carBSpeed, "Right");

        // Distance text below the line
        g.drawString("Distance AB: " + distanceBetweenCars + " Kms", carASpace + (carBSpace - carASpace) / 2, 150);
    }

    private void drawLowerPart(Graphics g) {
        // Draw lower part background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 200, 700, 200);

        // Position for cars in lower part
        int lowerCarASpace = 20; // Left corner for lower Car A
        int lowerCarBSpace = lowerCarASpace + 500; // Right position for lower Car B
        // g.setColor(Color.BLACK);
        

        // Draw lower Car A
        drawCar(g, lowerCarASpace, 250, carAImageRight, carAName, carASpeed, "Right");
        // Draw lower Car B
        drawCar(g, lowerCarBSpace+10, 260, carBImageLeft, carBName, carBSpeed, "Left");

        // Draw connecting line centered between the cars
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(4)); // Set line thickness to 4
        g2d.draw(new Line2D.Double(
            lowerCarASpace + 160, 320, // Right end of lower Car A
            lowerCarBSpace - 20, 320 // Left end of lower Car B
        ));
        g2d.draw(new Line2D.Double(
            300, 240, // Right end of lower Car A
            300, 310 // Left end of lower Car B
        ));
        g2d.draw(new Line2D.Double(
            400, 240, // Right end of lower Car A
            400, 310 // Left end of lower Car B
        ));

        g.drawString(" A ", 160, 340);
        g.drawString(" B ", 500, 340);

        g.drawString("Car A (After " + afterTime + "hr)", 210, 235);
        g.drawString("Car B (After " + afterTime + "hr)", 390, 235);

        g.drawString(" <---- " + afterTimeDis + " Kms ----> ", 300, 275);
        g.drawString("Distance AB: " + distanceBetweenCars + " Kms", lowerCarASpace + (lowerCarBSpace - lowerCarASpace) / 2, 340);
    }

    private void drawCar(Graphics g, int x, int y, Image carImage, String carName, int speed, String direction) {
        int scaledWidth = 160; // Set desired width for scaling
        int scaledHeight = (int) ((double) carImage.getHeight(null) / carImage.getWidth(null) * scaledWidth);
        Image scaledCarImage = carImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

        g.drawImage(scaledCarImage, x, y, null); // Draw the scaled image

        // Add labels on the same horizontal line but outside the car image
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 12)); // Set font to bold
        int labelY = y + scaledHeight + 15;
        g.drawString(carName + " (" + speed + " km/h)", x, labelY);
        g.drawString("Direction: " + direction, x, labelY + 15);
    }


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
		String filename = "D:/excel files/VLab_0304060402_108_1_Assign28_Bhushan.xlsx";     //Location where excel file is getting generated
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
	
		sheet1.setColumnWidth(6, 49*256+200);
	 	//Adding header to the second sheet
		for(int head=0; head<header.length; head++) {
			rowhead.createCell(head).setCellValue(header[head]);
			
		}
		
		   
		int mapsize,mapsizeafter;
		HashMap<String, Integer> map = new HashMap<String, Integer> ();
		VLab_0304060402_108_1_Assign28_Bhushan my_img=new VLab_0304060402_108_1_Assign28_Bhushan();
		for(int i =1;i<201;i++)
		{
			// Create row
			System.out.println(i);
			XSSFRow row = sheet1.createRow(i);
			row.createCell(0).setCellValue(i); 
			row.createCell(1).setCellValue("Text"); 
			row.createCell(2).setCellValue(1);
			row.createCell(3).setCellValue("0304060402");

			
			
			
            
			int speedA=(int)(Math.random()*40+5); 
			int speedB=(int)(Math.random()*26+5); 
			int timeT=(int)(Math.random()*8+2); 
			int distanceB=speedA*timeT-speedB*timeT;

			while(speedA<speedB || distanceB<(speedA+speedB+5) || distanceB!=speedA*timeT-speedB*timeT){
				speedA=(int)(Math.random()*40+5); 
				speedB=(int)(Math.random()*26+5); 
				timeT=(int)(Math.random()*8+2); 
				distanceB=speedA*timeT-speedB*timeT;
			}
			int betDis=distanceB-(speedA+speedB);
			int gcd2=gcd(distanceB, timeT);

			String Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Que,Que1,Sol,Sol1;
			
			Que="The distance between two places $A$ and $B$ is $"+distanceB+"$ kilometers. First car starts from $A$ and the second car from $B$. If they travel in the same direction, they will meet each other after $"+timeT+"$ hours. If they travel towards each other, then after $1$ hour the distance between both of them is $"+betDis+"$ km without crossing each other. Then find their respective speeds<br>";
			Que1="# $A$ आणि $B$ या ठिकाणांमधील अंतर $"+distanceB+"$ किमी आहे. पहिली मोटार गाडी $A$ पासून तर दुसरी मोटर गाडी $B$ पासून निघाली. जर दोन्ही गाड्या एकाच दिशेने प्रवास करीत असतील तर त्या एकमेकांना $"+timeT+"$ तासांनी भेटतात. परंतु जर त्या एकमेकींच्या दिशेने प्रवास करीत असतील तर $1$ तासाने त्यांच्यातील अंतर एकमेकींना न ओलांडता $"+betDis+"$ किमी असते. तर त्या दोन्ही मोटार गाड्यांचा अनुक्रमे ताशी वेग किती? <br>";

			// Sol="Ans: First car $"+speedA+"$ km/hr and second car $"+speedB+"$ km/hr. <br> Let the speed of the car starting from $A$ be $p$ km/hr. and that of starting from $B$ be $q$ km/hr. <br>(Refer the given figure.) <br> From the given data we get two equations as<br> $"+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"p="+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"q+"+(distanceB/gcd2)+" \\Rightarrow "+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"p-"+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"q="+(distanceB/gcd2)+". . . . (i)$, and $p+q+"+betDis+"="+distanceB+" \\Rightarrow p+q="+(distanceB-betDis)+". . . (ii)$ <br> From $(i)$ , by substituting of $"+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"p="+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"q+"+(distanceB/gcd2)+"$ in $(ii)$, we get $q="+speedB+"$ km/hr.<br> By substituting this value of $q$ in $(i)$, we get $p="+speedA+"$ km/hr. <br> $\\therefore$ their respective speed are $"+speedA+"$ km/hr and $"+speedB+"$ km/hr. <br>";
			// Sol1="#उत्तर: $"+speedA+"$ किमी/तास आणि $"+speedB+"$ किमी/तास. <br> # $A$ पासून निघणाऱ्या मोटार गाडीचा वेग $p$ किमी/तास आणि $B$ पासून निघणाऱ्या मोटार गाडीचा वेग $q$ किमी/तास मानू. <br> दिलेल्या माहितीनुसार आपल्याला खाली प्रमाणे दोन समिकरणे मिळतायत ती अशी<br> $"+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"p="+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"q+"+(distanceB/gcd2)+" \\Rightarrow "+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"p-"+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"q="+(distanceB/gcd2)+". . . . (i)$, and $p+q+"+betDis+"="+distanceB+" \\Rightarrow p+q="+(distanceB-betDis)+". . . (ii)$<br>आता $(i)$ वरून $p$ ची किंमत, $"+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"p="+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"q+"+(distanceB/gcd2)+"$ ही समिकरण $(ii)$ मध्ये ठेऊन आपल्याला  $q="+speedB+"$ किमी/तास मिळते <br>आता $q$ ची ही किंमत पुन्हा समिकरण $(i)$, मध्ये ठेऊन आपलयाला $p="+speedA+"$ असे मिळते. <br> $\\therefore$ त्या दोन्ही गाड्यांचा अनुक्रमे वेग  $"+speedA+"$ किमी/तास आणि $"+speedB+"$  किमी/तास हे उत्तर. <br>";
			
            Sol="Ans: First car $"+speedA+"$ km/hr and second car $"+speedB+"$ km/hr. <br> Let the speed of the car starting from $A$ be $p$ km/hr and that of starting from $B$ be $q$ km/hr. <br>(Refer the given figure.) <br>From the first condition, that, they are travelling in the same direction, both cars meet each other after $"+timeT+"$ hours. <br> Car starting from point $A$, has travelled extra distance of $"+distanceB+"$ km as compared to other car starting from pount $B$, as can be seen from the figure. <br> $\\therefore$ We can write an equation as $"+(timeT ==1 ?"":timeT )+"p="+(timeT ==1 ?"":timeT)+"q+"+(distanceB)+"$ <br> This equation can be simplified and rewritten as, <br> $"+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"p-"+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"q="+(distanceB/gcd2)+" . . . . (i)$, and <br>According to the second condition, after traveling towards each other for $1$ hour without meeting, they are still $"+betDis+"$ km apart. (Refer to lower picture in the figure) <br> From this, we can write another equation as $p+q+"+betDis+"="+distanceB+"$ <br> By simplifying this equation we get, <br> $p+q="+(distanceB-betDis)+" . . . . (ii)$ <br>We will find out the value of $p$ from equation $(i)$ as, $"+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"p="+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"q+"+(distanceB/gcd2)+"$ <br> By substituting this value of $p$ in equation $(ii)$ we get, <br> $("+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"q+"+(distanceB/gcd2)+")+q="+(distanceB-betDis)+"$ <br> $\\therefore q="+speedB+"$ km/hr speed of first car. <br> By substituting this value of $q$ in $(i)$ we get, <br> $p="+speedA+"$ km/hr, speed of second car. <br> $\\therefore$ Speed of first car is $"+speedA+"$ km/hr and speed of second car is $"+speedB+"$ km/hr is the answer. <br>";
			Sol1="#उत्तर : पहिली मोटार गाडी $"+speedA+"$ किमी/तास आणि दुसरी मोटार गाडी $"+speedB+"$ किमी/तास. <br> $A$ पासून निघणाऱ्या पहिल्या मोटार गाडीचा वेग $p$ किमी/तास आणि $B$ पासून निघणाऱ्या दुसऱ्या मोटार गाडीचा वेग $q$ किमी/तास मानू. <br> (सोबतची आकृती पहा.)<br> पहिल्या अटी नुसार एकाच दिशेने निघलेल्या दोन्ही गाड्या $"+timeT+"$ तासांनी एकमेकींना जेव्हा भेटतात, तेव्हा $A$ पासून निघणाऱ्या दुसऱ्या मोटार गाडीने पहिल्या मोटार गाडी पेक्षा $"+distanceB+"$ किमी अंतर जास्तीचा प्रवास केलेला आहे. <br> या वरून आपण $"+(timeT ==1 ?"":timeT )+"p="+(timeT ==1 ?"":timeT)+"q+"+(distanceB)+"$ असे समीकरण लिहू शकतो.<br> सरळ रूप देऊन आपण हे समीकरण <br> $"+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"p-"+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"q="+(distanceB/gcd2)+" . . . . (i)$, असे लिहू शकतो आणि <br> दुसऱ्या अटी नुसार दोन्ही गाड्या एकमेकींच्या दिशेने निघाल्या असता, दोन्ही गाड्या $1$ तासाने एकमेकींना न ओलांडता एकमेकी पासून $"+betDis+"$ किमी दूर असतात. (आकृती मधील खालचे चित्र पहा) <br> $\\therefore p+q+"+betDis+"="+distanceB+"$ आपण असे समीकरण लिहू शकतो. <br> सरळ रूप देऊन आपल्याला हे समीकरण <br> $p+q="+(distanceB-betDis)+" . . . . (ii)$ असे मिळते. <br> समीकरण  $(i)$ वरून आपल्याला $"+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"p="+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"q+"+(distanceB/gcd2)+"$ असे मिळते. <br> $p$ ची ही किंमत समीकरण  $(ii)$ मध्ये ठेवून, <br> $("+(timeT/gcd2 ==1 ?"":timeT/gcd2)+"q+"+(distanceB/gcd2)+")+q="+(distanceB-betDis)+"$ असे मिळते. <br> $\\therefore q="+speedB+"$ किमी/तास दुसऱ्या गाडीचा वेग, <br> आता $q$ ची ही किंमत समीकरण  $(i)$ मध्ये ठेवून, <br> $p="+speedA+"$ किमी/तास असा पहिल्या गाडीचा वेग मिळतो. <br> $\\therefore$ पहिल्या गाडीचा वेग $"+speedA+"$ किमी/तास आणि दुसऱ्या गाडीचा वेग $"+speedB+"$ किमी/तास हे उत्तर. <br>";

			String Solution = ""+Sol+" "+Sol1+"";
			String Question =""+Que+" "+Que1+"";
			
			Correct_ans="$"+speedA+"$ km/hr and $"+speedB+"$ km/hr. <br> # $"+speedA+"$ किमी/तास आणि $"+speedB+"$ किमी/तास. <br>";
			wrong_ans="$"+(speedA+4)+"$ km/hr and $"+speedB+"$ km/hr. <br> # $"+(speedA+4)+"$ किमी/तास आणि $"+speedB+"$ किमी/तास. <br>";
			
			wrong_ans1="$"+speedA+"$ km/hr and $"+(speedB+3)+"$ km/hr. <br> # $"+speedA+"$ किमी/तास आणि $"+(speedB+3)+"$ किमी/तास. <br>";

			wrong_ans2="$"+(speedA+1)+"$ km/hr and $"+(speedB+1)+"$ km/hr. <br> # $"+(speedA+1)+"$ किमी/तास आणि $"+(speedB+1)+"$ किमी/तास. <br>";

			row.createCell(4).setCellValue(Question);
			row.createCell(5).setCellValue(Correct_ans);
			//				 row.createCell(6).setCellValue(" ");
			//				 row.createCell(7).setCellValue(" ");
			//				 row.createCell(8).setCellValue(" ");
			row.createCell(9).setCellValue(wrong_ans);
			row.createCell(10).setCellValue(wrong_ans1);
			row.createCell(11).setCellValue(wrong_ans2);
			row.createCell(12).setCellValue(360);
			row.createCell(13).setCellValue(4);
			//				  row.createCell(14).setCellValue(" ");
			row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			//Generate Solution
								
			row.createCell(16).setCellValue(Solution);
		
			row.createCell(18).setCellValue(108);

			String imagePath = "C:\\Users\\bhush\\Downloads\\Assign28_Images\\Solution"+i+".png";
			row.createCell(17).setCellValue(imagePath);
//  Making Solution image 
			my_img.draw_sol_img(speedA,speedB,distanceB,1,betDis,imagePath);
					
			insertImageIntoExcel(sheet1, imagePath, i, 6,workbook);

			// System.out.println("Question " + i + ": A=" + speedA + " B="+speedB+" C="+timeT+" Dis="+distanceB+" BetDis="+betDis+"");				

			String Checker =""+speedA+""+speedB+""+timeT+""+distanceB+""+betDis+"";
			mapsize = map.size();
			map.put(Checker,i);
			mapsizeafter = map.size();
							
			//In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
			if(mapsize == mapsizeafter) {
				// System.out.println("----------------------------------------");
				// System.out.println(Checker);
				// System.out.println("----------------------------------------");

				i--;
			}
            if(speedB+speedA+betDis!=distanceB && speedA*timeT!=speedB*timeT+distanceB){
                i--;
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