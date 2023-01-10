package app.play;

import app.discount.discountCondition.*;

public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void makeOrder() {
        int totalPrice = cart.calculateTotalPrice();
        int finalPrice = totalPrice;

        DiscountCondition[] discountConditions = new DiscountCondition[
                new CozDiscountCondition(),
                new KidDiscountCondition();

        for(DiscountCondition discountCondition : discountConditions) {
            discountCondition.checkDiscountCondition();
            if (discountCondition.isSatisfied()) finalPrice = discountCondition.applyDiscount(finalPrice);
        }

        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(60));

        cart.printCartItemDetails();

        System.out.println("-".repeat(60));
        System.out.printf("금액 합계      : %d원\n", totalPrice);
        System.out.printf("할인 적용 금액 : %d원\n", finalPrice);

    }
}