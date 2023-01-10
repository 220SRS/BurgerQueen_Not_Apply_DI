package app.discount.discountCondition;

public interface DiscountCondition {
    public void checkDiscountCondition();
    public boolean isSatisfied();
    public int applyDiscount(int price);

}
