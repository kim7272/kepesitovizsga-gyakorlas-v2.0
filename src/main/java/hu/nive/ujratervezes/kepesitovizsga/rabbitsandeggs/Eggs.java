package hu.nive.ujratervezes.kepesitovizsga.rabbitsandeggs;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Eggs {

    public static final String DATA = "src/main/resources/eggs.csv";


    public Rabbit getRabbitWithMaxEggs() {
        Rabbit rabbit = null;
        Path path = Path.of(DATA);
        int max = Integer.MIN_VALUE;
        String nameForMax = "";
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(";");

                if (Integer.parseInt(parts[1]) > max) {
                    max = Integer.parseInt(parts[1]);
                    nameForMax = parts[0];
                }
            }
            rabbit = new Rabbit(nameForMax, max);

        } catch (IOException e) {
            throw new IllegalStateException("Can not read file!", e);
        }
        return rabbit;
    }
}
