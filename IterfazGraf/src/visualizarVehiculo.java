

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;



public class visualizarVehiculo extends JFrame implements ActionListener{
	public static Cliente p1;
	public static Vehiculo v1;
	private static JPanel contentPane;
	public JTextField tfMatricula;
	public JTextField tfMarca;
	public JTextField tfModelo;
	public JTextField tfAño;
	private JMenuBar barraMenu;
	private JMenu menu0,menu1, menu2, menu3, menu4, menu5, menu6;
	private JMenuItem mi1,mInicio, mi2, mi3, mi4, mi5, mi6, mi7, mi8, mi9, mi10, mi11, mi12, mi13, mi14;
	private JButton btnGuardar, btnElim,btnMostrarCli,btnAñadirReparacion,btnEliminarReparacion;
	public JTextField tfDni;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visualizarVehiculo frame = new visualizarVehiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public visualizarVehiculo() {
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

		JLabel tVehiculo = new JLabel("Vehiculo");
		tVehiculo.setFont(new Font("Tahoma", Font.BOLD, 15));
		tVehiculo.setForeground(new Color(255, 255, 255));
		tVehiculo.setBounds(10, 10, 120, 14);
		contentPane.add(tVehiculo);

		JLabel labelSeparador = new JLabel("");
		labelSeparador.setOpaque(true);
		labelSeparador.setBackground(new Color(255, 255, 255));
		labelSeparador.setBounds(10, 30, 765, 2);
		contentPane.add(labelSeparador);

		JLabel matricula = new JLabel("Matricula:");
		matricula.setForeground(new Color(255, 255, 255));
		matricula.setBounds(10, 40, 65, 15);
		contentPane.add(matricula);

		JLabel Marca = new JLabel("Marca:");
		Marca.setForeground(Color.WHITE);
		Marca.setBounds(10, 90, 63, 15);
		contentPane.add(Marca);

		JLabel Modelo = new JLabel("Modelo:");
		Modelo.setForeground(Color.WHITE);
		Modelo.setBounds(10, 145, 65, 15);
		contentPane.add(Modelo);

		JLabel Año = new JLabel("A\u00F1o:");
		Año.setForeground(Color.WHITE);
		Año.setBounds(10, 200, 65, 15);
		contentPane.add(Año);

		JLabel labelSeparador_2 = new JLabel("");
		labelSeparador_2.setOpaque(true);
		labelSeparador_2.setBackground(Color.WHITE);
		labelSeparador_2.setBounds(10, 235, 765, 2);
		contentPane.add(labelSeparador_2);

		tfMatricula = new JTextField();
		tfMatricula.setBounds(75, 40, 85, 20);
		contentPane.add(tfMatricula);
		tfMatricula.setColumns(10);

		tfMarca = new JTextField();
		tfMarca.setColumns(10);
		tfMarca.setBounds(75, 90, 85, 20);
		contentPane.add(tfMarca);

		tfModelo = new JTextField();
		tfModelo.setColumns(10);
		tfModelo.setBounds(75, 145, 85, 20);
		contentPane.add(tfModelo);

		tfAño = new JTextField();
		tfAño.setColumns(10);
		tfAño.setBounds(75, 195, 85, 20);
		contentPane.add(tfAño);

		JLabel tReparacion = new JLabel("Reparaciones");
		tReparacion.setForeground(Color.WHITE);
		tReparacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		tReparacion.setBounds(10, 250, 120, 14);
		contentPane.add(tReparacion);

		JLabel labelSeparador_3 = new JLabel("");
		labelSeparador_3.setOpaque(true);
		labelSeparador_3.setBackground(Color.WHITE);
		labelSeparador_3.setBounds(10, 275, 765, 2);
		contentPane.add(labelSeparador_3);

		btnGuardar = new JButton("Guardar ");
		btnGuardar.setBackground(new Color(255, 255, 0));
		btnGuardar.setOpaque(true);
		btnGuardar.setBounds(640, 50, 115, 65);
		contentPane.add(btnGuardar);
		btnGuardar.addActionListener(this);

		JLabel DNI = new JLabel("DNI:");
		DNI.setForeground(Color.WHITE);
		DNI.setBounds(201, 135, 60, 15);
		contentPane.add(DNI);

		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(255, 130, 170, 20);
		contentPane.add(tfDni);

		btnElim = new JButton("Eliminar");
		btnElim.setOpaque(true);
		btnElim.setBackground(Color.YELLOW);
		btnElim.setBounds(640, 155, 115, 65);
		contentPane.add(btnElim);
		btnElim.addActionListener(this);

		btnAñadirReparacion = new JButton("A\u00F1adir");
		btnAñadirReparacion.setBounds(565, 245, 90, 25);
		contentPane.add(btnAñadirReparacion);
		btnAñadirReparacion.addActionListener(this);

		btnEliminarReparacion = new JButton("Eliminar");
		btnEliminarReparacion.setBounds(670, 245, 90, 25);
		contentPane.add(btnEliminarReparacion);
		btnEliminarReparacion.addActionListener(this);

		btnMostrarCli = new JButton("Ver cliente");
		btnMostrarCli.setOpaque(true);
		btnMostrarCli.setBackground(Color.YELLOW);
		btnMostrarCli.setBounds(435, 120, 115, 35);
		contentPane.add(btnMostrarCli);
		btnMostrarCli.addActionListener(this);

	}
	public static boolean esNumero(String num) {
		boolean numerico=true;
		try {
			//Sie el cambio da error saltara un error
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
		//Si la cadena introducida tiene la longitud de 9
		if (x.length()==9) {
			//Y el ultimo caracter es un letra
			String ultimaL=String.valueOf(x.charAt(x.length()-1));
			if (letrasValidas.contains(ultimaL)) {
				//y los 8 caracteres anteriores son numeros, y el 
				//el contandor ha llegado a 8 devolvera true
				for (int i = 0; i < x.length(); i++)if (esNumero(String.valueOf(x.charAt(i))))contador++;
				//sino false
				if (contador==8)return true;
				//Si no es un letra devulve false
			}else {
				return false;
			}
		}
		//Si la cadena no tiene 9 caracteres 
		//devulve false
		return false;

	}
	public static boolean checkTlf(int tlf) {
		//Si la cadena de numeros tiene 9 devulve true
		if (Integer.toString(tlf).length()==9) {
			return true;
		}
		//sino false
		return false;
	}
	public static boolean checkMail(String str) {
		String preArroba = null;
		String postArroba = null;
		//Se recorrera la array en busca de un @
		//al encontrarla se separara desde el principio hasta 
		//el caracter anterior de la arroba y desde el siguiente
		//hasta el final
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)=='@') {
				preArroba=str.substring(0,i);
				postArroba=str.substring(i+1,str.length());
			}			
		}
		//si no hay arroba la variable que guarda lo que hay 
		//despues de esta sera null por lo devolvera false.
		String postArrobaPre = null, postArrobaPos = null;
		if (postArroba!=null) {
			//De la parte posterior de la arroba se buscara un '.'
			for (int i = 0; i < postArroba.length(); i++) {
				if (postArroba.charAt(i)=='.') {
					//se guarda la parte anterior del punto 
					postArrobaPre=str.substring(0,i);
					//Si el punto no esta en la ultima posicion 
					//se guarda lo que hay al final
					if (i!=postArroba.length()-1)postArrobaPos=str.substring(i+1,postArroba.length());
				}
				//Si despues del punto hay una arroba devolvera false
				if (postArroba.charAt(i)=='@')return false;
			}
			//si lo que hay antes de la arroba esta vacio o si lo que hay despues 
			//de la arroba y antes del punot esta vacio o si lo que hay despues 
			//de la arroba pero despues del punto del punto esta vacio
			//devolvera false
			if (postArrobaPos==null||postArrobaPre==null||preArroba==null) {
				return false;
				//si no true
			}else {
				return true;
			}
			//si lo que hay despues del arroba esta vacio devolvera false
		}else {
			return false;
		}
	}
	public static boolean checkMatricula(String str) {
		//Si la cadena introducida tiene 7 caracteres
		//Tendra este formato: 4326PJK
		if (str.length()==7) {
			String LetrasMatricula="BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxYyZz";
			//se recogeran los 4 primero digito y las 3 letras
			String dijitos= str.substring(0,4);
			String letras=str.substring(4);
			//Se comprobara si la la cadena de los numero 
			//de la matricula con numeros
			try {
				int numeroMatricula=Integer.parseInt(dijitos);
			} catch (NumberFormatException e) {
				//si no son numero devolvera false
				return false;
			}
			int contLetrasValidas=0;
			//se recorrera la cadena y si tiene 3 letras validas 
			//se sumara 1 por cada uno
			for (int i = 0; i < letras.length(); i++) {
				if (LetrasMatricula.contains(String.valueOf(letras.charAt(i))) ){
					contLetrasValidas++;
				}
			}
			//si el contador tiene 3 devolvera true
			//si no false
			if (contLetrasValidas==3) {
				return true;
			}else {
				return false;
			}
			//Si la cadena introducida tiene 8 caracteres
			//Tendra este formato: SS6738BH
			//					   M 5687BH
		}else if (str.length()==8) {
			//se guardaran las dos primeras letras, los cuatro digitos
			//y los dos ultimas letras
			String LetrasMatricula=" BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxYyZz";
			String letraP=str.substring(0,2);
			String dijitos=str.substring(2,6);
			String letraF=str.substring(2,8);
			int contLetraValida=0;
			//Se recorrera la cadena y comprobara si las dos letras del principio 
			//son realmente letras
			for (int i = 0; i < letraP.length(); i++) {
				if (LetrasMatricula.contains(String.valueOf(letraP.charAt(i))))contLetraValida++;
			}
			//si el contador es de dos seguira si no 
			//dara false
			if (contLetraValida!=2)return false;
			//Luego si los numeros numero son realmente numeros
			//seguira si no devolvera false
			try {
				int numeroMa=Integer.parseInt(dijitos);
			} catch (NumberFormatException e) {
				return false;
			}
			//el contador se reseteara a 0 
			contLetraValida=0;
			//y se volvera a comprobar como con los dos caracteres del principio
			for (int i = 0; i < letraF.length(); i++) {
				if (LetrasMatricula.contains(String.valueOf(letraF.charAt(i))))contLetraValida++;
			}
			//nuevamente si el contador no es de 2 devolvera false
			if (contLetraValida!=2)return false;
			//si no devolvera true
			return true;
			//si  no tiene ninguna de las logitudes anteriores dara false
		}else {
			return false;
		}
	}
	public static boolean checkAño(int año) {
		//si la fecha del sistema es superios a la actual
		//devolvera false, si no true
		Calendar fechaActual = Calendar.getInstance();
		int añoActual= fechaActual.get(Calendar.YEAR);
		if (año>añoActual) {
			return false;
		}
		return true;
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
		if (e.getSource()==btnGuardar) {			
			String matricula= tfMatricula.getText();
			String marca=tfMarca.getText();
			String modelo=tfModelo.getText();
			int año=Integer.parseInt(tfAño.getText());
			String dni=tfDni.getText();
			Vehiculo v= new Vehiculo(matricula, marca, modelo, año, dni);
			v.actualizarBase();
		}
		if (e.getSource()==btnElim) {			
			String matricula= tfMatricula.getText();
			String marca=tfMarca.getText();
			String modelo=tfModelo.getText();
			int año=Integer.parseInt(tfAño.getText());
			String dni=tfDni.getText();
			Vehiculo v= new Vehiculo(matricula, marca, modelo, año, dni);
			v.elimVehiculo();
			setVisible(false);
			dispose();
			menuBusqueda mB=new menuBusqueda();
			mB.setVisible(true);
			mB.setLocationRelativeTo(null);
		}
		if (e.getSource()==btnMostrarCli) {		
			String Dni="";
			Dni=tfDni.getText();
			String cliente="SELECT * FROM CLIENTE WHERE NIF='"+Dni+"'";
			if (existente(Dni, cliente)) {
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
			}
		}
		
		if (e.getSource()==btnEliminarReparacion) {
			JOptionPane.showMessageDialog(null, "4");
		}
		if (e.getSource()==btnAñadirReparacion) {
			JOptionPane.showMessageDialog(null, "5");
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
