import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Consultas implements IStrategy {
    private Repository repository;
    private Predicate<RegistroDoTempo> consultaPadrao;

    public Consultas(Repository repository){
        this.repository=repository;
    }

    public List<String> datasEmQueChouveuMaisDe(double milimetros){
        return repository.getTodos()
               .stream()
               .filter(r->r.getPrecipitacao() > milimetros)
               .map(r->r.getDia()+"/"+r.getMes()+"/"+r.getAno())
               .collect(Collectors.toList());
    }

    public String diaQueMaisChoveuNoAno(int ano){
        List<RegistroDoTempo> registrosAno = repository.getTodos()
            .stream()
            .filter(reg->reg.getAno()==ano)
            .collect(Collectors.toList());

        if (registrosAno.isEmpty()) {
            throw new IllegalArgumentException("Nenhum registro encontrado para o ano especificado."); 
        }

        RegistroDoTempo registro = registrosAno
            .stream()
            .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
            .orElseThrow(IllegalArgumentException::new);

        return registro.getDia() + "/" + registro.getMes() + "/" + registro.getAno() + ", " + registro.getPrecipitacao();
    }

    public List<Data> diasEmQue() {
        return repository.getTodos()
            .stream()
            .filter(consultaPadrao)
            .map(reg -> new Data(reg.getDia(), reg.getMes(), reg.getAno()))
            .collect(Collectors.toList());
    }

    public void alteraConsultaPadrao(Predicate<RegistroDoTempo> consulta)   {
        consultaPadrao=consulta;
    }

}
