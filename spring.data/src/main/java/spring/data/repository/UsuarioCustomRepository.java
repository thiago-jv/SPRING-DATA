package spring.data.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import spring.data.model.Usuario;

@Repository
public class UsuarioCustomRepository {

	// injetando o entityManager
	private final EntityManager em;

	// contrutor que recebe o entityManager
	public UsuarioCustomRepository(EntityManager em) {
		this.em = em;
	}

	// mostagem da query dinamica
	public List<Usuario> busca(Long id, String nome, String email) {
		String query = "select u from Usuario u ";
		String condicao = "where";

		if (id != null) {
			query += condicao + " u.id = :id";
			condicao = " and";
		}

		if (nome != null) {
			query += condicao + " u.nome = :nome";
			condicao = " and";
		}

		if (email != null) {
			query += condicao + " u.email = :email";
		}

		TypedQuery<Usuario> q = em.createQuery(query, Usuario.class);

		if (id != null) {
			q.setParameter("id", id);
		}

		if (nome != null) {
			q.setParameter("nome", nome);
		}

		if (email != null) {
			q.setParameter("email", email);
		}

		return q.getResultList();
	}

}
