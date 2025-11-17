package alexandreS.encurtadorUrl.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alexandreS.encurtadorUrl.Entidade.entidadeUrl;

@Repository
public interface repositorioUrl extends JpaRepository<entidadeUrl, Long> {

}
