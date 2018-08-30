/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/24
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len; i++){
            if(flowerbed[i] == 0){
                if((i == 0 || flowerbed[i-1] == 0) && (i == len - 1 || flowerbed[i+1] == 0)){
                    flowerbed[i] = 1;
                    n--;
                    i++;
                }
            }else {
                i++;
            }
        }
        return n <= 0;
    }
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(n == 0)return true;
        if(flowerbed.length == 1)return flowerbed[0] == 0;
        if(flowerbed.length >= 2){
            if(flowerbed[0] == 0 && flowerbed[1] == 0){
                flowerbed[0] = 1;
                n--;
            }
            if(flowerbed[len-1] == 0 && flowerbed[len-2] == 0){
                flowerbed[len-1] = 1;
                n--;
            }
        }
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if(flowerbed[i] == 0){
                if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
                if(n == 0)break;
            }
        }
        return n <= 0;
    }
}
