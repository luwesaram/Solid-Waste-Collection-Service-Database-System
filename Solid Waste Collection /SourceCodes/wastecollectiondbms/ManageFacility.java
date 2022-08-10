package wastecollectiondbms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageFacility extends javax.swing.JInternalFrame {


    public ManageFacility() {
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
            
            String strQuery = "SELECT a.facility_id, a.facility_LGU, a.facility_address, b.classification FROM facility a, facility_type b WHERE a.type_id = b.type_id";
            PreparedStatement stmntQuery = objConn.prepareStatement(strQuery);
            ResultSet resSet = stmntQuery.executeQuery();
            DefaultTableModel table = (DefaultTableModel)facilityTable.getModel();
            
            table.setRowCount(0);
            while(resSet.next()){
                table.addRow(new String[]{resSet.getString(1),resSet.getString(2), resSet.getString(3),resSet.getString(4)});
            }
        }catch(Exception objError){
            System.out.println(objError);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        facilityIDTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        facilityLGUTF = new javax.swing.JTextField();
        facilityAddressTF = new javax.swing.JTextField();
        facilityTypeTF = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        viewAllBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        facilityTable = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Manage Facility");

        jLabel2.setText("LGU:");

        jLabel3.setText("Address:");

        deleteBtn.setText("Delete");
        deleteBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        facilityIDTF.setEditable(false);
        facilityIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facilityIDTFActionPerformed(evt);
            }
        });

        jLabel4.setText("Facility Type:");

        facilityLGUTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facilityLGUTFActionPerformed(evt);
            }
        });

        facilityAddressTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facilityAddressTFActionPerformed(evt);
            }
        });

        facilityTypeTF.setEditable(false);
        facilityTypeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facilityTypeTFActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        viewAllBtn.setText("View All");
        viewAllBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Facility ID:");

        facilityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "facility_ID", "LGU", "Address", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        facilityTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facilityTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(facilityTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(facilityLGUTF, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facilityIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(facilityTypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(viewAllBtn)
                        .addGap(31, 31, 31)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(facilityAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facilityIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facilityAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facilityLGUTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facilityTypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(viewAllBtn)
                    .addComponent(deleteBtn)
                    .addComponent(updateBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
        );

        setBounds(150, 60, 738, 370);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        String strfacilityID = facilityIDTF.getText();
        try {
            String strDriver = "com.mysql.jdbc.Driver";
            String strConn = "jdbc:mysql://localhost:3306/swcdbms";
            String strUser = "root";
            String strPass = "";
            Class.forName(strDriver);
            Connection objConn = DriverManager.getConnection(strConn,strUser,strPass);

            String strQuery = "DELETE FROM facility WHERE facility_id = "+strfacilityID+"";
            Statement statementQuery = objConn.createStatement();
            int intConfirmation = statementQuery.executeUpdate(strQuery);
            viewTable();
            if (intConfirmation == 1){
                infoMessage("Facility Info deleted.", "SUCCESS!");
            }
        } catch(Exception objError){
            System.out.println(objError);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void facilityIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilityIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facilityIDTFActionPerformed

    private void facilityLGUTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilityLGUTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facilityLGUTFActionPerformed

    private void facilityAddressTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilityAddressTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facilityAddressTFActionPerformed

    private void facilityTypeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilityTypeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facilityTypeTFActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String strFacilityID = facilityIDTF.getText();
        String strFacilityLGU = facilityLGUTF.getText();
        String strFacilityAddress = facilityAddressTF.getText();

        try {
            String strDriver = "com.mysql.jdbc.Driver";
            String strConn = "jdbc:mysql://localhost:3306/swcdbms";
            String strUser = "root";
            String strPass = "";
            Class.forName(strDriver);
            Connection objConn = DriverManager.getConnection(strConn,strUser,strPass);

            String strQuery = "UPDATE facility SET facility_LGU='"+strFacilityLGU+"', facility_address='"+strFacilityAddress+"' WHERE facility_id = "+strFacilityID+"";
            Statement statementQuery = objConn.createStatement();
            int intConfirmation = statementQuery.executeUpdate(strQuery);
            viewTable();
            if (intConfirmation == 1){
                infoMessage("Facility info updated.", "SUCCESS!");

            }
        } catch(Exception objError){
            System.out.println(objError);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void viewAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllBtnActionPerformed
        viewTable();
    }//GEN-LAST:event_viewAllBtnActionPerformed

    private void facilityTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facilityTableMouseClicked
        DefaultTableModel table = (DefaultTableModel)facilityTable.getModel();
        int intSelectedRows = facilityTable.getSelectedRow();

        facilityIDTF.setText(table.getValueAt(intSelectedRows, 0).toString());
        facilityLGUTF.setText(table.getValueAt(intSelectedRows, 1).toString());
        facilityAddressTF.setText(table.getValueAt(intSelectedRows, 2).toString());
        facilityTypeTF.setText(table.getValueAt(intSelectedRows, 3).toString());
    }//GEN-LAST:event_facilityTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField facilityAddressTF;
    private javax.swing.JTextField facilityIDTF;
    private javax.swing.JTextField facilityLGUTF;
    private javax.swing.JTable facilityTable;
    private javax.swing.JTextField facilityTypeTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton viewAllBtn;
    // End of variables declaration//GEN-END:variables
}
