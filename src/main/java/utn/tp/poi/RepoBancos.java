package utn.tp.poi;


import utn.tp.poi.model.BancoDTO;

import java.util.HashSet;
import java.util.Set;

public class RepoBancos extends AbstractRepo<BancoDTO> {

    public RepoBancos(Set<BancoDTO> bancos) {
        super(bancos);
    }

    /**
     * Searches for entries that match given parameters
     * @param bancoQuery
     * @param servicioQuery
     * @return
     */
    public Set<BancoDTO> buscar(String bancoQuery, String servicioQuery) {
        Set<BancoDTO> result = new HashSet<BancoDTO>();
        bancoQuery = bancoQuery.length() > 0 ? ".*" + bancoQuery.toLowerCase() + ".*" : "";
        servicioQuery = servicioQuery.length() > 0 ? ".*" + servicioQuery.toLowerCase() + ".*" : "";

        for (BancoDTO banco : this.getItems()) {
            if (banco.getBanco().toLowerCase().matches(bancoQuery)) {
                result.add(banco);
            } else {
                for (String servicio : banco.getServicios()) {
                    if (servicio.toLowerCase().matches(servicioQuery)) {
                        result.add(banco);
                    }
                }
            }
        }
        return result;
    }
}
