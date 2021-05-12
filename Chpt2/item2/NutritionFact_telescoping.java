package Chpt2.item2;

// 확장하기 어려운 형태의 점층적 생성자 패턴
public class NutritionFact_telescoping {
    // required
    private final int servingSize;
    private final int servings;
    // options
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFact_telescoping(int servingSize, int servings) {
            this(servingSize, servings, 0);
        }

    public NutritionFact_telescoping(int servingSize, int servings, int calories) {
            this(servingSize, servings, calories, 0);
        }

    public NutritionFact_telescoping(int servingSize, int servings, int calories, int fat) {
            this(servingSize, servings, calories, fat, 0);
        }

    public NutritionFact_telescoping(int servingSize, int servings, int calories, int fat, int sodium) {
            this(servingSize, servings, calories, fat, sodium, 0);
        }

    public NutritionFact_telescoping(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
            this.servingSize = servingSize;
            this.servings = servings;
            this.calories = calories;
            this.fat = fat;
            this.sodium = sodium;
            this.carbohydrate = carbohydrate;
        }

}
