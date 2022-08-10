package wastecollectiondbms;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import javax.swing.UIManager;

public class WasteCollectionDBMS {
    public static void main(String[] args) {
        FlatArcDarkOrangeIJTheme.setup();
        try {
            UIManager.setLookAndFeel(new FlatArcDarkOrangeIJTheme());
        } catch(Exception objError) {
            System.err.println( "Failed to initialize LaF" );
        }
        Login mainScreen=new Login();
        mainScreen.setLocationRelativeTo(null);
        mainScreen.setVisible(true);
    }
}


