package utn.tp.poi;



import utn.tp.poi.model.CentroDTO;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RepoCentros {
    private Set<CentroDTO> centros = new HashSet<CentroDTO>();

    /**
     * Default constructor
     */
    public RepoCentros(){
    }

    /**
     * Contructor with initial data
     * @param initialData
     */
    public RepoCentros(Set<CentroDTO> initialData) {
        if(initialData!=null){
            centros.addAll(initialData);
        }
    }

    /**
     * Adds a new entry
     * @param centro
     * @return
     */
    public boolean addCentro(CentroDTO centro) {
        return this.centros.add(centro);
    }

    /**
     * Removes given entry
     * @param centro
     * @return
     */
    public boolean removeCentro(CentroDTO centro) {
        return this.centros.remove(centro);
    }

    /**
     * Searches for entries that match given parameters
     * @param zonaQuery
     * @return
     */
    public Set<CentroDTO> buscar(String zonaQuery) {
        Set<CentroDTO> result = new HashSet<CentroDTO>();

        if(zonaQuery.trim().length() == 0){
            return Collections.emptySet();
        }

        zonaQuery = ".*" + zonaQuery.toLowerCase() + ".*";

        for (CentroDTO centro : centros) {
            if (centro.getZonas().toLowerCase().matches(zonaQuery)) {
                result.add(centro);
            }
        }
        return result;
    }
}
