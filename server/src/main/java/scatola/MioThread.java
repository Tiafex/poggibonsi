package scatola;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

public class MioThread extends Thread {
    Socket s;

    public MioThread(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String frase;
            String numero;
            String stringaTrasformata = "";
            int n = 0;
            Random random = new Random();
            int randomico = random.nextInt(100);

            do {

                numero = in.readLine();
                if (numero.equals("EXIT")) {
                    System.out.println("Il client vuole chiudere");
                    s.close();
                    break;
                }
               frase = in.readLine();
                
                
                
                out.writeBytes(stringaTrasformata + "\n");

            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}