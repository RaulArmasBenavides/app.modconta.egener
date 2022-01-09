package cliente;

import entity.Pelicula;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;
import entity.Producto;

public class Formulario_Cliente extends javax.swing.JFrame implements Observer{
    private final Cliente client;
    private final DefaultTableModel defaultTableModel;
    
    public Formulario_Cliente() {
        initComponents();
        defaultTableModel=new DefaultTableModel();
        mostrarCabecera();
        client=new Cliente(2000);
        client.addObserver(this);
        Thread t=new Thread(client);
        t.start();
    }
    
    private void mostrarCabecera(){
        defaultTableModel.addColumn("Codigo");
        defaultTableModel.addColumn("Nombre");
        defaultTableModel.addColumn("Tipo");
        defaultTableModel.addColumn("Fecha");
        tblProductos.setModel(defaultTableModel);
        //boton.contains(jLabel1, 30, 20);
      
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hiFiTabbedPaneUI1 = new com.jtattoo.plaf.hifi.HiFiTabbedPaneUI();
        aluminiumLookAndFeel1 = new com.jtattoo.plaf.aluminium.AluminiumLookAndFeel();
        aluminiumPopupMenuSeparatorUI1 = new com.jtattoo.plaf.aluminium.AluminiumPopupMenuSeparatorUI();
        aluminiumTabbedPaneUI1 = new com.jtattoo.plaf.aluminium.AluminiumTabbedPaneUI();
        aluminiumIcons1 = new com.jtattoo.plaf.aluminium.AluminiumIcons();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProductos);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/planet.jpeg"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("CARTELERA- ESTRENO HOY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            //for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
           // if ("Nimbus".equals(info.getName())) {
               // javax.swing.UIManager.setLookAndFeel(info.getClassName());
               //     break;
            // }
           javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
           // javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_Cliente().setVisible(true);
            }
        });
    }
    
    public void clearTable(){
        System.out.println("clearTable");
        defaultTableModel.setRowCount(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jtattoo.plaf.aluminium.AluminiumIcons aluminiumIcons1;
    private com.jtattoo.plaf.aluminium.AluminiumLookAndFeel aluminiumLookAndFeel1;
    private com.jtattoo.plaf.aluminium.AluminiumPopupMenuSeparatorUI aluminiumPopupMenuSeparatorUI1;
    private com.jtattoo.plaf.aluminium.AluminiumTabbedPaneUI aluminiumTabbedPaneUI1;
    private com.jtattoo.plaf.hifi.HiFiTabbedPaneUI hiFiTabbedPaneUI1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
   //private com.jtattoo.plaf.luna.LunaButtonUI boton ;
    @Override
    public void update(Observable o, Object arg) {  
        clearTable();
        //List<Producto> products = (List<Producto>)arg;
        List<Pelicula> pelis = (List<Pelicula>)arg;
        if(pelis!=null && pelis.size()>=0){
            for(Pelicula peli : pelis){
                Object[] row = {peli.getCodigo(),peli.getNombre(),peli.getTipo(),peli.getFecha()};
                defaultTableModel.addRow(row);
            }
        }
   
    }
}
