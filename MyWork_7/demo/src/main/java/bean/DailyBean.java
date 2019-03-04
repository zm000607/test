package bean;

import java.util.List;

public class DailyBean {

    /**
     * images : ["https://pic4.zhimg.com/v2-7889956e1f47b311f289083e3077e94b.jpg"]
     * type : 0
     * id : 9708360
     * ga_prefix : 030119
     * title : 人人都想做产品经理，但这几条「硬杠杠」很少有人能达到
     */

    private int type;
    private int id;
    private String ga_prefix;
    private String title;
    private List<String> images;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
