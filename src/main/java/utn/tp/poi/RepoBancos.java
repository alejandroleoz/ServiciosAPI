package utn.tp.poi;


import utn.tp.poi.model.BancoDTO;

import java.util.HashSet;
import java.util.Set;

public class RepoBancos {
    private Set<BancoDTO> bancos = new HashSet<BancoDTO>();

    public boolean addBanco(BancoDTO banco) {
        return this.bancos.add(banco);
    }

    public boolean removeBanco(BancoDTO banco) {
        return this.bancos.remove(banco);
    }

    public Set<BancoDTO> buscar(String bancoQuery, String servicioQuery) {
        Set<BancoDTO> result = new HashSet<BancoDTO>();
        for (BancoDTO banco : bancos) {
            if (banco.getBanco().toLowerCase().equals(bancoQuery.toLowerCase())) {
                result.add(banco);
            } else {
                for (String servicio : banco.getServicios()) {
                    if (servicio.toLowerCase().equals(servicioQuery.toLowerCase())) {
                        result.add(banco);
                    }
                }
            }
        }
        return result;
    }
}
