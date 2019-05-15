import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DarkFrameProcessorTest {
    private static final double DELTA = 1e-15;

    DarkFrameProcessor dfp = new DarkFrameProcessor();

    @Test
    public void testSimpleAverage() {
        double[][] image = new double[2][2];
        image[0][0] = 1.0;
        image[0][1] = 1.0;
        image[1][0] = 1.0;
        image[1][1] = 1.0;

        assertEquals(1.0, dfp.getAveragePixelValue(image), DELTA);
    }

    @Test
    public void testComplexAverage() {
        double[][] image = new double[4][3];
        image[0][0] = 0.55;
        image[0][1] = 1.78;
        image[0][2] = 5.24;
        image[1][0] = 2.25;
        image[1][1] = 2.46;
        image[1][2] = 3.47;
        image[2][0] = 6.04;
        image[2][1] = 3.02;
        image[2][2] = 1.43;
        image[3][0] = 2.47;
        image[3][1] = 0.36;
        image[3][2] = 4.54;

        assertEquals(2.8008333333333333, dfp.getAveragePixelValue(image), DELTA);
    }

    @Test
    public void testSimpleMinMax() {
        double[][] image = new double[2][2];
        image[0][0] = 1.0;
        image[0][1] = 1.0;
        image[1][0] = 1.0;
        image[1][1] = 1.0;

        assertEquals(1.0, dfp.getMaxPixelValue(image), DELTA);
        assertEquals(1.0, dfp.getMinPixelValue(image), DELTA);
    }

    @Test
    public void testComplexMinMax() {
        double[][] image = new double[4][3];
        image[0][0] = 0.55;
        image[0][1] = 1.78;
        image[0][2] = 5.24;
        image[1][0] = 2.25;
        image[1][1] = 2.46;
        image[1][2] = 3.47;
        image[2][0] = 6.04;
        image[2][1] = 3.02;
        image[2][2] = 1.43;
        image[3][0] = 2.47;
        image[3][1] = 0.36;
        image[3][2] = 4.54;

        assertEquals(6.04, dfp.getMaxPixelValue(image), DELTA);
        assertEquals(0.36, dfp.getMinPixelValue(image), DELTA);
    }

    @Test
    public void testCreateSimpleDarkFrame() {
        double[][] image = new double[2][2];
        image[0][0] = 1.0;
        image[0][1] = 1.0;
        image[1][0] = 1.0;
        image[1][1] = 1.0;

        List<double[][]> images = new ArrayList<>();
        images.add(image);
        images.add(image);

        double[][] darkImage = dfp.createDarkFrame(images);

        assertEquals(1.0, dfp.getAveragePixelValue(darkImage), DELTA);
    }

    @Test
    public void testCreateComplexImage() {
        double[][] image1 = new double[4][3];
        image1[0][0] = 0.55;
        image1[0][1] = 1.78;
        image1[0][2] = 5.24;
        image1[1][0] = 2.25;
        image1[1][1] = 2.46;
        image1[1][2] = 3.47;
        image1[2][0] = 6.04;
        image1[2][1] = 3.02;
        image1[2][2] = 1.43;
        image1[3][0] = 2.47;
        image1[3][1] = 0.36;
        image1[3][2] = 4.54;

        double[][] image2 = new double[4][3];
        image2[0][0] = 1.25;
        image2[0][1] = 3.48;
        image2[0][2] = 2.44;
        image2[1][0] = 0.25;
        image2[1][1] = 1.47;
        image2[1][2] = 2.37;
        image2[2][0] = 4.14;
        image2[2][1] = 1.42;
        image2[2][2] = 0.75;
        image2[3][0] = 1.64;
        image2[3][1] = 3.664;
        image2[3][2] = 1.554554;

        double[][] image3 = new double[4][3];
        image3[0][0] = 1.5;
        image3[0][1] = 4.7845;
        image3[0][2] = 8.2;
        image3[1][0] = 3.255456;
        image3[1][1] = 4.444554;
        image3[1][2] = 2.45545;
        image3[2][0] = 4.5452;
        image3[2][1] = 1.54515;
        image3[2][2] = 2.4;
        image3[3][0] = 1.47545;
        image3[3][1] = 5.54;
        image3[3][2] = 1.54;

        List<double[][]> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);

        double[][] darkFrame = dfp.createDarkFrame(images);

        assertEquals(2.7701198333333337, dfp.getAveragePixelValue(darkFrame), DELTA);
    }

    @Test
    public void testApplySimpleDarkFrame() {
        double[][] image = new double[2][2];
        image[0][0] = 1.0;
        image[0][1] = 1.0;
        image[1][0] = 1.0;
        image[1][1] = 1.0;

        List<double[][]> images = new ArrayList<>();
        images.add(image);
        images.add(image);

        double[][] processImage = new double[2][2];
        processImage[0][0] = 5.0;
        processImage[0][1] = 5.0;
        processImage[1][0] = 5.0;
        processImage[1][1] = 5.0;

        double[][] darkImage = dfp.createDarkFrame(images);

        double[][] finalImage = dfp.applyDarkFrame(processImage, darkImage);

        assertEquals(4.0, dfp.getAveragePixelValue(finalImage), DELTA);
    }

    @Test
    public void testApplyComplexDarkFrame() {
        double[][] image1 = new double[4][3];
        image1[0][0] = 0.55;
        image1[0][1] = 1.78;
        image1[0][2] = 5.24;
        image1[1][0] = 2.25;
        image1[1][1] = 2.46;
        image1[1][2] = 3.47;
        image1[2][0] = 6.04;
        image1[2][1] = 3.02;
        image1[2][2] = 1.43;
        image1[3][0] = 2.47;
        image1[3][1] = 0.36;
        image1[3][2] = 4.54;

        double[][] image2 = new double[4][3];
        image2[0][0] = 1.25;
        image2[0][1] = 3.48;
        image2[0][2] = 2.44;
        image2[1][0] = 0.25;
        image2[1][1] = 1.47;
        image2[1][2] = 2.37;
        image2[2][0] = 4.14;
        image2[2][1] = 1.42;
        image2[2][2] = 0.75;
        image2[3][0] = 1.64;
        image2[3][1] = 3.664;
        image2[3][2] = 1.554554;

        double[][] image3 = new double[4][3];
        image3[0][0] = 1.5;
        image3[0][1] = 4.7845;
        image3[0][2] = 8.2;
        image3[1][0] = 3.255456;
        image3[1][1] = 4.444554;
        image3[1][2] = 2.45545;
        image3[2][0] = 4.5452;
        image3[2][1] = 1.54515;
        image3[2][2] = 2.4;
        image3[3][0] = 1.47545;
        image3[3][1] = 5.54;
        image3[3][2] = 1.54;

        double[][] processedImage = new double[4][3];
        processedImage[0][0] = 50.545;
        processedImage[0][1] = 70.75;
        processedImage[0][2] = 16.2;
        processedImage[1][0] = 14.155;
        processedImage[1][1] = 8.4444;
        processedImage[1][2] = 45.445;
        processedImage[2][0] = 16.542;
        processedImage[2][1] = 25.545;
        processedImage[2][2] = 24.25445;
        processedImage[3][0] = 60.4755;
        processedImage[3][1] = 54.54;
        processedImage[3][2] = 25.54;

        List<double[][]> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);

        double[][] darkFrame = dfp.createDarkFrame(images);

        double[][] finalImage = dfp.applyDarkFrame(processedImage, darkFrame);

        assertEquals(31.599576, dfp.getAveragePixelValue(finalImage), DELTA);
    }
}