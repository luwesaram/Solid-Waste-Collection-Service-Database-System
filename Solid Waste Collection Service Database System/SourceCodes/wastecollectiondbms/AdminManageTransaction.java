package wastecollectiondbms;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminManageTransaction extends javax.swing.JInternalFrame {

Connection objConn;
PreparedStatement prepState;
ResultSet resSet;    
    
    public AdminManageTransaction() {
        initComponents();
        getConnection();
        viewTable();
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
            
    public void viewTable(){
        try{
            
            String strQuery = "SELECT txn_id, txn_date, txn_pickup_date, txn_status, txn_payment_method, txn_cost, txn_payment, customer_id, pickup_id, driver_id, facility_id FROM transaction";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            resSet = stmntQuery.executeQuery();
            DefaultTableModel table = (DefaultTableModel)txnTable.getModel();
            
            table.setRowCount(0);
            while(resSet.next()){
                table.addRow(new String[]{resSet.getString(1),resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getString(5),resSet.getString(6),resSet.getString(7),resSet.getString(8),resSet.getString(9),resSet.getString(10),resSet.getString(11)});
            }
            
        }catch(Exception objError){
            System.out.println(objError);
        }
    }
    
    public void viewTxnDetailsTable(){
        try{
            String strTxnID = txnIDTF.getText();
            String strQuery = "SELECT a.txn_id, a.item_id, b.waste_type, a.waste_amount, a.container_type FROM transaction_detail a, solidwaste b, transaction c WHERE a.waste_id = b.waste_id AND a.txn_id = c.txn_id AND a.txn_id = "+strTxnID+"";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            resSet = stmntQuery.executeQuery();
            DefaultTableModel table = (DefaultTableModel)txnDetailsTable.getModel();
            
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

        txnIDTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        updateIDBtn = new javax.swing.JButton();
        viewAllBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txnTable = new javax.swing.JTable();
        facilityIDTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        driverIDTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txnDetailsTable = new javax.swing.JTable();
        txnStatusCB = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txnCostTF = new javax.swing.JTextField();
        updateCostBtn = new javax.swing.JButton();
        updateStatus = new javax.swing.JButton();
        searchTFtxn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        searchTFtxnd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        searchTxnBtn = new javax.swing.JButton();
        searchTxnDBtn = new javax.swing.JButton();
        permitImage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        wasteImage = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        itemIDTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Manage Transaction");

        txnIDTF.setEditable(false);
        txnIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnIDTFActionPerformed(evt);
            }
        });

        jLabel4.setText("Facility ID:");

        updateIDBtn.setText("Update IDs");
        updateIDBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateIDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateIDBtnActionPerformed(evt);
            }
        });

        viewAllBtn.setText("View All");
        viewAllBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Transaction ID:");

        jLabel2.setText("Transaction Status:");

        txnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "txn_ID", "txn_Date", "txn_Pickup-Date", "txn_Status", "Payment Method", "Cost", "Payment", "CustomerID", "PickupID", "DriverID", "FacilityID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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

        facilityIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facilityIDTFActionPerformed(evt);
            }
        });

        jLabel6.setText("Driver ID:");

        driverIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driverIDTFActionPerformed(evt);
            }
        });

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

        txnStatusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "For Payment", "For Pickup", "Done" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel10.setText("VIEW TRANSACTION DETAILS");

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel12.setText("VIEW / EDIT TRANSACTION");

        jLabel13.setText("Cost:");

        txnCostTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnCostTFActionPerformed(evt);
            }
        });

        updateCostBtn.setText("Update Cost");
        updateCostBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateCostBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCostBtnActionPerformed(evt);
            }
        });

        updateStatus.setText("Update Status");
        updateStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStatusActionPerformed(evt);
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

        searchTFtxnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTFtxndActionPerformed(evt);
            }
        });
        searchTFtxnd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTFtxndKeyReleased(evt);
            }
        });

        jLabel7.setText("Search:");

        searchTxnBtn.setText("Search");
        searchTxnBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchTxnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxnBtnActionPerformed(evt);
            }
        });

        searchTxnDBtn.setText("Search");
        searchTxnDBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchTxnDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxnDBtnActionPerformed(evt);
            }
        });

        permitImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        permitImage.setText("Click Image to Enlarge.");
        permitImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        permitImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                permitImageMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel9.setText("PERMIT PHOTO");

        wasteImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wasteImage.setText("Click Image to Enlarge.");
        wasteImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        wasteImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wasteImageMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel11.setText("WASTE PHOTO");

        itemIDTF.setEditable(false);
        itemIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIDTFActionPerformed(evt);
            }
        });

        jLabel3.setText("Item ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(permitImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wasteImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel11)))
                .addGap(0, 33, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txnCostTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txnIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(facilityIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(driverIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(updateCostBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(viewAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txnStatusCB, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateIDBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTFtxn, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(searchTxnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itemIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchTFtxnd, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchTxnDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(searchTFtxn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(searchTxnBtn))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(updateCostBtn)
                                            .addComponent(viewAllBtn)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txnStatusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateIDBtn))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txnIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(facilityIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(txnCostTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(driverIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTxnDBtn)
                            .addComponent(searchTFtxnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(permitImage, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wasteImage, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );

        setBounds(90, 20, 818, 514);
    }// </editor-fold>//GEN-END:initComponents

    private void txnIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnIDTFActionPerformed

    private void txnTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txnTableMouseClicked
        DefaultTableModel table = (DefaultTableModel)txnTable.getModel();
        int intSelectedRows = txnTable.getSelectedRow();
        
        txnIDTF.setText(table.getValueAt(intSelectedRows, 0).toString());
        
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
    }//GEN-LAST:event_txnTableMouseClicked

    private void facilityIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilityIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facilityIDTFActionPerformed

    private void driverIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driverIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_driverIDTFActionPerformed

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

    private void updateIDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateIDBtnActionPerformed
        String strTxnID = txnIDTF.getText();
        String strDriverID = driverIDTF.getText();
        String strFacilityID = facilityIDTF.getText();
        try{
            
            String strQuery = "UPDATE transaction SET driver_id ='"+strDriverID+"', facility_id = '"+strFacilityID+"' WHERE txn_id ="+strTxnID+"";
            Statement stmntQuery = objConn.prepareStatement(strQuery);
            int intConfirmation = stmntQuery.executeUpdate(strQuery);
            if (intConfirmation == 1){
            infoMessage("Driver and Facility ID Updated.", "SUCCESS!");
            }
            else{
                infoMessage("Error updating driver and facility ID.", "ALERT!");
            }
        }catch(Exception objError){
            System.out.println(objError);
        }
        viewTable();
    }//GEN-LAST:event_updateIDBtnActionPerformed

    private void txnCostTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnCostTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnCostTFActionPerformed

    private void updateCostBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCostBtnActionPerformed
        String strTxnID = txnIDTF.getText();
        String strTxnCost = txnCostTF.getText();
        try{
            
            String strQuery = "UPDATE transaction SET txn_cost ='"+strTxnCost+"' WHERE txn_id ="+strTxnID+"";
            Statement stmntQuery = objConn.prepareStatement(strQuery);
            int intConfirmation = stmntQuery.executeUpdate(strQuery);
            if (intConfirmation == 1){
            infoMessage("Cost Updated.", "SUCCESS!");
            }
            else{
                infoMessage("Error updating cost.", "ALERT!");
            }
        }catch(Exception objError){
            System.out.println(objError);
        }
    }//GEN-LAST:event_updateCostBtnActionPerformed

    private void viewAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllBtnActionPerformed
        viewTable();
    }//GEN-LAST:event_viewAllBtnActionPerformed

    private void updateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStatusActionPerformed
        String strTxnID = txnIDTF.getText();
        String strStatus = (String)txnStatusCB.getSelectedItem();
        try{
            
            String strQuery = "UPDATE transaction SET txn_status ='"+strStatus+"' WHERE txn_id ="+strTxnID+"";
            Statement stmntQuery = objConn.prepareStatement(strQuery);
            int intConfirmation = stmntQuery.executeUpdate(strQuery);
            if (intConfirmation == 1){
            infoMessage("Status Updated.", "SUCCESS!");
            }
            else{
                infoMessage("Error updating status.", "ALERT!");
            }
        }catch(Exception objError){
            System.out.println(objError);
        }
        viewTable();
    }//GEN-LAST:event_updateStatusActionPerformed

    private void searchTFtxnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFtxnActionPerformed

    }//GEN-LAST:event_searchTFtxnActionPerformed

    private void searchTFtxndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFtxndActionPerformed

    }//GEN-LAST:event_searchTFtxndActionPerformed

    private void searchTFtxnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFtxnKeyReleased

    }//GEN-LAST:event_searchTFtxnKeyReleased

    private void searchTFtxndKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFtxndKeyReleased

    }//GEN-LAST:event_searchTFtxndKeyReleased

    private void searchTxnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxnBtnActionPerformed

        String strSearch = searchTFtxn.getText();
        try{
            String strQuery = "SELECT txn_id, txn_date, txn_pickup_date, txn_status, txn_payment_method, txn_cost, txn_payment, customer_id, pickup_id, driver_id, facility_id FROM transaction WHERE txn_status LIKE '"+strSearch+"%'";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            resSet = stmntQuery.executeQuery();
            DefaultTableModel table = (DefaultTableModel)txnTable.getModel();
            
            table.setRowCount(0);
            while(resSet.next()){
                table.addRow(new String[]{resSet.getString(1),resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getString(5),resSet.getString(6),resSet.getString(7),resSet.getString(8),resSet.getString(9),resSet.getString(10),resSet.getString(11)});
            }
            
        }catch(Exception objError){
            System.out.println(objError);
        }

    }//GEN-LAST:event_searchTxnBtnActionPerformed

    private void searchTxnDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxnDBtnActionPerformed

        String strSearch = searchTFtxnd.getText();
        try{
            String strQuery = "SELECT a.txn_id, a.item_id, b.waste_type, a.waste_amount, a.container_type FROM transaction_detail a, solidwaste b, transaction c WHERE a.waste_id = b.waste_id AND a.txn_id = c.txn_id AND (b.waste_type LIKE '"+strSearch+"%' OR a.container_type LIKE '"+strSearch+"%')";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            resSet = stmntQuery.executeQuery();
            DefaultTableModel table = (DefaultTableModel)txnDetailsTable.getModel();
            
            table.setRowCount(0);
            while(resSet.next()){
                table.addRow(new String[]{resSet.getString(1),resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getString(5)});
            }
            
        }catch(Exception objError){
            System.out.println(objError);
        }
        
    }//GEN-LAST:event_searchTxnDBtnActionPerformed

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

    private void itemIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemIDTFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField driverIDTF;
    private javax.swing.JTextField facilityIDTF;
    private javax.swing.JTextField itemIDTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel permitImage;
    private javax.swing.JTextField searchTFtxn;
    private javax.swing.JTextField searchTFtxnd;
    private javax.swing.JButton searchTxnBtn;
    private javax.swing.JButton searchTxnDBtn;
    private javax.swing.JTextField txnCostTF;
    private javax.swing.JTable txnDetailsTable;
    private javax.swing.JTextField txnIDTF;
    private javax.swing.JComboBox<String> txnStatusCB;
    private javax.swing.JTable txnTable;
    private javax.swing.JButton updateCostBtn;
    private javax.swing.JButton updateIDBtn;
    private javax.swing.JButton updateStatus;
    private javax.swing.JButton viewAllBtn;
    private javax.swing.JLabel wasteImage;
    // End of variables declaration//GEN-END:variables
}
