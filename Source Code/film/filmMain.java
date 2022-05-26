import java.util.Scanner;

public class filmMain {
    public static void menu() {
        System.out.println("DATA FILM LAYAR LEBAR ");
        System.out.println("=====================================");
        System.out.println("1. Tambah Data Awal");
        System.out.println("2. Tambah Data Akhir");
        System.out.println("3. Tambah Data Index tertentu");
        System.out.println("4. Hapus Data Pertama");
        System.out.println("5. Hapus Data Terakhir");
        System.out.println("6. Hapus Data Tertentu");
        System.out.println("7. Cetak");
        System.out.println("8. Cari ID Film ");
        System.out.println("9. Urut Data Rating Film-DESC");
        System.out.println("10. Keluar");
        System.out.println("");
        
    }

    public static void main(String[] args) throws Exception {
        filmService dll = new filmService();
        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        int pilihan = 0;
        int id;
        String judul;
        double rating;
        int pos;

        while (pilihan != 10) {
            menu();
            System.out.print("Pilih Menu : ");
            pilihan = sc.nextInt();
            System.out.println("=====================================");
            
            switch(pilihan) {
                case 1: 
                    System.out.println("Masukkan Data Film Posisi Awal");
                    System.out.println("Masukkan ID Film : ");
                    id = sc.nextInt();
                    System.out.println("Masukkan Judul Film : ");
                    judul = scn.nextLine();
                    System.out.println("Masukkan Rating Film : ");
                    rating = scan.nextDouble();
                    System.out.println("");
                    dll.addFirst(new film(id, judul, rating));
                    break;
                    
                case 2: 
                    System.out.println("Masukkan Data Film Posisi Akhir");
                    System.out.println("Masukkan ID Film : ");
                    id = sc.nextInt();
                    System.out.println("Masukkan Judul Film : ");
                    judul = scn.nextLine();
                    System.out.println("Masukkan Rating Film : ");
                    rating = scan.nextDouble();
                    System.out.println("");
                    dll.addLast(new film(id, judul, rating));
                    break;
                    
                case 3: 
                    System.out.println("Masukkan Data Film");
                    System.out.print("Urutan ke-");
                    pos = sc.nextInt();
                    System.out.println("Masukkan ID Film : ");
                    id = sc.nextInt();
                    System.out.println("Masukkan Judul Film : ");
                    judul = scn.nextLine();
                    System.out.println("Masukkan Rating Film : ");
                    rating = scan.nextDouble();
                    System.out.println("Data Film ini akan masuk di urutan ke- : "+pos);
                    System.out.println("");
                    dll.add(new film(id, judul, rating), pos);
                    break;
                    
                case 4:
                    film temp = dll.removeFirst();
                    if(temp == null)System.out.println("Data Film masih kosong");
                    else System.out.println("Data Film yang dihapus:\n"+ temp);
                    System.out.println("");
                    break;
                    
                case 5:
                    temp = dll.removeLast();
                    if(temp == null)System.out.println("Data Film masih kosong");
                    else System.out.println("Data Film yang dihapus:\n"+temp);
                    System.out.println("");
                    break;
                    
                case 6:
                    System.out.print("Masukkan data yang ingin dihapus di index ke-: ");
                    temp = dll.remove(sc.nextInt());
                    if(temp == null)System.out.println("Data Film masih kosong");
                    else System.out.println("Data Film yang dihapus:\n"+ temp);
                    System.out.println("");
                    break;
                    
                case 7:
                    System.out.println("Cetak Data");
                    System.out.println("Size : " + dll.size);
                    System.out.println("");
                    dll.print();
                    System.out.println("");
                    break;
                    
                case 8:
                    System.out.println("Masukkan ID Film yang dicari :");
                    int idfm = sc.nextInt();
                    int cari = dll.cari(idfm);
                    film filmFound = dll.get(cari);
                    System.out.println("Data ID film berada di node ke-" + cari);
                    System.out.println("IDENTITAS: ");
                    System.out.println(" ID FIlm: " + filmFound.id);
                    System.out.println(" Judul Film: " + filmFound.nama);
                    System.out.println(" Rating: " + filmFound.rating);
                    System.out.println("");
                    break;
                    
                case 9:
                    dll.printDesc();
                    System.out.println("");
                    break;
                    
                case 10:
                    System.out.println("Terima kasih");
                    sc.close();
            }
        }
    }
}