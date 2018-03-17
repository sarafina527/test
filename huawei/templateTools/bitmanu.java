public class bitmunu {

	public static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}
	
	public static int setBit(int num, int i) {
		return num | (1 << i);
	}
	
	public static int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}
	//更新i位
	public static int updateBit(int num, int i, int value) {
		int mask = ~(1 << i);
		return (num & mask) | (value << i);
	}
	//取i为以后的部分
	public static int clearBitsMSBthroughI(int num, int i) {
		int mask = (1 << i) - 1;
		return num & mask;
	}
	//清除取i位以前的
	public static int clearBitsIthrough0(int num, int i) {
		int mask = ~(-1 >>> (31 - i));
		return (num & mask);
	}
}