import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class LineGraphImage {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int SCALE = 40; // pixels per unit

    public static void main(String[] args) {
        double m = 1; // slope
        double b = 0; // y-intercept

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Set the background color
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        // Draw grid and axes 
        drawGridAndAxes(g2d);

        // Draw the line
        g2d.setColor(Color.RED);
        drawLineEquation(g2d, m, b);

        // Save the image
        try {
            ImageIO.write(image, "png", new File("line_graph.png"));
            System.out.println("Image saved as line_graph.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display the image in a JFrame
        JFrame frame = new JFrame("Line Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(new JLabel(new ImageIcon(image)));
        frame.setVisible(true);

        g2d.dispose();
    }

    private static void drawGridAndAxes(Graphics2D g2d) {
        // Draw grid lines and labels
        g2d.setColor(Color.LIGHT_GRAY);
        for (int i = -10; i <= 10; i++) {
            int x = i * SCALE + WIDTH / 2;
            int y = i * SCALE + HEIGHT / 2;
            g2d.drawLine(x, 0, x, HEIGHT); // vertical grid lines
            g2d.drawLine(0, y, WIDTH, y); // horizontal grid lines
        }

        // Draw axes
        g2d.setColor(Color.BLACK);
        g2d.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT); // y-axis
        g2d.drawLine(0, HEIGHT / 2, WIDTH, HEIGHT / 2); // x-axis

        // Draw labels
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        for (int i = -10; i <= 10; i++) {
            if (i != 0) { // Skip the origin
                int x = i * SCALE + WIDTH / 2;
                int y = HEIGHT / 2 - i * SCALE;
                g2d.drawString(String.valueOf(i), x, HEIGHT / 2 + 15); // x-axis labels
                g2d.drawString(String.valueOf(i), WIDTH / 2 + 5, y); // y-axis labels
            }
        }
    }

    private static void drawLineEquation(Graphics2D g2d, double m, double b) {
        // Convert coordinates to pixels
        int x1 = -10;
        int y1 = (int) (m * x1 + b);
        int x2 = 10;
        int y2 = (int) (m * x2 + b);

        // Transform to screen coordinates
        int x1Screen = x1 * SCALE + WIDTH / 2;
        int y1Screen = HEIGHT / 2 - y1 * SCALE;
        int x2Screen = x2 * SCALE + WIDTH / 2;
        int y2Screen = HEIGHT / 2 - y2 * SCALE;

        // Draw the line
        g2d.drawLine(x1Screen, y1Screen, x2Screen, y2Screen);
    }
}


// import javax.swing.*;
// import java.awt.*;
// import java.util.Random;

// public class IntersectingLines extends JPanel {
//     private int A1, B1, C1;
//     private int A2, B2, C2;
//     private int xIntersect, yIntersect;

//     public IntersectingLines() {
//         Random random = new Random();

//         // Generate a random intersection point within the range -10 to 10
//         xIntersect = random.nextInt(21) - 10; // Intersection x-coordinate between -10 and 10
//         yIntersect = random.nextInt(21) - 10; // Intersection y-coordinate between -10 and 10

//         // Generate coefficients for the first line (A1, B1, C1)
//         do {
//             A1 = random.nextInt(21) - 10; // Coefficient A1 between -10 and 10
//             B1 = random.nextInt(21) - 10; // Coefficient B1 between -10 and 10
//         } while (A1 == 0 && B1 == 0); // Ensure A1 and B1 are not both zero

//         // Calculate C1 such that (xIntersect, yIntersect) is a solution
//         C1 = A1 * xIntersect + B1 * yIntersect;

//         // Generate coefficients for the second line (A2, B2, C2)
//         do {
//             A2 = random.nextInt(21) - 10; // Coefficient A2 between -10 and 10
//             B2 = random.nextInt(21) - 10; // Coefficient B2 between -10 and 10
//         } while ((A2 == 0 && B2 == 0) || (A1 * B2 == A2 * B1)); // Ensure lines are not parallel and A2, B2 are not both zero

//         // Calculate C2 such that (xIntersect, yIntersect) is also a solution for the second line
//         C2 = A2 * xIntersect + B2 * yIntersect;

//         // Display the line equations and intersection point
//         System.out.println("Generated line equation 1: " + A1 + "x + " + B1 + "y = " + C1);
//         System.out.println("Generated line equation 2: " + A2 + "x + " + B2 + "y = " + C2);
//         System.out.println("Intersection point: (" + xIntersect + ", " + yIntersect + ")");
//     }

//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         g.setColor(Color.BLACK);

//         // Transform coordinates to fit within the panel
//         int width = getWidth();
//         int height = getHeight();
//         int originX = width / 2;
//         int originY = height / 2;

//         // Draw axes
//         g.drawLine(0, originY, width, originY);
//         g.drawLine(originX, 0, originX, height);

//         // Draw the first line
//         drawLine(g, A1, B1, C1, width, height);

//         // Draw the second line
//         drawLine(g, A2, B2, C2, width, height);

//         // Draw the intersection point
//         g.setColor(Color.RED);
//         g.fillOval(originX + xIntersect * 20 - 5, originY - yIntersect * 20 - 5, 10, 10);
//     }

//     private void drawLine(Graphics g, int A, int B, int C, int width, int height) {
//         int originX = width / 2;
//         int originY = height / 2;

//         // Calculate points for the line
//         if (B != 0) {
//             int y1 = (C - A * -10) / B;
//             int y2 = (C - A * 10) / B;
//             g.drawLine(originX - 10 * 20, originY - y1 * 20, originX + 10 * 20, originY - y2 * 20);
//         } else {
//             int x = C / A;
//             g.drawLine(originX + x * 20, 0, originX + x * 20, height);
//         }
//     }

//     public static void main(String[] args) {
//         JFrame frame = new JFrame();
//         IntersectingLines panel = new IntersectingLines();
//         frame.add(panel);
//         frame.setSize(800, 800);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);
//     }
// }
