package Chpt2.item1;

class subClass { // Discount
    public static Discount createDiscountItem(String discountCode) throws Exception {
        if(!isValidCode(discountCode)) {
            throw new Exception("잘못된 할인 코드");
        }
        // 쿠폰 코드인가? 포인트 코드인가?
        if(isUsableCoupon(discountCode)) {
            return new Coupon(1000);
        } else if(isUsablePoint(discountCode)) {
            return new Point(500);
        }
        throw new Exception("이미 사용한 코드");
    }
}

class Coupon extends Discount { }
class Point extends Discount { }


// Source : https://johngrib.github.io/wiki/static-factory-method-pattern/