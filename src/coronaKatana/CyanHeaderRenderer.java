package coronaKatana;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
 
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
 
/**
 * A simple renderer class for JTable component.
 * @author www.codejava.net
 *
 */
public class CyanHeaderRenderer extends JLabel implements TableCellRenderer {
 
    public CyanHeaderRenderer() {
        setFont(new Font("Consolas", Font.BOLD, 14));
        setOpaque(true);
        setForeground(Color.WHITE);
        setBackground(Color.CYAN);
        setBorder(BorderFactory.createEtchedBorder());
    }
     
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
 
}