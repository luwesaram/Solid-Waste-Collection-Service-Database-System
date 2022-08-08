package wastecollectiondbms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class EditPickup extends javax.swing.JInternalFrame {

    String strCustomerID;
    public EditPickup(String customerID) {
        this.strCustomerID  = customerID;
        System.out.println(customerID);
        initComponents();
        viewTable();
    }
    
    public void infoMessage(String strMessage, String strTitle){
        JOptionPane.showMessageDialog(null, strMessage, strTitle, JOptionPane.INFORMATION_MESSAGE);
    }    
    
    public void viewTable(){
         try{
            String strDriver = "com.mysql.jdbc.Driver";
            String strConn = "jdbc:mysql://localhost:3306/swcdbms";
            String strUser = "root";
            String strPass = "";
            Class.forName(strDriver);
            Connection objConn = DriverManager.getConnection(strConn,strUser,strPass);
            
            String strQuery = "SELECT * FROM Pickup_Location WHERE customer_id = "+strCustomerID+"";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            ResultSet resSet = stmntQuery.executeQuery();
            DefaultTableModel table = (DefaultTableModel)pickupTable.getModel();
            table.setRowCount(0);
            while(resSet.next()){
                table.addRow(new String[]{resSet.getString(1),resSet.getString(2), resSet.getString(3),resSet.getString(4)});
            }
        }catch(Exception objError){
            System.out.println(objError);
        }  
    }
    
    public void clearFields(){
        pickupIDTF.setText("");
        locationNameTF.setText("");
        addressTF.setText("");
        customerIDTF.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        locationNameTF = new javax.swing.JTextField();
        addressTF = new javax.swing.JTextField();
        customerIDTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pickupTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pickupIDTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pickup Location");

        jLabel4.setText("Customer ID:");

        locationNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationNameTFActionPerformed(evt);
            }
        });

        addressTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTFActionPerformed(evt);
            }
        });

        customerIDTF.setEditable(false);
        customerIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDTFActionPerformed(evt);
            }
        });

        pickupTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "pickup_ID", "location_name", "address", "customer_ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jLabel2.setText("Location Name");

        jLabel1.setText("Pickup ID:");

        jLabel3.setText("Address:");

        pickupIDTF.setEditable(false);
        pickupIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickupIDTFActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setText("ADD | EDIT | REMOVE PICK UP LOCATION");

        addBtn.setText("Add");
        addBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(customerIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(updateBtn)
                            .addGap(18, 18, 18)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pickupIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(locationNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pickupIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateBtn)
                        .addComponent(addBtn)
                        .addComponent(deleteBtn)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
        );

        setBounds(160, 50, 691, 393);
    }// </editor-fold>//GEN-END:initComponents

    private void locationNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationNameTFActionPerformed

    private void addressTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTFActionPerformed

    private void customerIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIDTFActionPerformed

    private void pickupTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pickupTableMouseClicked
        DefaultTableModel table = (DefaultTableModel)pickupTable.getModel();
        int intSelectedRows = pickupTable.getSelectedRow();

        pickupIDTF.setText(table.getValueAt(intSelectedRows, 0).toString());
        locationNameTF.setText(table.getValueAt(intSelectedRows, 1).toString());
        addressTF.setText(table.getValueAt(intSelectedRows, 2).toString());
        customerIDTF.setText(table.getValueAt(intSelectedRows, 3).toString());
    }//GEN-LAST:event_pickupTableMouseClicked

    private void pickupIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickupIDTFActionPerformed

    }//GEN-LAST:event_pickupIDTFActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
    String locationName = locationNameTF.getText();
    String locationAddress = addressTF.getText();
    String locationID = pickupIDTF.getText();
        
        try {
            String strDriver = "com.mysql.jdbc.Driver";
            String strConn = "jdbc:mysql://localhost:3306/swcdbms";
            String strUser = "root";
            String strPass = "";
            Class.forName(strDriver);
            Connection objConn = DriverManager.getConnection(strConn,strUser,strPass);
            
            String strQuery = "DELETE FROM pickup_location WHERE pickup_id ="+locationID+" AND customer_id ="+strCustomerID+"";
            Statement statementQuery = objConn.createStatement();
            int intConfirmation = statementQuery.executeUpdate(strQuery);
            if (intConfirmation == 1){
            infoMessage("Pickup Location Deleted.", "SUCCESS!");
            }
            } catch(Exception objError){
            System.out.println(objError);
            }
        viewTable();
        pickupIDTF.setText("");
        locationNameTF.setText("");
        addressTF.setText("");
        customerIDTF.setText("");
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
    String locationName = locationNameTF.getText();
    String locationAddress = addressTF.getText();
    String locationID = pickupIDTF.getText();
        
        try {
            String strDriver = "com.mysql.jdbc.Driver";
            String strConn = "jdbc:mysql://localhost:3306/swcdbms";
            String strUser = "root";
            String strPass = "";
            Class.forName(strDriver);
            Connection objConn = DriverManager.getConnection(strConn,strUser,strPass);
            
            String strQuery = "UPDATE pickup_location SET location_name ='"+locationName+"', pickup_address ='"+locationAddress+"' WHERE pickup_id = "+locationID+" AND customer_id = "+strCustomerID+"";
            Statement statementQuery = objConn.createStatement();
            int intConfirmation = statementQuery.executeUpdate(strQuery);
            if (intConfirmation == 1){
            infoMessage("Pickup Location Updated.", "SUCCESS!");
            }
            else {
            infoMessage("Error updating.", "ERROR!");
            }
            } catch(Exception objError){
            System.out.println(objError);
            }
        viewTable();
        pickupIDTF.setText("");
        locationNameTF.setText("");
        addressTF.setText("");
        customerIDTF.setText("");
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String locationName = locationNameTF.getText();
        String locationAddress = addressTF.getText();
        
        try {
            String strDriver = "com.mysql.jdbc.Driver";
            String strConn = "jdbc:mysql://localhost:3306/swcdbms";
            String strUser = "root";
            String strPass = "";
            Class.forName(strDriver);
            Connection objConn = DriverManager.getConnection(strConn,strUser,strPass);
            
            String strQuery = "INSERT INTO pickup_location VALUES(null,'"+locationName+"','"+locationAddress+"',"+strCustomerID+")";
            Statement statementQuery = objConn.createStatement();
            int intConfirmation = statementQuery.executeUpdate(strQuery);
            if (intConfirmation == 1){
            infoMessage("Pickup Location Added.", "SUCCESS!");
            }
            } catch(Exception objError){
            System.out.println(objError);
            }
        viewTable();
        pickupIDTF.setText("");
        locationNameTF.setText("");
        addressTF.setText("");
        customerIDTF.setText("");
    }//GEN-LAST:event_addBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField addressTF;
    private javax.swing.JTextField customerIDTF;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField locationNameTF;
    private javax.swing.JTextField pickupIDTF;
    private javax.swing.JTable pickupTable;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
