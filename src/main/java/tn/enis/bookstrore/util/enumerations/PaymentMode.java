package tn.enis.bookstrore.util.enumerations;

public enum PaymentMode {

    CHECK("CH"), BANKCARD("BC"), CASH("CS");
    private String shortName;

    PaymentMode(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return this.shortName;
    }

    public static PaymentMode fromShortName(String shortName) {
        switch (shortName) {
            case "CH":
                return PaymentMode.CHECK;
            case "BC":
                return PaymentMode.BANKCARD;
            case "CS":
                return PaymentMode.CASH;
            default:
                throw new IllegalArgumentException("ShortName [" + shortName + "] not supported");
        }
    }
}
