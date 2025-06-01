import java.util.Scanner;

// Kelas ini merepresentasikan sistem antrian pembelian
public class PurchaseQueue {
    // Variabel untuk menyimpan antrian barang menggunakan implementasi kustom
    private CustomQueue queue;

    // Konstruktor kelas
    public PurchaseQueue() {
        // Membuat objek CustomQueue baru untuk antrian
        this.queue = new CustomQueue();
    }

    // Method untuk menambahkan barang ke antrian
    public void addItem(String item) {
        queue.enqueue(item); // Menggunakan method enqueue dari CustomQueue
        System.out.println("'" + item + "' telah ditambahkan ke antrian.");
    }

    // Method untuk memproses (mengeluarkan) barang dari antrian
    public void processItem() {
        if (queue.isEmpty()) { // Menggunakan method isEmpty dari CustomQueue
            System.out.println("Antrian kosong. Tidak ada barang untuk diproses.");
        } else {
            // Mengambil dan menghapus barang paling depan menggunakan dequeue
            String processedItem = queue.dequeue();
            System.out.println("Memproses: '" + processedItem + "'.");
        }
    }

    // Method untuk menampilkan semua barang di antrian
    public void displayQueue() {
        if (queue.isEmpty()) { // Menggunakan method isEmpty dari CustomQueue
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Daftar Antrian Pembelian:");
            // Menggunakan method toString dari CustomQueue untuk menampilkan isi
            // Perhatian: Implementasi toString di CustomQueue menampilkan dalam format list,
            // jika ingin format bernomor seperti sebelumnya, perlu iterasi manual atau modifikasi toString.
            // Untuk kesederhanaan, kita gunakan toString CustomQueue.
            System.out.println(queue.toString());

            // Jika ingin format bernomor seperti sebelumnya, ganti baris di atas dengan kode ini:
            /*
            Node current = queue.head; // Akses head dari CustomQueue (jika diizinkan, atau tambahkan method getter)
            int index = 1;
            while (current != null) {
                System.out.println(index + ". " + current.item);
                index++;
                current = current.next;
            }
            */
        }
    }

    // Method untuk mengecek apakah antrian kosong
    public boolean isEmpty() {
        return queue.isEmpty(); // Menggunakan method isEmpty dari CustomQueue
    }

    // Method main untuk menjalankan contoh penggunaan
    public static void main(String[] args) {
        PurchaseQueue pq = new PurchaseQueue();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Menu Antrian Pembelian ---");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Proses Barang");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan nama barang: ");
                        String item = scanner.nextLine();
                        pq.addItem(item);
                        break;
                    case 2:
                        pq.processItem();
                        break;
                    case 3:
                        pq.displayQueue();
                        break;
                    case 4:
                        System.out.println("Keluar dari program.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.nextLine(); // Konsumsi input yang salah
                choice = 0; // Set choice ke nilai yang tidak valid untuk melanjutkan loop
            }

        } while (choice != 4);

        scanner.close();
    }
}
