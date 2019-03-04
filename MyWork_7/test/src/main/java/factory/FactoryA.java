package factory;

/**
 * Created by asus on 2019/3/4.
 */

public class FactoryA extends Factory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
