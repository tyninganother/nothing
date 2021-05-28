package com.tyning.zuoshen;

public class Solution {


    /**
     * 从左往右的尝试模型1
     * <p>
     * https://github.com/algorithmzuo
     *
     * @param str 需要统计的char数组
     * @param i   i位置之前不包括i位置，char数组已经做过统计。那么统计一下i位置包括i位置以及往后的char的转化结果；就是说是从i这个位置上还是计算还有哪几种结果
     * @return
     */
    public static int process(char[] str, int i) {
        //将数组str放在数组（数组A）中,str是从数组A的0位置开始，将所有的元素放在A中，其中i代表数组A的下标；
        // 该算法的思路就是，遍历数组A，然后按照某一个路径将对应的str的元素都遍历完，那么这条路径就是一种结果。
        // 因为是一个元素一个元素按个遍历的所以可以使用一直往下遍历的方法直到遍历的i=str的长度的时候就能代表这条路径遍历完了。然后记录1，代表这一条路径。
        if (i == str.length) {
            return 1;
        }
        // i位置上的元素作为组合或者是自己进行转化的时候是否可以充当第首位，如果不能就放在
        if (str[i] == '0') {
            return 0;
        }
        // process(str, i + 1)说明的意思是，该条路径在i这个位置上是转化的时候是没有问题的，因为不需要记录路径的详情只记录最终遍历完的树的个数，所以就用i+1
        // 跳过i然后用process去找从i+1开始的字符串的路径
        // process(str, i + 2) 就说的是 i和i+1组合成一个两位的字符去转换是没有问题的，然后执行process(str, i + 2)去找i+2开始的字符串路径转换方式
        // 为什么之后i+1和i+2呢？就是因为，数组的元素是一位0到9而用0到9的字符转化A到Z的时候一位或者是两位，故而如此，联想如果转化是3位的话就需要再去找i+3开始的字符串的转化方式了
        if (str[i] == '1') {
            int res = process(str, i + 1);
            if (i + 1 < str.length) {
                res += process(str, i + 2);
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str, i + 1);
            if (i + 1 < str.length && (str[i + 1] > '0' && str[i + 1] <= '6')) {
                res += process(str, i + 2);
            }
            return res;
        }
        return process(str, i + 1);
    }


    /**
     * 从左往右的尝试模型2
     *
     * @param w        不变
     * @param v        不变
     * @param index
     * @param alreadyW 0..index-1上的货物的选择，现在已经有了多少的重量
     * @param bag      不变 是需要达到的总重量
     * @return
     */
    public static int process(int[] w, int[] v, int index, int alreadyW, int bag) {
        //如果已经装的总载重超过了想要的重量bag的话就用-1标记这个是没有方案的
        if (alreadyW > bag) {
            return -1;
        }
        //如果遍历到index这个位置上的话发现已经没有货物了的话就用0标记；代表的意思是装物品已经用完了物品，并且已经达到的总重量并没有超过想要的重量
        if (index == w.length) {
            return 0;
        }
        //如果不装index上的货物的话，看一下index+1之后的货物的价值
        int p1 = process(w, v, index + 1, alreadyW, bag);
        //如果装了index上的物品的话，看一下从index+1之后的货物的价值
        int p2next = process(w, v, index + 1, alreadyW + w[index], bag);
        int p2 = -1;
        if (p2next != -1) {
            //v[index] + p2next就是算index这个物品和下边的一些物品的价值一共是多少
            p2 = v[index] + p2next;
        }
        return Math.max(p1, p2);
    }

    /**
     * 从左往右的尝试模型2
     *
     * @param w     不变
     * @param v     不变
     * @param index
     * @param rest  在放了0到index-1的货物后，袋子中还有多少重量可以放置物品
     * @return
     */
    public static int process(int[] w, int[] v, int index, int rest) {
        // 就是在判断index这个位置的时候袋子没有可以放物品的重量了
        if (rest < 0) {
            return -1;
        }
        // 如果遍历到index这个位置上的话发现已经没有货物了的话就用0标记；代表的意思是装物品已经用完了，并且袋子中可以放置物品的重量还在
        if (index == w.length) {
            return 0;
        }
        //如果不装index上的货物的话，看一下index+1之后的货物的价值
        int p1 = process(w, v, index + 1, rest);
        //如果装了index上的物品的话，看一下从index+1之后的货物的价值
        int p2next = process(w, v, index + 1, rest - w[index]);
        int p2 = -1;
        if (p2next != -1) {
            //v[index] + p2next就是算index这个物品和下边的一些物品的价值一共是多少
            p2 = v[index] + p2next;
        }
        return Math.max(p1, p2);
    }


