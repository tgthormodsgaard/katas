import java.util.Arrays;
import java.util.List;

/**
 * Create a Dark Frame and process images with it.
 */
public class DarkFrameProcessor {

    /**
     * Get the average pixel value of an image
     * @param image double array of the image
     * @return double value of thee average
     */
    public double getAveragePixelValue(double[][] image) {
        return Arrays.stream(image).flatMapToDouble(Arrays::stream).average().getAsDouble();
    }

    public double getMaxPixelValue(double[][] image) {
        return Arrays.stream(image).flatMapToDouble(Arrays::stream).max().getAsDouble();
    }

    public double getMinPixelValue(double[][] image) {
        return Arrays.stream(image).flatMapToDouble(Arrays::stream).min().getAsDouble();
    }

    public double[][] createDarkFrame(List<double[][]> images) {
        double[][] darkFrame = new double[images.get(0).length][images.get(0)[0].length];
        for (double[][] image : images) {
            for(int i=0; i < image.length; i++) {
                for(int j=0; j < image[i].length; j++) {
                    darkFrame[i][j] += image[i][j];
                }
            }
        }
        for (int x=0; x < darkFrame.length; x++) {
            for(int y=0; y < darkFrame[x].length; y++) {
                darkFrame[x][y] = darkFrame[x][y] / images.size();
            }
        }
        return darkFrame;
    }

    public double[][] applyDarkFrame(double[][] image, double[][] darkFrame) {
        double[][] results = new double[image.length][image[0].length];
        for(int i=0; i < image.length; i++) {
            for(int j=0; j <image[i].length; j++) {
                results[i][j] = image[i][j] - darkFrame[i][j];
            }
        }

        return results;
    }
}
