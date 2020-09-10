package edu.traning.hackerrank.algorithms_datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArraysUtils {

	public static boolean containsPairsWithSum(int[] array, int sum) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int value : array) {
			map.merge(value,1,Integer::sum);
		}

		for (int value : array) {
			int dif = sum - value;
			if ((dif == value && map.get(value) > 1) || (dif != value && map.containsKey(value))){
				return true;
			}
		}
		return false;
	}

	public static boolean sortedArrayContainsPairsWithSum(int[] array, int sum) {
		int i = 0;
		int j = array.length - 1;
		while (i < j && (array[i] + array[j]) < sum) {
			i++;
		}
		while (j > i && (array[i] + array[j]) > sum) {
			j--;
		}

		return (array[i] + array[j]) == sum;
	}

	public static int[] rotateArray(int [] arr, int k) {
		if (k == arr.length || arr.length < 2) return arr;

		if (k > arr.length){
			k = k % arr.length;
		}

		int index = 0;
		int nextIndex = k;
		int temp = arr[index];
		int temp2 = arr[nextIndex];
		while (nextIndex != 0){
			arr[nextIndex] = temp;
			temp = temp2;
			nextIndex = (nextIndex + k) % arr.length;
			temp2 = arr[nextIndex];
		}
		arr[0] = temp;

		return arr;
	}

	public static int oddOccurrences(int [] arr){
		int num = 0;
		for (int i : arr){
			num = num ^ i;
		}
		return num;
	}

	public static int missingElement(int [] arr){
		int el = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++){
			el = el ^ arr[i];
			el = el ^ i;
		}
		el = el ^ n;
		el = el ^ n+1;
		return el;
	}

	public static int tapeEquilibrium(int [] arr){
		int min = Integer.MAX_VALUE;
		int sum =0;
		for (int value : arr) {
			sum += value;
		}
		int leftSum = 0;
		for (int i = 0; i < arr.length-1; i++) {
			leftSum += arr[i];
			int temp = 2 * leftSum - sum;
			if (temp < 0){
				temp = -temp;
			}
			if (temp < min){
				min = temp;
			}
		}
		return min;
	}

	public static int [] maxCounters(int n, int [] arr){
		int [] counters = new int[n];
		int max = 0;
		int fill = 0;
		for (int el : arr) {
			if (el == n + 1) {
				fill = max;
			} else {
				if (counters[el -1] < fill){
					counters[el-1] = fill;
				}
				counters[el-1]++;
				max = Math.max(max,counters[el-1]);
			}
		}

		for (int i = 0; i < counters.length; i++) {
			if (counters[i] < fill) {
				counters[i] = fill;
			}
		}
		return counters;
	}

	public static int missingInteger(int [] arr){
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		for (int i = 1;; i++) {
			if (!set.contains(i)){
				return i;
			}
		}
	}

	public static int permCheck(int [] arr){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum ^ arr[i];
			sum = sum ^ i+1;
		}

		return sum == 0 ? 0 : 1;
	}
}