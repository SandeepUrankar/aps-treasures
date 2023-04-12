
#ifdef W
    #include "k_II.h"
#else
    #include <bits/stdc++.h>
    using namespace std;
#endif
#define pb emplace_back
#define all(x) x.begin(), x.end()
#define sz(x) static_cast<int32_t>(x.size())
#include <ext/pb_ds/assoc_container.hpp>
namespace Hashing {    
    using hash_t = pair<int, uint64_t>;
    static const uint64_t FIXED_RANDOM = chrono::steady_clock::now().time_since_epoch().count();
    
    struct custom_hash {
        static uint64_t splitmix64(uint64_t x) {
            x += 0x9e3779b97f4a7c15;
            x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
            x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
            return x ^ (x >> 31);
        }
        size_t operator()(uint64_t x) const { return splitmix64(x + FIXED_RANDOM); }
        size_t operator()(const hash_t& x) const { return splitmix64(FIXED_RANDOM + x.second) ^ (splitmix64(FIXED_RANDOM + x.first) << 1); }
    };
    
    template<typename K, typename V, typename Hash = custom_hash>
    using hash_map = __gnu_pbds::gp_hash_table<K, V, Hash>;
    
    template<typename K, typename Hash = custom_hash>
    using hash_set = hash_map<K, __gnu_pbds::null_type, Hash>;
 
} using namespace Hashing;
 
const int64_t DESPACITO = 2e18;
const int INF = 2e9, MOD = 1e9+7;
const int N = 2e5 + 5;
 
int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    int i, n, cur = 0; int64_t ans = 0;
    cin >> n;
    hash_map<int, int> pref;
    pref[0] = 1;
 
    for(i = 0; i < n; i++) {
        int y; cin >> y; y %= n;
        if(y < 0) y += n;
        cur += y;
        if(cur >= n) cur -= n;
        ans += pref[cur];
        pref[cur]++;
    } cout << ans;
} // ~W 