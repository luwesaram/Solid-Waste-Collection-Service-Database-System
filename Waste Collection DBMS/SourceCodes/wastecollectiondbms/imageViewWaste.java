package wastecollectiondbms;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class imageViewWaste extends javax.swing.JFrame {

    String strItemID;
    Connection objConn;
    PreparedStatement prepState;
    ResultSet resSet;
    public imageViewWaste() {

    }
    
    public imageViewWaste(String itemID){
        this.strItemID = itemID;
        initComponents();
        getConnection();
        fillImage();
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
    
    
    public void fillImage(){
         try{
            String strQuery = "SELECT waste_photo FROM transaction_detail WHERE item_id = "+strItemID+"";
            prepState = objConn.prepareStatement(strQuery);
            resSet = prepState.executeQuery();
            resSet.next();
            Blob blobImage = resSet.getBlob("waste_photo");
            InputStream inputStreamImg = blobImage.getBinaryStream();
            BufferedImage buffImage = ImageIO.read(inputStreamImg);
            ImageIcon imgIcon = new ImageIcon(buffImage);
            Image objImage = imgIcon.getImage().getScaledInstance(600,700, Image.SCALE_SMOOTH);
            wasteImage.setIcon(new ImageIcon(objImage));
        } catch (Exception objError){
            System.out.println(objError);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wasteImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 700));
        setResizable(false);

        wasteImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wasteImage, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wasteImage, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(imageViewWaste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(imageViewWaste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(imageViewWaste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(imageViewWaste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new imageViewWaste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel wasteImage;
    // End of variables declaration//GEN-END:variables
}
