package org.colendi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.colendi.domain.valueobject.CreditStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credits", indexes = {
  @Index(name = "idx_user_id", columnList = "user_id")
})
@Entity
public class CreditEntity extends BaseDataEntity{

  @Id
  private UUID creditId;

  @Enumerated(EnumType.STRING)
  private CreditStatus status;

  private Integer installmentsCount;

  private BigDecimal amount;

  private UUID userId;
}
