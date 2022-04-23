#include <iostream>
#include <string>
using namespace std;

class sol0912mergesort {


public:
    void merge(int* a, int left, int right, int mid) 
    {
        int sorted[right - left  - 1];
        int i = left, j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                sorted[idx] = a[i];
                idx++;
                i++;
            } else {
                sorted[idx] = a[j];
                idx++;
                j++;
            }
        }
        while (i<= mid)
        {
            sorted[idx]=a[i];
            idx++;
            i++;
        }
        while (j<= right) 
        {
            sorted[idx] = a[j];
            idx++;
            j++;
        }
        for (int k = left, q = 0; k <= right; k++, q++) 
        {
            a[k] = sorted[q];
        }
    }


    void mergesort(int* a, int left, int right) 
    {
        if (left < right) 
        {
            int mid = (left + right) / 2;
            mergesort(a, left, mid);
            mergesort(a, mid + 1, right);
            merge(a,left,right,mid);
        }
        return;
    }


    void printArray(int a[], int length) 
    {
        for (int i = 0; i < length; i++) 
        {
            cout << a[i] << " ";
        }
        cout << endl;
    }

    // int main() {
    //     int n[] = {1,3,5,6};
    //     int length_n=sizeof(n)/sizeof(int);
    //     mergesort(n, 0, length_n-1);
    //     printArray(n, length_n);
    //     return 0;
    // }
};

int main() {
    int n[] = {3,5,6,1};
    int* a=n;
    int length_n=sizeof(n)/sizeof(int);
    sol0912mergesort sol;
    sol.printArray(n, length_n);
    sol.mergesort(a, 0, length_n-1);
    sol.printArray(n, length_n);
    return 0;
};
