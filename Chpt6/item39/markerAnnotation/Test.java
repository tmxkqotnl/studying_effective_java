package Chpt6.item39.markerAnnotation;

// 코드 39-1 마커(marker) 애너테이션 타입 선언 (238쪽)
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}
