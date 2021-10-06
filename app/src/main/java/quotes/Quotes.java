package quotes;

public class Quotes {

    private String[] tags;
    private String author;
    private String likes;
    private String text;


    public Quotes(String[] tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }


    @Override
    public String toString() {
        return "Author : " + author + '.' + '\n' + "Text : " + text + '.';
    }
}