package utn.tp.poi;


import utn.tp.poi.model.BancoDTO;

import java.util.HashSet;
import java.util.Set;

public class RepoBancos {
    private Set<BancoDTO> bancos = new HashSet<BancoDTO>();

    /**
     * Default constructor
     */
    public RepoBancos(){
    }

    /**
     * Contructor with initial data
     * @param initialData
     */
    public RepoBancos(Set<BancoDTO> initialData) {
        if(initialData!=null){
            bancos.addAll(initialData);
        }
    }

    /**
     * Adds a new entry
     * @param banco
     * @return
     */
    public boolean addBanco(BancoDTO banco) {
        return this.bancos.add(banco);
    }

    /**
     * Removes given entry
     * @param banco
     * @return
     */
    public boolean removeBanco(BancoDTO banco) {
        return this.bancos.remove(banco);
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

        for (BancoDTO banco : bancos) {
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
