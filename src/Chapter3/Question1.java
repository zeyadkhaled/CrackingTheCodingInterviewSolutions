package Chapter3;
/**
 * Create a 3 fixed size stacks from an Array
 */
public class Question1 {
	
	private class ThreeInOne {
		private final int numStacks = 3;
		private final int stackSize = 100;
		private int[] array = new int[stackSize * numStacks];
		private int[] heads = { -1, -1, -1 };
		
		public void push(int value, int stackNum) throws Exception {
			if (stackNum < 0 || stackNum >= numStacks) {
				throw new Exception("stackNum out of range");
			}
			if (heads[stackNum] >= stackSize) {
				throw new Exception("Out of space");
			}
			heads[stackNum]++;
			int offset = arrayOffset(stackNum) + heads[stackNum]; 
			array[offset] = value;
		}

		public int pop(int stackNum) throws Exception {
			if (heads[stackNum] == -1) {
				throw new Exception("No elements to pop");
			}
			int offset = arrayOffset(stackNum) + heads[stackNum];
			heads[stackNum]--;
			return array[offset];
		}

		public int peek(int stackNum) throws Exception {
			if (heads[stackNum] == -1) {
				throw new Exception("No elements to pop");
			}
			int offset = arrayOffset(stackNum) + heads[stackNum];
			return array[offset];
		}

		public boolean isEmpty(int stackNum) {
			return (heads[stackNum] == -1);
		}

		private int arrayOffset(int stackNum) {
			return stackSize * stackNum;
	}
	}
}
