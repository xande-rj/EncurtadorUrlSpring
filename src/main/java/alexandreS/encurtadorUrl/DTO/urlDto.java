package alexandreS.encurtadorUrl.DTO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class urlDto {

  private String longUrl;
  private Date dataExpiracao;
}
