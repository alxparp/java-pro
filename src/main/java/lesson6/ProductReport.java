package lesson6;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public final class ProductReport {

    public static List<Product> getBooksMoreThan250Units(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals(ProductType.BOOK))
                .filter(product -> product.getPrice()>250)
                .toList();
    }

    public static List<Product> getBooksWith10PercentDiscount(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals(ProductType.BOOK) && product.getDiscount())
                .peek(product -> product.setPrice(product.getPrice()*0.9))
                .toList();
    }

    public static Product getCheapestBook(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals(ProductType.BOOK))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException(String.format("Product %s dismiss", ProductType.BOOK.getType())));
    }

    public static List<Product> getLastThreeProductsByDate(List<Product> products) {
        return products.stream()
                .sorted((p1,p2) -> p2.getDate().compareTo(p1.getDate()))
                .limit(3)
                .toList();
    }

    public static double getAmountOfBooksAddedThisYearAndLessThan75Units(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals(ProductType.BOOK))
                .filter(product -> convertToLocalDateViaInstant(product.getDate()).getYear() == Year.now().getValue())
                .filter(product -> product.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    private static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static Map<ProductType, List<Product>> getProductsGroupingByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

}
