package utn.tp.poi;


import utn.tp.poi.model.CentroDTO;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RepoCentros extends AbstractRepo<CentroDTO> {

    public RepoCentros(Set<CentroDTO> centros) {
        super(centros);
    }
    /**
     * Searches for entries that match given parameters
     *
     * @param zonaQuery
     * @return
     */
    public Set<CentroDTO> buscar(String zonaQuery) {
        Set<CentroDTO> result = new HashSet<CentroDTO>();

        if (zonaQuery.trim().length() == 0) {
            return Collections.emptySet();
        }

        zonaQuery = ".*" + zonaQuery.toLowerCase() + ".*";

        for (CentroDTO centro : this.getItems()) {
            if (centro.getZonas().toLowerCase().matches(zonaQuery)) {
                result.add(centro);
            }
        }
        return result;
    }
}
