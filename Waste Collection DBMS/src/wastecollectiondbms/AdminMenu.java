
package wastecollectiondbms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminMenu extends javax.swing.JFrame {

    Connection objConn;
    PreparedStatement prepState;
    ResultSet resSet;
    
    public void infoMessage(String strMessage, String strTitle){
        JOptionPane.showMessageDialog(null, strMessage, strTitle, JOptionPane.INFORMATION_MESSAGE);
    }
    public AdminMenu() {
        initComponents();
        connect();
    }
    
    public void connect(){
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        adminMenuLabel = new javax.swing.JLabel();
        adminMenuLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        exportCustomer = new javax.swing.JMenuItem();
        exportBusiness = new javax.swing.JMenuItem();
        exportDriver = new javax.swing.JMenuItem();
        exportFacility = new javax.swing.JMenuItem();
        exportTxn = new javax.swing.JMenuItem();
        exportTxnDetails = new javax.swing.JMenuItem();
        exportPickup = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Menu");
        setResizable(false);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 988, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );

        adminMenuLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        adminMenuLabel.setText("ADMIN MENU");

        adminMenuLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        adminMenuLabel1.setText("SOLID WASTE COLLECTION");

        jMenu1.setText("Customers");

        jMenuItem1.setText("View/Delete Customers");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu6.setText("Businesses");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("View Businesses");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Pick-up Locations");

        jMenuItem6.setText("View Pickup Location");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem6);

        jMenuBar1.add(jMenu7);

        jMenu2.setText("Transactions");

        jMenuItem4.setText("View/ Edit Transactions");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Drivers & Vehicles");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("View/Edit/Delete Drivers & Vehicles");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem5.setText("Add a Driver");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem7.setText("Add Vehicle Information");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Waste Facilities");

        jMenuItem9.setText("View/Edit/Delete Facility");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem8.setText("Add a Waste Facility");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        jMenu8.setText("Export");

        exportCustomer.setText("Export Customer Data");
        exportCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportCustomerActionPerformed(evt);
            }
        });
        jMenu8.add(exportCustomer);

        exportBusiness.setText("Export Business Data");
        exportBusiness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBusinessActionPerformed(evt);
            }
        });
        jMenu8.add(exportBusiness);

        exportDriver.setText("Export Driver Data");
        exportDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportDriverActionPerformed(evt);
            }
        });
        jMenu8.add(exportDriver);

        exportFacility.setText("Export Facility Data");
        exportFacility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFacilityActionPerformed(evt);
            }
        });
        jMenu8.add(exportFacility);

        exportTxn.setText("Export Transaction Data");
        exportTxn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportTxnActionPerformed(evt);
            }
        });
        jMenu8.add(exportTxn);

        exportTxnDetails.setText("Export Transaction Details");
        exportTxnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportTxnDetailsActionPerformed(evt);
            }
        });
        jMenu8.add(exportTxnDetails);

        exportPickup.setText("Export Pickup Location List");
        exportPickup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportPickupActionPerformed(evt);
            }
        });
        jMenu8.add(exportPickup);

        jMenuBar1.add(jMenu8);

        jMenu5.setText("Options");

        jMenuItem12.setText("Log-out");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(adminMenuLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(adminMenuLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminMenuLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminMenuLabel)
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        AdminManageTransaction manageTxn = new AdminManageTransaction();
        jDesktopPane1.add(manageTxn);
        manageTxn.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        AddDriver addDriver = new AddDriver();
        jDesktopPane1.add(addDriver);
        addDriver.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        AddDriver addDriverMenu = new AddDriver();
        jDesktopPane1.add(addDriverMenu);
        addDriverMenu.show();
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ViewAllDrivers allDrivers = new ViewAllDrivers();
        jDesktopPane1.add(allDrivers);
        allDrivers.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        AddFacility addFacilityMenu = new AddFacility();
        jDesktopPane1.add(addFacilityMenu);
        addFacilityMenu.show();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        ManageFacility addFacilityManage = new ManageFacility();
        jDesktopPane1.add(addFacilityManage);
        addFacilityManage.show();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed

    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        AdminManageBusiness manageBusiness = new AdminManageBusiness();
        jDesktopPane1.add(manageBusiness);
        manageBusiness.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        AdminManagePickup managePickup = new AdminManagePickup();
        jDesktopPane1.add(managePickup);
        managePickup.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ViewAllCustomers allCustomers = new ViewAllCustomers();
        jDesktopPane1.add(allCustomers);
        allCustomers.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        dispose();
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void exportCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportCustomerActionPerformed
        String strFileName = "D:\\CustomerTable.csv";
        
        try {
            FileWriter fileWriter = new FileWriter(strFileName);
            prepState = objConn.prepareStatement("SELECT * FROM customer");
            resSet = prepState.executeQuery();
            fileWriter.append("customer_id");
            fileWriter.append(',');
            fileWriter.append("customer_firstname");
            fileWriter.append(',');
            fileWriter.append("customer_lastname");
            fileWriter.append(',');
            fileWriter.append("customer_phoneno");
            fileWriter.append(',');
            fileWriter.append("customer_email");
            fileWriter.append('\n');           
            while(resSet.next()){ 
                fileWriter.append(resSet.getString(1));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(2));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(3));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(4));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(5));
                fileWriter.append('\n');  
            }
            infoMessage("Exported customer data.", "SUCCESS!");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportCustomerActionPerformed

    private void exportDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportDriverActionPerformed
        String strFileName = "D:\\DriverTable.csv";
        try {
            FileWriter fileWriter = new FileWriter(strFileName);
            prepState = objConn.prepareStatement("SELECT a.driver_id, a.driver_firstname, a.driver_lastname, b.vehicle_type, b.vehicle_plateno FROM driver a, vehicle b WHERE a.driver_id = b.driver_id");
            resSet = prepState.executeQuery();
            fileWriter.append("driver_id");
            fileWriter.append(',');
            fileWriter.append("driver_firstname");
            fileWriter.append(',');
            fileWriter.append("driver_lastname");
            fileWriter.append(',');
            fileWriter.append("vehicle_type");
            fileWriter.append(',');
            fileWriter.append("vehicle_plateno");
            fileWriter.append('\n');
            while(resSet.next()){
                fileWriter.append(resSet.getString(1));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(2));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(3));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(4));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(5));
                fileWriter.append('\n');  
            }
            infoMessage("Exported driver data.", "SUCCESS!");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportDriverActionPerformed

    private void exportTxnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportTxnActionPerformed
        String strFileName = "D:\\TransactionTable.csv";
        try {
            FileWriter fileWriter = new FileWriter(strFileName);
            prepState = objConn.prepareStatement("SELECT txn_id, txn_date, txn_pickup_date, txn_status, txn_payment_method, txn_cost, txn_payment, customer_id, pickup_id, driver_id, facility_id FROM transaction");
            resSet = prepState.executeQuery();
            fileWriter.append("txn_id");
            fileWriter.append(',');
            fileWriter.append("txn_date");
            fileWriter.append(',');
            fileWriter.append("txn_pickupdate");
            fileWriter.append(',');
            fileWriter.append("txn_status");
            fileWriter.append(',');
            fileWriter.append("txn_payment_method");
            fileWriter.append(',');
            fileWriter.append("txn_cost");
            fileWriter.append(',');
            fileWriter.append("txn_payment");
            fileWriter.append(',');
            fileWriter.append("customer_id");
            fileWriter.append(',');
            fileWriter.append("pickup_id");
            fileWriter.append(',');
            fileWriter.append("driver_id");
            fileWriter.append(',');
            fileWriter.append("facility_id"); 
            fileWriter.append('\n');            
            while(resSet.next()){
                fileWriter.append(resSet.getString(1));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(2));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(3));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(4));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(5));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(6));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(7));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(8));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(9));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(10));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(11));
                fileWriter.append('\n');  
            }
            infoMessage("Exported transaction data.", "SUCCESS!");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportTxnActionPerformed

    private void exportBusinessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBusinessActionPerformed
        String strFileName = "D:\\BusinessTable.csv";
        try {
            FileWriter fileWriter = new FileWriter(strFileName);
            prepState = objConn.prepareStatement("SELECT a.business_id, a.business_name, a.business_type, a.business_city, a.business_street, a.business_barangay, a.business_contactno, a.customer_id, b.customer_firstname, b.customer_lastname FROM business a, customer b WHERE a.customer_id = b.customer_id");
            resSet = prepState.executeQuery();
            fileWriter.append("business_id");
            fileWriter.append(',');
            fileWriter.append("business_name");
            fileWriter.append(',');
            fileWriter.append("business_type");
            fileWriter.append(',');
            fileWriter.append("business_city");
            fileWriter.append(',');
            fileWriter.append("business_street");
            fileWriter.append(',');
            fileWriter.append("business_barangay");
            fileWriter.append(',');
            fileWriter.append("business_contactno");
            fileWriter.append(',');
            fileWriter.append("customer_id");
            fileWriter.append(',');
            fileWriter.append("customer_firstname");
            fileWriter.append(',');
            fileWriter.append("customer_lastname");
            fileWriter.append('\n');          
            while(resSet.next()){
                fileWriter.append(resSet.getString(1));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(2));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(3));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(4));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(5));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(6));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(7));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(8));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(9));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(10));
                fileWriter.append('\n');  
            }
            infoMessage("Exported business data.", "SUCCESS!");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportBusinessActionPerformed

    private void exportFacilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFacilityActionPerformed
        String strFileName = "D:\\FacilityTable.csv";
        try {
            FileWriter fileWriter = new FileWriter(strFileName);
            prepState = objConn.prepareStatement("SELECT a.facility_id, a.facility_lgu, b.classification, a.facility_address FROM facility a, facility_type b WHERE a.type_id = b.type_id");
            resSet = prepState.executeQuery();           
            fileWriter.append("facility_id");
            fileWriter.append(',');
            fileWriter.append("facility_lgu");
            fileWriter.append(',');
            fileWriter.append("facility_type");
            fileWriter.append(',');
            fileWriter.append("facility_address");
            fileWriter.append('\n');     
            while(resSet.next()){
                fileWriter.append(resSet.getString(1));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(2));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(3));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(4));
                fileWriter.append('\n');  
            }
            infoMessage("Exported facility data.", "SUCCESS!");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportFacilityActionPerformed

    private void exportTxnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportTxnDetailsActionPerformed
        String strFileName = "D:\\TransactionDetailsTable.csv";
        try {
            FileWriter fileWriter = new FileWriter(strFileName);
            prepState = objConn.prepareStatement("SELECT a.txn_id, a.item_id, b.waste_type, a.waste_amount, a.container_type, c.customer_id, d.customer_firstname, d.customer_lastname FROM transaction_detail a, solidwaste b, transaction c, customer d WHERE a.waste_id = b.waste_id AND a.txn_id = c.txn_id AND c.customer_id = d.customer_id ORDER BY a.txn_id");
            resSet = prepState.executeQuery();
            fileWriter.append("txn_id");
            fileWriter.append(',');
            fileWriter.append("item_id");
            fileWriter.append(',');
            fileWriter.append("waste_type");
            fileWriter.append(',');
            fileWriter.append("waste_amount");
            fileWriter.append(',');
            fileWriter.append("container_type");
            fileWriter.append(',');
            fileWriter.append("customer_id");
            fileWriter.append(',');
            fileWriter.append("customer_firstname");
            fileWriter.append(',');
            fileWriter.append("customer_lastname");
            fileWriter.append('\n');            
            while(resSet.next()){
                fileWriter.append(resSet.getString(1));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(2));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(3));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(4));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(5));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(6));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(7));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(8));
                fileWriter.append('\n');  
            }
            infoMessage("Exported transaction details data.", "SUCCESS!");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportTxnDetailsActionPerformed

    private void exportPickupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPickupActionPerformed
        String strFileName = "D:\\PickupLocationTable.csv";
        try {
            FileWriter fileWriter = new FileWriter(strFileName);
            prepState = objConn.prepareStatement("SELECT a.pickup_id, a.location_name, b.customer_id, b.customer_lastname, b.customer_firstname, a.pickup_address FROM pickup_location a, customer b WHERE a.customer_id = b.customer_id");
            resSet = prepState.executeQuery();
            fileWriter.append("pickup_id");
            fileWriter.append(',');
            fileWriter.append("location_name");
            fileWriter.append(',');
            fileWriter.append("customer_id");
            fileWriter.append(',');
            fileWriter.append("customer_lastname");
            fileWriter.append(',');
            fileWriter.append("customer_firstname");
            fileWriter.append(',');
            fileWriter.append("pickup_address");
            fileWriter.append('\n');             
            while(resSet.next()){
                fileWriter.append(resSet.getString(1));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(2));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(3));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(4));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(5));
                fileWriter.append(',');
                fileWriter.append(resSet.getString(6));
                fileWriter.append('\n');  
            }
            infoMessage("Exported pickup location data.", "SUCCESS!");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportPickupActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        AddVehicle addVehicle = new AddVehicle();
        jDesktopPane1.add(addVehicle);
        addVehicle.show();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminMenuLabel;
    private javax.swing.JLabel adminMenuLabel1;
    private javax.swing.JMenuItem exportBusiness;
    private javax.swing.JMenuItem exportCustomer;
    private javax.swing.JMenuItem exportDriver;
    private javax.swing.JMenuItem exportFacility;
    private javax.swing.JMenuItem exportPickup;
    private javax.swing.JMenuItem exportTxn;
    private javax.swing.JMenuItem exportTxnDetails;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
