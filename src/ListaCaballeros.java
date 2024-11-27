import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListaCaballeros {
    public Nodo primero;

    public ListaCaballeros() {
        this.primero = null;
    }

    public boolean estaVacia(){
        return this.primero == null;
    }

    public boolean existeID(int id){
        if(estaVacia()){
            return false;
        }else{
            Nodo actual = primero;
            while(actual != null){
                if(id == actual.caballeroDelZodiaco.getId()){
                    return true;
                }
                actual = actual.siguiente;
            }
        }
        return false;
    }

    public void agregarCaballero(CaballeroDelZodiaco caballero, JTable jTable){
        Nodo nuevo = new Nodo(caballero);

        if(existeID(caballero.getId())){
            JOptionPane.showMessageDialog(null, "El ID ya existe. No se puede registrar");
            return;
        }

        if(estaVacia()){
            primero = nuevo;
        }else{
            Nodo actual = primero;
            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        actualizarTabla(jTable);
    }

    public void actualizarTabla(JTable jTable){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Nodo actual = primero;
        while(actual != null){
            model.addRow(new Object[]{actual.caballeroDelZodiaco.getId(),
                    actual.caballeroDelZodiaco.getNombre(),
                    actual.caballeroDelZodiaco.getRango(),
                    actual.caballeroDelZodiaco.getConstelacion(),
                    actual.caballeroDelZodiaco.getNivelDePoder(),
                    actual.caballeroDelZodiaco.getMisionAsignada(),
                    actual.caballeroDelZodiaco.getNivelDeDificultadMision(),
                    actual.caballeroDelZodiaco.getRecompensaPorMision(),
            });

            actual = actual.siguiente;
        }
    }

    public void mostrarInforme(JTable jTable){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Nodo actual = primero;
        while(actual != null){
            model.addRow(new Object[]{actual.caballeroDelZodiaco.getId(),
                    actual.caballeroDelZodiaco.getNombre(),
                    actual.caballeroDelZodiaco.getRango(),
                    actual.caballeroDelZodiaco.getConstelacion(),
                    actual.caballeroDelZodiaco.getNivelDePoder(),
                    actual.caballeroDelZodiaco.getMisionAsignada(),
                    actual.caballeroDelZodiaco.getNivelDeDificultadMision(),
                    actual.caballeroDelZodiaco.getRecompensaPorMision(),
                    actual.caballeroDelZodiaco.calcularAporteAlFondoSantuario(),
                    actual.caballeroDelZodiaco.calcularImpuestoReinoAtena(),
                    actual.caballeroDelZodiaco.calcularRecompensaNeta()});

            actual = actual.siguiente;
        }
    }

    public CaballeroDelZodiaco buscarPorID(int id){
        if(estaVacia()){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }else{
            Nodo actual = primero;
            while(actual != null){
                if(id == actual.caballeroDelZodiaco.getId()){
                    return actual.caballeroDelZodiaco;
                }
                actual = actual.siguiente;
            }
        }
        JOptionPane.showMessageDialog(null, "Caballero no encontrado");
        return null;
    }
}
