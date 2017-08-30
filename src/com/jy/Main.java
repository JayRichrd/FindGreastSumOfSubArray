package com.jy;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[] { 1, -2, 3, 10, -4, 7, 2, -5 };
		int[] indexs = new int[2];
		System.out.println("输入的数组:" + Arrays.toString(array));
		System.out.println("数组的连续子数组中和最大为:" + findGreatestSumOfSubArray(array, indexs));
		System.out.print("和最大的连续子数组为:");
		for (int i = indexs[0]; i <= indexs[1]; i++)
			System.out.print(array[i] + " ");

	}

	/**
	 * 计算给定数组和最大的连续子数组之和
	 * 
	 * @param array
	 *            给定的数组
	 * @param indexs
	 *            子数组的开始和结束位置
	 * @return 返回连续子数组的最大和
	 */
	public static int findGreatestSumOfSubArray(int[] array, int[] indexs) {
		// 数组的长度
		int arrayLength = array.length;
		if (array == null || arrayLength <= 0)
			throw new RuntimeException("Invalid Input!!!");
		// 连续子数组的开始位置
		indexs[0] = 0;
		// 当前子数组的和
		int currentSum = 0;
		// 记录的子数组的和的最大值
		int greatestSum = Integer.MIN_VALUE;
		// 循环寻找和最大的连续子数组
		for (int i = 0; i < arrayLength; i++) {
			// 因为currentSum初始值为0，所以这里一定需要加上等于0的条件
			// 否则如果一个数组全是负数，且第一个元素的最大的负数时，则无法找到和最小的连续子数组
			if (currentSum <= 0) {
				// 当前子数组之和小于等于0时，就抛弃之前的子数组，从当前位置重新开始
				currentSum = array[i];
				// 并记录下子数组开始的位置
				indexs[0] = i;
			} else // 否则就累加上当前的数组元素
				currentSum += array[i];
			if (currentSum > greatestSum) {
				// greatestSum始终保存最大的和
				greatestSum = currentSum;
				// 并记录下子数组结束的位置
				indexs[1] = i;
			}
		}
		return greatestSum;
	}

}
