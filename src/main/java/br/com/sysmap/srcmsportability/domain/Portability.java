package br.com.sysmap.srcmsportability.domain;

import br.com.sysmap.srcmsportability.domain.enums.TelephoneCompany;
import br.com.sysmap.srcmsportability.domain.enums.PortabilityStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_portability")
public class Portability implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID portabilityId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TelephoneCompany source;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TelephoneCompany target;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    private PortabilityStatus portabilityStatus;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;
}
