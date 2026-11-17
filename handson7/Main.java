package handson7;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");
        Path logFile = Paths.get("log.txt");

        try {
            // Membuat file report.txt (kompatibel Java 8)
            Files.write(source, Arrays.asList("Report Generated", "Status: OK"), StandardCharsets.UTF_8);

            // Pengecekan file sebelum menyalin
            if (Files.exists(source)) {
                if (Files.notExists(backup.getParent())) {
                    Files.createDirectories(backup.getParent());
                }
                Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);

                String logEntry = "[" + LocalDateTime.now() + "] SUKSES: File report.txt berhasil disalin ke backup/report.txt" + System.lineSeparator();
                Files.write(logFile, logEntry.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                System.out.println("Backup berhasil dan log telah dicatat di log.txt!");
            } else {
                String logError = "[" + LocalDateTime.now() + "] GAGAL: File sumber report.txt tidak ditemukan." + System.lineSeparator();
                Files.write(logFile, logError.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("File sumber tidak ditemukan.");
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}