/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.view.pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.edu.utfpr.app.dto.ClienteDTO;
import br.edu.utfpr.app.dto.PedidoDTO;
import br.edu.utfpr.app.dto.ProdutoDTO;
import br.edu.utfpr.app.dto.VendedorDTO;
import br.edu.utfpr.util.Client;
import br.edu.utfpr.util.IBean;
import br.edu.utfpr.util.Mensagem;
import br.edu.utfpr.util.TipoCadastro;
import br.edu.utfpr.view.AbstractView;
import br.edu.utfpr.view.abstracts.pesquisa.AbstractPesquisaView;


/**
 *
 * @author Luan
 */
public class PedidoView<POJO extends IBean> extends JFrame implements AbstractView<POJO>{

	List<VendedorDTO> vendedores;;
	List<ClienteDTO> clientes;
	PedidoDTO pedido;
	Client<PedidoView> client;
	DefaultListModel modelo;
	
	public PedidoView() {
		client = new Client<PedidoView>(this);
		pedido = new PedidoDTO();
		vendedores = new ArrayList<VendedorDTO>();
		clientes = new ArrayList<ClienteDTO>();
		
		initComponents();
		populaTela(true);
    }

	public void populaTela(boolean carregar){
		textArea.setText(pedido == null ? "" : pedido.getDescricao());
		
		populaCombos(carregar);
		populaProdutos();
	}
	
	public void atualizaSelecionado(PedidoDTO pedidoDTO){
		pedido = pedidoDTO;
		populaTela(false);
	}
	
