package br.edu.utfpr.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import br.edu.utfpr.app.dto.ClienteDTO;
import br.edu.utfpr.app.dto.ProdutoDTO;
import br.edu.utfpr.app.dto.VendedorDTO;

public class Client implements Serializable{

	private static final long serialVersionUID = 1L;
	
	static final int port = 56550;
	static ObjectOutputStream oos;
	static ObjectInputStream ois;
	static Socket client;
	private String log;
	
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
    		
    		setLog(ois.readUTF());
    		
    		oos.flush();
    		ois.close();
    		client.close();
  
    		return retorno;
        }catch( Exception e ){ 
        	e.printStackTrace();
        	return null;
        }			
    }

    
    public void exibe(int entidade,Object retorno) throws IOException, ClassNotFoundException{
    	try{
    	switch (entidade) {
		case Entidade.CLIENTE:	
			List<ClienteDTO> clientes = (List<ClienteDTO>) retorno;
			for (ClienteDTO c : clientes) {
				System.out.println(c.getNome());
			}
			break;
		case Entidade.VENDEDOR:
			List<VendedorDTO> vendedores = new ArrayList<VendedorDTO>();
			vendedores = (List<VendedorDTO>) retorno;
			for (VendedorDTO v : vendedores) {
				System.out.println(v.getNome());
			}
			break;
		case Entidade.PRODUTO:
			List<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();
			produtos = (List<ProdutoDTO>) retorno;
			for (ProdutoDTO p : produtos) {
				System.out.println(p.getDescricao());
			}
			break;

		default:
			break;
		}
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
 
}
