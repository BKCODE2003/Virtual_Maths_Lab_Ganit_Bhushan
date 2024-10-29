import java.util.HashMap;
import java.util.Random;

public class SpeedDistanceQuestionGenerator {

    public static void main(String[] args) {
        int numberOfQuestions = 200;
        generateQuestions(numberOfQuestions);
    }

    public static void generateQuestions(int count) {
        int mapsize,mapsizeafter;
		HashMap<String, Integer> map = new HashMap<String, Integer> ();
        for (int i = 1; i <= count; i++) {
            
            int a=(int)(Math.random()*30+1); 
            int b=(int)(Math.random()*30+1); 
            int c=(int)(Math.random()*8+1); 
            int dis=a*c-b*c;

            while(a<b || dis<(a+b+5) || dis!=a*c-b*c){
                a=(int)(Math.random()*30+1); 
                b=(int)(Math.random()*30+1); 
                c=(int)(Math.random()*8+1); 
                dis=a*c-b*c;
            }
            int betDis=a+b;

            String Checker =""+a+""+b+""+c+""+dis+""+betDis+"";
			mapsize = map.size();
			map.put(Checker,i);
			mapsizeafter = map.size();
            System.out.println("Question " + i + ": A=" + a + " B="+b+" C="+c+" Dis="+dis+" BetDis="+betDis+"");				
			//In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
			if(mapsize == mapsizeafter) {
				System.out.println("----------------------------------------");
				System.out.println(Checker);
                System.out.println("----------------------------------------");
				i--;
			}

            
          
            
        }
    }
}
