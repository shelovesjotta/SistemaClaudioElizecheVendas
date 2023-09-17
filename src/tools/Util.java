/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class Util {
    public static void habilitar(boolean valor, JComponent ... vetComp) { //ele faz um laço de repetição
        for (int i = 0; i < vetComp.length; i++) { //Aqui o for é mais burro porque vc que deve falar pra ele fazer a comparação, que seria esse int i int i = 0; i < vetComp.length; i++
            
            vetComp[i].setEnabled(valor);   
        }
    }
    
    public static void limparCampos(JComponent... vetComp) {
        for (JComponent componente : vetComp) {
           if (componente instanceof JTextField) {
               ((JTextField) componente).setText("");
           }
           else if (componente instanceof JComboBox){
                ((JComboBox) componente).setSelectedIndex(-1);
        }  else if (componente instanceof JCheckBox) {
                ((JCheckBox)componente).setSelected(true);
        }
        }
    }
   

    public static boolean perguntar(String cadeia) {
        //JOptionPane.showConfirmDialog(null, cadeia, "Perguntar", JOptionPane.YES_NO_OPTION);
        int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro",
                "confirmar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void mensagem(String cadeia) {
        JOptionPane.showMessageDialog(null, cadeia);

    }
    
     
    public static int strInt(String cad) {
        return Integer.parseInt(cad);
    }
    
    public static String intStr(int num) {
        return "";
    }
    
    public static double strDouble(String cad) {
        return 0;
    }
     
    public static String doubleStr(double num) {
        return "";
    }
    
    public static Date strDate(String cad) {
        return null;
    }
    
    public static String dateStr(Date date) {
        return "";
    }
}
