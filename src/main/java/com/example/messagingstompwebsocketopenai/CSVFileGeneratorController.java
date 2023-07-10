package com.example.messagingstompwebsocketopenai;

import com.opencsv.CSVWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CSVFileGeneratorController {

    /*
    The code generates a CSV file and sends it as a response to the client.
     */
    @GetMapping("/generate-csv")
    public void generateCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"my-csv-file.csv\"");

//        CSVWriter writer = new CSVWriter(new FileWriter("my-csv-file.csv"));
        CSVWriter writer = new CSVWriter(response.getWriter());
        String[] header = {"Column 1", "Column 2", "Column 3"};
        writer.writeNext(header);

        String[] data1 = {"Data 1", "Data 2", "Data 3"};
        writer.writeNext(data1);

        String[] data2 = {"Data 4", "Data 5", "Data 6"};
        writer.writeNext(data2);

        writer.close();
    }
}
