package Chpt4.item24;

public class test {
    public static void main(String[] args){
        new Anonymous(){
            @Override
            public void println(){
                System.out.println("Override");
            }
        }.println();
    }    
}
