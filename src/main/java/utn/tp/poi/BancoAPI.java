package utn.tp.poi;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utn.tp.poi.model.BancoDTO;

import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/banco")
public class BancoAPI {
    private RepoBancos repoBancos = new RepoBancos();

    @RequestMapping(method = POST)
    public void crear(@RequestBody BancoDTO banco) {
        repoBancos.addBanco(banco);
    }

    @RequestMapping(method = GET)
    public Set<BancoDTO> buscar(@RequestParam(value = "banco") String banco, @RequestParam(value = "servicio") String servicio) {
        return repoBancos.buscar(banco, servicio);
    }
}
