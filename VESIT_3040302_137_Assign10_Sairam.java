
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VESIT_3040302_137_Assign10_Sairam {
    public static void main(String args[]) throws IOException, FileNotFoundException {
        String filename = "D:/excel files/VESIT_3040302_137_Assign10_Sairam.xlsx";     //Location where excel file is getting generated
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Instruction");      //Generating first sheet as Instruction

        XSSFSheet sheet1 = workbook.createSheet("Questions");       //Generating second sheet as Questions

        //Adding first row in second sheet(Questions)
        String[] header = {"Sr. No", "Question Type", "Answer Type", "Topic Number", "Question (Text Only)", "Correct Answer 1", "Correct Answer 2",
                "Correct Answer 3", "Correct Answer 4", "Wrong Answer 1", "Wrong Answer 2", "Wrong Answer 3", "Time in seconds", "Difficulty Level",
                "Question (Image/ Audio/ Video)", "Contributor's Registered mailId", "Solution (Text Only)", "Solution (Image/ Audio/ Video)", "Variation Number"};
        XSSFRow rowhead = sheet1.createRow((short) 0);

        //Set height and width to the column and row
        sheet1.setColumnWidth(4, 35 * 250);
        sheet1.setColumnWidth(16, 45 * 250);

        //Adding header to the second sheet
        for (int head = 0; head < header.length; head++) {
            rowhead.createCell(head).setCellValue(header[head]);

        }

        //Taking input for number of question you want to generate
        System.out.println("How many question you want to enter:-");
        Scanner sc = new Scanner(System.in);
        int mapsize, mapsizeafter;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int q = sc.nextInt();
        for (int k = 1; k < q + 1; k++) {
            // Create row
            XSSFRow row = sheet1.createRow(k);
            row.createCell(0).setCellValue(k);
            row.createCell(1).setCellValue("Text");
            row.createCell(2).setCellValue(1);
            row.createCell(3).setCellValue("3040302");

            // Generate random number to perform the operation
            int cmax = 10;
            int cmin = 1;
            int pmax = 4;
            int pmin = 0;

            int[] coefficients1 = new int[2];
            int[] coefficients2 = new int[2];

            for(int i = 0; i < 2; i++){
                coefficients1[i] = (int)(Math.random()*(cmax-cmin+1)+cmin);
            }
            for(int i = 0; i < 2; i++){
                coefficients2[i] = (int)(Math.random()*(cmax-cmin+1)+cmin);
                for(int j = 0; j < 2; j++){
                    while(coefficients2[i] == coefficients1[j]) {
                        coefficients2[i] = (int)(Math.random()*(cmax-cmin+1)+cmin);
                    }
                }
            }

            int[][] powers1 = new int[2][2];
            int[][] powers2 = new int[2][2];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    powers1[i][j] = (int) (Math.random() * (pmax - pmin + 1) + pmin);
                    powers2[i][j] = (int) (Math.random() * (pmax - pmin + 1) + pmin);
                }
            }

            for (int i = 0; i < 2; i++) {
                while ((powers1[i][0] + powers1[i][1]) > 4) {
                    if (powers1[i][0] > powers1[i][1]) {
                        powers1[i][0]--;
                    } else {
                        powers1[i][1]--;
                    }
                }
                while ((powers2[i][0] + powers2[i][1]) > 4) {
                    if (powers2[i][0] > powers2[i][1]) {
                        powers2[i][0]--;
                    } else {
                        powers2[i][1]--;
                    }
                }
            }
            while(powers1[0][0] == powers1[1][0] && powers1[0][1] == powers1[1][1]){
                if(powers1[1][1]==0 && powers1[1][0] != 4){
                    powers1[1][1]++;
                } else if(powers1[1][1] == 0 && powers1[1][0] == 4){
                    powers1[1][0]--;
                }else {powers1[1][1]--;}
            }
            while(powers2[0][0] == powers2[1][0] && powers2[0][1] == powers2[1][1]){
                if(powers2[1][1]==0 && powers2[1][0] != 4){
                    powers2[1][1]++;
                } else if(powers2[1][1]==0 && powers2[1][0] == 4){
                    powers2[1][0]--;
                } else {powers2[1][1]--;}
            }

            int index = (int)(Math.random()*(2));
            int place = (int)(Math.random()*(2));


            if (!(powers1[0][0] == powers2[index][0] && powers1[0][1] == powers2[index][1]) || (powers1[1][0] == powers2[index][0] && powers1[1][1] == powers2[index][1])){
                powers1[place][0] = powers2[index][0];
                powers1[place][1] = powers2[index][1];
            } else if(powers2[index][0] == powers1[0][0] && powers2[index][1] == powers1[0][1]){
                place = 0;
            } else if(powers2[index][0] == powers1[1][0] && powers2[index][1] == powers1[1][1]){
                place = 1;
            }


            String[] variables = {"a", "b", "c", "d", "f", "g", "h", "m", "n", "p","s", "t", "u", "v", "w", "x", "y","z" };
            int temp = (int)(Math.random()*(17));
            int[] alphaIndex = new int[2];
            alphaIndex[0] = temp;
            alphaIndex[1] = temp+1;

            String[] terms = new String[4];
            for(int i = 0; i < 2; i++){
                terms[i] = constructPolynomialTerm(coefficients1[i], powers1[i], alphaIndex, variables);
            }
            for(int i = 2, j = 0; i < 4 && j < 2; i++,j++){
                terms[i] = constructPolynomialTerm(coefficients2[j], powers2[j], alphaIndex, variables);
            }

            String questionTerm = constructPolynomialTerm(coefficients2[index], powers2[index], alphaIndex, variables);

            String correctAnswer = constructPolynomialTerm(coefficients1[place], powers1[place], alphaIndex, variables);

            String[] wrongAnswers = new String[4];
            int wPlace = 0;
            if(place == 0){
                wPlace = 1;
            }
            int wIndex = 0;
            if(index == 0){
                wIndex = 1;
            }
            wrongAnswers[0] = "$" + constructPolynomialTerm(coefficients1[wPlace], powers1[wPlace], alphaIndex, variables) + "$";
            wrongAnswers[1] = "$" + questionTerm + "$";
            String s1 = "Any of the given<br>#दिलेल्या पैकी कोणतेही";
            String s2 = "None of the given <br>#दिलेल्या पैकी कोणतेही नाही";
            String s3 = "No term will appear<br>#कोणतेही पद येणार नाही";
            int random = (int)(Math.random()*(3));
            if(random == 0){
                wrongAnswers[2] = s1;
            } else if(random == 1){wrongAnswers[2] = s2;} else if (random == 2) {
                wrongAnswers[2] = s3;
            }
            wrongAnswers[3] = "$" + constructPolynomialTerm(coefficients2[wIndex], powers2[wIndex], alphaIndex, variables) + "$";

            int[] wrongIndex = new int[3];
            Set<Integer> uniqueIndices = new HashSet<>();

            for (int i = 0; i < 3; i++) {
                int newIndex;
                do {
                    newIndex = (int) (Math.random() * 4);
                } while (!uniqueIndices.add(newIndex));
                wrongIndex[i] = newIndex;
            }


            String[] binomials = new String[2];
            for(int i = 0, j = 0; i < 2 && j < 4; i++, j+=2){
                binomials[i] = constructBinomial(terms[j], terms[j+1]);
            }

            String questionE = "In vertical arrangement method for addition of $"+binomials[0]+"$ and $"+binomials[1]+"$ which term will appear above $"+questionTerm+"$? <br>";
            String questionM = "#उभी मांडणी पद्धतीने $"+binomials[0]+"$ आणि $"+binomials[1]+"$ या राशींची बेरीज करतांना $"+questionTerm+"$ या पदाच्या रकान्यात $"+questionTerm+"$ या पदाच्या वर $"+binomials[1]+"$ या राशीतील कोणते पद येईल?<br>";
            String question = questionE + questionM;

            row.createCell(4).setCellValue(question);
            row.createCell(5).setCellValue("$"+correctAnswer + "$<br>");
            row.createCell(6).setCellValue(" ");
            row.createCell(7).setCellValue(" ");
            row.createCell(8).setCellValue(" ");
            row.createCell(9).setCellValue(wrongAnswers[wrongIndex[0]] + "<br>");
            row.createCell(10).setCellValue(wrongAnswers[wrongIndex[1]] + "<br>");
            row.createCell(11).setCellValue(wrongAnswers[wrongIndex[2]] + "<br>");
            row.createCell(12).setCellValue(60);
            row.createCell(13).setCellValue(2);
            row.createCell(14).setCellValue(" ");
            row.createCell(15).setCellValue("2022.sairam.konar@ves.ac.in");

            //Generate Solution
            String vArrange = "";

            if(index == 0 && place == 0){
                if(powers1[1][0] == powers2[1][0] && powers1[1][1] == powers2[1][1]){
                    vArrange = "$\\begin{alignat*}1&\n" +
                            "& " + terms[0] + " &{}+{}& " + terms[1] + "  \\\\\n" +
                            "&+& \\quad " + terms[2] + " &{}+{}& " + terms[3] + "  \\\\\n" +
                            "\\hline \\\\\n" +
                            "\\end{alignat*}$ <br>";
                } else {
                    vArrange = "$\\begin{alignat*}1&\n" +
                            "& " + terms[0] + " &{}+{}& " + terms[1] + "  \\\\\n" +
                            "&+& \\quad " + terms[2] + " &{}{}&&{}+{}& " + terms[3] + "  \\\\\n" +
                            "\\hline \\\\\n" +
                            "\\end{alignat*}$ <br>";
                }
            } else if(index == 1 && place == 0){
                if(powers1[1][0] == powers2[0][0] && powers1[1][1] == powers2[0][1]){
                    vArrange = "$\\begin{alignat*}1&\n" +
                            "& " + terms[0] + " &{}+{}& " + terms[1] + "  \\\\\n" +
                            "&+& \\quad " + terms[3] + " &{}+{}& " + terms[2] + "  \\\\\n" +
                            "\\hline \\\\\n" +
                            "\\end{alignat*}$ <br>";
                } else {
                    vArrange = "$\\begin{alignat*}1&\n" +
                            "& " + terms[0] + " &{}+{}& " + terms[1] + "  \\\\\n" +
                            "&+& \\quad " + terms[3] + " &{}{}&&{}+{}& " + terms[2] + "  \\\\\n" +
                            "\\hline \\\\\n" +
                            "\\end{alignat*}$ <br>";
                }
            } else if(index == 0 && place == 1){
                if(powers1[0][0] == powers2[1][0] && powers1[0][1] == powers2[1][1]){
                    vArrange = "$\\begin{alignat*}1&\n" +
                            "& " + terms[0] + " &{}+{}& " + terms[1] + "  \\\\\n" +
                            "&+& \\quad " + terms[3] + " &{}+{}& " + terms[2] + "  \\\\\n" +
                            "\\hline \\\\\n" +
                            "\\end{alignat*}$ <br>";
                } else {
                    vArrange = "$\\begin{alignat*}1&\n" +
                            "& " + terms[0] + " &{}+{}& " + terms[1] + "  \\\\\n" +
                            "&+& \\quad {}&&{}" + terms[2] + " &{}+{}& " + terms[3] + "  \\\\\n" +
                            "\\hline \\\\\n" +
                            "\\end{alignat*}$ <br>";
                }
            } else if(index == 1 && place == 1){
                if(powers1[0][0] == powers2[0][0] && powers1[0][1] == powers2[0][1]){
                    vArrange = "$\\begin{alignat*}1&\n" +
                            "& " + terms[0] + " &{}+{}& " + terms[1] + "  \\\\\n" +
                            "&+& \\quad " + terms[2] + " &{}+{}& " + terms[3] + "  \\\\\n" +
                            "\\hline \\\\\n" +
                            "\\end{alignat*}$ <br>";
                } else {
                    vArrange = "$\\begin{alignat*}1&\n" +
                            "& " + terms[0] + " &{}+{}& " + terms[1] + "  \\\\\n" +
                            "&+& \\quad {}&&{}" + terms[3] + " &{}+{}& " + terms[2] + "  \\\\\n" +
                            "\\hline \\\\\n" +
                            "\\end{alignat*}$ <br>";
                }
            }

            String solutionE = "Ans : $"+correctAnswer+"$<br> In vertical addition method, the arrangement of terms is as described below, <br> Like terms from all the given expressions are required to be written in one column.<br> Accordingly for $"+questionTerm+"$ the like term in the first expression is $"+correctAnswer+"$<br>The vertical arrangement for the following is as follows:<br>"+vArrange+"$\\therefore$ As shown in the arrangement, the term $"+correctAnswer+"$ from the first expression will appear above $"+questionTerm+"$ from the second expression, is the answer.<br># ";
            String solutionM = "उत्तर : $"+correctAnswer+"$<br> उभी मांडणी पद्धतीने बेरीज करतांना दिलेल्या सर्व बैजिक राशीतील पदांची मांडणी करण्याची पद्धत खाली दिल्या नुसार असते.<br> सर्व राशीतील सजातीय पदे एकाच रकान्यात एका खाली एक अशी लिहितात.<br> त्यानुसार $"+questionTerm+"$ या पदाच्या रकान्यात  त्या खाली पहिला राशीतील $"+correctAnswer+"$ हे पद येईल कारण $"+questionTerm+"$ आणि $"+correctAnswer+"$ ही सजातीय पदे आहेत.<br> या बेरजेसाठी उभी मांडणी खालील प्रमाणे आहे: <br>"+vArrange+"$\\therefore$ वर दाखविलेल्या मांडणी वरून पहिल्या राशीतील $"+correctAnswer+"$ हे पद दुसऱ्या राशीतील $"+questionTerm+"$ या पदाच्या वर येईल हे उत्तर. <br>";
            String solution = solutionE + solutionM;
            row.createCell(16).setCellValue(solution);
            row.createCell(17).setCellValue(" ");
            row.createCell(18).setCellValue(137);

            mapsize = map.size();
            map.put(question, k);
            mapsizeafter = map.size();

            //In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
            if (mapsize == mapsizeafter) {
                System.out.println("duplicate Question" + k + ". " + question);
                k--;
            }

            if (correctAnswer.equals(wrongAnswers[wrongIndex[0]]) || correctAnswer.equals(wrongAnswers[wrongIndex[1]]) || correctAnswer.equals(wrongAnswers[wrongIndex[2]]) || wrongAnswers[wrongIndex[0]].equals(wrongAnswers[wrongIndex[1]]) || wrongAnswers[wrongIndex[0]].equals(wrongAnswers[wrongIndex[2]]) || wrongAnswers[wrongIndex[1]].equals(wrongAnswers[wrongIndex[2]])) {
                System.out.println("duplicate" + k);
                k--;
            }


        }


        int rowTotal = sheet1.getLastRowNum();
