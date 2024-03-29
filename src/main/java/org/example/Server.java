package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String... args) {
        int port = 8081;
        try (ServerSocket serverSocket = new ServerSocket(port);) { // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ) {
                // ваш код

                System.out.println("New connection accepted");

                final String name = in.readLine();

                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}