import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/////////////////////////////////////////////////////////////////////////////
//Semester:         CS400 Spring 2018
//PROJECT:          p4  DictionaryGraph
//FILES:            Graph.java, GraphADT.java, GraphProcessor.java,
//					GraphTest.java, WordProcessor.java
//
//USER:             sdwood3, adwinter, yxu368, jwindorf, zwille
//
//Instructor:       Deb Deppeler (deppeler@cs.wisc.edu)
//Bugs:             No known bugs
//Due:              April 16th, 2018
//
//2018 Apr 14, 2018 WordProcessor.java
/////////////////////////////////////////////////////////////////////////////


/**
 * This class contains some utility helper methods
 *
 * @author sapan (sapan@cs.wisc.edu)
 */
public class WordProcessor {

    /**
     * Gets a Stream of words from the filepath.
     * <p>
     * The Stream should only contain trimmed, non-empty and UPPERCASE words.
     *
     * @param filepath file path to the dictionary file
     * @return Stream<String> stream of words read from the filepath
     * @throws IOException exception resulting from accessing the filepath
     * @see <a href="http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html">java8 stream blog</a>
     */
    public static Stream<String> getWordStream(String filepath) throws IOException {
        /**
         * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html">java.nio.file.Files</a>
         * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/nio/file/Paths.html">java.nio.file.Paths</a>
         * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html">java.nio.file.Path</a>
         * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html">java.util.stream.Stream</a>
         *
         * class Files has a method lines() which accepts an interface Path object and
         * produces a Stream<String> object via which one can read all the lines from a file as a Stream.
         *
         * class Paths has a method get() which accepts one or more strings (filepath),
         * joins them if required and produces a interface Path object
         *
         * Combining these two methods:
         *     Files.lines(Paths.get(<string filepath>))
         *     produces
         *         a Stream of lines read from the filepath
         *
         * Once this Stream of lines is available, you can use the powerful operations available for Stream objects to combine
         * multiple pre-processing operations of each line in a single statement.
         *
         * Few of these features:
         * 		1. map( )      [changes a line to the result of the applied function. Mathematically, line = operation(line)]
         * 			-  trim all the lines
         * 			-  convert all the lines to UpperCase
         * 			-  example takes each of the lines one by one and apply the function toString on them as line.toString()
         * 			   and returns the Stream:
         * 			        streamOfLines = streamOfLines.map(String::toString)
         *
         * 		2. filter( )   [keeps only lines which satisfy the provided condition]
         *      	-  can be used to only keep non-empty lines and drop empty lines
         *      	-  example below removes all the lines from the Stream which do not equal the string "apple"
         *                 and returns the Stream:
         *      			streamOfLines = streamOfLines.filter(x -> x != "apple");
         *
         * 		3. collect( )  [collects all the lines into a java.util.List object]
         * 			-  can be used in the function which will invoke this method to convert Stream<String> of lines to List<String> of lines
         * 			-  example below collects all the elements of the Stream into a List and returns the List:
         * 				List<String> listOfLines = streamOfLines.collect(Collectors::toList);
         *
         * Note: since map and filter return the updated Stream objects, they can chained together as:
         * 		streamOfLines.map(...).filter(a -> ...).map(...) and so on
         */
        try {
            //Code we learned in class about streams
            Stream<String> stream = Files.lines(Paths.get(filepath));
            stream = stream.map(String::trim);
            stream = stream.filter(x -> x != null && !x.equals(""));
            stream = stream.map(String::toUpperCase);
            return stream;
        } catch (IOException e) {
            System.out.println("Invalid File Path");
        }
        return null;
    }

    /**
     * Adjacency between word1 and word2 is defined by:
     * if the difference between word1 and word2 is of
     * 1 char replacement
     * 1 char addition
     * 1 char deletion
     * then
     * word1 and word2 are adjacent
     * else
     * word1 and word2 are not adjacent
     * <p>
     * Note: if word1 is equal to word2, they are not adjacent
     *
     * @param word1 first word
     * @param word2 second word
     * @return true if word1 and word2 are adjacent else false
     */
    public static boolean isAdjacent(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        String longest;
        String smallest;
        int simCount = 0;

        //determines longer word
        if (length1 >= length2) {
            longest = word1;
            smallest = word2;
        } else {
            longest = word2;
            smallest = word1;
        }
        int dif = longest.length() - smallest.length();

        //returns false if length difference is >=2 or the words are the same
        if ((dif >= 2) || longest.equals(smallest)) {
            return false;
        }

        //algorithm for same-length words
        if (dif == 0) {
            for (int lcv = 0; lcv < smallest.length(); lcv++) {
                String smallBit = smallest.substring(lcv, lcv + 1);
                String largeBit = longest.substring(lcv, lcv + 1);
                //if strings have same characters at a location, increment counter
                if (smallBit.equals(largeBit)) {
                    simCount++;
                }
            }
            if (simCount >= smallest.length() - 1) {
                return true;
            }
        } else {
            //Algorithm for different length words
            int cnt = 0;
            for (int lcv = 0; lcv < smallest.length() + 1; lcv++) {
                String smallBit = smallest.substring(cnt, cnt + 1);
                String largeBit = longest.substring(lcv, lcv + 1);
                if (smallBit.equals(largeBit)) {
                    simCount++;
                    if (cnt + 1 == smallest.length()) {
                        break;
                    }
                    cnt++;
                    //if characters arent the same, skip ahead in the smaller word to maintain
                    // location accuracy
                } else if (cnt + 2 < smallBit.length() - 1) {
                    cnt += 2;
                }
            }
            if (simCount >= smallest.length()) {
                return true;
            }
        }
        return false;
    }
}
