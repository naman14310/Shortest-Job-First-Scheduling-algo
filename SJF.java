package sjf;

import java.util.Scanner;

public class SJF {

	static void bubbleSort(int AT[], int BT[]) {
		int n = AT.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (AT[j] > AT[j + 1]) {
					int temp = AT[j];
					AT[j] = AT[j + 1];
					AT[j + 1] = temp;

					temp = BT[j];
					BT[j] = BT[j + 1];
					BT[j + 1] = temp;

				}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("enter no of process : ");
		n = sc.nextInt();
		int AT[] = new int[n];
		int BT[] = new int[n];
		int CT[] = new int[n];

		System.out.print("enter AT : ");
		for (int i = 0; i < n; i++) {
			AT[i] = sc.nextInt();
		}

		System.out.print("enter BT : ");
		for (int i = 0; i < n; i++) {
			BT[i] = sc.nextInt();
		}

		bubbleSort(AT, BT);

		for (int i = 1; i < n; i++) {
			if (AT[i] == 0 && BT[i - 1] > BT[i]) {
				int temp = AT[i];
				AT[i] = AT[i - 1];
				AT[i - 1] = temp;

				temp = BT[i];
				BT[i] = BT[i - 1];
				BT[i - 1] = temp;
			}
		}

		CT[0] = AT[0] + BT[0];

		for (int i = 1; i < n - 1; i++) {
			int j = i + 1;
			int count = i;
			int min = BT[i];
			int gap = AT[i] - CT[i - 1];

			if (gap <= 0) {
				while (AT[j] <= CT[i - 1]) {
					if (BT[j] < min) {
						min = BT[j];
						count = j;
					}
					j++;
					if (j == n)
						break;
				}
				if (i != count) {
					int temp = AT[i];
					AT[i] = AT[count];
					AT[count] = temp;

					temp = BT[i];
					BT[i] = BT[count];
					BT[count] = temp;
				}

				CT[i] = CT[i - 1] + BT[i];

			}

			else {
				while (AT[j] == AT[i] && j < n) {
					if (BT[j] < min) {
						min = BT[j];
						count = j;
					}
					j++;
					if (j == n)
						break;
				}

				if (i != count) {
					int temp = AT[i];
					AT[i] = AT[count];
					AT[count] = temp;

					temp = BT[i];
					BT[i] = BT[count];
					BT[count] = temp;
				}

				CT[i] = CT[i - 1] + BT[i] + gap;
			}

		}

		int gap = AT[n - 1] - CT[n - 2];
		if (gap > 0) {
			CT[n - 1] = CT[n - 2] + BT[n - 1] + gap;
		} else {
			CT[n - 1] = CT[n - 2] + BT[n - 1];
		}

		System.out.print("CT : ");
		for (int i = 0; i < n; i++) {
			System.out.print(CT[i]);
			System.out.print(" ");
		}

	}

}
