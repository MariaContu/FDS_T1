import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Repository{
    // Classe para amrazenamento de dados

    private String nArq;
    private ArrayList<RegistroDoTempo> dados;
    public Repository(String nArq){
        this.nArq = nArq;
        dados = new ArrayList<>();
        carregaDados();
        
    }

    public void carregaDados(){
        String currDir = Paths.get("").toAbsolutePath().toString();
        // Monta o nome do arquivo
        String nomeCompleto = currDir+"/"+nArq;
        System.out.println(nomeCompleto);
        // Cria acesso ao "diretorio" da mídia (disco)
        Path path = Paths.get(nomeCompleto);

        String linha = "";
         // Usa a classe scanner para fazer a leitura do arquivo
         try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
            // Pula o cabecalho
            sc.nextLine();
            // Le os dados
            while(sc.hasNext()){
                linha = sc.nextLine();
                String dados[] = linha.split(" ");
                // Trata a data
                String data[] = dados[0].split("/");
                int dia = Integer.parseInt(data[0]);
                int mes = Integer.parseInt(data[1]);
                int ano = Integer.parseInt(data[2]);
                // Trata demais dados
                double precipitacao = Double.parseDouble(dados[1]);
                double tempMaxima = Double.parseDouble(dados[2]);
                double tempMinima = Double.parseDouble(dados[3]);
                double horasInsolacao = Double.parseDouble(dados[4]);
                double temperaturaMedia = Double.parseDouble(dados[5]);
                double umidadeRelativaDoAr = Double.parseDouble(dados[6]);
                double velocidadeDoVento = Double.parseDouble(dados[7]);
                // Cria um registro e insere na lista
                RegistroDoTempo reg = new RegistroDoTempo(dia, mes, ano, precipitacao, tempMaxima, tempMinima, horasInsolacao, temperaturaMedia, umidadeRelativaDoAr, velocidadeDoVento);
                cadastraRegistro(reg);
            }
         }catch (IOException x){
             System.err.format("Erro de E/S: %s%n", x);
         }
    }
    
    public RegistroDoTempo recupera(int dia, int mes, int ano){
        return dados.stream()
                    .filter(r -> r.getDia() == dia && r.getMes() == mes && r.getAno() == ano)
                    .collect(Collectors.toList())
                    .get(0);
    }

    public boolean existente(int dia, int mes, int ano){
        for(RegistroDoTempo r : dados){
            if(r.getDia() == dia && r.getMes() == mes && r.getAno() == ano){
                return true;
            }
        }
        return false;
    }

    public void cadastraRegistro(RegistroDoTempo regTemp){
        dados.add(regTemp);
    }

    public void atualiza(RegistroDoTempo regTemp){
        dados.add(regTemp);
    }

    public Collection<RegistroDoTempo> getTodos(){
        return dados;
    }

    
}