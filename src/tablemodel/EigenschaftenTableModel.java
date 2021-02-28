/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import klassen.Eigenschaft;

public class EigenschaftenTableModel extends AbstractTableModel {
    
    private ArrayList<Eigenschaft> _eigenschaften;
    
    private static final String[] COLUMN_NAMES = {"Name", "Datentyp", "Editierbar"};
    
    public EigenschaftenTableModel(ArrayList<Eigenschaft> eigenschaften){
        this._eigenschaften = eigenschaften;
    }
    
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }
    
    @Override
    public int getRowCount(){
        return _eigenschaften.size();
    }
    
    @Override
    public int getColumnCount(){
        return COLUMN_NAMES.length;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
        case 0: return String.class;
        case 1: return String.class;
        case 2: return String.class;
        default: throw new UnsupportedOperationException("no such column: " + columnIndex);
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        
        Object value = "??";
        Eigenschaft eigenschaft = _eigenschaften.get(rowIndex);
        switch(columnIndex){
            case 0:
                value = eigenschaft.getName();
                break;
            case 1:
                value = eigenschaft.getDatentyp();
                break;
            case 2:
                value = eigenschaft.isEditierbar();
        }    
        
        return value;
    }
    
    public void setValueAt(Object Value, int rowIndex, int columnIndex){
        Eigenschaft eigenschaft = _eigenschaften.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                eigenschaft.setName((String)Value);
                break;
            case 1:
                eigenschaft.setDatentyp((String)Value);
                break;
            case 2:
                eigenschaft.setEditierbar((String)Value);
        }
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
        boolean rueckgabe;
        
        switch(columnIndex){
            case 0:
                rueckgabe = true;
                break;
            case 1:
                rueckgabe = true;
                break;
            case 2:
                rueckgabe = true;
                break;
            default:
                rueckgabe = true;
        }
        return rueckgabe;
    }
    
    public void addRow(Eigenschaft eigenschaft){
        _eigenschaften.add(eigenschaft);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }
    
    public void removeRow(int row){
        _eigenschaften.remove(row);
        fireTableRowsDeleted(row, row);
    }
    
    public ArrayList<Eigenschaft> getList(){
        return _eigenschaften;
    }
}