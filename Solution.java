import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static ArrayList<Integer> input = new ArrayList<Integer>();

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int numberOfIntegers = reader.nextInt();

		for (int i = 0; i < numberOfIntegers; i++) {
			int inputInteger = reader.nextInt();
			System.out.println(putIntegersInNondecreasingOrder_getMedian(inputInteger, i));
		}
		reader.close();
	}

	public static double putIntegersInNondecreasingOrder_getMedian(int inputInteger, int currentIndex) {
		double median = 0;
		if (input.size() == 0) {
			input.add(inputInteger);
			median = inputInteger;
			return median;
		} else if (inputInteger <= input.get(0)) {
			input.add(0, inputInteger);
			median = calculateMedian();
			return median;
		} else if (inputInteger >= input.get(input.size() - 1)) {
			input.add(input.size(), inputInteger);
			median = calculateMedian();
			return median;
		}

		int lowerIndex = 0;
		int upperIndex = input.size() - 1;

		while (true) {
			int provisionalMedian_Subset = input.get(lowerIndex + (upperIndex - lowerIndex + 1) / 2);
			if (upperIndex - lowerIndex == 1) {
				input.add(lowerIndex + 1, inputInteger);
				break;
			} else if (inputInteger == provisionalMedian_Subset) {
				input.add(lowerIndex + (upperIndex - lowerIndex + 1) / 2, inputInteger);
				break;
			} else if (inputInteger > provisionalMedian_Subset) {
				lowerIndex = lowerIndex + (upperIndex - lowerIndex + 1) / 2;
			} else if (inputInteger < provisionalMedian_Subset) {
				upperIndex = lowerIndex + (upperIndex - lowerIndex + 1) / 2;
			}

		}
		median = calculateMedian();
		return median;
	}

	public static double calculateMedian() {
		double value = 0;
		if (input.size() % 2 == 0) {
			int median_firstIndex = (input.size() - 1) / 2;
			int median_secondIndex = (input.size()) / 2;
			value = (((double) input.get(median_firstIndex) + (double) input.get(median_secondIndex)) / 2);
		} else {
			int medianIndex = (input.size() - 1) / 2;
			value = (double) input.get(medianIndex);
		}
		return value;
	}
}
