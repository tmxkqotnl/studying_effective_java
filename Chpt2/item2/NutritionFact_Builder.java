package Chpt2.item2;

public class NutritionFact_Builder {
        private final int servingSize;
        private final int servings;
        private final int calories;
        private final int fat;
        private final int sodium;
        private final int carbohydrate;
    
        public static class Builder {
            // 필수 매개변수
            private final int servingSize;
            private final int servings;
    
            // 선택 매개변수 - 기본값으로 초기화한다.
            private int calories      = 0;
            private int fat           = 0;
            private int sodium        = 0;
            private int carbohydrate  = 0;
    
            public Builder(int servingSize, int servings) {
                this.servingSize = servingSize;
                this.servings    = servings;
            }
    
            public Builder calories(int val)
            { calories = val;      return this; }
            public Builder fat(int val)
            { fat = val;           return this; }
            public Builder sodium(int val)
            { sodium = val;        return this; }
            public Builder carbohydrate(int val)
            { carbohydrate = val;  return this; }
    
            public NutritionFact_Builder build() {
                return new NutritionFact_Builder(this);
            }
        }
    
        private NutritionFact_Builder(Builder builder) {
            servingSize  = builder.servingSize;
            servings     = builder.servings;
            calories     = builder.calories;
            fat          = builder.fat;
            sodium       = builder.sodium;
            carbohydrate = builder.carbohydrate;
        }
    
        public static void main(String[] args) {
            // method chaining
            NutritionFact_Builder cocaCola = new NutritionFact_Builder.Builder(240, 8)
                    .calories(100).sodium(35).carbohydrate(27).build();
        }
}
