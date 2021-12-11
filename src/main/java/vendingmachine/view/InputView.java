package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String SET_COINS_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String SET_ITEMS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";

	public static String setCoins() {
		System.out.println(SET_COINS_MESSAGE);
		return Console.readLine();
	}

	public static String setItems() {
		System.out.println();
		System.out.println(SET_ITEMS_MESSAGE);
		return Console.readLine();
	}
}
