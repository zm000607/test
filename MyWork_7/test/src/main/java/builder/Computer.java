package builder;

public abstract class Computer {
    public Computer() {
    }
    protected String board;

    protected String display;

    protected String os;

    protected void setBoard(String board) {
        this.board = board;
    }

    protected void setDisplay(String display) {
        this.display = display;
    }

    protected void setOs() {

    }

    @Override
    public String toString() {
        return "Computer{" +
                "board='" + board + '\'' +
                ", display='" + display + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
