package bootcamp.personapi.dto.mapper;

import bootcamp.personapi.dto.request.PersonDTO;
import bootcamp.personapi.entities.Cargo;
import bootcamp.personapi.entities.Person;
import bootcamp.personapi.enums.CargoType;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ValueMapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {


    @Mappings({
        @Mapping(source = "cargo", target = "cargo")
    })
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);
    
    @ValueMapping(target = "cargo", source = "cargo")
    PersonDTO toDTO(Person dto);

    
    default String toCargoString(Cargo cargo) {
        System.out.println("\n\n\n toString str:cargo: "+cargo.getNome().getDescricao()+" | "+"enum:cargo: "+cargo.toString()+"\n\n\n");
        return cargo.getNome().toString();
    }
    
    default public Cargo toCargoModel(String cargo){                
        CargoType cargoEnum = CargoType.getEnum(cargo);
        System.out.println("\n\n\n toModel enum:cargo: "+cargoEnum+" | "+"str:cargo: "+cargo+"\n\n\n");
        Long id;
        if (cargoEnum == null) {
            return new Cargo(5L, CargoType.ATENDENTE);
        }
        switch (cargoEnum) {
            case ADMIN: id = 1L;
            break;
            case GERENTE: id = 2L;
            break;
            case CAIXA: id = 3L;
            break;
            case ESTOQUISTA: id = 4L;
            break;
            case ATENDENTE: id = 5L;
            break;
            default: id = 5L;
        }
        System.out.println(new Cargo(id, cargoEnum));
        return new Cargo(id, cargoEnum);
    }
}
