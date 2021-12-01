package week12;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here

        List<List<Integer>> all = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            all.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < cities.size(); ++i) {
            int n1, n2;
            n1 = cities.get(i).get(0);
            n2 = cities.get(i).get(1);
            all.get(n1).add(n2);
            all.get(n2).add(n1);
        }
        boolean[] costs = new boolean[n + 1];
        int nLib = 0;
        int nRoad = 0;
        for (int i = 0; i < n + 1; i++) {
            costs[i] = false;
        }
        for (int i = 1; i < all.size(); i++) {
            if (costs[i] == false) {
                nLib++;
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                costs[i] = true;
                while (!q.isEmpty()) {
                    int v = q.remove();
                    for (int w : all.get(v)) {
                        if (costs[w] == false) {
                            q.add(w);
                            costs[w] = true;
                            nRoad++;
                        }
                    }
                }
            }
        }
        return Math.max(n * c_lib, (long) c_lib * nLib + (long) c_road * nRoad);
    }

}

public class RoadsAndLibraries {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            int c_lib = Integer.parseInt(firstMultipleInput[2]);

            int c_road = Integer.parseInt(firstMultipleInput[3]);

            List<List<Integer>> cities = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String[] citiesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> citiesRowItems = new ArrayList<>();

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowTempItems[j]);
                    citiesRowItems.add(citiesItem);
                }

                cities.add(citiesRowItems);
            }

            long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

