public class film {
    int id;
    String nama;
    double rating;
    
    public film(int id, String judul, double rating){
        this.id = id;
        this.nama = judul;
        this.rating = rating;
    }
    
    public String toString() {
        return String.format("ID: %d\n" + " Judul Film: %s\n" + " Rating Film: %.1f", id, nama, rating);
    }  

}
