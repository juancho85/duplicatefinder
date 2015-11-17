package com.jdse.duplicatefinder;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class DuplicateFinderTest {

DuplicateFinder classUnderTest;
    
    @Before
    public void setUp(){
	classUnderTest = new DuplicateFinder();
    }
    
    /**
     * Test case for "only duplicates" scenario:
     * <ul>
     * <li>All siren numbers have a correct formating</li>
     * <li>Some Unique siren numbers are present</li>
     * <li>Some duplicate siren numbers are present</li>
     * </ul>
     */
    @Test
    public void standardScenarioTest()
    {
	Set<String> unique = new HashSet<String>();
        Set<String> dupe = new HashSet<String>();
	classUnderTest.countDuplicates(getFilePath("test_file_1.txt"), unique, dupe);
	assertEquals("2 unique sirens were expected.", 2, unique.size());
	assertEquals("2 duplicate sirens were expected.", 2, dupe.size());
    }
    
    
    /**
     * Test case for "all duplicates" scenario:
     * <ul>
     * <li>All siren numbers have a correct formating</li>
     * <li>No Unique siren numbers are present</li>
     * <li>1 duplicate siren number is present</li>
     * </ul>
     */
    @Test
    public void onlyDuplicatesScenarioTest()
    {
	Set<String> unique = new HashSet<String>();
        Set<String> dupe = new HashSet<String>();
	classUnderTest.countDuplicates(getFilePath("test_file_2.txt"), unique, dupe);
	assertEquals("No unique sirens were expected.", 0, unique.size());
	assertEquals("1 duplicate sirens were expected.", 1, dupe.size());
    }
    
    /**
     * Test case for "invalid entry" scenario:
     * <ul>
     * <li>1 Siren numbers has incorrect formating. That entry is ignored</li>
     * <li>2 Unique siren numbers are present</li>
     * <li>1 duplicate siren number is present</li>
     * </ul>
     */
    @Test
    public void NotNumericEntryTest()
    {
	Set<String> unique = new HashSet<String>();
        Set<String> dupe = new HashSet<String>();
	classUnderTest.countDuplicates(getFilePath("test_file_3.txt"), unique, dupe);
	assertEquals("2 unique sirens were expected.", 2, unique.size());
	assertEquals("1 duplicate sirens were expected.", 1, dupe.size());
    }
    
    /**
     * Test case for "empty file" scenario:
     * 
     * No siren numbers in the file provided.
     */
    @Test
    public void emptyFileTest()
    {
	Set<String> unique = new HashSet<String>();
        Set<String> dupe = new HashSet<String>();
	classUnderTest.countDuplicates(getFilePath("test_file_4.txt"), unique, dupe);
	assertEquals("No unique sirens were expected.", 0, unique.size());
	assertEquals("No duplicate sirens were expected.", 0, dupe.size());
    }
    
    /**
     * Test case for "all unique" scenario:
     * <ul>
     * <li>All siren numbers have a correct formating</li>
     * <li>3 unique siren numbers are present</li>
     * <li>0 duplicate siren numbers are present</li>
     * </ul>
     */
    @Test
    public void onlyUniqueTest()
    {
	Set<String> unique = new HashSet<String>();
        Set<String> dupe = new HashSet<String>();
	classUnderTest.countDuplicates(getFilePath("test_file_5.txt"), unique, dupe);
	assertEquals("3 unique sirens were expected.", 3, unique.size());
	assertEquals("0 duplicate sirens were expected.", 0, dupe.size());
    }
    
    
    public Path getFilePath(String fileName){
	ClassLoader classLoader = this.getClass().getClassLoader();
	URL url = classLoader.getResource(fileName);
	File file = new File(url.getPath());
	return Paths.get(file.getAbsolutePath());
    }
}
