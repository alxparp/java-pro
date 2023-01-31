package lesson6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Product {

    private long id;
    private ProductType type;
    private double price;
    private boolean discount;
    private Date date;

    public Product(long id, ProductType type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.date = getDateByFormat();
    }

    public Product(long id, ProductType type, double price, boolean discount) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.date = getDateByFormat();
    }

    private Date getDateByFormat() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
            return sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public long getId() {
        return id;
    }

    public boolean isDiscount() {
        return discount;
    }

    public ProductType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getDiscount() {
        return discount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type=" + type.getType() +
                ", price=" + price +
                ", discount=" + discount +
                ", date=" + new SimpleDateFormat("dd-MM-yyyy").format(date) +
                '}';
    }
}
