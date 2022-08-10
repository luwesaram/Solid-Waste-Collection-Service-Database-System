package wastecollectiondbms;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
public class AddWasteTransaction extends javax.swing.JInternalFrame {

    File file = null;
    String path = null;
    private ImageIcon format = null;
    String strCustomerID;
    
    Connection objConn;
    PreparedStatement prepState;
    ResultSet resSet;

    public AddWasteTransaction(String customerID) {
        this.strCustomerID = customerID;
        System.out.println(strCustomerID);
        getConnection();
        initComponents();
        fillWasteTypeCB();
        fillTransactionCB();
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wasteTypeCB = new javax.swing.JComboBox<>();
        browseBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        labelImage = new javax.swing.JLabel();
        unitTypeCB = new javax.swing.JComboBox<>();
        imagePathTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        wasteAmountTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        wasteIDTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txnIDCB = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txnStatusTF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        wasteTypeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Waste Type" }));
        wasteTypeCB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        wasteTypeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wasteTypeCBActionPerformed(evt);
            }
        });

        browseBtn.setText("Browse Image");
        browseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Container Type:");

        labelImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        unitTypeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Garbage Bag", "Bin", "Others" }));
        unitTypeCB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        imagePathTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagePathTFActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Quantity:");

        wasteAmountTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wasteAmountTFActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Waste Image:");

        addBtn.setText("Confirm Transaction");
        addBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("ID:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Add Waste Type:");

        wasteIDTF.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("ADD WASTE DETAILS");

        txnIDCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transaction ID" }));
        txnIDCB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txnIDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnIDCBActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Transaction ID");

        txnStatusTF.setEditable(false);
        txnStatusTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnStatusTFActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Transaction Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(wasteTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(unitTypeCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(wasteAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wasteIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txnIDCB, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txnStatusTF, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(imagePathTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(browseBtn)
                        .addGap(90, 90, 90))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txnIDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(txnStatusTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wasteTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wasteIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unitTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(imagePathTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wasteAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseBtn))
                .addGap(18, 18, 18)
                .addComponent(addBtn)
                .addGap(21, 21, 21))
        );

        setBounds(240, 40, 508, 431);
    }// </editor-fold>//GEN-END:initComponents

        public void fillWasteTypeCB(){
        try{
            String strQuery = "SELECT waste_type FROM solidwaste";
            Statement stmntQuery = objConn.createStatement();
            ResultSet result = stmntQuery.executeQuery(strQuery);
            
            while(result.next()){
                wasteTypeCB.addItem(result.getString("waste_type"));
            }
            
        }catch(Exception objError){
            System.out.println(objError);
        }
    }
    
    public void fillTransactionCB(){
        try{
            String strQuery = "SELECT txn_id FROM transaction WHERE customer_id = "+strCustomerID+"";
            Statement stmntQuery = objConn.createStatement();
            ResultSet result = stmntQuery.executeQuery(strQuery);
            
            while(result.next()){
                txnIDCB.addItem(result.getString("txn_id"));
            }
            
        }catch(Exception objError){
            System.out.println(objError);
        }
    }
    
    public void clearFields() {
        wasteTypeCB.setSelectedIndex(0);
        txnIDCB.setSelectedIndex(0);
        unitTypeCB.setSelectedIndex(0);
        wasteIDTF.setText("");
        labelImage.setIcon(null);
        imagePathTF.setText("");
        txnStatusTF.setText("");
        wasteAmountTF.setText("");
    }
        
    private void wasteTypeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wasteTypeCBActionPerformed
        String wasteType = (String)wasteTypeCB.getSelectedItem();
        try{
            String strQuery = "SELECT waste_id FROM solidwaste WHERE waste_type ='"+wasteType+"'";
            Statement stmntQuery = objConn.createStatement();
            ResultSet result = stmntQuery.executeQuery(strQuery);

            if(result.next()== true){
                wasteIDTF.setText(result.getString("waste_id"));
            }
            else{
                wasteIDTF.setText("");
            }
        }catch(Exception objError){
            System.out.println(objError);
        }
    }//GEN-LAST:event_wasteTypeCBActionPerformed

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

    private void wasteAmountTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wasteAmountTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wasteAmountTFActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        File file = new File(path);
        String strTxnStatus = txnStatusTF.getText();
        System.out.println(strTxnStatus);
        
        if (strTxnStatus.equals("For Review")){
            try {
                String strTxnID = (String)txnIDCB.getSelectedItem();
                String strWasteID = wasteIDTF.getText();
                String strUnitType = (String)unitTypeCB.getSelectedItem();
                String strWasteAmount = wasteAmountTF.getText();
                InputStream inputStream = new FileInputStream(file);

                prepState = objConn.prepareStatement("INSERT INTO transaction_detail(txn_id,waste_id,waste_amount,waste_photo,container_type) VALUES(?,?,?,?,?)");
                prepState.setString(1, strTxnID);
                prepState.setString(2, strWasteID);
                prepState.setString(3, strWasteAmount);
                prepState.setBlob(4, inputStream);
                prepState.setString(5, strUnitType);

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
        }
        else {
            infoMessage("Transaction must be for review.", "ERROR!");
        }
        
    }//GEN-LAST:event_addBtnActionPerformed

    private void txnIDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnIDCBActionPerformed
        String txnID = (String)txnIDCB.getSelectedItem();
        try{
            String strQuery = "SELECT txn_status FROM transaction WHERE txn_id ="+txnID+" AND customer_id = "+strCustomerID+"";
            Statement stmntQuery = objConn.createStatement();
            ResultSet result = stmntQuery.executeQuery(strQuery);

            if(result.next()== true){
                txnStatusTF.setText(result.getString("txn_status"));
            }
            else{
                txnStatusTF.setText("");
            }
        }catch(Exception objError){
            System.out.println(objError);
        }
    }//GEN-LAST:event_txnIDCBActionPerformed

    private void txnStatusTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnStatusTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnStatusTFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton browseBtn;
    private javax.swing.JTextField imagePathTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelImage;
    private javax.swing.JComboBox<String> txnIDCB;
    private javax.swing.JTextField txnStatusTF;
    private javax.swing.JComboBox<String> unitTypeCB;
    private javax.swing.JTextField wasteAmountTF;
    private javax.swing.JTextField wasteIDTF;
    private javax.swing.JComboBox<String> wasteTypeCB;
    // End of variables declaration//GEN-END:variables
}
