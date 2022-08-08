package wastecollectiondbms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AdminManageBusiness extends javax.swing.JInternalFrame {

    public AdminManageBusiness() {
        initComponents();
        viewTable();
    }
    
    public void search(String keyword){
        DefaultTableModel table = (DefaultTableModel)businessTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(table);
        businessTable.setRowSorter(sorter);
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
            
            String strQuery = "SELECT a.business_id, a.business_name, a.business_city, a.business_street, a.business_barangay, a.business_contactno, a.customer_id, b.customer_lastname FROM BUSINESS a, CUSTOMER b WHERE a.customer_id = b.customer_id";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            ResultSet resSet = stmntQuery.executeQuery();
            DefaultTableModel table = (DefaultTableModel)businessTable.getModel();
            table.setRowCount(0);
            while(resSet.next()){
                table.addRow(new String[]{resSet.getString(1), resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getString(5),resSet.getString(6),resSet.getString(7),resSet.getString(8)});
            }
        }catch(Exception objError){
            System.out.println(objError);
        }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        businessTable = new javax.swing.JTable();
        viewAllBtn = new javax.swing.JButton();
        searchTFtxn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Businesses");

        businessTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "business_ID", "name", "city", "street", "barangay", "contact_no", "customer_id", "customer_lastname"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        businessTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                businessTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(businessTable);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTFtxn, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewAllBtn)
                .addGap(187, 187, 187))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTFtxn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(viewAllBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
        );

        setBounds(110, 60, 783, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void businessTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_businessTableMouseClicked

    }//GEN-LAST:event_businessTableMouseClicked

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
    private javax.swing.JTable businessTable;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTFtxn;
    private javax.swing.JButton viewAllBtn;
    // End of variables declaration//GEN-END:variables
}
