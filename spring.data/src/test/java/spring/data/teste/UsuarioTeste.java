package spring.data.teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spring.data.model.Usuario;
import spring.data.repository.UsuarioCustomRepository;
import spring.data.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTeste {

	// Injetando o usuario repository 
	@Autowired
	private UsuarioRepository interfaceUsuarioData;


	// Injetando o usuario repository customizado
	@Autowired
	private UsuarioCustomRepository usuarioCustomRepository;

	@Test
	public void testeInit() {
		System.out.println("Iniciou o spring");
	}

	// insere registros
	@Test
	public void testeInsert() {
		Usuario u1 = new Usuario();
		Usuario u2 = new Usuario();
		Usuario u3 = new Usuario();
		Usuario u4 = new Usuario();

		u1.setNome("Jessica Henrique Araujo da Silva");
		u1.setEmail("arthur.henrique25@hotmail.com");
		u1.setIdade(31);
		u1.setLogin("teste 123");
		u1.setSenha("123");

		u2.setNome("Joao Henrique Araujo da Silva");
		u2.setEmail("arthur.henrique25@hotmail.com");
		u2.setIdade(31);
		u2.setLogin("teste 123");
		u2.setSenha("123");

		u3.setNome("Maria Henrique Araujo da Silva");
		u3.setEmail("arthur.henrique25@hotmail.com");
		u3.setIdade(31);
		u3.setLogin("teste 123");
		u3.setSenha("123");

		u4.setNome("Jose Henrique Araujo da Silva");
		u4.setEmail("arthur.henrique25@hotmail.com");
		u4.setIdade(31);
		u4.setLogin("teste 123");
		u4.setSenha("123");

		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		usuarios.add(u4);

		// percorre a lista e salva todos
		for (Usuario u : usuarios) {
			// salva
			interfaceUsuarioData.save(u);
		}

		// Total de registros
		System.out.println("Total de registros: " + interfaceUsuarioData.count());
	}

	// busca por id
	@Test
	public void testeConsulta() {
		Usuario usuario = interfaceUsuarioData.findOne(3L);

		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Email: " + usuario.getEmail());
		System.out.println("Idade: " + usuario.getIdade());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
	}

	// lista todos
	@Test
	public void testeConsultaTodos() {
		Iterable<Usuario> lista = interfaceUsuarioData.findAll();

		// foreache
		for (Usuario usuario : lista) {
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("Idade: " + usuario.getIdade());
			System.out.println("Login: " + usuario.getLogin());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("---------------------------------------");
		}
	}

	// atualiza por id
	@Test
	public void testeUpdate() {
		Usuario usuario = interfaceUsuarioData.findOne(3L);

		// seta nome
		usuario.setNome("Francisca Rta melo da Silva");

		// atualiza dados
		interfaceUsuarioData.save(usuario);
	}

	// deleta por id
	@Test
	public void testeDelete() {
		Usuario usuario = interfaceUsuarioData.findOne(2L);
		interfaceUsuarioData.delete(usuario);
		// interfaceUsuarioData.delete(3L);
	}

	// busca por nome
	@Test
	public void testeConsultaNome() {
		List<Usuario> lista = interfaceUsuarioData.buscaPorNome("Thiago");

		// foreach
		for (Usuario usuario : lista) {
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("Idade: " + usuario.getIdade());
			System.out.println("Login: " + usuario.getLogin());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("---------------------------------------");
		}
	}

	// busca por Param
	@Test
	public void testeConsultaNomeParam() {
		Usuario usuario = interfaceUsuarioData.buscaPorNomeParam("Thiago Henrique Melo da Silva");

		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Email: " + usuario.getEmail());
		System.out.println("Idade: " + usuario.getIdade());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("---------------------------------------");
	}

	// deleta por nome
	@Test
	public void testeDeletaPorNome() {
		interfaceUsuarioData.deletePorNome("Thiago Henrique Melo da Silva");
	}

	// atualiza por nome
	@Test
	public void testeUpdatePorNome() {
		interfaceUsuarioData.updateEmailPorNome("marcia.henrique25@hotmail.com", "Arthur Henrique Araujo da Silva");
	}

	// consulta por nome
	@Test
	public void testeConsultaByName() {
		List<Usuario> lista = interfaceUsuarioData.findByNomeContains("Arthur");

		// foreach
		for (Usuario usuario : lista) {
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("Idade: " + usuario.getIdade());
			System.out.println("Login: " + usuario.getLogin());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("---------------------------------------");
		}
	}

	// busca por query dinamica customizada
	@Test
	public void listaPorQueryDinamica() {
		List<Usuario> lista = usuarioCustomRepository.busca(4L, "Maria Henrique Araujo da Silva",
				"arthur.henrique25@hotmail.com");
			System.out.println("Usuário: " + lista.toString());

	}

}
