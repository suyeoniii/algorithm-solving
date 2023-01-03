#include <iostream>
#include <algorithm>

using namespace std;

int m[1000001];

int dp(int n){
    if(m[n]==0){
        if(dp(n-2)==-1){
            m[n] = dp(n-5) +1;
        }
        else if(dp(n-5)==-1){
            m[n] = dp(n-2) +1;
        }
        else{
            m[n] = min(dp(n-2),dp(n-5))+1;
        }
    }
    return m[n];
}

int main(){
    int n;
    cin>>n;

    m[0] = -1;
    m[1] = -1;
    m[2] = 1;
    m[3] = -1;
    m[5] = 1;


    cout<<dp(n);
}