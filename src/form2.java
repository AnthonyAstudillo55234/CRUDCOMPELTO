import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class form2 extends JFrame {
    private JPanel mainPanel;
    private JTextField eliminar;
    private JButton ELIMINARButton;
    private JButton REGRESARButton;
    private JLabel resultado;

    public form2() {
        setTitle("Borrar");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600,400));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String url = "jdbc:mysql://localhost:3306/clase";
                String url = "jdbc:mysql://sql10.freemysqlhosting.net/sql10720950";
                String username = "sql10720950";
                String password = "9IN3lSHIrx";
                String cedula = eliminar.getText();
                Connection conn = null;
                PreparedStatement ps = null;
                String query = "delete from estudiantes where cedula = ?";
                try {
                    conn = DriverManager.getConnection(url,username,password);
                    ps = conn.prepareStatement(query);
                    ps.setString(1,cedula);
                    int filas = ps.executeUpdate();
                    if (filas > 0) {
                        resultado.setText("El estudiante "+filas+" se ha eliminado correctamente");
                    }else {
                        resultado.setText("El estudiante "+cedula+" no existe");
                    }
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        });
        REGRESARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new form1();
                setVisible(false);
            }
        });
    }
}
