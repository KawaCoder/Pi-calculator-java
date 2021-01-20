import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

        public static void main(String args[]){
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            int hum = 1;
            int i = 0;
            double pi = 0.0;

            while(true){
                date = new Date();
                i++;
                double vactuelle = 0.0;
                if (i%2==0){
                    vactuelle = (double) -4/hum;
                }else{
                    vactuelle = (double) 4/hum;
                }
                hum = hum+2;
                pi = pi + vactuelle;
                System.out.println("[ " +formatter.format(date)+ "] Computing Pi...  "+pi);
            }


        }
    }


