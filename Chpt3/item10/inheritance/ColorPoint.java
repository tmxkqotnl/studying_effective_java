package Chpt3.item10.inheritance;

import Chpt3.item10.Color;
import Chpt3.item10.Point;

public class ColorPoint extends Point{
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /* // 대칭성 위배!
    @Override public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        return super.equals(o) && ((ColorPoint) o).color == color;
    } */

   // 추이성 위배!
   @Override public boolean equals(Object o) {
       if (!(o instanceof Point))
           return false;

       // o가 일반 Point면 색상을 무시하고 비교한다.
       if (!(o instanceof ColorPoint))
           return o.equals(this);

       // o가 ColorPoint면 색상까지 비교한다.
       return super.equals(o) && ((ColorPoint) o).color == color;
   }

    public static void main(String[] args) {
        // 첫 번째 equals 메서드(코드 10-2)는 대칭성을 위배한다. (57쪽)
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp) + " " + cp.equals(p));

        // 두 번째 equals 메서드(코드 10-3)는 추이성을 위배한다. (57쪽)
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.printf("%s %s %s%n",
                          p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}
