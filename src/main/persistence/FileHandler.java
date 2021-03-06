package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CipherSequence;
import model.Encoder;
import model.ciphers.Cipher;

import java.io.*;
import java.lang.reflect.Type;

/**
 * Represents the single instance file handler
 *
 * @author Jason Hsu
 */
public class FileHandler {
    public static final String DATA_FOLDER = "./data/";
    /**
     * The file extension to write
     */
    public static final String FILE_EXT = ".json";

    /**
     * Singleton instance
     */
    private static FileHandler singleton;
    private Gson gson;

    /**
     * MODIFIES: this
     * EFFECTS: Initializes gson
     */
    private FileHandler() {
        gson = new GsonBuilder()
        .registerTypeAdapter(Cipher.class,
                new SerializationHandler())
                .create();
    }

    /**
     * MODIFIES: this
     * EFFECTS: Returns the FileHandler, or a new one if it does not already exist
     * @return The singleton instance of this
     */
    public static FileHandler getInstance() {
        if (singleton != null) {
            return singleton;
        }

        singleton = new FileHandler();
        return singleton;
    }

    /**
     * REQUIRES: A filepath
     * EFFECTS: Converts a file's contents to a encoder
     * @param path The filepath.
     * @return The encoder loaded from file.
     * @throws IOException Problem loading encoder.
     */
    public Encoder loadEncoder(String path) throws IOException, ClassNotFoundException {
        if (path.contains("Cipher")) {
            if (path.contains(Cipher.ARG_DELIM)) {
                return gson.fromJson(readFile(path),
                        (Type) Class.forName("model.ciphers." + path.substring(0, path.indexOf(Cipher.ARG_DELIM))));
            } else {
                return gson.fromJson(readFile(path),
                        (Type) Class.forName("model.ciphers." + path));
            }
        } else {
            return gson.fromJson(readFile(path), CipherSequence.class);
        }
    }

    /**
     * REQUIRES: The encoder of the same name is not already saved.
     * MODIFIES: filesystem
     * EFFECTS: Saves a encoder to a new file.
     * @param encoder The encoder to be saved.
     * @throws IOException Problem saving encoder
     */
    public void saveEncoder(Encoder encoder) throws IOException {
        writeFile(encoder.toString(), gson.toJson(encoder));
    }

    /**
     * REQUIRES: A valid new filename.
     * MODIFIES: filesystem
     * EFFECTS: Writes some text to a file.
     * @param fileName The filename.
     * @param text The text to save.
     * @throws IOException Problem writing to file.
     */
    private void writeFile(String fileName, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(DATA_FOLDER + fileName + FILE_EXT);
        fileWriter.write(text);
        fileWriter.close();
    }

    /**
     * REQUIRES: A valid filename.
     * EFFECTS: Reads the contents of a file.
     * @param fileName The file to read.
     * @return The file's contents
     * @throws IOException Problem reading from file.
     */
    private String readFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA_FOLDER + fileName + FILE_EXT));
        StringBuilder result = new StringBuilder();
        String line;
        while (true) {
            line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            result.append(line);
        }
        return result.toString();
    }
}
