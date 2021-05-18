package microservice.learn.moviecatalogservice.models;

public class CatalogItem {
    private String name;
    private String desc;
    private int rating;
    private String port;

    public CatalogItem(String name, String desc, int rating, String port) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public CatalogItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public CatalogItem setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public CatalogItem setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public String getPort() {
        return port;
    }

    public CatalogItem setPort(String port) {
        this.port = port;
        return this;
    }
}
