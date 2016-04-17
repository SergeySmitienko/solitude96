package com.tsystems.javaschool.tasks;
import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DuplicateFinderImpl implements DuplicateFinder {
    @Override
    public boolean process(File sourceFile, File targetFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile)); // Create buffered stream for reading
            String line;                                                            // Variable for read one string from input file
            Map<String,Integer> lines = new TreeMap<>();                            // Collection for storage strings
            while ((line = reader.readLine())!= null){                              // Check if a string have already added
                if (lines.containsKey(line))
                    lines.put(line,lines.get(line) + 1);                            // Integer(value)++
                else
                    lines.put(line,1);                                              // First string with this Key
            }
            reader.close();                                                         // Closing file...

            if (!targetFile.exists()){                                              // Checking file exist for write
                targetFile.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile,true)); // Create buggered stream for writing

            Iterator<Map.Entry<String,Integer>> iterator= lines.entrySet().iterator();
            while (iterator.hasNext()){                                                  // Writing strings in file
                Map.Entry entry = iterator.next();
                writer.write(entry.getKey().toString()+"[");
                writer.write(entry.getValue().toString()+"]");
                writer.newLine();

            }
            writer.flush();                                                          // Flushing buffers and closing file...
            writer.close();
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }


        return true;
    }
}