    public static int win1pd(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int f = f(arr, 0, arr.length - 1);
        int s = s(arr, 0, arr.length - 1);
        return Math.min(f, s);
    }

    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.min(
                f(arr, 0, arr.length - 1),
                s(arr, 0, arr.length - 1)
        );
    }

    /**
     * 先手函数
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int f(int[] arr, int L, int R) {
        // 因为这个方法包含两个过程去掉自己拿走元素，第二步对方拿元素。如果arr中的范围L到R相等那么就是说就剩下最后一个元素了，
        // 那么只能完成第一步骤，自己将分数拿走
        if (L == R) {
            return arr[L];
        }
        //先拿左侧的获取到的分数
        //如果我先拿左侧的话，那么就看我下次拿的时候分数s函数中做了两个步骤一个是模拟让对方先手那L+1到R的结果，然后我再拿
        int left = arr[L] + s(arr, L + 1, R);
        //先拿右侧的获取到的分数，那么就看我下次拿的时候分数s函数中做了两个步骤一个是模拟让对方先手那L到R-1的结果，然后我再拿
        int right = arr[R] + s(arr, L, R - 1);
        return Math.max(left, right);
    }

    /**
     * 后手函数
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int s(int[] arr, int L, int R) {
        // 因为这个方法包含两个过程去掉对方拿走的元素，第二步自己拿元素。如果arr中的范围L到R相等那么就是说就剩下最后一个元素了，那么只能完成第一步骤，那么这个一步的操作自己是得不到分数的
        if (L == R) {
            return 0;
        }
        // 如果左侧的元素被对方拿走了，那么接下来轮到自己的时候就要从L+1到R上去拿
        int left = f(arr, L + 1, R);
        // 如果右侧的元素被对方拿走了，那么接下来轮到自己的时候就要从L到R-1上去拿
        int right = f(arr, L, R - 1);
        return Math.min(left, right);
    }

    public static void main(String[] args) {
//        int[] arr = {100,40,70,9,5};
        int[] arr = {5, 9, 70, 40, 100};
        System.out.println(f(arr, 0, 4));
        System.out.println(s(arr, 0, 4));

    }

    /**
     * @param i      目前这个方法要操作的行数
     * @param record 标示之前的行，放了的皇后位置的记录
     * @param n      n代表一共有多少行
     * @return 傍晚所有的皇后，合理的摆法有多少种
     */
    public static int process(int i, int[] record, int n) {
        //如果如果i==n证明这条路径已经走完就记录一个1说明走完了这条有效的路径
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
                //这里不用恢复record的值和i和j的值
            }
        }
        return res;
    }

    /**
     * 如果该方法的返回值是true证明i行是可以摆皇后的，如果是false就证明i行不能摆皇后了
     *
     * @param record record[0..i-1]需要看，record【i...】不需要看
     * @param i      返回i行皇后，放在了j列，是否有效
     * @param j
     * @return
     */
    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public static int num(int n) {
        //因为这个地方使用的是int类型的二进制来表示棋盘int的最高位数是32位所以不能超过32。
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process(limit, 0, 0, 0);
    }

    /**
     * @param limit       棋盘的初始化值，主要是用来去除int的32最左边用不到的位数的干扰
     * @param colLim      列的限制
     * @param leftDiaLim  左边界的限制 1的位置不能放皇后，0的位置可以
     * @param rightDiaLim 右边界的限制，1的位置不能放皇后，0的位置可以
     * @return
     */
    public static int process(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        // 将列、左、右的限制合在一起，然后做计算将pos表示成二进制上1位置能放皇后0不能放的int标示的数字
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        // 最右边的一个可以放皇后的位置
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            //mostRightOne = pos & (~pos + 1);这个语句是取一个数字二进制表示的时候的最右边为1的int数字，这个公式就是n & (~n + 1)。
            mostRightOne = pos & (~pos + 1);
            // 计算下边行的位置 colLim|mostRightOne是叠加列限制；(leftDiaLim|mostRightOne)<<1叠加的左限制；叠加的右限制；
            res += process(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
            pos = pos - mostRightOne;
        }
        return res;
    }


}
