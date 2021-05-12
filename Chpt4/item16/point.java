package Chpt4.item16;

// information hiding
class point{
    private double x;
    //...

    Point(double x){
        this.x = x;
        //...
    }

    public double getX(){
        return x;
    }
    private void setX(double x){ 
        this.x = x;
    }
}