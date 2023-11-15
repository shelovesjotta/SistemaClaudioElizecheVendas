/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.CjrProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author junior
 */
    public class CjrProdutoControle extends AbstractTableModel {
    
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public CjrProduto getBean(int row) {
        return (CjrProduto) lista.get(row);
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
        CjrProduto produto = (CjrProduto) lista.get(rowIndex);
        if( columnIndex == 0){
            return produto.getCjrIdProduto();
        }
        if( columnIndex == 1){
            return produto.getCjrNome();
        }
        if( columnIndex == 2){
            return produto.getCjrPreco();
        }
        if( columnIndex == 3){
            return produto.getCjrTipo();
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
            return "Preço";
        }
        if( column == 3){
            return "Tipo";
        }
        return "";
    }
}
