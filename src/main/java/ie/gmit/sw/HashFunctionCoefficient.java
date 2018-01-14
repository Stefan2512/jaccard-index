package ie.gmit.sw;

/**
 * Class encapsulation the a and b coefficients of the (ax + b) % c hash function.
 */
public class HashFunctionCoefficient {

    private int a;
    private int b;

    public HashFunctionCoefficient(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
