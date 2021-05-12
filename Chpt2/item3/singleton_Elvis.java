package Chpt2.item3;
// 가장 기본적인 싱글톤 패턴
public class singleton_Elvis {
    public static final singleton_Elvis INSTANCE = new singleton_Elvis();
    private singleton_Elvis() {}
    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }
}