package ph.com.bilinear.ccf_mobile.data.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by jtampinco on 3/21/2017.
 */

public class News implements Serializable{

    @Expose
    private int id;

    @Expose
    private String title;

    @Expose
    private String description;

    @Expose
    private String image;

    @Expose
    private String categories;

    @Expose
    private String created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

}
