package pl.emil;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double sumaDrogi=0,odlegloscDoPierwszego;
        int sasiad=0;
        int x,y;
        int iloscPkt;
        int punktStart;
        double[][] wspolrzedne = new double[100][100];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ilosc punktow: ");
        iloscPkt=scanner.nextInt();
        System.out.println("podaj wspolrzedne x i y tych punktow: ");

        for (int i=0,j=1; i<iloscPkt; i++,j++)
        {
            System.out.println("PUNKT " + j + " - " + "wpolrzedna x" + ": ");
            x=scanner.nextInt();
            wspolrzedne[i][0]=x;
            System.out.println("PUNKT " + j + " - " + "wpolrzedna y" + ": ");
            y=scanner.nextInt();
            wspolrzedne[i][1]=y;
        }

        System.out.println("Punkt startowy: ");
        punktStart=scanner.nextInt();
        System.out.print(punktStart);

        punktStart--;

        boolean[] odwiedzone = new boolean[iloscPkt];
        for(int i=0;i<iloscPkt;i++)
            odwiedzone[i]=false;

        odwiedzone[punktStart]=true;


        int temp = punktStart;


        double dystans;
        double najblizszaOdleglosc;
        boolean pierwszy = true;

        for(int i=0; i<iloscPkt-1; i++){
            double x1=wspolrzedne[temp][0];
            double y1=wspolrzedne[temp][1];
            najblizszaOdleglosc = 0;

            for(int j=0; j<iloscPkt; j++) {
                if(!odwiedzone[j]) {
                    dystans= odleglosc(x1,wspolrzedne[j][0],y1,wspolrzedne[j][1]);

                    if(pierwszy){
                        pierwszy = false;
                    }

                    if(((dystans > 0) && (najblizszaOdleglosc > 0) && (dystans < najblizszaOdleglosc)) || (najblizszaOdleglosc == 0)) {
                        najblizszaOdleglosc = dystans;
                        sasiad=j;
                    }
                }
            }
            sumaDrogi += najblizszaOdleglosc;
            temp = sasiad;
            odwiedzone[temp] = true;
            System.out.print(" -> " + (sasiad+1));
        }

        System.out.println(" -> "+ (punktStart+1));

        odlegloscDoPierwszego= odleglosc(wspolrzedne[punktStart][0],wspolrzedne[sasiad][0],wspolrzedne[punktStart][1],wspolrzedne[sasiad][1]); //odleglosc z ostatniego pkt do pkt 1 startowego
        System.out.println("Calkowita dlugosc trasy: " + (odlegloscDoPierwszego+sumaDrogi));
        scanner.close();
    }

    private static double odleglosc(double x1, double x2, double y1, double y2) {

        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }
}