#include <iostream>
#include <string>
#include<vector>
using namespace std;


class main0069 {
public:
  int mySqrt(int x) {      
    long l = 1;
    long r = static_cast<long>(x) + 1; // !!!! overflow
    while (l < r) {
      long m = l + (r - l) / 2;
      if (m * m > x) { 
        r = m;
      } else {
        l = m + 1;
      }
    }
    // l: smallest number such that l * l > x
    return l - 1;
  }
};

int main() {
    main0069 sol;
    int x = 4;
    int res = sol.mySqrt(x);
    cout << res;
}