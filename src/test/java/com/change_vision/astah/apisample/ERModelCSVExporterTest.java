package com.change_vision.astah.apisample;

import java.io.File;
import java.net.URL;

import org.junit.Test;

public class ERModelCSVExporterTest {
    
    @Test
    public void exportERModel() throws Exception {
        URL resource = ERModelCSVExporterTest.class.getResource("/test.asta");
        String path = resource.getFile();
        File modelFile = new File(path);
        ERModelCSVExporter exporter = new ERModelCSVExporter(modelFile);
        exporter.export();
        
    }

}
