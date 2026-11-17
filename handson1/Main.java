package handson1;

enum AccountType {
    SAVINGS("Tabungan Reguler"),
    CREDIT("Kartu / Fasilitas Kredit"),
    DEPOSIT("Deposito Berjangka");

    private final String description;

    AccountType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name() + " - " + description;
    }
}

class Account {
    private AccountType type;

    public Account(AccountType type) {
        this.type = type;
    }

    public AccountType getType() {
        return type;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Daftar Semua Tipe Akun ===");
        for (AccountType type : AccountType.values()) {
            System.out.println(type.toString());
        }

        Account acc = new Account(AccountType.DEPOSIT);
        System.out.println("\nAkun baru dibuat: " + acc.getType());
    }
}