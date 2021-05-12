package Chpt2.item1;


import java.util.function.Supplier;

public class Charactor{
    private int hp, mp, attack;

    // 클라이언트가 클래스의 인스턴스를 얻는 전통적인 수단은 public 생성자
    public Charactor(int hp, int mp, int attack){
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
    }

    // 정적 팩토리 메소드
    public static Charactor Archer(){
        return new Charactor(5,5,20);
    }
    public static Charactor SwordMan(){
        return new Charactor(12,5,10);
    }
    public String getInfo(){
        String info = String.format("%d %d %d", this.hp,this.mp,this.attack);
        return info;
    }
    public Charactor getThis(){
        return this;
    }

    public static void main(String[] args){
        Charactor A = Charactor.Archer();
        Charactor B = Charactor.SwordMan();

        System.out.println(A.getInfo());
        System.out.println(B.getInfo());
    }
}