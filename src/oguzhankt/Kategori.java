package oguzhankt;

import java.util.ArrayList;

public class Kategori {

    private String name;
    private int id;
    private ArrayList<Urun> urunList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Urun> getUrunList() {
        return urunList;
    }

    public void setUrunList(ArrayList<Urun> urunList) {
        this.urunList = urunList;
    }

    public Kategori(String isim) {
        this.name = isim;
    }

    public Kategori(int id, ArrayList<Urun> urunList) {
        this.id = id;
        this.urunList = urunList;
    }

    @Override
    public String toString() {
        return "Kategori{" +
                "id=" + id +
                ", urunList=" + urunList +
                '}';
    }
}
