package wastecollectiondbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AddFacility extends javax.swing.JInternalFrame {

    public AddFacility() {
        initComponents();
        fillFacilityTypeCB();
    }
    
    public void fillFacilityTypeCB(){
        try{
            String strDriver = "com.mysql.jdbc.Driver";
            String strConn = "jdbc:mysql://localhost:3306/swcdbms";
            String strUser = "root";
            String strPass = "";
            Class.forName(strDriver);
            Connection objConn = DriverManager.getConnection(strConn,strUser,strPass);
            String strQuery = "SELECT classification FROM facility_type";
            Statement stmntQuery = objConn.createStatement();
            ResultSet result = stmntQuery.executeQuery(strQuery);
            
            while(result.next()){
                facilityTypeCB.addItem(result.getString("classification"));
            }
        }catch(Exception objError){
            System.out.println(objError);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        facilityLGUTF = new javax.swing.JTextField();
        addFacility = new javax.swing.JButton();
        facilityAddressTF = new javax.swing.JTextField();
        facilityTypeCB = new javax.swing.JComboBox<>();
        facilityTypeIDTF = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Facility");
        setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("ADD FACILITY DETAILS");

        jLabel2.setText("Facility LGU:");

        jLabel3.setText("Facility Address:");

        jLabel4.setText("Facility Type:");

        addFacility.setText("Add Facility");
        addFacility.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addFacility.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addFacility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFacilityActionPerformed(evt);
            }
        });

        facilityTypeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Classification" }));
        facilityTypeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facilityTypeCBActionPerformed(evt);
            }
        });

        facilityTypeIDTF.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(facilityAddressTF)
                    .addComponent(facilityTypeCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(facilityLGUTF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(facilityTypeIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(addFacility)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(facilityLGUTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(facilityAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(facilityTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facilityTypeIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addFacility)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        setBounds(260, 110, 406, 264);
    }// </editor-fold>//GEN-END:initComponents

    public void infoMessage(String strMessage, String strTitle){
        JOptionPane.showMessageDialog(null, strMessage, strTitle, JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void addFacilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFacilityActionPerformed
        String strFacilityLGU = facilityLGUTF.getText();
        String strFacilityAddress = facilityAddressTF.getText();
        String strFacilityTypeID = facilityTypeIDTF.getText();
        
        try {
            String strDriver = "com.mysql.jdbc.Driver";
            String strConn = "jdbc:mysql://localhost:3306/swcdbms";
            String strUser = "root";
            String strPass = "";
            Class.forName(strDriver);
            Connection objConn = DriverManager.getConnection(strConn,strUser,strPass);
            
            String strQuery = "INSERT INTO FACILITY VALUES(null,'"+strFacilityLGU+"','"+strFacilityAddress+"','"+strFacilityTypeID+"')";
            Statement statementQuery = objConn.createStatement();
            int intConfirmation = statementQuery.executeUpdate(strQuery);
            if (intConfirmation == 1){
            infoMessage("Facility Added.", "SUCCESS!");
            }
            } catch(ClassNotFoundException | SQLException objError){
            System.out.println(objError);
            }
        facilityLGUTF.setText("");
        facilityAddressTF.setText("");
    }//GEN-LAST:event_addFacilityActionPerformed

    private void facilityTypeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilityTypeCBActionPerformed
        String strFacilityClass = (String)facilityTypeCB.getSelectedItem();
        try{
            String strDriver = "com.mysql.jdbc.Driver";
            String strConn = "jdbc:mysql://localhost:3306/swcdbms";
            String strUser = "root";
            String strPass = "";
            Class.forName(strDriver);
            Connection objConn = DriverManager.getConnection(strConn,strUser,strPass);
            String strQuery = "SELECT type_id FROM facility_type WHERE classification ='"+strFacilityClass+"'";
            Statement stmntQuery = objConn.createStatement();
            ResultSet result = stmntQuery.executeQuery(strQuery);
            
            if(result.next()== true){
                facilityTypeIDTF.setText(result.getString("type_id"));
            }
            else{
                facilityTypeIDTF.setText("");
            }
        }catch(Exception objError){
            System.out.println(objError);
        }
    }//GEN-LAST:event_facilityTypeCBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFacility;
    private javax.swing.JTextField facilityAddressTF;
    private javax.swing.JTextField facilityLGUTF;
    private javax.swing.JComboBox<String> facilityTypeCB;
    private javax.swing.JTextField facilityTypeIDTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
