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
import br.edu.utfpr.app.dto.PedidoDTO;
import br.edu.utfpr.app.dto.ProdutoDTO;
import br.edu.utfpr.app.dto.VendedorDTO;
import br.edu.utfpr.util.IBean;
import br.edu.utfpr.util.TipoCadastro;
import br.edu.utfpr.view.AbstractView;

public class AbstractCellComponent_<POJO extends IBean,V extends AbstractView<POJO>> extends JPanel {
	POJO pojo;
	TipoCadastro tipoCadastro;

	JButton editarButton, excluirButton, adicionarButton;
	JLabel texto;
	JPanel botoes;

	AbstractCellComponent_(final V view,final V viewCadastro,TipoCadastro tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
		
		this.setLayout(new BorderLayout());
	    setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));  
	    Font f = new Font("Arial",Font.BOLD , 12);
	    
	    texto = new JLabel();
	    texto.setFont(f);
	    
	    botoes = new JPanel();
	    botoes.setLayout(new BorderLayout());
	    
	    add(texto,BorderLayout.CENTER);
	    
	    if(tipoCadastro == TipoCadastro.ADICIONAR_PRODUTO){
	    	
	    	adicionarButton = new JButton();
			adicionarButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/add.png")));
			adicionarButton.setToolTipText("Adicionar");
			adicionarButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					viewCadastro.addLista((ProdutoDTO) pojo);
					view.dispose();
				}
			});
			botoes.add(adicionarButton,BorderLayout.CENTER);
	    }
	    
	    else{
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
			
			botoes.add(editarButton,BorderLayout.CENTER);
		    botoes.add(excluirButton,BorderLayout.EAST);
	    }
	    
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
			
		case PEDIDO:
			PedidoDTO pedido = (PedidoDTO) pojo;
			return pedido.getDescricao() + "  -  Total em produtos: R$" + getValorTotal();
		
		case ADICIONAR_PRODUTO:
			ProdutoDTO p2 = (ProdutoDTO) pojo;
			return p2.getDescricao() + "  -  " + "R$ " + p2.getPreco();

		default:
			return "";

		}
	}
	
	public String getValorTotal(){
		PedidoDTO pedido = (PedidoDTO) pojo;
		double soma =0;
		
		for (ProdutoDTO p : pedido.getProdutos()) {
			soma = soma + p.getPreco();
		}
		
		return String.valueOf(soma);
	}
}
