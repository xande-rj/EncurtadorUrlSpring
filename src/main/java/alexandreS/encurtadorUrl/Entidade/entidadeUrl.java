package alexandreS.encurtadorUrl.Entidade;

import java.util.Date;

import lombok.*;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_Url")
public class entidadeUrl {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(nullable = false)
  private String urlLonga;
  @Column(nullable = false)
  private Date dataCriacao;
  @Column(nullable = false)
  private Date dataExpiracao;

}
