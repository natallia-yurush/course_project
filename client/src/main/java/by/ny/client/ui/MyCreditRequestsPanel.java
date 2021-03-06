/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.ny.client.ui;

/**
 *
 * @author Natallia Yurush
 */
public class MyCreditRequestsPanel extends javax.swing.JPanel {

    /**
     * Creates new form MyCreditRequestsPanel
     */
    public MyCreditRequestsPanel() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        requestCreditPanel1 = new by.ny.client.ui.RequestCreditPanel();
        myRequestedCreditsPanel1 = new by.ny.client.ui.MyRequestedCreditsPanel();

        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });
        jTabbedPane1.addTab("Оставить заявку на кредит", requestCreditPanel1);

        myRequestedCreditsPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                myRequestedCreditsPanel1ComponentShown(evt);
            }
        });
        jTabbedPane1.addTab("Мои заявки на кредит", myRequestedCreditsPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
        
    }//GEN-LAST:event_jTabbedPane1ComponentShown

    private void myRequestedCreditsPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_myRequestedCreditsPanel1ComponentShown
        myRequestedCreditsPanel1.reloadTableData();
    }//GEN-LAST:event_myRequestedCreditsPanel1ComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private by.ny.client.ui.MyRequestedCreditsPanel myRequestedCreditsPanel1;
    private by.ny.client.ui.RequestCreditPanel requestCreditPanel1;
    // End of variables declaration//GEN-END:variables
}
