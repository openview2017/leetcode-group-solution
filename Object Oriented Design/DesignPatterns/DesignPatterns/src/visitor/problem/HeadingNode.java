package visitor.problem;

public class HeadingNode implements HtmlNode{
    @Override
    public void highlight() {
        System.out.println("Highlight-heading");
    }
}
