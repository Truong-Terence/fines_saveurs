package com.example.fines_saveurs.service;

import com.example.fines_saveurs.util.Image;
import com.example.fines_saveurs.util.Path;
import jakarta.servlet.ServletOutputStream;

import java.io.*;

public class ImageService {

    public void readImage(String imageFileName, ServletOutputStream out) throws IOException {
        String origin = new Path().getProjectPath() + "/product-images/" + imageFileName;

        try (FileInputStream fin = new FileInputStream(origin);
             BufferedInputStream bin = new BufferedInputStream(fin);
             BufferedOutputStream bout = new BufferedOutputStream(out);) {
                int ch = 0;
                while((ch = bin.read()) != -1) {
                    bout.write(ch);
                }
        }
    }

    public void saveImage(InputStream inputFile, String imageName) {
        String projectPath = new Path().getProjectPath();
        String pathFromRepoRoot = "/product-images/";
        String imagePath = projectPath + pathFromRepoRoot + imageName;
        int[][] imageData = Image.imgToTwoD(inputFile);
        Image.twoDToImage(imageData, imagePath);
    }

}
