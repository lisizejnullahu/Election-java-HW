import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Election {
    

    public static void main(String [] args) {
        ArrayList< ArrayList<Integer> > votimet = new ArrayList<>(3);
        Scanner kandidati = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            ArrayList<Integer> kandidatet = new ArrayList<>();
            System.out.println("Votoni per regjionin: " + i + "!!!");
            for(int j = 0; j < 4; j++) {
                System.out.println("Shenoni voten per kandidatin " + j + ": ");
                kandidatet.add(kandidati.nextInt());
            }
            votimet.add(kandidatet);
        }
        int [] votatEnumeruara = {0, 0, 0, 0};

        for (int i = 0; i < votimet.get(0).size(); i++) {
            for (int j = 0; j < votimet.size(); j++) {
                votatEnumeruara[i] += votimet.get(j).get(i);
            }
        }

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("eleksionet.txt"));
            for (int i = 0; i < votimet.size(); i++) {
                for (int j = 0; j < votimet.get(0).size(); j++) {
                    writer.println("Reg" + i + "Cand" + j + " " + votatEnumeruara[j]);
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
}

