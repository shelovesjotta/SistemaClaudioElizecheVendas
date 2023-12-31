 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import bean.CjrFuncionario;
import bean.CjrCliente;
import bean.CjrVendaProduto;
import dao.CjrCliente_DAO;
import dao.CjrFuncionario_DAO;
import dao.CjrVendaProduto_DAO;
import tools.Util;
import bean.CjrVenda;
import controles.CjrVendaProdutoControle;
import dao.CjrVenda_DAO;
import java.text.ParseException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author USER
 */
public class jDlgCjrVenda extends javax.swing.JDialog {
    private boolean incluindo;
    MaskFormatter mascaraCjrDataVenda;
    
    CjrVenda cjrVenda;
    CjrVendaProduto cjrVendaProduto;
    CjrVenda_DAO cjrVenda_DAO;
    CjrVendaProdutoControle cjrVendaProdutoControle;
    CjrVendaProduto_DAO cjrVendaProduto_DAO;

    

    /**
     * Creates new form jDlgCjrVenda
     */
    public jDlgCjrVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Cadastro de Venda");
        List lista = new ArrayList();
        Util.habilitar(false, jTxtNumVenda, jFmtData, jCboCliente, jCboFuncionario, jTxtQuantidade, jTxtTotal, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        setLocationRelativeTo(null);
        cjrVenda = new CjrVenda();
        cjrVendaProduto = new CjrVendaProduto();
        cjrVenda_DAO = new CjrVenda_DAO();
        cjrVendaProduto_DAO = new CjrVendaProduto_DAO();
        cjrVendaProdutoControle = new CjrVendaProdutoControle();
        List listProduto = cjrVendaProduto_DAO.listAll();
        cjrVendaProdutoControle.setList(lista);
        jTable1.setModel(cjrVendaProdutoControle);
        
        CjrCliente_DAO cjrCliente_DAO = new CjrCliente_DAO();
        List listaCli = cjrCliente_DAO.listAll();
        for (int i = 0; i < listaCli.size(); i++) {
            jCboCliente.addItem((CjrCliente) listaCli.get(i));
        }

        CjrFuncionario_DAO cjrFuncionario_DAO = new CjrFuncionario_DAO();
        List listaFu = cjrFuncionario_DAO.listAll();
        for (int i = 0; i < listaFu.size(); i++) {
            jCboFuncionario.addItem((CjrFuncionario) listaFu.get(i));
        }
        try {
            mascaraCjrDataVenda = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(jDlgCjrUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtData.setFormatterFactory(new DefaultFormatterFactory(mascaraCjrDataVenda));
        Util.limparCampos(jTxtNumVenda, jFmtData, jCboCliente, jCboFuncionario, jTxtQuantidade, jTxtTotal);
    }

    public CjrVenda viewBean() {
        cjrVenda = new CjrVenda();
        int id = Util.strInt(jTxtNumVenda.getText());
        cjrVenda.setCjrIdVenda(id);
        Date datevend = Util.StrDate(jFmtData.getText());
        cjrVenda.setCjrDataVenda(datevend);
        cjrVenda.setCjrCliente((CjrCliente) jCboCliente.getSelectedItem());
        cjrVenda.setCjrFuncionario((CjrFuncionario) jCboFuncionario.getSelectedItem());
        cjrVenda.setCjrQuantidadeVenda(jTxtQuantidade.getText());
        double saldo = Util.strDouble(jTxtTotal.getText());
        cjrVenda.setCjrValorTotal(saldo);
        return cjrVenda; //retorna do bean 
    
    }
    
    public void beanView(CjrVenda cjrVenda) {
        String valor = Util.intStr(cjrVenda.getCjrIdVenda());
        jTxtNumVenda.setText(valor);
        String datenasc = Util.dateStr(cjrVenda.getCjrDataVenda());
        jFmtData.setText(datenasc);
        jCboCliente.setSelectedItem(cjrVenda.getCjrCliente());
        jCboFuncionario.setSelectedItem(cjrVenda.getCjrFuncionario());
        jTxtQuantidade.setText(cjrVenda.getCjrQuantidadeVenda());
        String saldo = Util.doubleStr(cjrVenda.getCjrValorTotal());
        jTxtTotal.setText(saldo);
        
        CjrVendaProduto_DAO cjrVendaProduto_DAO = new CjrVendaProduto_DAO();
        List listaProd = (List) cjrVendaProduto_DAO.listProduto(cjrVenda);
        
        cjrVendaProdutoControle.setList(listaProd);
    }
    
    public int getSelectedRowProd(){
        return jTable1.getSelectedRow();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtNumVenda = new javax.swing.JTextField();
        jCboCliente = new javax.swing.JComboBox<CjrCliente>();
        jCboFuncionario = new javax.swing.JComboBox<CjrFuncionario>();
        jLabel5 = new javax.swing.JLabel();
        jTxtTotal = new javax.swing.JTextField();
        jFmtData = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jBtnIncluir = new javax.swing.JButton();
        jBntAlterarProd = new javax.swing.JButton();
        jBntExcluirProd = new javax.swing.JButton();
        jTxtQuantidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jBtnIncluirProd = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Num da Venda");

        jLabel3.setText("Data");

        jLabel4.setText("Cliente");

        jCboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboClienteActionPerformed(evt);
            }
        });

        jCboFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboFuncionarioActionPerformed(evt);
            }
        });

        jLabel5.setText("Funcionario");

        jLabel6.setText("Total");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Venda", "Produtos", "Valor Unitario", "Quantidade"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar_preto.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir_preto.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar_preto.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar_preto.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar_preto.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel20.setText("Instrumentaliza Vendas");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir_preto.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBntAlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar_preto.png"))); // NOI18N
        jBntAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBntAlterarProdActionPerformed(evt);
            }
        });

        jBntExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir_preto.png"))); // NOI18N
        jBntExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBntExcluirProdActionPerformed(evt);
            }
        });

        jLabel7.setText("Quantidade");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_cadastro.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel17.setText("Cadastro de Vendas");

        jBtnIncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir_preto.png"))); // NOI18N
        jBtnIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirProdActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)
                                .addGap(261, 261, 261))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jBtnIncluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnAlterar)
                                .addGap(10, 10, 10)
                                .addComponent(jBtnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnPesquisar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel20)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTxtNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jTxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jBntExcluirProd)
                                .addComponent(jBtnIncluirProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jBntAlterarProd)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jBtnIncluirProd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBntAlterarProd)
                        .addGap(18, 18, 18)
                        .addComponent(jBntExcluirProd)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxtNumVenda, jFmtData, jCboCliente, jCboFuncionario,jTxtQuantidade, jTxtTotal, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        incluindo = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        if (cjrVenda != null) {
            if (Util.perguntar("Deseja excluir a Venda?") == true) {
                CjrVendaProduto_DAO cjrVendaProduto_DAO = new CjrVendaProduto_DAO();
                CjrVendaProduto cjrVendaProduto;
                for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                    cjrVendaProduto = cjrVendaProdutoControle.getBean(linha);
                    cjrVendaProduto_DAO.delete(cjrVendaProduto);
                }
                cjrVendaProduto_DAO.delete(cjrVenda);
            } else {
                Util.mensagem("Deve ser realizada uma pesquisa antes");
            }
       Util.limparCampos(jTxtNumVenda, jFmtData, jCboCliente, jCboFuncionario, jTxtQuantidade, jTxtTotal, jBtnConfirmar, jBtnCancelar);
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        cjrVenda = viewBean();
        if (incluindo == true) {
            cjrVenda_DAO.insert(cjrVenda);
            CjrVendaProduto_DAO cjrVendaProduto_DAO = new CjrVendaProduto_DAO();
            CjrVendaProduto cjrVendaProduto;
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                cjrVendaProduto = cjrVendaProdutoControle.getBean(linha);
                cjrVendaProduto.setCjrVenda(cjrVenda);
                cjrVendaProduto_DAO.insert(cjrVendaProduto);
            }
        } else {
            cjrVenda_DAO.update(cjrVenda);
            // Obtém todos os produtos associados a esta venda
            List<CjrVendaProduto> produtosDaVenda = cjrVendaProduto_DAO.listProduto(cjrVenda);

            // Remove cada produto associado a esta venda
            for (CjrVendaProduto produto : produtosDaVenda) {
                cjrVendaProduto_DAO.delete(produto);
            }
            // Incluir todos os produtos do jTable na venda atual
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                cjrVendaProduto = cjrVendaProdutoControle.getBean(linha);
                cjrVendaProduto.setCjrVenda(cjrVenda);
                cjrVendaProduto_DAO.insert(cjrVendaProduto);
            }
            
        }
        Util.habilitar(false, jTxtNumVenda, jFmtData, jCboCliente, jCboFuncionario,jTxtQuantidade, jTxtTotal, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        Util.limparCampos(jTxtNumVenda, jFmtData, jCboCliente, jCboFuncionario,jTxtQuantidade, jTxtTotal, jBtnConfirmar, jBtnCancelar);

    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(false, jTxtNumVenda, jFmtData, jCboCliente, jCboFuncionario,jTxtQuantidade, jTxtTotal, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        Util.mensagem("A ação foi cancelada!");
        Util.limparCampos(jTxtNumVenda, jFmtData, jCboCliente, jCboFuncionario,jTxtQuantidade, jTxtTotal, jBtnConfirmar, jBtnCancelar);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed

        jDlgCjrVendaPesquisa jDlgCjrVendaPesquisa1 = new jDlgCjrVendaPesquisa(null, true);
        jDlgCjrVendaPesquisa1.setTelaAnterior(this);
        jDlgCjrVendaPesquisa1.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxtNumVenda, jFmtData, jCboCliente, jCboFuncionario,jTxtQuantidade, jTxtTotal, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        Util.limparCampos(jTxtNumVenda, jFmtData, jCboCliente, jCboFuncionario,jTxtQuantidade, jTxtTotal, jBtnConfirmar, jBtnCancelar);
        incluindo = true;
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jCboFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboFuncionarioActionPerformed

    private void jBntAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBntAlterarProdActionPerformed
        // TODO add your handling code here:
        int rowSel = jTable1.getSelectedRow();
        if (rowSel != -1) {
            cjrVendaProduto = cjrVendaProdutoControle.getBean(rowSel);

            jDlgCjrVendasProduto telaVendaProduto = new jDlgCjrVendasProduto(new javax.swing.JFrame(), true);
            telaVendaProduto.setTitle("Alteração");
            telaVendaProduto.setIncluindo(false);
            telaVendaProduto.setTelaAnterior(this); 
            telaVendaProduto.beanView(cjrVendaProduto);

            telaVendaProduto.setVisible(true);
            Util.habilitar(true, jBtnConfirmar, jBtnCancelar);
            Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        } else {
            Util.mensagem("Erro! Selecione um Registro para poder ser Alterado.");
        }
    }//GEN-LAST:event_jBntAlterarProdActionPerformed

    private void jCboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboClienteActionPerformed

    private void jBntExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBntExcluirProdActionPerformed
        // TODO add your handling code here:
        CjrVendaProdutoControle cjrVendaProdutoControle = new CjrVendaProdutoControle();
        int linha = jTable1.getSelectedRow();
            if (linha == -1) {
              Util.mensagem("Selecione uma linha para oder Excluir");
        } else {
                if (Util.perguntar("Deseja Confirmar a Exclusão do Produto") == true) {
                    cjrVendaProdutoControle.removeBean(linha);
                }
            }
           Util.mensagem("Produto Excluido com Sucesso");
         ((CjrVendaProdutoControle)jTable1.getModel()).removeBean(linha);
    }//GEN-LAST:event_jBntExcluirProdActionPerformed

    private void jBtnIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirProdActionPerformed
        // TODO add your handling code here:
        jDlgCjrVendasProduto telaVendaProduto = new jDlgCjrVendasProduto(new javax.swing.JFrame(), true);
        telaVendaProduto.setTitle("Inclusão");
        telaVendaProduto.setIncluindo(true);
        telaVendaProduto.setTelaAnterior(this);
        telaVendaProduto.setVisible(true);
        
        Util.habilitar(true, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
    }//GEN-LAST:event_jBtnIncluirProdActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            jBtnConfirmarActionPerformed(null);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jDlgCjrVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jDlgCjrVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jDlgCjrVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jDlgCjrVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jDlgCjrVenda dialog = new jDlgCjrVenda(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBntAlterarProd;
    private javax.swing.JButton jBntExcluirProd;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnIncluirProd;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<CjrCliente> jCboCliente;
    private javax.swing.JComboBox<CjrFuncionario> jCboFuncionario;
    private javax.swing.JFormattedTextField jFmtData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtNumVenda;
    private javax.swing.JTextField jTxtQuantidade;
    private javax.swing.JTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables
}
