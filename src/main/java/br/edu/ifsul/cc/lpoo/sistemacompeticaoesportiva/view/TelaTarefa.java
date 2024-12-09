/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.sistemacompeticaoesportiva.view;

import br.edu.ifsul.cc.lpoo.sistemacompeticaoesportiva.projetolpooe1_franciscojunior.dao.PersistenciaJPA;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Tarefa;

/**
 *
 * @author vanessalagomachado
 */
public class TelaTarefa extends javax.swing.JFrame {

    PersistenciaJPA jpa = new PersistenciaJPA();

    /**
     * Creates new form TelaVeiculosJFrame
     */
    public TelaTarefa() {
        initComponents();
        loadTarefasCadastradas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnAddVeiculo = new javax.swing.JButton();
        btnEditarVeiculo = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setText("Tarefas cadastradas");

        btnAddVeiculo.setText("Novo");
        btnAddVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVeiculoActionPerformed(evt);
            }
        });

        btnEditarVeiculo.setText("Editar");
        btnEditarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVeiculoActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        tblVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Projeto", "Funcionário", "Tarefa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVeiculos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAddVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnEditarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddVeiculo)
                    .addComponent(btnEditarVeiculo)
                    .addComponent(btnRemover))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVeiculoActionPerformed
        TelaCadastroTarefa tela = new TelaCadastroTarefa(this, rootPaneCheckingEnabled);
        tela.setVisible(true);

        loadTarefasCadastradas();
    }//GEN-LAST:event_btnAddVeiculoActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        Tarefa tarefaSel = getTarefaSelecionada();
        if (tarefaSel != null) {
            int delOp = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover tarefa " + tarefaSel + "?");
            if (delOp == JOptionPane.YES_OPTION) {
                jpa.conexaoAberta();
                try {
                    // Passo 2: Remover o objeto
                    jpa.remover(tarefaSel);
                    JOptionPane.showMessageDialog(rootPane, "Tarefa removida com sucesso!");

                    loadTarefasCadastradas(); // Atualiza a tabela
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Erro ao remover tarefa " + tarefaSel + "\nErro: " + e.getMessage());
                } finally {
                    jpa.fecharConexao();
                }

            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnEditarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVeiculoActionPerformed

        Tarefa tarefaSel = getTarefaSelecionada();
        if (tarefaSel != null) {
            TelaCadastroTarefa tela = new TelaCadastroTarefa(this, rootPaneCheckingEnabled);
            tela.setTarefa(tarefaSel);
            tela.setVisible(true);
            loadTarefasCadastradas(); // Atualiza a tabela após edição

        }
    }//GEN-LAST:event_btnEditarVeiculoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTarefa().setVisible(true);
            }
        });
    }

    public void loadTarefasCadastradas() {
        // Abre a conexão
        jpa.conexaoAberta();
        try {

            // Busca os veículos cadastrados
            List<Tarefa> listaTarefas = jpa.getTarefas(); // Método criado no DAO

            // Obtém o modelo da tabela
            DefaultTableModel modeloTabela = (DefaultTableModel) tblVeiculos.getModel();

            // Limpa a tabela 
            modeloTabela.setRowCount(0);

            // Adiciona os veículos ao modelo da tabela
            for (Tarefa tarefa : listaTarefas) {
                Object[] linha = {
                    tarefa.getProjeto() != null ? tarefa.getProjeto().getNome() : "",
                    tarefa.getFuncionario() != null ? tarefa.getFuncionario().getNome() : "",
                    tarefa.getDescricao()
                };
                modeloTabela.addRow(linha);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar as tarefas: " + e.getMessage());
        } finally {
            // Fecha a conexão
            jpa.fecharConexao();
        }

    }

    public void loadVeiculosCadastrados(List<Tarefa> listaTarefas) {
        try {

            // Obtém o modelo da tabela
            DefaultTableModel modeloTabela = (DefaultTableModel) tblVeiculos.getModel();

            // Limpa a tabela 
            modeloTabela.setRowCount(0);

            // Adiciona os veículos ao modelo da tabela
            for (Tarefa tarefa : listaTarefas) {
                Object[] linha = {
                    tarefa.getProjeto() != null ? tarefa.getProjeto().getNome() : "",
                    tarefa.getFuncionario() != null ? tarefa.getFuncionario().getNome() : "",
                    tarefa.getDescricao()
                };
                modeloTabela.addRow(linha);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar as tarefas: " + e.getMessage());
        }
    }

    public Tarefa getTarefaSelecionada() {
        int linhaSelecionada = tblVeiculos.getSelectedRow(); // Obtém a linha selecionada
        if (linhaSelecionada >= 0) { // Quando não tem nenhum objeto selecionado retorna -1
            DefaultTableModel modeloTabela = (DefaultTableModel) tblVeiculos.getModel();
            Tarefa tarefaSelecionada = (Tarefa) modeloTabela.getValueAt(linhaSelecionada, 0); // A coluna 0 contém o objeto Veiculo
            return tarefaSelecionada;
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada.");
            return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddVeiculo;
    private javax.swing.JButton btnEditarVeiculo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblVeiculos;
    // End of variables declaration//GEN-END:variables
}