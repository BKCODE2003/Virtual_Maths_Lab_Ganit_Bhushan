import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VLab_0304070202_122_Assign30_Bhushan {
	public static int[] findFactors(int targetProduct, int targetSum) {
		// Loop through possible values of p
		for (int p = -Math.abs(targetProduct); p <= Math.abs(targetProduct); p++) {
			if (p == 0) continue; // Skip division by zero
	
			// Calculate q
			int q = targetProduct / p;
	
			// Check if the conditions are met
			if (p * q == targetProduct && p + q == targetSum) {
				// Ensure the larger number is first
				if (p > q) {
					return new int[] {p, q};
				} else {
					return new int[] {q, p};
				}
			}
		}
		return null; // Return null if no solution is found
	}
	
	public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
	private static final Set<String> usedPairs = new HashSet<>();

	public static boolean isInUse(int a, int b,int c) {
        
        String pair = a + "-" + b +	"-" + c;

        if (usedPairs.contains(pair)) {
            return true; 
		}
        usedPairs.add(pair);
        return false;
    }

	public static void main(String args[]) throws IOException,FileNotFoundException{
		String filename = "D:/excel files/VLab_0304070202_122_Assign30_Bhushan.xlsx";     //Location where excel file is getting generated
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
			row.createCell(3).setCellValue("0304070202");
			String []var1={"a","c","g","l","m","p","r","s","u","v","x","y","b","d","h","m","n","q","s","t","v","w","y","z"};
    		
			int Chr1[] = { 3, 6, 9, 12, 15, 18, 5, 10, 8, 7};
			int Chr2[] = { 4, 8, 12, 16, 20, 24, 12, 24, 15, 24 };
			int Chr3[] = { 5, 10, 15, 20, 25, 30, 13, 26, 17, 25};

			int p=(int)(Math.random()*24);
			int nim=(int)(Math.random()*10);
			int div=(int)(Math.random()*9)+1;
			while(div==5 || div==7){
				div=(int)(Math.random()*9)+1;
			}

			while(isInUse(nim,div,p)){
				p=(int)(Math.random()*24);
				nim=(int)(Math.random()*10);
				div=(int)(Math.random()*9)+1;
				while(div==5 || div==7){
					div=(int)(Math.random()*9)+1;
				}
			}

			int diff=Chr2[nim]-Chr1[nim];
			String Correct_ans,wrong_ans,wrong_ans1,wrong_ans2,Que,Que1,Sol,Sol1;
			int term1=diff*diff-Chr3[nim]*Chr3[nim];
			int gcd3=gcd(2*div*div,gcd(2*div*diff,Math.abs(term1)));
			int term2=(2*div*div)/gcd3;
			int term3=(2*div*diff)/gcd3;
			int term4=Math.abs(term1)/gcd3;
			int term4S=term1/gcd3;
			int [] result=findFactors(term2*term4S,term3);
			if (result == null) {
				System.out.println("Error: "+i);
				i--; // Decrement i to retry the current iteration
				continue; // Skip to the next iteration
			}
			int cf3=gcd(Chr1[nim],Chr2[nim]);
			int cf4=result[0];
			int cf5=Math.abs(result[1]);
			int cf1=gcd(term2,cf4);
			int cf2=gcd(cf5,term4);
			int ans1gcd=gcd(cf2,cf1);
			int ans2gcd=gcd(Chr2[nim],div);
			
			int nGcd=gcd(diff,div); 
			int nGcd1=gcd(Chr3[nim],div);
			int nGcd3=gcd(nGcd,nGcd1);
		
			int nTerm=((diff/nGcd)*(diff/nGcd))-((Chr3[nim]/nGcd1)*(Chr3[nim]/nGcd1));

			int nGcd4=gcd((2*((div/nGcd)*(div/nGcd))),gcd((2*(div/nGcd)*(diff/nGcd)),Math.abs(nTerm)));

			Que="The altitude of a right triangle is $"+((div/nGcd)==1?""+(diff/div)+"":"\\dfrac{"+(diff/nGcd)+"}{"+(div/nGcd)+"}")+"$ cm more than its base. If the hypotenuse is $"+((div/nGcd1)==1?""+(Chr3[nim]/div)+"":"\\dfrac {"+(Chr3[nim]/nGcd1)+"}{"+(div/nGcd1)+"}")+"$ cm, find the other two sides of the triangle using quadratic equation method. <br>";
								
			Que1="#एका काटकोन त्रिकोणाची उंची पायापेक्षा $"+((div/nGcd)==1?""+(diff/div)+"":"\\dfrac{"+(diff/nGcd)+"}{"+(div/nGcd)+"}")+"$ सेंमी ने जास्त आहे. जर त्या त्रिकोणाचा कर्ण $"+((div/nGcd1)==1?""+(Chr3[nim]/div)+"":"\\dfrac {"+(Chr3[nim]/nGcd1)+"}{"+(div/nGcd1)+"}")+"$ असेल तर त्या त्रिकोणाच्या बाकीच्या दोन बाजू वर्ग समीकरण पद्धत वापरून शोधा. <br>";

			// Sol="As the measure of base is not given let us assume base to be $"+var1[p]+"$ cm. <br>" +
			// 					"$\\therefore $ Altitude $="+var1[p]+"+\\dfrac{"+diff+"}{"+div+"}=\\dfrac {"+div+""+var1[p]+"+"+diff+"}{"+div+"} $ cm <br>" +
			// 					"And hypotenuse is given as $\\dfrac{"+Chr3[nim]+"}{"+div+"}$ cm <br>" +
			// 					"For right angle triangle, by using Pythagorus Theorem, we get<br>" +
			// 					"Base$^2 +$ Altitude $^2 =$ Hypotenus$^2$<br>" +
			// 					"$\\therefore "+var1[p]+"^2+(\\dfrac {"+div+""+var1[p]+"+"+diff+"}{"+div+"})^2=(\\dfrac{"+Chr3[nim]+"}{"+div+"})^2$ . . . .  by Pythagoras theorem <br>" +
			// 					"$\\therefore "+div*div+""+var1[p]+"^2+("+div+""+var1[p]+"+"+diff+")^2 ="+Chr3[nim]+"^2$ <br>" +
			// 					"$\\therefore "+div*div+""+var1[p]+"^2+"+div*div+""+var1[p]+"^2+"+2*div*diff+""+var1[p]+"+"+diff*diff+" = "+Chr3[nim]*Chr3[nim]+"$ <br>" +
			// 					"$\\therefore "+2*div*div+""+var1[p]+"^2+"+2*div*diff+""+var1[p]+""+(term1==Math.abs(term1) ? "+":"-")+Math.abs(term1)+"=0$ <br>" +
			// 					"$\\therefore "+(2*div*div)/gcd3+""+var1[p]+"^2+"+(2*div*diff)/gcd3+""+var1[p]+""+(term1==Math.abs(term1) ? "+":"-")+(Math.abs(term1)/gcd3)+"=0$ <br>" +
			// 					"$\\therefore "+term2+""+var1[p]+"^2 +"+(Chr2[nim]/cf3)+""+var1[p]+"-"+(Chr1[nim]/cf3)+""+var1[p]+"-"+term4+"=0$ <br>" +
			// 					"$\\therefore "+(cf1==1?"":cf1)+""+var1[p]+"("+term2/cf1+""+var1[p]+"+"+cf4/cf1+")-"+(cf2==1?"":cf2)+"("+term4/cf2+""+var1[p]+"+"+cf5/cf2+")=0$ <br>" +
			// 					"$\\therefore ("+term2/cf1+""+var1[p]+"+"+cf4/cf1+")("+(cf1==1?"":cf1)+""+var1[p]+"-"+(cf2==1?"":cf2)+")=0$ <br>" +
			// 					"$\\therefore "+(term2/cf1)+""+var1[p]+"+"+(cf4/cf1)+"=0$ or $"+(cf1==1?"":cf1)+""+var1[p]+"-"+(cf2==1?"":cf2)+"=0$ <br>" +
			// 					"$\\therefore "+var1[p]+"=-\\dfrac {"+cf4/cf1+"}{"+term2/cf1+"}$ or $"+var1[p]+"="+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"$ <br>" +
			// 					"But $"+var1[p]+"=-\\dfrac {"+(cf4)/cf1+"}{"+term2/cf1+"}$ is not possible (being length of side of a triangle) <br>" +
			// 					"$\\therefore "+var1[p]+"="+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"$ cm is one side and <br>" +
			// 					"Other side $="+var1[p]+"+\\dfrac {"+diff+"}{"+div+"} = "+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"+\\dfrac {"+diff+"}{"+div+"}=\\dfrac {"+Chr2[nim]+"}{"+div+"}$ cm <br>" +
			// 					"$\\therefore$ two sides of the triangle are $"+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"$ cm and $\\dfrac {"+Chr2[nim]+"}{"+div+"}$ cm is the answer. <br>";

			
			 
			Sol="Ans:$"+(ans1gcd==1?""+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"$ cm and $"+(ans2gcd==1?""+(div==1?""+Chr2[nim]/div+"":"\\dfrac {"+Chr2[nim]+"}{"+div+"}")+"":((div/ans2gcd)==1?""+(Chr2[nim]/div)+"":"\\dfrac {"+(Chr2[nim]/ans2gcd)+"}{"+(div/ans2gcd)+"}"))+"$ cm <br>As the measure of base is not given let us assume base to be $"+var1[p]+"$ cm. <br>" +
								"$\\therefore $ Altitude $="+var1[p]+"+"+((div/nGcd)==1?""+(diff/div)+"":"\\Bigl(\\dfrac{"+(diff/nGcd)+"}{"+(div/nGcd)+"}\\Bigl)")+"="+((div/nGcd)==1?""+var1[p]+"+"+(diff/div)+"":"\\Bigl(\\dfrac {"+(div/nGcd)+""+var1[p]+"+"+(diff/nGcd)+"}{"+(div/nGcd)+"}\\Bigl)")+" $ cm <br>"+
								"And hypotenuse is given as $"+((div/nGcd1)==1?""+(Chr3[nim]/div)+"":"\\Bigl(\\dfrac {"+(Chr3[nim]/nGcd1)+"}{"+(div/nGcd1)+"}\\Bigl)")+"$ cm <br>"+
								"For right angle triangle, by using Pythagoras Theorem, we get<br>"+
								"Base$^2 +$ Altitude $^2 =$ Hypotenuse$^2$<br>" +
								"$\\therefore "+var1[p]+"^2+"+((div/nGcd)==1?"("+var1[p]+"+"+(diff/div)+")^2":"\\Bigl(\\dfrac {"+(div/nGcd)+""+var1[p]+"+"+(diff/nGcd)+"}{"+(div/nGcd)+"}\\Bigl)^2")+"="+((div/nGcd1)==1?"("+(Chr3[nim]/div)+")^2":"\\Bigl(\\dfrac {"+(Chr3[nim]/nGcd1)+"}{"+(div/nGcd1)+"}\\Bigl)^2")+"$ . . . .  by Pythagoras theorem <br>" +
								"$\\therefore "+(((div/nGcd)*(div/nGcd))==1?"":((div/nGcd)*(div/nGcd)))+""+var1[p]+"^2+\\Bigl("+(div/nGcd==1?"":div/nGcd)+""+var1[p]+"+"+(diff/nGcd)+"\\Bigl)^2 ="+(Chr3[nim]/nGcd1)+"^2. . . .$ by simplifying <br>" +
								"$\\therefore "+(((div/nGcd)*(div/nGcd))==1?"":((div/nGcd)*(div/nGcd)))+""+var1[p]+"^2+"+(div/nGcd==1?"":(div/nGcd)*(div/nGcd))+""+var1[p]+"^2+"+2*(div/nGcd)*(diff/nGcd)+""+var1[p]+"+"+(diff/nGcd)*(diff/nGcd)+" = "+(Chr3[nim]/nGcd1)*(Chr3[nim]/nGcd1)+"$ <br>" +
								"$\\therefore "+(((div/nGcd)*(div/nGcd))+((div/nGcd)*(div/nGcd)))+""+var1[p]+"^2+"+2*(div/nGcd)*(diff/nGcd)+""+var1[p]+""+(nTerm==Math.abs(nTerm) ? "+":"-")+Math.abs(nTerm)+"=0$ <br>" +
								"$\\therefore "+(((((div/nGcd)*(div/nGcd))+((div/nGcd)*(div/nGcd)))/nGcd4)==1?"":((((div/nGcd)*(div/nGcd))+((div/nGcd)*(div/nGcd)))/nGcd4))+""+var1[p]+"^2+"+(((2*(div/nGcd)*(diff/nGcd))/nGcd4)==1?"":((2*(div/nGcd)*(diff/nGcd))/nGcd4))+""+var1[p]+""+(nTerm==Math.abs(nTerm) ? "+":"-")+(Math.abs(nTerm)/nGcd4)+"=0$ <br>" +
								"$\\therefore "+(term2==1?"":""+term2+"")+""+var1[p]+"^2 +"+(result[0]==1?"":""+result[0]+"")+""+var1[p]+"-"+(Math.abs(result[1])==1?"":""+Math.abs(result[1])+"")+""+var1[p]+"-"+term4+"=0 . . . . $ by splitting the middle term <br>" +
								"$\\therefore "+(cf1==1?"":cf1)+""+var1[p]+"("+(term2/cf1==1?"":""+term2/cf1+"")+""+var1[p]+"+"+cf4/cf1+")-"+(cf2==1?"":cf2)+"("+(cf5/cf2==1?"":""+cf5/cf2+"")+""+var1[p]+"+"+term4/cf2+")=0$ <br>" +
								"$\\therefore ("+(term2/cf1==1?"":""+term2/cf1+"")+""+var1[p]+"+"+cf4/cf1+")("+(cf1==1?"":cf1)+""+var1[p]+"-"+(cf2==1?"1":cf2)+")=0$ <br>" +
								"$\\therefore "+(term2/cf1==1?"":""+term2/cf1+"")+""+var1[p]+"+"+(cf4/cf1)+"=0$ or $"+(cf1==1?"":cf1)+""+var1[p]+"-"+(cf2==1?"1":cf2)+"=0$ <br>" +
								"$\\therefore "+var1[p]+"="+(term2/cf1==1?"-"+((cf4)/cf1)+"":"-\\dfrac {"+(cf4)/cf1+"}{"+term2/cf1+"}")+"$ or $"+var1[p]+"="+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"$ <br>" +
								"But $"+var1[p]+"="+(term2/cf1==1?"-"+((cf4)/cf1)+"":"-\\dfrac {"+(cf4)/cf1+"}{"+term2/cf1+"}")+"$ is not possible (being length of side of a triangle) <br>" +
								"$\\therefore "+var1[p]+"="+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+""+(ans1gcd==1?"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"=\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"$ cm is one side and <br>" +
								"Other side $="+var1[p]+"+"+((div/nGcd)==1?""+(diff/div)+"":"\\Bigl(\\dfrac{"+(diff/nGcd)+"}{"+(div/nGcd)+"}\\Bigl)")+" = "+(ans1gcd==1?""+(cf1==1?""+(cf2/cf1)+"":"\\Bigl(\\dfrac {"+cf2+"}{"+cf1+"}\\Bigl)")+"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"+"+((div/nGcd)==1?""+(diff/div)+"":"\\Bigl(\\dfrac{"+(diff/nGcd)+"}{"+(div/nGcd)+"}\\Bigl)")+""+((ans2gcd==1 && div!=1)?"=\\dfrac {"+Chr2[nim]+"}{"+div+"}":((div/ans2gcd)==1?""+((((div/nGcd)==1)&&((ans1gcd==1&&cf1==1)))?"":"")+"="+(Chr2[nim]/div)+"":"=\\dfrac {"+(Chr2[nim]/ans2gcd)+"}{"+(div/ans2gcd)+"}"))+"$ cm <br>" +
								"$\\therefore$ two sides of the triangle are $"+(ans1gcd==1?""+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"$ cm and $"+((ans2gcd==1 && div!=1)?"\\dfrac {"+Chr2[nim]+"}{"+div+"}":((div/ans2gcd)==1?""+(Chr2[nim]/div)+"":"\\dfrac {"+(Chr2[nim]/ans2gcd)+"}{"+(div/ans2gcd)+"}"))+"$ cm is the answer. <br>";

			// if((div*div)/(nGcd3)!=div*div){
			// System.out.println("no "+i+"  "+((div*div)/(nGcd3))+"  fffff  "+div+"   ngcd "+nGcd3+" div/ncd "+(div/nGcd)+" ");}
			// if(div/nGcd!=div/nGcd1){
			// System.out.println("no "+i+"--------------------------------------"+nGcd4+"");
			// System.out.println(""+(((div/nGcd)*(div/nGcd))+((div/nGcd)*(div/nGcd)))+""+var1[p]+"^2+"+2*(div/nGcd)*(diff/nGcd)+""+var1[p]+""+(nTerm==Math.abs(nTerm) ? "+":"-")+Math.abs(nTerm)+"=0$");
			// System.out.println(""+(((((div/nGcd)*(div/nGcd))+((div/nGcd)*(div/nGcd)))/nGcd4)==1?"":((((div/nGcd)*(div/nGcd))+((div/nGcd)*(div/nGcd)))/nGcd4))+""+var1[p]+"^2+"+(((2*(div/nGcd)*(diff/nGcd))/nGcd4)==1?"":((2*(div/nGcd)*(diff/nGcd))/nGcd4))+""+var1[p]+""+(nTerm==Math.abs(nTerm) ? "+":"-")+(Math.abs(nTerm)/nGcd4)+"=0$");

			// Sol1="#पायाची किंमत दिलेली नसल्यामुळे आपण पाया $"+var1[p]+"$ सेंमी आहे असे मानू. <br>" +
			// 					"$\\therefore $ उंची $="+var1[p]+"+"+((div/nGcd)==1?""+(diff/div)+"":"(\\dfrac{"+(diff/nGcd)+"}{"+(div/nGcd)+"})")+"="+((div/nGcd)==1?""+var1[p]+"+"+(diff/div)+"":"\\dfrac {"+(div/nGcd)+""+var1[p]+"+"+(diff/nGcd)+"}{"+(div/nGcd)+"}")+" $ सेंमी <br>" +
			// 					"आणि कर्णाची लांबी  $"+((div/nGcd1)==1?""+(Chr3[nim]/div)+"":"\\dfrac {"+(Chr3[nim]/nGcd1)+"}{"+(div/nGcd1)+"}")+"$ सेंमी आहे <br>" +
			// 					"म्हणून या काटकोन त्रिकोणासाठी पायथागोरसच्या प्रमेया नुसार <br>" +
			// 					"पाया $^2 +$ उंची $^2 = $ कर्ण $^2$ <br>" +
			// 					"$\\therefore "+var1[p]+"^2+("+((div/nGcd)==1?""+var1[p]+"+"+(diff/div)+"":"\\dfrac {"+(div/nGcd)+""+var1[p]+"+"+(diff/nGcd)+"}{"+(div/nGcd)+"}")+")^2=("+((div/nGcd1)==1?""+(Chr3[nim]/div)+"":"\\dfrac {"+(Chr3[nim]/nGcd1)+"}{"+(div/nGcd1)+"}")+")^2$ . . . .  पायथागोरस प्रमेया नुसार <br>" +
			// 					"$\\therefore "+((div*div)/nGcd3)+""+var1[p]+"^2+("+(div/nGcd==1?"":div/nGcd)+""+var1[p]+"+"+(diff/nGcd)+")^2 ="+(Chr3[nim]/nGcd1)+"^2. . . .$ सरळरूप देवून <br>" +
			// 					"$\\therefore "+((div*div)/nGcd3)+""+var1[p]+"^2+"+(div/nGcd==1?"":(div/nGcd)*(div/nGcd))+""+var1[p]+"^2+"+2*(div/nGcd)*(diff/nGcd)+""+var1[p]+"+"+(diff/nGcd)*(diff/nGcd)+" = "+(Chr3[nim]/nGcd1)*(Chr3[nim]/nGcd1)+"$ <br>" +
			// 					"$\\therefore "+(((div*div)/nGcd3)+((div/nGcd)*(div/nGcd)))+""+var1[p]+"^2+"+2*(div/nGcd)*(diff/nGcd)+""+var1[p]+""+(nTerm==Math.abs(nTerm) ? "+":"-")+Math.abs(nTerm)+"=0$ <br>" +
			// 					"$\\therefore "+(2*div*div)/gcd3+""+var1[p]+"^2+"+(((2*div*diff)/gcd3)==1?"":(2*div*diff)/gcd3)+""+var1[p]+""+(term1==Math.abs(term1) ? "+":"-")+(Math.abs(term1)/gcd3)+"=0$ <br>" +
			// 					"$\\therefore "+(term2==1?"":""+term2+"")+""+var1[p]+"^2 +"+(result[0]==1?"":""+result[0]+"")+""+var1[p]+"-"+(Math.abs(result[1])==1?"":""+Math.abs(result[1])+"")+""+var1[p]+"-"+term4+"=0$ मध्यपदाची फोड करून <br>" +
			// 					"$\\therefore "+(cf1==1?"":cf1)+""+var1[p]+"("+(term2/cf1==1?"":""+term2/cf1+"")+""+var1[p]+"+"+cf4/cf1+")-"+(cf2==1?"":cf2)+"("+(cf5/cf2==1?"":""+cf5/cf2+"")+""+var1[p]+"+"+term4/cf2+")=0$ <br>" +
			// 					"$\\therefore ("+(term2/cf1==1?"":""+term2/cf1+"")+""+var1[p]+"+"+cf4/cf1+")("+(cf1==1?"":cf1)+""+var1[p]+"-"+(cf2==1?"":cf2)+")=0$ <br>" +
			// 					"$\\therefore "+(term2/cf1==1?"":""+term2/cf1+"")+""+var1[p]+"+"+(cf4/cf1)+"=0$ or $"+(cf1==1?"":cf1)+""+var1[p]+"-"+(cf2==1?"":cf2)+"=0$ <br>" +
			// 					"$\\therefore "+var1[p]+"="+(term2/cf1==1?"-"+((cf4)/cf1)+"":"-\\dfrac {"+(cf4)/cf1+"}{"+term2/cf1+"}")+"$ or $"+var1[p]+"="+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"$ <br>" +
			// 					"परंतु $"+var1[p]+"="+(term2/cf1==1?"-"+((cf4)/cf1)+"":"-\\dfrac {"+(cf4)/cf1+"}{"+term2/cf1+"}")+"$ हे शक्य नाही (कारण ती त्रिकोणाची बाजू आहे) <br>" +
			// 					"$\\therefore "+var1[p]+"="+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+""+(ans1gcd==1?"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"=\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"$ सेंमी ही एक बाजू आहे <br>" +
			// 					"दुसरी बाजू  $="+var1[p]+"+(\\dfrac {"+diff+"}{"+div+"}) = "+(ans1gcd==1?""+(cf1==1?""+(cf2/cf1)+"":"(\\dfrac {"+cf2+"}{"+cf1+"})")+"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"+(\\dfrac {"+diff+"}{"+div+"})=\\dfrac {"+Chr2[nim]+"}{"+div+"}"+(ans2gcd==1?"":((div/ans2gcd)==1?"="+(Chr2[nim]/div)+"":"=\\dfrac {"+(Chr2[nim]/ans2gcd)+"}{"+(div/ans2gcd)+"}"))+"$ सेंमी <br>" +
			// 					"उरलेल्या दोन बाजू ह्या $"+(ans1gcd==1?""+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"$ सेंमी आणि $"+(ans2gcd==1?"\\dfrac {"+Chr2[nim]+"}{"+div+"}":((div/ans2gcd)==1?""+(Chr2[nim]/div)+"":"\\dfrac {"+(Chr2[nim]/ans2gcd)+"}{"+(div/ans2gcd)+"}"))+"$ सेंमी आहेत हे उत्तर. <br>";
			
			Sol1="#उत्तर: $"+(ans1gcd==1?""+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"$ सेंमी आणि $"+(ans2gcd==1?""+(div==1?""+Chr2[nim]/div+"":"\\dfrac {"+Chr2[nim]+"}{"+div+"}")+"":((div/ans2gcd)==1?""+(Chr2[nim]/div)+"":"\\dfrac {"+(Chr2[nim]/ans2gcd)+"}{"+(div/ans2gcd)+"}"))+"$ सेंमी <br>पायाची किंमत दिलेली नसल्यामुळे आपण पाया $"+var1[p]+"$ सेंमी आहे असे मानू. <br>" +
								"$\\therefore $ उंची $="+var1[p]+"+"+((div/nGcd)==1?""+(diff/div)+"":"\\Bigl(\\dfrac{"+(diff/nGcd)+"}{"+(div/nGcd)+"}\\Bigl)")+"="+((div/nGcd)==1?""+var1[p]+"+"+(diff/div)+"":"\\Bigl(\\dfrac {"+(div/nGcd)+""+var1[p]+"+"+(diff/nGcd)+"}{"+(div/nGcd)+"}\\Bigl)")+" $ सेंमी <br>" +
								"आणि कर्णाची लांबी  $"+((div/nGcd1)==1?""+(Chr3[nim]/div)+"":"\\Bigl(\\dfrac {"+(Chr3[nim]/nGcd1)+"}{"+(div/nGcd1)+"}\\Bigl)")+"$ सेंमी आहे <br>" +
								"म्हणून या काटकोन त्रिकोणासाठी पायथागोरसच्या प्रमेया नुसार <br>" +
								"पाया $^2 +$ उंची $^2 = $ कर्ण $^2$ <br>" +
								"$\\therefore "+var1[p]+"^2+"+((div/nGcd)==1?"("+var1[p]+"+"+(diff/div)+")^2":"\\Bigl(\\dfrac {"+(div/nGcd)+""+var1[p]+"+"+(diff/nGcd)+"}{"+(div/nGcd)+"}\\Bigl)^2")+"="+((div/nGcd1)==1?"("+(Chr3[nim]/div)+")^2":"\\Bigl(\\dfrac {"+(Chr3[nim]/nGcd1)+"}{"+(div/nGcd1)+"}\\Bigl)^2")+"$ . . . .  पायथागोरस प्रमेया नुसार <br>" +
								"$\\therefore "+(((div/nGcd)*(div/nGcd))==1?"":((div/nGcd)*(div/nGcd)))+""+var1[p]+"^2+\\Bigl("+(div/nGcd==1?"":div/nGcd)+""+var1[p]+"+"+(diff/nGcd)+"\\Bigl)^2 ="+(Chr3[nim]/nGcd1)+"^2. . . .$ सरळरूप देवून <br>" +
								"$\\therefore "+(((div/nGcd)*(div/nGcd))==1?"":((div/nGcd)*(div/nGcd)))+""+var1[p]+"^2+"+(div/nGcd==1?"":(div/nGcd)*(div/nGcd))+""+var1[p]+"^2+"+2*(div/nGcd)*(diff/nGcd)+""+var1[p]+"+"+(diff/nGcd)*(diff/nGcd)+" = "+(Chr3[nim]/nGcd1)*(Chr3[nim]/nGcd1)+"$ <br>" +
								"$\\therefore "+(((div/nGcd)*(div/nGcd))+((div/nGcd)*(div/nGcd)))+""+var1[p]+"^2+"+2*(div/nGcd)*(diff/nGcd)+""+var1[p]+""+(nTerm==Math.abs(nTerm) ? "+":"-")+Math.abs(nTerm)+"=0$ <br>" +
								"$\\therefore "+(((((div/nGcd)*(div/nGcd))+((div/nGcd)*(div/nGcd)))/nGcd4)==1?"":((((div/nGcd)*(div/nGcd))+((div/nGcd)*(div/nGcd)))/nGcd4))+""+var1[p]+"^2+"+(((2*(div/nGcd)*(diff/nGcd))/nGcd4)==1?"":((2*(div/nGcd)*(diff/nGcd))/nGcd4))+""+var1[p]+""+(nTerm==Math.abs(nTerm) ? "+":"-")+(Math.abs(nTerm)/nGcd4)+"=0$ <br>" +
								"$\\therefore "+(term2==1?"":""+term2+"")+""+var1[p]+"^2 +"+(result[0]==1?"":""+result[0]+"")+""+var1[p]+"-"+(Math.abs(result[1])==1?"":""+Math.abs(result[1])+"")+""+var1[p]+"-"+term4+"=0 . . . . $ मध्यपदाची फोड करून <br>" +
								"$\\therefore "+(cf1==1?"":cf1)+""+var1[p]+"("+(term2/cf1==1?"":""+term2/cf1+"")+""+var1[p]+"+"+cf4/cf1+")-"+(cf2==1?"":cf2)+"("+(cf5/cf2==1?"":""+cf5/cf2+"")+""+var1[p]+"+"+term4/cf2+")=0$ <br>" +
								"$\\therefore ("+(term2/cf1==1?"":""+term2/cf1+"")+""+var1[p]+"+"+cf4/cf1+")("+(cf1==1?"":cf1)+""+var1[p]+"-"+(cf2==1?"1":cf2)+")=0$ <br>" +
								"$\\therefore "+(term2/cf1==1?"":""+term2/cf1+"")+""+var1[p]+"+"+(cf4/cf1)+"=0$ or $"+(cf1==1?"":cf1)+""+var1[p]+"-"+(cf2==1?"1":cf2)+"=0$ <br>" +
								"$\\therefore "+var1[p]+"="+(term2/cf1==1?"-"+((cf4)/cf1)+"":"-\\dfrac {"+(cf4)/cf1+"}{"+term2/cf1+"}")+"$ किंवा $"+var1[p]+"="+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"$ <br>" +
								"परंतु $"+var1[p]+"="+(term2/cf1==1?"-"+((cf4)/cf1)+"":"-\\dfrac {"+(cf4)/cf1+"}{"+term2/cf1+"}")+"$ हे शक्य नाही (कारण ती त्रिकोणाची बाजू आहे) <br>" +
								"$\\therefore "+var1[p]+"="+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+""+(ans1gcd==1?"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"=\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"$ सेंमी ही एक बाजू आहे <br>" +
								"दुसरी बाजू  $="+var1[p]+"+"+((div/nGcd)==1?""+(diff/div)+"":"\\Bigl(\\dfrac{"+(diff/nGcd)+"}{"+(div/nGcd)+"}\\Bigl)")+" = "+(ans1gcd==1?""+(cf1==1?""+(cf2/cf1)+"":"\\Bigl(\\dfrac {"+cf2+"}{"+cf1+"}\\Bigl)")+"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"+"+((div/nGcd)==1?""+(diff/div)+"":"\\Bigl(\\dfrac{"+(diff/nGcd)+"}{"+(div/nGcd)+"}\\Bigl)")+""+((ans2gcd==1 && div!=1)?"=\\dfrac {"+Chr2[nim]+"}{"+div+"}":((div/ans2gcd)==1?""+((((div/nGcd)==1)&&((ans1gcd==1&&cf1==1)))?"":"")+"="+(Chr2[nim]/div)+"":"=\\dfrac {"+(Chr2[nim]/ans2gcd)+"}{"+(div/ans2gcd)+"}"))+"$ सेंमी <br>" +
								"उरलेल्या दोन बाजू ह्या $"+(ans1gcd==1?""+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"$ सेंमी आणि  $"+((ans2gcd==1 && div!=1)?"\\dfrac {"+Chr2[nim]+"}{"+div+"}":((div/ans2gcd)==1?""+(Chr2[nim]/div)+"":"\\dfrac {"+(Chr2[nim]/ans2gcd)+"}{"+(div/ans2gcd)+"}"))+"$ सेंमी आहेत हे उत्तर. <br>";
			
			
			String Solution = ""+Sol+" "+Sol1+"";
			String Question =""+Que+" "+Que1+"";
			
			Correct_ans="$"+(ans1gcd==1?""+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"$ cm and $"+(ans2gcd==1?""+(div==1?""+Chr2[nim]/div+"":"\\dfrac {"+Chr2[nim]+"}{"+div+"}")+"":((div/ans2gcd)==1?""+(Chr2[nim]/div)+"":"\\dfrac {"+(Chr2[nim]/ans2gcd)+"}{"+(div/ans2gcd)+"}"))+"$ cm <br> #$"+(ans1gcd==1?""+(cf1==1?""+(cf2/cf1)+"":"\\dfrac {"+cf2+"}{"+cf1+"}")+"":((cf1/ans1gcd)==1?"="+(cf2/cf1)+"":"\\dfrac {"+(cf2/ans1gcd)+"}{"+(cf1/ans1gcd)+"}"))+"$ सेंमी आणि $"+(ans2gcd==1?""+(div==1?""+Chr2[nim]/div+"":"\\dfrac {"+Chr2[nim]+"}{"+div+"}")+"":((div/ans2gcd)==1?""+(Chr2[nim]/div)+"":"\\dfrac {"+(Chr2[nim]/ans2gcd)+"}{"+(div/ans2gcd)+"}"))+"$ सेंमी <br>";
			wrong_ans="$"+(cf2==1?""+cf1+"":(cf1%cf2==0?""+cf1/cf2+"":"\\dfrac {"+cf1+"}{"+cf2+"}"))+"$ cm and $"+(ans2gcd==1?""+(div==1?""+Chr2[nim]/div+"":"\\dfrac {"+Chr2[nim]+"}{"+div+"}")+"":((div/ans2gcd)==1?""+(Chr2[nim]/div)+"":"\\dfrac {"+(Chr2[nim]/ans2gcd)+"}{"+(div/ans2gcd)+"}"))+"$ cm <br> #$"+(cf2==1?""+cf1+"":(cf1%cf2==0?""+cf1/cf2+"":"\\dfrac {"+cf1+"}{"+cf2+"}"))+"$ सेंमी आणि $"+(ans2gcd==1?""+(div==1?""+Chr2[nim]/div+"":"\\dfrac {"+Chr2[nim]+"}{"+div+"}")+"":((div/ans2gcd)==1?""+(Chr2[nim]/div)+"":"\\dfrac {"+(Chr2[nim]/ans2gcd)+"}{"+(div/ans2gcd)+"}"))+"$ सेंमी <br>";
			
			wrong_ans1="$"+(div==1?""+(Chr1[nim]+5)+"":((Chr1[nim]+5)%div==0?""+(Chr1[nim]+5)/div+"":"\\dfrac {"+(Chr1[nim]+5)+"}{"+div+"}"))+"$ cm and $"+(div==1?""+(Chr2[nim]+1)+"":((Chr2[nim]+1)%div==0?""+(Chr2[nim]+1)/div+"":"\\dfrac {"+(Chr2[nim]+1)+"}{"+div+"}"))+"$ cm <br> #$"+(div==1?""+(Chr1[nim]+5)+"":((Chr1[nim]+5)%div==0?""+(Chr1[nim]+5)/div+"":"\\dfrac {"+(Chr1[nim]+5)+"}{"+div+"}"))+"$ सेंमी आणि $"+(div==1?""+(Chr2[nim]+1)+"":((Chr2[nim]+1)%div==0?""+(Chr2[nim]+1)/div+"":"\\dfrac {"+(Chr2[nim]+1)+"}{"+div+"}"))+"$ सेंमी <br>";
			
			wrong_ans2="$"+(div%Chr3[nim]==0 ?""+div/Chr3[nim]+"":"\\dfrac {"+(div)+"}{"+Chr3[nim]+"}")+"$ cm and $"+(div%diff==0 ?""+div/diff+"":"\\dfrac {"+(div)+"}{"+diff+"}")+"$ cm <br> # $"+(div%Chr3[nim]==0 ?""+div/Chr3[nim]+"":"\\dfrac {"+(div)+"}{"+Chr3[nim]+"}")+"$ सेंमी आणि $"+(div%diff==0 ?""+div/diff+"":"\\dfrac {"+(div)+"}{"+diff+"}")+"$ सेंमी <br>";

			row.createCell(4).setCellValue(Question);
			row.createCell(5).setCellValue(Correct_ans);
			//				 row.createCell(6).setCellValue(" ");
			//				 row.createCell(7).setCellValue(" ");
			//				 row.createCell(8).setCellValue(" ");
			row.createCell(9).setCellValue(wrong_ans);
			row.createCell(10).setCellValue(wrong_ans1);
			row.createCell(11).setCellValue(wrong_ans2);
			row.createCell(12).setCellValue(420);
			row.createCell(13).setCellValue(5);
			//				  row.createCell(14).setCellValue(" ");
			row.createCell(15).setCellValue("2022.bhushan.kor@ves.ac.in");
				
			//Generate Solution
								
			row.createCell(16).setCellValue(Solution);
			//				  row.createCell(17).setCellValue(" ");
			row.createCell(18).setCellValue(122);

				
			String Checker =""+Solution+""+Correct_ans+""+wrong_ans+""+wrong_ans1+""+wrong_ans2+""+Question+"";
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
