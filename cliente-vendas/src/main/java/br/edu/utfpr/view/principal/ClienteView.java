/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.view.principal;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.View;

import br.edu.utfpr.app.dto.ClienteDTO;
import br.edu.utfpr.app.dto.PedidoDTO;
import br.edu.utfpr.app.dto.ProdutoDTO;
import br.edu.utfpr.app.dto.VendedorDTO;
import br.edu.utfpr.util.Client;
import br.edu.utfpr.util.Mensagem;
import br.edu.utfpr.util.TipoCadastro;
import br.edu.utfpr.view.abstracts.cadastro.AbstractCadastroView;
import br.edu.utfpr.view.pedido.PedidoView;

/**
 *
 * @author Luan
 */
public class ClienteView extends javax.swing.JFrame {
    
	public ClienteView() {
		initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btCliente = new javax.swing.JButton();
        btVendedor = new javax.swing.JButton();
        jbProdutos = new javax.swing.JButton();
        jbPedidos = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btCliente.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/user-icon.png")));
        btCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btCliente.setText("Cliente");
        btCliente.setPreferredSize(new java.awt.Dimension(75, 23));
        btCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClienteActionPerformed(evt);
            }
        });

        btVendedor.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/vendedor.png")));
        btVendedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btVendedor.setText("Vendedor");
        btVendedor.setToolTipText("");
        btVendedor.setPreferredSize(new java.awt.Dimension(75, 23));
        btVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVendedorActionPerformed(evt);
            }
        });

        jbProdutos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/shopping.png")));
        jbProdutos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbProdutos.setText("Produtos");
        jbProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProdutosActionPerformed(evt);
            }
        });

        jbPedidos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/pedido.png")));
        jbPedidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbPedidos.setText("Pedidos");
        jbPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jbPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        btSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/exit.png")));
        btSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClienteActionPerformed
        new AbstractCadastroView<ClienteDTO>(TipoCadastro.CLIENTE).setVisible(true);
    }//GEN-LAST:event_btClienteActionPerformed

    private void btVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVendedorActionPerformed
    	new AbstractCadastroView<VendedorDTO>(TipoCadastro.VENDEDOR).setVisible(true);
    }//GEN-LAST:event_btVendedorActionPerformed

    private void jbProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProdutosActionPerformed
    	new AbstractCadastroView<ProdutoDTO>(TipoCadastro.PRODUTO).setVisible(true);
    }//GEN-LAST:event_jbProdutosActionPerformed

    private void jbPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPedidosActionPerformed
    	new PedidoView().setVisible(true);
    }//GEN-LAST:event_jbPedidosActionPerformed


    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btSairActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCliente;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btVendedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbPedidos;
    private javax.swing.JButton jbProdutos;
    // End of variables declaration//GEN-END:variables
}
