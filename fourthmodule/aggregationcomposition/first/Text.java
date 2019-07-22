package aggregationcomposition.first;

public class Text {

    private String title;
    private String text;

    public Text(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Text(String title, Word[] words) {
        this.title = title;
        StringBuilder sb = new StringBuilder();

        for (Word word : words) {
            sb.append(word.getText())
                    .append(" ");
        }

        this.text = sb.toString();
    }

    public Text(String title, Sentence[] sentences) {
        this.title = title;
        StringBuilder sb = new StringBuilder();

        for (Sentence sentence : sentences) {
            sb.append(sentence.getText());
        }

        this.text = sb.toString();
    }

    public void append(String text) {
        this.text += text;
    }

    public void append(Word[] words) {
        StringBuilder sb = new StringBuilder();

        for (Word word : words) {
            sb.append(word.getText())
                    .append(" ");
        }

        this.text += sb.toString();
    }

    public void append(Sentence[] sentences) {
        StringBuilder sb = new StringBuilder();

        for (Sentence sentence : sentences) {
            sb.append(sentence.getText());
        }

        this.text += sb.toString();
    }

    public String getText() {
        return text;
    }

    public void printTitle() {
        System.out.println(title);
    }

    public void printText() {
        System.out.println(text);
    }

}
