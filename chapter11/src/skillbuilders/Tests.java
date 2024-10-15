

/* Reserved for testing; not an actual skillbuilder */

package skillbuilders;

import java.io.*;


public class Tests {
    public static void main(String[] args) {
        try {
            File textFile = new File("newfile.txt");
            if (textFile.createNewFile()) {
                System.out.println("File created: " + textFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while trying to create the file.");
            e.printStackTrace();
        }
    }
}

