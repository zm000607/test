package builder;

public abstract class ComputerBuilder {

    protected abstract ComputerBuilder builderBoard(String board);
    protected abstract ComputerBuilder buildDisplay(String display);

    protected abstract ComputerBuilder buildOs();

    protected abstract Computer build();
}
