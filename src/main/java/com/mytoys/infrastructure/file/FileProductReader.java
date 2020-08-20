package com.mytoys.infrastructure.file;

import com.mytoys.domain.model.product.Product;
import com.mytoys.domain.model.service.ProductReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FileProductReader implements ProductReader {

    private static Map<Long, Product> productMap = new HashMap<>();

    static {
        try {
            Reader in = new InputStreamReader(FileProductReader.class.getResourceAsStream("/products_csv.csv"));
            Iterable<CSVRecord> records = CSVFormat.EXCEL
                    .withHeader("ID", "NAME", "PRICE", "OLD_PRICE", "STOCK", "BRAND")
                    .withDelimiter(';')
                    .withSkipHeaderRecord(true)
                    .parse(in);
            records.forEach(record -> {
                Long id = Long.parseLong(record.get("ID"));
                String name = record.get("NAME");
                Float price = Float.parseFloat(record.get("PRICE"));
                Float oldPrice = Float.parseFloat(record.get("PRICE"));
                Integer stock = Integer.parseInt(record.get("STOCK"));
                String brand = record.get("BRAND");

                Product product = new Product(id, name, price, oldPrice, stock, brand);

                productMap.put(product.getId(), product);
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> readAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(Long id) {
        return productMap.get(id);
    }
}
