/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;
import bean.CjrCliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 71661414176
 */
public class CjrClienteControle extends AbstractTableModel {
    
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
    }
    
    public CjrCliente getBean(int row) {
        return (CjrCliente) lista.get(row);
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
        CjrCliente cjrcliente = (CjrCliente) lista.get(rowIndex);
        if( columnIndex == 0){
            return cjrcliente.getCjrIdCliente();
        }
        if( columnIndex == 1){
            return cjrcliente.getCjrNome();
        }
        if( columnIndex == 2){
            return cjrcliente.getCjrEmail();
        }
        if( columnIndex == 3){
            return cjrcliente.getCjrSaldoCarteira();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        if( column == 0){
            return "id";
        }
        if( column == 1){
            return "nome";
        }
        if( column == 2){
            return "email";
        }
        if( column == 3){
            return "saldo da carteira";
        }
        return "";
    }
}
