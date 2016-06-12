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
     *
     * @param bancoQuery
     * @param servicioQuery
     * @return
     */
    public Set<BancoDTO> buscar(String bancoQuery, String servicioQuery) {
        boolean searchByBanco = bancoQuery.trim().length() > 0;
        boolean searchByServicio = servicioQuery.trim().length() > 0;

        bancoQuery = searchByBanco ? ".*" + bancoQuery.toLowerCase() + ".*" : "";
        servicioQuery = searchByServicio ? ".*" + servicioQuery.toLowerCase() + ".*" : "";

        if (searchByBanco) {
            if (searchByServicio) {
                return searchByBancoAndServicio(bancoQuery, servicioQuery);
            } else {
                return searchByBanco(bancoQuery);
            }
        } else if(searchByServicio) {
            return searchByServicio(servicioQuery);
        } else {
            // return everything (DANGER! this is just because there are few elements)
            return new HashSet<>(this.getItems());
        }
    }


    private Set<BancoDTO> searchByBanco(String bancoQuery) {
        Set<BancoDTO> result = new HashSet<>();
        for (BancoDTO banco : this.getItems()) {
            if (banco.getBanco().toLowerCase().matches(bancoQuery)) {
                result.add(banco);
            }
        }
        return result;
    }

    private Set<BancoDTO> searchByServicio(String servicioQuery) {
        Set<BancoDTO> result = new HashSet<>();
        for (BancoDTO banco : this.getItems()) {
            for (String servicio : banco.getServicios()) {
                if (servicio.toLowerCase().matches(servicioQuery)) {
                    result.add(banco);
                }
            }
        }
        return result;
    }

    private Set<BancoDTO> searchByBancoAndServicio(String bancoQuery, String servicioQuery) {
        Set<BancoDTO> result = new HashSet<>();
        for (BancoDTO banco : this.getItems()) {
            if (banco.getBanco().toLowerCase().matches(bancoQuery)) {
                for (String servicio : banco.getServicios()) {
                    if (servicio.toLowerCase().matches(servicioQuery)) {
                        result.add(banco);
                        break;
                    }
                }
            }
        }
        return result;
    }

}
