package Carti;

import java.io.PrintWriter;

public class Joc {
    public static void main(String[] args) {
        int[] Jucator1 = new int[26];
        int[] Jucator2 = new int[26];
        int[] Carti = new int[52];
        int[] Verif = new int[52];
        for(int i = 0; i<4; i++)
        {
            Atribuie(Carti,i,Verif);
        }
        Shuffle(Carti,Jucator1,Jucator2, Verif);
        Game(Jucator1,Jucator2);
    }

    private static void Game(int[] jucator1, int[] jucator2) {
        PrintWriter scriere = new PrintWriter("JOC.txt");
        do{
          CmpNRw(jucator1,jucator2);
          scriere.write(jucator1[0] + " VS " + jucator2[0]);
        }while(jucator1[0]!=0 || jucator2[0]!=0);
        if(jucator1[0]==0)
            scriere.write("JUCATORUL 2 ESTE CASTIGATOR!!!!!!!!!!");
        else
            scriere.write("JUCATORUL 1 ESTE CASTIGATOR!!!!!!!!!!");
        scriere.close();

    }

    private static void CmpNRw(int[] jucator1, int[] jucator2) {
        if(jucator1[0]>jucator2[0])
        {
            Rw1(jucator1, jucator2);
        }
        else if(jucator1[0]<jucator2[0])
            Rw2(jucator1, jucator2);
        else
            Runda(jucator1,jucator2);
    }

    private static void Runda(int[] jucator1, int[] jucator2) {
    }

    private static void Rw1(int[] jucator1, int[] jucator2) {
        jucator1 = new int[28];
        jucator1[26]=jucator1[0];
        jucator1[27]=jucator2[0];
        for(int i=0; i<26; i++)
            jucator1[i]=jucator1[i+1];
        for(int i =0; i<26; i++)
            jucator2[i]=jucator2[i+1];
    }

    private static void Rw2(int[] jucator1, int[] jucator2) {
        jucator2 = new int[28];
        jucator1[26]=jucator1[0];
        jucator1[27]=jucator2[0];
        for(int i=0; i<26; i++)
            jucator1[i]=jucator1[i+1];
        for(int i =0; i<26; i++)
            jucator2[i]=jucator2[i+1];
    }

    private static void Atribuie(int[] Carti, int i, int[] Verif) {
        int k =0;
        for(int j = 13*i; j<(13*i)+13; j++)
        {
            Carti[j]=k+1;
            Verif[j]=1;
            k++;
        }
    }

    private static void Shuffle(int[] Carti, int[] Jucator1, int[] Jucator2, int[] Verif) {
        GiveTo1(Jucator1, Carti, Verif);
        GiveTo2(Jucator2, Carti, Verif);
    }

    private static void GiveTo1(int[] Jucator1, int[] Carti, int[] Verif) {
        int check;

        for(int i = 0; i<26; i++)
        {
            do {
                int x = GenerareNumar();
                check = CautaSiBifeaza(x, Carti, Verif);
                if(check!=0) break;
            }while(check==0);

            if(check!=0)
            {
                Jucator1[i]=check;
            }
        }
    }

    private static void GiveTo2(int[] Jucator2, int[] Carti, int[] Verif) {
        int check;

        for(int i = 0; i<26; i++) {
            do {
                int x = GenerareNumar();
                check = CautaSiBifeaza(x, Carti, Verif);
                if(check!=0) break;
            }while(check==0);

            if(check!=0)
            {
                Jucator2[i]=check;
            }
        }
    }

    private static int CautaSiBifeaza(int x, int[] Carti, int[] Verif) {
        int gasit = 0;
        for(int i = 0;i<52; i++)
        {
            if(Carti[i]==x && Verif[i]==1)
            {
                Verif[i]=0;
                gasit=x;
                break;
            }
        }
        return gasit;
    }

    private static int GenerareNumar() {
        int random =  (int) (Math.random()*13);
        random+=1;
        return random;
    }
}
