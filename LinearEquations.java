// import java.util.Random;

// public class LinearEquations {
//     public static void main(String[] args) {
//         Random random = new Random();
//         int numberOfEquations = 200;

//         for (int i = 1; i <= numberOfEquations; i++) {
//             int m1 = random.nextInt(11) - 5; // Slope of first line between -5 and 5
//             int c1 = random.nextInt(21) - 10; // Intercept of first line between -10 and 10
//             int m2 = random.nextInt(11) - 5; // Slope of second line between -5 and 5
//             int c2 = random.nextInt(21) - 10; // Intercept of second line between -10 and 10

//             System.out.println("Equation " + (i * 2 - 1) + ": y = " + m1 + "x + " + c1);
//             System.out.println("Points on this line:");
//             for (int x = -2; x <= 1; x++) {
//                 int y = m1 * x + c1;
//                 System.out.println("(" + x + ", " + y + ")");
//             }

//             System.out.println("\nEquation " + (i * 2) + ": y = " + m2 + "x + " + c2);
//             System.out.println("Points on this line:");
//             for (int x = -2; x <= 1; x++) {
//                 int y = m2 * x + c2;
//                 System.out.println("(" + x + ", " + y + ")");
//             }

//             System.out.println();
//         }
//     }
// }


// import java.util.HashSet;
// import java.util.Random;

// public class LinearEquations {
//     public static void main(String[] args) {
//         Random random = new Random();
//         int numberOfEquations = 500;
//         HashSet<String> uniqueEquations = new HashSet<>();

//         for (int i = 1; i <= numberOfEquations; i++) {
//             int m1, c1, m2, c2;

//             do {
//                 m1 = random.nextInt(21) - 10; // Slope of first line between -5 and 5
//                 c1 = random.nextInt(21) - 10; // Intercept of first line between -10 and 10
//             } while (!uniqueEquations.add(m1 + "," + c1));

//             do {
//                 m2 = random.nextInt(21) - 10; // Slope of second line between -5 and 5
//                 c2 = random.nextInt(21) - 10; // Intercept of second line between -10 and 10
//             } while (!uniqueEquations.add(m2 + "," + c2));

//             System.out.println("Equation " + (i * 2 - 1) + ": y = " + m1 + "x + " + c1);
//             System.out.println("Points on this line:");
//             for (int x = -2; x <= 1; x++) {
//                 int y = m1 * x + c1;
//                 System.out.println("(" + x + ", " + y + ")");
//             }

//             System.out.println("\nEquation " + (i * 2) + ": y = " + m2 + "x + " + c2);
//             System.out.println("Points on this line:");
//             for (int x = -2; x <= 1; x++) {
//                 int y = m2 * x + c2;
//                 System.out.println("(" + x + ", " + y + ")");
//             }

//             System.out.println();
//         }
//     }
// }



// GPT want coefficient to y also. Bhushan Chrome
// https://chatgpt.com/share/676af8f9-b298-8002-aff0-41ee161e52c4




