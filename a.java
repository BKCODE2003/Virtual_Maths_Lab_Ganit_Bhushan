public class a {
    public static void main(String[] args){


        String ans="Ans : Correct answer $"+pos_marks+"$ "+(pos_marks==1 || pos_marks==-1? "mark":"marks")+" and wrong answer $"+neg_marks+"$ "+(neg_marks==1 || neg_marks==-1? "mark":"marks")+". <br>" + //
                        "Let us assume that correct answer gets $x$ marks and wrong answer gets $y$ marks. <br>" + //
                        "As Rukhsana answered $"+correct_attempt+"$ correct and $"+wrong_attempt+"$ wrong answers, her score will be <br>" + //
                        "$"+correct_attempt+"x+"+wrong_attempt+"y="+score+" . . . . . (i)$ <br>" + //
                        "and Rashmika answered $"+correct_attempt1+"$ correct and $"+wrong_attempt1+"$  wrong answers, her score can be written as <br>" + //
                        "$"+correct_attempt1+"x+"+wrong_attempt1+"y="+score1+" . . . . . (ii)$ <br>" + //
                        "Since unattempted answers to not contribute (same as carrying $0$ marks), we will not worry about the number of unanswered questions. <br>" + //
                        "From equation $(i)$ we get the value of $x$ in terms of $y$ as <br>" + //
                        "$x= \\dfrac {"+score+"-"+wrong_attempt+"y}{"+correct_attempt+"}$ <br>" + //
                        "Substituting this value of $x$ in equation $(ii)$ we get,<br>" + //
                        "$"+correct_attempt1+"\\times \\dfrac {"+score+"-"+wrong_attempt+"y}{"+correct_attempt+"} +"+wrong_attempt1+"y="+score1+"$ <br>" + //
                        "$\\dfrac {"+(correct_attempt1*score)+"-"+(correct_attempt1*wrong_attempt)+"y}{"+correct_attempt+"}+"+wrong_attempt1+"y="+score1+"$ <br>" + //
                        "$\\therefore "+(correct_attempt1*score)+"-"+(correct_attempt1*wrong_attempt)+"y+"+(wrong_attempt1*correct_attempt)+"y= "(correct_attempt*score1)"$ . . . .  by simplyfying<br>" + //
                        "$\\therefore "+((wrong_attempt1*correct_attempt)-(correct_attempt1*wrong_attempt))+"y = "+((correct_attempt*score1)-(correct_attempt1*score))+"$<br>" + //
                        "$\\therefore y="+((correct_attempt*score1)-(correct_attempt1*score))/((wrong_attempt1*correct_attempt)-(correct_attempt1*wrong_attempt))+"$ which gives the marks for wrong answer.<br>" + //
                        "By putting this value of $y$ in equation $(i)$ we get<br>" + //
                        "$"+correct_attempt+"x+\\{"+wrong_attempt+" \\times ("+((correct_attempt*score1)-(correct_attempt1*score))/((wrong_attempt1*correct_attempt)-(correct_attempt1*wrong_attempt))+")\\}= "+score+"$<br>" + //
                        "$\\therefore "+correct_attempt+"x= "+score+"+"+((-1)*(wrong_attempt)*((correct_attempt*score1)-(correct_attempt1*score))/((wrong_attempt1*correct_attempt)-(correct_attempt1*wrong_attempt)))+"="+((score)+((-1)*(wrong_attempt)*((correct_attempt*score1)-(correct_attempt1*score))/((wrong_attempt1*correct_attempt)-(correct_attempt1*wrong_attempt))))+"$  . . . .  by simplyfying <br>" + //
                        "$\\therefore x="+((score)+((-1)*(wrong_attempt)*((correct_attempt*score1)-(correct_attempt1*score))/((wrong_attempt1*correct_attempt)-(correct_attempt1*wrong_attempt))))+"$ which gives the marks for correct answer. <br>" + //
                        "Thus correct answer carries $"+pos_marks+"$ marks and wrong answer carries $"+neg_marks+"$ mark is the answer. <br> #" + //
                        "उत्तर : बरोबर उत्तर $2$ गुण आणि चूक उत्तर $-1$ गुण. <br> " + //
                        "आपण बरोबर उत्तरासाठी $x$ गुण आणि चूक उत्तरासाठी $y$ गुण मिळतील असे मानू. <br>" + //
                        "रुखसानाची $43$ उत्तरे बरोबर आणि $12$ उत्तरे चूक आहेत, म्हणून तिला मिळालेले एकूण गुण <br>" + //
                        "$43x+12y=74 . . . . . (i)$ असे असतील. <br>" + //
                        "आणि रश्मीकाने $65$ उत्तरे बरोबर आणि $26$ उत्तरे चूक आहेत, म्हणून तिला मिळालेले एकूण गुण <br>" + //
                        "$65x+26y=104 . . . . . (ii)$ असे असतील. <br>" + //
                        "उत्तर न दिलेले  प्रश्न विचारात घेतले नाहीत म्हणजेच त्यांना प्रत्येक $0$ गुण आहेत. <br>" + //
                        "समीकरण $(i)$ वरून आपण $x$  ची किंमत $y$ च्या रूपात <br>" + //
                        "$x= \\dfrac {74-12y}{43}$ अशी लिहू शकतो. <br>" + //
                        "$x$ ची ही किंमत समीकरण $(ii)$ मध्ये ठेवून आपल्याला,<br>" + //
                        "$65\\times \\dfrac {74-12y}{43} +26y=104$ असे मिळते. <br>" + //
                        "$\\dfrac {4810-780y}{43}+26y=104$<br>" + //
                        "$\\therefore 4810-780y+1118y= 4472$ . . . .  सोडवून आणि सरळ रूप देऊन<br>" + //
                        "$\\therefore 338y = -338$<br>" + //
                        "$\\therefore y=-1$ हे चूक उत्तरासाठी असलेले गुण आहेत. ( म्हणजे चूक उत्तरासाठी $1$ गुण वजा होतो. )<br>" + //
                        "$y$ ची ही किंमत समीकरण $(i)$ ठेवून आपल्याला <br>" + //
                        "$43x+\\{12 \\times (-1)\\}= 74$ असे मिळते. <br>" + //
                        "$\\therefore 43x= 74+12=86$ . . . . . सोडवून आणि सरळ रूप देऊन <br>" + //
                        "$\\therefore x=2$ हे बरोबर उत्तरासाठी असलेले गुण आहेत.<br>" + //
                        "म्हणजे बरोबर उत्तरासाठी $2$ गुण आणि  चूक उत्तरासाठी $-1$ गुण हे उत्तर. <br>";
    }
}
