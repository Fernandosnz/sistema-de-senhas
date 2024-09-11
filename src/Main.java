import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Fila fila = new Fila(10); // capacidade de 10 senhas
        Scanner ler = new Scanner(System.in);
        int comumCount = 0, prioridadeCount = 0;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Solicitar nova senha (Comum)");
            System.out.println("2. Solicitar nova senha (Prioridade)");
            System.out.println("3. Excluir uma senha");
            System.out.println("4. Listar todas as senhas");
            System.out.println("5. Próximo a ser atendido");
            System.out.println("6. Chamar próximo a ser atendido");
            System.out.println("0. Sair");
            int opcao = ler.nextInt();

            if (opcao == 1) {
                System.out.print("Informe a senha comum: ");
                String senhaComum = ler.next();
                fila.adicionarSenhaComum(senhaComum);
                comumCount++;

            } else if (opcao == 2) {
                System.out.print("Informe a senha prioritária: ");
                String senhaPrioridade = ler.next();
                fila.adicionarSenhaPrioridade(senhaPrioridade);
                prioridadeCount++;

            } else if (opcao == 3) {
                System.out.print("Excluir senha comum ou prioritária? (1 - Comum, 2 - Prioridade): ");
                int tipo = ler.nextInt();
                if (tipo == 1) {
                    fila.removerSenhaComum();
                } else if (tipo == 2) {
                    fila.removerSenhaPrioridade();
                }

            } else if (opcao == 4) {
                fila.listarSenhas();

            } else if (opcao == 5) {
                System.out.println(fila.proximoAtendimento());

            } else if (opcao == 6) {

                if (prioridadeCount >= 3 && comumCount > 0) {
                    System.out.println(fila.removerSenhaComum());
                    prioridadeCount = 0;
                } else if (prioridadeCount < 3 && fila.removerSenhaPrioridade() != null) {
                    System.out.println(fila.removerSenhaPrioridade());
                    prioridadeCount++;
                } else if (comumCount > 0) {
                    System.out.println(fila.removerSenhaComum());
                } else {
                    System.out.println("Não há senhas para atendimento.");
                }

            } else if (opcao == 0) {
                System.out.println("Saindo do sistema...");
                break;

            } else {
                System.out.println("Opção inválida.");
            }
        }

    }
}
