//UIUC CS125 SPRING 2017 MP. File: hello.cpp, CS125 Project: Midterm2Bonus, Version: 2017-04-01T08:17:52-0500.574983000
#include <iostream>
#include <string>

using std::string;
using std::cout;
using std::endl;

int main()
{
   cout << "Hey,";
   string mesg = "this my first C++ program";
   mesg += "!";
   cout << mesg << endl;
 
  // endl stands for 'end line'

   for(int i=0; i<10; i++) {
     cout << i*i;
     cout << endl;
   }
   return 0;
}
