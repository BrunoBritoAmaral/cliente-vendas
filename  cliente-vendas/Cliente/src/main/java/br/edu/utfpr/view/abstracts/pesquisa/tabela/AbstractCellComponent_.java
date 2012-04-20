package br.edu.utfpr.view.abstracts.pesquisa.tabela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;

import br.edu.utfpr.util.IBean;
import br.edu.utfpr.util.TipoCadastro;
import br.edu.utfpr.view.abstracts.pesquisa.AbstractPesquisaView;

public class AbstractCellComponent_<POJO extends IBean> extends JPanel {
	POJO pojo;
	TipoCadastro tipoCadastro;

	JButton editarButton, excluirButton;
	JLabel texto, descricao;
	JPanel botoes;

	AbstractCellComponent_(AbstractPesquisaView<POJO> view,
			TipoCadastro tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
		
		editarButton = new JButton();
		editarButton.setToolTipText("Editar");
		editarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		excluirButton = new JButton();
		excluirButton.setToolTipText("Excluir");
		excluirButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(null,"Deseja excluir o item selecionado?","Excluir",JOptionPane.YES_NO_OPTION);
				if(op == 0){
					
				}
			}
		});
		
		this.setLayout(new BorderLayout());
	    setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));  
	    Font f = new Font("Arial",Font.BOLD , 12);
	    
	    descricao = new JLabel();
	    descricao.setFont(f);
	    
	    botoes = new JPanel();
	    botoes.setLayout(new BorderLayout());
	    botoes.add(editarButton,BorderLayout.CENTER);
	    botoes.add(excluirButton,BorderLayout.EAST);
	    
	    add(descricao,BorderLayout.WEST);
//	    add(texto,BorderLayout.CENTER);
	    add(botoes,BorderLayout.EAST);

	}

	public void updateData(POJO pojo, boolean isSelected, JTable table) {
		this.pojo = pojo;
		descricao.setText(getDescricao());

		if (isSelected) {
			setBackground(new Color(214, 217, 223));
			botoes.setBackground(new Color(214, 217, 223));
		} else {
			setBackground(new Color(255, 255, 255));
			botoes.setBackground(new Color(255, 255, 255));
		}
	}

	public String getDescricao() {
		switch (tipoCadastro) {
		
		case CLIENTE:
			return "Nome: ";
					
		case VENDEDOR:
			return "Nome";
			
		case PRODUTO:
			return "Descrição";

		default:
			return "";

		}
	}
}
