package Domain;

import java.util.Scanner;
import Domain.Gerenciamento.SistemaDeGerenciamento;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaDeGerenciamento sistema = new SistemaDeGerenciamento(scanner);
        sistema.iniciar();
        scanner.close();
    }
}