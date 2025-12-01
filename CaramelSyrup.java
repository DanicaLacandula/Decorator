public class CaramelSyrup extends CoffeeDecorator {
    public CaramelSyrup(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Caramel Syrup";
    }
    
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 40.00;
    }
}
