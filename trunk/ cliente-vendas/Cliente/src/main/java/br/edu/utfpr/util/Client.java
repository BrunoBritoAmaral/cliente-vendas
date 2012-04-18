package br.edu.utfpr.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import br.edu.utfpr.app.dto.Cliente;

public class Client extends Thread{
	static final int port = 56550;
	static ObjectOutputStream oos;
	static Socket client;
	
    public static void enviarCliente(Cliente c) throws IOException{//método de teste para tentar enviar um cliente
    	try{
    		client = new Socket ( "localhost",56551);
    		oos = new ObjectOutputStream( client.getOutputStream() );
    		oos.writeChars(new String("00"));
    		oos.writeObject(c);
    		oos.flush();
        }catch( Exception e ){ }			
    }

	public static void estabelecerConexao(){//método de teste de conexão da
    	try{
            InetAddress addr = InetAddress.getByName("localhost");
            
            String message = "00Este é uma mensagem enviada pelo cliente";
            
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket datagram1 = new DatagramPacket(message.getBytes(),message.getBytes().length,addr,port);
            
            socket.send(datagram1);
            socket.close();
        }catch(Exception e){
            System.err.println("Ocorreu um erro qualquer: "+e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
