package tn.enis.bookstrore.util.converter;

import tn.enis.bookstrore.util.enumerations.DeliveryMethod;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DeliveryMethodConverter implements AttributeConverter<DeliveryMethod,String> {
    @Override
    public String convertToDatabaseColumn(DeliveryMethod deliveryMethod) {
        return deliveryMethod.getShortName();
    }

    @Override
    public DeliveryMethod convertToEntityAttribute(String dbData) {
        return DeliveryMethod.fromShortName(dbData);
    }
}
