import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomQueue purchaseQueue = new CustomQueue();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Main program loop
        do {
            System.out.println("\n--- Menu Antrian Pembelian ---");
            System.out.println("1. Tambah Barang ke Antrian");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Proses Barang Pertama");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan Anda: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan nama barang: ");
                        String item = scanner.nextLine();
                        purchaseQueue.enqueue(item); // Add item to the queue
                        break;
                    case 2:
                        System.out.println("Daftar Antrian Pembelian: " + purchaseQueue.toString()); // Display queue
                        break;
                    case 3:
                        String processedItem = purchaseQueue.dequeue(); // Process item from the queue
                        if (processedItem != null) {
                            System.out.println("Memproses: '" + processedItem + "'.");
                        } else {
                            System.out.println("Antrian kosong. Tidak ada barang untuk diproses.");
                        }
                        break;
                    case 0:
                        System.out.println("Keluar dari program.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka untuk pilihan menu.");
                scanner.nextLine(); // Consume invalid input
                choice = -1; // Keep loop running
            }

        } while (choice != 0);

        scanner.close();
    }
}
