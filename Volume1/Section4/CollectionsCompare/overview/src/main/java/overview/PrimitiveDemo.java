package overview;

import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.primitive.IntInterval;

public class PrimitiveDemo {
	public static void main(String[] args) {
		// Mutable and immutable Lists, Sets, Bags, Stacks and Maps are available for all 8 primitive types
		MutableIntList intList = IntLists.mutable.of(1, 2, 3);
		MutableLongList longList = LongLists.mutable.of(1L, 2L, 3L);
		MutableCharList charList = CharLists.mutable.of('a', 'b', 'c');
		MutableShortList shortList = ShortLists.mutable.of((short) 1, (short) 2, (short) 3);
		MutableByteList byteList = ByteLists.mutable.of((byte) 1, (byte) 2, (byte) 3);
		MutableBooleanList booleanList = BooleanLists.mutable.of(true, false);
		MutableFloatList floatList = FloatLists.mutable.of(1.0f, 2.0f, 3.0f);
		MutableDoubleList doubleList = DoubleLists.mutable.of(1.0, 2.0, 3.0);

		// You can created a ranged ints with IntInterval
		IntInterval oneTo10 = IntInterval.fromTo(1, 10); // ints from 1 to 10
		// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		IntInterval oneTo10By3 = IntInterval.fromToBy(1, 10, 3); // ints from 1 to 10 step by 3
		// [1, 4, 7, 10]
		IntInterval oddsFrom1To10 = IntInterval.oddsFromTo(1, 10); // odd ints from 1 to 10
		// [1, 3, 5, 7, 9]
		IntInterval evensFrom1To10 = IntInterval.evensFromTo(1, 10); // even ints from i to 10
		// [2, 4, 6, 8, 10]
		
		System.out.println(oneTo10);
		System.out.println(oneTo10By3);
		System.out.println(oddsFrom1To10);
		System.out.println(evensFrom1To10);
	}
}
