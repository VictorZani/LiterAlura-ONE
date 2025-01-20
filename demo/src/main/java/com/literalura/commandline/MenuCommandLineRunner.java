import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class MenuCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        // Exibe o menu para o usuário
        exibirMenu(scanner);
    }

    private void exibirMenu(Scanner scanner) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Buscar livro");
            System.out.println("2. Listar livros");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Implementar a busca de livro
                    break;
                case 2:
                    // Implementar a listagem de livros
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
