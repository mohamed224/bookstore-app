package tn.enis.bookstrore.util.enumerations;

public enum DeliveryMethod {

    EXPRESS("E"), RELAY("R");
    private String shortName;

    DeliveryMethod(String shortName) {
        this.shortName = shortName;
    }

    public static DeliveryMethod fromShortName(String shortName) {
        switch (shortName) {
            case "E":
                return DeliveryMethod.EXPRESS;
            case "R":
                return DeliveryMethod.RELAY;
            default:
                throw new IllegalArgumentException("ShortName [" + shortName + "] not supported");
        }
    }

    public String getShortName() {
        return this.shortName;
    }
}
