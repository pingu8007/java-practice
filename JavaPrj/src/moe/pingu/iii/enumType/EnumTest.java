package moe.pingu.iii.enumType;

enum county {
	Keelung, Taipei, NewTaipei, Taoyuan, Hsinchu, Miaoli, Taichung, Changhua, Yunlin, Chiayi, Tainan, Kaohsiung, Pingtung, Taitung, Hualien, Yilan, Nantou, Penghu, Kinmen
}

public class EnumTest {

	public static void main(String[] args) {
		for (county c : county.values()) {
			System.out.println(c.ordinal() + ":" + c);
		}
	}

}
