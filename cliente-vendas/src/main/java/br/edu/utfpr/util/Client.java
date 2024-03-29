package br.edu.utfpr.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.edu.utfpr.view.abstracts.cadastro.AbstractCadastroView;
import br.edu.utfpr.view.principal.ClienteView;

public class Client<V extends JFrame> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	static final int port = 56550;
	static ObjectOutputStream oos;
	static ObjectInputStream ois;
	static Socket client;
	public String log;
	public V view;
	
	public Client(V view){
		this.view = view;
	}
	
	//Sobrecarga no metodo enviar para as listagens
	public Object enviar(String protocolo) throws IOException{
		return enviar(null,protocolo);
	}
	
    public Object enviar(Object o,String protocolo) throws IOException{
    	Object retorno = null;
    	try{
    		client = new Socket ( "localhost",56551);
			oos = new ObjectOutputStream( client.getOutputStream() );
			ois = new ObjectInputStream(client.getInputStream());
    		
    		oos.writeUTF(new String(protocolo));
    		oos.writeObject(o);
    		
    		retorno = ois.readObject();
    		
    		log = ois.readUTF();
    		
    		oos.flush();
    		ois.close();
    		client.close();
  
    		return retorno;
    	}
    	catch (java.net.ConnectException e) {
    		Mensagem.show(view, "Não foi possivel conectar com o servidor", JOptionPane.ERROR_MESSAGE);
    		return null;
		}
        catch( Exception e ){ 
        	e.printStackTrace();
        	return null;
        }			
    }
 
}
