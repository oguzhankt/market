package oguzhankt;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class Main {

    public static String[] genelKategoriTempList = {"Bilgisayar", "Beyaz Eşya", "Elektronik", "Giyim", "Kırtasiye_Ofis", "YapıMarket", "Bahçe", "Tekstil", "Yiyecek"};
    public static ArrayList<String> genelKategoriList = new ArrayList<>();
    public static Hashtable<String, KategoriTree> table = new Hashtable<>();
    public static Scanner okuyucu = new Scanner(System.in);

    public static void main(String[] args) {

        init();
        anaMenu();

        // Agac ekleme


        KategoriTree agac = table.get("Bilgisayar");

        // Kategori ekleme
        kategoriEkle(agac, "Dizüstü Bilgisayar");

        Kategori k1 = agac.find(0).getKtgr();

        // Urun ekleme

        String metin1 = "Laptop 15 Ekran";
        Urun u1 = new Urun("Asus", "P50IJ", 3, 1500.00, 1900.00, aciklamaOlustur(metin1));

        urunEkle(u1,k1);

        String metin2 = "Laptop 3 inch";
        Urun u2 = new Urun("Sony", "AA21", 5, 1830.00, 3400.00, aciklamaOlustur(metin2));

        urunEkle(u2, k1);

        table.get("Bilgisayar").display(table.get("Bilgisayar").find(0));


        //        program.hashTableDictOlustur();


    }

    public static void printLine(){
        System.out.println("------------------------");
    }

    public static void init(){

        for(String name : genelKategoriTempList){
            genelKategoriList.add(name);
            agacEkle(table, name);
        }

        kategoriEkle(table.get("Bilgisayar"), "Tablet");
        kategoriEkle(table.get("Bilgisayar"), "Dizustu Bilgisayar");
        kategoriEkle(table.get("Bilgisayar"), "Netbook");

    }

    public static void urunEkle(Urun u, Kategori k){

        ArrayList<Urun> tempList = new ArrayList<>();

        tempList = k.getUrunList();
        tempList.add(u);
        k.setUrunList(tempList);

    }

    public static void kategoriEkle(KategoriTree kTree, String kIsım){

        Kategori k = new Kategori(kIsım);
        kTree.insert(k);

    }

    public static void agacEkle(Hashtable htGenel , String treeIsım){

        KategoriTree kt = new KategoriTree(treeIsım);
        htGenel.put(treeIsım, kt);

    }

    public static ArrayList<String> aciklamaOlustur(String metin){

        ArrayList<String> aciklama = new ArrayList<>();

        for(String kelime : metin.split(" ")){
            aciklama.add(kelime.trim());
        }

        return aciklama;

    }

    public static void anaMenu(){
        System.out.println("SANAL MARKET");
        printLine();
        System.out.println("1) Personel Girişi");
        System.out.println("0) Çıkış");

        switch (okuyucu.nextInt()){
            case(1):
                personelMenu();
                break;

            case(0):
                System.exit(0);
                break;
        }
    }

    public static void personelMenu(){
        System.out.println("PERSONEL MENUSU");
        printLine();
        System.out.println("1) Urun Ekleme");
        System.out.println("2) Urun Arama ve Değişiklik Yapma");
        System.out.println("3) Urun Silme");
        System.out.println("4) Şirketin toplam gelir, gider ve karının hesaplanması");
        System.out.println("0) Ana Menüye Geri Dön");

        switch(okuyucu.nextInt()){

            case(1):
                urunEklemeMenu();
                break;

            case(2):
                break;

            case(3):
                break;

            case(4):
                break;

            case(0):
                anaMenu();
                break;
        }

    }

    public static void urunEklemeMenu(){
        System.out.println("URUN EKLEME");
        printLine();
        System.out.println("1) Varolan Kategoriye ekleme");
        System.out.println("2) Yeni kategoriye ekleme");
        System.out.println("0) Geriye git");

        switch (okuyucu.nextInt()){

            case(1):

                System.out.println("KATEGORİLER");
                printLine();
                for(String key : genelKategoriList){
                    System.out.println(key);
                }
                printLine();
                varolanKategoriyeEkleme();

                break;

            case(2):

                break;

            case(0):
                personelMenu();
                break;



        }
    }

    public static void varolanKategoriyeEkleme(){
        System.out.println("Kategori ismini giriniz");
        String menuTableKey = okuyucu.next();
        if(!genelKategoriList.contains(menuTableKey)){
            System.out.println("Yanlış kategori ismi girdiniz, Tekrar deneyin");
            varolanKategoriyeEkleme();
        }else{
            System.out.println(menuTableKey + " Kategorisine ürün eklemektesiniz");
            System.out.println("1) Varolan ürün türüne ekleme");
            System.out.println("2) Yeni ürün türü ekleme");
            System.out.println("0) Geriye git");
            System.out.println("-1) Ürün ekleme menüsüne dön");

            switch (okuyucu.nextInt()){
                case(1):
                    varolanUrunTuruneEkleme(menuTableKey);
                    break;
                case(2):
                    break;
                case(0):
                    varolanKategoriyeEkleme();
                    break;
                case(-1):
                    urunEklemeMenu();
                    break;
            }
        }
    }

    public static void varolanUrunTuruneEkleme(String menuTableKey){

        System.out.println("URUN TURLERI");
        ArrayList<String> menuNodeNames = table.get(menuTableKey).getNodeNames();

        for(String name : menuNodeNames){
            System.out.println(name);
        }

    }

//    public void hashTableDictOlustur(){
//        ArrayList<Urun> dictionaryUrunList = new ArrayList<>();
//        String tempStr, dictionaryKeyStrTemp;
//
//
//
//        for(int i=0 ; i<GenelKategoriList.size(); i++){
//
//            tempStr = GenelKategoriList.get(i);
//            KategoriTree tempTree = table.get(tempStr);
//
//            for(int j = 0; j<tempTree.getIdCounter(); j++){
//
//                for(int t = 0; t<tempTree.find(j).getKtgr().getUrunList().size(); t++){
//
//                    for(int x = 0; x<tempTree.find(j).getKtgr().getUrunList().get(t).getUrunAciklamasi().size(); x++){
//
//                        dictionaryUrunList.add(tempTree.find(j).getKtgr().getUrunList().get(t));
//                        dictionaryKeyStrTemp = tempTree.find(j).getKtgr().getUrunList().get(t).getUrunAciklamasi().get(x);
//                        System.out.println("Added " + dictionaryKeyStrTemp);
//                        DictionaryTable.put(dictionaryKeyStrTemp, (ArrayList)dictionaryUrunList.clone());
//
//
//                    }
//                    dictionaryUrunList.clear();
//
//                }
//
//            }
//
//        }
//        System.out.println("     ");
//
//        System.out.println(DictionaryTable.toString());
//
//    }



}
