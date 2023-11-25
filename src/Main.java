/* Main.java
 * last edited 8 7 23 by Zack A
 *
 * This application demonstrates heap sort and timing a heap sort that sorts 1 million
 * randomly generated integers, each up to 5 digits long.
 *
 * It uses the system function nanoTime() to read the system clock in nanoseconds,
 * once before the sort starts ande once after it ends. It subtracts the end time from
 * the start time to ge the elapsed time in nanoseconds.  This is divided by 1 billion to
 * get the time in seconds.
 *
 * The randomly generated array is written to a data file before the sort and again after the sort.
 * The sorted list in the file "after.txt" can be visually inspected or otherwise
 * tested for correctness.
 *
 * This code is written for clarity.  Changes can be made to improve efficiency.
 */

public class Main {
    public static void main(String[] arg) throws Exception{
        for (int k = 1; k<= 100; k++)
        {
            int size = 1000000;     // change this number to change the size of the random array
            int[] a = new int[size];
            int[] temp = new int[a.length];  // empty temporary array, the same size and type as a[]

            // fill the array with random integers
            for (int i = 0; i< a.length; i++)
                a[i] = (int)(Math.random()*100000 +1);

            // write the array to a data file
            // WARNING the text file will be 5.7 MB for 1 million items
            writeLines(a, "before.txt");

            // get the start time in nanoseconds
            long startTime = System.nanoTime();

            // call heap sort to sort the entire array
            heapSort(a);

            // get the end time in nanoseconds
            long endTime = System.nanoTime();

            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            // print the elapsed time in seconds   (nanoseconds/ 1 billion)
            System.out.printf("%12.8f %n", (double)duration/1.0E+09) ;

            // write the sorted array to a data file
            // WARNING the file will be 5.7 MB for 1 million items
            writeLines(a, "after.txt");
        }
    }// end main()


    // *************************************************************

    /* This method writes an int array to a text data file.
     * The first parameter is the array. The second parameter
     * is the file name.
     */
    public static void writeLines(int[] a, String fileName) throws Exception {
        // create a File class object with the given file name
        java.io.File out = new java.io.File(fileName);
        // Create a PrintWriter output stream and link it to the File object
        java.io.PrintWriter outfile = new java.io.PrintWriter(out);

        // write the elements of an int array, separated by spaces
        for (int i = 0; i < a.length; i++)
            outfile.print(a[i] + " ");

        // print a newline at the end of the list of integers
        outfile.println();

        outfile.close();

    } // end writeTextArray()

    /* **************************************************************** */

    /*
     * This method sorts according to taking a set of data
     * items and insert them into a heap one at a time,
     * then extract them one at a time, putting them back into the set
     * in the order in which they are  extracted.
     */
    public static void heapSort(int[] a) {
        // instantiate a heap to be used for sorting
        Heap myHeap = new Heap(a.length);
        // iterate the array, inserting each element into the heap one at a time
        for (int i = 0; i < a.length; i++) {
            myHeap.insert(a[i]);
        } // end for ()
        // iterate the array, extracting each element from the heap into the array one a time
        for (int i = 0; i < a.length; i++) {
            a[i] = myHeap.extract();
        } // end for ()
    } // end heapSort()
} // end Main
