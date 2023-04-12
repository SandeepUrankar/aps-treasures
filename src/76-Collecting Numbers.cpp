
#ifdef W
    #include "k_II.h"
#else
    #include <bits/stdc++.h>
    using namespace std;
#endif
#define pb emplace_back
#define all(x) x.begin(), x.end()
#define sz(x) static_cast<int32_t>(x.size())
 
const int64_t DESPACITO = 2e18;
const int INF = 2e9, MOD = 1e9+7;
const int N = 2e5 + 5;
 
int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    int i, n, ans = 1;
    cin >> n;
    vector<int> pos(n);
    for(i = 0; i < n; i++) {
        int x; cin >> x;
        pos[--x] = i;
    }
 
    for(i = 1; i < n; i++)
        ans += pos[i] < pos[i-1];
 
    cout << ans;
} // ~W 