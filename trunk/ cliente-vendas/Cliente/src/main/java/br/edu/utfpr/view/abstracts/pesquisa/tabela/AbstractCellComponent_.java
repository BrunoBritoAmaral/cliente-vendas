package br.edu.utfpr.view.abstracts.pesquisa.tabela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;

import br.edu.utfpr.app.dto.ClienteDTO;
import br.edu.utfpr.app.dto.ProdutoDTO;
import br.edu.utfpr.app.dto.VendedorDTO;
import br.edu.utfpr.util.IBean;
import br.edu.utfpr.util.TipoCadastro;
import br.edu.utfpr.view.abstracts.cadastro.AbstractCadastroView;
import br.edu.utfpr.view.abstracts.pesquisa.AbstractPesquisaView;

public class AbstractCellComponent_<POJO extends IBean> extends JPanel {
	POJO pojo;
	TipoCadastro tipoCadastro;

	JButton editarButton, excluirButton;
	JLabel texto;
	JPanel botoes;

	AbstractCellComponent_(final AbstractPesquisaView<POJO> view,final AbstractCadastroView<POJO> viewCadastro,TipoCadastro tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
		
		editarButton = new JButton();
		editarButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/edit.png")));
		editarButton.setToolTipText("Editar");
		editarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewCadastro.atualizaSelecionado(pojo);
				view.dispose();
			}
		});
		
		excluirButton = new JButton();
		excluirButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/Trash-icon.png")));
		excluirButton.setToolTipText("Excluir");
		excluirButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(null,"Deseja excluir o item selecionado?","Excluir",JOptionPane.YES_NO_OPTION);
				if(op == 0){
					viewCadastro.atualizaSelecionado(pojo);
					viewCadastro.excluir(view);
					view.atualizaTabela(pojo);
				}
			}
		});
		
		this.setLayout(new BorderLayout());
	    setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));  
	    Font f = new Font("Arial",Font.BOLD , 12);
	    
	    texto = new JLabel();
	    texto.setFont(f);
	    
	    botoes = new JPanel();
	    botoes.setLayout(new BorderLayout());
	    botoes.add(editarButton,BorderLayout.CENTER);
	    botoes.add(excluirButton,BorderLayout.EAST);
	    
	    add(texto,BorderLayout.CENTER);
	    add(botoes,BorderLayout.EAST);

	}

	public void updateData(POJO pojo, boolean isSelected, JTable table) {
		this.pojo = pojo;
		texto.setText(getDescricao());

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
			ClienteDTO c = (ClienteDTO) pojo;
			return "Nome: " + c.getNome() + "  -  " + "CPF: " + c.getCpf();
					
		case VENDEDOR:
			VendedorDTO v = (VendedorDTO) pojo;
			return "Nome: " + v.getNome() + "  -  " + "CPF: " + v.getCpf();
			
		case PRODUTO:
			ProdutoDTO p = (ProdutoDTO) pojo;
			return p.getDescricao() + "  -  " + "R$ " + p.getPreco();

		default:
			return "";

		}
	}
}
