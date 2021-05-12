package Chpt2.item3;

// getInstance를 이용한 싱글톤 패턴
public class singleton_Elvis_getInstance {
    private static final singleton_Elvis_getInstance INSTANCE = new singleton_Elvis_getInstance();
    private singleton_Elvis_getInstance() { }
    public static singleton_Elvis_getInstance getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        singleton_Elvis_getInstance elvis = singleton_Elvis_getInstance.getInstance();
        elvis.leaveTheBuilding();
    }
}