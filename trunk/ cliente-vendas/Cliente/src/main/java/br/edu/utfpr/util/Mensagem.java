package br.edu.utfpr.util;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/** 
 * @author Luan Malaguti Reffatti
 */
public class Mensagem extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que exibe uma mensagem de acordo com os parametros informados
	 * 
	 * @param clazz jframe que vai exibir a mensagem
	 * @param mensagem texto a ser apresentado
	 * @param tipo do alerta
	 */
	public static void show(Component jframe, String mensagem,int tipo) {
		JOptionPane.showMessageDialog(jframe, mensagem, "", tipo);
	}
}
