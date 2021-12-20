package coronaKatana;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
 
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class DrawnHeaderRenderer extends JLabel implements TableCellRenderer {
 
    public DrawnHeaderRenderer() {
        setFont(new Font("Consolas", Font.BOLD, 14));
        setOpaque(true);
        setForeground(Color.BLACK);
        setBackground(Color.YELLOW);
        setBorder(BorderFactory.createEtchedBorder());
    }
     
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
 
}