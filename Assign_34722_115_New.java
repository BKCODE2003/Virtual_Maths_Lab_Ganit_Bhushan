import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assign_34722_115_New {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Required No of Questions");
        int n = sc.nextInt();

        // declare file name to be create
        String filename = "D:/excel files/Vlab_0304070202_115_Assign28_Komal.xlsx";

        // creating an instance of HSSFWorkbook class
        XSSFWorkbook workbook = new XSSFWorkbook();

        // invoking creatSheet() method and passing the name of the sheet to be created
        XSSFSheet sheet = workbook.createSheet("Instruction");
        XSSFSheet sheet1 = workbook.createSheet("Question");

        // create header part
        String[] header = { "Sr. No", "Question Type", "Answer Type", "Topic Number", "Question (Text Only)",
                "Correct Answer 1", "Correct Answer 2", "Correct Answer 3", "Correct Answer 4", "Wrong Answer 1",
                "Wrong Answer 2", "Wrong Answer 3", "Time in seconds", "Difficulty Level",
                "Question (Image/ Audio/ Video)", "Contributor's Registered mailId", "Solution (Text Only)",
                "Solution (Image/ Audio/ Video)", "Variation Number" };

        XSSFRow rowhead = sheet1.createRow((short) 0);

        sheet1.setColumnWidth(4, 35 * 250);
        sheet1.setColumnWidth(16, 45 * 250);
        for (int head = 0; head < header.length; head++) {

            rowhead.createCell(head).setCellValue(header[head]);
        }

        int mapsize, mapsizeafter;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        XSSFRow row1 = sheet1.createRow((short) n);

        ArrayList<String> Q1 = new ArrayList<String>();
        ArrayList<String> Q = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {


            Random r = new Random();
            int min = 1;
            int max = 9;

            int a = (int) (Math.random() * (max - min + 1) + min);
            
            int min1 =10;
            int max1 =20;
            
            int b = (int) (Math.random() * (max1 - min1 + 1) + min1);
            
            int c = (int) (Math.random() * (max - min + 1) + min);
            int d = (int) (Math.random() * (max - min + 1) + min);

            int e = (int) (Math.random() * (max - min + 1) + min);
            int f = (int) (Math.random() * (max - min + 1) + min);
            int g = (int) (Math.random() * (max - min + 1) + min);

            int min2 = 2;
            int max2 = 5;

            int a1 = (int) (Math.random() * (max2 - min2 + 1) + min2);
            int a2 = (int) (Math.random() * (max2 - min2 + 1) + min2);
            int a3 = (int) (Math.random() * (max2 - min2 + 1) + min2);

            String array1[]=Var();
            String chrt1=array1[0];
            String chrt2=array1[1];

            int min3 = 0;
            int max3 = 1;
            int r1 = (int) (Math.random() * (max3 - min3 + 1) + min3);

            String w1 = "";
            String w2 = "";
            String w3 = "";
            String w4 = "";
            String w5 = "";
            String w6 = "";
            String w7 = "";

            String question = "";
            String solution = "";
            String cans = "";

//				Assign_34722_115 assign=new Assign_34722_115();
            int[] pairs =valuesTriplate();
            
            int t1=pairs[0];
            int t2=pairs[1];
            int t3=pairs[2];
            
            int mid=2*t1;
            int sqrt=t1*t1;
            int hsqrt=t3*t3;
            
            int sub=sqrt-hsqrt;
            int div1=mid/2;
            int div2=sub/2;
            int mul=t1*t2;
            int dmul=mul*2;
            int mid1=t1-t2;
            int pmid=(-1)*mid1;
            int dmid1=mid1*2;
            
            String mid11="";
            if(mid1==-1) {
                mid11="-"+chrt1+"";
            }else {
                mid11=""+mid1+""+chrt1+"";
            }
            
            if(r1==0) {
//	Question			

        question = " Base of a right angle triangle is $"+chrt1+"$.The altitude of a right triangle is $"+pmid+"$ cm less than its base. If the hypotenuse is $"+t3+"$ cm, find the other two sides using quadratic equation.<br >#"
                + "एका काटकोन त्रिकोणाचा पाया $"+chrt1+"$ आहे. त्याची उंची पायापेक्षा $"+pmid+"$ सेंमी ने  कमी आहे. जर त्या त्रिकोणाचा कर्ण $"+t3+"$ असेल तर त्या त्रिकोणाच्या बाकीच्या दोन बाजू वर्ग समीकरण पद्धत वापरून शोधा  <br>";
//Correct Answer
            cans = "$"+t2+"$ cm and $"+t1+"$ cm<br>"
                    +"#$"+t2+"$ सेंमी आणि $"+t1+"$ सेंमी <br>";
//		String cans2 ="";

int wr4=t2+1;
int wr5=t1+1;
//	Wrong Options	
            w1 = "$-"+t2+"$ cm and $"+t1+"$ cm<br>"
                    +"#$-"+t2+"$ सेंमी आणि $"+t1+"$ सेंमी <br>";
            
            w2 = "$"+t2+"$ cm and $-"+t1+"$ cm<br>"
                +"#$"+t2+"$ सेंमी आणि $-"+t1+"$ सेंमी <br>";
            
            w3 ="$-"+t2+"$ cm and $-"+t1+"$ cm<br>"
                +"#$-"+t2+"$ सेंमी आणि $-"+t1+"$ सेंमी <br>";
            
            w4 ="$"+wr4+"$ cm and $"+t1+"$ cm<br>"
                +"#$"+wr4+"$ सेंमी आणि $"+t1+"$ सेंमी <br>";
            
            w5 = "$"+t2+"$ cm and $"+wr5+"$ cm<br>"
                +"#$"+t2+"$ सेंमी आणि $"+wr5+"$ सेंमी <br>";
            
//				w6="";
//				w7="";
            int sol1=t2+mid1;
            
            
// Solution
            solution ="Ans : $"+t2+"$ cm and $"+t1+"$ cm<br >"
                    + "Let the base of the right angled triangle be $"+chrt1+"$ cm.<br>"
                    + "$\\therefore$ Altitude is $"+chrt1+" "+mid1+"$ cm<br>"
                    + "And hypotenuse is given as $"+t3+"$ cm<br>"
                    + "$\\therefore "+chrt1+"^2+("+chrt1+" "+mid1+")^2={"+t3+"}^2$ . . . .  by Pythagoras theorem<br>"
                    + "$\\therefore 2"+chrt1+"^2 "+dmid1+""+chrt1+"-"+dmul+"=0$<br>"
                    + "$\\therefore "+chrt1+"^2 "+mid11+"-"+mul+"=0$<br>"
                    + "$\\therefore "+chrt1+"^2 -"+t2+""+chrt1+"+"+t1+""+chrt1+"-"+mul+"=0$<br>"
                    + "$\\therefore "+chrt1+"("+chrt1+"-"+t2+")+"+t1+"("+chrt1+"-"+t2+")=0$<br>"
                    + "$\\therefore ("+chrt1+"-"+t2+")("+chrt1+"+"+t1+")=0$<br>"
                    + "$\\therefore "+chrt1+"-"+t2+"=0$ or $"+chrt1+"+"+t1+"=0$<br>"
                    + "$\\therefore "+chrt1+"="+t2+"$ or $"+chrt1+"=-"+t1+"$<br>"
                    + "But $"+chrt1+"=-"+t1+"$ is not possible (being length of side of a triangle)<br>"
                    + "$\\therefore "+chrt1+"="+t2+"$ cm is one side and<br>"
                    + "Other side $="+chrt1+""+mid1+" = "+t2+""+mid1+"="+sol1+"$ cm<br>"
                    + "$\\therefore$ two sides of the triangle are $"+t2+"$ cm and $"+t1+"$ cm is the answer<br>"
                    
                    + "#उत्तर :$"+t2+"$ सेंमी आणि $"+t1+"$ सेंमी <br> "
                    + "काटकोन त्रिकोणाचा पाय  $"+chrt1+"$ सेंमी मानू .<br>"
                    + "$\\therefore$ उंची  $"+chrt1+" "+mid1+"$ सेंमी आहे <br>"
                    + "आणि कर्ण $"+t3+"$ सेंमी दिलेला आहे <br>"
                    + "$\\therefore "+chrt1+"^2+("+chrt1+" "+mid1+")^2={"+t3+"}^2$ . . . .  पायथागोरसच्या प्रमेया नुसार"
                            + "<br>"
                    + "$\\therefore 2"+chrt1+"^2 "+dmid1+""+chrt1+"-"+dmul+"=0$<br>"
                    + "$\\therefore "+chrt1+"^2 "+mid11+"-"+mul+"=0$<br>"
                    + "$\\therefore "+chrt1+"^2 -"+t2+""+chrt1+"+"+t1+""+chrt1+"-"+mul+"=0$<br>"
                    + "$\\therefore "+chrt1+"("+chrt1+"-"+t2+")+"+t1+"("+chrt1+"-"+t2+")=0$<br>"
                    + "$\\therefore ("+chrt1+"-"+t2+")("+chrt1+"+"+t1+")=0$<br>"
                    + "$\\therefore "+chrt1+"-"+t2+"=0$ किंवा  $"+chrt1+"+"+t1+"=0$<br>"
                    + "$\\therefore "+chrt1+"="+t2+"$ किंवा  $"+chrt1+"=-"+t1+"$<br>"
                    + "परंतु $"+chrt1+"=-"+t1+"$ हे शक्य नाही (कारण ती त्रिकोणाच्या बाजूची लांबी आहे)<br>"
                    + "$\\therefore "+chrt1+"="+t2+"$  सेंमी ही एक बाजू आहे <br>"
                    + "दुसरी बाजू $="+chrt1+""+mid1+" = "+t2+""+mid1+"="+sol1+"$ सेंमी <br>"
                    + "उरलेल्या दोन बाजू ह्या $"+t2+"$ सेंमी आणि $"+t1+"$ सेंमी आहेत हे उत्तर. <br>";
            }
            else if(r1==1) {
//					Question			

                question = "Base of a right angle triangle is $"+chrt1+"$.The altitude of a right triangle is $"+pmid+"$ cm more than its base. If the hypotenuse is $"+t3+"$ cm, find the other two sides using quadratic equation.<br >#"
                        + "एका काटकोन त्रिकोणाचा पाया $"+chrt1+"$ आहे. त्याची उंची पायापेक्षा $"+pmid+"$ सेंमी ने  जास्त  आहे. जर त्या त्रिकोणाचा कर्ण $"+t3+"$ असेल तर त्या त्रिकोणाच्या बाकीच्या दोन बाजू वर्ग समीकरण पद्धत वापरून शोधा  <br>";
    //Correct Answer
                    cans = "$"+t1+"$ cm and $"+t2+"$ cm<br>"
                            +"#$"+t1+"$ सेंमी आणि $"+t2+"$ सेंमी <br>";
//				String cans2 ="";

        int wr4=t2+1;
        int wr5=t1+1;
//			Wrong Options	
                    w1 = "$-"+t1+"$ cm and $"+t2+"$ cm<br>"
                            +"#$-"+t1+"$ सेंमी आणि $"+t2+"$ सेंमी <br>";
                    
                    w2 = "$"+t1+"$ cm and $-"+t2+"$ cm<br>"
                        +"#$"+t1+"$ सेंमी आणि $-"+t2+"$ सेंमी <br>";
                    
                    w3 ="$-"+t1+"$ cm and $-"+t2+"$ cm<br>"
                        +"#$-"+t1+"$ सेंमी आणि $-"+t2+"$ सेंमी <br>";
                    
                    w4 ="$"+wr5+"$ cm and $"+t2+"$ cm<br>"
                        +"#$"+wr5+"$ सेंमी आणि $"+t2+"$ सेंमी <br>";
                    
                    w5 = "$"+t1+"$ cm and $"+wr4+"$ cm<br>"
                        +"#$"+t1+"$ सेंमी आणि $"+wr4+"$ सेंमी <br>";
                    
//						w6="";
//						w7="";
                    int sol1=t2+mid1;
                    int pmid1=(-1)*mid1;
                    int sum=t1+pmid1;
                    int pdmid1=(-1)*dmid1;
//						int pmid1=(-1)*mid1;
                    
                    String mid12="";
                    if(mid1==-1) {
                        mid11=""+chrt1+"";
                    }else {
                        mid11=""+pmid+""+chrt1+"";
                    }
                    
    // Solution
                    solution ="Ans : $"+t1+"$ cm and $"+t2+"$ cm<br >"
                            + "Let the base of the right angled triangle be $"+chrt1+"$ cm.<br>"
                            + "$\\therefore$ Altitude is $"+chrt1+"+"+pmid1+"$ cm<br>"
                            + "And hypotenuse is given as $"+t3+"$ cm<br>"
                            + "$\\therefore "+chrt1+"^2+("+chrt1+"+ "+pmid1+")^2={"+t3+"}^2$ . . . .  by Pythagoras theorem<br>"
                            + "$\\therefore 2"+chrt1+"^2 +"+pdmid1+""+chrt1+"-"+dmul+"=0$<br>"
                            + "$\\therefore "+chrt1+"^2 +"+mid11+"-"+mul+"=0$<br>"
                            + "$\\therefore "+chrt1+"^2 +"+t2+""+chrt1+"-"+t1+""+chrt1+"-"+mul+"=0$<br>"
                            + "$\\therefore "+chrt1+"("+chrt1+"+"+t2+")-"+t1+"("+chrt1+"+"+t2+")=0$<br>"
                            + "$\\therefore ("+chrt1+"+"+t2+")("+chrt1+"-"+t1+")=0$<br>"
                            + "$\\therefore "+chrt1+"+"+t2+"=0$ or $"+chrt1+"-"+t1+"=0$<br>"
                            + "$\\therefore "+chrt1+"=-"+t2+"$ or $"+chrt1+"="+t1+"$<br>"
                            + "But $"+chrt1+"=-"+t2+"$ is not possible (being length of side of a triangle)<br>"
                            + "$\\therefore "+chrt1+"="+t1+"$ cm is one side and<br>"
                            + "Other side $="+chrt1+"+"+pmid1+" = "+t1+"+"+pmid1+"="+sum+"$ cm<br>"
                            + "$\\therefore$ two sides of the triangle are $"+t1+"$ cm and $"+t2+"$ cm is the answer<br>"
                            
                            + "#उत्तर :$"+t1+"$ सेंमी आणि $"+t2+"$ सेंमी <br> "
                            + "काटकोन त्रिकोणाचा पाय  $"+chrt1+"$ सेंमी मानू .<br>"
                            + "$\\therefore$ उंची  $"+chrt1+"+"+pmid1+"$ सेंमी आहे <br>"
                            + "आणि कर्ण $"+t3+"$ सेंमी दिलेला आहे <br>"
                            + "$\\therefore "+chrt1+"^2+("+chrt1+" +"+pmid1+")^2={"+t3+"}^2$ . . . .  पायथागोरसच्या प्रमेया नुसार<br>"
                            + "$\\therefore 2"+chrt1+"^2 +"+pdmid1+""+chrt1+"-"+dmul+"=0$<br>"
                            + "$\\therefore "+chrt1+"^2 +"+mid11+"-"+mul+"=0$<br>"
                            + "$\\therefore "+chrt1+"^2 +"+t2+""+chrt1+"-"+t1+""+chrt1+"-"+mul+"=0$<br>"
                            + "$\\therefore "+chrt1+"("+chrt1+"+"+t2+")-"+t1+"("+chrt1+"+"+t2+")=0$<br>"
                            + "$\\therefore ("+chrt1+"+"+t2+")("+chrt1+"-"+t1+")=0$<br>"
                            + "$\\therefore "+chrt1+"+"+t2+"=0$ किंवा  $"+chrt1+"-"+t1+"=0$<br>"
                            + "$\\therefore "+chrt1+"=-"+t2+"$ किंवा  $"+chrt1+"="+t1+"$<br>"
                            + "परंतु $"+chrt1+"=-"+t2+"$ हे शक्य नाही (कारण ती त्रिकोणाच्या बाजूची लांबी आहे)<br>"
                            + "$\\therefore "+chrt1+"="+t1+"$  सेंमी ही एक बाजू आहे <br>"
                            + "दुसरी बाजू $="+chrt1+"+"+pmid1+" = "+t1+"+"+pmid1+"="+sum+"$ सेंमी <br>"
                            + "उरलेल्या दोन बाजू ह्या $"+t1+"$ सेंमी आणि $"+t2+"$ सेंमी आहेत हे उत्तर. <br>";
            }
            
            
            
            
            
            
            
            String WA[] = { w1, w2, w3,w4,w5};
            int ar[] = GetIndex();

            ArrayList<String> W = new ArrayList<String>();// It is used to store wrong answer
            W.add(WA[ar[0]]);
            W.add(WA[ar[1]]);
            W.add(WA[ar[2]]);

            HashSet<String> hs = new HashSet<String>();// For checking duplication of wrong answer
            hs.add(WA[ar[0]]);
            hs.add(WA[ar[1]]);
            hs.add(WA[ar[2]]);
          
//				System.out.println(hs.size());
            String check1=question;
            String check=question+solution;
            
            if (Q.contains(check)||Q1.contains(check1)|| W.contains(cans) || hs.size() != W.size()) {
//			              System.out.println("step 2");
                i--;

            } else {
                
                Q.add(check);
                Q1.add(check1);
                XSSFRow row = sheet1.createRow((short) i);
                row.createCell(0).setCellValue(i);
                row.createCell(1).setCellValue("Text");
                row.createCell(2).setCellValue(1);
                row.createCell(3).setCellValue("0304070202");
                row.createCell(4).setCellValue(question); // Question
                row.createCell(5).setCellValue(cans); // Answer
//					 row.createCell(6).setCellValue(cans2);
                // row.createCell(7).setCellValue("");
                // row.createCell(8).setCellValue("");
                row.createCell(9).setCellValue(WA[ar[0]]); // w1
                row.createCell(10).setCellValue(WA[ar[1]]); // w2
                row.createCell(11).setCellValue(WA[ar[2]]); // w3
                row.createCell(12).setCellValue(120);
                row.createCell(13).setCellValue(4);
                // row.createCell(14).setCellValue("");
                row.createCell(15).setCellValue("komaldivasebe22@gmail.com");
                row.createCell(16).setCellValue(solution);// solution
                // row.createCell(17).setCellValue("");
                row.createCell(18).setCellValue(115);
            }
        
        }

        XSSFRow row = sheet1.createRow((short) n + 1);
        row.createCell(0).setCellValue("****");

        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            // workbook.close();
            System.out.println("Excel file generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//		To get the only 3 random wrong options from an array 
    static int[] GetIndex() {
        Random r = new Random();
        int arr[] = new int[3];
        ArrayList<Integer> al = new ArrayList<Integer>();
        int count = 0;
        while (count != 3) {
            int a = r.nextInt(5);
            if (!(al.contains(a))) {
                al.add(a);
                count++;
            }

        }
        // System.out.println(al);
        for (int i = 0; i < 3; i++) {
            arr[i] = al.get(i);
        }
        return arr;
    }
    
    static String[] Var() {

        Random r = new Random();

        String var[] = new String[2];

        String Chr1[] = { "a", "c", "f", "g", "m", "p", "q", "r", "s", "u", "v", "x", "y" };

        String Chr2[] = { "b", "d", "g", "h", "n", "q", "r", "s", "t", "v", "w", "y", "z" };

        int chi = r.nextInt(Chr1.length);


        String v1 = Chr1[chi];

        String v2 = Chr2[chi];



        var[0] = v1;

        var[1] = v2;

        return var;

    }
    
    static int[] valuesTriplate() {
        Random r = new Random();
        int var[] = new int[3];
        int Chr1[] = { 3, 6, 9, 12, 15, 18, 5, 10, 8, 7};
        int Chr2[] = { 4, 8, 12, 16, 20, 24, 12, 24, 15, 24 };
        int Chr3[] = { 5, 10, 15, 20, 25, 30, 13, 26, 17, 25};
        int chi = r.nextInt(Chr1.length);

        int v1 = Chr1[chi];
        int v2 = Chr2[chi];
        int v3 = Chr3[chi];

//			v1=r.nextInt(2,30);
//			v2=r.nextInt(2,30);
//			v3=r.nextInt(2,30);
//			
//			while(v1>v3 || v3-v1==1 ||v1==v3) {
//				v1=r.nextInt(2,30);
//				v2=r.nextInt(2,30);
//				v3=r.nextInt(2,30);
//			}
        
        var[0] = v1;
        var[1] = v2;
        var[2] = v3;

        return var;
    }

}



