package test;

import java.io.File;

/**
 * Created by abrasha on 11/13/15.
 */
public class FileAccessor {

    public static File getFile(String name) throws Exception {

        File file = new File("src/main/resources/" + name);
        if (!file.exists()){
            file.createNewFile();
        }

        return file;

    }

}
