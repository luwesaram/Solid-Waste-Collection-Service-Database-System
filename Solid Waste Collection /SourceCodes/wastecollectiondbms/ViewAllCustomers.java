package wastecollectiondbms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ViewAllCustomers extends javax.swing.JInternalFrame {
    
Connection objConn;
PreparedStatement prepState;
ResultSet resSet;  

    public void infoMessage(String strMessage, String strTitle){
        JOptionPane.showMessageDialog(null, strMessage, strTitle, JOptionPane.INFORMATION_MESSAGE);
    }

    DefaultTableModel table;
    
    public void searchTxnDetails(){

    }

    public void getConnection(){
        try{
            String strDriver = "com.mysql.jdbc.Driver";
            String strConn = "jdbc:mysql://localhost:3306/swcdbms";
            String strUser = "root";
            String strPass = "";
            Class.forName(strDriver);
            objConn = DriverManager.getConnection(strConn,strUser,strPass);
        }catch(Exception objError){
            System.out.println(objError);
        }
    }
    

    public void viewTable(){
         try{
            
            String strQuery = "SELECT * FROM CUSTOMER";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            resSet = stmntQuery.executeQuery();
            table = (DefaultTableModel)customerTable.getModel();
            table.setRowCount(0);
            while(resSet.next()){
                table.addRow(new String[]{resSet.getString(1),resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getString(5)});
            }
        }catch(Exception objError){
            System.out.println(objError);
        }  
    }
    
    public ViewAllCustomers() {
        initComponents();
        getConnection();
        viewTable();
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        customerIDTF = new javax.swing.JTextField();
        deleteBtn = new javax.swing.JButton();
        viewAllBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Manage Customers");

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "customer_ID", "FirstName", "LastName", "PhoneNo", "email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customerTable);

        customerIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDTFActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        viewAllBtn.setText("View All");
        viewAllBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Customer ID:");

        searchTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTFActionPerformed(evt);
            }
        });
        searchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTFKeyReleased(evt);
            }
        });

        jLabel5.setText("Search:");

        searchBtn.setText("Search");
        searchBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewAllBtn)
                .addGap(37, 37, 37)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(deleteBtn)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(viewAllBtn)
                    .addComponent(searchBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );

        setBounds(150, 60, 719, 359);
    }// </editor-fold>//GEN-END:initComponents

    private void customerIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDTFActionPerformed

    }//GEN-LAST:event_customerIDTFActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        String strCustomerID = customerIDTF.getText();
        try {

            String strQuery = "DELETE FROM customer WHERE customer_id = "+strCustomerID+"";
            Statement statementQuery = objConn.createStatement();
            int intConfirmation = statementQuery.executeUpdate(strQuery);
            viewTable();
            if (intConfirmation == 1){
                infoMessage("Customer Info deleted.", "SUCCESS!");
            }
            else{
                infoMessage("Error deleting..", "ERROR!");
            }
        } catch(Exception objError){
            System.out.println(objError);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void viewAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllBtnActionPerformed
        viewTable();
    }//GEN-LAST:event_viewAllBtnActionPerformed

    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTableMouseClicked
        table = (DefaultTableModel)customerTable.getModel();
        int intSelectedRows = customerTable.getSelectedRow();
        
        customerIDTF.setText(table.getValueAt(intSelectedRows, 0).toString());
    }//GEN-LAST:event_customerTableMouseClicked

    private void searchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFActionPerformed

    }//GEN-LAST:event_searchTFActionPerformed

    private void searchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFKeyReleased

    }//GEN-LAST:event_searchTFKeyReleased

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        
        String strSearch = searchTF.getText();
        try{
            
            String strQuery = "SELECT * FROM CUSTOMER WHERE customer_lastname LIKE '"+strSearch+"%' OR customer_firstname LIKE '"+strSearch+"%' OR customer_email LIKE '"+strSearch+"%' OR customer_phoneno LIKE '"+strSearch+"%'";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            resSet = stmntQuery.executeQuery();
            table = (DefaultTableModel)customerTable.getModel();
            table.setRowCount(0);
            while(resSet.next()){
                table.addRow(new String[]{resSet.getString(1),resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getString(5)});
            }
        }catch(Exception objError){
            System.out.println(objError);
        }  
    }//GEN-LAST:event_searchBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField customerIDTF;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTF;
    private javax.swing.JButton viewAllBtn;
    // End of variables declaration//GEN-END:variables
}
