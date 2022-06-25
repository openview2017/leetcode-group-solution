package mediator.observer;

public class ArticlesDialogBox {
    private ListBox articlesListBox = new ListBox();
    private TextBox titleTextBox = new TextBox();
    private Button saveButton = new Button();

    public ArticlesDialogBox() {
        /*articlesListBox.attach(new Observer() {
            @Override
            public void update() {
                articlesSelected();
            }
        });
        // Use lambda function in functional interface (Observer)
        // () -> {}
        articlesListBox.attach(() -> {
            articlesSelected();
        });
        articlesListBox.attach(() -> articlesSelected());*/
        articlesListBox.attach(this::articlesSelected); //EventHandlers -> Change attach to addEventHandler and observer to EventHandler

        titleTextBox.attach(this::titleChanged);
    }

    public void simulateUserInteraction() {
        articlesListBox.setSelection("Article 1");
        // titleTextBox.setContent("");
        // titleTextBox.setContent("Article 2");
        System.out.println("TextBox: " + titleTextBox.getContent());
        System.out.println("Button: " + saveButton.isEnabled());
    }

    private void titleChanged() {
        var content = titleTextBox.getContent();
        var isEmpty = (content == null || content.isEmpty());
        saveButton.setEnabled(!isEmpty);
    }

    private void articlesSelected(){
        titleTextBox.setContent(articlesListBox.getSelection());
        saveButton.setEnabled(true);
    }

}
