package klassen;

public class Eigenschaft {
    
    private String _name;
    private String _datentyp;
    private boolean _editierbar;
    
    public Eigenschaft(){
        
    }

    public Eigenschaft(String _name, String _datentyp, boolean _editierbar) {
        this._name = _name;
        this._datentyp = _datentyp;
        this._editierbar = _editierbar;
    }

    public String getName() {
        return _name;
    }

    public String getDatentyp() {
        return _datentyp;
    }

    public boolean isEditierbar() {
        return _editierbar;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public void setDatentyp(String _datentyp) {
        this._datentyp = _datentyp;
    }

    public void setEditierbar(boolean _editierbar) {
        this._editierbar = _editierbar;
    }
    
    public void setEditierbar(String _editierbar) {
        if(_editierbar == "1"){
            this._editierbar = true;
        } else {
            this._editierbar = false;
        }
    }
}
