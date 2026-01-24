import java.util.Arrays;

public class SlidingWindow {
    public static int[] maxSliding(int[] in, int w) {
        int n = in.length;

        int[] max_left = new int[n];
        int[] max_right = new int[n];

        max_left[0] = in[0];
        max_right[n - 1] = in[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % w == 0)
                max_left[i] = in[i];
            else
                max_left[i] = Math.max(max_left[i - 1], in[i]);

            int j = n - i - 1;
            if ((j + 1) % w == 0)
                max_right[j] = in[j];
            else
                max_right[j] = Math.max(max_right[j + 1], in[j]);
        }

        int[] result = new int[n - w + 1];
        for (int i = 0; i + w <= n; i++) {
            result[i] = Math.max(max_right[i], max_left[i + w - 1]);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int w = 3;

        int[] ans = maxSliding(arr, w);
        System.out.println(Arrays.toString(ans));
    }
}