package handson2;

enum AccountType {
    SAVINGS("SA", 2.5),
    CREDIT("CR", 12.0),
    DEPOSIT("DP", 5.0);

    private final String code;
    private final double interestRate;

    private AccountType(String code, double interestRate) {
        this.code = code;
        this.interestRate = interestRate;
    }

    public String getCode() {
        return code;
    }

    public double getInterestRate() {
        return interestRate;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Detail Tipe Akun Bank ===");
        for (AccountType type : AccountType.values()) {
            System.out.printf("Nama: %-8s | Kode: %s | Suku Bunga: %.1f%%%n",
                    type.name(), type.getCode(), type.getInterestRate());
        }
    }
}