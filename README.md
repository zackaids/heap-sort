# heap-sort

# Overview
This application demonstrates heap sort and timing a heap sort that sorts 1 million randomly generated integers, each up to 5 digits long.

It uses the system function nanoTime() to read the system clock in nanoseconds once before the sort starts and once after it ends. It subtracts the end time fromthe start time to ge the elapsed time in nanoseconds. This is divided by 1 billion to get the time in seconds. The randomly generated array is written to a data file before the sort and again after the sort. The sorted list in the file "after.txt" can be visually inspected or otherwise tested for correctness.

# Heap
A heap is a tree-based data structure in which all the nodes of the tree are in a specific order.

Heap class that implements a heap data structure, which is a binary tree that satisfies the heap property, which states that the key of each node is either greater than or equal to or less than or equal to the keys of its children. Contains an insert method that inserts an element into the heap and maintains the heap property by using the percolate method. An extract method that extracts the minimum element from the heap and maintains the heap property by calling the sift method. Percolate method that maintains the heap property by moving an element up in the tree until it is in its correct position. A sift method that maintains the heap property by moving an element down in the tree until it is in its correct position.
