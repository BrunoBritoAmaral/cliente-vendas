/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.view.abstracts.pesquisa;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import br.edu.utfpr.util.IBean;
import br.edu.utfpr.util.TipoCadastro;

/**
 *
 * @author Luan
 */
public class AbstractPesquisaView<POJO extends IBean> extends javax.swing.JFrame {

    List<POJO> items = null;
    TipoCadastro tipoCadastro;
	
	public AbstractPesquisaView(TipoCadastro tipoCadastro,List<POJO> items) {
        this.items = items;
        this.tipoCadastro = tipoCadastro;
		initComponents();
    }
	
	public void atualizaTabela(){
		switch (tipoCadastro) {
		case CLIENTE:
			
			break;
		case VENDEDOR:
					
			break;
		
		case PRODUTO:
			
			break;

		default:
			break;
		}
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelItems = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
       
        labelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelItems.setBackground(new java.awt.Color(255, 255, 255));
        panelItems.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        scrollPane.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        tabela = new javax.swing.JTable();
        tabela.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        scrollPane.setViewportView(tabela);

        javax.swing.GroupLayout panelItemsLayout = new javax.swing.GroupLayout(panelItems);
        panelItems.setLayout(panelItemsLayout);
        panelItemsLayout.setHorizontalGroup(
            panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );
        panelItemsLayout.setVerticalGroup(
            panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
        );

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTitulo.setText("Listagem de ENTIDADE cadastrados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitulo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addGap(16, 16, 16)
                .addComponent(panelItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable tabela;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelItems;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
