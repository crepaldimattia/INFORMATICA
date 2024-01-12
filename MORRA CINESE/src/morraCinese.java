import java.util.Scanner;

public class morraCinese {
    public static void main (String[] args){
    Scanner gioco=new Scanner(System.in);

        //declaration and initialization of variables
        char giocatore1;
        char giocatore2;

        //do-while loop
        do{
            //I take the value of player 1 as input
            System.out.println("Inserisci un elemento: (A=carta, S=sasso, D=forbici e X=STOP)  ");
            giocatore1=gioco.next().charAt(0);

            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //if the values are invalid
            //player 1
            if(giocatore1!='A' && giocatore1!='S' && giocatore1!='D' && giocatore1!='X'){
                //do-while loop
                do{
                    System.out.println("VALORI NON VALIDI");
                    System.out.println("Inserisci un elemento: (A=carta, S=sasso, D=forbici e X=STOP");
                    giocatore1=gioco.next().charAt(0);
                }while (giocatore1!='A' && giocatore1!='S' && giocatore1!='D' && giocatore1!='X');
            }

            //I take the value of player 1 as input
            System.out.println("Inserisci un elemento: (J=carta, K=sasso e L=forbici)  ");
            giocatore2=gioco.next().charAt(0);

            //player 2
            if(giocatore2!='J' && giocatore2!='K' && giocatore2!='L' && giocatore2!='X'){
                //do-while loop
                do {
                    System.out.println("VALORI NON VALIDI");
                    System.out.println("Inserisci un elemento: (J=carta, K=sasso, L=forbici e X=STOP)  ");
                    giocatore2=gioco.next().charAt(0);
                }while(giocatore2!='J' && giocatore2!='K' && giocatore2!='L' && giocatore2!='X');
            }


            //EQUALITY
            if(giocatore1=='A' && giocatore2=='J'){
                System.out.println("PARITA'");
            }
            if(giocatore1=='S' && giocatore2=='K'){
                System.out.println("PARITA'");
            }
            if(giocatore1=='D' && giocatore2=='L'){
                System.out.println("PARITA'");
            }


            //player 1=S and player 2=J
            if(giocatore1=='S' && giocatore2=='J'){
                System.out.println("HA VINTO IL GIOCATORE 1");
            }

            //player 1=D and player 2=J
            if (giocatore1=='S' && giocatore2=='J'){
                System.out.println("HA VINTO IL GIOCATORE 2");
            }

            //player 1=D and player 2=J
            if (giocatore1=='D' && giocatore2=='J'){
                System.out.println("HA VINTO IL GIOCATORE 1");
            }

            //player 1=A and player 2=K
            if (giocatore1=='A' && giocatore2=='K'){
                System.out.println("HA VINTO IL GIOCATORE 1");
            }

            //player 1=D and player 2=K
            if (giocatore1=='D' && giocatore2=='K'){
                System.out.println("HA VINTO IL GIOCATORE 2");
            }

            //player 1=A and player 2=L
            if (giocatore1=='A' && giocatore2=='L'){
                System.out.println("HA VINTO IL GIOCATORE 2");
            }

            //player 1=S and player 2=L
            if (giocatore1=='S' && giocatore2=='L'){
                System.out.println("HA VINTO IL GIOCATORE 1");
            }

            //STOP
            if (giocatore1=='X' || giocatore2=='X'){
                System.out.println("STOP");
            }
        }while(giocatore1!='X' && giocatore2!='X');
    }
}
