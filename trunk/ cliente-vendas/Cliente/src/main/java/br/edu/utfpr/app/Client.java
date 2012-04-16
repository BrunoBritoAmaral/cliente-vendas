package br.edu.utfpr.app;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) {
        /*if(args.length < 3){
            System.err.println("Usage: java udp.Client <ip address> <port> <message>");
            System.exit(-1);
        }*/

        try{
            InetAddress addr = InetAddress.getByName("localhost");
            int port = Integer.parseInt("56550");
           // String message = "exit";
            String message = "00Este é uma mensagem enviada pelo cliente";

            DatagramSocket socket = new DatagramSocket();
            
            //socket.connect(addr,port);
            
            DatagramPacket datagram1 = new DatagramPacket(message.getBytes(),message.getBytes().length,addr,port);
            
            //DatagramPacket datagram1 = new DatagramPacket(message.getBytes(),0,
            //  message.getBytes().length);
            
            socket.send(datagram1);
            
            socket.close();
        }catch(Exception e){
            System.err.println("Ocorreu um erro qualquer: "+e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
