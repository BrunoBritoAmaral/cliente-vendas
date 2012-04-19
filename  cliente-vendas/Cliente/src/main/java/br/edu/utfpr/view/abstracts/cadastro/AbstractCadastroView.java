/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.view.abstracts.cadastro;

import java.awt.List;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.edu.utfpr.app.dto.ClienteDTO;
import br.edu.utfpr.app.dto.ProdutoDTO;
import br.edu.utfpr.app.dto.VendedorDTO;
import br.edu.utfpr.util.Client;
import br.edu.utfpr.util.IBean;
import br.edu.utfpr.util.Mensagem;
import br.edu.utfpr.util.TipoCadastro;
import br.edu.utfpr.view.abstracts.pesquisa.AbstractPesquisaView;
import br.edu.utfpr.view.principal.ClienteView;

/**
 *
 * @author Luan
 */
public class AbstractCadastroView<POJO extends IBean> extends javax.swing.JFrame {

    TipoCadastro tipoCadastro;  
    POJO selecionado = null;
	
	public AbstractCadastroView(TipoCadastro tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
		initComponents();
		populaTela();
    }
	
	public void populaTela(){
		switch (tipoCadastro) {
		case CLIENTE:
			jlCampo1.setText("Nome:");
			jlCampo2.setText("CPF:");
			
			ClienteDTO cliente = (ClienteDTO) selecionado;
			jtCampo1.setText(cliente == null? "" : cliente.getNome());
			jtCampo2.setText(cliente == null? "" : cliente.getCpf());
			break;
			
		case VENDEDOR:
			jlCampo1.setText("Nome:");
			jlCampo2.setText("CPF:");
			
			VendedorDTO vendedor = (VendedorDTO) selecionado;
			jtCampo1.setText(vendedor == null? "" : vendedor.getNome());
			jtCampo2.setText(vendedor == null? "" : vendedor.getCpf());
			break;
			
		case PRODUTO:
			jlCampo1.setText("Descrição:");
			jlCampo2.setText("Preço:");
			
			ProdutoDTO produto = (ProdutoDTO) selecionado;
			jtCampo1.setText(produto == null? "" : produto.getDescricao());
			jtCampo2.setText(produto == null? "" : String.valueOf(produto.getPreco()));
			break;
			
		default:
			break;
		}
	}
	
	public void atualizaSelecionado(POJO selecionado){
		this.selecionado = selecionado;
		populaTela();
	}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBotoes = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jbPesquisar = new javax.swing.JButton();
        painelConteudo = new javax.swing.JPanel();
        jlCampo1 = new javax.swing.JLabel();
        jtCampo1 = new javax.swing.JTextField();
        jlCampo2 = new javax.swing.JLabel();
        jtCampo2 = new javax.swing.JTextField();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jlCampo1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlCampo1.setText("Campo1");

        jtCampo1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jlCampo2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlCampo2.setText("Campo2");

        jtCampo2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout painelConteudoLayout = new javax.swing.GroupLayout(painelConteudo);
        painelConteudo.setLayout(painelConteudoLayout);
        painelConteudoLayout.setHorizontalGroup(
            painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConteudoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCampo1)
                    .addComponent(jlCampo2))
                .addGap(33, 33, 33)
                .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        painelConteudoLayout.setVerticalGroup(
            painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConteudoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCampo1)
                    .addComponent(jtCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCampo2)
                    .addComponent(jtCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
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
        atualizaSelecionado(null);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
    	if(!validaCampos())
    		return;
    	
    	switch (tipoCadastro) {
		case CLIENTE:
			ClienteDTO cliente = (ClienteDTO) selecionado;
			
			if(cliente == null)
				cliente = new ClienteDTO();
			
			cliente.setNome(jtCampo1.getText());
			cliente.setCpf(jtCampo2.getText());
			
			try {
				ClienteView.client.enviarCliente(cliente,"00");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		case VENDEDOR:
			VendedorDTO vendedor = (VendedorDTO) selecionado;	
			if(vendedor == null)
				vendedor = new VendedorDTO();
			
			vendedor.setNome(jtCampo1.getText());
			vendedor.setCpf(jtCampo2.getText());
			try{
				ClienteView.client.enviarCliente(vendedor,"10");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		case PRODUTO:
			ProdutoDTO produto = (ProdutoDTO) selecionado;
			if(produto == null)
				produto = new ProdutoDTO();
			produto.setDescricao(jtCampo1.getText());
			produto.setPreco(Double.parseDouble(jtCampo2.getText()));
			try{
				ClienteView.client.enviarCliente(produto,"20");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
    }//GEN-LAST:event_btSalvarActionPerformed

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
    	new AbstractPesquisaView<POJO>(tipoCadastro, null ).setVisible(true);
    }//GEN-LAST:event_jbPesquisarActionPerformed

    
    public boolean validaCampos(){
    	if(jtCampo1.getText().trim().equals("") || jtCampo2.getText().trim().equals("")){
    		Mensagem.show(this, "Todos os campos são obrigatórios", JOptionPane.WARNING_MESSAGE);
    		return false;
    	}
    	return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JLabel jlCampo1;
    private javax.swing.JLabel jlCampo2;
    private javax.swing.JTextField jtCampo1;
    private javax.swing.JTextField jtCampo2;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelConteudo;
    // End of variables declaration//GEN-END:variables
}
