package quotes;

public class QuotesAPI {

    private String quoteText;
    private String quoteAuthor;

    public QuotesAPI(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteText() {
        return quoteText;
    }


    public String getQuoteAuthor() {
        return quoteAuthor;
    }


}
