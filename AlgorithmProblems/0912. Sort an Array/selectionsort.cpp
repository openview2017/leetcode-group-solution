#include <iostream>
#include <string>
#include<vector>
using namespace std;

class SelectionSort {
 public:
  vector<int> solve(vector<int> array) {
    // write your solution here
    int len = array.size();
    for (int i = 0; i < len; i++) {
      int step = i;
      for (int j = step+1; j < len; j++) {
        if (array[j] < array[step]) {
          step = j;
        }
      }
      swap(&array[i], &array[step]);
    }
    return array;
  }

 void swap(int* a, int* b) {
   int tmp = *a;
   *a = *b;
   *b = tmp;
 }

   void printArray(vector<int> array) 
    {
        for (int i : array) 
        {
            cout << i << " ";
        }
        cout << endl;
    }
};



    // int main() {
    //     int n[] = {1,3,5,6};
    //     int length_n=sizeof(n)/sizeof(int);
    //     mergesort(n, 0, length_n-1);
    //     printArray(n, length_n);
    //     return 0;
    // }

int main() {
    vector<int> vect{3,5,6,1};
    SelectionSort sol;
    sol.printArray(vect);
    vect = sol.solve(vect);
    sol.printArray(vect);
    return 0;
};