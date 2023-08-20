import java.util.List;

public class App {
    public static void main(String[] args) {
        // Criar um repositório de dados climáticos
        Repositorio dataRepositorio = new Repositorio("poa_temps.txt");
        dataRepositorio.carregaDados(); // Carregar os dados do arquivo

        // Criar uma instância de Consultas com o repositório
        Consultas consultas = new Consultas(dataRepositorio);

        // Realizar consultas e imprimir resultados
        List<String> datasChuvosas = consultas.datasEmQueChoveuMaisDe(90.0); // Exemplo de consulta
        System.out.println("Datas com precipitação acima de 20mm: " + datasChuvosas);

        System.out.println("\n==============================\n");

        String diaMaisChuvoso = consultas.diaQueMaisChoveuNoAno(2016); // Exemplo de consulta
        System.out.println("Dia mais chuvoso em 2026: " + diaMaisChuvoso);

        System.out.println("\n==============================\n");

        // Alterar a condição padrão de consulta
        consultas.alteraConsultaPadrao(registro -> registro.getTempMaxima() > 39.0);

        List<Data> datasQuentes = consultas.diasEmQue(); // Consulta com nova condição
        System.out.println("Datas com temperaturas máximas acima de 39°C: " + datasQuentes);
    }
}

