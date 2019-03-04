package builder;

public class MacBookBuilder extends ComputerBuilder {

    Computer computer=new MacBook();

    @Override
    public MacBookBuilder builderBoard(String board) {
        computer.setBoard(board);
        return this;
    }

    @Override
    public MacBookBuilder buildDisplay(String display) {
        computer.setDisplay(display);
        return this;
    }

    @Override
    public MacBookBuilder buildOs() {
        computer.setOs();
        return this;
    }

    @Override
    public Computer build() {
        return computer;
    }
}
