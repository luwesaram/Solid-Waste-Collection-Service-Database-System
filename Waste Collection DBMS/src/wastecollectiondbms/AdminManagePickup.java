package wastecollectiondbms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AdminManagePickup extends javax.swing.JInternalFrame {


    public AdminManagePickup() {
        initComponents();
        viewTable();
    }
    
    public void search(String keyword){
        DefaultTableModel table = (DefaultTableModel)pickupTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(table);
        pickupTable.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(keyword));
    }
    
    public void viewTable(){
         try{
            String strDriver = "com.mysql.jdbc.Driver";
            String strConn = "jdbc:mysql://localhost:3306/swcdbms";
            String strUser = "root";
            String strPass = "";
            Class.forName(strDriver);
            Connection objConn = DriverManager.getConnection(strConn,strUser,strPass);
            
            String strQuery = "SELECT a.pickup_id, a.location_name, a.pickup_address, a.customer_id, b.customer_lastname FROM pickup_location a, customer b WHERE a.customer_id = b.customer_id";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            ResultSet resSet = stmntQuery.executeQuery();
            DefaultTableModel table = (DefaultTableModel)pickupTable.getModel();
            table.setRowCount(0);
            while(resSet.next()){
                table.addRow(new String[]{resSet.getString(1), resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getString(5)});
            }
        }catch(Exception objError){
            System.out.println(objError);
        }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pickupTable = new javax.swing.JTable();
        viewAllBtn = new javax.swing.JButton();
        searchTFtxn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Pickup");

        pickupTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "pickup_id", "location_name", "address", "customer_id", "customer_lastname"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pickupTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pickupTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pickupTable);

        viewAllBtn.setText("View All");
        viewAllBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllBtnActionPerformed(evt);
            }
        });

        searchTFtxn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTFtxnActionPerformed(evt);
            }
        });
        searchTFtxn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTFtxnKeyReleased(evt);
            }
        });

        jLabel5.setText("Search:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTFtxn, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(viewAllBtn)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTFtxn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(viewAllBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
        );

        setBounds(150, 60, 641, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void pickupTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pickupTableMouseClicked

    }//GEN-LAST:event_pickupTableMouseClicked

    private void viewAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllBtnActionPerformed
        viewTable();
    }//GEN-LAST:event_viewAllBtnActionPerformed

    private void searchTFtxnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFtxnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTFtxnActionPerformed

    private void searchTFtxnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFtxnKeyReleased
        String strSearch = searchTFtxn.getText();
        search(strSearch);
    }//GEN-LAST:event_searchTFtxnKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pickupTable;
    private javax.swing.JTextField searchTFtxn;
    private javax.swing.JButton viewAllBtn;
    // End of variables declaration//GEN-END:variables
}
