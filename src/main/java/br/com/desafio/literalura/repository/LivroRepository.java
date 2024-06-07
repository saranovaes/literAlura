package br.com.desafio.literalura.repository;

import br.com.desafio.literalura.model.Language;
import br.com.desafio.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro findByTitle(String title);

    @Query("SELECT b FROM Livro b WHERE %:language% MEMBER OF b.languages")
    List<Livro> findBooksByLanguage(@Param("language") Language language);
}
