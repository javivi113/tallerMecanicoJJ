
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener{
	public JFrame frmAcceso;
	public JTextField textFUsuario;
	public JPasswordField textPContraseña;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblImagenFondo;
	public JButton btnAcceso; 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAcceso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login() {
		//Diseño grafico de la aplicacion
		frmAcceso = new JFrame();
		frmAcceso.setTitle("Acceso");
		frmAcceso.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Plaiaundi\\Programacion\\IterfazGraf\\imagenes\\fondoTop.png"));
		frmAcceso.getContentPane().setBackground(new Color(0, 0, 70));
		frmAcceso.setBounds(100, 100, 480, 415);
		frmAcceso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAcceso.getContentPane().setLayout(null);

		textFUsuario = new JTextField();
		textFUsuario.setBounds(210, 110, 110, 20);
		frmAcceso.getContentPane().add(textFUsuario);
		textFUsuario.setColumns(10);

		textPContraseña = new JPasswordField();
		textPContraseña.setBounds(210, 140, 110, 20);
		frmAcceso.getContentPane().add(textPContraseña);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBounds(140, 110, 60, 15);
		frmAcceso.getContentPane().add(lblUsuario);

		lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(140, 145, 70, 15);
		frmAcceso.getContentPane().add(lblContrasea);

		btnAcceso = new JButton("Acceder");
		btnAcceso.setBounds(220, 175, 85, 20);
		frmAcceso.getContentPane().add(btnAcceso);
		btnAcceso.addActionListener(this);

		lblImagenFondo = new JLabel("");
		lblImagenFondo.setIcon(new ImageIcon("E:\\Plaiaundi\\Programacion\\IterfazGraf\\imagenes\\logoTallerCoche.png"));
		lblImagenFondo.setBounds(60, 130, 330, 235);
		frmAcceso.getContentPane().add(lblImagenFondo);		
	}

	public void actionPerformed(ActionEvent evBtn) {
		//Cuando pulsas el boton de acceso entra en este if
		if (evBtn.getSource()==btnAcceso) {		
			try {
				//Creamos una conexion
				Conexion conn = new Conexion();
				Connection conex = conn.conexOra();

				//Se crea un statement èn el que se ejecutara nuestra query
				Statement accesoLogin=conex.createStatement();
				//Guardamos en una variable los datos introducidos por el usuario
				//en los campos de texto
				String usu=textFUsuario.getText();
				String contr=String.valueOf(textPContraseña.getPassword());
				//Creo el resultSet para guardar aqui elresultado de la query
				ResultSet queryContraseñaUsu=null; 
				queryContraseñaUsu=accesoLogin.executeQuery("SELECT * FROM EMPLEADO WHERE USUARIO='"+usu+"'");
				//Al hacer el next() obtenemos el valor que haya devuelto
				//la query
				if (queryContraseñaUsu.next()) {
					//Guardamos el valor del campo de la contraseña qu es el 14
					String contraseñaBase=queryContraseñaUsu.getString(14);
					//Comparamos si es la misma contraseña, si es asi
					if (contraseñaBase.equals(contr)) {
						//Se oculta el login
						frmAcceso.setVisible(false);
						frmAcceso.dispose();
						//lanzamos la ventana del menu
						menuBusqueda frame = new menuBusqueda();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
						//si no
					}else {
						//Saldra una alerta que pondra que el usuario o la contraseña
						//son incorrectos, y vaciara los campos
						JOptionPane.showMessageDialog(null, "El usuario o la contraseña son incorrectos");
						textFUsuario.setText("");
						textPContraseña.setText("");							
					}
					//Si no encuentra ningun usuario
				}else {
					//Saldra una alerta que pondra que el usuario o la contraseña
					//son incorrectos, y vaciara los campos
					JOptionPane.showMessageDialog(null, "El usuario o la contraseña son incorrectos");
					textFUsuario.setText("");
					textPContraseña.setText("");	
				}
			} catch (SQLException e2) {
				e2.getStackTrace();
			}
		}
	}
}
