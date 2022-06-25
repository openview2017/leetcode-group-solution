package stategy.solution;

public class JpegCompressor implements Compressor {
    @Override
    public void compress(String filename) {
        System.out.println("Compressing using Jpeg.");
    }
}
