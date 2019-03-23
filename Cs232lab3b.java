package cs232lab3b;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.nio.file.Paths;

public class Cs232lab3b {

    public static void main(String[] args) {
        
        ArrayList<String> keys;           
        ArrayList<String> values = null;        
        
        HashMap<String, String> row;       

        String line, header;
        
        ArrayList<HashMap<String, String>> data = new ArrayList<>(); // Create ArrayList to hold HashMaps for all rows
        
        try {            

            Scanner in = new Scanner(Paths.get("lab03b_input.csv"), "UTF-8");         
            
            header = in.nextLine();
            keys = new ArrayList(Arrays.asList(header.split(",")));
            
            while ( in.hasNextLine() ) {
                
                line = in.nextLine();
                
                row = new HashMap<>();
                
                values = new ArrayList(Arrays.asList(line.split(",")));
                
                for (int i = 0; i < keys.size(); i++) {
                    
                    row.put(keys.get(i), values.get(i));
                    
                }
                
                data.add(row);

            }
            
            System.out.println("Number of records read: " + data.size());
            
            in.close();
            
            System.out.println();
            
            for (int i = 0; i < data.size(); ++i) {
                row = (HashMap)data.get(i);
                
                System.out.println(row.getOrDefault(keys.get(0), values.get(0)) + " " + row.getOrDefault(keys.get(1), values.get(1)) + " " + row.getOrDefault(keys.get(2), values.get(2)));
                System.out.println(row.getOrDefault(keys.get(3), values.get(3)));
                System.out.println(row.getOrDefault(keys.get(4), values.get(4)) + " " + row.getOrDefault(keys.get(5), values.get(5)) + " " + row.getOrDefault(keys.get(6), values.get(6)));
                System.out.println();
                
            }
                      
        }
        
        catch (Exception e) {
            
            System.err.println(e.toString());
            
        }
        
    }

}