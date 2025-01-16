package br.com.alura.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.literalura.main.Main;
import br.com.alura.literalura.repository.AuthorRepository;
import br.com.alura.literalura.repository.BookRepository;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner{

	@Autowired()
	private BookRepository bookRepository;

	@Autowired()
	private AuthorRepository AuthorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

		@Override
	public void run(String... args) throws Exception {
		Main main = new Main(bookRepository,AuthorRepository);
		main.show_menu();
		
	}

}
