package stategy.problem;

public class ImageStorage {
    private String compressor;
    private String filter;

    public ImageStorage(String compressor, String filter) {
        this.compressor = compressor;
        this.filter = filter;
    }

    public void store (String fileName) {
        // JPEG, PNG, ...
        // B&W, High Contrast
        if (compressor == "jpeg") {
            System.out.println("Compressing using JPEG");
        } else if (compressor == "png") {
            System.out.println("Compressing using PNG");
        }
        
        if (filter == "b&w") {
            System.out.println("Using black and white fitler");
        } else if (filter == "high-contrast") {
            System.out.println("Using high contrast filter");
        }
    }
}
