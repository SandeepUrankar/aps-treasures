
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
    int i, j, n, ans = 0;
    cin >> n;
    vector<int> a(n);
    for(auto& x: a) cin >> x;
    set<int> have;
    for(i = j = 0; i < n; i++) {
        while(j < n and !have.count(a[j]))
            have.insert(a[j++]);
        ans = max(ans, j-i);
        have.erase(a[i]);
    } cout << ans;
} // ~W 