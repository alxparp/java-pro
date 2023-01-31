package lesson6;

public enum ProductType {

    BOOK("Book"),
    PEN("Pen"),
    PENCIL("Pencil"),
    NOTEBOOK("Notebook");

    private String type;

    ProductType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