	private void populaCombos(boolean carregar) {
		
		if(!carregar){
			comboClientes.setSelectedItem(pedido == null ? null : clientes.indexOf(pedido.getCliente()));
			comboVendedores.setSelectedItem(pedido == null ? null : vendedores.indexOf(pedido.getVendedor()));
		}
		else{
			clientes = new ArrayList<ClienteDTO>();
			vendedores = new ArrayList<VendedorDTO>();

			try {
				vendedores = (List<VendedorDTO>) client.enviar("12");
				clientes = (List<ClienteDTO>) client.enviar("02");

				for (VendedorDTO v : vendedores) {
					comboVendedores.insertItemAt(v.getNome(),
							vendedores.indexOf(v));
				}

				for (ClienteDTO c : clientes) {
					comboClientes
							.insertItemAt(c.getNome(), clientes.indexOf(c));
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void populaProdutos(){
		if(pedido == null || pedido.getProdutos().isEmpty()){
			listProdutos.setModel(new AbstractListModel() {
				String[] strings = { "Nenhum produto adicionado" };
				public int getSize() {return strings.length;}
				public Object getElementAt(int i) {return strings[i];}
			});
		}
		
		else{
		    listProdutos.setModel(new DefaultListModel());
		    modelo = ( DefaultListModel ) listProdutos.getModel();  
			
		    for ( int i = 0; i < pedido.getProdutos().size(); i++)  
		        modelo.addElement( pedido.getProdutos().get(i) );
		}
	}
	
	@Override
	public void addLista(ProdutoDTO pojo) {
		pedido.add(pojo);
		populaProdutos();
	}
	
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
        painelBotoes = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jbPesquisar = new javax.swing.JButton();
        painelConteudo = new javax.swing.JPanel();
        lbDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        lbVendedor = new javax.swing.JLabel();
        comboVendedores = new javax.swing.JComboBox();
        jbClientes = new javax.swing.JLabel();
        comboClientes = new javax.swing.JComboBox();
        lbProdutos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listProdutos = new javax.swing.JList();
        btAdicionar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbNovo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/new.png")));
        jbNovo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/save.png")));
        btSalvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jbPesquisar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/search-icon.png")));
        jbPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(jbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelConteudo.setBackground(new java.awt.Color(255, 255, 255));
        painelConteudo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbDescricao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDescricao.setText("Descrição:");

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        lbVendedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbVendedor.setText("Vendedor:");

        jbClientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbClientes.setText("Cliente:");

        lbProdutos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbProdutos.setText("Produtos:");

        listProdutos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        jScrollPane2.setViewportView(listProdutos);

        btAdicionar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/add.png")));
        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btRemover.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/remove.png")));
        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelConteudoLayout = new javax.swing.GroupLayout(painelConteudo);
        painelConteudo.setLayout(painelConteudoLayout);
        painelConteudoLayout.setHorizontalGroup(
            painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConteudoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelConteudoLayout.createSequentialGroup()
                        .addComponent(lbDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(painelConteudoLayout.createSequentialGroup()
                        .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbVendedor)
                            .addComponent(jbClientes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboVendedores, 0, 329, Short.MAX_VALUE)
                            .addComponent(comboClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelConteudoLayout.createSequentialGroup()
                        .addComponent(lbProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(painelConteudoLayout.createSequentialGroup()
                                .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 203, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelConteudoLayout.setVerticalGroup(
            painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConteudoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbVendedor)
                    .addComponent(comboVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbClientes)
                    .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProdutos)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionar)
                    .addComponent(btRemover))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
    	atualizaSelecionado(new PedidoDTO());
    }//GEN-LAST:event_jbNovoActionPerformed
   
    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
    	if(!validaCampos())
    		return;
    	
    	pedido.setDescricao(textArea.getText().trim());
    	pedido.setCliente(clientes.get(comboClientes.getSelectedIndex()));
    	pedido.setVendedor(vendedores.get(comboVendedores.getSelectedIndex()));
    	
    	Object retorno = null;
    	try {
    		retorno = client.enviar(pedido, "30");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	if(retorno != null){
    		atualizaSelecionado(new PedidoDTO());
			Mensagem.show(this, "Pedido efetuado com sucesso", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else{
    		Mensagem.show(this, "Ocorreu um erro ao efetuar o pedido", JOptionPane.ERROR_MESSAGE);
    	}
    	
    }//GEN-LAST:event_btSalvarActionPerformed

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
    	
		try {
			List<PedidoDTO> pedidos = (List<PedidoDTO>) new Client(this).enviar("32");
			new AbstractPesquisaView<PedidoDTO,PedidoView<PedidoDTO>>(TipoCadastro.PEDIDO,(PedidoView<PedidoDTO>) this,pedidos).setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    }//GEN-LAST:event_jbPesquisarActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
    	try {
    		List<ProdutoDTO> lista =  (List<ProdutoDTO>) new Client(this).enviar("22");
    		new AbstractPesquisaView<ProdutoDTO,PedidoView<ProdutoDTO>>(TipoCadastro.ADICIONAR_PRODUTO,(PedidoView<ProdutoDTO>) this, lista ).setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
    	if(modelo != null){
    		ProdutoDTO p = (ProdutoDTO) modelo.getElementAt(listProdutos.getSelectedIndex());
    		pedido.remove(p);
    		modelo.remove(listProdutos.getSelectedIndex());
    		
    		if(pedido.getProdutos().isEmpty())
    			populaProdutos();
    	}
    	
    }//GEN-LAST:event_btRemoverActionPerformed
    
    
    public boolean validaCampos(){
    	if(textArea.getText().trim().equals("")){
    		Mensagem.show(this, "Informe a descrição", JOptionPane.INFORMATION_MESSAGE);
    		return false;
    	}
    	
    	if(comboVendedores.getSelectedItem() == null){
    		Mensagem.show(this, "Selecione o vendedor", JOptionPane.INFORMATION_MESSAGE);
    		return false;
    	}
    	
    	if(comboClientes.getSelectedItem() == null){
    		Mensagem.show(this, "Selecione o cliente", JOptionPane.INFORMATION_MESSAGE);
    		return false;
    	}
    	
    	if(pedido == null || pedido.getProdutos().isEmpty()){
    		Mensagem.show(this, "Adicione ao menos 1 produto", JOptionPane.INFORMATION_MESSAGE);
    		return false;
    	}
    	
    	return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox comboVendedores;
    private javax.swing.JComboBox comboClientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel jbClientes;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbProdutos;
    private javax.swing.JLabel lbVendedor;
    private javax.swing.JList listProdutos;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelConteudo;
    // End of variables declaration//GEN-END:variables


	@Override
	public void atualizaSelecionado(POJO pojo) {
		atualizaSelecionado((PedidoDTO) pojo);
	}

	@Override
	public void atualizaTabela(POJO pojo) {}

	@Override
	public void excluir(AbstractView<POJO> view) {
		try {
			Object retorno = client.enviar(pedido,"31");
			PedidoDTO pedido = null;
			atualizaSelecionado(pedido);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
