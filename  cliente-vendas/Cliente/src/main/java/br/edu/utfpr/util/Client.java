package br.edu.utfpr.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client implements Serializable{

	private static final long serialVersionUID = 1L;
	
	static final int port = 56550;
	static ObjectOutputStream oos;
	static ObjectInputStream ois;
	static Socket client;
	public String log;
	
	public Client(){
	
	}
    public Object enviar(Object o,String protocolo) throws IOException{//método de teste para tentar enviar um cliente
    	try{
    		client = new Socket ( "localhost",56551);
			oos = new ObjectOutputStream( client.getOutputStream() );
			ois = new ObjectInputStream(client.getInputStream());
    		
    		oos.writeUTF(new String(protocolo));
    		oos.writeObject(o);
    		
    		Object retorno = ois.readObject();
    		
    		log = ois.readUTF();
    		
    		oos.flush();
    		ois.close();
    		client.close();
  
    		return retorno;
        }catch( Exception e ){ 
        	e.printStackTrace();
        	return null;
        }			
    }
 
}
