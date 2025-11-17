package alexandreS.encurtadorUrl.Controler;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alexandreS.encurtadorUrl.DTO.urlDto;
import alexandreS.encurtadorUrl.Service.serviceUrl;

@RestController
@RequestMapping("/shorten-url")
public class urlControler {

  private final serviceUrl ServiceUrl;

  public urlControler(serviceUrl serviceUrl) {
    this.ServiceUrl = serviceUrl;
  }

  @PostMapping
  public String urlConvertida(@RequestBody urlDto Dto) {
    return "localhost:8080/shorten-url/" + ServiceUrl.converterUrl(Dto);
  }

  @GetMapping("/{urlCurta}")

  public ResponseEntity<Void> pegarERedirecionar(@PathVariable String urlCurta) {

    String url = ServiceUrl.urlOriginal(urlCurta);

    return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
  }
}
