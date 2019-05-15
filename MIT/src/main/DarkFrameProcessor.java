import java.util.Arrays;
import java.util.List;

/**
 * Create a Dark Frame and process images with it.
 */
public class DarkFrameProcessor {

    /**
     * Get the average pixel value of an image
     *
     * @param image double array of the image
     * @return double value of thee average
     */
    public double getAveragePixelValue(double[][] image) {
        return Arrays.stream(image).flatMapToDouble(Arrays::stream).average().getAsDouble();
    }

    /**
     * Get the max value of a pixel of an image
     *
     * @param image double array of the image
     * @return double value of the max pixel
     */
    public double getMaxPixelValue(double[][] image) {
        return Arrays.stream(image).flatMapToDouble(Arrays::stream).max().getAsDouble();
    }

    /**
     * Get the min value of a pixel of an image
     *
     * @param image double array of the image
     * @return double value of the min pixel
     */
    public double getMinPixelValue(double[][] image) {
        return Arrays.stream(image).flatMapToDouble(Arrays::stream).min().getAsDouble();
    }

    /**
     * Take an array list of images and process them to create a master dark frame
     *
     * @param images a list of images
     * @return double array of the master dark frame
     */
    public double[][] createDarkFrame(List<double[][]> images) {
        double[][] darkFrame = new double[images.get(0).length][images.get(0)[0].length];
        images.forEach(image -> {
            for (int i = 0; i < image.length; i++) {
                for (int j = 0; j < image[i].length; j++) {
                    darkFrame[i][j] += image[i][j];
                }
            }
        });

        for (int x = 0; x < darkFrame.length; x++) {
            for (int y = 0; y < darkFrame[x].length; y++) {
                darkFrame[x][y] = darkFrame[x][y] / images.size();
            }
        }
        return darkFrame;
    }

    /**
     * Take an image and the master dark frame and apply the master dark frame to the provided image
     *
     * @param image the image that is to be processed
     * @param darkFrame the master dark frame
     * @return double array of the processed image
     */
    public double[][] applyDarkFrame(double[][] image, double[][] darkFrame) {
        double[][] results = new double[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                //With this subtraction, you can recieve negatives, but that should be ok as we assume the original
                // image could have negative values also.  We are just removing the dark frame from the image.
                results[i][j] = image[i][j] - darkFrame[i][j];
            }
        }

        return results;
    }
}
