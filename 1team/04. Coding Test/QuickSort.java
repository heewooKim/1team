// Quick Sort
// 가장 빠른 정렬 알고리즘 중 하나

// - pivot : 그룹을 나누는 기준
// - pl : 왼쪽 끝 요소의 인덱스
// - pr : 오른쪽 끝 요소의 인덱스

// pivot 이하의 요소를 배열 왼쪽, 이상의 요소를 배열 오른쪽으로 옮겨야 한다.
// a[pl] >= pivot이 성립하는 요소를 찾을 때까지 pl을 오른쪽으로 스캔한다.
// a[pr] <= pivot이 성립하는 요소를 찾을 때까지 pr을 왼쪽으로 스캔한다.
// 위 조건을 모두 만족하는 위치의 요소(a[pl], a[pr])를 교환한다.

// pr이 왼쪽 끝 요소보다 오른쪽에 위치하면 왼쪽 그룹으로 나누어 퀵 정렬 진행한다.
// pl이 오른쪽 끝 요소보다 왼쪽에 위치하면 오른쪽 그룹으로 나누어 퀵 정렬 진행한다.

public class QuickSort {

    static void swap(int[] x, int idx1, int idx2) {

        int temp = x[idx1];
        x[idx1] = x[idx2];
        x[idx2] = temp;

    }

    static void quickSort_process(int[] x) {

        int pl = 0;
        int pr = x.length - 1;
        int pivot = x[x.length / 2];

        do {
            while (x[pl] < pivot) {
                pl++;
            }
            while (x[pr] > pivot) {
                pr--;
            }
            if (pl <= pr) {
                swap(x, pl++, pr--);
            }
        } while (pl <= pr);

        System.out.println("피벗의 값은 " + pivot + "입니다.");

        System.out.println("피벗 이하의 그룹");

        for (int i = 0; i <= pl - 1; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();

        System.out.println("피벗과 일치하는 그룹");

        System.out.println(pivot);

        System.out.println("피벗 이상의 그룹");

        for (int i = pr + 1; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();

    }

    static void quickSort(int[] x, int left, int right) {

        int pl = left;
        int pr = right;
        int pivot = x[(pl + pr) / 2];

        do {
            while (x[pl] < pivot) {
                pl++;
            }
            while (x[pr] > pivot) {
                pr--;
            }
            if (pl <= pr) {
                swap(x, pl++, pr--);
            }
        } while (pl <= pr);

        System.out.println("-------------------------------------");
        System.out.println("피벗의 값은 " + pivot + "입니다.");

        System.out.println("피벗 이하의 그룹");

        for (int i = 0; i <= pl - 1; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();

        System.out.println("피벗과 일치하는 그룹");

        System.out.println(pivot);

        System.out.println("피벗 이상의 그룹");

        for (int i = pr + 1; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
        System.out.println("-------------------------------------");

        if (left < pr) {
            quickSort(x, left, pr);
        }
        if (right > pl) {
            quickSort(x, pl, right);
        }

    }

    public static void main(String[] args) {

        System.out.println("배열을 나눕니다.");

        int[] x = new int[]{1, 8, 7, 4, 5, 2, 6, 3, 9};

        quickSort(x, 0, x.length - 1);

        System.out.println("퀵 정렬 적용된 배열");

        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }

    }

}