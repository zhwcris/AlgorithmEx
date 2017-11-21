import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws SocketTimeoutException {
        int[][] test = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] test2 = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        ArrayList<Integer> list = new ArrayList<>();
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        ImageSmoother imageSmoother = new ImageSmoother();
        MaxAreaIsland maxAreaIsland = new MaxAreaIsland();
        int result = maxAreaIsland.maxAreaOfIsland(test);
        //int tmp = maxAreaIsland.dfsSearch(0,0,test2);
        System.out.println("Completed..........");
    }

}
