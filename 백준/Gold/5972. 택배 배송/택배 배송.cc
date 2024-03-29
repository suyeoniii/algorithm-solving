#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>

using namespace std;



int main(){

    vector<pair<int, int>> v[50001];
    int dist[50001];

    int N, M;
    cin>>N>>M;

    for(int i = 0; i<M; i++){
        int s, e, d;
        cin>>s>>e>>d;

        v[s].push_back(make_pair(e, d));
        v[e].push_back(make_pair(s, d));
    }

    //배열을 큰 값으로 초기화
    memset(dist, 0x7f, sizeof(dist));
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    //시작 노드 추가
    pq.push({0, 1});
    dist[1] = 0;

    while(!pq.empty()){
        int index = pq.top().second;
        int cost = pq.top().first;

        pq.pop();

        if(dist[index] != cost) continue;

        for(int i = 0; i<v[index].size(); i++){
            int next = v[index][i].first;
            int w = v[index][i].second;

            if(dist[next] > dist[index] + w){
                dist[next] = dist[index] + w;
                pq.push(make_pair(dist[next], next));
            }
        }
    }

    cout<<dist[N];
}