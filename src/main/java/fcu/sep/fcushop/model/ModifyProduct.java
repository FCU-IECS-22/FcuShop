package fcu.sep.fcushop.model;

/**
 * this is class Product.
 */
public class ModifyProduct {

    private long id;

    private String newName;

    private String oldName;

    private String imageUrl;

    private int price;

    private String description;

    public ModifyProduct() {
    }

    /**
     * Product init().
     *
     * @param id          id.
     * @param newName     newName.
     * @param oldName     oldName.
     * @param imageUrl    imageUrl.
     * @param price       price.
     * @param description description.
     */
    public ModifyProduct(long id, String oldName, String newName,String imageUrl, int price, String description) {
        this.id = id;
        this.oldName = oldName;
        this.newName = newName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOldName() {
        return oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setOldName(String name) {
        this.oldName = name;
    }

    public void setNewName(String name) {
        this.newName = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
