package tn.enis.bookstrore.util.converter;

import tn.enis.bookstrore.util.enumerations.PaymentMode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PaymentModeConverter implements AttributeConverter<PaymentMode, String> {

    @Override
    public String convertToDatabaseColumn(PaymentMode paymentMode) {
        return paymentMode.getShortName();
    }

    @Override
    public PaymentMode convertToEntityAttribute(String dbData) {
        return PaymentMode.fromShortName(dbData);
    }
}
