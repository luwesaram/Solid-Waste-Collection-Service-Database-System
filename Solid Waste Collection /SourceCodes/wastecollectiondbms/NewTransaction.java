package wastecollectiondbms;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class NewTransaction extends javax.swing.JInternalFrame {
File file = null;
String path = null;
private ImageIcon format = null;

Connection objConn;
PreparedStatement prepState;
ResultSet resSet;

    String strCustomerID;
    public NewTransaction(String customerID) {
        this.strCustomerID = customerID;
        System.out.println(strCustomerID);
        getConnection();
        initComponents();
        fillLocationCB();
        setDate();
    }
    
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
    
    public void fillLocationCB(){
        try{
            
            String strQuery = "SELECT location_name, pickup_id FROM pickup_location WHERE customer_id="+strCustomerID+"";
            Statement stmntQuery = objConn.createStatement();
            ResultSet result = stmntQuery.executeQuery(strQuery);
            
            while(result.next()){
                pickupCB.addItem(result.getString("location_name"));
            }
            
        }catch(Exception objError){
            System.out.println(objError);
        }
    }
     
    public void setDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String strDate = dateFormat.format(date);
        txndateTF.setText(strDate);
    }
    
    public void clearFields() {
        paymentMethodCB.setSelectedIndex(0);
        pickupCB.setSelectedIndex(0);
        pickupIDTF.setText("");
        labelImage.setIcon(null);
        imagePathTF.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pickupCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        paymentMethodCB = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txndateTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pickupIDTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        browseBtn = new javax.swing.JButton();
        labelImage = new javax.swing.JLabel();
        imagePathTF = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("New Transaction");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("NEW TRANSACTION");

        pickupCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pickup Location" }));
        pickupCB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pickupCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickupCBActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Pick-up Location:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Payment Method:");

        paymentMethodCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VISA", "Invoice" }));
        paymentMethodCB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Date:");

        txndateTF.setEditable(false);
        txndateTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txndateTFActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Permit Image:");

        pickupIDTF.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("ID:");

        addBtn.setText("Confirm Transaction");
        addBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        browseBtn.setText("Browse Image");
        browseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBtnActionPerformed(evt);
            }
        });

        labelImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        imagePathTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagePathTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pickupCB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pickupIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txndateTF)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(paymentMethodCB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(imagePathTF, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(labelImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(browseBtn)
                        .addGap(84, 84, 84))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(imagePathTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE)
                        .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browseBtn))
                    .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pickupCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pickupIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentMethodCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txndateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );

        setBounds(240, 50, 499, 413);
    }// </editor-fold>//GEN-END:initComponents

    private void txndateTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txndateTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txndateTFActionPerformed

    private void pickupCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickupCBActionPerformed
        String locationName = (String)pickupCB.getSelectedItem();
        try{
            String strQuery = "SELECT pickup_id FROM pickup_location WHERE customer_id="+strCustomerID+" AND location_name ='"+locationName+"'";
            Statement stmntQuery = objConn.createStatement();
            ResultSet result = stmntQuery.executeQuery(strQuery);
            
            if(result.next()== true){
                pickupIDTF.setText(result.getString("pickup_id"));
            }
            else{
                pickupIDTF.setText("");
            }
        }catch(Exception objError){
            System.out.println(objError);
        }
    }//GEN-LAST:event_pickupCBActionPerformed

    private void browseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpg","jpeg");
        fileChooser.addChoosableFileFilter(fnwf);
        int load = fileChooser.showOpenDialog(null);
        
        if(load == fileChooser.APPROVE_OPTION){
            file = fileChooser.getSelectedFile();
            
            path = file.getAbsolutePath();
            imagePathTF.setText(path);
            ImageIcon imgIcon = new ImageIcon(path);
            Image img = imgIcon.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH);
            labelImage.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_browseBtnActionPerformed

    private void imagePathTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagePathTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imagePathTFActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        File file = new File(path);
        try {
            String strPickupID = pickupIDTF.getText();
            String strPaymentMethod = (String)paymentMethodCB.getSelectedItem();
            String strDate = txndateTF.getText();
            String strTxnStatus = "For Review";
            InputStream inputStream = new FileInputStream(file);
            String strQuery = "INSERT INTO transaction VALUES(null, '"+strDate+"', null, '"+strTxnStatus+"','"+strPaymentMethod+"', null, null, "+strCustomerID+", "+strPickupID+", null, null, null)";
            prepState = objConn.prepareStatement(strQuery, Statement.RETURN_GENERATED_KEYS);
            prepState.executeUpdate();
            resSet = prepState.getGeneratedKeys();
            resSet.next();
            String strTxnID = String.valueOf(resSet.getInt(1));
            System.out.println(strTxnID);
            
            prepState = objConn.prepareStatement("UPDATE transaction set txn_permit = ? WHERE txn_id = "+strTxnID+" AND customer_id = "+strCustomerID+"");
            prepState.setBlob(1, inputStream);
            
            int check = prepState.executeUpdate();
            if (check > 0 ){
                infoMessage("Transaction Successful","SUCCESS");
                clearFields();
            }
            else{
                infoMessage("Error.", "ERROR!");
            }
        } catch (FileNotFoundException | SQLException ex) {
            infoMessage("Error. Some values are missing.", "ERROR!");
            java.util.logging.Logger.getLogger(NewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton browseBtn;
    private javax.swing.JTextField imagePathTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelImage;
    private javax.swing.JComboBox<String> paymentMethodCB;
    private javax.swing.JComboBox<String> pickupCB;
    private javax.swing.JTextField pickupIDTF;
    private javax.swing.JTextField txndateTF;
    // End of variables declaration//GEN-END:variables
}
