package handson4;

class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() { return first; }
    public T2 getSecond() { return second; }

    public void showTypes() {
        System.out.println("Tipe: " + first.getClass().getSimpleName() + " & " + second.getClass().getSimpleName()
                + " -> Nilai: (" + first + ", " + second + ")");
    }

    public Pair<T2, T1> swap() {
        return new Pair<>(second, first);
    }
}

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "Andi");
        pair1.showTypes();
        Pair<String, Integer> swapped1 = pair1.swap();
        System.out.print("Setelah swap -> ");
        swapped1.showTypes();

        System.out.println();

        Pair<Double, Boolean> pair2 = new Pair<>(95.5, true);
        pair2.showTypes();
        Pair<Boolean, Double> swapped2 = pair2.swap();
        System.out.print("Setelah swap -> ");
        swapped2.showTypes();
    }
}