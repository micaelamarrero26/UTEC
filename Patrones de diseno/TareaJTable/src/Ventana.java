
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class Ventana {

	private JFrame frame;
	private JTextField textCedula;
	private JTextField textApellido;
	private JTextField textNombre;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnMostrarTodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLIntegrityConstraintViolationException 
	 */
	public Ventana() throws SQLIntegrityConstraintViolationException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws SQLIntegrityConstraintViolationException{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textCedula = new JTextField();
		textCedula.setBounds(132, 36, 86, 20);
		frame.getContentPane().add(textCedula);
		textCedula.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(132, 114, 86, 20);
		frame.getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(132, 69, 86, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		btnMostrarTodo = new JButton("Mostrar Todo");
		btnMostrarTodo.setBounds(61, 176, 157, 23);
		frame.getContentPane().add(btnMostrarTodo);
		
		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setBounds(48, 39, 46, 14);
		frame.getContentPane().add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(48, 72, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(48, 117, 61, 14);
		frame.getContentPane().add(lblApellido);
		
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ci=textCedula.getText();
				String nombre=textNombre.getText();
				String apellido=textApellido.getText();
				if(!(ci.equals("") || nombre.equals("") || apellido.equals(""))) {
					if(ci.equals(DAOEmpleados.find(ci).getCedula())) {
						JOptionPane.showMessageDialog(null, "El empleado ya existe en la base de datos", "ERROR", JOptionPane.INFORMATION_MESSAGE);
						textApellido.setText("");
						textCedula.setText("");
						textNombre.setText("");
					} else {
						Empleado e = new Empleado(ci,nombre,apellido);
						DAOEmpleados.insert(e);
						JOptionPane.showMessageDialog(null, "Se ha agregado al empleado " + ci + " - " + nombre + " " + apellido ,"Exito", JOptionPane.INFORMATION_MESSAGE);
						textApellido.setText("");
						textCedula.setText("");
						textNombre.setText("");
					}
					

				} else {
					JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnAlta.setBounds(254, 35, 89, 23);
		frame.getContentPane().add(btnAlta);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ci=textCedula.getText();
				String nombre=textNombre.getText();
				String apellido=textApellido.getText();
				if(!ci.equals("")) {
					Empleado e1 = new Empleado(ci,nombre,apellido);
					DAOEmpleados.delete(e1);
					JOptionPane.showMessageDialog(null, "Se ha eliminado el registro del empleado con CI " + ci, "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
					textApellido.setText("");
					textCedula.setText("");
					textNombre.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "El campo CÉDULA es obligatorio", "ERROR", JOptionPane.INFORMATION_MESSAGE);

				}

				
			}
		});
		btnEliminar.setBounds(254, 83, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ci=textCedula.getText();
				
				if(!ci.equals("")) {
					if(ci.equals(DAOEmpleados.find(ci).getCedula())) {

						Empleado re=DAOEmpleados.find(ci);
						textNombre.setText(re.getNombre());
						textApellido.setText(re.getApellido());
						
					}
					else {
						JOptionPane.showMessageDialog(null, "No existen empleados con esa cédula de identidad", "ERROR", JOptionPane.INFORMATION_MESSAGE);

					}
				}
				else {
					
					JOptionPane.showMessageDialog(null, "El campo CÉDULA es obligatorio", "ERROR", JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		btnBuscar.setBounds(254, 128, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ci=textCedula.getText();
				String nombre=textNombre.getText();
				String apellido=textApellido.getText();
				if(!(ci.equals("") || nombre.equals("") || apellido.equals(""))) {
					if(ci.equals(DAOEmpleados.find(ci).getCedula())) {

						Empleado e1 = new Empleado(ci,nombre,apellido);
						DAOEmpleados.update(e1);
						JOptionPane.showMessageDialog(null, "Se ha modificado el registro del empleado con CI " + ci, "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
						textApellido.setText("");
						textCedula.setText("");
						textNombre.setText("");
					} else { 
						JOptionPane.showMessageDialog(null, "No existen empleados con esa cédula de identidad", "ERROR", JOptionPane.INFORMATION_MESSAGE);

					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				

			}			
		});
		btnModificar.setBounds(254, 176, 89, 23);
		frame.getContentPane().add(btnModificar);
		
		btnMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				MostrarTodo mt=new MostrarTodo();
				mt.mostrar();
			}
		});
		
	}
}
