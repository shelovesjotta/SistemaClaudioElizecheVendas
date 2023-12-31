/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.CjrVendaProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author junior
 */
    public class CjrVendaProdutoControle extends AbstractTableModel {
    
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public CjrVendaProduto getBean(int row) {
        return (CjrVendaProduto) lista.get(row);
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
        CjrVendaProduto cjrvendaproduto = (CjrVendaProduto) lista.get(rowIndex);
        if( columnIndex == 0){
            return cjrvendaproduto.getCjrProduto();
        }
        if( columnIndex == 1){
            return cjrvendaproduto.getCjrQuantidade();
        }
        if( columnIndex == 2){
            return cjrvendaproduto.getCjrValorUnitario();
        }
        if( columnIndex == 3){
            return cjrvendaproduto.getCjrQuantidade() * cjrvendaproduto.getCjrValorUnitario();
        }
        
        return "";
    }
    
    public void addBean(CjrVendaProduto cjrVendaProduto) {
        lista.add(cjrVendaProduto);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int index) {
        if (lista != null && index >= 0 && index < lista.size() ) {
            lista.remove(index);
            this.fireTableDataChanged();   
        }
    }
    
    public void updateBean(int index, CjrVendaProduto cjrVendaProduto) {
        lista.set(index, cjrVendaProduto);
        this.fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        if( column == 0){
            return "Produto";
        }
        if( column == 1){
            return "Quantidade";
        }
        if( column == 2){
            return "Valor Unitario";
        }
        if( column == 3){
            return "Total";
        }
        return "";
    }
}