import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class LinearEquations {
    public static void main(String[] args) {
        Random random = new Random();
        int numberOfEquations = 200;
        HashSet<String> uniquePairEquations = new HashSet<>();

        for (int i = 1; i <= numberOfEquations; i++) {
            int m1, c1, m2, c2;
            String pair,reversePair;
            ArrayList<String> quearr = new ArrayList<String>();
            ArrayList<String> quearr2 = new ArrayList<String>();
            String line1="",line2="";
					

            do {
                m1 = random.nextInt(11) - 5; // Slope of first line between -5 and 5
                c1 = random.nextInt(21) - 10; // Intercept of first line between -10 and 10
                m2 = random.nextInt(11) - 5; // Slope of second line between -5 and 5
                c2 = random.nextInt(21) - 10; // Intercept of second line between -10 and 10
                pair = m1 + "," + c1 + ";" + m2 + "," + c2;
                reversePair = m2 + "," + c2 + ";" + m1 + "," + c1;
            } while ((!uniquePairEquations.add(pair) && !uniquePairEquations.add(reversePair))||(m1==m2 || c1==c2)||m1==0||m2==0||c1==0||c2==0);

            System.out.println("Equation " + (i * 2 - 1) + ": y = " + m1 + "x + " + c1);
            System.out.println("Points on this line:");
            for (int x = -5; x <= 5; x++) {
                int y = m1 * x + c1;
                if(y>=-10 && y<=10){
                    quearr.add("(" + x + ", " + y + ")");
                }
                System.out.println("(" + x + ", " + y + ")");
            }
            System.out.println(quearr);


            System.out.println("\nEquation " + (i * 2) + ": y = " + m2 + "x + " + c2);
            System.out.println("Points on this line:");
            for (int x = -5; x <= 5; x++) {
                int y = m2 * x + c2;
                if(y>=-10 && y<=10){
                    quearr2.add("(" + x + ", " + y + ")");
                }
                System.out.println("(" + x + ", " + y + ")");

            }
            System.out.println(quearr2);

            if(m1==Math.abs(m1) && c1==Math.abs(c1)){
                
                line1=""+(m1==Math.abs(m1) ? (m1==1 ? "-":"-"+m1):(m1==-1 ? "":Math.abs(m1)))+"x+y="+c1+"";

            }
            else if(m1==Math.abs(m1) && c1!=Math.abs(c1)){
               
                line1=""+(m1==Math.abs(m1) ? (m1==1 ? "":m1):(m1==-1 ? "-":m1))+"x-y="+Math.abs(c1)+"";

            }
            else if(m1!=Math.abs(m1) && c1==Math.abs(c1)){
                
                line1=""+(m1==Math.abs(m1) ? (m1==1 ? "-":"-"+m1):(m1==-1 ? "":Math.abs(m1)))+"x+y="+c1+"";

            }
            else if(m1!=Math.abs(m1) && c1!=Math.abs(c1)){
                
                line1=""+(m1==Math.abs(m1) ? (m1==1 ? "-":"-"+m1):(m1==-1 ? "":Math.abs(m1)))+"x+y="+c1+"";

            }


            if(m2==Math.abs(m2) && c2==Math.abs(c2)){
                
                line2=""+(m2==Math.abs(m2) ? (m2==1 ? "-":"-"+m2):(m2==-1 ? "":Math.abs(m2)))+"x+y="+c2+"";

            }
            else if(m2==Math.abs(m2) && c2!=Math.abs(c2)){
               
                line2=""+(m2==Math.abs(m2) ? (m2==1 ? "":m2):(m2==-1 ? "-":m2))+"x-y="+Math.abs(c2)+"";

            }
            else if(m2!=Math.abs(m2) && c2==Math.abs(c2)){
                
                line2=""+(m2==Math.abs(m2) ? (m2==1 ? "-":"-"+m2):(m2==-1 ? "":Math.abs(m2)))+"x+y="+c2+"";


            }
            else if(m2!=Math.abs(m2) && c2!=Math.abs(c2)){
                
                line2=""+(m2==Math.abs(m2) ? (m2==1 ? "-":"-"+m2):(m2==-1 ? "":Math.abs(m2)))+"x+y="+c2+"";

            }

            // line1=""+(m1==Math.abs(m1) ? (m1==1 ? "-":"-"+m1):(m1==-1 ? "":Math.abs(m1)))+"x+y="+c1+"";
			// line2=""+(k2==Math.abs(k2) ? (k2==1 ? "":k2):(k2==-1 ? "-":k2))+"x"+(l2==Math.abs(l2) ? (l2==1 ? "-":"-"+l2):(l2==-1 ? "+":"+"+(Math.abs(l2))))+"y="+m2+"";
            System.out.println("Line 1: "+line1+"   Line 2:"+line2);
            System.out.println();
            if(quearr.size()<4 ||quearr2.size()<4){
                i--;
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}
