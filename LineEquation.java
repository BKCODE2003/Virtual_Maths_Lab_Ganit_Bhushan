import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LineEquation {

    public static void main(String[] args) {
        Random random = new Random();
        Set<String> uniqueLines = new HashSet<>();
        
        int x1, y1, x2, y2;
        int a, b, c;
        
        for (int i = -8; i <= 8; i++) {
            for (int j = -8; j <= 8; j++) {
                for (int k = -8; k <= 8; k++) {
                    for (int l = -8; l <= 8; l++) {
                        x1 = i;
                        y1 = j;
                        x2 = k;
                        y2 = l;

                        if (x1 != x2 || y1 != y2) {
                            a = y2 - y1;
                            b = x1 - x2;
                            c = a * x1 + b * y1;

                            if (a >= -10 && a <= 10 && b >= -10 && b <= 10 && c >= -10 && c <= 10) {
                                String lineEquation = a + "x + " + b + "y = " + c;
                                uniqueLines.add(lineEquation);
                                System.out.println(lineEquation);
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Generated " + uniqueLines.size() + " unique lines:");
    }
}
