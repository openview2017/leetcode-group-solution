package stategy.solution;

public class ImageStorage {
    private Compressor compressor;
    private Filter filter;

    public ImageStorage(Compressor compressor, Filter filter) {
        this.compressor = compressor;
        this.filter = filter;
    }

    public void store (String fileName) {
        // JPEG, PNG, ...
        // B&W, High Contrast
       compressor.compress(fileName);
       filter.apply(fileName);
    }
}

/*
public class ImageStorage {
    public void store (String fileName, Compressor compressor, Filter filter) {
        // JPEG, PNG, ...
        // B&W, High Contrast
        compressor.compress(fileName);
        filter.apply(fileName);
    }
}
*/
