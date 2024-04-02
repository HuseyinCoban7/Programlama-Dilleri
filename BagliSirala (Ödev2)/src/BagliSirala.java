import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class BagliSirala {
    
    public static void main(String[] args) throws Exception {
        Deger[] sayiDizisi;
        int[][] values;
        Scanner scan = new Scanner(System.in);
        // C:\Users\Hüseyin Çoban\Desktop\DERS\Java\Programlama Dilleri\BagliSirala\deneme.txt
        System.out.print("Dosya Yolu Giriniz: ");
        String path = scan.nextLine();
        File file = new File(path);
        if(file.exists()) {
            
            String[] cumleDizisi = satirOku(file);
            sayiDizisi = new Deger[cumleDizisi.length];
            values = new int[cumleDizisi.length][4];
            
            for (int i = 0; i < cumleDizisi.length; i++) {
                Deger yeniDeger = new Deger(Integer.parseInt(cumleDizisi[i]), i);
                sayiDizisi[i] = yeniDeger;
            }
            
            for (int i = 0; i < sayiDizisi.length; i++) {
                
                values[i][0] = sayiDizisi[i].sayi;
                values[i][1] = sayiDizisi[i].index; 
            }
            
            for (int i = 0; i < sayiDizisi.length; i++) {
                for (int j = 0; j < sayiDizisi.length - 1; j++) {
                    if (sayiDizisi[j].sayi > sayiDizisi[j + 1].sayi) {
                        int tempSayi = sayiDizisi[j].sayi;
                        int tempIndex = sayiDizisi[j].index;
                        sayiDizisi[j].sayi = sayiDizisi[j + 1].sayi;
                        sayiDizisi[j].index = sayiDizisi[j + 1].index;
                        sayiDizisi[j + 1].sayi = tempSayi;
                        sayiDizisi[j + 1].index = tempIndex;
                    }
                }
            }
            
            for (int i = 0; i < sayiDizisi.length; i++) {
                
                values[i][2] = sayiDizisi[i].sayi;
                values[i][3] = sayiDizisi[i].index ;

            }
            
            for (int i = 0; i < sayiDizisi.length; i++) {                
                    System.out.print("Deger: " + values[i][0] + " ");
                    System.out.print("Index: " + values[i][1] + " ");
                    System.out.print("\t");
                    System.out.print("Deger: " + values[i][2] + " ");
                    System.out.print("Index: " + values[i][3] + " ");
                    System.out.println();
            }    
        }
        
        else {
            System.out.println("Dosya bulunamadı.");
        }
    }
    
    public static String[] satirOku(File file) throws Exception {
        try (BufferedReader bR = new BufferedReader(new FileReader(file))) {
            String line;
            String text = "";
            while ((line = bR.readLine()) != null) {
                text += line + "\n";
            }
            return text.trim().split("[\\r\\n]+");
        }
    }
}
