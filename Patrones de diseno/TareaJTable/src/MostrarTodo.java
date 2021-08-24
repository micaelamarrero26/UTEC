
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.*;
import java.util.LinkedList;

//clase que muestra el contenido de una tabla de la BD utilizando una tabla
public class MostrarTodo extends JFrame {

	public void mostrar(){

		JFrame frame =new JFrame("Mostrar");

		// creamos el modelo de Tabla
		DefaultTableModel modelo= new DefaultTableModel();

		// se crea la Tabla con el modelo DefaultTableModel
		final JTable table = new JTable(modelo);
		//crea un array que contiene los nombre de las columnas
		final String[] columnNames = {"Nombre","Apellido","Cedula"};
		// insertamos las columnas
		for(int column = 0; column < columnNames.length; column++){
			//agrega las columnas a la tabla
			modelo.addColumn(columnNames[column]);
		}


		
			// Se crea un array que será una de las filas de la tabla. 
			Object [] fila = new Object[columnNames.length]; 
			// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
					LinkedList<Empleado> todosEmpleados = DAOEmpleados.findAll();
				
				
			for (int i=0;i<todosEmpleados.size();i++){
		
				String nombre=todosEmpleados.get(i).getNombre();
				String apellido=todosEmpleados.get(i).getApellido();
				String cedula=todosEmpleados.get(i).getCedula();
			
				fila[0] = nombre;
				fila[1] = apellido;
				fila[2] = cedula;
				modelo.addRow(fila); 
			}
			// Se añade al modelo la fila completa.
				
			//System.out.println(modelo);
		

		//se define el tamaño de la tabla
		table.setPreferredScrollableViewportSize(new Dimension(600, 100));
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(table);
		//crea el panel
		JPanel panel = new JPanel();
		//definimos un layout
		//Agregamos el JScrollPane al contenedor
		panel.add(scrollPane);		

		frame.add(panel);
		frame.pack();

		frame.setVisible(true);


	}


}
