package ecodoar;

import java.util.Scanner;

// REQ-016: Validação de beneficiários
// REQ-017: Histórico
// REQ-018: Logs de auditoria
// UC: Validação de beneficiário

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ValidationService service = new ValidationService();

        int option;

        do {
            System.out.println("\n1 - Validar beneficiário");
            System.out.println("2 - Ver histórico");
            System.out.println("3 - Ver logs");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            option = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (option) {

                case 1:
                    System.out.print("ID do beneficiário: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do beneficiário: ");
                    String name = scanner.nextLine();
                    Beneficiary beneficiary = new Beneficiary(id, name);
                    service.createBeneficiary(beneficiary);
                    boolean result = service.validateBeneficiaryById(id);

                    if (result) {
                        System.out.println("Beneficiário validado.");
                    } else {
                        System.out.println("Erro: beneficiário inválido.");
                    }
                    break;
                case 2:
                    service.showHistory();
                    break;

                case 3:
                    service.showLogs();
                    break;

                case 0:
                    System.out.println("Encerrar.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (option != 0);

        scanner.close();
    }
}
