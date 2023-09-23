/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author claudiojunior
 */
public class Util {

    public static void habilitar(boolean valor, JComponent... vetComp) { 
        for (int i = 0; i < vetComp.length; i++) { 
            vetComp[i].setEnabled(valor);
        }
    }

    public static void limparCampos(JComponent... vetComp) { 
        for (JComponent componente : vetComp) {
            if (componente instanceof JTextField) { 
                ((JTextField) componente).setText("");
            } else if (componente instanceof JComboBox) { 
                ((JComboBox) componente).setSelectedIndex(-1);
            } else if (componente instanceof JCheckBox) { 
                ((JCheckBox) componente).setSelected(false);
                
            }

        }
    }

    public static void mensagem(String cadeia) {
        JOptionPane.showMessageDialog(null, cadeia); 
    }

    public static boolean perguntar(String cadeia) {

        JOptionPane.showConfirmDialog(null, cadeia,
                "Perguntar", JOptionPane.YES_NO_OPTION); 
        int resp = JOptionPane.showConfirmDialog(null, "Confirmar excluir?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    public static int strInt(String cad) { 
        return Integer.valueOf(cad);
    }

    public static String intStr(int num) {
        return String.valueOf(num);
    }

    public static double strDouble(String cad) {
        try {
            return Double.parseDouble(cad);
        } catch (NumberFormatException e) {
            // Trate o erro de conversão aqui (por exemplo, exiba uma mensagem de erro)
            e.printStackTrace();
            return 0.0; // Ou retorne um valor padrão adequado
        }
    }


    public static String doubleStr(double num) {
       
        return String.valueOf(num);
    }

    public static Date StrDate(String cad) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formato.parse(cad);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateStr(Date date) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(date);
    }

}