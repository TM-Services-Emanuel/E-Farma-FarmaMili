package Componentes;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderTextoRojo extends DefaultTableCellRenderer {
        
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setForeground(new java.awt.Color(205,0,0));   
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}

