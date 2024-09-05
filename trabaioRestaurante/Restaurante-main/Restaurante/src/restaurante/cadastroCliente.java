/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restaurante;

import conexao.DatabaseClientes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tabelas.clientes;

/**
 *
 * @author paulo
 */
public class cadastroCliente extends javax.swing.JFrame {

    /**
     * Creates new form cadastroFunc
     */
    public cadastroCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        CPF_txt = new javax.swing.JLabel();
        Nome_txt = new javax.swing.JLabel();
        Sexo_txt = new javax.swing.JLabel();
        Idade_txt = new javax.swing.JLabel();
        Endereco_txt = new javax.swing.JLabel();
        Email_txt = new javax.swing.JLabel();
        Telefone_txt = new javax.swing.JLabel();
        Data_cadastro_txt = new javax.swing.JLabel();
        enviar = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        CPF = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        Nome = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        Idade = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        Sexo = new javax.swing.JTextArea();
        jScrollPane15 = new javax.swing.JScrollPane();
        Email = new javax.swing.JTextArea();
        jScrollPane16 = new javax.swing.JScrollPane();
        Endereco = new javax.swing.JTextArea();
        jScrollPane18 = new javax.swing.JScrollPane();
        Telefone = new javax.swing.JTextArea();
        jScrollPane19 = new javax.swing.JScrollPane();
        Data_cadastro = new javax.swing.JTextArea();
        Sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setText("Cadastro de Clientes");

        CPF_txt.setText("CPF");

        Nome_txt.setText("Nome");

        Sexo_txt.setText("Sexo");

        Idade_txt.setText("Idade");

        Endereco_txt.setText("Endereço");

        Email_txt.setText("Email");

        Telefone_txt.setText("Telefone");

        Data_cadastro_txt.setText("Data do Cadastro");

        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        CPF.setLineWrap(true);
        CPF.setRows(1);
        CPF.setWrapStyleWord(true);
        jScrollPane11.setViewportView(CPF);

        Nome.setLineWrap(true);
        Nome.setRows(1);
        Nome.setWrapStyleWord(true);
        jScrollPane12.setViewportView(Nome);

        Idade.setLineWrap(true);
        Idade.setRows(1);
        Idade.setWrapStyleWord(true);
        jScrollPane13.setViewportView(Idade);

        Sexo.setLineWrap(true);
        Sexo.setRows(1);
        Sexo.setWrapStyleWord(true);
        jScrollPane14.setViewportView(Sexo);

        Email.setLineWrap(true);
        Email.setRows(1);
        Email.setWrapStyleWord(true);
        jScrollPane15.setViewportView(Email);

        Endereco.setLineWrap(true);
        Endereco.setRows(1);
        Endereco.setWrapStyleWord(true);
        jScrollPane16.setViewportView(Endereco);

        Telefone.setLineWrap(true);
        Telefone.setRows(1);
        Telefone.setWrapStyleWord(true);
        jScrollPane18.setViewportView(Telefone);

        Data_cadastro.setLineWrap(true);
        Data_cadastro.setRows(1);
        Data_cadastro.setWrapStyleWord(true);
        jScrollPane19.setViewportView(Data_cadastro);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(title)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Data_cadastro_txt)
                            .addComponent(Telefone_txt)
                            .addComponent(Email_txt)
                            .addComponent(Endereco_txt)
                            .addComponent(Idade_txt)
                            .addComponent(Sexo_txt)
                            .addComponent(Nome_txt)
                            .addComponent(CPF_txt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(enviar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Sair))
                            .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(95, 95, 95))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CPF_txt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nome_txt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sexo_txt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Idade_txt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Endereco_txt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email_txt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Telefone_txt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Data_cadastro_txt))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enviar)
                    .addComponent(Sair))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SairActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        String cpf = CPF.getText();
        String nome = Nome.getText();
        String sexo = Sexo.getText();
        String idade = Idade.getText();
        String endereco = Endereco.getText();
        String email = Email.getText();
        String telefone = Telefone.getText();
        String data_cadastro = Data_cadastro.getText();
        
        Date dataCadastro = null;
        try {
            dataCadastro = new SimpleDateFormat("MM/dd/yyyy").parse(data_cadastro);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválido");
        }
        
        clientes NovoCliente = new clientes(cpf,nome,sexo,idade,endereco,email,telefone,dataCadastro);
        DatabaseClientes criar = new DatabaseClientes();
        criar.create(NovoCliente);
        JOptionPane.showMessageDialog(this, "Ô meu sangue bom, tu foi cadastrado com sucesso meu patrão!");
    }//GEN-LAST:event_enviarActionPerformed

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
            java.util.logging.Logger.getLogger(cadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CPF;
    private javax.swing.JLabel CPF_txt;
    private javax.swing.JTextArea Data_cadastro;
    private javax.swing.JLabel Data_cadastro_txt;
    private javax.swing.JTextArea Email;
    private javax.swing.JLabel Email_txt;
    private javax.swing.JTextArea Endereco;
    private javax.swing.JLabel Endereco_txt;
    private javax.swing.JTextArea Idade;
    private javax.swing.JLabel Idade_txt;
    private javax.swing.JTextArea Nome;
    private javax.swing.JLabel Nome_txt;
    private javax.swing.JButton Sair;
    private javax.swing.JTextArea Sexo;
    private javax.swing.JLabel Sexo_txt;
    private javax.swing.JTextArea Telefone;
    private javax.swing.JLabel Telefone_txt;
    private javax.swing.JButton enviar;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JPanel painel;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}