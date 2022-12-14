package br.com.alura.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
	// Curso_Nome
	Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);

	@Query("SELECT t from Topico t where t.curso.nome = :nomeCurso")
	Page<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso, Pageable paginacao);

}
