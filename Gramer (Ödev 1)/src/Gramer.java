import java.util.Scanner;

public class Gramer {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Gramer Kontrolu Icin Cumlenizi Giriniz:");
        String cumle = scan.nextLine();
        if (cumleKontrol(cumle)) {
            System.out.println("EVET");
        }
        
        else {
            System.out.println("HAYIR");
        }
    }

    public static boolean cumleKontrol(String cumle) {
        String[] kelimeler = cumle.trim().split("\\s+");
        if (kelimeler.length != 3){
            return false;
        }

        String ozne = kelimeler[0];
        String nesne = kelimeler[1];
        String yuklem = kelimeler[2];
        
        String[] ozneler = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
        String[] nesneler = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma","Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
        String[] yuklemler = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

        boolean ozneKontrol = false;
        for (String icerik : ozneler) {
            if (icerik.equalsIgnoreCase(ozne)) { 
                ozneKontrol = true;
                break;
            }
        }
        
        boolean nesneKontrol = false;
        for (String icerik : nesneler) {
            if (icerik.equalsIgnoreCase(nesne)) { 
                nesneKontrol = true;
                break;
            }
        }
        
        boolean yuklemKontrol = false;
        for (String icerik : yuklemler) {
            if (icerik.equalsIgnoreCase(yuklem)) { 
                yuklemKontrol = true;
                break;
            }
        }
        
        return ozneKontrol && nesneKontrol && yuklemKontrol;
        
    }
}
