package utn.tp.poi;

import utn.tp.poi.model.BancoDTO;

import java.util.Set;

public class Resources {

    // Singleton usage
    private static Resources instance = null;

    private RepoBancos repoBancos;
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

    public boolean createRepoBancos(Set<BancoDTO> initialData) {
        this.repoBancos = new RepoBancos(initialData);
        return true;
    }

}
