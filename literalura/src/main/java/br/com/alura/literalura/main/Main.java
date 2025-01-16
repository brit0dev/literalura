package br.com.alura.literalura.main;

import java.util.Scanner;



public class Main {
    private Scanner read = new Scanner(System.in);

    public void show_menu() {
        boolean loop = true;


        while (loop) {
            String menu = 
            """
            ----------- MENU -----------
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em um determinado ano
                5 - Listar livros em um determinado idioma

                0 - Sair
            """;
            System.out.println(menu);

            int option = read.nextInt();
            read.nextLine();

            System.out.println("----------- RESULTADO DA OPÇÃO -----------");

            switch (option) {
                case 1:
                    System.out.println("Case 1");          
                    break;
                case 2:
                    System.out.println("Case 2");          
                    break;
                case 3:
                    System.out.println("Case 3");          
                    break;
                case 4:
                    System.out.println("Case 4");          
                    break;
                case 5:
                    System.out.println("Case 5");          
                    break;
                case 0:
                    System.out.println("Exiting...");
                    loop = false;
                    break;
                default:
                System.out.println("Opção inválida.");
                    break;
            }
        }

    }
}
