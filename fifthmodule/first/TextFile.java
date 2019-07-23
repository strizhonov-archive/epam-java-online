package first;

public class TextFile extends File {

    private String text;

    public TextFile(String name, String text, Directory directory) {
        this.name = name;
        this.text = text;
        this.directory = directory;
    }

    public void print() {
        System.out.println(text);
    }

    @Override
    public void update(String[] args) {
        if (args.length != 1) {
            System.exit(-1);
        }
        text += args[0];
    }
}
