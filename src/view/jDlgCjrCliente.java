/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import tools.HibernateUtil;
import tools.Util;
import bean.CjrCliente;
import dao.CjrCliente_DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author claudio
 */
public class jDlgCjrCliente extends javax.swing.JDialog {

    /**
     * Creates new form JDlgClientes
     */
    
    MaskFormatter mascaraCjrCpf;
    MaskFormatter mascaraCjrDataNascimento;
    MaskFormatter mascaraCjrDataCadastro;
    MaskFormatter mascaraCjrCep;
    MaskFormatter mascaraCjrTelefone;
    
    private boolean incluindo;
    
    public jDlgCjrCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Util.habilitar(false, jTxtCodigo, jTxtNome, jTxtEmail, jFmtCpf, jFmtTelefone, jFmtDatadeNascimento, jTxtSexo, jTxtEndereco, jTxtCidade, jTxtEstado, jFmtCep, jTxtNumeroCasa, jFmtDatadeCadastro, jTxtSaldoCarteira, jTxtObservacoes, jBtnConfirmar, jBtnCancelar);
        setTitle("Clientes");
        setLocationRelativeTo(null);
        try {
            mascaraCjrCpf = new MaskFormatter("###.###.###-##");
            mascaraCjrDataNascimento = new MaskFormatter("##/##/####");
            mascaraCjrDataCadastro = new MaskFormatter("##/##/####");
            mascaraCjrCep = new MaskFormatter("#####-###");
            mascaraCjrTelefone = new MaskFormatter("(##)#####-####");
        } catch (ParseException ex) {
            Logger.getLogger(jDlgCjrUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtCpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCjrCpf));
        jFmtDatadeNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraCjrDataNascimento));
        jFmtDatadeCadastro.setFormatterFactory(new DefaultFormatterFactory(mascaraCjrDataCadastro));
        jFmtCep.setFormatterFactory(new DefaultFormatterFactory(mascaraCjrCep));
        jFmtTelefone.setFormatterFactory(new DefaultFormatterFactory(mascaraCjrTelefone));
    }

    

    public CjrCliente viewBean() {
        CjrCliente cjrcliente = new CjrCliente();
        int id = Integer.valueOf(jTxtCodigo.getText());
        cjrcliente.setCjrIdCliente(id);
        cjrcliente.setCjrNome(jTxtNome.getText());
        cjrcliente.setCjrEmail(jTxtEmail.getText());
        cjrcliente.setCjrCpf(jFmtCpf.getText());
        cjrcliente.setCjrTelefone(jFmtTelefone.getText());
        //cliente.setData_nasc(jFmtDatadeNascimento.getText());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            cjrcliente.setCjrDataNasc(formato.parse( jFmtDatadeNascimento.getText() ) );
            cjrcliente.setCjrDataCadastro(formato.parse( jFmtDatadeCadastro.getText() ) );
        } catch (ParseException ex) {
            
            //Logger.getLogger(jDlgUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro cabeçudo:"+ex.getMessage());
        }
        cjrcliente.setCjrSexo(jTxtSexo.getText());
        cjrcliente.setCjrEndereco(jTxtEndereco.getText());
        cjrcliente.setCjrCidade(jTxtCidade.getText());
        cjrcliente.setCjrEstado(jTxtEstado.getText());
        cjrcliente.setCjrCep(jFmtCep.getText());
        cjrcliente.setCjrNumeroCasa(jTxtNumeroCasa.getText());
        //cliente.setData_cadastro(jFmtDatadeCadastro.getText());
        cjrcliente.setCjrSaldoCarteira(jTxtSaldoCarteira.getText());
        cjrcliente.setCjrObservacoes(jTxtObservacoes.getText());


        return cjrcliente;
    }

    public void beanView(CjrCliente cjrcliente) {
        String valor = String.valueOf(cjrcliente.getCjrIdCliente());
        jTxtCodigo.setText(valor);
        jTxtNome.setText(cjrcliente.getCjrNome());
        jTxtEmail.setText(cjrcliente.getCjrEmail());
        jFmtCpf.setText(cjrcliente.getCjrCpf());
        jFmtTelefone.setText(cjrcliente.getCjrTelefone());
        //jFmtDataNasc.setText(cliente.getDataNasc());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        jFmtDatadeNascimento.setText( formato.format( cjrcliente.getCjrDataNasc()) );
        jTxtSexo.setText(cjrcliente.getCjrSexo());
        jTxtEndereco.setText(cjrcliente.getCjrEndereco());
        jTxtCidade.setText(cjrcliente.getCjrCidade());
        jTxtEstado.setText(cjrcliente.getCjrEstado());
        jFmtCep.setText(cjrcliente.getCjrCep());
        jTxtNumeroCasa.setText(cjrcliente.getCjrNumeroCasa());
        //jFmtDataCadastro.setText(cliente.getDataCadastro());
        jFmtDatadeCadastro.setText( formato.format( cjrcliente.getCjrDataCadastro()) );
        
        jTxtSaldoCarteira.setText(String.valueOf(cjrcliente.getCjrSaldoCarteira()));
        jTxtObservacoes.setText(cjrcliente.getCjrObservacoes());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtSaldoCarteira1 = new javax.swing.JTextField();
        jTxtCódigo9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFmtCpf = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFmtDatadeNascimento = new javax.swing.JFormattedTextField();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jFmtTelefone = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtSexo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtEndereco = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtEstado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTxtCidade = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jFmtCep = new javax.swing.JFormattedTextField();
        jTxtNumeroCasa = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxtSaldoCarteira = new javax.swing.JTextField();
        jTxtObservacoes = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtCodigo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jFmtDatadeCadastro = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();

        jTxtSaldoCarteira1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtSaldoCarteira1ActionPerformed(evt);
            }
        });

        jTxtCódigo9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCódigo9ActionPerformed(evt);
            }
        });

        jLabel10.setText("Código");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel3.setText("Email");

        jTxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtEmailActionPerformed(evt);
            }
        });

        jLabel4.setText("CPF");

        jLabel5.setText("Data de Nascimento");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir_preto.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

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

        jFmtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtTelefoneActionPerformed(evt);
            }
        });

        jLabel8.setText("Telefone");

        jLabel2.setText("Sexo");

        jTxtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtEnderecoActionPerformed(evt);
            }
        });

        jLabel9.setText("Endereço");

        jTxtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtEstadoActionPerformed(evt);
            }
        });

        jLabel11.setText("Estado");

        jTxtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCidadeActionPerformed(evt);
            }
        });

        jLabel12.setText("Cidade");

        jLabel13.setText("Cep");

        jFmtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtCepActionPerformed(evt);
            }
        });

        jTxtNumeroCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNumeroCasaActionPerformed(evt);
            }
        });

        jLabel14.setText("Número da Casa");

        jLabel6.setText("Saldo da Carteira");

        jTxtSaldoCarteira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtSaldoCarteiraActionPerformed(evt);
            }
        });

        jTxtObservacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtObservacoesActionPerformed(evt);
            }
        });

        jLabel7.setText("Observações");

        jTxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodigoActionPerformed(evt);
            }
        });

        jLabel15.setText("Código");

        jLabel16.setText("Data de Cadastro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFmtCpf)
                            .addComponent(jLabel8)
                            .addComponent(jFmtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jFmtDatadeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(90, 90, 90)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(jFmtDatadeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jFmtCep)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtNumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTxtSaldoCarteira))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
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
                                .addComponent(jBtnPesquisar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(425, 425, 425)
                                    .addComponent(jLabel2))
                                .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmtDatadeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFmtDatadeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtNumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtSaldoCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtEmailActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        Util.habilitar( true, jTxtCodigo, jTxtNome, jTxtEmail, jFmtCpf, jFmtTelefone, jFmtDatadeNascimento, jTxtSexo, jTxtEndereco,  jTxtCidade, jTxtEstado, jFmtCep,  jTxtNumeroCasa, jFmtDatadeCadastro, jTxtSaldoCarteira, jTxtObservacoes, jBtnCancelar, jBtnConfirmar);
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        Util.limparCampos(jFmtDatadeCadastro, jTxtCodigo, jTxtNome, jTxtEmail, jFmtCpf, jFmtDatadeNascimento, jTxtSexo, jFmtTelefone, jTxtEndereco, jTxtCidade, jTxtEstado, jFmtCep, jTxtNumeroCasa, jTxtSaldoCarteira, jTxtObservacoes);
        incluindo = true;
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxtCodigo, jTxtNome, jTxtEmail, jFmtCpf, jFmtTelefone, jFmtDatadeNascimento, jTxtSexo, jTxtEndereco, jTxtCidade, jTxtEstado, jFmtCep, jTxtNumeroCasa, jFmtDatadeCadastro, jTxtSaldoCarteira, jTxtObservacoes, jBtnCancelar, jBtnConfirmar);
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        incluindo = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        CjrCliente cjrcliente = viewBean();
        CjrCliente_DAO cliente_DAO = new CjrCliente_DAO();
        if (incluindo == true) {
            cliente_DAO.insert(cjrcliente);
        } else {
            cliente_DAO.update(cjrcliente);
        }
        Util.habilitar(false, jTxtCodigo, jTxtNome, jTxtEmail, jFmtCpf, jFmtTelefone, jFmtDatadeNascimento, jTxtSexo, jTxtEndereco, jTxtCidade, jTxtEstado, jFmtCep, jTxtNumeroCasa, jFmtDatadeCadastro, jTxtSaldoCarteira, jTxtObservacoes, jBtnCancelar, jBtnConfirmar);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        Util.limparCampos(jFmtDatadeCadastro, jTxtCodigo, jTxtNome, jTxtEmail, jFmtCpf, jFmtDatadeNascimento, jTxtSexo, jFmtTelefone, jTxtEndereco, jTxtCidade, jTxtEstado, jFmtCep, jTxtNumeroCasa, jTxtSaldoCarteira, jTxtObservacoes);

    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(false, jTxtCodigo, jTxtNome, jTxtEmail, jFmtCpf, jFmtTelefone, jFmtDatadeNascimento, jTxtSexo, jTxtEndereco, jTxtCidade, jTxtEstado, jFmtCep, jTxtNumeroCasa, jFmtDatadeCadastro, jTxtSaldoCarteira, jTxtObservacoes, jBtnCancelar, jBtnConfirmar);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        Util.limparCampos(jFmtDatadeCadastro, jTxtCodigo, jTxtNome, jTxtEmail, jFmtCpf, jFmtDatadeNascimento, jTxtSexo, jFmtTelefone, jTxtEndereco, jTxtCidade, jTxtEstado, jFmtCep, jTxtNumeroCasa, jTxtSaldoCarteira, jTxtObservacoes);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        
        //habilitar();
        //String resp = JOptionPane.showInputDialog(null, "Entre com o codigo(chave primaria)");
        //Cliente_DAO cliente_DAO = new Cliente_DAO();
        //int id = Integer.valueOf(resp);
        //Cliente cliente = (Cliente) cliente_DAO.list(id);//o list retorna o bean, o list pega o bean e transforma em  objeto
        //beanView(cliente);

        //jBtnAlterar.setEnabled(true);
        //jBtnPesquisar.setEnabled (true);
        //jBtnCancelar.setEnabled(true);
        //jBtnConfirmar.setEnabled(false);
        //jBtnExcluir.setEnabled(true);
        
       
        jDlgCjrClientePesquisa jDlgCjrClientePesquisa = new jDlgCjrClientePesquisa(null, true);
        jDlgCjrClientePesquisa.setTelaAnterior(this);
        jDlgCjrClientePesquisa.setVisible(true);
        
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jFmtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtTelefoneActionPerformed

    private void jTxtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtEnderecoActionPerformed

    private void jTxtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtEstadoActionPerformed

    private void jTxtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCidadeActionPerformed

    private void jFmtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtCepActionPerformed

    private void jTxtNumeroCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNumeroCasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNumeroCasaActionPerformed

    private void jTxtSaldoCarteiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtSaldoCarteiraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtSaldoCarteiraActionPerformed

    private void jTxtSaldoCarteira1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtSaldoCarteira1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtSaldoCarteira1ActionPerformed

    private void jTxtObservacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtObservacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtObservacoesActionPerformed

    private void jTxtCódigo9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCódigo9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCódigo9ActionPerformed

    private void jTxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigoActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
       if(Util.perguntar("Deseja excluir o registro?") == true){    
         }else {
            Util.mensagem("exclusão cancelada.");
        }
         Util.limparCampos(jFmtDatadeCadastro, jTxtCodigo, jTxtNome, jTxtEmail, jFmtCpf, jFmtDatadeNascimento, jTxtSexo, jFmtTelefone, jTxtEndereco, jTxtCidade, jTxtEstado, jFmtCep, jTxtNumeroCasa, jTxtSaldoCarteira, jTxtObservacoes);
    }//GEN-LAST:event_jBtnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(jDlgCjrCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jDlgCjrCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jDlgCjrCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jDlgCjrCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jDlgCjrCliente dialog = new jDlgCjrCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JFormattedTextField jFmtCep;
    private javax.swing.JFormattedTextField jFmtCpf;
    private javax.swing.JFormattedTextField jFmtDatadeCadastro;
    private javax.swing.JFormattedTextField jFmtDatadeNascimento;
    private javax.swing.JFormattedTextField jFmtTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTxtCidade;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtCódigo9;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtEndereco;
    private javax.swing.JTextField jTxtEstado;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtNumeroCasa;
    private javax.swing.JTextField jTxtObservacoes;
    private javax.swing.JTextField jTxtSaldoCarteira;
    private javax.swing.JTextField jTxtSaldoCarteira1;
    private javax.swing.JTextField jTxtSexo;
    // End of variables declaration//GEN-END:variables
}
