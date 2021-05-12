package Chpt2.item3;

// 원소가 하나인 enum type을 선언한 싱글톤 패턴
// 상속하려는 class가 enum이 아니면 곤란하다.
public enum singleton_Elvis_enum {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("기다려 자기야, 지금 나갈께!");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        singleton_Elvis_enum  elvis = singleton_Elvis_enum.INSTANCE;
        elvis.leaveTheBuilding();
    }
}