import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import javax.swing.event.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;


public class ListaCliente extends JFrame implements ActionListener{

    
	public JPanel miPanelSuperior, miPanelCentral;
	public JMenuBar barraMenu;

	
	public JScrollPane jScrollPane1;
	public JTable jTabla;
	public DefaultTableModel modelo1, modelo2;
	public JButton BotonCargar, BotonModificar, BotonEliminar;
	public JLabel etiqueta;
	public JComboBox comboBox;
	public JTextField textoCampo;
	private JLabel filtro;
	private JMenu menu1, menu2, menu3, menu4, menu5, menu6;
	private JMenuItem mi1,mInicio, mi2, mi3, mi4, mi5, mi6, mi7, mi8, mi9, mi10, mi11, mi12, mi13, mi14;
	public PreparedStatement pS;
	public ResultSet rS;

	
    public ListaCliente() {
    	
		// Inclusi贸n del men煤
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


    	// Panel superior filtros
    	getContentPane().setLayout(new BorderLayout(0,0));    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,800,553);
		
		JPanel miPanelSuperior = new JPanel();
		miPanelSuperior.setBackground(new Color(0, 0, 70));	
		getContentPane().add(miPanelSuperior, BorderLayout.NORTH);
		miPanelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 35));
		
		
		// Filtrar combox y textField
		etiqueta = new JLabel("Filtrar");
		etiqueta.setForeground(new Color(255,255,0));
		miPanelSuperior.add(etiqueta);
		
		comboBox = new JComboBox();
        comboBox = new JComboBox();
        comboBox.addItem("SIN FILTRO");
        comboBox.addItem("NIF");
		comboBox.addItem("NOMBRE");
		comboBox.addItem("TELEFONO");
		
		//Selecionamos un elemento por defecto
		comboBox.setSelectedItem("SIN FILTRO");
		miPanelSuperior.add(comboBox);
		
        textoCampo = new JTextField();
        textoCampo.setColumns(10);
        miPanelSuperior.add(textoCampo);
        
        
        // Los botones
        BotonCargar = new JButton();
        BotonCargar.setText("Cargar");
        miPanelSuperior.add(BotonCargar);
        BotonCargar.addActionListener(this);
        
        BotonModificar = new JButton();
        BotonModificar.setText("Modificar");
        miPanelSuperior.add(BotonModificar);
        BotonModificar.addActionListener(this);
        
        BotonEliminar = new JButton();
        BotonEliminar.setText("Eliminar");
        miPanelSuperior.add(BotonEliminar);
        BotonEliminar.addActionListener(this);
		
		
		// Panel con la taula Clientes
		JPanel miPanelCentral = new JPanel();
		miPanelCentral.setBackground(new Color(0, 0, 70));
		getContentPane().add(miPanelCentral, BorderLayout.CENTER);
    	jScrollPane1 = new JScrollPane();
        
    	jScrollPane1.setPreferredSize(new Dimension(750, 350));
    	jTabla = new JTable();
 
    	jScrollPane1.setViewportView(jTabla);
    	miPanelCentral.add(jScrollPane1);
    	
        // Conexion 
		Conexion conn = new Conexion();
		Connection conex = conn.conexOra();
        
        creacionTablaClientes(conex);
                
    }
    // Creacion de la taula clientes
	private void creacionTablaClientes(Connection conex) {
		
		// Cuando se desea filtrar pero no se rellena el campo
		if (comboBox.getSelectedItem() != "SIN FILTRO" && "".equals(textoCampo.getText())) { 
			JOptionPane.showMessageDialog(null, "Rellena el campo para la busqueda");
			comboBox.setSelectedItem("SIN FILTRO");
		}
		else {
		
			try {
				DefaultTableModel modelo = new DefaultTableModel();
		        jTabla.setModel(modelo);
		        
	    		String sql = "";
	    		
	    		// En funci贸n del filtrado (cuando no esta la opci贸n sin filtro)
	    		if (comboBox.getSelectedItem() != "SIN FILTRO") {
	    			
	    			String campo = textoCampo.getText();
	    			// Si el campo no esta vacio
	                if (!"".equals(campo)) {
	                	sql = "SELECT * FROM cliente WHERE " + comboBox.getSelectedItem()+"='" +campo+"'";
	                	textoCampo.setText("");
	                	comboBox.setSelectedItem("SIN FILTRO");
	                }
	    		}
	    		else {
	    			sql = "SELECT * FROM cliente order by nombre";
	    		}
	    		    		
	            pS = conex.prepareStatement(sql);
	            rS = pS.executeQuery();
	            ResultSetMetaData resultMetaDatos = rS.getMetaData();
	            
	            // Obtenci贸n del n煤mero de columnas de la tabla de la base de datos
	            int numColumnas = resultMetaDatos.getColumnCount();
		
	            // Definici贸n de las columnas
	            modelo.addColumn("NIF");
	            modelo.addColumn("NOMBRE");
	            modelo.addColumn("PRIMER APELLIDO");
	            modelo.addColumn("SEGUNDO APELLIDO");
	            modelo.addColumn("DIRECCION");
	            modelo.addColumn("TELEFONO");
	            modelo.addColumn("CORREO");
	            modelo.addColumn("NUMERO CUENTA");
	            modelo.addColumn("USUARIO");
	            modelo.addColumn("CONTRASE袮");
	
	            // Inserci贸n de datos de las columnas
	            for (int i = 0; i < jTabla.getColumnCount(); i++) {
	            	jTabla.getColumnModel().getColumn(i);
	            }
	            
	            // Se obtienen los datos y se meten por filas
	            while (rS.next()) {
	                Object[] filas = new Object[numColumnas];
	        		
	                filas[0] = rS.getString("nif");
	                filas[1] = rS.getString("nombre");
	                filas[2] = rS.getString("apellido1");
	                filas[3] = rS.getString("apellido2");
	                filas[4] = rS.getString("direccion");
	                filas[5] = rS.getString("telefono");
	                filas[6] = rS.getString("correo");
	                filas[7] = rS.getString("n_cuenta");
	                filas[8] = rS.getString("usuario");
	                filas[9] = rS.getString("contrase馻");
	                
	                modelo.addRow(filas);
	            }
	        } catch (SQLException ex) {
	            System.err.println(ex.toString());
	        }
		}
	}
    
    // Listeners
    public void actionPerformed(ActionEvent e) {
    	
    	// Conexion 
    	Conexion conn = new Conexion();
    	Connection conex = conn.conexOra();
		
    	// Para enviar al menu principal
		if (e.getSource() == mi1) {
			setVisible(false);
			dispose();
			menuBusqueda frame = new menuBusqueda();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		}
		
		if (e.getSource() == mi2) {
		
			//Salida del programa
			System.exit(0);
		}
		
		// Actualizar o mostrar con filtro la taula de clientes
		if (e.getSource() == BotonCargar ) {
			
				creacionTablaClientes(conex);
		}	
		
		// Para eliminar clientes
		if ( e.getSource() == BotonEliminar ){
			
			int fila = jTabla.getSelectedRow();
			
			if (fila!=-1) {
				 try {
					 // Guardo el nif del sujeto a eliminar (el primer datos de la taula)
		             String codigo = jTabla.getValueAt(fila, 0).toString();
		
		             pS = conex.prepareStatement("DELETE FROM cliente WHERE nif=?");
		             pS.setString(1, codigo);
		             pS.execute();
		
		            // Vuelvo a cargar la taula
		            creacionTablaClientes(conex);
		            JOptionPane.showMessageDialog(null, "Cliente Eliminado");
		
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Error al Eliminar Cliente");
		            System.out.println(ex.toString());
		        }
			}
			else {
				JOptionPane.showMessageDialog(null, "Selecciona la fila que desea borrar");
			}
		}
		
		// Para obtener los datos del cliente que deseo modificar y enviarlos a visualizarCliente
		if ( e.getSource() == BotonModificar ){
		
			int fila = jTabla.getSelectedRow();
			
			if (fila!=-1) {
				//Ocultar la ventana
				setVisible(false);
				//Cerrar
				dispose();
				visualizarCliente visualizarCli=new visualizarCliente();
				// Defino donde quiero que vayan los datos
				visualizarCli.tfDni.setText(jTabla.getValueAt(fila, 0).toString());
				// Bloquea la posible edicion del DNI
				visualizarCli.tfDni.setEditable(false);
				visualizarCli.tfNombre.setText(jTabla.getValueAt(fila, 1).toString());
				// Para el caso de que sea null este dato
				if (jTabla.getValueAt(fila, 2) != null) {
					visualizarCli.tfApe1.setText(jTabla.getValueAt(fila, 2).toString());
				}
				// Para el caso de que sea null este dato
				if (jTabla.getValueAt(fila, 3) != null) {
					visualizarCli.tfApe2.setText(jTabla.getValueAt(fila, 3).toString());
				}
				visualizarCli.tfDireccion.setText(jTabla.getValueAt(fila, 4).toString());
				visualizarCli.tfTelefono.setText(jTabla.getValueAt(fila, 5).toString());
				visualizarCli.tfCorreo.setText(jTabla.getValueAt(fila, 6).toString());
				visualizarCli.tfNumCuenta.setText(jTabla.getValueAt(fila, 7).toString());
				// Para el caso de que sea null este dato
				if (jTabla.getValueAt(fila, 8) != null) {
					visualizarCli.tfUsuarioWeb.setText(jTabla.getValueAt(fila, 8).toString());
				}
				// Para el caso de que sea null este dato
				if (jTabla.getValueAt(fila, 9) != null) {
					visualizarCli.tfContrase馻Web.setText(jTabla.getValueAt(fila, 9).toString());
				}
				visualizarCli.setVisible(true);
				visualizarCli.setLocationRelativeTo(null);
			}
			else {
				JOptionPane.showMessageDialog(null, "Selecciona la fila que desea modificar");
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
			// Listar veh韈ulos

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
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaCliente().setVisible(true);
            }
        });
    }
    
}











