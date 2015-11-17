package com.jdse.duplicatefinder;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class DuplicateFinderLauncher {

    public static void main(String args[]) {
        Path path = Paths.get(args[0]);
        Set<String> unique = new HashSet<String>();
        Set<String> dupe = new HashSet<String>();
        new DuplicateFinder().countDuplicates(path, unique, dupe);
        System.out.println("Unique sirens count: "+ unique.size());
        System.out.println("Duplicate sirens count: "+ dupe.size());
    }
}
