import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Consultas {
    private List<RegistroDoTempo> registros;

    public Consultas(Repository rep){
        registros = new LinkedList<>();
        registros = (List<RegistroDoTempo>) rep.getTodos();
    }

    public List<String> datasEmQueChouveuMaisDe(double milimetros){
        List<String> lista = registros.stream()
                        .filter(r->r.getPrecipitacao() > milimetros)
                        .map(r->r.getDia()+"/"+r.getMes()+"/"+r.getAno())
                        .toList();
        return lista;
    }

    public String diaQueMaisChoveuNoAno(int ano){
        RegistroDoTempo registro = registros
        .stream()
        .filter(reg->reg.getAno() == ano)
        .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
        .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia()+"/"+registro.getMes()+"/"+registro.getAno()+", "+registro.getPrecipitacao();
        return resp;
    }
}
