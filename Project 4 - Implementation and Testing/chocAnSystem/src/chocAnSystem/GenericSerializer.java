package chocAnSystem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Vector;

/**
 * Class for serializing and deserializing JSON files
 *
 * @author Walter Mink
 * @version 1.0
 */
public class GenericSerializer {
    /**
     * Generic function for deserializing a JSON file into a Vector of classType objects
     *
     * @param filePath Path to JSON file to be read from stored as a string
     * @param classType Class type of objects to be deserialized
     * @return Vector of classType objects
     * @param <T> Generic type
     * @throws IOException Exception thrown if file cannot be read
     */
    public static <T> Vector<T> deserializeJsonArray(String filePath, Class<T> classType) throws IOException {
        // Create a Gson instance
        Gson gson = new Gson();
        // Create a Vector to hold the objects
        Vector<T> vector;

        // Use try-with-resources for automatic resource management
        try (FileReader reader = new FileReader(filePath)) {
            // Correctly create a Type that represents Vector<T>
            Type type = TypeToken.getParameterized(Vector.class, classType).getType();

            // Deserialize the JSON file into a Vector of classType objects
            vector = gson.fromJson(reader, type);
        }  // FileReader is automatically closed here

        return vector;
    }

    /**
     * Generic function for serializing a Vector of objects into a JSON file
     *
     * @param vector Vector of objects to be serialized
     * @param filePath Path to JSON file to be written to stored as a string
     * @param <T> Generic type
     * @throws IOException Exception thrown if file cannot be written
     */
    public static <T> void serializeJsonArray(Vector<T> vector, String filePath) throws IOException {
        // Create a Gson instance
        Gson gson = new Gson();

        // Create a FileWriter instance
        FileWriter writer = new FileWriter(filePath);

        // Serialize the vector into a JSON string
        String jsonString = gson.toJson(vector);

        // Write the JSON string to the file
        writer.write(jsonString);

        // Close the writer
        writer.close();
    }

    /**
     * Generic function for processing a JSON file
     *
     * @param filePath Path to JSON file to be processed stored as a string
     * @param newInstance New instance of the class to be processed
     * @param <T> Generic type
     */
    public static <T> void processJsonFile(String filePath, T newInstance) {
        // Create a Vector to hold the objects
        Vector<T> vector = new Vector<>();
        // Create a File object
        File file = new File(filePath);

        // Check if the file exists
        if (file.exists()) {
            // Deserialize the existing JSON file into a Vector of objects
            try {
                vector = deserializeJsonArray(filePath, (Class<T>) newInstance.getClass());
            } catch (IOException e) {
                e.printStackTrace();
                // Handle exceptions or return from the method
            }
        }

        // Add the provided instance to the Vector (either new or deserialized)
        vector.add(newInstance);

        // Serialize the Vector back into a JSON file
        try {
            serializeJsonArray(vector, filePath);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions or return from the method
        }
    }
}
