/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;
import civitas.Diario;
import javax.swing.JFrame;

/**
 *
 * @author angus
 */
public class DiarioDialog extends javax.swing.JDialog {
    
    Diario diario=Diario.getInstance();

    /**
     * Creates new form DiarioDialog
     */
    public DiarioDialog(JFrame parent) {
      /*  super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
         eventos.setVisible(true);
        eventos.setText(diario.toString());
       
        repaint();
        revalidate();*/
      
     super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        String textoeventos="";
        while(diario.eventosPendientes()){
            textoeventos+= diario.leerEvento() + "\n";
            
            
        }
        
        
        eventos.setText(textoeventos);
        this.setVisible(true);
        repaint();
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaEventos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventos = new javax.swing.JTextArea();
        boton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiquetaEventos.setText("Eventos");

        eventos.setColumns(20);
        eventos.setRows(5);
        jScrollPane1.setViewportView(eventos);

        boton1.setText("OK");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etiquetaEventos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(boton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(etiquetaEventos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_boton1ActionPerformed

    /**
     * @param args the command line arguments
     */
  //  public static void main(String args[]) {
        /* Set the Nimbus look and feel */
      //  //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       // try {
         //   for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
           //     if ("Nimbus".equals(info.getName())) {
             //       javax.swing.UIManager.setLookAndFeel(info.getClassName());
               //     break;
                //}
            //}
        //} catch (ClassNotFoundException ex) {
          //  java.util.logging.Logger.getLogger(DiarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //} catch (InstantiationException ex) {
          //  java.util.logging.Logger.getLogger(DiarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //} catch (IllegalAccessException ex) {
          //  java.util.logging.Logger.getLogger(DiarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //} catch (javax.swing.UnsupportedLookAndFeelException ex) {
          //  java.util.logging.Logger.getLogger(DiarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //}
        //</editor-fold>

        /* Create and display the dialog */
        //java.awt.EventQueue.invokeLater(new Runnable() {
          //  public void run() {
            //    DiarioDialog dialog = new DiarioDialog(new javax.swing.JFrame());
              //  dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                //    @Override
                  //  public void windowClosing(java.awt.event.WindowEvent e) {
                    //    System.exit(0);
                    //}
                //});
                //dialog.setVisible(true);
            //}
        //});
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton1;
    private javax.swing.JLabel etiquetaEventos;
    private javax.swing.JTextArea eventos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}