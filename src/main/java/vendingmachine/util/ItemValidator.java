package vendingmachine.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ItemValidator {
	private static final String ERROR = "[ERROR] ";
	private static final String BLANK = "";
	private static final String NO_ITEMS_ERROR = "상품이 입력되지 않았습니다.";
	private static final String ITEM_DIVIDER = ";";
	private static final String REGEX = "\\[[a-zA-Z0-9가-힣]+,\\d{3,},\\d+]";
	private static final String NOT_VALID_FORMAT = "입력 형식이 잘못되었습니다.";
	private static final String INFO_DIVIDER = ",";
	private static final String NOT_VALID_PRICE = "상품 가격은 10원 단위로 나누어져야 합니다.";
	private static final String NOT_VALID_QUANTITY = "상품 수량은 1개 이상이어야 합니다.";

	private static final int TEN_WON = 10;
	private static final int ZERO_WON = 0;
	private static final int EMPTY = 0;
	private static final int ITEM_PACKAGE = 1;
	private static final int PRICE = 1;
	private static final int QUANTITY = 2;

	public static List<String> isValidItems(String input) {
		List<String> items = isNotBlank(input);
		isNotEmpty(items);
		return items;
	}

	private static List<String> isNotBlank(String input) {
		if (input.equals(BLANK)) {
			throw new IllegalArgumentException(ERROR + NO_ITEMS_ERROR);
		}
		return Arrays.asList(input.split(ITEM_DIVIDER));
	}

	private static void isNotEmpty(List<String> items) {
		if (items.size() == EMPTY) {
			throw new IllegalArgumentException(ERROR + NO_ITEMS_ERROR);
		}
	}

	public static List<String> isValidItem(String input) {
		List<String> item = isInFormat(input);
		isValidPrice(item);
		isEnough(item);
		return item;
	}

	private static List<String> isInFormat(String input) {
		if (!Pattern.matches(REGEX, input)) {
			throw new IllegalArgumentException(ERROR + NOT_VALID_FORMAT);
		}
		return Arrays.asList(input.substring(ITEM_PACKAGE, input.length() - ITEM_PACKAGE).split(INFO_DIVIDER));
	}

	private static void isValidPrice(List<String> item) {
		if (Integer.parseInt(item.get(PRICE)) % TEN_WON != ZERO_WON) {
			throw new IllegalArgumentException(ERROR + NOT_VALID_PRICE);
		}
	}

	private static void isEnough(List<String> item) {
		if (Integer.parseInt(item.get(QUANTITY)) <= EMPTY) {
			throw new IllegalArgumentException(ERROR + NOT_VALID_QUANTITY);
		}
	}
}