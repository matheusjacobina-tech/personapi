package bootcamp.personapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import bootcamp.personapi.enums.CargoConverter;
import bootcamp.personapi.enums.CargoType;

import javax.persistence.Convert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Convert(converter = CargoConverter.class)
    @Column(nullable = false)
    private CargoType nome;
}