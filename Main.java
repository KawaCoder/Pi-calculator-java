import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static String pistr = "";
    public static String actualpistr = "3.141592653589793";
    public static double pi = 0.0;
    public static long startTime;
    public static long endTime;




    public static void GregoryLeibniz(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        int hum = 1;
        int i = 0;

        startTime = System.currentTimeMillis();
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
            if (pi == 3.1415928191281157){
                endTime = System.currentTimeMillis();
                break;
            }
        }



    }




    public static void Gauss_method(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


        double A = 1;
        double X = A;
        double B = 1/1.414213562;
        double C = 0.25;
        double Y = A;
        String pistr = "";
        String actualpistr = "3.141592653589793";

        startTime = System.currentTimeMillis();
        for (int i = 0; i<3; i++){
            Y = A;
            A = (A + B) / 2;

            B = Math.sqrt(B * Y);
            C = C - (X * Math.pow(A - Y, 2));
            X = 2 * X;
            pi = (Math.pow(A + B, 2) / (4 * C));

            System.out.println("[ " +formatter.format(date)+ "] Computing Pi...  "+pi);
        }
        endTime = System.currentTimeMillis();

    }





    public static void Nilakantha(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


        int hum = 2;
        double i = 1.0;
        pi = 3.0;

        startTime = System.currentTimeMillis();
        while(true){
            i++;
            double vactuelle = 0.0;
            if (i%2==0){
                vactuelle = (double) 4/((hum)*(hum+1)*(hum+2));

            }else{
                vactuelle = (double)  -4/((hum)*(hum+1)*(hum+2));

            }
            hum = hum + 2;
            pi = pi + vactuelle;

            System.out.println("[ " +formatter.format(date)+ "] Computing Pi...  "+pi);
            if (i > 10000 && pi > 3.1415 && pi < 3.1416){
                endTime = System.currentTimeMillis();
                break;

            }

        }

    }



    public static void main(String args[]){
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Calcul method:\n[1]-Gregory-Leibniz series\n[2]-Nilakantha series\n[3]-Gauss algorithm");
            int reponse = sc.nextInt();
            //long startTime = System.currentTimeMillis();
            if (reponse == 1) {
                Main.GregoryLeibniz();
            } else if (reponse == 2) {
                Main.Nilakantha();
            } else if (reponse == 3) {
                Main.Gauss_method();
            }

            //long endTime = System.currentTimeMillis();
            pistr = String.valueOf(pi);
            System.out.println("\n\n\nBetter aproximation of pi value found: " + pi);
            System.out.println("Calculated in ~" + (endTime - startTime) + "ms.");

            int i = 0;
            while (true) {
                if (pistr.charAt(i) == actualpistr.charAt(i)) {
                    i++;

                } else {
                    System.out.println("Precision: " + (i - 1) + " rights for " + (pistr.length() - 1) + " digits given.\n\n\n");
                    break;
                }
            }


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}


