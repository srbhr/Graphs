import java.util.ArrayList;

public class Sunset {

    public void findSunset(int[] arr) {
        int n = arr.length;
        int maxValue = arr[0];
        int countBuildings = 1;

        ArrayList sunriseBuildings = new ArrayList<Integer>();

        ArrayList sunsetBuildings = new ArrayList<Integer>();
        sunsetBuildings.add(arr[0]);

        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
                sunsetBuildings.add(arr[i]);
                countBuildings++;
            }
        }

        maxValue = arr[n - 1];
        sunriseBuildings.add(arr[n - 1]);

        for (int i = arr.length - 1; i > 0; i--) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
                sunriseBuildings.add(arr[i]);
            }
        }

        System.out.println(countBuildings);
        System.out.println(sunsetBuildings);
        System.out.println(sunriseBuildings);

    }

    public static void main(String[] args) {
        var test = new Sunset();
        int[] arr = { 1, 7, 4, 8, 2, 9 };
        test.findSunset(arr);

        // System.out.println(Arrays.toString(output));
    }

}
