package models;

public class ProductDTO {
    private Long id;
    private String name;
    private String price;

    public ProductDTO(Long id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
