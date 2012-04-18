package br.edu.utfpr.app;

import br.edu.utfpr.util.Client;
import br.edu.utfpr.view.principal.ClienteView;

public class Aplication {
	static Client c;
	
    public static void main(String args[]) {
    	try {
        	c = new Client();
        
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }finally{
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ClienteView(c).setVisible(true);
            }
        });
    }
}
