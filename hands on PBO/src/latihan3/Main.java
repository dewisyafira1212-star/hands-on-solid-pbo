package latihan3;

// Abstraksi dasar semua kendaraan
interface Vehicle {
    void move();
}

// Interface kecil dan spesifik (ISP)
interface EnginePowered {
    void startEngine();
}

interface FuelRefillable {
    void isiBahanBakar();
}

interface Rechargeable {
    void isiBaterai();
}

// Implementasi kelas konkret sesuai fitur masing-masing (OCP)
class MobilListrik implements Vehicle, EnginePowered, Rechargeable {
    @Override
    public void startEngine() {
        System.out.println("Menyalakan motor listrik...");
    }

    @Override
    public void isiBaterai() {
        System.out.println("Mengisi baterai mobil listrik...");
    }

    @Override
    public void move() {
        System.out.println("Mobil listrik melaju.");
    }
}

class MobilBensin implements Vehicle, EnginePowered, FuelRefillable {
    @Override
    public void startEngine() {
        System.out.println("Menyalakan mesin bensin...");
    }

    @Override
    public void isiBahanBakar() {
        System.out.println("Mengisi bensin di SPBU...");
    }

    @Override
    public void move() {
        System.out.println("Mobil bensin melaju.");
    }
}

class Sepeda implements Vehicle {
    @Override
    public void move() {
        System.out.println("Sepeda dikayuh di jalur sepeda.");
    }
}

public class Main {
    public static void main(String[] args) {
        MobilListrik mobilListrik = new MobilListrik();
        mobilListrik.startEngine();
        mobilListrik.isiBaterai();
        mobilListrik.move();

        System.out.println();

        MobilBensin mobilBensin = new MobilBensin();
        mobilBensin.startEngine();
        mobilBensin.isiBahanBakar();
        mobilBensin.move();

        System.out.println();

        Sepeda sepeda = new Sepeda();
        sepeda.move();
    }
}