package utn.tp.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

import utn.tp.poi.model.BancoDTO;
import utn.tp.poi.model.CentroDTO;
import utn.tp.poi.model.ServicioDTO;

public class Factory {

    /**
     * Creates "BancoDTO" entries for given file in JSON format
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public Set<BancoDTO> createBancosFromConfig(String filename) throws IOException {
        Set<BancoDTO> result = new HashSet<>();

        List<Map> map = getItemsFromFile(filename);

        for (Map bancoMap : map) {
            BancoDTO banco = new BancoDTO();
            banco.setBanco((String) bancoMap.get("banco"));
            banco.setSucursal((String) bancoMap.get("sucursal"));
            banco.setX(((Integer) bancoMap.get("x")).doubleValue());
            banco.setY(((Integer) bancoMap.get("x")).doubleValue());
            banco.setGerente((String) bancoMap.get("gerente"));
            Set servicios = new HashSet<>();
            servicios.addAll((Collection) bancoMap.get("servicios"));
            banco.setServicios(servicios);
            result.add(banco);
        }

        return result;
    }

    /**
     * Creates "CentroDTO" entries for given file in JSON format
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public Set<CentroDTO> createCentrosFromConfig(String filename) throws IOException {
        Set<CentroDTO> result = new HashSet<>();

        List<Map> map = getItemsFromFile(filename);

        for (Map centroMap : map) {
            CentroDTO centro = new CentroDTO();
            centro.setComuna((Integer) centroMap.get("comuna"));
            centro.setZonas((String) centroMap.get("zonas"));
            centro.setDirector((String) centroMap.get("director"));
            centro.setDomicilio((String) centroMap.get("domicilio"));
            centro.setTelefono((String) centroMap.get("telefono"));

            // create servicios  for Centro
            Set<ServicioDTO> servicios = new HashSet<ServicioDTO>();
            List<Map> serviciosConfig = (List<Map>) centroMap.get("servicios");
            for (Map servicio : serviciosConfig) {
                // create Horarios for servicio
                List<Map> rangos = (List<Map>) servicio.get("rangos");
                Set<ServicioDTO.Horario> horarios = new HashSet<>();
                for (Map rango : rangos) {
                    ServicioDTO.Horario horario = new ServicioDTO.Horario();
                    horario.setDiaSemana((Integer) rango.get("dia"));
                    horario.setHoraDesde((Integer) rango.get("horaDesde"));
                    horario.setMinutosDesde((Integer) rango.get("minutosDesde"));
                    horario.setHoraHasta((Integer) rango.get("horaHasta"));
                    horario.setMinutosHasta((Integer) rango.get("minutosHasta"));
                    horarios.add(horario);
                }

                // create ServicioDTO instance and config
                ServicioDTO servicioDTO = new ServicioDTO();
                servicioDTO.setNombre((String) servicio.get("nombre"));
                servicioDTO.setHorarios(horarios);
                servicios.add(servicioDTO);
            }

            centro.setServicios(servicios);
            result.add(centro);
        }

        return result;
    }


    /**
     * Returns a map of elements from a JSON file
     *
     * @param filename
     * @return
     * @throws IOException
     */
    private List<Map> getItemsFromFile(String filename) throws IOException {
        final int BUFFER_SIZE = 1024;
        Charset utf8 = Charset.forName("UTF-8");
        byte[] buffer = new byte[BUFFER_SIZE];
        int count;
        StringBuilder str = new StringBuilder();
        InputStream fis = null;

        try {
            fis = new FileInputStream(filename);
            count = fis.read(buffer);
            while (count > 0) {
                str.append(new String(buffer,utf8));
                count = fis.read(buffer);
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        String json = str.toString();
        JsonParser parser = JsonParserFactory.getJsonParser();
        return (List) parser.parseList(json);
    }


}
