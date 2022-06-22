package business.model;

public class BaseProduct extends MenuItem {
    public BaseProduct(String title, double rating, int calories, int protein, int fat, int sodium, int price, int orderCounter) {
        super(title, rating, calories, protein, fat, sodium, price, orderCounter);
    }
    @Override
    public int compareTo(MenuItem o) {
        return super.getTitle().compareTo(o.getTitle());
    }
}
