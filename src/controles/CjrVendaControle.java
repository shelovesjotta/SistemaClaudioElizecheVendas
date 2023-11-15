/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.CjrVenda;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Junior
 */
    public class CjrVendaControle extends AbstractTableModel{

        List lista;

        public void setList(List lista){
            this.lista = lista;
            this.fireTableDataChanged();
        }

        public CjrVenda getBean(int row) {
            return (CjrVenda) lista.get(row);
        }

        @Override
        public int getRowCount() {
            return lista.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }
    

    public Object getValueAt(int rowIndex, int columnIndex) {
            CjrVenda cjrvenda = (CjrVenda) lista.get(rowIndex);
            if( columnIndex == 0){
                return cjrvenda.getCjrIdVenda();
            }
            if (columnIndex == 1) {
                return cjrvenda.getCjrFuncionario();
            }
            if( columnIndex == 2){
                return cjrvenda.getCjrCliente();
            }
            if( columnIndex == 3){
                return cjrvenda.getCjrValorTotal();
            }
            return "";
        }
    
        @Override
        public String getColumnName(int column) {
            if( column == 0){
                return "id";
            }
            if( column == 1){
                return "Funcionario";
            }
            if( column == 2){
                return "Cliente";
            }
            if( column == 3){
                return "Valor total";
            }
            return "";
        }
    }
