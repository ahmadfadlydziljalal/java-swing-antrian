/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.MainAntrian;

/**
 *
 * @author tmsdzil
 */
public class TableModelAntrian extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    List<MainAntrian> list;

    public TableModelAntrian(List<MainAntrian> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getCounter_name();
            case 1:
                return list.get(rowIndex).getAntrian_dilayani();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Konter";
            case 1:
                return "Antrian Dilayani";
            default:
                return null;
        }
    }

    // This method is used by the JTable to define the default
    // renderer or editor for each cell. For example if you have
    // a boolean data it will be rendered as a check box. A
    // number value is right aligned.
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        // return data[0][columnIndex].getClass();
//    }

}
