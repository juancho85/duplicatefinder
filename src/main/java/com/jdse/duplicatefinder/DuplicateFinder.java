package com.jdse.duplicatefinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Stream;

public class DuplicateFinder 
{
    public void countDuplicates(Path path, Set<String> unique,  Set<String> dupe){
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s ->  {
        	if(unique.contains(s)){
        	    dupe.add(s);
        	    unique.remove(s);
        	}else if(!dupe.contains(s) && s!=null && s.matches("\\d{9}")){
        	    unique.add(s);
        	}
            });
        } catch (IOException ex) {
            System.out.println("The file could not be read. Please check that the path provided is correct and that you have rights to read the file.");
        }
    }
}
