

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
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;



public class nuevoCliente extends JFrame implements ActionListener{

	private static JPanel contentPane;
	public JTextField tfNombre;
	public JTextField tfApe1;
	public JTextField tfApe2;
	public JTextField tfTelefono;
	public JTextField tfNumCuenta;
	public JTextField tfCorreo;
	public JTextField tfUsuarioWeb;
	public JTextField tfContrase�aWeb;
	public JTextField tfMatriculaV1;
	public JTextField tfMarcaV1;
	public JTextField tfModeloV1;
	public JTextField tfA�oV1;
	public JTextField tfMatriculaV2;
	public JTextField tfMarcaV2;
	public JTextField tfModeloV2;
	public JTextField tfA�oV2;
	public JTextField tfMatriculaV3;
	public JTextField tfMarcaV3;
	public JTextField tfModeloV3;
	public JTextField tfA�oV3;
	private JButton btnGuardar;
	public JTextField tfDireccion;
	public JTextField tfDni;
	public JCheckBox chBoxV1, chBoxV2, chBoxV3; 
	public JCheckBox chBoxUsuarioWeb;
	private JMenuBar barraMenu;
	private JMenu menu1, menu2, menu3, menu4, menu5, menu6;
	private JMenuItem mi1, mi2,mInicio, mi3, mi4, mi5, mi6, mi7, mi8, mi9, mi10, mi11, mi12, mi13, mi14;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nuevoCliente frame = new nuevoCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public nuevoCliente() {
		//Dise�o ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 70));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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

		JLabel labelTituloNuevoCliente = new JLabel("Cliente");
		labelTituloNuevoCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelTituloNuevoCliente.setForeground(new Color(255, 255, 255));
		labelTituloNuevoCliente.setBounds(10, 10, 120, 14);
		contentPane.add(labelTituloNuevoCliente);

		JLabel labelSeparador = new JLabel("");
		labelSeparador.setOpaque(true);
		labelSeparador.setBackground(new Color(255, 255, 255));
		labelSeparador.setBounds(10, 30, 765, 2);
		contentPane.add(labelSeparador);

		JLabel Nombre = new JLabel("Nombre: (*)");
		Nombre.setForeground(new Color(255, 255, 255));
		Nombre.setBounds(10, 50, 65, 15);
		contentPane.add(Nombre);

		JLabel Apellido1 = new JLabel("Apellido 1:");
		Apellido1.setForeground(Color.WHITE);
		Apellido1.setBounds(10, 100, 63, 15);
		contentPane.add(Apellido1);

		JLabel Apellido2 = new JLabel("Apellido 2:");
		Apellido2.setForeground(Color.WHITE);
		Apellido2.setBounds(10, 150, 65, 15);
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

		tfNombre = new JTextField();
		tfNombre.setBounds(75, 50, 85, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);

		tfApe1 = new JTextField();
		tfApe1.setColumns(10);
		tfApe1.setBounds(75, 100, 85, 20);
		contentPane.add(tfApe1);

		tfApe2 = new JTextField();
		tfApe2.setColumns(10);
		tfApe2.setBounds(75, 150, 85, 20);
		contentPane.add(tfApe2);

		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(75, 195, 85, 20);
		contentPane.add(tfTelefono);

		JLabel correo = new JLabel("Correo: (*)");
		correo.setForeground(Color.WHITE);
		correo.setBounds(195, 50, 65, 15);
		contentPane.add(correo);

		JLabel numCuenta = new JLabel("N�mero de cuenta: (*)");
		numCuenta.setForeground(Color.WHITE);
		numCuenta.setBounds(195, 100, 120, 15);
		contentPane.add(numCuenta);

		tfNumCuenta = new JTextField();
		tfNumCuenta.setBounds(340, 100, 140, 20);
		contentPane.add(tfNumCuenta);
		tfNumCuenta.setColumns(10);

		tfCorreo = new JTextField();
		tfCorreo.setColumns(10);
		tfCorreo.setBounds(315, 50, 165, 20);
		contentPane.add(tfCorreo);

		JLabel direccion = new JLabel("Direccion: (*)");
		direccion.setForeground(Color.WHITE);
		direccion.setBounds(195, 150, 80, 15);
		contentPane.add(direccion);

		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(300, 150, 180, 20);
		contentPane.add(tfDireccion);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(530, 65, 175, 140);
		contentPane.add(panel);
		panel.setLayout(null);

		chBoxUsuarioWeb = new JCheckBox("Crear usuario web");
		chBoxUsuarioWeb.setBounds(5, 5, 145, 25);
		panel.add(chBoxUsuarioWeb);
		chBoxUsuarioWeb.setBackground(new Color(255, 255, 0));
		chBoxUsuarioWeb.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel usuWeb = new JLabel("Usuario Web");
		usuWeb.setBounds(5, 35, 75, 15);
		panel.add(usuWeb);

		tfUsuarioWeb = new JTextField();
		tfUsuarioWeb.setBounds(5, 50, 145, 20);
		panel.add(tfUsuarioWeb);
		tfUsuarioWeb.setColumns(10);

		JLabel contraWeb = new JLabel("Contrase�a web");
		contraWeb.setBounds(5, 80, 110, 15);
		panel.add(contraWeb);

		tfContrase�aWeb = new JTextField();
		tfContrase�aWeb.setColumns(10);
		tfContrase�aWeb.setBounds(5, 95, 145, 20);
		panel.add(tfContrase�aWeb);

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

		JLabel labelSeparador_V1 = new JLabel("");
		labelSeparador_V1.setOpaque(true);
		labelSeparador_V1.setBackground(Color.WHITE);
		labelSeparador_V1.setBounds(185, 280, 2, 145);
		contentPane.add(labelSeparador_V1);

		JPanel panelV1 = new JPanel();
		panelV1.setBackground(new Color(0, 0, 70));
		panelV1.setBounds(10, 285, 165, 135);
		contentPane.add(panelV1);
		panelV1.setLayout(null);

		chBoxV1 = new JCheckBox("A�adir vehiculo");
		chBoxV1.setBounds(0, 0, 100, 25);
		panelV1.add(chBoxV1);
		chBoxV1.setBackground(new Color(0, 0, 70));
		chBoxV1.setForeground(new Color(255, 255, 255));

		JLabel matricula = new JLabel("Matr�cula:(*)");
		matricula.setBounds(5, 30, 65, 15);
		panelV1.add(matricula);
		matricula.setForeground(new Color(255, 255, 255));

		tfMatriculaV1 = new JTextField();
		tfMatriculaV1.setBounds(80, 25, 85, 20);
		panelV1.add(tfMatriculaV1);
		tfMatriculaV1.setColumns(10);

		JLabel marca = new JLabel("Marca:(*)");
		marca.setBounds(5, 55, 60, 15);
		panelV1.add(marca);
		marca.setForeground(new Color(255, 255, 255));

		tfMarcaV1 = new JTextField();
		tfMarcaV1.setBounds(80, 50, 85, 20);
		panelV1.add(tfMarcaV1);
		tfMarcaV1.setColumns(10);

		JLabel modelo = new JLabel("Modelo:(*)");
		modelo.setBounds(5, 80, 60, 15);
		panelV1.add(modelo);
		modelo.setForeground(Color.WHITE);

		tfModeloV1 = new JTextField();
		tfModeloV1.setBounds(80, 75, 85, 20);
		panelV1.add(tfModeloV1);
		tfModeloV1.setColumns(10);

		JLabel a�o = new JLabel("A�o: (*)");
		a�o.setBounds(5, 105, 60, 15);
		panelV1.add(a�o);
		a�o.setForeground(Color.WHITE);

		tfA�oV1 = new JTextField();
		tfA�oV1.setBounds(80, 100, 85, 20);
		panelV1.add(tfA�oV1);
		tfA�oV1.setColumns(10);

		JPanel panelV2 = new JPanel();
		panelV2.setLayout(null);
		panelV2.setBackground(new Color(0, 0, 70));
		panelV2.setBounds(200, 285, 165, 135);
		contentPane.add(panelV2);

		chBoxV2 = new JCheckBox("A�adir vehiculo");
		chBoxV2.setForeground(Color.WHITE);
		chBoxV2.setBackground(new Color(0, 0, 70));
		chBoxV2.setBounds(0, 0, 100, 25);
		panelV2.add(chBoxV2);

		JLabel matricula_1 = new JLabel("Matr�cula:(*)");
		matricula_1.setForeground(Color.WHITE);
		matricula_1.setBounds(5, 30, 65, 15);
		panelV2.add(matricula_1);

		tfMatriculaV2 = new JTextField();
		tfMatriculaV2.setColumns(10);
		tfMatriculaV2.setBounds(80, 25, 85, 20);
		panelV2.add(tfMatriculaV2);

		JLabel marca_1 = new JLabel("Marca:(*)");
		marca_1.setForeground(Color.WHITE);
		marca_1.setBounds(5, 55, 60, 15);
		panelV2.add(marca_1);

		tfMarcaV2 = new JTextField();
		tfMarcaV2.setColumns(10);
		tfMarcaV2.setBounds(80, 50, 85, 20);
		panelV2.add(tfMarcaV2);

		JLabel modelo_1 = new JLabel("Modelo:(*)");
		modelo_1.setForeground(Color.WHITE);
		modelo_1.setBounds(5, 80, 60, 15);
		panelV2.add(modelo_1);

		tfModeloV2 = new JTextField();
		tfModeloV2.setColumns(10);
		tfModeloV2.setBounds(80, 75, 85, 20);
		panelV2.add(tfModeloV2);

		JLabel a�o_1 = new JLabel("A�o: (*)");
		a�o_1.setForeground(Color.WHITE);
		a�o_1.setBounds(5, 105, 60, 15);
		panelV2.add(a�o_1);

		tfA�oV2 = new JTextField();
		tfA�oV2.setColumns(10);
		tfA�oV2.setBounds(80, 100, 85, 20);
		panelV2.add(tfA�oV2);

		JLabel labelSeparador_V2 = new JLabel("");
		labelSeparador_V2.setOpaque(true);
		labelSeparador_V2.setBackground(Color.WHITE);
		labelSeparador_V2.setBounds(375, 280, 2, 145);
		contentPane.add(labelSeparador_V2);

		JPanel panelV2_1 = new JPanel();
		panelV2_1.setLayout(null);
		panelV2_1.setBackground(new Color(0, 0, 70));
		panelV2_1.setBounds(390, 285, 165, 135);
		contentPane.add(panelV2_1);

		chBoxV3 = new JCheckBox("A�adir vehiculo");
		chBoxV3.setForeground(Color.WHITE);
		chBoxV3.setBackground(new Color(0, 0, 70));
		chBoxV3.setBounds(0, 0, 100, 25);
		panelV2_1.add(chBoxV3);

		JLabel matricula_1_1 = new JLabel("Matr�cula:(*)");
		matricula_1_1.setForeground(Color.WHITE);
		matricula_1_1.setBounds(5, 30, 65, 15);
		panelV2_1.add(matricula_1_1);

		tfMatriculaV3 = new JTextField();
		tfMatriculaV3.setColumns(10);
		tfMatriculaV3.setBounds(80, 25, 85, 20);
		panelV2_1.add(tfMatriculaV3);

		JLabel marca_1_1 = new JLabel("Marca:(*)");
		marca_1_1.setForeground(Color.WHITE);
		marca_1_1.setBounds(5, 55, 60, 15);
		panelV2_1.add(marca_1_1);

		tfMarcaV3 = new JTextField();
		tfMarcaV3.setColumns(10);
		tfMarcaV3.setBounds(80, 50, 85, 20);
		panelV2_1.add(tfMarcaV3);

		JLabel modelo_1_1 = new JLabel("Modelo:(*)");
		modelo_1_1.setForeground(Color.WHITE);
		modelo_1_1.setBounds(5, 80, 60, 15);
		panelV2_1.add(modelo_1_1);

		tfModeloV3 = new JTextField();
		tfModeloV3.setColumns(10);
		tfModeloV3.setBounds(80, 75, 85, 20);
		panelV2_1.add(tfModeloV3);

		JLabel a�o_1_1 = new JLabel("A�o: (*)");
		a�o_1_1.setForeground(Color.WHITE);
		a�o_1_1.setBounds(5, 105, 60, 15);
		panelV2_1.add(a�o_1_1);

		tfA�oV3 = new JTextField();
		tfA�oV3.setColumns(10);
		tfA�oV3.setBounds(80, 100, 85, 20);
		panelV2_1.add(tfA�oV3);

		JLabel labelSeparador_V3 = new JLabel("");
		labelSeparador_V3.setOpaque(true);
		labelSeparador_V3.setBackground(Color.WHITE);
		labelSeparador_V3.setBounds(565, 280, 2, 145);
		contentPane.add(labelSeparador_V3);

		btnGuardar = new JButton("Guardar ");
		btnGuardar.setBackground(new Color(255, 255, 0));
		btnGuardar.setOpaque(true);
		btnGuardar.setBounds(580, 310, 200, 95);
		contentPane.add(btnGuardar);

		JLabel DNI = new JLabel("DNI: (*)");
		DNI.setForeground(Color.WHITE);
		DNI.setBounds(195, 200, 60, 15);
		contentPane.add(DNI);

		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(300, 195, 180, 20);
		contentPane.add(tfDni);
		btnGuardar.addActionListener(this);

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
	public static boolean checkA�o(int a�o) {
		//si la fecha del sistema es superios a la actual
		//devolvera false, si no true
		Calendar fechaActual = Calendar.getInstance();
		int a�oActual= fechaActual.get(Calendar.YEAR);
		if (a�o>a�oActual) {
			return false;
		}
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnGuardar) {			
			Persona cliente;
			//Usuario
			String nombre="", apellido1="", apellido2="", correo="", direccion="",nif="", numCuenta;
			int telefono;
			String usuario="-", contrase�a="-";
			//Vehiculo
			String [] matricula= new String[3], marca= new String[3], modelo= new String[3];
			int[] a�o=new int[3];
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
						if (chBoxUsuarioWeb.isSelected()) {
							usuario=tfUsuarioWeb.getText();
							contrase�a=tfContrase�aWeb.getText();
							cliente=new Cliente(nif, nombre, telefono, direccion, correo, usuario, contrase�a, numCuenta);
						}else {
							cliente=new Cliente(nif, nombre, telefono, direccion, correo, numCuenta);
						}
					}else {
						if (chBoxUsuarioWeb.isSelected()) {
							usuario=tfUsuarioWeb.getText();
							contrase�a=tfContrase�aWeb.getText();
							cliente=new Cliente(nif, nombre, apellido1, apellido2, telefono, direccion, correo, usuario, contrase�a, numCuenta);
						}else {
							cliente=new Cliente(nif, nombre, apellido1, apellido2, telefono, direccion, correo, numCuenta);
						}
					}
					cliente.a�adirAlaBase();
					if (chBoxV1.isSelected()) {
						matricula[0]= tfMatriculaV1.getText();
						marca[0]=tfMarcaV1.getText();
						modelo[0]=tfModeloV1.getText();
						a�o[0]=Integer.parseInt(tfA�oV1.getText());
						//if (datosMalIntro) {

						//}
						Vehiculo v1= new Vehiculo(matricula[0], marca[0], modelo[0], a�o[0], cliente.getNif());
						v1.a�adirVehiculo();					
					}
					if (chBoxV2.isSelected()) {
						matricula[1]= tfMatriculaV2.getText();
						marca[1]=tfMarcaV2.getText();
						modelo[1]=tfModeloV2.getText();
						a�o[1]=Integer.parseInt(tfA�oV2.getText());
						Vehiculo v2= new Vehiculo(matricula[1], marca[1], modelo[1], a�o[1], cliente.getNif());
						v2.a�adirVehiculo();					
					}
					if (chBoxV3.isSelected()) {
						matricula[2]= tfMatriculaV3.getText();
						marca[2]=tfMarcaV3.getText();
						modelo[2]=tfModeloV3.getText();
						a�o[2]=Integer.parseInt(tfA�oV3.getText());
						Vehiculo v3= new Vehiculo(matricula[2], marca[2], modelo[2], a�o[2], cliente.getNif());
						v3.a�adirVehiculo();
					}
				}

			} catch (NumberFormatException ex) {
				ex.getStackTrace();
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
			// Listar veh�culos

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
