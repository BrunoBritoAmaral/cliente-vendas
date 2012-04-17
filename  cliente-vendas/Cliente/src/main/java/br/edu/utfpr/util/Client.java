package br.edu.utfpr.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import br.edu.utfpr.pojo.Cliente;

public class Client {
	static final int port = 56550;
	static ObjectOutputStream oos;
	static Socket client;
    public static void enviarCliente(Cliente c) throws IOException{
    	try{
    		client = new Socket ( "localhost", port );
    		oos = new ObjectOutputStream( client.getOutputStream() );
    		oos.writeObject(c);
    		oos.flush();
        }catch( Exception e ){ }
        finally{ 
            oos.close(); 
            client.close();
        }
    			
    	}

	public static void estabelecerConexao(){//método de teste de conexão da
    	try{
            InetAddress addr = InetAddress.getByName("localhost");
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
