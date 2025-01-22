import java.util.*;

public class Q3 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToId = new HashMap<>();
        UnionFind uf = new UnionFind(accounts.size());
        int id = 0;

        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }
                uf.union(emailToId.get(firstEmail), emailToId.get(email));
            }
        }

        Map<Integer, List<String>> componentToEmails = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int root = uf.find(emailToId.get(email));
            componentToEmails.putIfAbsent(root, new ArrayList<>());
            componentToEmails.get(root).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> emails : componentToEmails.values()) {
            Collections.sort(emails);
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(emails.get(0));
            mergedAccount.addAll(emails);
            result.add(mergedAccount);
        }
        return result;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
}
