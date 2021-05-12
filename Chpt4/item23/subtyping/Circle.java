package Chpt4.item23.subtyping;

class Circle extends Figure {
    final double radius;
    Circle(double radius) { this.radius = radius; }
    @Override 
    double area() { return Math.PI * (radius * radius); }
}
