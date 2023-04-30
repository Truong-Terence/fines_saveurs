package com.example.fines_saveurs.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;


public class Image {

    public static int[][] imgToTwoD(InputStream inputFile) {
        try {
            BufferedImage image = ImageIO.read(inputFile);
            int imgRows = image.getHeight();
            int imgCols = image.getWidth();
            int[][] pixelData = new int[imgRows][imgCols];
            for (int i = 0; i < imgRows; i++) {
                for (int j = 0; j < imgCols; j++) {
                    pixelData[i][j] = image.getRGB(j, i);
                }
            }
            return pixelData;
        } catch (Exception e) {
            System.out.println("Failed to load image: " + e.getLocalizedMessage());
            return null;
        }
    }


    public static void twoDToImage(int[][] imgData, String filePath) {
        try {
            int imgRows = imgData.length;
            int imgCols = imgData[0].length;
            BufferedImage result = new BufferedImage(imgCols, imgRows, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < imgRows; i++) {
                for (int j = 0; j < imgCols; j++) {
                    result.setRGB(j, i, imgData[i][j]);
                }
            }
            File output = new File(filePath);
            ImageIO.write(result, "jpg", output);
        } catch (Exception e) {
            System.out.println("Failed to save image: " + e.getLocalizedMessage());
        }
    }


    public static void saveImage(InputStream inputFile, String imageName, Object servlet) {
        String imagePath = "";
        try {
            File projectDir = new File(servlet.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getParentFile().getParentFile();
            imagePath = new File(projectDir + "/src/main/webapp/images/products/" + imageName).toString();
            int[][] imageData = Image.imgToTwoD(inputFile);
            Image.twoDToImage(imageData, imagePath);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
