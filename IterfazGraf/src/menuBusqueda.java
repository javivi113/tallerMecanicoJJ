import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class menuBusqueda extends JFrame implements ActionListener{
	public static Cliente p1;
	public static Vehiculo v1;
	private JPanel contentPane;
	private JTextField tfBusqueda;
	public JComboBox ComBoxFiltro;
	public JButton  btnBusqueda;
	private JMenuBar barraMenu;
	private JMenu menu1, menu2, menu3, menu4, menu5, menu6;
	private JMenuItem mi1, mi2, mi3, mi4, mi5, mi6, mi7, mi8, mi9, mi10, mi11, mi12, mi13, mi14;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuBusqueda frame = new menuBusqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public menuBusqueda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 70));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		barraMenu.setBackground(new Color(255,255,0));
		barraMenu.setOpaque(true);

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


		tfBusqueda = new JTextField();
		tfBusqueda.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfBusqueda.setBounds(175, 200, 425, 45);
		contentPane.add(tfBusqueda);
		tfBusqueda.setColumns(10);

		ComBoxFiltro = new JComboBox();
		ComBoxFiltro.addItem("FILTRO");
		ComBoxFiltro.addItem("DNI");
		ComBoxFiltro.addItem("MATRICULA");
		ComBoxFiltro.setSelectedItem("FILTRO");
		ComBoxFiltro.setBounds(600, 200, 80, 45);
		ComBoxFiltro.addActionListener(this);
		contentPane.add(ComBoxFiltro);

		btnBusqueda = new JButton("Buscar");
		btnBusqueda.setBackground(new Color(255, 255, 0));
		btnBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBusqueda.setBounds(245, 265, 280, 45);
		btnBusqueda.setOpaque(true);
		btnBusqueda.addActionListener(this);
		contentPane.add(btnBusqueda);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\Plaiaundi\\Programacion\\IterfazGraf\\imagenes\\logoTallerCoche.png"));
		lblNewLabel.setBounds(250, -30, 350, 350);
		contentPane.add(lblNewLabel);
	}
	public static boolean existente(String nif, String query) {
		boolean exists=false;
		try {
			// Conexion 
			Conexion conn = new Conexion();
			Connection conex = conn.conexOra();
			//Se crea un statement èn el que se ejecutara nuestra query
			Statement selectqCon=conex.createStatement();
			//Se ejecutara el select introducido mendiante parametros
			ResultSet resultadoBusqueda=selectqCon.executeQuery(query);		
			//Si hay algun resultado, devolvera true asiq entrara en el if
			if (resultadoBusqueda.next()) {
				//Una vez dentro el boolean cambiara a true y se llamara al
				//constructor, y se definiran los datos del usuario en este
				//o vehiculo
				exists= true;				
				if (query.contains("CLIENTE"))p1=new Cliente(resultadoBusqueda.getString(1), resultadoBusqueda.getString(2), resultadoBusqueda.getString(3), resultadoBusqueda.getString(4), resultadoBusqueda.getInt(6),	resultadoBusqueda.getString(5), resultadoBusqueda.getString(7), resultadoBusqueda.getString(9), resultadoBusqueda.getString(10), resultadoBusqueda.getString(8));	
				if (query.contains("VEHICULO"))v1=new Vehiculo(resultadoBusqueda.getString(1), resultadoBusqueda.getString(2), resultadoBusqueda.getString(3), resultadoBusqueda.getInt(4), resultadoBusqueda.getString(5));
				if (query.contains("PROVEEDOR")) {
					
				}
				if(query.contains("EMPLEADO")) {
					
				}
			}
		} catch (SQLException ex) {
			ex.getStackTrace();
			//System.out.println("Error a la hora de guardar en la base de datos");
		}
		//Se devuelve el resultado, si ha entrado en el if sera true si no false
		return exists;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//Al pulsar el boton de buscar entrara
		if (e.getSource()==btnBusqueda) {
			//Guardamos en una variable lo introducido en el campo
			String busqueda=tfBusqueda.getText();
			//Guardamos la eleccion del fltro
			String filtro = (String) ComBoxFiltro.getSelectedItem();
			//Si el filtro de busqueda esta vacio, mostrara un mensaje diciendo que 
			//introduzca algo en el campo
			if (busqueda==null||busqueda.equals("")) {
				JOptionPane.showMessageDialog(null, "Introduce una matricula o un dni en el campo.");
				//si no hara la comprobacion del filtro
			}else {
				//Si la eleccion es de DNI
				if (filtro.equals("DNI")) {
					//	String empleado="SELECT * FROM EMPLEADO WHERE NIF='"+busqueda+"'";
					String cliente="SELECT * FROM CLIENTE WHERE NIF='"+busqueda+"'";
					//	String proveedor="SELECT * FROM PROVEEDOR WHERE NIF='"+busqueda+"'";
					//Se buscara si existe 
					if (existente(busqueda, cliente)) {
						//Si existe
						//se oculta la ventana y se cierra
						setVisible(false);
						dispose();
						//Se hace la llamada a la ventana para mostrar los clientes
						visualizarCliente nVenCli=new visualizarCliente();
						//Se definiran en los campos los datos del cliente existente
						nVenCli.tfDni.setText(p1.getNif());
						nVenCli.tfApe1.setText(p1.getApellido1());
						nVenCli.tfApe2.setText(p1.getApellido2());
						nVenCli.tfTelefono.setText(String.valueOf(p1.getTelefono()));
						nVenCli.tfDireccion.setText(p1.getDireccion());
						nVenCli.tfNombre.setText(p1.getNombre());
						nVenCli.tfNumCuenta.setText(p1.getNumCuenta());
						nVenCli.tfCorreo.setText(p1.getCorreo());
						//Se muestra la ventana y la colocamos en el centro
						nVenCli.setVisible(true);
						nVenCli.setLocationRelativeTo(null);
					}else {
						//Si el cliente no existe
						//Se preguntara si se deasea añadir el cliente o no
						String create=JOptionPane.showInputDialog("El cliente no esta registrado.\nDesea crearlo?");
						//Si es que si o s
						if (create.equalsIgnoreCase("si")||create.equalsIgnoreCase("s")) {
							//esta ventana se ocultara y se cerrara
							setVisible(false);
							dispose();
							//Se hace la llamada a la ventana para mostrar los clientes
							nuevoCliente nVenCli=new nuevoCliente();
							//se pondra el DNI buscado en el campo de DNi y los demas espacios
							//apareceran en blanco para poder rellenarlo
							nVenCli.tfDni.setText(tfBusqueda.getText());
							//Se muestra la ventana y la colocamos en el centro
							nVenCli.setVisible(true);
							nVenCli.setLocationRelativeTo(null);
						}
					}
				}else if (filtro.equals("MATRICULA")) {
					String vehiculo= "SELECT * FROM VEHICULO WHERE MATRICULA='"+busqueda+"'";
					if (existente(busqueda, vehiculo)) {
						//Si existe
						//se oculta la ventana y se cierra
						setVisible(false);
						dispose();
						//Se hace la llamada a la ventana para mostrar los vehiculos
						visualizarVehiculo nVenVehi=new visualizarVehiculo();
						//Se definiran en los campos los datos del vehiculo existente
						nVenVehi.tfDni.setText(v1.getDniCli());
						nVenVehi.tfMatricula.setText(v1.getMatricula());
						//No se podra modificar este campo
						nVenVehi.tfMatricula.setEditable(false);						
						nVenVehi.tfMarca.setText(v1.getMarca());
						nVenVehi.tfAño.setText(String.valueOf(v1.getAño()));
						nVenVehi.tfModelo.setText(v1.getModelo());
						//Se muestra la ventana y la colocamos en el centro
						nVenVehi.setVisible(true);
						nVenVehi.setLocationRelativeTo(null);
					}else {
						//Si el vehiculo no existe
						//Se preguntara si se deasea añadir el vehiculo o no
						String create=JOptionPane.showInputDialog("El vehiculo no esta registrado.\nDesea crearlo?");
						//Si es que si o s
						if (create.equalsIgnoreCase("si")||create.equalsIgnoreCase("s")) {
							//esta ventana se ocultara y se cerrara
							setVisible(false);
							dispose();
							//Se hace la llamada a la ventana para mostrar los vehiculos
							nuevoCliente nVenCli=new nuevoCliente();
							//se pondra el matricula buscado en el campo de matricula y los demas 
							//espacios apareceran en blanco para poder rellenarlo
							nVenCli.tfDni.setText(tfBusqueda.getText());
							nVenCli.tfDni.setEditable(false);
							//Se muestra la ventana y la colocamos en el centro
							nVenCli.setVisible(true);
							nVenCli.setLocationRelativeTo(null);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Selecciona un filtro: DNI o Matricula.");
				}
			}
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
