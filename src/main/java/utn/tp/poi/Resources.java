package utn.tp.poi;

import utn.tp.poi.model.BancoDTO;
import utn.tp.poi.model.CentroDTO;

import java.util.Set;

public class Resources {

    // Singleton usage
    private static Resources instance = null;

    private RepoBancos repoBancos;
    private RepoCentros repoCentros;
    private Factory factory = new Factory();

    public static Resources getInstance() {
        if(instance == null){
            instance = new Resources();
        }
        return instance;
    }

    private Resources(){
    }

    public Factory getFactory() {
        return this.factory;
    }

    public RepoBancos getRepoBancos() {
        return this.repoBancos;
    }

    public RepoCentros getRepoCentros() {
        return this.repoCentros;
    }

    public boolean createRepoBancos(Set<BancoDTO> initialData) {
        this.repoBancos = new RepoBancos(initialData);
        return true;
    }

    public boolean createRepoCentros(Set<CentroDTO> initialData) {
        this.repoCentros = new RepoCentros(initialData);
        return true;
    }

}
