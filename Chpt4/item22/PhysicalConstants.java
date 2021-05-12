package Chpt4.item22;

// constant interface anti-pattern
/* public interface PhysicalConstants{
    public static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    public static final double BOLTZMANN_CONST = 1.380_648_52e-23;
} */

public class PhysicalConstants {
    private PhysicalConstants(){}

    public static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    public static final double BOLTZMANN_CONST = 1.380_648_52e-23;
    
    ...    
}
