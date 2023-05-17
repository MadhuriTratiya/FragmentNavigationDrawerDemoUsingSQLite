package madhuri.com.craftzone;

public class sofa {

    String img;
    String title;

    public sofa(int img, String title){
        this.img = String.valueOf(img);
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
