import java.util.*;
import javax.swing.JOptionPane;

class prova_1 {
	public static ArrayList<Integer> initList(int len) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			list.add(i);
		}
		return list;
	}

	public static ArrayList<Integer> schiftList(ArrayList<Integer> list, int shift) {
		Collections.rotate(list, shift);
		return list;
	}

	public static void main(String[] args) {
		System.out.println("Start");
		int shift, len = 0;
		ArrayList<Integer> list;

		try {
			len = Integer.parseInt(JOptionPane.showInputDialog("Inserire lunghezza vett: "));
			list = initList(len);
			System.out.println(list);
			shift = Integer.parseInt(JOptionPane.showInputDialog("Inserire numero schift: "));
		} catch (Exception e) {
			shift = 0;
			if (!(len > 0)) {
				list = initList(5);
				System.out.println(list);
			} else {
				list = initList(len);
				System.out.println(list);
			}
		}

		while (shift != 0) {
			list = schiftList(list, shift);
			System.out.println(list);
			try {
				shift = Integer.parseInt(JOptionPane.showInputDialog("Inserire numero schift: "));
			} catch (Exception e) {
				shift = 0;
			}
			list = initList(len);

		}

		System.out.println("End");

	}
}
