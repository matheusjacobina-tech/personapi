package bootcamp.personapi.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CargoConverter implements AttributeConverter<CargoType, String> {
    @Override
    public String convertToDatabaseColumn(CargoType cargoEnum) {
        return cargoEnum.getDescricao();
    }
    @Override
    public CargoType convertToEntityAttribute(String dbData) {
        System.out.println(dbData);
        return CargoType.getEnum(dbData);
    }
}