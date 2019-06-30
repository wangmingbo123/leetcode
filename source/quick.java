package source;

public class quick {

    public static void main(String[] args) {
        int a[] = {3, 2, 6, 1, 7};


        int leftIndex = 0;
        int rightIndex = a.length - 1;
        int compare = a[leftIndex];

        while (leftIndex < rightIndex) {
            if (compare < a[leftIndex]) {
                // 交换 a[i]和a[rightIndex]的位置
                int temp = a[leftIndex];
                a[leftIndex] = a[rightIndex];
                a[rightIndex] = temp;
                rightIndex--;
                continue;
            } else {
                leftIndex++;

            }


        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            builder.append(",").append(String.valueOf(a[i]));
        }

        String str = builder.toString().substring(1);
        System.out.println(str);


    }
}
