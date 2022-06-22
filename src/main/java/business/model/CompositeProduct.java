package business.model;

import java.util.List;

public class CompositeProduct extends MenuItem {
    private List<MenuItem> menuItemList;

    public CompositeProduct(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
        this.setNewTitle();
        this.setRating(0);
        this.computeNutrients();
        this.computePrice();
    }

    public String setNewTitle() {
        String title = "Menu: ";
        for(int i = 0; i < menuItemList.size(); i++) {
            title += menuItemList.get(i).getTitle();
            if(i != menuItemList.size())
                title += ", ";
        }
        this.setTitle(title);
        return title;
    }

    public void computeNutrients() {
        int calories = 0, protein = 0, fat = 0, sodium = 0;
        for (MenuItem menuItem : menuItemList) {
            calories += menuItem.getCalories();
            protein += menuItem.getProtein();
            fat += menuItem.getFat();
            sodium += menuItem.getSodium();
        }
        this.setCalories(calories);
        this.setProtein(protein);
        this.setFat(fat);
        this.setSodium(sodium);
    }

    @Override
    public int computePrice() {
        int price = 0;
        for (MenuItem menuItem : menuItemList)
            price += menuItem.computePrice();
        this.setPrice(price);
        return price;
    }
    @Override
    public int compareTo(MenuItem o) {
        return super.getTitle().compareTo(o.getTitle());
    }
}
