import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Consultas {
    private Repositorio datas;
    private Predicate<RegistroDoTempo> condicao;

    public Consultas(Repositorio datas) {
        this.datas = datas;
        this.condicao = registro -> registro.getPrecipitacao() > 10.0; // Exemplo de condição padrão
    }

    public List<String> datasEmQueChoveuMaisDe(double milimetros) {
        return datas.getRegistros().stream()
            .filter(r -> r.getPrecipitacao() > milimetros)
            .map(r -> r.getDia() + "/" + r.getMes() + "/" + r.getAno())
            .toList();
    }

    public String diaQueMaisChoveuNoAno(int ano) {
        RegistroDoTempo registro = datas.getRegistros().stream()
            .filter(reg -> reg.getAno() == ano)
            .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
            .orElseThrow(IllegalArgumentException::new);
        return registro.getDia() + "/" + registro.getMes() + "/" + registro.getAno() + ", " + registro.getPrecipitacao();
    }

    public void alteraConsultaPadrao(Predicate<RegistroDoTempo> consulta) {
        this.condicao = consulta;
    }

    public List<Data> diasEmQue() {
        List<Data> result = new ArrayList<>();
        List<RegistroDoTempo> registros = datas.getRegistros();

        for (RegistroDoTempo registro : registros) {
            if (condicao.test(registro)) {
                result.add(new Data(registro.getDia(), registro.getMes(), registro.getAno()));
            }
        }

        return result;
    }
}