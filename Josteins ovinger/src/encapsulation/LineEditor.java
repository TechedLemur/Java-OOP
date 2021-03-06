package encapsulation;

// er ikke innkapslet ferdig

public class LineEditor {
	
	private String text = "";
	private int insertionIndex;
	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getInsertionIndex() {
		return insertionIndex;
	}

	public void setInsertionIndex(int insertionIndex) {
		this.insertionIndex = insertionIndex;
	}

	public void left() {
		if (insertionIndex == 0) {
			return;
		}
		else {
			insertionIndex --;
		}
	}
	
	public void right() {
		if (insertionIndex == text.length()) {
			return;
		}
		else {
			insertionIndex ++;
		}
	}
	public void insertString(String S) {
		String f = text.substring(0, insertionIndex);
		String e = text.substring(insertionIndex);
		this.text = f + S + e;
		insertionIndex = (f + S).length();
	}
	
	public void deleteLeft() {
		if (insertionIndex == 0) {
			return;
		}
		else {
			this.text = text.substring(0, insertionIndex-1) + text.substring(insertionIndex);
		}
		insertionIndex --;
	}
	
	public void deleteRight() {
		if (insertionIndex == text.length()) {
			return;
		}
		else {
			this.text = text.substring(0, insertionIndex) + text.substring(insertionIndex+1);
		}
		
	}
	@Override
	public String toString() {
		return text.substring(0, insertionIndex) + "|" + text.substring(insertionIndex);
	}
	
	public void insert(Object o) {
		String n = o.toString();
		this.insertString(n);
	}
	
	public void left(int n) {
		for (int i = 0; i < n; i++) {
			this.left();
		}
	}
	public void right(int n) {
		for (int i = 0; i < n; i++) {
			this.right();
		}
	}	
	
	
	
	public static void main(String[] args) {
		LineEditor l1 = new LineEditor();
		System.out.println(l1);
		l1.insertString("Hei");
		System.out.println(l1);
		l1.right();
		System.out.println(l1);
		l1.left();
		System.out.println(l1);
		l1.insertString("Test");
		System.out.println(l1);
		l1.deleteRight();
		System.out.println(l1);
		l1.deleteLeft();
		System.out.println(l1);
		l1.setInsertionIndex(2);
		System.out.println(l1);
		l1.insertString("Hoe");
		System.out.println(l1);
		l1.left(3);
		System.out.println(l1);
		l1.right(8);
		System.out.println(l1);
		}
}
