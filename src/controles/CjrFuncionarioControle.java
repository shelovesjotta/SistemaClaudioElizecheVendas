/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.CjrFuncionario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author junior
 */
    public class CjrFuncionarioControle extends AbstractTableModel {
    
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public CjrFuncionario getBean(int row) {
        return (CjrFuncionario) lista.get(row);
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
        CjrFuncionario cjrfuncionario = (CjrFuncionario) lista.get(rowIndex);
        if( columnIndex == 0){
            return cjrfuncionario.getCjrIdFuncionario();
        }
        if( columnIndex == 1){
            return cjrfuncionario.getCjrNome();
        }
        if( columnIndex == 2){
            return cjrfuncionario.getCjrCpf();
        }
        if( columnIndex == 3){
            return cjrfuncionario.getCjrEndereco();
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
            return "CPF";
        }
        if( column == 3){
            return "Endereço";
        }
        return "";
    }
}