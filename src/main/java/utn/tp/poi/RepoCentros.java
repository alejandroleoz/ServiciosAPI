package utn.tp.poi;


import utn.tp.poi.model.CentroDTO;

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

        // if no query set -> return all (CAUTION: this is just because there are few items)
        if (zonaQuery.trim().length() == 0) {
            return new HashSet<>(this.getItems());
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
