package first;

import java.util.Arrays;

public class Directory {

    private String name;
    private File[] files;

    public Directory(String name, File[] files) {
        this.name = name;
        this.files = files;
    }

    public void createTextFile() {
        files = Arrays.copyOf(files, files.length + 1);

        String name = "New File";

        int add = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(name)) {
                name = "New File" + " (" + ++add + ")";
                i = -1;
            }
        }

        files[files.length - 1] = new TextFile(name, "", this);
    }

    public void deleteFile(String name) {
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(name)) {
                files[i] = files[files.length - 1];
                files = Arrays.copyOf(files, files.length - 1);
                return;
            }
        }
    }
}
