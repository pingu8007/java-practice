package moe.pingu.iii.enumType;

enum county {
	Keelung, Taipei, NewTaipei, Taoyuan, Hsinchu, Miaoli, Taichung, Changhua, Yunlin, Chiayi, Tainan, Kaohsiung, Pingtung, Taitung, Hualien, Yilan, Nantou, Penghu, Kinmen;

	county() {
		System.out.println(this.toString());
	}
}

enum poker {
	Spare(3), Heart(2), Diamond, Club;
	poker() {
		System.out.println(this.toString());
	}

	poker(int num) {
		System.out.println();
	}
}

public class EnumTest {

	public static void main(String[] args) {
		for (county c : county.values()) {
			System.out.println(c.ordinal() + ":" + c);
		}
		for (poker c : poker.values()) {
			System.out.println(c.ordinal() + ":" + c);
		}
	}

}
