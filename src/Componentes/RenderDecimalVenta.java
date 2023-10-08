package Componentes;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderDecimalVenta extends DefaultTableCellRenderer {
    private static DecimalFormatSymbols simbolos;
    public static DecimalFormat formato;
        
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        formato = new DecimalFormat("#,###", simbolos);
        value = formato.format(Integer.parseInt(String.valueOf(value)));
        this.setForeground(new java.awt.Color(0,102,0));
        
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}

