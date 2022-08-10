package wastecollectiondbms;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class CustomerManageTransaction extends javax.swing.JInternalFrame {
private ImageIcon format = null;
Connection objConn;
PreparedStatement prepState;
ResultSet resSet;

    String strCustomerID;
    public CustomerManageTransaction(String customerID) {
        this.strCustomerID = customerID;
        System.out.println(strCustomerID);
        initComponents();
        getConnection();
        viewTxnTable();
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
    
    public void infoMessage(String strMessage, String strTitle){
        JOptionPane.showMessageDialog(null, strMessage, strTitle, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void viewTxnTable(){
        try{
            String strQuery = "SELECT a.txn_id, a.txn_date, a.txn_pickup_date, a.txn_status, a.txn_payment_method, a.txn_cost, a.txn_payment FROM transaction a, customer b WHERE a.customer_id = b.customer_id AND a.customer_id ="+strCustomerID+"";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            ResultSet resSet = stmntQuery.executeQuery();
            DefaultTableModel table = (DefaultTableModel)txnTable.getModel();
            
            table.setRowCount(0);
            while(resSet.next()){
                table.addRow(new String[]{resSet.getString(1),resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getString(5),resSet.getString(6),resSet.getString(7)});
            }
        }catch(Exception objError){
            System.out.println(objError);
        }
    }
        
    public void viewTxnDetailsTable(){
        try{
            String strTxnID = txnIDTF.getText();
            String strQuery = "SELECT a.txn_id, a.item_id, b.waste_type, a.waste_amount, a.container_type FROM transaction_detail a, solidwaste b, transaction c WHERE a.waste_id = b.waste_id AND a.txn_id = c.txn_id AND c.customer_id ="+strCustomerID+" AND a.txn_id = "+strTxnID+"";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            ResultSet resSet = stmntQuery.executeQuery();
            DefaultTableModel table = (DefaultTableModel)txnDetailsTable.getModel();
            
            table.setRowCount(0);
            while(resSet.next()){
                table.addRow(new String[]{resSet.getString(1),resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getString(5)});
            }
        }catch(Exception objError){
            System.out.println(objError);
        }
    }
    
    public void viewDriverTable(){  
        try{
            String strTxnID = txnIDTF.getText();
            
            String strQuery = "SELECT a.txn_id, b.driver_lastname, b.driver_firstname, c.vehicle_type, c.vehicle_plateno FROM transaction a, driver b, vehicle c WHERE a.driver_id = b.driver_id AND b.driver_id = c.driver_id AND a.customer_id ="+strCustomerID+" AND a.txn_id = "+strTxnID+"";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            resSet = stmntQuery.executeQuery();
            DefaultTableModel table = (DefaultTableModel)driverDetailsTable.getModel();
            
            table.setRowCount(0);
            while(resSet.next()){
                table.addRow(new String[]{resSet.getString(1),resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getString(5)});
            }
        }catch(Exception objError){
            System.out.println(objError);
        }                
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txnTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txnDetailsTable = new javax.swing.JTable();
        permitImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pickupDateDC = new com.toedter.calendar.JDateChooser();
        txnIDTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txnStatusTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cancelTransaction = new javax.swing.JButton();
        confirmPickupDate = new javax.swing.JButton();
        confirmPayment = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        driverDetailsTable = new javax.swing.JTable();
        viewChangesBtn = new javax.swing.JButton();
        wasteImage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txnPaymentTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        itemIDTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Transaction List");

        txnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "txn_ID", "txn_Date", "PickupDate", "Status", "Payment Method", "Cost", "Payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        txnTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txnTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txnTable);

        txnDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "txn_ID", "item_ID", "waste_type", "amount", "container_type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        txnDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txnDetailsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(txnDetailsTable);

        permitImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        permitImage.setText("Click Image to Enlarge.");
        permitImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        permitImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                permitImageMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("TRANSACTION DETAILS");

        pickupDateDC.setDateFormatString("yyyy-MM-dd");

        txnIDTF.setEditable(false);

        jLabel2.setText("Transaction ID:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setText("MANAGE TRANSACTION");

        jLabel4.setText("Pick-up Date:");

        txnStatusTF.setEditable(false);

        jLabel5.setText("Status:");

        cancelTransaction.setText("Cancel Transaction");
        cancelTransaction.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelTransactionActionPerformed(evt);
            }
        });

        confirmPickupDate.setText("Confirm Pick-up Schedule");
        confirmPickupDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmPickupDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPickupDateActionPerformed(evt);
            }
        });

        confirmPayment.setText("Confirm Payment");
        confirmPayment.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPaymentActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel7.setText("DRIVER DETAILS");

        driverDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "txn_ID", "lastname", "firstname", "vehicle", "plateno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(driverDetailsTable);

        viewChangesBtn.setText("View Changes");
        viewChangesBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewChangesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewChangesBtnActionPerformed(evt);
            }
        });

        wasteImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wasteImage.setText("Click Image to Enlarge.");
        wasteImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        wasteImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wasteImageMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel8.setText("WASTE PHOTO");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel9.setText("PERMIT PHOTO");

        jLabel6.setText("Payment Amount:");

        itemIDTF.setEditable(false);

        jLabel10.setText("Item ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txnStatusTF, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(txnIDTF)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pickupDateDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txnPaymentTF, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(permitImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(confirmPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmPickupDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viewChangesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(wasteImage, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txnIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txnStatusTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pickupDateDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txnPaymentTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(permitImage, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewChangesBtn)
                                .addGap(22, 22, 22)
                                .addComponent(confirmPickupDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(confirmPayment)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelTransaction)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(jLabel7)))
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(itemIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addGap(2, 2, 2)
                        .addComponent(wasteImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        setBounds(90, 2, 810, 525);
    }// </editor-fold>//GEN-END:initComponents

    private void txnTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txnTableMouseClicked
        DefaultTableModel table = (DefaultTableModel)txnTable.getModel();
        int intSelectedRows = txnTable.getSelectedRow();
        
        txnIDTF.setText(table.getValueAt(intSelectedRows, 0).toString());
        txnStatusTF.setText(table.getValueAt(intSelectedRows, 3).toString());
        
        try{
            String strTxnID = txnIDTF.getText();
            String strQuery = "SELECT txn_permit FROM transaction WHERE txn_id = "+strTxnID+"";
            prepState = objConn.prepareStatement(strQuery);
            resSet = prepState.executeQuery();
            resSet.next();
            Blob blobImage = resSet.getBlob("txn_permit");
            InputStream inputStreamImg = blobImage.getBinaryStream();
            BufferedImage buffImage = ImageIO.read(inputStreamImg);
            ImageIcon imgIcon = new ImageIcon(buffImage);
            Image objImage = imgIcon.getImage().getScaledInstance(150,143, Image.SCALE_SMOOTH);
            permitImage.setIcon(new ImageIcon(objImage));
            
        } catch (Exception objError){
            System.out.println(objError);
            permitImage.setIcon(null);
        }
        
        viewTxnDetailsTable();
        viewDriverTable();
    }//GEN-LAST:event_txnTableMouseClicked

    private void txnDetailsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txnDetailsTableMouseClicked
        DefaultTableModel table = (DefaultTableModel)txnDetailsTable.getModel();
        int intSelectedRows = txnDetailsTable.getSelectedRow();
        
        itemIDTF.setText(table.getValueAt(intSelectedRows, 1).toString());
        
        try{
            String strItemID = itemIDTF.getText();
            String strQuery = "SELECT waste_photo FROM transaction_detail WHERE item_id = "+strItemID+"";
            prepState = objConn.prepareStatement(strQuery);
            resSet = prepState.executeQuery();
            resSet.next();
            Blob blobImage = resSet.getBlob("waste_photo");
            InputStream inputStreamImg = blobImage.getBinaryStream();
            BufferedImage buffImage = ImageIO.read(inputStreamImg);
            ImageIcon imgIcon = new ImageIcon(buffImage);
            Image objImage = imgIcon.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
            wasteImage.setIcon(new ImageIcon(objImage));
            
        } catch (Exception objError){
            System.out.println(objError);
            wasteImage.setIcon(null);
        }        
    }//GEN-LAST:event_txnDetailsTableMouseClicked

    private void cancelTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelTransactionActionPerformed
        String strTxnID = txnIDTF.getText();
        try {
            String strQuery = "UPDATE transaction SET txn_status = 'Cancelled' WHERE (txn_id ="+strTxnID+" AND customer_id = "+strCustomerID+") AND (txn_status = 'For Review' OR txn_status = 'For Payment')";
            Statement statementQuery = objConn.createStatement();
            int intConfirmation = statementQuery.executeUpdate(strQuery);
            viewTxnTable();
            if (intConfirmation == 1){
            infoMessage("Transaction Cancelled.", "SUCCESS!");
            
            }
            else{
                infoMessage("Error cancelling transaction. The status should be for review, or for payment to be cancelled.", "ERROR!");
            }
            } catch(Exception objError){
                infoMessage("Error cancelling transaction. The status should be for review, or for payment to be cancelled.", "ERROR!");
                System.out.println(objError);
            }
    }//GEN-LAST:event_cancelTransactionActionPerformed

    private void confirmPickupDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPickupDateActionPerformed
        String strTxnID = txnIDTF.getText();
        String strPickupDate = ((JTextField)pickupDateDC.getDateEditor().getUiComponent()).getText();
        System.out.println(strPickupDate);
        try {
            
            String strQuery = "UPDATE transaction SET txn_pickup_date ='"+strPickupDate+"'  WHERE (txn_id ="+strTxnID+" AND customer_id = "+strCustomerID+") AND (txn_status = 'For Scheduling')";
            Statement statementQuery = objConn.createStatement();
            int intConfirmation = statementQuery.executeUpdate(strQuery);
            viewTxnTable();
            if (intConfirmation == 1){
            infoMessage("Pick-up Date Scheduled.", "SUCCESS!");
            }
            else{
            infoMessage("Error scheduling pickup. The status should be for scheduling.", "ERROR!");
            }
            } catch(Exception objError){
            infoMessage("Error scheduling pickup. The status should be for scheduling.", "ERROR!");
            System.out.println(objError);
            }
    }//GEN-LAST:event_confirmPickupDateActionPerformed

    private void confirmPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPaymentActionPerformed
        String strTxnID = txnIDTF.getText();
        String strPayment = txnPaymentTF.getText();
        try {
            String strQuery = "UPDATE transaction SET txn_status = 'For Scheduling', txn_payment = "+strPayment+" WHERE (txn_id ="+strTxnID+" AND customer_id = "+strCustomerID+") AND (txn_status = 'For Payment' AND txn_cost IS NOT NULL)";
            Statement statementQuery = objConn.createStatement();
            int intConfirmation = statementQuery.executeUpdate(strQuery);
            viewTxnTable();
            if (intConfirmation == 1){
            infoMessage("Payment Confirmed.", "SUCCESS!");
            
            }
            else{
                infoMessage("Error confirming payment. The status should be for payment.", "ERROR!");
            }
            } catch(Exception objError){
                infoMessage("Error confirming payment. The status should be for payment.", "ERROR!");
                System.out.println(objError);
            }
        
    }//GEN-LAST:event_confirmPaymentActionPerformed

    private void viewChangesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewChangesBtnActionPerformed
        viewTxnTable();
    }//GEN-LAST:event_viewChangesBtnActionPerformed

    private void permitImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_permitImageMouseClicked
        String strTxnID = txnIDTF.getText();
        imageViewPermit imageViewer = new imageViewPermit(strTxnID);
        imageViewer.setVisible(true);
        imageViewer.setLocationRelativeTo(null);
    }//GEN-LAST:event_permitImageMouseClicked

    private void wasteImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wasteImageMouseClicked
        String strItemID = itemIDTF.getText();
        imageViewWaste imageViewer = new imageViewWaste(strItemID);
        imageViewer.setVisible(true);
        imageViewer.setLocationRelativeTo(null);
    }//GEN-LAST:event_wasteImageMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelTransaction;
    private javax.swing.JButton confirmPayment;
    private javax.swing.JButton confirmPickupDate;
    private javax.swing.JTable driverDetailsTable;
    private javax.swing.JTextField itemIDTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel permitImage;
    private com.toedter.calendar.JDateChooser pickupDateDC;
    private javax.swing.JTable txnDetailsTable;
    private javax.swing.JTextField txnIDTF;
    private javax.swing.JTextField txnPaymentTF;
    private javax.swing.JTextField txnStatusTF;
    private javax.swing.JTable txnTable;
    private javax.swing.JButton viewChangesBtn;
    private javax.swing.JLabel wasteImage;
    // End of variables declaration//GEN-END:variables
}
