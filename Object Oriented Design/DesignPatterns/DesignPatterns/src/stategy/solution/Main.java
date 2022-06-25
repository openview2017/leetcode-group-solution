package stategy.solution;

public class Main {
    public static void main(String[] args){
        var imageStore = new ImageStorage(
                new JpegCompressor(), new BlackAndWhiteFilter()
        );
        imageStore.store("a");
    }
}
