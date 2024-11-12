package parcial3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;

public class parcial_3 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField campoEstudiante;
    private JTextField parcialesNota;
    private JTextField semestralesNota;
    private JTextField proyectosNota;
    private JTextField estudiantesTotal;
    private JTable table;
    private JComboBox<String> comboBoxTurno;
    private int totalEstudiantes = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    parcial_3 frame = new parcial_3();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public parcial_3() {
        setTitle("Calificaciones del Curso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 702, 469);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("CALIFICACIONES DEL CURSO DE DESARROLLO DE SOFTWARE II - 2024");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(10, 11, 664, 34);
        lblTitulo.setForeground(new Color(0, 153, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(lblTitulo);

        JLabel lbEstudiante = new JLabel("Nombre del Estudiante:");
        lbEstudiante.setBounds(10, 48, 206, 34);
        lbEstudiante.setForeground(new Color(255, 0, 51));
        lbEstudiante.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(lbEstudiante);

        campoEstudiante = new JTextField();
        campoEstudiante.setBounds(207, 56, 467, 20);
        contentPane.add(campoEstudiante);
        campoEstudiante.setColumns(10);

        JLabel lblParciales = new JLabel("Nota de Parciales:");
        lblParciales.setBounds(20, 105, 129, 14);
        lblParciales.setForeground(Color.BLACK);
        lblParciales.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblParciales);

        parcialesNota = new JTextField();
        parcialesNota.setBounds(145, 103, 57, 20);
        contentPane.add(parcialesNota);
        parcialesNota.setColumns(10);

        JLabel lblProyectos = new JLabel("Nota de Proyectos:");
        lblProyectos.setBounds(252, 106, 140, 14);
        lblProyectos.setForeground(Color.BLACK);
        lblProyectos.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblProyectos);

        proyectosNota = new JTextField();
        proyectosNota.setBounds(389, 103, 57, 20);
        contentPane.add(proyectosNota);
        proyectosNota.setColumns(10);

        JLabel lblSemestrales = new JLabel("Nota de Semestrales:");
        lblSemestrales.setBounds(20, 142, 152, 14);
        lblSemestrales.setForeground(Color.BLACK);
        lblSemestrales.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblSemestrales);

        semestralesNota = new JTextField();
        semestralesNota.setBounds(167, 140, 57, 20);
        contentPane.add(semestralesNota);
        semestralesNota.setColumns(10);

        JLabel lblTurno = new JLabel("Turno al que asiste:");
        lblTurno.setBounds(252, 143, 140, 14);
        lblTurno.setForeground(Color.BLACK);
        lblTurno.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblTurno);

        comboBoxTurno = new JComboBox<>();
        comboBoxTurno.setModel(new DefaultComboBoxModel<>(new String[]{"Diurno", "Nocturno"}));
        comboBoxTurno.setBounds(389, 139, 100, 22);
        contentPane.add(comboBoxTurno);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(49, 244, 601, 127);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"Estudiante", "Turno", "Nota Parcial", "Nota Proyecto", "Nota Semestral", "Promedio"}
        ));
        scrollPane.setViewportView(table);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(241, 191, 95, 23);
        btnAgregar.setForeground(new Color(0, 153, 255));
        btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarEstudiante();
            }
        });
        contentPane.add(btnAgregar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(371, 191, 89, 23);
        btnEliminar.setForeground(Color.RED);
        btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarEstudiante();
            }
        });
        contentPane.add(btnEliminar);

        JLabel lblTotalEstudiantes = new JLabel("Total de Estudiantes:");
        lblTotalEstudiantes.setBounds(449, 397, 146, 14);
        lblTotalEstudiantes.setForeground(Color.BLACK);
        lblTotalEstudiantes.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblTotalEstudiantes);

        estudiantesTotal = new JTextField();
        estudiantesTotal.setBounds(593, 395, 57, 20);
        estudiantesTotal.setEditable(false);
        contentPane.add(estudiantesTotal);
    }

    private void agregarEstudiante() {
        // Validación de campos vacíos
        if (campoEstudiante.getText().isEmpty() || parcialesNota.getText().isEmpty() || proyectosNota.getText().isEmpty() || semestralesNota.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = campoEstudiante.getText();
        String turno = (String) comboBoxTurno.getSelectedItem();
        
        // Validación de números
        try {
            double notaParcial = Double.parseDouble(parcialesNota.getText());
            double notaProyecto = Double.parseDouble(proyectosNota.getText());
            double notaSemestral = Double.parseDouble(semestralesNota.getText());

            // Calcular promedio y formatear a 2 decimales
            double promedio = (notaParcial + notaProyecto + notaSemestral) / 3;
            DecimalFormat df = new DecimalFormat("#.##");
            String promedioFormateado = df.format(promedio);

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{nombre, turno, notaParcial, notaProyecto, notaSemestral, promedioFormateado});

            // Actualizar el contador de estudiantes
            totalEstudiantes++;
            estudiantesTotal.setText(String.valueOf(totalEstudiantes));

            // Limpiar los campos y enfocar en el campo de nombre
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Las notas deben ser valores numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarEstudiante() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            // Mostrar un cuadro de diálogo de confirmación
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de que desea eliminar al estudiante seleccionado?",
                "Confirmación de eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            // Si el usuario selecciona "Sí", procede a eliminar el estudiante
            if (confirm == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(selectedRow);

                // Actualizar el contador de estudiantes
                totalEstudiantes--;
                estudiantesTotal.setText(String.valueOf(totalEstudiantes));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un estudiante para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void limpiarCampos() {
        campoEstudiante.setText("");
        parcialesNota.setText("");
        proyectosNota.setText("");
        semestralesNota.setText("");
        comboBoxTurno.setSelectedIndex(0);
        campoEstudiante.requestFocus();
    }
}

