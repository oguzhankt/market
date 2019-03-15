package oguzhankt;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author DankSide
 */

public class UrunIO {

    static String PATH = "Urunler.dat";

    public static List<Urun> loadItems(){
        return loadItems(PATH);
    }

    public static List<Urun> loadItems(String filePath){
        List<Urun> list = new ArrayList<>();
        FileInputStream fileIn = null;
        ObjectInputStream input = null;

        try {
            fileIn = new FileInputStream(filePath);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage() + "@1");
        }

        try {

            input = new ObjectInputStream(fileIn);
            Urun item = null;
            do{
                try {
                    item = (Urun) input.readObject();
                }
                catch (ClassNotFoundException e){
                    System.out.println(e.getMessage() + " @2");
                }
                if (item != null){
                    list.add(item);
                }
            }
            while (true);
        }
        catch (EOFException e){
            System.out.println("@3");
            return list;
        }
        catch (IOException e){
            System.out.println(e.getMessage() + " @4");
            e.printStackTrace();
            return null;
        }
        finally {
            try {
                input.close();
            }
            catch (IOException e){
                System.out.println(e.getMessage() + " A problem occurred while closing the Object input stream (@5)");
            }
        }
    }
    public static boolean writeItems(List<Urun> list){
        return writeItems(list, PATH);
    }

    public static boolean writeItems(List<Urun> list, String pathName){
        FileOutputStream fileOut = null;
        ObjectOutputStream output = null;
        try {
            fileOut = new FileOutputStream(pathName);
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage() + " @6");
        }
        try {

            output = new ObjectOutputStream(fileOut);
            for (Urun item : list){
                output.writeObject(item);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage() + " OUTPUT @7");
        }
        finally {
            try {
                output.close();
                return true;
            }
            catch (IOException e){
                System.out.println(e.getMessage() + " A problem occurred while closing the Object output stream @8");
                return false;
            }
        }
    }

    public static void main(String[] args) {
//            DAT DOSYASI OLUSTURULACAKSA


//        ArrayList<Urun> list = new ArrayList<>();
//        list.add(new Urun("TOSHIBA","Satellite",1 , 2.5,3.0, new ArrayList<String>()));
//        list.add(new Urun("Acer","Vision",5 , .5,3.5, new ArrayList<String>()));
//        list.add(new Urun("HP","Pavillion",2 , 2.2,3.2, new ArrayList<String>()));
//
//        System.out.println(writeItems(list));




//        -------------------------- * ---------------------------



//            DAT DOSYASI MEVCUTSA


//        List<Urun> list = loadItems();
//
//        for (Urun u : list){
//            System.out.println(u);
//        }
    }


}
