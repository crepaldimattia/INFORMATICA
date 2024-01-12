import java.util.*;

public class Sfida {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        Random casuale=new Random();

        //variable declaration and initialization
        int testaOCroce;
        int sceltaBego;
        int sceltaChiarion;
        int facciaMoneta;

        //choice output
        System.out.println("Bego, scegli tra testa(0) o croce(1): ");
        sceltaBego=tastiera.nextInt();

        //if the choice is =0
        if(sceltaBego==0){
            sceltaChiarion=1;
        } else{
            sceltaChiarion=0;
        }

        testaOCroce = casuale.nextInt();
        //if choice =0
        if(testaOCroce%2==0){
        facciaMoneta=0;
        } else {
        facciaMoneta=1;
        }

        //final output
        if(facciaMoneta==sceltaBego){
            System.out.println("Ha vinto Bego");
        } else{
            System.out.println("Ha vinto Chiarion");
        }
    }
}