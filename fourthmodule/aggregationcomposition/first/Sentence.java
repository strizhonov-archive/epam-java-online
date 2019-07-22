package aggregationcomposition.first;

public class Sentence {

    private String text;

    public Sentence(String text) {
        this.text = text;
    }

    public Sentence(Word[] words) {
        StringBuilder sb = new StringBuilder();
        for (Word word : words) {
            sb.append(word.getText())
                    .append(" ");
        }

        this.text = sb.toString();
    }

    public String getText() {
        return text;
    }
}
