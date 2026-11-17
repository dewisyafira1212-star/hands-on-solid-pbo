package handson10;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

// Generic Class fleksibel untuk berbagai entitas (Produk, Pelanggan, dll.)
class DataEntity<T, U, V> {
    private T field1;
    private U field2;
    private V field3;

    public DataEntity(T field1, U field2, V field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return field1 + " | " + field2 + " | " + field3;
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. Penggunaan untuk Produk (Nama, Harga, Stok Integer)
        List<DataEntity<String, Double, Integer>> produkList = new ArrayList<>();
        produkList.add(new DataEntity<>("Laptop", 15000000.0, 5));
        produkList.add(new DataEntity<>("Mouse", 150000.0, 20));
        produkList.add(new DataEntity<>("Keyboard", 350000.0, 12));

        Path produkPath = Paths.get("produk_output.txt");

        // 2. Penggunaan untuk entitas lain: Pelanggan (ID, Nama, Kota)
        List<DataEntity<Integer, String, String>> pelangganList = new ArrayList<>();
        pelangganList.add(new DataEntity<>(1, "Andi Pratama", "Makassar"));
        pelangganList.add(new DataEntity<>(2, "Siti Rahma", "Gowa"));

        Path pelangganPath = Paths.get("pelanggan_output.txt");

        try {
            // Simpan dan baca kembali data Produk
            List<String> produkLines = new ArrayList<>();
            for (DataEntity<String, Double, Integer> p : produkList) {
                produkLines.add(p.toString());
            }
            Files.write(produkPath, produkLines);

            System.out.println("=== Isi File produk_output.txt ===");
            List<String> readProduk = Files.readAllLines(produkPath);
            readProduk.forEach(System.out::println);

            // Simpan dan baca kembali data Pelanggan
            List<String> pelangganLines = new ArrayList<>();
            for (DataEntity<Integer, String, String> c : pelangganList) {
                pelangganLines.add(c.toString());
            }
            Files.write(pelangganPath, pelangganLines);

            System.out.println("\n=== Isi File pelanggan_output.txt ===");
            List<String> readPelanggan = Files.readAllLines(pelangganPath);
            readPelanggan.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Gagal memproses file: " + e.getMessage());
        }
    }
}