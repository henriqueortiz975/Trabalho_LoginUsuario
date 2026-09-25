package telas;

import java.sql.*;
import dal.Mod_conexao;
import javax.swing.JOptionPane;

public class TelaCliente extends javax.swing.JInternalFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaCliente() {
        initComponents();
        conexao = Mod_conexao.conector();
        
        RadCPF.setSelected(true);
    }
    
    private void consultar(){
        String sql = "SELECT * FROM TB_Clientes2 WHERE ID_Cliente = ?";
    
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNome.setText(rs.getString(2));
                txtEndereco.setText(rs.getString(3));
                txtCidade.setText(rs.getString(4));
                txtUF.setText(rs.getString(5));
                if(rs.getString(6) != null){
                    txtRegistro.setText(rs.getString(6));
                }else if(rs.getString(7) != null){
                    txtRegistro.setText(rs.getString(7));
                }else{
                    JOptionPane.showMessageDialog(null, "Fudeu neguinho, ta errado");
                }
                txtTelefone.setText(rs.getString(8));
                txtData.setText(rs.getString(9));
        
            }else {
                JOptionPane.showMessageDialog(null, "USUARIO NÃO CADASTRADO...");
                txtNome.setText(null);
                txtEndereco.setText(null);
                txtCidade.setText(null);
                txtUF.setText(null);
                txtRegistro.setText(null); 
                txtTelefone.setText(null);
                txtData.setText(null);
            }   
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    
    private void adicionar(){
        String sql = "INSERT INTO TB_Clientes2 (Nome_Cliente, Endereco_Cliente, Cidade_Cliente, UF_Cliente, CPF_Cliente, CNPJ_Cliente, Telefone_Cliente, Data_Nasc_Cliente, Status_Cliente) VALUES (?,?,?,?,?,?,?,?,?)" ;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1 ,txtNome.getText());
            pst.setString(2 ,txtEndereco.getText());
            pst.setString(3 ,txtCidade.getText());
            pst.setString(4 ,txtUF.getText());
            if(RadCPF.isSelected()){
                String Registro = "PF";
                pst.setString(5, txtRegistro.getText());
                pst.setString(6, null);
                pst.setString(9, Registro);
            }else if(RadCNPJ.isSelected()){
                String Registro = "PJ";
                pst.setString(5, null);
                pst.setString(6, txtRegistro.getText());
                pst.setString(9, Registro);
            }
            pst.setString(7 ,txtTelefone.getText());
            pst.setString(8 ,txtData.getText());

        
            int adicionado = pst.executeUpdate();
        
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Usuario Cadastrado");
                txtNome.setText(null);
                txtEndereco.setText(null);
                txtCidade.setText(null);
                txtUF.setText(null);
                txtRegistro.setText(null);
                txtTelefone.setText(null);
                txtData.setText(null);
            }
        
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao adicionar usuário: " + e.getMessage());
        }finally {
        }   
    }

    private void alterar() {
        String sql = "UPDATE TB_Clientes2 SET Nome_Cliente = ?, Endereco_Cliente = ?, Cidade_Cliente = ?, UF_Cliente = ?, CPF_Cliente = ?, CNPJ_Cliente = ?, Telefone_Cliente = ?, Data_Nasc_Cliente = ?, Status_Cliente = ? WHERE ID_Cliente = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtEndereco.getText());
            pst.setString(3, txtCidade.getText());
            pst.setString(4, txtUF.getText());
            if(RadCPF.isSelected()){
                String Registro = "PF";
                pst.setString(5, txtRegistro.getText());
                pst.setString(6, null);
                pst.setString(9, Registro);
            }else if(RadCNPJ.isSelected()){
                String Registro = "PJ";
                pst.setString(6, txtRegistro.getText());
                pst.setString(5, null);
                pst.setString(9, Registro);
            }            
            pst.setString(7, txtTelefone.getText());
            pst.setString(8, txtData.getText());
            pst.setString(10, txtId.getText());
            int adicionado = pst.executeUpdate();
            if(adicionado > 0){
                JOptionPane.showMessageDialog(null, "USUÁRIO ALTERADO COM SUCESSO");
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao alterar usuário: " + e.getMessage());
        }
    }
    
    private void apagar(){
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este usuario?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
            String sql = "DELETE FROM TB_Clientes2 WHERE ID_Cliente = ?";
            try{
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0){
                    JOptionPane.showMessageDialog(null, "USUÁRIO APAGADO");
                    txtNome.setText(null);
                    txtEndereco.setText(null);
                    txtCidade.setText(null);
                    txtUF.setText(null);
                    txtRegistro.setText(null);
                    txtTelefone.setText(null);
                    txtData.setText(null);
                } 
                pst.executeUpdate();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgRegistro = new javax.swing.ButtonGroup();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        ID = new javax.swing.JLabel();
        btnApagar = new javax.swing.JButton();
        nome = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        email = new javax.swing.JLabel();
        senha = new javax.swing.JLabel();
        senha1 = new javax.swing.JLabel();
        txtUF = new javax.swing.JTextField();
        txtRegistro = new javax.swing.JTextField();
        senha3 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        senha4 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        RadCPF = new javax.swing.JRadioButton();
        RadCNPJ = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("TELA CADASTRO");

        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        ID.setText("ID:");

        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        nome.setText("Nome:");

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        email.setText(" Endereço:");

        senha.setText("Cidade:");

        senha1.setText("UF:");

        txtUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUFActionPerformed(evt);
            }
        });

        txtRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegistroActionPerformed(evt);
            }
        });

        senha3.setText("Telefone");

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        senha4.setText("Data Nasc:");

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        bgRegistro.add(RadCPF);
        RadCPF.setText("CPF");
        RadCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadCPFActionPerformed(evt);
            }
        });

        bgRegistro.add(RadCNPJ);
        RadCNPJ.setText("CNPJ");
        RadCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadCNPJActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(email)
                                    .addComponent(nome)
                                    .addComponent(senha)
                                    .addComponent(senha1)
                                    .addComponent(senha3)
                                    .addComponent(senha4))
                                .addGap(11, 11, 11)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RadCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RadCNPJ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtUF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                        .addComponent(txtCidade, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(198, 198, 198))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senha)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(senha1)
                    .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RadCPF)
                    .addComponent(RadCNPJ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senha3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senha4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVisualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApagar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        adicionar();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        consultar();
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        apagar();
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        alterar();
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUFActionPerformed

    private void txtRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegistroActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void RadCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadCPFActionPerformed

    private void RadCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadCNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadCNPJActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JRadioButton RadCNPJ;
    private javax.swing.JRadioButton RadCPF;
    private javax.swing.ButtonGroup bgRegistro;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JLabel email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel senha;
    private javax.swing.JLabel senha1;
    private javax.swing.JLabel senha3;
    private javax.swing.JLabel senha4;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRegistro;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtUF;
    // End of variables declaration//GEN-END:variables
}
