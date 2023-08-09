package com.market.cart;
import com.market.bookitem.Book;

public class Cart implements CartInterface {

	static final int NUM_BOOK = 3;
	public CartItem[] mCartItem = new CartItem[NUM_BOOK];
	public static int mCartCount = 0;

	public Cart() {

	}

	public void printBookList(Book[] booklist) {
		for (int i = 0; i < booklist.length; i++) {
			System.out.print(booklist[i].getBookId() + " | ");
			System.out.print(booklist[i].getName() + " | ");
			System.out.print(booklist[i].getUnitPrice() + " | ");
			System.out.print(booklist[i].getAuthor() + " | ");
			System.out.print(booklist[i].getDescription() + " | ");
			System.out.print(booklist[i].getCategory() + " | ");
			System.out.print(booklist[i].getReleaseDate());
			System.out.println("");
		}
	}

	public void insertBook(Book book) {
		mCartItem[mCartCount++] = new CartItem(book);

	}

	public void deleteBook() {
		mCartItem = new CartItem[NUM_BOOK]; //���� �����ϰ� �Ǹ� ��ü�迭 ���� null�� ��
		mCartCount = 0;
	}

	public void printCart() {
		System.out.println("��ٱ��� ��ǰ ��� :");
		System.out.println("---------------------------------------------");
		System.out.println("    ����ID \t|     ���� \t|      �հ�");

		for (int i = 0; i < mCartCount; i++) {
			System.out.print("    " + mCartItem[i].getBookID() + " \t| ");
			System.out.print("    " + mCartItem[i].getQuantity() + " \t| ");
			System.out.print("    " + mCartItem[i].getTotalPrice());
			System.out.println("  ");
		}
		System.out.println("---------------------------------------------");
	}

	public boolean isCartInBook(String bookId) {
		boolean flag = false;
		for (int i = 0; i < mCartCount; i++) {
			if (bookId == mCartItem[i].getBookID()) {
				mCartItem[i].setQuantity(mCartItem[i].getQuantity() + 1);
				flag = true;
			}
		}
		return flag;
	}

	public void removeCart(int numId) { //������ �׸� ���� ������ ���� �迭 �̵�
		CartItem[] cartItem = new CartItem[NUM_BOOK];
		int num = 0;

		for (int i = 0; i < mCartCount; i++)
			if (numId != i)
				cartItem[num++] = mCartItem[i];

		mCartCount = num;
		mCartItem = cartItem;
	}
}