package alexandreS.encurtadorUrl.Controler;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    return ServiceUrl.converterUrl(Dto);
  }

  @GetMapping("/{urlCurta}")
  public ResponseEntity<Void> pegarERedirecionar(@PathVariable String urlCurta) {

    String url = ServiceUrl.urlOriginal(urlCurta);

    return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
  }
}
