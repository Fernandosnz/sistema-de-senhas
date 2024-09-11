public class Fila {
    private String[] filaComum;
    private String[] filaPrioridade;
    private int capacidade;
    private int inicioComum;
    private int fimComum;
    private int inicioPrioridade;
    private int fimPrioridade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.filaComum = new String[capacidade];
        this.filaPrioridade = new String[capacidade];
        this.inicioComum = 0;
        this.fimComum = 0;
        this.inicioPrioridade = 0;
        this.fimPrioridade = 0;
    }


    public void adicionarSenhaComum(String senha) {
        if (fimComum < capacidade) {
            filaComum[fimComum] = senha;
            fimComum++;
        } else {
            System.out.println("Fila de senhas comuns está cheia.");
        }
    }

    
    public void adicionarSenhaPrioridade(String senha) {
        if (fimPrioridade < capacidade) {
            filaPrioridade[fimPrioridade] = senha;
            fimPrioridade++;
        } else {
            System.out.println("Fila de senhas prioritárias está cheia.");
        }
    }

    
    public String removerSenhaComum() {
        if (inicioComum < fimComum) {
            String senha = filaComum[inicioComum];
            inicioComum++;
            return senha;
        } else {
            return "Fila de senhas comuns está vazia."; 
    }

    
    public String removerSenhaPrioridade() {
        if (inicioPrioridade < fimPrioridade) {
            String senha = filaPrioridade[inicioPrioridade];
            inicioPrioridade++;
            return senha;
        } else {
            return "Fila de senhas prioritárias está vazia."; 
        }
    }

    
    public void listarSenhas() {
        System.out.println("Senhas Comuns:");
        for (int i = inicioComum; i < fimComum; i++) {
            System.out.println(filaComum[i]);
        }
        System.out.println("Senhas Prioritárias:");
        for (int i = inicioPrioridade; i < fimPrioridade; i++) {
            System.out.println(filaPrioridade[i]);
        }
    }

   
    public String proximoAtendimento() {
        if (inicioPrioridade < fimPrioridade) {
            return "Próxima senha prioritária: " + filaPrioridade[inicioPrioridade];
        } else if (inicioComum < fimComum) {
            return "Próxima senha comum: " + filaComum[inicioComum];
        } else {
            return "Não há senhas para atendimento.";
        }
    }
}
