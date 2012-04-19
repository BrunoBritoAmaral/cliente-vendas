package br.edu.utfpr.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import br.edu.utfpr.app.dto.ClienteDTO;

public class Client{
	static final int port = 56550;
	static ObjectOutputStream oos;
	static ObjectInputStream ois;
	static Socket client;
	
	public Client(){
		connect();
	}
	
    public  void enviarCliente(Object o,String mensagem) throws IOException{//método de teste para tentar enviar um cliente
    	try{
    		oos.writeUTF(new String(mensagem));
    		oos.writeObject(o);
    		//Agora aqui tem que receber um objeto e manipula-lo
    		String texto = ois.readUTF();
    		System.out.println("Texto:"+texto);
    		oos.flush();
    		
        }catch( Exception e ){ }			
    }
    
    public void connect(){
    	try {
			client = new Socket ( "localhost",56551);
			oos = new ObjectOutputStream( client.getOutputStream() );
			ois = new ObjectInputStream(client.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
 
}
