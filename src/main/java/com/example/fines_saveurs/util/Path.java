package com.example.fines_saveurs.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Path {

    public String getProjectPath() {
        String projectPath = "";
        try {
            String path = this.getClass().getClassLoader().getResource("").getPath();
            String decodedPath = URLDecoder.decode(path, StandardCharsets.UTF_8);
            String[] pathArr = decodedPath.split("/target/");
            projectPath = pathArr[0];
        } catch (NullPointerException error) {
            error.printStackTrace();
        }
        return projectPath;
    }

}
