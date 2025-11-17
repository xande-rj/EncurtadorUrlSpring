package alexandreS.encurtadorUrl.Service;

import java.util.Date;

import org.springframework.stereotype.Service;

import alexandreS.encurtadorUrl.DTO.urlDto;
import alexandreS.encurtadorUrl.Entidade.entidadeUrl;
import alexandreS.encurtadorUrl.Repositorio.repositorioUrl;
import jakarta.persistence.EntityNotFoundException;

@Service
public class serviceUrl {

  private final repositorioUrl repositoriourl;
  private final Conversor conversor;

  public serviceUrl(repositorioUrl repositorioUrl, Conversor conversor) {
    this.repositoriourl = repositorioUrl;
    this.conversor = conversor;

  }

  public String converterUrl(urlDto Dto) {
    entidadeUrl url = new entidadeUrl();

    url.setUrlLonga(Dto.getLongUrl());
    url.setDataExpiracao(Dto.getDataExpiracao());
    url.setDataCriacao(new Date());

    return conversor.criptografa(repositoriourl.save(url).getId());
  }

  public String urlOriginal(String urlCurta) {

    long id = conversor.decriptografia(urlCurta);
    entidadeUrl entidade = repositoriourl.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Sem entidade dessa url:" + urlCurta));

    if (entidade.getDataExpiracao() != null && entidade.getDataExpiracao().before(new Date())) {
      repositoriourl.delete(entidade);
      throw new EntityNotFoundException("url expirado");
    }
    return entidade.getUrlLonga();
  }
}
