package handson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("employees.txt");
        Path copyPath = Paths.get("copy_employees.txt");

        try {
            // Deteksi jika file tidak ditemukan
            if (Files.notExists(sourcePath)) {
                System.out.println("File employees.txt tidak ditemukan! Membuat file contoh...");
                Files.write(sourcePath, Arrays.asList("101 - Budi Santoso", "102 - Siti Aminah", "103 - Andi Wijaya"), StandardCharsets.UTF_8);
            }

            // Simpan hasil baca ke ArrayList<String>
            ArrayList<String> employeeList = new ArrayList<>();
            try (BufferedReader br = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {
                String line;
                while ((line = br.readLine()) != null) {
                    employeeList.add(line);
                }
            }

            System.out.println("Isi ArrayList karyawan:");
            employeeList.forEach(System.out::println);

            // Tuliskan ke file baru copy_employees.txt
            Files.write(copyPath, employeeList, StandardCharsets.UTF_8);
            System.out.println("\nBerhasil menyalin data ke: " + copyPath.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan I/O: " + e.getMessage());
        }
    }
}