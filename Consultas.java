import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Consultas {
    private Repositorio dataRepository;
    private Predicate<RegistroDoTempo> defaultCondition;

    public Consultas(Repositorio dataRepository) {
        this.dataRepository = dataRepository;
        this.defaultCondition = registro -> registro.getPrecipitacao() > 10.0; // Exemplo de condição padrão
    }

    public List<String> datasEmQueChoveuMaisDe(double milimetros) {
        return dataRepository.getRegistros().stream()
            .filter(r -> r.getPrecipitacao() > milimetros)
            .map(r -> r.getDia() + "/" + r.getMes() + "/" + r.getAno())
            .toList();
    }

    public String diaQueMaisChoveuNoAno(int ano) {
        RegistroDoTempo registro = dataRepository.getRegistros().stream()
            .filter(reg -> reg.getAno() == ano)
            .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
            .orElseThrow(IllegalArgumentException::new);
        return registro.getDia() + "/" + registro.getMes() + "/" + registro.getAno() + ", " + registro.getPrecipitacao();
    }

    public void alteraConsultaPadrao(Predicate<RegistroDoTempo> consulta) {
        this.defaultCondition = consulta;
    }

    public List<String> datasEmQue() {
        return dataRepository.getRegistros().stream()
            .filter(defaultCondition)
            .map(r -> r.getDia() + "/" + r.getMes() + "/" + r.getAno())
            .toList();
    }
}