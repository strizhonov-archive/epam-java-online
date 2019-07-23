package first;

public abstract class File {

    protected String name;
    protected Directory directory;

    public String getName() {
        return name;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void rename(String name) {
        this.name = name;
    }

    public abstract void update(String[] args);

}
