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


int main() {
    vector<int> vect{3,5,6,1};
    SelectionSort sol;
    sol.printArray(vect);
    vect = sol.solve(vect);
    sol.printArray(vect);
    return 0;
};