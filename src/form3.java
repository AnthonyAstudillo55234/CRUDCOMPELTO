import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class form3 extends JFrame{
    private JPanel mainPanel;
    private JTextField actualizar;
    private JButton ACTUALIZARButton;
    private JButton REGRESARButton;
    private JTextField nota1;
    private JLabel resultado;
    private JLabel resultado2;

    public form3() {
        setTitle("Actualizar");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600,400));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        ACTUALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url="jdbc:mysql://localhost:3306/clase";
                String user="root";
                String password="123456";
                float nota = Float.parseFloat(nota1.getText());
                String cedula = actualizar.getText();
                Connection con= null;
                PreparedStatement ps = null;
                String sql = "update estudiantes set b1 = ? where cedula = ?";
                try{
                    con = DriverManager.getConnection(url,user,password);
                    ps = con.prepareStatement(sql);
                    ps.setFloat(1, nota);
                    ps.setString(2,cedula);
                    System.out.println(sql);
                    int a = ps.executeUpdate();
                    resultado.setText("Se modificaron: "+a+" Lineas");
                    resultado2.setText("Se han ingresado los datos del estudiante");
                }catch (SQLException e1){
                    System.out.println(e1.getMessage());
                } finally {
                    try {
                        if (ps != null) {
                            ps.close();
                        }if (con != null){
                            con.close();
                        }
                    }catch (SQLException e1){
                        System.out.println(e1.getMessage());
                    }
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
