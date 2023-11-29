import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Participante {
    String nome;
    String telefone;
    String endereco;
    String cpf;

    public Participante(String nome, String telefone, String endereco, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }
}

public class Josephus {

    public static Participante josephus(List<Participante> participantes, int m) {
        // Inicializa o índice do próximo a ser eliminado
        int indice = 0;

        while (participantes.size() > 1) {
            // Calcula o próximo índice a ser eliminado
            indice = (indice + m - 1) % participantes.size();

            // Remove o participante na posição do índice calculado
            participantes.remove(indice);
        }

        // Retorna o último participante que permaneceu no círculo
        return participantes.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Participante> participantes = new ArrayList<>();

        // Criar 20 participantes pré-programados
        participantes.add(new Participante("Alice", "11 9876-5432", "Rua A", "111.222.333-44"));
        participantes.add(new Participante("Bob", "22 8765-4321", "Rua B", "222.333.444-55"));
        participantes.add(new Participante("Carlos", "33 7654-3210", "Rua C", "333.444.555-66"));
        participantes.add(new Participante("Denise", "44 6543-2109", "Rua D", "444.555.666-77"));
        participantes.add(new Participante("Eric", "55 5432-1098", "Rua E", "555.666.777-88"));
        participantes.add(new Participante("Fernanda", "66 4321-0987", "Rua F", "666.777.888-99"));
        participantes.add(new Participante("Guilherme", "77 3210-9876", "Rua G", "777.888.999-00"));
        participantes.add(new Participante("Helena", "88 2109-8765", "Rua H", "888.999.000-11"));
        participantes.add(new Participante("Ivan", "99 1098-7654", "Rua I", "999.000.111-22"));
        participantes.add(new Participante("Juliana", "10 0987-6543", "Rua J", "000.111.222-33"));
        participantes.add(new Participante("Klaus", "11 9876-5432", "Rua K", "111.222.333-44"));
        participantes.add(new Participante("Larissa", "12 8765-4321", "Rua L", "222.999.555-33"));
        participantes.add(new Participante("Marcos", "13 7654-3210", "Rua M", "333.444.555-66"));
        participantes.add(new Participante("Natasha", "14 6543-2109", "Rua N", "444.555.666-77"));
        participantes.add(new Participante("Oscar", "15 5432-1098", "Rua O", "555.666.777-88"));
        participantes.add(new Participante("Patrícia", "16 4321-0987", "Rua P", "666.777.888-99"));
        participantes.add(new Participante("Rafael", "17 3210-9876", "Rua Q", "777.888.999-00"));
        participantes.add(new Participante("Sandra", "18 2109-8765", "Rua R", "888.999.000-11"));
        participantes.add(new Participante("Thales", "64 9347-5239", "Rua S", "999.000.111.22"));
        participantes.add(new Participante("Joao", "64 2579-3156", "Rua T", "010.002.003-35"));
        // Adicione mais participantes conforme necessário...

        // Solicitar ao usuário o número de passos de contagem
        System.out.print("Insira o número de passos de contagem (m): ");
        int m = scanner.nextInt();

        // Garantir que há pelo menos um participante antes de prosseguir
        if (participantes.size() < 1) {
            System.out.println("Não há participantes suficientes.");
            return;
        }

        Participante resultado = josephus(participantes, m);

        System.out.println("Informações do último participante remanescente:");
        System.out.println("Nome: " + resultado.nome);
        System.out.println("Telefone: " + resultado.telefone);
        System.out.println("Endereço: " + resultado.endereco);
        System.out.println("CPF: " + resultado.cpf);

        // Fechar o scanner para evitar vazamento de recursos
        scanner.close();
    }
}