//			  System.out.println(rowTotal);
        XSSFRow row = sheet1.createRow( rowTotal + 1);
        row.createCell(0).setCellValue("****");

        //Writing data to the file
        FileOutputStream fileout = new FileOutputStream(filename);
        workbook.write(fileout);
        fileout.close();

        System.out.println("file created");

    }

    static String constructPolynomialTerm(int coefficient, int[] powers, int[] alphaIndex, String[] variables) {
        StringBuilder polynomialBuilder = new StringBuilder();
        String coefficientSign = (coefficient > 0) ? "" : "-";
        polynomialBuilder.append(coefficientSign);
        if (powers[0] == 0 && powers[1] == 0){
            polynomialBuilder.append(Math.abs(coefficient));
        } else if (Math.abs(coefficient) != 1){
            polynomialBuilder.append(Math.abs(coefficient));
        }
        String variable = (powers[0] == 0 && powers[1] == 0) ? "" : (powers[0] == 1 && powers[1] == 1) ? variables[alphaIndex[0]] + "" + variables[alphaIndex[1]] : (powers[0] == 0) ? (powers[1] == 1) ? variables[alphaIndex[1]] : variables[alphaIndex[1]] +"^"+ powers[1] : (powers[1] == 0) ? (powers[0] == 1) ? variables[alphaIndex[0]] : variables[alphaIndex[0]] +"^"+ powers[0] : (powers[0] == 1) ? variables[alphaIndex[0]] +""+ variables[alphaIndex[1]] + "^" +powers[1] : (powers[1] == 1) ? variables[alphaIndex[0]] +"^"+ powers[0] + "" + variables[alphaIndex[1]] : variables[alphaIndex[0]] +"^"+ powers[0] + "" + variables[alphaIndex[1]] +"^"+ powers[1];
        polynomialBuilder.append(variable);
        return polynomialBuilder.toString();
    }

    static String constructBinomial(String term1, String term2){
        StringBuilder binomialBuilder = new StringBuilder();
        binomialBuilder.append(term1);
        if(!term2.contains("-")){
            binomialBuilder.append("+");
        }
        binomialBuilder.append(term2);
        return binomialBuilder.toString();
    }
}