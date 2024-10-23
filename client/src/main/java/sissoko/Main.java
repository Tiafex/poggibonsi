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
        String frase, numero;
        int n = 0;
        System.out.println("Client avviato!");
        Socket s = new Socket("localhost", 3000);
        System.out.println("Client connesso!");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        do {
            System.out.println("Inserisci un numero");
            numero = scan.nextLine();

            if (numero.equals("exit")) {
                System.out.println("Il client sta terminando");
                out.writeBytes("EXIT" + "\n");
                break;
            }

            n = Integer.parseInt(numero);
            if (n > 100 || n < 1) {
                System.out.println("errore nel numero inviato");
                break;
            }
            out.writeBytes(n + "\n");
            frase = in.readLine();

            System.out.println("Il server ha risposto con " + frase);

        } while (true);

    }
}