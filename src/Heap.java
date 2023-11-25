/*
 * Heap.java
 * Heap class that implements a heap data structure, which is a binary
 * tree that satisfies the heap property, which states that the key of
 * each node is either greater than or equal to or less than or equal to
 * the keys of its children. Contains an insert method that inserts an
 * element into the heap and maintains the heap property by using the
 * percolate method. An extract method that extracts the minimum element
 * from the heap and maintains the heap property by calling the sift method.
 * Percolate method that maintains the heap property by moving an element up
 * in the tree until it is in its correct position. A sift method that maintains
 * the heap property by moving an element down in the tree until it is in its
 * correct position.
 * last edited 8 7 23 by Zack A
 */

public class Heap {
    private int[] heapArray;
    private int size;

    public Heap(int capacity) {
        heapArray = new int[capacity + 1];
        size = 0;
    } // end Heap()

    public void insert(int data) {
        // loop that cancels insert if the heap is full
        if (size == heapArray.length - 1) {
            throw new IllegalStateException("Heap is full");
        } // end if ()
        // add the item to the end of the items in the array
        heapArray[size + 1] = data;
        size = size + 1;
        //call a percolate method to put the new item into a correct spot in the tree
        percolate(size);
    } // end void insert()

    private void percolate(int current) {
        // If the current item is not the root
        if (current > 1) {
            // if the parent < child, swap the two and repeat the recursion
            if (heapArray[current / 2] < heapArray[current]) {
                int temp = heapArray[current / 2]; // swap
                heapArray[current / 2] = heapArray[current]; // swap
                heapArray[current] = temp; // swap

                percolate(current / 2);
            } // end if ()
        } // end if ()
    } // end void percolate()

    public int extract() {
        // extract should not be called if the heap is empty
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        } // end if ()
        // retrieve the value from the root of the tree (array element 1)
        int returnValue = heapArray[1];
        // move the value from the last element in the array to the root ( position 1 in the array )
        heapArray[1] = heapArray[size];
        // decrease the size of the heap by 1.
        size = size - 1;
        // set a current pointer to the root item of the heap
        int current = 1;
        // call the sift method to maintain the heap property by sifting the heap
        sift(current);

        return returnValue;
    } // end int extract()

    private void sift(int current) {
        // if the current item has one child (if it does, it will be the left child)
        if ((current * 2) <= size && (current * 2 + 1) > size) { // if left exists and right doesn't (only left in bounds)
            // if that child's value < the current value, swap them and recursively sift down the tree
            if (heapArray[current * 2] < heapArray[current]) {
                int temp = heapArray[current]; // swap
                heapArray[current] = heapArray[current * 2]; // swap
                heapArray[current * 2] = temp; // swap
                // sift from the child
                sift(current * 2);
            } // end if ()
        } // end if ()
        // if current item has two children
        if ((current * 2 + 1) <= size) { // both left and right children exist (are in bounds)
            int smallestChild;

            // find the smallest of the two children
            if (heapArray[current * 2 + 1] < heapArray[current * 2]) { // right is smallest
                smallestChild = current * 2 + 1;
            } // end if ()
            else { // else left is smallest
                smallestChild = current * 2;
            } // end else

            // if smallestChild's value < the current value, swap them
            if (heapArray[smallestChild] < heapArray[current]) {
                int temp = heapArray[current]; // swap
                heapArray[current] = heapArray[smallestChild]; // swap
                heapArray[smallestChild] = temp; // swap
                // sift from the position previously held by the smallest child
                sift(smallestChild);
            } // end if ()
        } // end if ()
    } // end void sift()
} // end class Heap

