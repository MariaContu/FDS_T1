public class App {
    public static void main(String[] args) {       
        Repository repositorio = new Repository("poa_temps.txt");
        Consultas consultas = new Consultas(repositorio);
        
        System.out.println("Dia em que mais choveu no ano de 1980: ");
        System.out.println(consultas.diaQueMaisChoveuNoAno(1980));
        System.out.println("Datas em que choveu mais de 90 milimetros");
        consultas.datasEmQueChouveuMaisDe(90)
            .forEach(System.out::println);

        System.out.println("Consulta de Temperatura maxima\n");
        System.out.println(consultas.diasEmQue());
        System.out.println();
        
        consultas.alteraConsultaPadrao(r -> r.getPrecipitacao() > 25);

        System.out.println("Consulta de Precipatacao\n");
        System.out.println(consultas.diasEmQue());

    }
}
