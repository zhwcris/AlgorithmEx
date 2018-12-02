import java.util.*;

public class ShoppingOffers {
    private static class Tuple {
        int code;
        int p;
        int sIndex;
        private Tuple(int code, int p, int sIndex) {
            this.code = code;
            this.p = p;
            this.sIndex = sIndex;
        }
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {//bfs nice
        int ret = Integer.MAX_VALUE;
        int n = price.size();
        int p = 0;
        int code = 0;
        for (int i = 0; i < n; i++) {
            p += price.get(i)*needs.get(i);
            code ^= (needs.get(i)<<(i*4));
        }
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(code, p, 0));
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            ret = Math.min(ret, t.p);
            for (int i = t.sIndex; i < special.size(); i++) {
                List<Integer> offer = special.get(i);
                Tuple nextT = getTupleIfValid(t, offer, price, i);
                if (nextT != null) {
                    q.offer(nextT);
                }
            }
        }
        return ret;
    }

    private Tuple getTupleIfValid(Tuple t, List<Integer> offer, List<Integer> price, int sIndex) {
        int newCode = 0;
        int code = t.code;
        int p = t.p;
        for (int i = 0; i < price.size(); i++) {
            int count = (code>>>(i*4))&0XF;
            if (offer.get(i) > 0) {
                if (count >= offer.get(i)) {
                    count -= offer.get(i);
                    p -= price.get(i)*offer.get(i);
                } else {
                    return null;
                }
            }
            newCode ^= (count << (4*i));
        }
        p += offer.get(offer.size()-1);
        return new Tuple(newCode, p, sIndex);
    }
}
