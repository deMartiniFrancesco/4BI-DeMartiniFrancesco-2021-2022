package demartini_F_ArrayShifter.bin;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

class ArrayShifter {

	private ArrayList<Integer> list;

    public ArrayShifter() {
		list = new ArrayList<>();
    }

	public void initList(int len) {
		list = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			list.add(i);
		}
	}

	public void schiftList(int shift) {
		Collections.rotate(list, shift);
	}

	public ArrayList<Integer> getList() {
		return list;
	}

	@Override
	public String toString() {
		return list.toString();
	}
}

class ArrayShifterTest {
    public static void main(String[] args) {

        System.out.println("Start");

        //		CALCOLO PATH RELATIVO UNIVERSALE
        //----------------------------------------------------------------------
        String tempPath = new File(
                String.valueOf(ArrayShifter.class.getPackage()).replace("package ", "").replace(".", "/")
        ).getParent();
        File uesrPath = new File(System.getProperty("user.dir"));
        String projectPath = uesrPath.getName().equals(tempPath) ?
                uesrPath.getPath() :
                new File(uesrPath.getPath() + "/src").exists() ?
                        uesrPath.getPath() + "/src/" + tempPath :
                        uesrPath.getPath() + tempPath;
        //----------------------------------------------------------------------

        // COSTANTI
        String resursesPath = "/file/";

        int shift, len = 0;
        ArrayShifter list = new ArrayShifter();

        try {
            len = Integer.parseInt(JOptionPane.showInputDialog("Inserire lunghezza vett: "));
            list.initList(len);
            System.out.println(list);
            shift = Integer.parseInt(JOptionPane.showInputDialog("Inserire numero schift: "));
        } catch (Exception e) {
            shift = 0;
            if (!(len > 0)) {
                list.initList(5);
                System.out.println(list);
            } else {
                list.initList(len);
                System.out.println(list);
            }
        }

        while (shift != 0) {
            list.schiftList(shift);
            System.out.println(list);
            try {
                shift = Integer.parseInt(JOptionPane.showInputDialog("Inserire numero schift: "));
            } catch (Exception e) {
                shift = 0;
            }
            list.initList(len);

        }

        System.out.println("End");

    }
}