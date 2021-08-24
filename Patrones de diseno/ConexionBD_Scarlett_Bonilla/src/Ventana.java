import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;


public class Ventana extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField txtDatosSobrePersonas;
	private JFrame frmGrupo;
	
	public JFrame getFrame() {
		return frmGrupo;
	}

	public void setFrame(JFrame frame) {
		this.frmGrupo = frame;
	}
	public Ventana() {
		inicializar();
	}
	

	private void inicializar() {
		// TODO Auto-generated method stub
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 616, 405);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 592, 358);
		frmGrupo.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);

		
		table = new JTable();
		table.setBounds(54, 82, 500, 243);
		panel.add(table);
		
		txtDatosSobrePersonas = new JTextField();
		txtDatosSobrePersonas.setBackground(SystemColor.menu);
		txtDatosSobrePersonas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDatosSobrePersonas.setText("Datos sobre PERSONAS");
		txtDatosSobrePersonas.setBounds(207, 35, 179, 23);
		panel.add(txtDatosSobrePersonas);
		txtDatosSobrePersonas.setColumns(10);
		
		DefaultTableModel modelo = new DefaultTableModel((new String[] {
				"Nombre y apellido"}),0);

		table.setModel(modelo);
		cargarRegistro(modelo, table);
		
	}

	public static void cargarRegistro(DefaultTableModel modelo, JTable table) {
		int cantFilas= table.getRowCount()-1;
		for(int i=cantFilas ; i>=0;i--) {
			modelo.removeRow(modelo.getRowCount()-1);
		}

		for(int i = 0 ; i< Principal.personas.size(); i++) {

			String datos = Principal.personas.get(i);

			Object[] data = {datos};
			modelo.addRow(data);

		}
	}
}
