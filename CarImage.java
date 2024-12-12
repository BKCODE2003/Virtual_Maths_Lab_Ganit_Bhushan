import java.awt.*;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class CarImage {

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

    // Constructor that accepts parameters
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

    public static void main(String[] args) {
        // Example usage with parameters
        CarImage carImage = new CarImage();
        carImage.draw_sol_img(60, 80, 80, 1, 30, "CarImage.png"); // Specify the path where you want to save the image
   
    }
}
