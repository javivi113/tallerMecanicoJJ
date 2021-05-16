import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class visualizarCliente extends JFrame implements ActionListener{
	private static JPanel contentPane;
	public JTextField tfNombre;
	public JTextField tfApe1;
	public JTextField tfApe2;
	public JTextField tfTelefono;
	public JTextField tfNumCuenta;
	public JTextField tfCorreo;
	public JTextField tfUsuarioWeb;
	public JTextField tfContraseñaWeb;
	private JButton btnGuardar, btnEliminar, btnVerVehiculo, btnAñadirVehiculo, btnEliminarVehiculo;
	public JTextField tfDireccion;
	public JTextField tfDni;
	public JScrollPane jScrollPane;
	public JTable jTabla;
	public DefaultTableModel modelo;
	public PreparedStatement pS;
	public ResultSet rS;
	public JMenuBar barraMenu;
	private JMenu menu1, menu2, menu3, menu4, menu5, menu6;
	private JMenuItem mi1,mInicio, mi2, mi3, mi4, mi5, mi6, mi7, mi8, mi9, mi10, mi11, mi12, mi13, mi14;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visualizarCliente frame = new visualizarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public visualizarCliente() {

		// Dar caracteristicas a la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 70));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Creación del menu
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		barraMenu.setBackground(new Color(255,255,0));
		barraMenu.setOpaque(true);

		mInicio = new JMenuItem("Inicio");
		barraMenu.add(mInicio);
		mInicio.setOpaque(true);
		mInicio.setBackground(new Color(255,255,0));
		mInicio.addActionListener(this);
		
		menu1 = new JMenu("Clientes y facturas");
		barraMenu.add(menu1);
		menu2 = new JMenu("Vehiculos y reparaciones");
		barraMenu.add(menu2);
		menu3 = new JMenu("Piezas y pedidos");
		barraMenu.add(menu3);
		menu4 = new JMenu("Proveedores");
		barraMenu.add(menu4);
		menu5 = new JMenu("Empleados");
		barraMenu.add(menu5);
		menu6 = new JMenu("Otras operaciones");
		barraMenu.add(menu6);

		mi1= new JMenuItem("Alta cliente");
		mi1.addActionListener(this);
		menu1.add(mi1);

		mi2= new JMenuItem("Ver listado");
		mi2.addActionListener(this);
		menu1.add(mi2);

		mi3= new JMenuItem("Facturas");
		mi3.addActionListener(this);
		menu1.add(mi3);

		mi4= new JMenuItem("Alta vehiculo");
		mi4.addActionListener(this);
		menu2.add(mi4);

		mi5= new JMenuItem("Ver listado de vehiculos");
		mi5.addActionListener(this);
		menu2.add(mi5);

		mi6= new JMenuItem("Ver listado de reparaciones");
		mi6.addActionListener(this);
		menu2.add(mi6);

		mi7= new JMenuItem("Realizar pedido");
		mi7.addActionListener(this);
		menu3.add(mi7);

		mi8= new JMenuItem("Ver listado de pedidos");
		mi8.addActionListener(this);
		menu3.add(mi8);

		mi9= new JMenuItem("Ver stock de piezas");
		mi9.addActionListener(this);
		menu3.add(mi9);

		mi10= new JMenuItem("Nuevo proveedor");
		mi10.addActionListener(this);
		menu4.add(mi10);

		mi11= new JMenuItem("Ver proveedores");
		mi11.addActionListener(this);
		menu4.add(mi11);

		mi12= new JMenuItem("Nuevo empleado");
		mi12.addActionListener(this);
		menu5.add(mi12);

		mi13= new JMenuItem("Ver empleaods");
		mi13.addActionListener(this);
		menu5.add(mi13);

		mi14= new JMenuItem("Salir");
		mi14.addActionListener(this);
		menu6.add(mi14);


		// Creación de etiquetas JLabel
		JLabel labelTituloNuevoCliente = new JLabel("Cliente");
		labelTituloNuevoCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelTituloNuevoCliente.setForeground(new Color(255, 255, 255));
		labelTituloNuevoCliente.setBounds(10, 40, 120, 14);
		contentPane.add(labelTituloNuevoCliente);

		JLabel labelSeparador = new JLabel("");
		labelSeparador.setOpaque(true);
		labelSeparador.setBackground(new Color(255, 255, 255));
		labelSeparador.setBounds(10, 65, 765, 2);
		contentPane.add(labelSeparador);

		JLabel Nombre = new JLabel("Nombre: (*)");
		Nombre.setForeground(new Color(255, 255, 255));
		Nombre.setBounds(10, 80, 65, 15);
		contentPane.add(Nombre);

		JLabel Apellido1 = new JLabel("Apellido 1:");
		Apellido1.setForeground(Color.WHITE);
		Apellido1.setBounds(10, 120, 63, 15);
		contentPane.add(Apellido1);

		JLabel Apellido2 = new JLabel("Apellido 2:");
		Apellido2.setForeground(Color.WHITE);
		Apellido2.setBounds(10, 160, 65, 15);
		contentPane.add(Apellido2);

		JLabel telefono = new JLabel("Telefono:(*)");
		telefono.setForeground(Color.WHITE);
		telefono.setBounds(10, 200, 65, 15);
		contentPane.add(telefono);

		JLabel labelSeparador_2 = new JLabel("");
		labelSeparador_2.setOpaque(true);
		labelSeparador_2.setBackground(Color.WHITE);
		labelSeparador_2.setBounds(10, 235, 765, 2);
		contentPane.add(labelSeparador_2);

		// Creacion de los TextField para introducir datos
		tfNombre = new JTextField();
		tfNombre.setBounds(75, 80, 85, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);

		tfApe1 = new JTextField();
		tfApe1.setColumns(10);
		tfApe1.setBounds(75, 115, 85, 20);
		contentPane.add(tfApe1);

		tfApe2 = new JTextField();
		tfApe2.setColumns(10);
		tfApe2.setBounds(75, 155, 85, 20);
		contentPane.add(tfApe2);

		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(75, 195, 85, 20);
		contentPane.add(tfTelefono);

		JLabel correo = new JLabel("Correo: (*)");
		correo.setForeground(Color.WHITE);
		correo.setBounds(180, 80, 65, 15);
		contentPane.add(correo);

		JLabel numCuenta = new JLabel("Número de cuenta: (*)");
		numCuenta.setForeground(Color.WHITE);
		numCuenta.setBounds(180, 120, 120, 15);
		contentPane.add(numCuenta);

		tfNumCuenta = new JTextField();
		tfNumCuenta.setBounds(294, 115, 130, 20);
		contentPane.add(tfNumCuenta);
		tfNumCuenta.setColumns(10);

		tfCorreo = new JTextField();
		tfCorreo.setColumns(10);
		tfCorreo.setBounds(255, 75, 170, 20);
		contentPane.add(tfCorreo);

		JLabel direccion = new JLabel("Direccion: (*)");
		direccion.setForeground(Color.WHITE);
		direccion.setBounds(180, 160, 80, 15);
		contentPane.add(direccion);

		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(255, 160, 170, 20);
		contentPane.add(tfDireccion);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(445, 80, 175, 140);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel usuWeb = new JLabel("Usuario Web");
		usuWeb.setBounds(5, 11, 75, 15);
		panel.add(usuWeb);

		tfUsuarioWeb = new JTextField();
		tfUsuarioWeb.setBounds(5, 37, 145, 20);
		panel.add(tfUsuarioWeb);
		tfUsuarioWeb.setColumns(10);

		JLabel contraWeb = new JLabel("Contraseña web");
		contraWeb.setBounds(5, 69, 110, 15);
		panel.add(contraWeb);

		tfContraseñaWeb = new JTextField();
		tfContraseñaWeb.setColumns(10);
		tfContraseñaWeb.setBounds(5, 95, 145, 20);
		panel.add(tfContraseñaWeb);

		JLabel lblVehiculos = new JLabel("Vehiculo/s");
		lblVehiculos.setForeground(Color.WHITE);
		lblVehiculos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVehiculos.setBounds(10, 250, 120, 14);
		contentPane.add(lblVehiculos);

		JLabel labelSeparador_3 = new JLabel("");
		labelSeparador_3.setOpaque(true);
		labelSeparador_3.setBackground(Color.WHITE);
		labelSeparador_3.setBounds(10, 275, 765, 2);
		contentPane.add(labelSeparador_3);

		JLabel DNI = new JLabel("DNI: (*)");
		DNI.setForeground(Color.WHITE);
		DNI.setBounds(180, 200, 60, 15);
		contentPane.add(DNI);

		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(255, 195, 170, 20);
		contentPane.add(tfDni);

		// Creacion de los botones para las acciones
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(255, 255, 0));
		btnGuardar.setOpaque(true);
		btnGuardar.setBounds(640, 80, 115, 65);
		contentPane.add(btnGuardar);
		btnGuardar.addActionListener(this);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setOpaque(true);
		btnEliminar.setBackground(Color.YELLOW);
		btnEliminar.setBounds(640, 155, 115, 65);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(this);

		// Creacion del Scroll y la tabla
		jScrollPane = new JScrollPane();
		jScrollPane.setBounds(180, 288, 440, 162);
		contentPane.add(jScrollPane);
		jTabla = new JTable();
		jTabla.setBackground(Color.YELLOW);
		jScrollPane.setViewportView(jTabla);
		jScrollPane.setVisible(false);

		//Botones de vehiculos
		btnVerVehiculo = new JButton("Ver vehiculos");
		btnVerVehiculo.setOpaque(true);
		btnVerVehiculo.setBackground(Color.YELLOW);
		btnVerVehiculo.setBounds(302, 248, 115, 23);
		contentPane.add(btnVerVehiculo);
		btnVerVehiculo.addActionListener(this);

		btnAñadirVehiculo = new JButton("Añadir vehiculo");
		btnAñadirVehiculo.setOpaque(true);
		btnAñadirVehiculo.setBackground(Color.YELLOW);
		btnAñadirVehiculo.setBounds(458, 248, 130, 23);	
		contentPane.add(btnAñadirVehiculo);
		btnAñadirVehiculo.addActionListener(this);

		btnEliminarVehiculo = new JButton("Eliminar vehiculo");
		btnEliminarVehiculo.setOpaque(true);
		btnEliminarVehiculo.setBackground(Color.YELLOW);
		btnEliminarVehiculo.setBounds(625, 248, 130, 23);
		contentPane.add(btnEliminarVehiculo);
		btnEliminarVehiculo.addActionListener(this);


	}

	// Creación de la tabla con el listado de vehiculos del cliente
	private void creacionTablaVehiculos(Connection conex) {
		//se visibiliza la tabla
		jScrollPane.setVisible(true);
		DefaultTableModel modelo = new DefaultTableModel();
        jTabla.setModel(modelo);
        
		try {
			// Para obtener el dni del query			
			String nif = tfDni.getText();
			
	        String sql = "SELECT matricula, marca, modelo, año FROM vehiculo INNER JOIN cliente ON vehiculo.nif_cliente=cliente.nif where cliente.nif='"+nif+"'";
		       
            pS = conex.prepareStatement(sql);
            rS = pS.executeQuery();
            
            ResultSetMetaData resultMetaDatos = rS.getMetaData();
            
            // Obtención del número de columnas de la tabla de la base de datos
            int numColumnas = resultMetaDatos.getColumnCount();
           
            // Definición de las columnas
            modelo.addColumn("MATRICULA");
            modelo.addColumn("MARCA");
            modelo.addColumn("MODELO");
            modelo.addColumn("AÑO");
            
            // Inserción de datos columna
            for (int i = 0; i < jTabla.getColumnCount(); i++) {
            	jTabla.getColumnModel().getColumn(i);
            }
            
            // Inserción de los datos fila (vehiculos)   
            while (rS.next()) {
        	   		// Para introducir todos los datos del vehiculos
	                Object[] filas = new Object[numColumnas];
	        		
	                filas[0] = rS.getString("matricula");
	                filas[1] = rS.getString("marca");
	                filas[2] = rS.getString("modelo");
	                filas[3] = rS.getString("año");
	                
	                // Se insertan todos los datos de vehiculo
	                modelo.addRow(filas);
	        } 
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
	
	}
	public static boolean esNumero(String num) {
		boolean numerico=true;
		try {
			//Si el cambio da error saltara un error
			int numero=Integer.parseInt(num);
			//Al saltar la excepcion le dara false al boolean y devolvera que el valor
			//no es numerico

		} catch (NumberFormatException e) {
			numerico= false;
		}
		return numerico;

	}
	public static boolean checkDNI(String x) {
		int contador=0;
		String letrasValidas="AaBbCcDdEeFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxYyZz";
		if (x.length()==9) {
			String ultimaL=String.valueOf(x.charAt(x.length()-1));
			if (letrasValidas.contains(ultimaL)) {
				for (int i = 0; i < x.length(); i++)if (esNumero(String.valueOf(x.charAt(i))))contador++;
				if (contador==8)return true;
			}else {
				return false;
			}
		}
		return false;

	}
	public static boolean checkTlf(int tlf) {
		if (Integer.toString(tlf).length()==9) {
			return true;
		}
		return false;
	}
	public static boolean checkMail(String str) {
		String preArroba = null;
		String postArroba = null;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)=='@') {
				preArroba=str.substring(0,i);
				postArroba=str.substring(i+1,str.length());
			}			
		}
		String postArrobaPre = null, postArrobaPos = null;
		if (postArroba!=null) {
			for (int i = 0; i < postArroba.length(); i++) {
				if (postArroba.charAt(i)=='.') {
					postArrobaPre=str.substring(0,i);
					if (i!=postArroba.length()-1)postArrobaPos=str.substring(i+1,postArroba.length());
				}
				if (postArroba.charAt(i)=='@')return false;
			}
			if (postArrobaPos==null||postArrobaPre==null||preArroba==null) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		// Conexion 
		Conexion conn = new Conexion();
		Connection conex = conn.conexOra();

		if (e.getSource()==btnGuardar) {			
			Persona cliente;
			//Usuario
			String nombre="", apellido1="", apellido2="", correo="", direccion="",nif="", numCuenta;
			int telefono;
			String usuario="-", contraseña="-";
			try {
				boolean datosMalIntro=false;
				nif=tfDni.getText();
				telefono=Integer.parseInt(tfTelefono.getText());
				nombre=tfNombre.getText();
				apellido1=tfApe1.getText();
				apellido2=tfApe2.getText();
				correo=tfCorreo.getText();
				numCuenta=tfNumCuenta.getText();
				direccion=tfDireccion.getText();

				//Se haran comprobaciones  de los datos introducido para
				//saber si son validos
				//-Comprobacion DNI					
				if (checkDNI(nif)==false) {
					tfDni.setText("");	
					if (datosMalIntro==false)datosMalIntro=true;
				}

				//-Telefono
				if (checkTlf(telefono)==false) {
					tfTelefono.setText("");
					if (datosMalIntro==false)datosMalIntro=true;
				}

				//-Correo
				if (checkMail(correo)==false) {
					tfCorreo.setText("");
					if (datosMalIntro==false)datosMalIntro=true;
				}					
				if (datosMalIntro) {
					JOptionPane.showMessageDialog(null,"Algunos de los datos estan mal introducidos.\nPorfavor comprueba que los datos introducidos sean correctos.");
				}else {
					if (apellido1.equals("")||apellido2.equals("")) {
						if (tfUsuarioWeb.getText()!=null || tfContraseñaWeb.getText()!=null) {
							usuario=tfUsuarioWeb.getText();
							contraseña=tfContraseñaWeb.getText();
							cliente=new Cliente(nif, nombre, telefono, direccion, correo, usuario, contraseña, numCuenta);
						}
						else { 
							cliente=new Cliente(nif, nombre, telefono, direccion, correo, numCuenta);
						}

					}else {

						if (tfUsuarioWeb.getText()!=null || tfContraseñaWeb.getText()!=null) {
							usuario=tfUsuarioWeb.getText();
							contraseña=tfContraseñaWeb.getText();
							cliente=new Cliente(nif, nombre, apellido1, apellido2, telefono, direccion, correo, usuario, contraseña, numCuenta);
						}
						else { 
							cliente=new Cliente(nif, nombre, apellido1, apellido2, telefono, direccion, correo, numCuenta);
						}
					}
					cliente.actualizarBase();	
				}

			} catch (NumberFormatException ex) {
				ex.getStackTrace();
			}

		}

		// 
		if (e.getSource()==btnEliminar) {
			try {

				// Obtengo el dni del sujeto a eliminar
				String codigo = tfDni.getText();

				pS = conex.prepareStatement("DELETE FROM cliente WHERE nif=?");
				pS.setString(1, codigo);
				pS.execute();

				JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");

				// Para volver al menu principal
				setVisible(false);
				dispose();
				menuBusqueda volverMenu=new menuBusqueda();
				volverMenu.setVisible(true);
				volverMenu.setLocationRelativeTo(null); 	            
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al eliminar el cliente");
				System.out.println(ex.toString());
			}			
		}

		if (e.getSource()==btnVerVehiculo) {
			// Para ver los vehiculos del cliente creando la taula y/o para actualizarla
			creacionTablaVehiculos(conex);
		}

		if (e.getSource()==btnAñadirVehiculo) {
			//Cierra la ventana
			setVisible(false);
			dispose();
			//abre la nueva para poder añadir el vehiculo
			nuevoVehiculo nV=new nuevoVehiculo();
			nV.tfDni.setText(tfDni.getText());
			nV.tfDni.setEditable(false);
			nV.setVisible(true);
			nV.setLocationRelativeTo(null);

		}


		if (e.getSource()==btnEliminarVehiculo) {
			
			int fila = jTabla.getSelectedRow();			
			if (fila!=-1) {
				 try {
					 // Guardo la matricula del vehiculo a eliminar
		             String codigo = jTabla.getValueAt(fila, 0).toString();
		
		             pS = conex.prepareStatement("DELETE FROM vehiculo WHERE matricula=?");
		             pS.setString(1, codigo);
		             pS.execute();
		
		            // Vuelvo a cargar la taula
		            jScrollPane.setVisible(false);
		            creacionTablaVehiculos(conex);
		            JOptionPane.showMessageDialog(null, "Vehiculo eliminado");
		
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Error al eliminar vehiculo");
		            System.out.println(ex.toString());
		        }
			}
			else {
				JOptionPane.showMessageDialog(null, "Selecciona la fila que desea borrar");
			}
		}
		if (e.getSource()==mInicio) {
			setVisible(false);
			dispose();
			menuBusqueda mB=new menuBusqueda();
			mB.setVisible(true);
			mB.setLocationRelativeTo(null);
		}
		if (e.getSource() == mi1) {
			setVisible(false);
			dispose();
			nuevoCliente nC=new nuevoCliente();
			nC.setVisible(true);
			nC.setLocationRelativeTo(null);
		}
		if (e.getSource() == mi2) {
			setVisible(false);
			dispose();
			ListaCliente lC=new ListaCliente();
			lC.setVisible(true);
			lC.setLocationRelativeTo(null);
		}
		if (e.getSource() == mi3) {
			// Facturas			

		}
		if (e.getSource() == mi4) {
			setVisible(false);
			dispose();
			nuevoVehiculo nV=new nuevoVehiculo();
			nV.setVisible(true);
			nV.setLocationRelativeTo(null);
		}
		if (e.getSource() == mi5) {
			// Listar vehículos

		}
		if (e.getSource() == mi6) {

			// Listar reparaciones

		}
		if (e.getSource() == mi7) {

			// Realizar pedido
		}

		if (e.getSource() == mi8) {
			// Listar pedidos

		}
		if (e.getSource() == mi9) {
			// Listar stock piezas	
		}

		if (e.getSource() == mi10) {
			// Nuevo proveedor
		}

		if (e.getSource() == mi11) {
			// Listar proveedores
		}

		if (e.getSource() == mi12) {
			// Nuevo empleado
		}

		if (e.getSource() == mi13) {
			// Listar empleado
		}

		if (e.getSource() == mi14) {

			// Salida del programa
			System.exit(0);
		}
	}
}
