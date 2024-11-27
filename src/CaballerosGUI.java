import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaballerosGUI {
    private JPanel pGeneral;
    private JTabbedPane tabbedPane1;
    private JTextField txtRegID;
    private JTextField txtRegNombre;
    private JComboBox cbRegRango;
    private JTextField txtRegConstelacion;
    private JComboBox cbRegPoder;
    private JTextField txtRegMision;
    private JComboBox cbRegDificultad;
    private JTextField txtRegRecompensa;
    private JButton registrarButton;
    private JTable tbRegistro;
    private JButton mostrarInformeButton;
    private JTable tbInforme;
    private JTextField txtBuscarID;
    private JTextField txtEditNombre;
    private JComboBox cbEditRango;
    private JTextField txtEditConstelacion;
    private JComboBox cbEditPoder;
    private JTextField txtEditMision;
    private JComboBox cbEditDificultad;
    private JTextField txtEditRecompensa;
    private JButton buscarButton;
    private JButton confirmarCambiosButton;

    ListaCaballeros listaCaballeros = new ListaCaballeros();

    public CaballerosGUI() {
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Nombre", "Rango", "Constelacion", "Nivel de poder", "Mision", "Nivel de dificultad", "Recompensa"},0);
                tbRegistro.setModel(model);
                try{
                    int id = Integer.parseInt(txtRegID.getText());
                    String nombre = txtRegNombre.getText();
                    String rango = cbRegRango.getSelectedItem().toString();
                    String constelacion = txtRegConstelacion.getText();
                    int nivelPoder = Integer.parseInt(cbRegPoder.getSelectedItem().toString());
                    String mision = txtRegMision.getText();
                    int nivelDificultad = Integer.parseInt(cbRegDificultad.getSelectedItem().toString());
                    double recompensa = Double.parseDouble(txtRegRecompensa.getText());

                    listaCaballeros.agregarCaballero(new CaballeroDelZodiaco(id, nombre, rango, constelacion, nivelPoder, mision, nivelDificultad, recompensa), tbRegistro);

                    txtRegID.setText("");
                    txtRegNombre.setText("");
                    cbRegRango.setSelectedIndex(0);
                    txtRegConstelacion.setText("");
                    cbRegPoder.setSelectedIndex(0);
                    txtRegMision.setText("");
                    cbRegDificultad.setSelectedIndex(0);
                    txtRegRecompensa.setText("");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Ingrese datos validos");
                }

                listaCaballeros.actualizarTabla(tbRegistro);
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(txtBuscarID.getText());
                    CaballeroDelZodiaco caballero = listaCaballeros.buscarPorID(id);

                    if(caballero != null){
                        txtEditNombre.setText(caballero.getNombre());
                        cbEditRango.setSelectedItem(caballero.getRango());
                        txtEditConstelacion.setText(caballero.getConstelacion());
                        cbEditPoder.setSelectedItem(String.valueOf(caballero.getNivelDePoder()));
                        txtEditMision.setText(caballero.getMisionAsignada());
                        cbEditDificultad.setSelectedItem(String.valueOf(caballero.getNivelDeDificultadMision()));
                        txtEditRecompensa.setText(String.valueOf(caballero.getRecompensaPorMision()));
                    }

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "ID no valido");
                }
            }
        });
        confirmarCambiosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(txtBuscarID.getText());
                    String nombre = txtEditNombre.getText();
                    String rango = cbEditRango.getSelectedItem().toString();
                    String constelacion = txtEditConstelacion.getText();
                    int nivelPoder = Integer.parseInt(cbEditPoder.getSelectedItem().toString());
                    String mision = txtEditMision.getText();
                    int nivelDificultad = Integer.parseInt(cbEditDificultad.getSelectedItem().toString());
                    double recompensa = Double.parseDouble(txtEditRecompensa.getText());

                    CaballeroDelZodiaco caballero = listaCaballeros.buscarPorID(id);

                    if(caballero != null){
                        caballero.setNombre(nombre);
                        caballero.setRango(rango);
                        caballero.setConstelacion(constelacion);
                        caballero.setNivelDePoder(nivelPoder);
                        caballero.setMisionAsignada(mision);
                        caballero.setNivelDeDificultadMision(nivelDificultad);
                        caballero.setRecompensaPorMision(recompensa);

                        listaCaballeros.actualizarTabla(tbRegistro);
                        JOptionPane.showMessageDialog(null, "Caballero actualizado");

                        txtBuscarID.setText("");
                        txtEditNombre.setText("");
                        cbEditRango.setSelectedIndex(0);
                        txtEditConstelacion.setText("");
                        cbEditPoder.setSelectedIndex(0);
                        txtEditMision.setText("");
                        cbEditDificultad.setSelectedIndex(0);
                        txtEditRecompensa.setText("");
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Ingrese valores validos");
                }

            }
        });
        mostrarInformeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Nombre", "Rango", "Constelacion", "Nivel de poder", "Mision", "Nivel de dificultad", "Recompensa", "Aporte", "Impuesto", "Recompensa Neta"}, 0);
                tbInforme.setModel(model);
                listaCaballeros.mostrarInforme(tbInforme);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CaballerosGUI");
        frame.setContentPane(new CaballerosGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
