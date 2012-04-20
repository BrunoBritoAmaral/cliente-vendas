/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.view.abstracts.pesquisa;

import java.util.List;

import javax.swing.JTable;

import com.sun.corba.se.impl.orbutil.ObjectWriter;

import br.edu.utfpr.app.dto.ClienteDTO;
import br.edu.utfpr.app.dto.ProdutoDTO;
import br.edu.utfpr.app.dto.VendedorDTO;
import br.edu.utfpr.util.IBean;
import br.edu.utfpr.util.TipoCadastro;
import br.edu.utfpr.view.abstracts.cadastro.AbstractCadastroView;
import br.edu.utfpr.view.abstracts.pesquisa.tabela.AbstractCellEditor_;
import br.edu.utfpr.view.abstracts.pesquisa.tabela.AbstractCellRenderer_;
import br.edu.utfpr.view.abstracts.pesquisa.tabela.AbstractTableModel_;

/**
 *
 * @author Luan
 */
public class AbstractPesquisaView<POJO extends IBean> extends javax.swing.JFrame {

    List<POJO> lista = null;
    TipoCadastro tipoCadastro;
    Class<POJO> clazz;
    AbstractCadastroView<POJO> viewCadastro;
	
	public AbstractPesquisaView(TipoCadastro tipoCadastro,AbstractCadastroView<POJO> viewCadastro,List<POJO> lista) {
        this.lista = lista;
        this.tipoCadastro = tipoCadastro;
        this.viewCadastro = viewCadastro;
        this.clazz = getClazz();
        
		initComponents();
    }
	
	@SuppressWarnings("unchecked")
	public Class<POJO> getClazz(){
		switch (tipoCadastro) {
		case CLIENTE:
			return (Class<POJO>) new ClienteDTO().getClass();
			
		case VENDEDOR:
			return (Class<POJO>) new VendedorDTO().getClass();
		
		case PRODUTO:
			return (Class<POJO>) new ProdutoDTO().getClass();

		default:
			return null;
		}
	}
	
	public void atualizaTabela(){
		switch (tipoCadastro) {
		case CLIENTE:
			List<ClienteDTO> cs = (List<ClienteDTO>) lista;
			for (ClienteDTO c : cs) {
				System.out.println("table: "+c.getNome());
			}
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
        
        tabela = new JTable(new AbstractTableModel_<POJO>(lista,tipoCadastro));
        tabela.setDefaultRenderer(clazz, new AbstractCellRenderer_<POJO>(this,viewCadastro, tipoCadastro));
        tabela.setDefaultEditor(clazz, new AbstractCellEditor_<POJO>(this,viewCadastro,tipoCadastro));
        tabela.setRowHeight(55);
        
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
        labelTitulo.setText("Listagem de "+getTitulo()+" cadastrados");

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
    
    public Class getColumnClass(int columnIndex) { return clazz; }
    
    public String getTitulo(){
    	switch (tipoCadastro) {
		case CLIENTE:
			return "clientes";
		case VENDEDOR:
			return "vendedores";		
		case PRODUTO:
			return "produtos";
		default:
			return "";
		}
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable tabela;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelItems;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
