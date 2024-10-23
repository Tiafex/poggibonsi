package sissoko;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {

        Scanner scan = new Scanner(System.in);
        String frase, operazione;

        System.out.println("Client avviato!");
        Socket s = new Socket("172.21.228.91", 3000);
        System.out.println("Client connesso!");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        do {
            System.out.println("1 maiuscolo, 2 minuscolo, 3 inverti, 4 conta caratteri:");
            System.out.println("Scegli operazione: ");
            operazione = scan.nextLine();

            if (operazione.equals("0")) {
                System.out.println("Il client sta terminando");
                out.writeBytes("!" + "\n");
                break;
            }

            System.out.println("inserisci la frase: ");
            frase = scan.nextLine();

            out.writeBytes(operazione + "\n");
            out.writeBytes(frase + "\n");
            out.flush();
            frase = in.readLine();
            System.out.println("Il server ha risposto con " + frase);

        } while (true);

    }
}