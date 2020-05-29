package tn.enis.bookstrore.util.constants;

public class ConstantsValue {
    public static final double VAT=0.2; //VAT = value-added tax
    public static final String LOWER_CHAR = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPER_CHAR = LOWER_CHAR.toUpperCase();
    public static final String NUMBER = "0123456789";
    public static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";
    public static final String PASSWORD_BASE = LOWER_CHAR + UPPER_CHAR + NUMBER + OTHER_CHAR;
    public static final int PASSWORD_LENGTH = 8;
    public static final String RESET_PASSWORD_SUBJECT = "Nouveau mot de passe";
}
