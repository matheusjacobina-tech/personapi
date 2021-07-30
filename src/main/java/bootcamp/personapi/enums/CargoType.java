package bootcamp.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CargoType {

    ADMIN("Administrador"),
    GERENTE("Gerente"),
    CAIXA("Caixa"),
    ESTOQUISTA("Estoquista"),
    ATENDENTE("Atendente");

    private final String descricao;
    
    public static CargoType getEnum(String descricao) {
        for(CargoType type : CargoType.values()){
            if(type.getDescricao().equals(descricao))
               return type;
        }
        return null;
    }
}
