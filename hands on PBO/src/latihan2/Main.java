package latihan2;

// Tanggung jawab 1: Menghitung nilai (SRP)
class GradeCalculator {
    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
        return (tugas * 0.3) + (uts * 0.3) + (uas * 0.4);
    }
}

// Tanggung jawab 2: Mencetak laporan (SRP)
class ReportPrinter {
    public void cetakLaporan(String nama, double nilai) {
        System.out.println("Laporan Nilai Mahasiswa: " + nama + " = " + nilai);
    }
}

// Tanggung jawab 3: Menyimpan ke database (SRP)
class GradeRepository {
    public void simpanDatabase(String nama, double nilai) {
        System.out.println("Menyimpan ke database: " + nama + " = " + nilai);
    }
}

public class Main {
    public static void main(String[] args) {
        GradeCalculator calculator = new GradeCalculator();
        ReportPrinter printer = new ReportPrinter();
        GradeRepository repository = new GradeRepository();

        double nilai = calculator.hitungNilaiAkhir(90, 100, 99);
        printer.cetakLaporan("Andi", nilai);
        repository.simpanDatabase("Andi", nilai);
    }
}