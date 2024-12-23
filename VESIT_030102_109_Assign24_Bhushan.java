import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VESIT_030102_109_Assign24_Bhushan {

    // Function to generate a random pair of expressions with a specified relationship
    private static String[] generateExpressionPair(String relation) {
        int lhsNum1, lhsNum2, rhsNum1, rhsNum2;
        String[] operators = {"+", "-", "\\times"};
        String lhsOperator, rhsOperator;
        int lhsResult, rhsResult;

        do {
            lhsNum1 = (int)(Math.random()*20+1);
            lhsNum2 = (int)(Math.random()*20+1);
            rhsNum1 = (int)(Math.random()*20+1);
            rhsNum2 = (int)(Math.random()*20+1);

            lhsOperator = operators[(int)(Math.random()*3)];
            rhsOperator = operators[(int)(Math.random()*3)];

            lhsResult = calculate(lhsNum1, lhsNum2, lhsOperator);
            rhsResult = calculate(rhsNum1, rhsNum2, rhsOperator);
        } while (!isValidRelation(lhsResult, rhsResult, relation));

        String lhsExpression = lhsNum1 + "" + lhsOperator + "" + lhsNum2;
        String rhsExpression = rhsNum1 + "" + rhsOperator + "" + rhsNum2;
        String lhsExpression1 = lhsNum1 + "" + lhsOperator + "" + lhsNum2+"="+lhsResult;
        String rhsExpression1 = rhsNum1 + "" + rhsOperator + "" + rhsNum2+"="+rhsResult;

        return new String[]{lhsExpression, rhsExpression,lhsExpression1, rhsExpression1};
    }

    // Function to validate if the generated expressions meet the required relation
    private static boolean isValidRelation(int lhs, int rhs, String relation) {
        switch (relation) {
            case "=":
                return lhs == rhs;
            case ">":
                return lhs > rhs;
            case "<":
                return lhs < rhs;
            default:
                return false;
        }
    }

    // Function to calculate the result of an expression
    private static int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "\\times":
                return num1 * num2;
            default:
                return 0;
        }
    }
	
	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VESIT_030102_109_Assign24_Bhushan.xlsx";     //Location where excel file is getting generated
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
	
	 	//Adding header to the second sheet
		for(int head=0; head<header.length; head++) {
			rowhead.createCell(head).setCellValue(header[head]);
			
		}
		
		   
		int mapsize,mapsizeafter;
		HashMap<String, Integer> map = new HashMap<String, Integer> ();
        

		for(int i =1;i<201;i++)
		{
			// Create row
			
			XSSFRow row = sheet1.createRow(i);
			row.createCell(0).setCellValue(i); 
			row.createCell(1).setCellValue("Text"); 
			row.createCell(2).setCellValue(1);
			row.createCell(3).setCellValue("030102");

            String[] relations = {"=", "<", ">"};
            ArrayList<String> expressions = new ArrayList<String>();
            ArrayList<String> getTerm = new ArrayList<String>();
            String term1="",term2="",term3="",solterm1="",solterm2="",solterm3="",solterm4="",solterm5="",solterm6="",msolterm4="",msolterm5="",msolterm6="";

            for (int j = 0; j < 3; j++) {
                String[] generatedExpressions =generateExpressionPair(relations[j]);
                expressions.add(""+generatedExpressions[0]+"");
                expressions.add(""+generatedExpressions[1]+"");
                expressions.add(""+generatedExpressions[2]+"");
                expressions.add(""+generatedExpressions[3]+"");
                // System.out.printf("%-5s %-20s %-20s %-5s %-5s%n", Tablerow, expressions[0], expressions[1], (i + 1), relations[i]);
            }
            // System.out.println(i);
            term1=""+expressions.get(0)+" & "+expressions.get(1)+"";
            term2=""+expressions.get(4)+" & "+expressions.get(5)+"";
            term3=""+expressions.get(8)+" & "+expressions.get(9)+"";
            solterm1=""+expressions.get(2)+" & "+expressions.get(3)+"";
            solterm2=""+expressions.get(6)+" & "+expressions.get(7)+"";
            solterm3=""+expressions.get(10)+" & "+expressions.get(11)+"";
            solterm4="LHS $= "+expressions.get(2)+"$ and RHS $= "+expressions.get(3)+"$";
            solterm5="LHS $= "+expressions.get(6)+"$ and RHS $= "+expressions.get(7)+"$";
            solterm6="LHS $= "+expressions.get(10)+"$ and RHS $= "+expressions.get(11)+"$";
         
            msolterm4="डावी बाजू $= "+expressions.get(2)+"$ आणि उजवी बाजू $= "+expressions.get(3)+"$";
            msolterm5="डावी बाजू $= "+expressions.get(6)+"$ आणि उजवी बाजू $= "+expressions.get(7)+"$";
            msolterm6="डावी बाजू $= "+expressions.get(10)+"$ आणि उजवी बाजू $= "+expressions.get(11)+"$";
            // System.out.println(""+solterm1+"  "+solterm2+"  "+solterm3+" expressions "+expressions.size()+" getTerm "+getTerm.size()+"");
            String[] inputs = {solterm1,solterm2,solterm3};
    
            // Arrays to store the results
            Integer[] lResults = new Integer[3]; // For first numbers after '='
            Integer[] rResults = new Integer[3]; // For second numbers after '='
    
            // Regular expression to find numbers after '='
            Pattern pattern = Pattern.compile("=(-?\\d+)");
    
            for (int iR = 0; iR < inputs.length; iR++) {
                Matcher matcher = pattern.matcher(inputs[iR]);
    
                int count = 0;
                while (matcher.find()) {
                    if (count == 0) {
                        lResults[iR] = Integer.parseInt(matcher.group(1));
                    } else if (count == 1) {
                        rResults[iR] = Integer.parseInt(matcher.group(1));
                    }
                    count++;
                }
            }

            int a=0,b=0,c=0,a1=0,b1=0,c1=0,a2=0,b2=0,c2=0,a3=0,b3=0,c3=0;
            int ch=(int)(Math.random()*6+1);

            switch (ch) {
                case 1:
                    a=1;b=2;c=3; a1=1;b1=3;c1=2;  a2=2;b2=1;c2=3; a3=2;b3=3;c3=1;
                    getTerm.add(term1); getTerm.add(term2); getTerm.add(term3);
                    getTerm.add(solterm1); getTerm.add(solterm2); getTerm.add(solterm3);
                    getTerm.add(solterm4+" which gives equal value. "); getTerm.add(solterm5+" and <br> $"+lResults[1].toString()+"<"+rResults[1].toString()+"$. "); getTerm.add(solterm6+" and <br> $"+lResults[2].toString()+">"+rResults[2].toString()+"$. ");
                    getTerm.add(""+lResults[1].toString()+"<"+rResults[1].toString()+""); getTerm.add(""+lResults[2].toString()+">"+rResults[2].toString()+""); 
                    getTerm.add(msolterm4+" म्हणजेच दोन्ही बाजूंची किंमत/ मूल्य समान आहे असे दिसते. "); getTerm.add(msolterm5+" आणि <br> $"+lResults[1].toString()+"<"+rResults[1].toString()+"$ पेक्षा लहान आहे. "); getTerm.add(msolterm6+" आणि <br> $"+lResults[2].toString()+">"+rResults[2].toString()+"$ पेक्षा मोठा आहे. ");
                break;
                case 2:
                    a=1;b=3;c=2;  a1=1;b1=2;c1=3;  a2=2;b2=1;c2=3; a3=2;b3=3;c3=1;
                    getTerm.add(term1); getTerm.add(term3); getTerm.add(term2);
                    getTerm.add(solterm1); getTerm.add(solterm3); getTerm.add(solterm2);
                    getTerm.add(solterm4+" which gives equal value. "); getTerm.add(solterm6+" and <br> $"+lResults[2].toString()+">"+rResults[2].toString()+"$. "); getTerm.add(solterm5+" and <br> $"+lResults[1].toString()+"<"+rResults[1].toString()+"$. ");
                    getTerm.add(""+lResults[2].toString()+">"+rResults[2].toString()+""); getTerm.add(""+lResults[1].toString()+"<"+rResults[1].toString()+""); 
                    getTerm.add(msolterm4+" म्हणजेच दोन्ही बाजूंची किंमत/ मूल्य समान आहे असे दिसते. "); getTerm.add(msolterm6+" आणि <br> $"+lResults[2].toString()+">"+rResults[2].toString()+"$ पेक्षा मोठा आहे. "); getTerm.add(msolterm5+" आणि <br> $"+lResults[1].toString()+"<"+rResults[1].toString()+"$ पेक्षा लहान आहे. ");

                break;
                case 3:
                    a=2;b=1;c=3;  a1=1;b1=3;c1=2;  a2=3;b2=1;c2=2; a3=2;b3=3;c3=1;
                    getTerm.add(term2); getTerm.add(term1); getTerm.add(term3);
                    getTerm.add(solterm2); getTerm.add(solterm1); getTerm.add(solterm3);
                    getTerm.add(solterm5+" and <br> $"+lResults[1].toString()+"<"+rResults[1].toString()+"$. "); getTerm.add(solterm4+" which gives equal value. "); getTerm.add(solterm6+" and <br> $"+lResults[2].toString()+">"+rResults[2].toString()+"$. ");
                    getTerm.add(""+lResults[1].toString()+"<"+rResults[1].toString()+""); getTerm.add(""+lResults[2].toString()+">"+rResults[2].toString()+""); 
                    getTerm.add(msolterm5+" आणि <br> $"+lResults[1].toString()+"<"+rResults[1].toString()+"$ पेक्षा लहान आहे. "); getTerm.add(msolterm4+" म्हणजेच दोन्ही बाजूंची किंमत/ मूल्य समान आहे असे दिसते. "); getTerm.add(msolterm6+" आणि <br> $"+lResults[2].toString()+">"+rResults[2].toString()+"$ पेक्षा मोठा आहे. ");


                break;
                case 4:
                    a=2;b=3;c=1;  a1=1;b1=3;c1=2;  a2=2;b2=1;c2=3; a3=3;b3=2;c3=1;
                    getTerm.add(term2); getTerm.add(term3); getTerm.add(term1);
                    getTerm.add(solterm2); getTerm.add(solterm3); getTerm.add(solterm1);
                    getTerm.add(solterm5+" and <br> $"+lResults[1].toString()+"<"+rResults[1].toString()+"$. "); getTerm.add(solterm6+" and <br> $"+lResults[2].toString()+">"+rResults[2].toString()+"$. "); getTerm.add(solterm4+" which gives equal value. ");
                    getTerm.add(""+lResults[1].toString()+"<"+rResults[1].toString()+""); getTerm.add(""+lResults[2].toString()+">"+rResults[2].toString()+""); 
                    getTerm.add(msolterm5+" आणि <br> $"+lResults[1].toString()+"<"+rResults[1].toString()+"$ पेक्षा लहान आहे. "); getTerm.add(msolterm6+" आणि <br> $"+lResults[2].toString()+">"+rResults[2].toString()+"$ पेक्षा मोठा आहे. "); getTerm.add(msolterm4+" म्हणजेच दोन्ही बाजूंची किंमत/ मूल्य समान आहे असे दिसते. ");


                break;
                case 5:
                    a=3;b=1;c=2;  a1=1;b1=3;c1=2;  a2=2;b2=1;c2=3; a3=2;b3=3;c3=1;
                    getTerm.add(term3); getTerm.add(term1); getTerm.add(term2);
                    getTerm.add(solterm3); getTerm.add(solterm1); getTerm.add(solterm2);
                    getTerm.add(solterm6+" and <br> $"+lResults[2].toString()+">"+rResults[2].toString()+"$. "); getTerm.add(solterm4+" which gives equal value. "); getTerm.add(solterm5+" and <br> $"+lResults[1].toString()+"<"+rResults[1].toString()+"$. ");
                    getTerm.add(""+lResults[2].toString()+">"+rResults[2].toString()+""); getTerm.add(""+lResults[1].toString()+"<"+rResults[1].toString()+""); 
                    getTerm.add(msolterm6+" आणि <br> $"+lResults[2].toString()+">"+rResults[2].toString()+"$ पेक्षा मोठा आहे. "); getTerm.add(msolterm4+" म्हणजेच दोन्ही बाजूंची किंमत/ मूल्य समान आहे असे दिसते. "); getTerm.add(msolterm5+" आणि <br> $"+lResults[1].toString()+"<"+rResults[1].toString()+"$ पेक्षा लहान आहे. ");

                break;
                case 6:
                    a=3;b=2;c=1;  a1=1;b1=3;c1=2;  a2=2;b2=1;c2=3; a3=2;b3=3;c3=1;
                    getTerm.add(term3); getTerm.add(term2); getTerm.add(term1);
                    getTerm.add(solterm3); getTerm.add(solterm2); getTerm.add(solterm1);
                    getTerm.add(solterm6+" and <br> $"+lResults[2].toString()+">"+rResults[2].toString()+"$. "); getTerm.add(solterm5+" and <br> $"+lResults[1].toString()+"<"+rResults[1].toString()+"$. "); getTerm.add(solterm4+" which gives equal value. ");
                    getTerm.add(""+lResults[2].toString()+">"+rResults[2].toString()+""); getTerm.add(""+lResults[1].toString()+"<"+rResults[1].toString()+""); 
                    getTerm.add(msolterm6+" आणि <br> $"+lResults[2].toString()+">"+rResults[2].toString()+"$ पेक्षा मोठा आहे. "); getTerm.add(msolterm5+" आणि <br> $"+lResults[1].toString()+"<"+rResults[1].toString()+"$ पेक्षा लहान आहे. "); getTerm.add(msolterm4+" म्हणजेच दोन्ही बाजूंची किंमत/ मूल्य समान आहे असे दिसते. ");

                break;
                default:
                    break;
            }

            
            // System.out.println(""+solterm1+"  "+solterm2+"  "+solterm3+" expressions "+expressions.size()+" getTerm "+getTerm.size()+"");

			String Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Que,Que1,Sol,Sol1;
            
           
            Que="Study each pair of expressions given in Expressions column (LHS and RHS) and match them with appropriate operator present in Relations column <br> # राशींच्या रकान्यामध्ये (LHS व RHS) दिलेल्या राशींच्या जोड्या तपासून बघा आणि त्यांना जोडण्यासाठी चिन्हांच्या रकान्यातील चिन्हांशी त्यांची जोडी लावा. \\[\\begin{array}{|c|c|c|c|c|} \\hline \\text{ } & \\text{Expressions (LHS)}& \\text{Expressions (RHS)} & \\text{ } & \\text{Relations} \\\\\\hline a & "+getTerm.get(0)+" & 1 & = \\\\\\hline b & "+getTerm.get(1)+" & 2 & < \\\\\\hline c & "+getTerm.get(2)+" & 3 & > \\\\\\hline \\end{array} \\]";
			Que1="";
            Correct_ans="$a="+a+", b="+b+", c="+c+"$";
           
			wrong_ans="$a="+a1+", b="+b1+", c="+c1+"$";
			wrong_ans1="$a="+a2+", b="+b2+", c="+c2+"$";
			wrong_ans2="$a="+a3+", b="+b3+", c="+c3+"$";
			Sol1="";
			
			
			Sol="Answer: \\[ \\begin{array}{|c|c|c|c|c|} \\hline \\text{ } & \\text{Expressions  (LHS)}& \\text{Expressions (RHS)} & \\text{ } & \\text{Relations} \\\\\\hline a & "+getTerm.get(0)+" & 1 & = \\\\\\hline b & "+getTerm.get(1)+" & 2 & < \\\\\\hline c & "+getTerm.get(2)+" & 3 & > \\\\\\hline \\end{array} \\]" +
                                "Solution: Answer - <br> The convention of using the operators between any two expressions is as follows : " +
                                "<br>$=$ used  when both LHS and RHS are having the same value. " +
                                "<br>$>$ used when the value of LHS is greater than that of RHS. " +
                                "<br>$<$ used when the value of LHS  is less than that of RHS. <br>" +
                                "Below given is the table, in which the answer for each expression is calculated and also explained. <br> \\[ \\begin{array}{|c|c|c|c|c|} \\hline \\text{ } & \\text{Expressions (LHS)}& \\text{Expressions (RHS)} & \\text{ } & \\text{Relations} \\\\\\hline a & "+getTerm.get(3)+" & 1 & = \\\\\\hline b & "+getTerm.get(4)+" & 2 & < \\\\\\hline c & "+getTerm.get(5)+" & 3 & > \\\\\\hline \\end{array} \\]" +
                                " <br>Row $a)$ "+getTerm.get(6)+" <br>$\\therefore a ≈ "+a+"$. <br>Row $b)$ "+getTerm.get(7)+" <br>$\\therefore b ≈ "+b+"$. <br>Row $c)$ "+getTerm.get(8)+" <br>$\\therefore c ≈ "+c+"$. <br>$\\therefore$ correct matching is $a ≈ "+a+", b ≈ "+b+", c ≈ "+c+"$. <br >";
                                
    
			Sol1="# उत्तर : <br> रूढ पद्धतीनुसार $2$ राशींमधील संबंध खालील प्रकारे दाखविला जातो" +
                                "<br> $=$ जेंव्हा डाव्या (LHS) आणि उजव्या (RHS) बाजूचे राशी मूल्य  समान असते तेंव्हा हे चिन्ह वापरतात. " +
                                "<br> $>$ जेंव्हा डाव्या (LHS) बाजूचे राशी मूल्य  उजव्या (RHS) बाजूच्या राशी मुल्या पेक्षा मोठे असते तेंव्हा हे चिन्ह वापरतात, आणि " +
                                "<br> $<$ जेंव्हा डाव्या (LHS) बाजूचे राशी मूल्य उजव्या (RHS) बाजूच्या राशी मुल्या पेक्षा लहान असते तेंव्हा हे चिन्ह वापरतात. <br>" +
                                "खाली दिलेल्या तक्त्यात सर्व राशी सोडवून त्यांचे उत्तर दाखविले आहे. आणि त्या खाली खुलासा सुद्धा दिला आहे. \\[ \\begin{array}{|c|c|c|c|c|} \\hline \\text{ } & \\text{Expressions (LHS)}& \\text{Expressions (RHS)} & \\text{ } & \\text{Relations} \\\\\\hline a & "+getTerm.get(3)+" & 1 & = \\\\\\hline b & "+getTerm.get(4)+" & 2 & < \\\\\\hline c & "+getTerm.get(5)+" & 3 & > \\\\\\hline \\end{array} \\]" +
                                "<br> $a)$ ओळींमध्ये, "+getTerm.get(11)+"" +
                                "<br> $\\therefore a ≈ "+a+"$ ." +
                                "<br> $b)$ ओळींमध्ये, "+getTerm.get(12)+"" +
                                "<br> $\\therefore b ≈ "+b+"$ ." +
                                "<br> $c)$ ओळींमध्ये, "+getTerm.get(13)+"" +
                                "<br> $\\therefore c ≈ "+c+"$ ." +
                                "<br> $\\therefore$ योग्य जोड्या पुढील प्रमाणे आहेत $a ≈ "+a+", b ≈ "+b+", c ≈ "+c+"$. <br> \\[ \\begin{array}{|c|c|c|c|c|} \\hline \\text{ } & \\text{Expressions (LHS)}& \\text{Expressions (RHS)} & \\text{ } & \\text{Relations} \\\\\\hline a & "+getTerm.get(3)+" & 1 & =  \\\\\\hline b & "+getTerm.get(4)+" & 2 & < \\\\\\hline c & "+getTerm.get(5)+" & 3 & >  \\\\\\hline \\end{array} \\]";
			
			String Solution = ""+Sol+" "+Sol1+"";
			String Question =""+Que+" "+Que1+"";
			
			
			
			row.createCell(4).setCellValue(Question);
			row.createCell(5).setCellValue(Correct_ans);
			//               row.createCell(6).setCellValue("");
			//				 row.createCell(7).setCellValue(" ");
			//				 row.createCell(8).setCellValue(" ");
			row.createCell(9).setCellValue(wrong_ans);
			row.createCell(10).setCellValue(wrong_ans1);
			row.createCell(11).setCellValue(wrong_ans2);
			row.createCell(12).setCellValue(120);
			row.createCell(13).setCellValue(3);
			//				  row.createCell(14).setCellValue(" ");
			row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			//Generate Solution
								
			row.createCell(16).setCellValue(Solution);
			//				  row.createCell(17).setCellValue(" ");
			row.createCell(18).setCellValue(109);

				
			String Checker =""+Question+""+Solution+""+Correct_ans+""+wrong_ans2+""+wrong_ans+""+wrong_ans1+"";
			mapsize = map.size();
			map.put(Checker,i);
			mapsizeafter = map.size();
				
			
			//In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
			if(mapsize == mapsizeafter) {
				// System.out.println(Checker);
				i--;
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
