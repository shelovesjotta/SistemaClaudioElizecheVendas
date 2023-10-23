/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;
import bean.CjrUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author junior
 */
    public class CjrUsuariosControle extends AbstractTableModel {
    
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public CjrUsuarios getBean(int row) {
        return (CjrUsuarios) lista.get(row);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CjrUsuarios cjrusuarios = (CjrUsuarios) lista.get(rowIndex);
        if( columnIndex == 0){
            return cjrusuarios.getCjrIdUsuario();
        }
        if( columnIndex == 1){
            return cjrusuarios.getCjrNome();
        }
        if( columnIndex == 2){
            return cjrusuarios.getCjrApelido();
        }
        if( columnIndex == 3){
            return cjrusuarios.getCjrCpf();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        if( column == 0){
            return "ID";
        }
        if( column == 1){
            return "Nome";
        }
        if( column == 2){
            return "apelido";
        }
        if( column == 3){
            return "cpf";
        }
        return "";
    }
}
