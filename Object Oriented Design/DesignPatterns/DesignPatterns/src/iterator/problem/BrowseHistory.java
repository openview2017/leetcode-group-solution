package iterator.problem;

import java.util.ArrayList;
import java.util.List;

public class BrowseHistory {
    private List<String> urls = new ArrayList<String>();

    public List<String> getUrls() {
        return urls;
    }

    public void push(String url) {
        urls.add(url);
    }
    public String pop() {
        var lastIndex = urls.size() - 1;
        var lastUrl = urls.get(lastIndex);
        urls.remove(lastIndex);
        return lastUrl;
    }
}
