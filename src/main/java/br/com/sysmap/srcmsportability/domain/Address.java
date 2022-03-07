package br.com.sysmap.srcmsportability.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Address {

    @Id
    private UUID addressId;

    private String street;
    private String number;
    private String city;
    private String country;
    private String stateOrRegion;
}
