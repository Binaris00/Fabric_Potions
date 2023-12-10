package binaris.fabric_potions.config;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Config {
    /**ID or mod folder, this can be no used**/
    public String id;
    /**File name**/
    public String name;
    public File file;
    /**If the config is on a folder**/
    public boolean onFolder;
    private static final HashMap<String, String> config = new HashMap<>();
    private final List<String> writeList = new ArrayList<>();


    public Config(String id, String name, boolean onFolder){
        this.id = id;
        this.name = name;
        this.onFolder = onFolder;
    }
    /**
     * Create the config folder if this doesn't exist (also with the mod folder if onFolder it's true)
     * Create the file if this doesn't exist and write the content
     * Read all the config content
     * */
    public void load() {
        try {
            File folder = new File("./config/");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            if (onFolder) {
                folder = new File("./config/" + id + "/");

                if (!folder.exists()) {
                    folder.mkdirs();
                }

                file = new File("./config/" + id + "/" + name + ".properties");
                createFile(file);
            } else {
                file = new File("./config/" + name + ".properties");
                createFile(file);
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Add a new value to the config information
     * @param key special word to save and get the value
     * @param value the value to save
     * */
    public void set(String key, Object value){
        writeList.add(key + " = " + value + " #[default: " + value + "]");
        config.put(key, String.valueOf(value));
    }
    /** add a comment to the config
     * @param comment the comment to add
     * */
    public void addComment(String comment){
        writeList.add("# " + comment);
    }

    /** add an empty line to the config
     * */
    public void emptyLine(){
        writeList.add("\n");
    }

    /**
     * Check the config and return a bool value depending on the key
     * @param key special word to search a value
     * @return the bool value got for the config, return false if this is null
     * */
    public static boolean getBool(String key){
        return Objects.equals(config.get(key), "true");
    }

    /** Check the config and return an int value depending on the key
     * @param key special word to search a value
     * @return the int value got for the config, throw a runtimeException if this gets any error
     * */
    public static int getInt(String key){
        try {
            return Integer.parseInt(config.get(key));
        }  catch (Exception e){
            throw new RuntimeException("Error loading the config for: " + key);
        }
    }
    /** Check the config and return a double value depending on the key
     * @param key special word to search a value
     * @return the bool value got for the config, throw a runtimeException if this gets any error
     * */
    public static double getDouble(String key){
        try {
            return Double.parseDouble(config.get(key));

        } catch (Exception e){
            throw new RuntimeException("Error loading the config for: " + key);
        }
    }
    /** Check the config and return a string value depending on the key
     * @param key special word to search a value
     * @return the string value got for the config
     * */
    public static String getString(String key){return config.get(key);}
    /** Check the config and return a float value depending on the key
     * @param key special word to search a value
     * @return the float value got for the config, throw a runtimeException if this gets any error
     * */
    public static float getFloat(String key){
        try {
            return Float.parseFloat(config.get(key));
        }catch (Exception e){
            throw new RuntimeException("Error loading the config for: " + key);
        }
    }
    /** Convert the entry data to put it on the config data
     * @param entry the line from the config file
     * @param line the current line number from the config file, just in case if this throws a runtime exception
     *
     * */
    private void parseConfig(String entry, int line) {
        if (!entry.isEmpty() && !entry.startsWith("# ")) {
            String[] parts = entry.split(" = ", 2);
            if (parts.length == 2) {
                String temp = parts[1].split(" #")[0];
                config.put(parts[0], temp);
            } else {
                throw new RuntimeException("Syntax error in config file on line " + line + "!");
            }
        }
    }
    /** Create and write the file if this doesn't exist
     * @param file the file in the mod folder or in the config folder
     * */
    private void createFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();

            FileWriter writer = new FileWriter(file);
            for (String value : writeList) {
                writer.write(value + "\n");
            }
            writer.close();
        } else {
            Scanner reader = new Scanner(file);

            for (int line = 1; reader.hasNextLine(); line++) {
                parseConfig(reader.nextLine(), line);
            }
        }
    }
}
