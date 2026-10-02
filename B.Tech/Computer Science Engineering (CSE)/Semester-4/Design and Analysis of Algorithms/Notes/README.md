# DSA 4th Semester Mid-Term Practical Solutions

This repository contains solutions for the Data Structures and Algorithms (DSA) practical exam for 4th semester B.Tech students. The solutions are organized week-wise and include various searching, sorting, graph, and dynamic programming algorithms.

## Student Information
- **Name:** Aditya Pandey  
- **Semester:** 4th  
- **Branch:** B.Tech (CSE)  
- **Course:** Data Structures and Algorithms  
- **Instructor:** Suraj Sir  

## Repository Structure

### Week 1: Searching Algorithms
1. Linear Search Implementation  
2. Binary Search Implementation  
3. Jump Search Implementation  

### Week 2: Advanced Searching Algorithms
1. Binary Search with Duplicate Elements  
2. Finding Three Indices (i, j, k) such that `arr[i] + arr[j] = arr[k]`  
3. Counting Pairs with Given Difference  

### Week 3: Basic Sorting Algorithms
1. Insertion Sort with Comparisons and Shifts  
2. Selection Sort with Comparisons and Swaps  
3. Duplicate Element Detection using Sorting  

### Week 4: Advanced Sorting Algorithms
1. Merge Sort with Comparisons and Inversions  
2. Quick Sort with Random Pivot  
3. Kth Smallest/Largest Element Finding  

### Week 5: Special Problems
1. Maximum Occurring Alphabet  
2. Pair Sum Problem  
3. Common Elements in Two Sorted Arrays  

### Week 6: Graph Algorithms
- Path Existence Check using DFS
- Bipartite Graph Check using BFS
- Cycle Detection in Directed Graph

### Week 7: Shortest Path Algorithms
- Dijkstra's Algorithm
- Bellman-Ford Algorithm
- Shortest Path with K Edges

### Week 8: Minimum Spanning Tree Algorithms
- Prim's Algorithm
- Kruskal's Algorithm
- Maximum Spanning Tree

### Week 9: Advanced Graph Algorithms and Greedy Problems
- Floyd-Warshall Algorithm
- Fractional Knapsack
- File Merging

### Week 10: Activity Selection and Task Scheduling
- Activity Selection
- Task Scheduling with Deadlines
- Majority Element and Median

### Week 11: Dynamic Programming Problems
- Matrix Chain Multiplication
- Coin Change
- Equal Sum Partition

## Input/Output Format

### Searching Problems (Week 1 & 2):
```
Input:
T (number of test cases)
For each test case:
n (size of array)
n space-separated integers
key (element to search)

Output:
For each test case:
"Present" or "Not Present"
Number of comparisons
```

### Sorting Problems (Week 3 & 4):
```
Input:
T (number of test cases)
For each test case:
n (size of array)
n space-separated integers

Output:
For each test case:
Sorted array
Number of comparisons
Number of swaps/shifts/inversions
```

### Graph and Dynamic Programming Problems (Week 6-11):
Each program follows a specific input/output format as described in the respective week's README.md file. Please refer to those files for detailed information about:
- Input format
- Output format
- Example test cases
- Time and space complexities

## How to Use

1. **Clone the repository:**
```bash
git clone https://github.com/yourusername/dsa-4th-sem-mid-practical.git
```

2. **Navigate to the specific week's folder:**
```bash
cd week1  # or week2, week3, etc.
```

3. **Compile and run the programs:**
```bash
g++ -std=c++11 program.cpp -o program
./program
```

## Time Complexities

### Basic Algorithms (Week 1-5)
| Algorithm        | Best Case | Average Case | Worst Case |
|-----------------|-----------|-------------|------------|
| **Linear Search** | O(1) | O(n) | O(n) |
| **Binary Search** | O(1) | O(log n) | O(log n) |
| **Jump Search** | O(√n) | O(√n) | O(√n) |
| **Insertion Sort** | O(n) | O(n²) | O(n²) |
| **Selection Sort** | O(n²) | O(n²) | O(n²) |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) |

### Advanced Algorithms (Week 6-11)
Each week's README.md file contains a detailed table of time and space complexities for all implemented algorithms.

## Contributing

Feel free to contribute to this repository by:
1. **Forking** the repository
2. **Creating a new branch**
3. **Making your changes**
4. **Submitting a pull request**

## License

This project is licensed under the **MIT License** - see the LICENSE file for details.

---
**Happy Coding!** 🚀

