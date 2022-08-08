package wastecollectiondbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class EditBusiness extends javax.swing.JInternalFrame {

    Connection objConn;
    PreparedStatement prepState;
    ResultSet resSet;
    
    public void infoMessage(String strMessage, String strTitle){
        JOptionPane.showMessageDialog(null, strMessage, strTitle, JOptionPane.INFORMATION_MESSAGE);
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
    
    String strCustomerID;
    public EditBusiness(String customerID) {
        this.strCustomerID = customerID;
        System.out.println(strCustomerID);
        initComponents();
        getConnection();
        try{
            
            String strQuery = "SELECT * FROM BUSINESS WHERE customer_id ="+strCustomerID+"";
            Statement stmntQuery = objConn.prepareStatement(strQuery);
            resSet = stmntQuery.executeQuery(strQuery);
            resSet.next();
            
            String businessName = resSet.getString(2);
            String businessType = resSet.getString(3);
            String businessCity = resSet.getString(4);
            String businessStreet = resSet.getString(5);
            String businessBarangay = resSet.getString(6);
            String businessContactNo = resSet.getString(7);
            
            businessNameTF.setText(businessName);
            businessTypeTF.setText(businessType);
            businessCityTF.setText(businessCity);
            businessStreetTF.setText(businessStreet);
            businessBarangayTF.setText(businessBarangay);
            businessContactTF.setText(businessContactNo); 
        }catch(Exception objError){
            System.out.println(objError);
        }  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        businessNameTF = new javax.swing.JTextField();
        businessCityTF = new javax.swing.JTextField();
        businessStreetTF = new javax.swing.JTextField();
        businessBarangayTF = new javax.swing.JTextField();
        editBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        businessContactTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        businessTypeTF = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Edit Business Profile");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Barangay:");

        businessNameTF.setEditable(false);
        businessNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                businessNameTFActionPerformed(evt);
            }
        });

        businessCityTF.setEditable(false);
        businessCityTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                businessCityTFActionPerformed(evt);
            }
        });

        businessStreetTF.setEditable(false);
        businessStreetTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                businessStreetTFActionPerformed(evt);
            }
        });

        businessBarangayTF.setEditable(false);
        businessBarangayTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                businessBarangayTFActionPerformed(evt);
            }
        });

        editBtn.setText("Edit Business");
        editBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update Business");
        updateBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setText("BUSINESS PROFILE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("City:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Street:");

        addBtn.setText("Add Business");
        addBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Contact:");

        businessContactTF.setEditable(false);
        businessContactTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                businessContactTFActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Type:");

        businessTypeTF.setEditable(false);
        businessTypeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                businessTypeTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(businessNameTF))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(businessTypeTF)
                                    .addComponent(businessContactTF)
                                    .addComponent(businessCityTF)
                                    .addComponent(businessStreetTF)
                                    .addComponent(businessBarangayTF))))
                        .addGap(81, 81, 81))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(editBtn)
                        .addGap(50, 50, 50)
                        .addComponent(addBtn)
                        .addGap(39, 39, 39)
                        .addComponent(updateBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(businessNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(businessTypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(businessCityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(businessStreetTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(businessBarangayTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(businessContactTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        setBounds(260, 50, 483, 406);
    }// </editor-fold>//GEN-END:initComponents

    private void businessNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_businessNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_businessNameTFActionPerformed

    private void businessCityTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_businessCityTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_businessCityTFActionPerformed

    private void businessStreetTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_businessStreetTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_businessStreetTFActionPerformed

    private void businessBarangayTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_businessBarangayTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_businessBarangayTFActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        businessNameTF.setEditable(true);
        businessTypeTF.setEditable(true);
        businessCityTF.setEditable(true);
        businessStreetTF.setEditable(true);
        businessBarangayTF.setEditable(true);
        businessContactTF.setEditable(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String businessName = businessNameTF.getText();
        String businessType = businessTypeTF.getText();
        String businessCity = businessCityTF.getText();
        String businessStreet = businessStreetTF.getText();
        String businessBarangay = businessBarangayTF.getText();
        String businessContact = businessContactTF.getText();
        
        try{            
            String strQuery = "UPDATE business SET business_name ='"+businessName+"', business_type ='"+businessType+"', business_city ='"+businessCity+"', business_street ='"+businessStreet+"', business_barangay ='"+businessBarangay+"', business_contactno ='"+businessContact+"' WHERE customer_id ="+strCustomerID+"";
            Statement stmntQuery = objConn.createStatement();
            int intConfirmation = stmntQuery.executeUpdate(strQuery);
            if (intConfirmation == 1){
            infoMessage("Business Profile Updated.", "SUCCESS!");
            
            }
            else{
                infoMessage("Error updating business profile.", "ALERT!");
            }
        }catch(Exception objError){
            System.out.println(objError);
        } 
        businessNameTF.setEditable(false);
        businessTypeTF.setEditable(false);
        businessCityTF.setEditable(false);
        businessStreetTF.setEditable(false);
        businessBarangayTF.setEditable(false);
        businessContactTF.setEditable(false);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String businessName = businessNameTF.getText();
        String businessType = businessTypeTF.getText();
        String businessCity = businessCityTF.getText();
        String businessStreet = businessStreetTF.getText();
        String businessBarangay = businessBarangayTF.getText();
        String businessContact = businessContactTF.getText();
        
        try{
            
            String strCheck = "SELECT customer_ID FROM BUSINESS WHERE customer_id ="+strCustomerID+"";
            Statement checkID = objConn.createStatement();
            ResultSet resultCheckID = checkID.executeQuery(strCheck);
            if (resultCheckID.next()==true){
                infoMessage("The user already has a business profile.", "Error!");
            } else {
                String strQuery = "INSERT INTO business VALUES(null,'"+businessName+"','"+businessType+"','"+businessCity+"','"+businessStreet+"','"+businessBarangay+"','"+businessContact+"',"+strCustomerID+")";
                Statement statementQuery = objConn.createStatement();
                int intConfirmation = statementQuery.executeUpdate(strQuery);
                if (intConfirmation == 1){
                    infoMessage("Successfully added Business Info.", "SUCCESS!");
                }
            }
             
        }catch(Exception objError){
            System.out.println(objError);
        }  
        businessNameTF.setEditable(false);
        businessTypeTF.setEditable(false);
        businessCityTF.setEditable(false);
        businessStreetTF.setEditable(false);
        businessBarangayTF.setEditable(false);
        businessContactTF.setEditable(false);
    }//GEN-LAST:event_addBtnActionPerformed

    private void businessContactTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_businessContactTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_businessContactTFActionPerformed

    private void businessTypeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_businessTypeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_businessTypeTFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField businessBarangayTF;
    private javax.swing.JTextField businessCityTF;
    private javax.swing.JTextField businessContactTF;
    private javax.swing.JTextField businessNameTF;
    private javax.swing.JTextField businessStreetTF;
    private javax.swing.JTextField businessTypeTF;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
