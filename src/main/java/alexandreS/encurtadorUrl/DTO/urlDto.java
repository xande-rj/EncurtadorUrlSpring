package alexandreS.encurtadorUrl.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd[ ][']'T'[ ]HH:mm:ss[.SS]")
public class urlDto {

  private String longUrl;
  private LocalDateTime dataExpiracao;
}
