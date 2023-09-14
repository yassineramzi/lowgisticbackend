package com.lowgistic.mission.domain;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "country")
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String currency;

    private String emoji;

    private String iso3;

    private String iso2;

    private Integer numericCode;

    private String phoneCode;

    private String capital;

    private String currencyName;

    private String currencySymbol;

}
