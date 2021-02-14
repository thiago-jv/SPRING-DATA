package spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.data.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// busca por paramentro utiliznado o like
	@Query(value = "select u from Usuario u where u.nome like %?1%")
	public List<Usuario> buscaPorNome(String nome);
	
	// busca apenas por paramentro igual, retornando um objeto
	@Query(value = "select u from Usuario u where u.nome = :paramnome")
	public Usuario buscaPorNomeParam (@Param("paramnome") String paramnome);
	
	// deleta por nome
	@Modifying
	@Transactional
	@Query(value = "delete from Usuario u where u.nome = ?1")
	public void deletePorNome(String nome);
	
	// atualiza por nome
	@Modifying
	@Transactional
	@Query(value = "update Usuario u set u.email =?1 where u.nome = ?2")
	public void updateEmailPorNome(String email, String nome);
	
	// lista por nome que contem a string passada
	List<Usuario> findByNomeContains(String nome);
	
	
	
}
