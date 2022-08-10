package wastecollectiondbms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AddVehicle extends javax.swing.JInternalFrame {

    public AddVehicle() {
        initComponents();
    }
    
    public void infoMessage(String strMessage, String strTitle){
        JOptionPane.showMessageDialog(null, strMessage, strTitle, JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vehiclePlateNoTF = new javax.swing.JTextField();
        addInfo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        vehicleTypeCB = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);

        jLabel2.setText("Plate No.:");

        jLabel3.setText("Vehicle Type:");

        addInfo.setText("Add Info");
        addInfo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInfoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("ADD VEHICLE DETAILS");

        vehicleTypeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Garbage Compactor", "Open Dump Truck" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(vehiclePlateNoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(vehicleTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(39, 39, 39)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addInfo)
                        .addGap(112, 112, 112)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vehiclePlateNoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehicleTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(addInfo)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        setBounds(280, 110, 400, 215);
    }// </editor-fold>//GEN-END:initComponents

    private void addInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInfoActionPerformed
        String strVehiclePlateNo = vehiclePlateNoTF.getText();
        String strVehicleType = (String)vehicleTypeCB.getSelectedItem();

        try {
            String strDriver = "com.mysql.jdbc.Driver";
            String strConn = "jdbc:mysql://localhost:3306/swcdbms";
            String strUser = "root";
            String strPass = "";
            Class.forName(strDriver);
            Connection objConn = DriverManager.getConnection(strConn,strUser,strPass);

            String strQuery = "INSERT INTO VEHICLE VALUES('"+strVehiclePlateNo+"','"+strVehicleType+"', null)";
            Statement statementQuery = objConn.createStatement();
            int intConfirmation = statementQuery.executeUpdate(strQuery);
            if (intConfirmation == 1){
                infoMessage("Vehicle details added.", "SUCCESS!");
            }
            else{
                infoMessage("Vehicle plate number already exists!", "ERROR!");
            }
        } catch(Exception objError){
            infoMessage("Vehicle plate number already exists!", "ERROR!");
            System.out.println(objError);
        }
        vehiclePlateNoTF.setText("");
    }//GEN-LAST:event_addInfoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField vehiclePlateNoTF;
    private javax.swing.JComboBox<String> vehicleTypeCB;
    // End of variables declaration//GEN-END:variables
}
