import java.util.List;

public class App {
    public static void main(String[] args) {
        // Criar um repositório de dados climáticos
        Repositorio dataRepository = new Repositorio(".txt");
        dataRepository.carregaDados(); // Carregar os dados do arquivo

        // Criar uma instância de Consultas com o repositório
        Consultas consultas = new Consultas(dataRepository);

        // Realizar consultas e imprimir resultados
        List<String> datasChuvosas = consultas.datasEmQueChoveuMaisDe(20.0); // Exemplo de consulta
        System.out.println("Datas com precipitação acima de 20mm: " + datasChuvosas);

        String diaMaisChuvoso2023 = consultas.diaQueMaisChoveuNoAno(2023); // Exemplo de consulta
        System.out.println("Dia mais chuvoso em 2023: " + diaMaisChuvoso2023);

        // Alterar a condição padrão de consulta
        consultas.alteraConsultaPadrao(registro -> registro.getTempMaxima() > 30.0);

        List<String> datasQuentes = consultas.datasEmQue(); // Consulta com nova condição
        System.out.println("Datas com temperaturas máximas acima de 30°C: " + datasQuentes);
    }
}

